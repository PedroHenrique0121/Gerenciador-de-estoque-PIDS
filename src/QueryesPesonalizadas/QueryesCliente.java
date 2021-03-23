/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueryesPesonalizadas;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelos.Factory;
import modelos.Cliente;

/**
 *
 * @author Alan Soares de Abreu
 */
public class QueryesCliente {
    
     
     Factory factory = new Factory();
    EntityManager em = factory.retornaEntidadegerenciada();
    
    public List<Cliente> retornaClientePorNome(String nome){
        
        Query  query = em.createNativeQuery("SELECT * FROM cliente where NOME_CLIENTE  LIKE '"+nome+"%' ;",Cliente.class);
        query.setParameter(1, nome);
        
        
        return query.getResultList();
    }
}
