/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Henrique Gomes
 */
public class Conexao {

    Connection con;

    public void conectar(String Banco, String usuario, String senha) {

    }

     public  static Connection  conecta() throws SQLException, ClassNotFoundException{
         
         try{
              String url= "jdbc:mysql://localhost:3306/projeto?user=root&password=";
       
            Connection conecta = DriverManager.getConnection(url);
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("conexao realizada com suceso!");
        return conecta;
         }
         catch(SQLException e){
             JOptionPane.showMessageDialog(null,"Nao foi possivel Conectar ao Mysql");
               return null;
         }
     
       
    }

}
