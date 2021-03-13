/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueryesPesonalizadas;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modellosUteis.PedidoCompletoo;
import modelos.Factory;
import modelos.Pedido;

/**
 *
 * @author pedro
 */
public class QueryPedido {

    Factory fac = new Factory();
    EntityManager em = fac.retornaEntidadegerenciada();
    
    public List<PedidoCompletoo> retornaPedido(int idCliente, String data) {
        
        Query q = em.createNativeQuery("select pe.id_pedido, pe.VALOR_TOTAL_PEDIDO, pe.data, c.nome_cliente,c.cpf_cliente, u.nome from pedido pe "
                + "inner JOIN cliente c on pe.cliente_id = c.id_cliente "
                + "inner join usuario u on pe.usuario_id = u.id "
                + "where c.id_cliente = "+idCliente+ " and  pe.data = '" +data+"' ", PedidoCompletoo.class);
        return  q.getResultList();
    }
    /* select p.descricaoproduto, pp.QUANTIDADE_PEDIDO_PRODUTO, pe.VALOR_TOTAL_PEDIDO  from produto p 
inner JOIN pedidoproduto pp on p.id = pp.produto_id 
inner join pedido pe on pp.pedido_id= pe.ID_PEDIDO

where pe.ID_PEDIDO=1*/
}
