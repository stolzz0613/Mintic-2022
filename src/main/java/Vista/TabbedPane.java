package Vista;

import java.sql.SQLException;

import javax.swing.*;

public class TabbedPane extends JFrame {

    public TabbedPane() throws SQLException {
        Requerimiento1 tabla1 = new Requerimiento1();
        Requerimiento2 tabla2 = new Requerimiento2();
        Requerimiento3 tabla3 = new Requerimiento3();

        // Parametros asociados a la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
        setTitle("Reto 5 MinTIC 2021");

        // Creamos el conjunto de pestañas
        JTabbedPane pestañas = new JTabbedPane();

        // Creamos el panel y lo añadimos a las pestañas
        JScrollPane panel1 = new JScrollPane(tabla1.tabla);
        // Añadimos un nombre de la pestaña y el panel
        pestañas.addTab("Requerimiento 1", panel1);

        // Creamos el panel y lo añadimos a las pestañas
        JScrollPane panel2 = new JScrollPane(tabla2.tabla);
        // Añadimos un nombre de la pestaña y el panel
        pestañas.addTab("Requerimiento 2", panel2);

        // Creamos el panel y lo añadimos a las pestañas
        JScrollPane panel3 = new JScrollPane(tabla3.tabla);
        // Añadimos un nombre de la pestaña y el panel
        pestañas.addTab("Requerimiento 3", panel3);

        getContentPane().add(pestañas);
    }
}
