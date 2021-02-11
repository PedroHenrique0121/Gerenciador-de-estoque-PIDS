/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private int id_produto;
    private String descricao_produto;
    private double preco_venda_produto;
    private double preco_custo_produto;
    private int estoque_produto;
    @OneToMany(mappedBy = "produto")
    private List<PedidoProduto> pedidoProduto;
    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getDescricao_produto() {
        return descricao_produto;
    }

    public void setDescricao_produto(String descricao_produto) {
        this.descricao_produto = descricao_produto;
    }

    public double getPreco_venda_produto() {
        return preco_venda_produto;
    }

    public void setPreco_venda_produto(double preco_venda_produto) {
        this.preco_venda_produto = preco_venda_produto;
    }

    public double getPreco_custo_produto() {
        return preco_custo_produto;
    }

    public void setPreco_custo_produto(double preco_custo_produto) {
        this.preco_custo_produto = preco_custo_produto;
    }

    public int getEstoque_produto() {
        return estoque_produto;
    }

    public void setEstoque_produto(int estoque_produto) {
        this.estoque_produto = estoque_produto;
    }
    
    
}
