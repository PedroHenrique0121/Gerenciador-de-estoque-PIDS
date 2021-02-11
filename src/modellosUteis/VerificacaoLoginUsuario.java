/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modellosUteis;

import QueryesPesonalizadas.Querys;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import modelos.Usuario;
import tela.Principal;
import static tela.Login.userStatic;
import static tela.Login.usuario;

/**
 *
 * @author Pedro Henrique Gomes
 */
public class VerificacaoLoginUsuario {

    public static Usuario userStatic;
    public static String usuario;

    public boolean logar(String nome, String senha, EntityManager jpa) {
        Querys loginUser = new Querys();
        userStatic = loginUser.LoginUser(nome, senha, jpa);
        if (userStatic != null) {
            JOptionPane.showMessageDialog(null, "Bem vindo: " + userStatic.getNome());
            Principal principal = new Principal();
            principal.setVisible(true);

            usuario = userStatic.getNome();
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Usuario não encontrado");
            userStatic = null;
            return false;
        }
        
    }

}
