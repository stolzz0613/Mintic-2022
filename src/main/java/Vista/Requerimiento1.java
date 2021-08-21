package Vista;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;

import Controlador.ElControladorDeRequerimientos;
import Modelo.vo.Requerimiento_1;

public class Requerimiento1 extends JFrame {
    JTable tabla = new JTable();
    public Requerimiento1() throws SQLException {
        this.tabla = initUI();
    }
    //Metodo
    public JTable initUI() throws SQLException{
        String[]nombres= {"ID_Proyecto", "Ciudad", "Banco_Vinculado", "Constructora", "Clasificacion"};
        JTable tabla = new JTable(mostrar(), nombres ); //objeto tabla

        //Color de fondo de las celdas
        tabla.setBackground(new Color(241, 174, 254));
        // Opciones de fuente de los celdas
        tabla.setFont(new Font("Serif", Font.ITALIC, 14));

        // Color de fondo de los titulos
        tabla.getTableHeader().setBackground(new Color(126, 16, 147));
        //Opciones de fuente de los titulos
        tabla.getTableHeader().setFont(new Font("Serif", Font.BOLD, 18));
        tabla.getTableHeader().setForeground(Color.WHITE);
        return tabla;
    }

    public String[][] mostrar() throws SQLException{ //crea una matriz

        ArrayList<Requerimiento_1> lista = new ArrayList<Requerimiento_1>(); //generar objeto crea array que contiene la info del controlado
        ElControladorDeRequerimientos controlador = new ElControladorDeRequerimientos(); //crea objeto

        lista= controlador.consultarRequerimiento1();
        String matriz [][]= new String [lista.size()][5]; //primer corchete a fila y seguno a columna
        for (int i=0; i< lista.size(); i++){
            matriz[i][0]=String.valueOf(lista.get(i).getID_Proyecto());//se esta convirtiendo a proyecto que es int a string
            matriz[i][1]=lista.get(i).getCiudad();//lista tiene todos los objetos por lo tanto con get solicito el dato que necesito
            matriz[i][2]=lista.get(i).getBanco_Vinculado();
            matriz[i][3]=lista.get(i).getConstructora();
            matriz[i][4]=lista.get(i).getClasificacion();
        }
        return matriz;
    }
    
}
