/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueryesPesonalizadas;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import modelos.Cliente;
import modelos.Produto;
import modelos.Usuario;

/**
 *
 * @author Pedro Henrique Gomes
 */
public class Querys {

    public void QueryAtualizarEstoque(int id_produto, int quantidade, EntityManager jpa) {
        Produto produto = new Produto();
        Query queryB = jpa.createQuery("SELECT p FROM Produto p WHERE p.id_produto = '" + id_produto + "' ", Produto.class);

        produto = (Produto) queryB.getSingleResult();
        int quantidadeCalculada = produto.getEstoque_produto() - quantidade;
        produto.setEstoque_produto(quantidadeCalculada);
        jpa.getTransaction().begin();
        jpa.merge(produto);
        jpa.getTransaction().commit();

    }

    public Cliente QueryBuscarPorCPF(String CPF, EntityManager jpa) {
        Query query = jpa.createQuery("SELECT c FROM Cliente c WHERE c.cpf_cliente = '" + CPF + "' ", Cliente.class);

        Cliente cliente = (Cliente) query.getSingleResult();
        return cliente;
    }

    public Usuario LoginUser(String nome, String senha, EntityManager jpa) {
        try {
            Query buscarUser = jpa.createQuery("SELECT u FROM Usuario u WHERE u.user = '" + nome + "' and u.senha ='" + senha + "'", Usuario.class);
            Usuario usuario = (Usuario) buscarUser.getSingleResult();
            return usuario;

        } catch (NoResultException e) {
            return null;

        }

    }

}
