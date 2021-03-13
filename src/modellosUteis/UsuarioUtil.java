/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modellosUteis;


import modelos.Usuario;

/**
 *
 * @author Alan Soares de Abreu
 */
public class UsuarioUtil {
    public static Usuario usuarioUtil;

    public static Usuario getForncedorUtil() {
        return usuarioUtil;
    }

    public static void setForncedorUtil(Usuario usuarioUtil) {
     
        UsuarioUtil.usuarioUtil = usuarioUtil;
    }
}
