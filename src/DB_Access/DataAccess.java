package DB_Access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


public class DataAccess {
    private Connection  conexion;

    public static final int TABLA_PERSONA = 1;
    public static final int TABLA_MEDIDAS = 2;

    public DataAccess() {
        conexion = ConexionBD.getConexion("jdbc:derby://localhost:1527/MedicionesDataBase", "root", "root");
        System.out.println("Intento de conexion a la BD [Class: "+getClass().getName()+"]");
    }

    public boolean updateData(String sql) { //actualiza datos
        boolean res = false;
        try {
            java.sql.Statement st = conexion.createStatement();
            st.executeUpdate(sql);
            res = true;
            System.out.println("se actualizo [Class: "+getClass().getName()+"]");
            conexion.commit();
        } catch (Exception e) {
            System.err.println("Error al insertar/Actualizar" + e.getMessage());
        }
        return res;
    }
    public int insertData(String sql) {
        int generatedKey = -1;
        try {
            PreparedStatement st = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            conexion.commit();
            System.out.println("Se insertó con el ID: " + generatedKey + " [Class: "+getClass().getName()+"]");
        } catch (Exception e) {
            System.err.println("Error al insertar/Actualizar " + e.getMessage());
            return -1; 
        }
        return generatedKey;
    }


    public int addPersona(String NOMBRE, Date FECHANAC, char SEXO, int ESTATURA) {
        String insertData = "INSERT INTO ROOT.PERSONA (NOMBRE, FECHANAC, SEXO, ESTATURA) VALUES";
        SimpleDateFormat ff = new SimpleDateFormat("YYYY-MM-dd");
        String fechaString = ff.format(FECHANAC);

        insertData += "('" 
            + NOMBRE + "', '" 
            + fechaString + "', '"
            + SEXO + "', "
            + ESTATURA
            + ")";
        System.out.println(insertData);
        return insertData(insertData);
    }

    public void updatePersona(String[] encabezados, int id, int column, Object value) {
        String newValue = (String)value;
        if(column == 1 || column == 2 || column == 3) {
            newValue = "'"+value+"'";
        }
        String update = "UPDATE ROOT.PERSONA SET " 
            + encabezados[column] 
            + " = " 
            + newValue 
            + " WHERE IDPERSONA = " 
            + id ;

        System.out.println(update);
        updateData(update);
    }
    public boolean deletePersona(int id) {
        boolean deleted = false;
        try (Statement st = conexion.createStatement()) {
            String sql = "DELETE FROM ROOT.PERSONA WHERE IDPERSONA = " + id;
            System.out.println(sql);
            int rowsAffected = st.executeUpdate(sql);
            if (rowsAffected > 0) {
                deleted = true;
                System.out.println("Registro eliminado correctamente.");
                conexion.commit();
            } else {
                System.out.println("No se encontró ningún registro con el ID proporcionado.");
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar el registro: " + e.getMessage());
        }
        return deleted;
    }

    public int addMedida(Date FECHA, double PESO, int CINTURA, double GRASACORPORAL, int IDPERSONA) {
        String insertData = "INSERT INTO ROOT.MEDIDAS (FECHA, PESO, CINTURA, GRASACORPORAL, IDPERSONA) VALUES";
        SimpleDateFormat ff = new SimpleDateFormat("YYYY-MM-dd");
        String fechaString = ff.format(FECHA);

        insertData += "('" 
            + fechaString + "', " 
            + PESO + ", "
            + CINTURA + ", "
            + GRASACORPORAL +", "
            + IDPERSONA
            + ")";
        System.out.println(insertData);
        return insertData(insertData);
    }
    public void updateMedida(String[] encabezados, int id, int column, Object value) {
        String newValue = (String)value;
        if(column == 1) {
            newValue = "'"+value+"'";
        }
        String update = "UPDATE ROOT.MEDIDAS SET " 
            + encabezados[column] 
            + " = " 
            + newValue 
            + " WHERE IDMEDIDAS = " 
            + id ;

        System.out.println(update);
        updateData(update);
    }

    public boolean deleteMedida(int id) {
        boolean deleted = false;
        try (Statement st = conexion.createStatement()) {
            String sql = "DELETE FROM ROOT.MEDIDAS WHERE IDMEDIDAS = " + id;
            System.out.println(sql);
            int rowsAffected = st.executeUpdate(sql);
            if (rowsAffected > 0) {
                deleted = true;
                System.out.println("Registro eliminado correctamente.");
                conexion.commit();
            } else {
                System.out.println("No se encontró ningún registro con el ID proporcionado.");
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar el registro: " + e.getMessage());
        }
        return deleted;
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
