package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class form1 {
    public JButton buscar;
    public JTextField consultaTXT;
    public JLabel resultadoTxt;
    public JPanel panel1;
    private JLabel b2TXT;
    private JLabel b1TXT;
    private JLabel cedula;
    private JLabel nombre;
    private JButton buscarNombreButton;

    public form1() {
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/estudiantes2024";
                String usuario = "root";
                String password = "123456";


                try (Connection connection = DriverManager.getConnection(url, usuario, password)) {
                    System.out.println("Conectado a la base de datos");
                    /*String query = "select * from estudiantes where cedula = '"+consultaTXT.getText()+"'";*/
                    String query = "select *, round(b1+b2/2) as PromedioNotas from Estudiantes where cedula = '" + consultaTXT.getText() + "'";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);

                    while (resultSet.next()) {
                        System.out.print(resultSet.getString("cedula"));
                        /*String resultado = resultSet.getString("nombre")+resultSet.getString("cedula")+resultSet.getString("b1")+resultSet.getString("b2")+resultSet.getString("PromedioNotas");*/
                        nombre.setText(resultSet.getString("nombre"));
                        cedula.setText(resultSet.getString("cedula"));
                        b1TXT.setText(resultSet.getString("b1"));
                        b2TXT.setText(resultSet.getString("b2"));
                        resultadoTxt.setText(resultSet.getString("PromedioNotas"));

                    }
                } catch (SQLException e1) {
                    System.out.println(e1.getMessage());
                }

            }
        });

        buscarNombreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/estudiantes2024";
                String usuario = "root";
                String password = "123456";


                try (Connection connection = DriverManager.getConnection(url, usuario, password)) {
                    System.out.println("Conectado a la base de datos");
                    /*String query = "select * from estudiantes where cedula = '"+consultaTXT.getText()+"'";*/
                    String query = "select *, round(b1+b2/2) as PromedioNotas from Estudiantes where nombre = '" + consultaTXT.getText() + "'";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);

                    while (resultSet.next()) {
                        System.out.print(resultSet.getString("cedula"));
                        /*String resultado = resultSet.getString("nombre")+resultSet.getString("cedula")+resultSet.getString("b1")+resultSet.getString("b2")+resultSet.getString("PromedioNotas");*/
                        nombre.setText(resultSet.getString("nombre"));
                        cedula.setText(resultSet.getString("cedula"));
                        b1TXT.setText(resultSet.getString("b1"));
                        b2TXT.setText(resultSet.getString("b2"));
                        resultadoTxt.setText(resultSet.getString("PromedioNotas"));

                    }
                } catch (SQLException e1) {
                    System.out.println(e1.getMessage());
                }

            }
        });
    }
}

