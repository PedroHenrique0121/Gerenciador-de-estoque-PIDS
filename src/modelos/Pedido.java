/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Pedro Henrique Gomes
 */
@Entity
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pedido;
    private double valor_total_pedido;
    private double desconto;
    @Temporal(TemporalType.DATE)
    private Date data;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    @OneToMany(mappedBy = "pedido")
    private List<PedidoProduto> pedido_produto;

    @ManyToOne()
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    @ManyToOne()
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    @ManyToOne()
    @JoinColumn(name="pagamento_id")
    private Pagamento pagamento;

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    private String descricao;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public double getValor_total_pedido() {
        return valor_total_pedido;
    }

    public void setValor_total_pedido(double valor_total_pedido) {
        this.valor_total_pedido = valor_total_pedido;
    }

    public List<PedidoProduto> getPedido_produto() {
        return pedido_produto;
    }

    public void setPedido_produto(List<PedidoProduto> pedido_produto) {
        this.pedido_produto = pedido_produto;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
