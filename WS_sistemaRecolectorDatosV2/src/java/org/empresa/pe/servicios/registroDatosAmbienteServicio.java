/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.empresa.pe.servicios;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.empresa.MisRecursos.llamaCallable;
import org.empresa.pe.modelo.registroAmbiente;
import static org.empresa.pe.dao.connecion_bd.*;
import org.empresa.pe.modelo.medicion;
import org.empresa.pe.modelo.registroLuminariasInAmbiente;
import org.empresa.pe.modelo.registroSensorInAmbiente;
/**
 *
 * @author FCV
 */
public class registroDatosAmbienteServicio {
    List<String> lstparams = new ArrayList();
    
    public String RegistraDatosAmbiente(registroAmbiente rda){
        String rpta ="";
        int idRegistro = 0;
        if(!estadoConectado()){
            conectar();
        }
        try{
            List<IntegerConPosicion> integers = new ArrayList<>();
            integers.add( new IntegerConPosicion(rda.getIdAmbiente(),2));
            integers.add(new IntegerConPosicion(rda.getIdUus(),4));
            integers.add(new IntegerConPosicion(rda.getIdLuxometro(),5));
            List<StringConPosicion> Strings = new ArrayList<>();
            Strings.add( new StringConPosicion(rda.getFecha(),1) );
            
            List<DoubleConPosicion> doubles = new ArrayList<>();
            doubles.add( new DoubleConPosicion(rda.getAlturaMedicion(),3) );
            
            ResultSet rs = llamaCallable("registDatosAmbiente",5,integers,Strings,null,doubles);
            while(rs.next()){
                  idRegistro = Integer.parseInt(rs.getString(1));
            }
            List<medicion> lstaMediciones = rda.getLstaMediciones();
            double promedioAmbiente = 0;
            int iMediciones =0 ;
            for( iMediciones = 0 ; iMediciones< lstaMediciones.size() ; iMediciones++){
                medicion med = lstaMediciones.get(iMediciones);
                List<IntegerConPosicion> integersMedicion = new ArrayList<>();
                integersMedicion.add(new IntegerConPosicion(idRegistro,1));
                integersMedicion.add(new IntegerConPosicion(med.getNroMedicionl(),2));
                List<DoubleConPosicion> doublesMedicion = new ArrayList<>();
                
                doublesMedicion.add(new DoubleConPosicion(med.getResultado(),3));
                promedioAmbiente += med.getResultado();
                List<StringConPosicion> StringsMedicion = new ArrayList<>();
                StringsMedicion.add(new StringConPosicion(med.getDescripcion(),4) );
                llamaCallableSinRetorno("registoMediciones",4,integersMedicion,StringsMedicion,null,doublesMedicion);
            }
            String estado =    compruebaEstadoAmbiente (promedioAmbiente,iMediciones);
                CallableStatement cst = cadenaConexion.prepareCall("{call ActualizaEstadoRegistro(?,?)}");
                cst.setInt(1, idRegistro);
                cst.setString(2, estado);
                cst.execute();
            List<registroLuminariasInAmbiente> lstaLumInAmbiete = rda.getLstregluminariasInAmbiente();
            for(int i  = 0 ; i<lstaLumInAmbiete.size();i++ ){
                registroLuminariasInAmbiente lumReg = lstaLumInAmbiete.get(i);
                List<IntegerConPosicion> integersLuminarias = new ArrayList<>();
                integersLuminarias.add(new IntegerConPosicion(idRegistro,1));
                integersLuminarias.add(new IntegerConPosicion(lumReg.getIdLum(),2));
                integersLuminarias.add(new IntegerConPosicion(lumReg.getCantidad(),4));
                List<BooleanConPisicion> booleansLuminarias = new ArrayList<>();
                booleansLuminarias.add( new BooleanConPisicion(lumReg.isEstado(),3));
                llamaCallableSinRetorno("registroLuminariasInAmbiente",4,integersLuminarias,null,booleansLuminarias,null);
            }
            List<registroSensorInAmbiente> lstSensore = rda.getLstregistroSensorInAmbiente();
            for(int  i = 0 ; i<lstSensore.size();i++ ){
                registroSensorInAmbiente sensor = lstSensore.get(i);
                List<IntegerConPosicion> integerSensores = new ArrayList<>();
                integerSensores.add(new IntegerConPosicion(idRegistro,1));
                integerSensores.add(new IntegerConPosicion(sensor.getIdSensor(),2));
                integerSensores.add(new IntegerConPosicion(sensor.getCantidad(),4));
                List<BooleanConPisicion> booleanSensores = new ArrayList<>();
                booleanSensores.add(new BooleanConPisicion(sensor.isEstado(),3));
                llamaCallableSinRetorno("registroSensorInRegAmbiente",4,integerSensores,null,booleanSensores,null);
            }
            return " ID : "+idRegistro;
        }catch( SQLException e ){
            System.out.println(e.getMessage());
            return  rpta = e.getMessage();
        }
    }
    
