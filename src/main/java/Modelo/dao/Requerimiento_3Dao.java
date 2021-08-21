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

import Modelo.vo.Requerimiento_3;

public class Requerimiento_3Dao {
    //Obtener los 10 proyectos rankeados según las compras
    public ArrayList<Requerimiento_3> requerimiento3()  throws SQLException {
        ArrayList<Requerimiento_3> respuesta = new ArrayList<Requerimiento_3>();
        Connection conexion = JDBCUtilities.getConnection();//conexion con la base de datos

        try{
            String consulta =   "SELECT Compra.Proveedor, Compra.Pagado,Proyecto.Constructora " +
                                "From Compra INNER JOIN Proyecto ON Compra.ID_Proyecto = Proyecto.ID_Proyecto " +
                                "WHERE Pagado ='No' AND Proveedor = 'JUMBO'; ";
            
            PreparedStatement statement = conexion.prepareStatement(consulta); 
            ResultSet resultSet = statement.executeQuery(); //Encargado de ejecutar la consulta y genera la tabla

            while (resultSet.next()){ //next permita que se verifiquen los datos de la tabla uno a uno
                Requerimiento_3 requerimiento_3 = new Requerimiento_3();
                requerimiento_3.setProveedor(resultSet.getString("Proveedor"));
                requerimiento_3.setPagado(resultSet.getString("Pagado"));
                requerimiento_3.setConstructora(resultSet.getString("Constructora"));

                respuesta.add(requerimiento_3); //cada una de las iteraciones se guardan en respuesta
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
