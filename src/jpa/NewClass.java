/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelos.Conexao;

/**
 *
 * @author Pedro Henrique Gomes
 */
public class NewClass {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        EntityManagerFactory emf= Persistence.createEntityManagerFactory("pidsPU");
//     EntityManager em = emf.createEntityManager();
        Conexao.conecta();
        

    }
}