    public registroAmbiente BuscaAnbiente(int idRegistro) {
        registroAmbiente rgA = new registroAmbiente();
        llamaCallable callable = new llamaCallable();
        List<org.empresa.MisRecursos.IntegerConPosicion> lstInt = new ArrayList<>();
        lstInt.add( new org.empresa.MisRecursos.IntegerConPosicion(idRegistro,1));
        try{     
            ResultSet rs = callable.llamaCallableConRespuesta(
                    "buscaRregistroAmbiente", 1, lstInt, null, null, null
            );            
            if(rs.next()){
                rgA.setIdRegistro(rs.getInt(1));
                rgA.setFecha(rs.getString(2));
                rgA.setIdAmbiente(rs.getInt(3));
                rgA.setIdUus(rs.getInt(4));
                rgA.setEstado(rs.getBoolean(6));
                rgA.setAlturaMedicion(rs.getDouble(7));
                rgA.setIdLuxometro(rs.getInt(8));
                
                List<medicion>lstaMediciones = new ArrayList<>();
                List<org.empresa.MisRecursos.IntegerConPosicion> lstIntMed = new ArrayList<>();
                
                lstIntMed.add(new org.empresa.MisRecursos.IntegerConPosicion(rgA.getIdRegistro(),1));
                ResultSet rsMediciones = callable.llamaCallableConRespuesta(
                        "buscaMedicionesPorRegistro", 1, lstIntMed, null, null, null
                );
                while(rsMediciones.next()){
                    medicion med = new medicion();
                    med.setIdMedicion(rsMediciones.getInt(1));
                    med.setIdRegistro(rsMediciones.getInt(2));
                    med.setNroMedicionl(rsMediciones.getInt(3));
                    med.setResultado(rsMediciones.getDouble(4));
                    med.setDescripcion(rsMediciones.getString(5));
                    lstaMediciones.add(med);
                    }
                rgA.setLstaMediciones(lstaMediciones);
                
                
                List<registroLuminariasInAmbiente> lstLuminarriasInAnbiente = new  ArrayList<>();
                List<org.empresa.MisRecursos.IntegerConPosicion> lstIntLum = new ArrayList<>();
                
                lstIntLum.add(new org.empresa.MisRecursos.IntegerConPosicion(rgA.getIdRegistro(),1));
                
                ResultSet rsLum = callable.llamaCallableConRespuesta(
                        "buscaLuminrasPorRegistro", 1, lstIntLum, null, null, null
                );
                
                while(rsLum.next()){
                    registroLuminariasInAmbiente rgLuminAnbiente = new registroLuminariasInAmbiente();
                    rgLuminAnbiente.setIdRegistroLum(rsLum.getInt(1));
                    rgLuminAnbiente.setIdregistroAnbien(rsLum.getInt(2));
                    rgLuminAnbiente.setIdLum(rsLum.getInt(3));
                    rgLuminAnbiente.setEstado(rsLum.getBoolean(4));
                    rgLuminAnbiente.setCantidad(rsLum.getInt(5));
                    lstLuminarriasInAnbiente.add(rgLuminAnbiente);
                }
                rgA.setLstregluminariasInAmbiente(lstLuminarriasInAnbiente);
                
                List<registroSensorInAmbiente> lstSensoresInAmbiente = new  ArrayList<>();
                List<org.empresa.MisRecursos.IntegerConPosicion> lstIntSensor = new ArrayList<>();
                
                lstIntSensor.add(new org.empresa.MisRecursos.IntegerConPosicion(rgA.getIdRegistro(),1));
                
                ResultSet rsSensores = callable.llamaCallableConRespuesta(
                        "buscaSensorPorRegistro", 1, lstIntSensor, null, null, null
                );
                
                while(rsSensores.next()){
                    registroSensorInAmbiente rgsan = new registroSensorInAmbiente();
                    rgsan.setIdRegSensorInAmbiente(rsSensores.getInt(1));
                    rgsan.setIdRegistro(rsSensores.getInt(2));
                    rgsan.setIdSensor(rsSensores.getInt(3));
                    rgsan.setEstado(rsSensores.getBoolean(4));
                    rgsan.setCantidad(rsSensores.getInt(5));
                    lstSensoresInAmbiente.add(rgsan);
                }
                rgA.setLstregistroSensorInAmbiente(lstSensoresInAmbiente);
            }else{
                rgA = null;
            }
        }catch( SQLException e){
        }
        return rgA;
    }
    public String ActualizaDatosAmbiente(registroAmbiente registroActulizar){
        try{
            List<IntegerConPosicion> lstInts = new ArrayList<>();
            lstInts.add(new IntegerConPosicion(registroActulizar.getIdRegistro(),1));
            llamaCallableSinRetorno("EliminaRegistroAnbiente",1,lstInts,null,null,null);
        }catch(Exception E){
        }
        
        String rpta =  RegistraDatosAmbiente(registroActulizar);
        
        return rpta;
    }
    private String compruebaEstadoAmbiente( double promedio  ,int nromediciones){
        promedio = promedio / nromediciones;
        if(promedio  < 500){
               return "D"; 
        }else{
            return "A";
        }
    }
    private ResultSet llamaCallable(String procedure,int cantidadParametros, List<IntegerConPosicion> lstInt, List<StringConPosicion> lstString,List<BooleanConPisicion> lstboolean,List<DoubleConPosicion> lstDouble) throws SQLException{
        String cadenaProcedure = "";
        if(cantidadParametros > 0){   
            String paramSimbolo ="";
            for(int  i = 0 ; i< cantidadParametros ; i++){
                if(i == 0){
                    paramSimbolo +="?";
                }else{
                    paramSimbolo +=",?";
                }
            }
            cadenaProcedure = "{call "+procedure+"("+paramSimbolo+")}";
        }
        else{
            cadenaProcedure = "{call "+procedure+"}";
        }
        CallableStatement  cst = cadenaConexion.prepareCall(cadenaProcedure);
        if(lstInt != null){
            for(int i =0 ; i<lstInt.size();i++ ){
                cst.setInt(lstInt.get(i).getPosision(),lstInt.get(i).getValor());   
            }
        }
        if(lstString != null){
            for(int i =0 ; i<lstString.size();i++ ){
                cst.setString(lstString.get(i).getPosicion(),lstString.get(i).getValor());   
            }
        }
        if(lstboolean != null){
            for(int i =0 ; i<lstboolean.size();i++ ){
                cst.setBoolean(lstboolean.get(i).getPosicion(),lstboolean.get(i).isValor());   
            }
        }
        
        if(lstDouble != null){
            for(int i =0 ; i<lstDouble.size();i++ ){
                cst.setDouble(lstDouble.get(i).getPosicion(),lstDouble.get(i).getValor());   
            }
        }
        ResultSet rs = cst.executeQuery();
        return rs;
    }
    private void llamaCallableSinRetorno(String procedure,int cantidadParametros, List<IntegerConPosicion> lstInt, List<StringConPosicion> lstString,List<BooleanConPisicion> lstboolean,List<DoubleConPosicion> lstDouble) throws SQLException{
        String cadenaProcedure = "";
        if(cantidadParametros > 0){   
            String paramSimbolo ="";
            for(int  i = 0 ; i< cantidadParametros ; i++){
                if(i == 0){
                    paramSimbolo +="?";
                }else{
                    paramSimbolo +=",?";
                }
            }
            cadenaProcedure = "{call "+procedure+"("+paramSimbolo+")}";
        }
        else{
            cadenaProcedure = "{call "+procedure+"}";
        }
        CallableStatement  cst = cadenaConexion.prepareCall(cadenaProcedure);
        if(lstInt != null){
            for(int i =0 ; i<lstInt.size();i++ ){
                cst.setInt(lstInt.get(i).getPosision(),lstInt.get(i).getValor());   
            }
        }
        if(lstString != null){
            for(int i =0 ; i<lstString.size();i++ ){
                cst.setString(lstString.get(i).getPosicion(),lstString.get(i).getValor());   
            }
        }
        if(lstboolean != null){
            for(int i =0 ; i<lstboolean.size();i++ ){
                cst.setBoolean(lstboolean.get(i).getPosicion(),lstboolean.get(i).isValor());   
            }
        }
        
        if(lstDouble != null){
            for(int i =0 ; i<lstDouble.size();i++ ){
                cst.setDouble(lstDouble.get(i).getPosicion(),lstDouble.get(i).getValor());   
            }
        }
         cst.execute();
        
    }
    
    
    private class IntegerConPosicion{
        private int valor;
        private int posision;

