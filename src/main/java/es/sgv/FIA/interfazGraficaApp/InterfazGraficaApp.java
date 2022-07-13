package es.sgv.FIA.interfazGraficaApp;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//https://www.incanatoit.com/2015/06/libreria-swing-interfaces-gui-jframe.html#:~:text=Swing%20es%20una%20biblioteca%20de,usuario%20(GUI)%20para%20Java.&text=Viene%20inclu%C3%ADda%20con%20el%20entorno%20de%20desarrollo%20de%20Java%20(JDK).&text=Extiende%20a%20otra%20librer%C3%ADa%20gr%C3%A1fica%20m%C3%A1s%20antigua%20llamada%20AWT.

public class InterfazGraficaApp {

	public static void main(String[] args) {
		
		// Creando el Marco        
        JFrame frame = new JFrame("FormulaSpring");       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        frame.setSize(400, 400);        

        // Creando MenuBar y agregando componentes   
        JMenuBar mb = new JMenuBar();       
        JMenu m1 = new JMenu("ARCHIVO");       
        JMenu m2 = new JMenu("Ayuda");       
        mb.add(m1);       
        mb.add(m2);       
        JMenuItem m11 = new JMenuItem("Abrir");       
        JMenuItem m22 = new JMenuItem("Guardar como");       
        m1.add(m11);       
        m1.add(m22);        

        // Creando el panel en la parte inferior y agregando componentes       
        JPanel panel = new JPanel(); // el panel no está visible en la salida      
        JLabel label = new JLabel("Introducir texto");       
        JTextField tf = new JTextField(10); // acepta hasta 10 caracteres        
        JButton send = new JButton("Enviar");       
        JButton reset = new JButton("Restablecer");       
        panel.add(label); // Componentes agregados usando Flow Layout     
        panel.add(tf); // Componentes agregados usando Flow Layout      
        panel.add(tf);       
        panel.add(send);       
        panel.add(reset);        

        // Área de texto en el centro    
        JTextArea ta = new JTextArea();        

        // Agregar componentes al marco.      
        frame.getContentPane().add(BorderLayout.SOUTH, panel);       
        frame.getContentPane().add(BorderLayout.NORTH, mb);       
        frame.getContentPane().add(BorderLayout.CENTER, ta);       
        frame.setVisible(true);
	}

}
