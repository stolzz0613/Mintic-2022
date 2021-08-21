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
import Modelo.vo.Requerimiento_1;

public class Requerimiento_1Dao {

    //metodo
    //Obtener los 10 proyectos rankeados según las compras
    public ArrayList<Requerimiento_1> requerimiento1()  throws SQLException {
        // Su código
        ArrayList<Requerimiento_1> respuesta = new ArrayList<Requerimiento_1>();//Crear objeto colecion
        Connection conexion = JDBCUtilities.getConnection();//conexion con la base de datos

        try{
            String consulta =   "select ID_Proyecto, Ciudad, Banco_Vinculado, Constructora, Clasificacion " + 
                                "from Proyecto " + 
                                "where (Clasificacion = 'Condominio' AND fecha_Inicio >='2020-01-01'); ";

            PreparedStatement statement = conexion.prepareStatement(consulta); 
            ResultSet resultSet = statement.executeQuery(); //Encargado de ejecutar la consulta y genera la tabla

            while (resultSet.next()){ //next permita que se verifiquen los datos de la tabla uno a uno
                Requerimiento_1 requerimiento_1 = new Requerimiento_1();
                requerimiento_1.setID_Proyecto(resultSet.getInt("ID_Proyecto"));
                requerimiento_1.setCiudad(resultSet.getString("Ciudad"));
                requerimiento_1.setBanco_Vinculado(resultSet.getString("Banco_Vinculado"));
                requerimiento_1.setConstructora(resultSet.getString("Constructora"));
                requerimiento_1.setClasificacion(resultSet.getString("Clasificacion"));

                respuesta.add(requerimiento_1); //cada una de las iteraciones se guardan en respuesta
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