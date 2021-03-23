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
import modelos.Fornecedor;
import modelos.Produto;

/**
 *
 * @author pedro
 */
public class QueryesProduto {
      Factory factory = new Factory();
    EntityManager em = factory.retornaEntidadegerenciada();
    
    public List<Produto> retornaProdutoPorNome(String nome){
        
        Query  query = em.createNativeQuery("SELECT * FROM produto where descricaoProduto LIKE '"+nome+"%' ;",Produto.class);
        query.setParameter(1, nome);
        
        
        return query.getResultList();
    }
    
     public List<Produto> retornaTodos(){
        
        Query  query = em.createNativeQuery("SELECT * FROM produto ",Produto.class);
       
        
        
        return query.getResultList();
    }
    
}
