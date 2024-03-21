package medicionesdb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DataAccess {
    private Connection  conexion;

    static final int TABLA_PERSONA = 1;
    static final int TABLA_MEDIDAS = 2;

    public DataAccess() {
        conexion = ConexionBD.getConexion("jdbc:derby://localhost:1527/MedicionesDataBase", "root", "root");
        System.out.println("Intento de conexion a la BD");
    }

    public boolean insertData(String sql) { //actualiza datos
        boolean res = false;
        try {
            java.sql.Statement st = conexion.createStatement();
            st.executeUpdate(sql);
            res = true;
            System.out.println("se inserto");
            conexion.commit();
        } catch (Exception e) {
            System.err.println("Error al insertar/Actualizar" + e.getMessage());
        }
        return res;
    }
    public List <Object[]> conexionConsultaDatos(String sql, int tabla) {
        //regresa los requisitos de las personas en una lista
        List <Object[]> datos = new ArrayList<Object[]>();
        try {
            // Statement es una clase generica
            Statement ps = conexion.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while(rs.next()) {
                //Consultar los datos segun la tabla
                datos.add(getData(tabla, rs));

            }
        } catch (Exception e) {
            System.err.println("Error al conectar/consultar a los datos " + e.getMessage());
        }
        return datos;
        
    }

    public String[] getData(int tabla, ResultSet rs) {
        String[] dat = {};
        try {
            if(tabla == 1) { // Tabla Persona
                dat = new String[5];

                dat[0] = String.valueOf((Integer)rs.getInt(1)); // Int ID
                dat[1] = rs.getString(2); // String nombre
                dat[2] = rs.getDate(3).toString(); // Fecha de nacimiento
                dat[3] = rs.getString(4); // Char sexo
                dat[4] = String.valueOf((Integer)rs.getInt(5)); // int estatura [cm]
                
            } else if(tabla == 2) { // Tabla Medidas
                dat = new String[6];

                dat[0] = String.valueOf((Integer)rs.getInt(1)); // Int ID
                dat[1] = rs.getDate(2).toString(); // Fecha de medicion
                dat[2] = String.valueOf((Double)rs.getDouble(3)); // peso [kg]
                dat[3] = String.valueOf((Integer)rs.getInt(4)); // cintura [cm]
                dat[4] = String.valueOf((Double)rs.getDouble(5)); // grasa [kg]
                dat[5] = String.valueOf((Integer)rs.getInt(6)); // Int ID FK Persona

            }
            
        } catch (Exception e) {
            System.err.println("Error al conectar/consultar a los datos " + e.getMessage());
        }
        return dat;
    }

    public static void main(String[] args){
        DataAccess d=new DataAccess();
    }
}
