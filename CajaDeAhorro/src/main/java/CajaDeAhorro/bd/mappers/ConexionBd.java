/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CajaDeAhorro.bd.mappers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonatan Eduardo
 */
public class ConexionBd {

    //Atributos
    String database = "caja_ahorro";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String password = "";
    Connection enlace;
    String driver = "com.mysql.cj.jdbc.Driver";

    //Constructor
    public ConexionBd() {

    }
    
    //Metodos
    public  Connection Conectar() {
        try {
            Class.forName(driver);
            enlace = DriverManager.getConnection(url + database, user, password);
            System.out.println("Se conecto a la base de datos: " + database);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No se pudo conectar a la base de datos");
            Logger.getLogger(ConexionBd.class.getName()).log(Level.SEVERE, null, ex);
            enlace=null;
        }
        return enlace;
        
    }

    public void Desconectar() {
        try {
            enlace.close();
            System.out.println("Se desconecto de la base de datos: " + database);
        } catch (SQLException ex) {
            System.out.println("No se pudo desconectar de la base de datos: " + database);
            Logger.getLogger(ConexionBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Codigo que prueba la coneccion a la base de datos
    
  /*public static void main(String[] args) {
        ConexionBd nuevoEnlace = new ConexionBd();
        nuevoEnlace.Conectar();
    }
   */
}
