/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Pedro Henrique Gomes
 */
@Entity
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String descricaoProduto;
    
    private double precoVendaProduto;
    private double precoCustoProduto;
    private int estoqueProduto;
    
    @ManyToOne()
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;
    @OneToMany(mappedBy = "produto")
    private List<PedidoProduto> pedidoProduto;
    
    public int getId_produto() {
        return id;
    }

    public void setId_produto(int id_produto) {
        this.id = id_produto;
    }

    public String getDescricao_produto() {
        return descricaoProduto;
    }

    public void setDescricao_produto(String descricao_produto) {
        this.descricaoProduto = descricao_produto;
    }

    public double getPreco_venda_produto() {
        return precoVendaProduto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<PedidoProduto> getPedidoProduto() {
        return pedidoProduto;
    }

    public void setPedidoProduto(List<PedidoProduto> pedidoProduto) {
        this.pedidoProduto = pedidoProduto;
    }

    public void setPreco_venda_produto(double preco_venda_produto) {
        this.precoVendaProduto = preco_venda_produto;
    }

    public double getPreco_custo_produto() {
        return precoCustoProduto;
    }

    public void setPreco_custo_produto(double preco_custo_produto) {
        this.precoCustoProduto = preco_custo_produto;
    }

    public int getEstoque_produto() {
        return estoqueProduto;
    }

    public void setEstoque_produto(int estoque_produto) {
        this.estoqueProduto = estoque_produto;
    }
    
    
}
