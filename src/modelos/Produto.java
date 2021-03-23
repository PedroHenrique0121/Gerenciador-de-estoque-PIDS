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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    

    public double getPrecoVendaProduto() {
        return precoVendaProduto;
    }

    public void setPrecoVendaProduto(double precoVendaProduto) {
        this.precoVendaProduto = precoVendaProduto;
    }

    public double getPrecoCustoProduto() {
        return precoCustoProduto;
    }

    public void setPrecoCustoProduto(double precoCustoProduto) {
        this.precoCustoProduto = precoCustoProduto;
    }

    public int getEstoqueProduto() {
        return estoqueProduto;
    }

    public void setEstoqueProduto(int estoqueProduto) {
        this.estoqueProduto = estoqueProduto;
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
    
   
    
}
