/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockTimeoutException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;
import org.eclipse.persistence.exceptions.CommunicationException;
import org.eclipse.persistence.exceptions.DatabaseException;
import org.eclipse.persistence.internal.jpa.ExceptionFactory;

/**
 *
 * @author Pedro Henrique Gomes
 */
public class Factory {

   

    public EntityManager retornaEntidadegerenciada() {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("jpaPU");
            em = emf.createEntityManager();
            return em;
        } catch (PersistenceException e) {
            
           JOptionPane.showMessageDialog(null,"Nao Conectado Ao MYSQL");
           return null;
        }
        catch(CommunicationException e){
               em.close();
             JOptionPane.showMessageDialog(null,"Nao Foi Possivel Conecctar ao Bd");
        }
         return null;
    }

}
