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
import modelos.Usuario;

/**
 *
 * @author pedro
 */
public class QueryesUsuario {

    Factory factory = new Factory();
    EntityManager em = factory.retornaEntidadegerenciada();
    
    public List<Usuario> retornaUsuariosPorNome(String nome){
        
        Query  query = em.createNativeQuery("SELECT * FROM usuario where nome  LIKE '"+nome+"%' ;",Usuario.class);
        query.setParameter(1, nome);
        
        
        return query.getResultList();
    }
}
