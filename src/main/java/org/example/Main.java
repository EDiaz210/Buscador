package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame fr = new JFrame("Aplicación");
        fr.setContentPane(new form1().panel1);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(700, 700);
        fr.setVisible(true);
    }
}