        public IntegerConPosicion(int valor, int posision) {
            this.valor = valor;
            this.posision = posision;
        }

            
        public int getValor() {
            return valor;
        }

        public void setValor(int valor) {
            this.valor = valor;
        }

        public int getPosision() {
            return posision;
        }

        public void setPosision(int posision) {
            this.posision = posision;
        }
        
    }
    private class StringConPosicion{
        private String valor;
        private int posicion;

        public StringConPosicion(String valor, int posicion) {
            this.valor = valor;
            this.posicion = posicion;
        }

        public String getValor() {
            return valor;
        }

        public void setValor(String valor) {
            this.valor = valor;
        }

        public int getPosicion() {
            return posicion;
        }

        public void setPosicion(int posicion) {
            this.posicion = posicion;
        }
    }
    private class BooleanConPisicion{
        private boolean valor;
        private int posicion;

        public BooleanConPisicion(boolean valor, int posicion) {
            this.valor = valor;
            this.posicion = posicion;
        }

        public boolean isValor() {
            return valor;
        }

        public void setValor(boolean valor) {
            this.valor = valor;
        }

        public int getPosicion() {
            return posicion;
        }

        public void setPosicion(int posicion) {
            this.posicion = posicion;
        }
    }
    private class DoubleConPosicion{
        private double valor;
        private int posicion;

        public DoubleConPosicion(double valor, int posicion) {
            this.valor = valor;
            this.posicion = posicion;
        }

        public double getValor() {
            return valor;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }

        public int getPosicion() {
            return posicion;
        }

        public void setPosicion(int posicion) {
            this.posicion = posicion;
        }
        
    
    }
}
