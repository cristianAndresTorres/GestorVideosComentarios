package com.example.demo.models.BD;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
	//Atributos
    protected Connection miConexion; 
    protected boolean estado;
    protected Connection conexionBD = null;
    private String bd = "BDaulaVirtual";
    private String url = "jdbc:mysql://localhost:3306/";
    private String usuario = "root";
    private String contrasegna = "criss";
    //Unico ejemplar de la clase
    private static ConexionBD miconexionBD = new ConexionBD(); 
	
    //Constructor
    private ConexionBD() {
    }
    
    //Realiza conexion a la BD de mysql
    public Connection realizarConexionBD() {
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexionBD = DriverManager.getConnection(url+bd, usuario, contrasegna);
                System.out.println("ConexionExitosa");
        } catch (Exception e) {
                System.out.println("ConexionOracle - ERROR");
        }

        return conexionBD;
    }

    //Patron de disegno singleton, ejemplificacion temprana
	public static ConexionBD getMiconexionBD() {
		return miconexionBD;
	} 

}
