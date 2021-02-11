/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modellosUteis;

import java.awt.Dialog;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;


/**
 *
 * @author Pedro Henrique Gomes
 */
public class CriarInternal {
    private static JDesktopPane jDesktopPane;
    
    public   CriarInternal(JDesktopPane jDesktopPane){
        CriarInternal.jDesktopPane=jDesktopPane;
    }

    public CriarInternal() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
            


   public void abrirJanela(JInternalFrame janela){
       if(janela.isVisible()){
           janela.toFront();
           janela.requestFocus();
       }
       else{
           jDesktopPane.add(janela);
           janela.setVisible(true);
       }
   }
    public  void abrirJanelaFrame(JFrame janela){
       if(janela.isVisible()){
           janela.toFront();
           janela.requestFocus();
           janela.setFocusable(true);
           janela.setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
       }
       else{
          
           janela.setVisible(true);
       }
   }
    public void abrirJanelaDialog(JDialog janela){
       if(janela.isVisible()){
           janela.toFront();
           janela.requestFocus();
           janela.setFocusable(true);
           janela.setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
       }
       else{
          
           janela.setVisible(true);
       }
   }
    
}
