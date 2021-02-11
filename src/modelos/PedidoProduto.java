/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Pedro Henrique Gomes
 */
@Entity
public class PedidoProduto implements Serializable {

    private static final long serialVersionUID = 1L;
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pedido_prdouto;
    private int quantidade_pedido_produto;
    @ManyToOne()
    @JoinColumn(name="pedido_id")
    private Pedido pedido;
    @ManyToOne()
     @JoinColumn(name = "produto_id")
    private Produto produto;

    public int getId_pedido_prdouto() {
        return id_pedido_prdouto;
    }

    public void setId_pedido_prdouto(int id_pedido_prdouto) {
        this.id_pedido_prdouto = id_pedido_prdouto;
    }

    public int getQuantidade_pedido_produto() {
        return quantidade_pedido_produto;
    }

    public void setQuantidade_pedido_produto(int quantidade_pedido_produto) {
        this.quantidade_pedido_produto = quantidade_pedido_produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
}
