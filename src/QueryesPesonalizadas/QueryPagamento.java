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
import modelos.Pagamento;

/**
 *
 * @author pedro
 */
public class QueryPagamento {
     Factory factory = new Factory();
    EntityManager em = factory.retornaEntidadegerenciada();
      public List<Pagamento> retornaPagamentoPorTipo(String nome){
        
        Query  query = em.createNativeQuery("SELECT * FROM pagamento where tipo_pagamento  LIKE '"+nome+"%' ;",Pagamento.class);
        query.setParameter(1, nome);
        
        
        return query.getResultList();
    }
}
