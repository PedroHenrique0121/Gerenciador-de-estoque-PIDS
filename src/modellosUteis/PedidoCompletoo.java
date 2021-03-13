/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modellosUteis;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author pedro
 */
@Entity
public class PedidoCompletoo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private int id_pedido;
    private double VALOR_TOTAL_PEDIDO;
    @Temporal(TemporalType.DATE)
    private Date data;
    private String cpf_cliente;
    private String nome_cliente;
    private String nome;

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public double getVALOR_TOTAL_PEDIDO() {
        return VALOR_TOTAL_PEDIDO;
    }

    public void setVALOR_TOTAL_PEDIDO(double VALOR_TOTAL_PEDIDO) {
        this.VALOR_TOTAL_PEDIDO = VALOR_TOTAL_PEDIDO;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
