package Modelo.dao;
//Estructura de datos
import java.util.ArrayList;
//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//Clase para conexión
import Util.JDBCUtilities;
import Modelo.vo.Requerimiento_2;

public class Requerimiento_2Dao {
    //Obtener los 10 proyectos rankeados según las compras
    public ArrayList<Requerimiento_2> requerimiento2()  throws SQLException {
        // Su código
        ArrayList<Requerimiento_2> respuesta = new ArrayList<Requerimiento_2>();//Crear objeto colecion
        Connection conexion = JDBCUtilities.getConnection();//conexion con la base de datos

        try{
            String consulta =   "SELECT Nombre, Primer_Apellido, Ciudad_Residencia, Cargo, Salario from Lider WHERE Cargo IN('Asesor', 'Coordinador') AND Salario <= 510000;" ;
            
            PreparedStatement statement = conexion.prepareStatement(consulta); 
            ResultSet resultSet = statement.executeQuery(); //Encargado de ejecutar la consulta y genera la tabla

            while (resultSet.next()){ //next permita que se verifiquen los datos de la tabla uno a uno
                Requerimiento_2 requerimiento_2 = new Requerimiento_2();
                requerimiento_2.setNombre(resultSet.getString("Nombre"));
                requerimiento_2.setPrimer_Apellido(resultSet.getString("Primer_Apellido"));
                requerimiento_2.setCiudad_Residencia(resultSet.getString("Ciudad_Residencia"));
                requerimiento_2.setCargo(resultSet.getString("Cargo"));
                requerimiento_2.setSalario(resultSet.getInt("Salario"));

                respuesta.add(requerimiento_2); //cada una de las iteraciones se guardan en respuesta
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            System.err.println("Error consultado: " + e);
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }
        return respuesta;
    }

}
