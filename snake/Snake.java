/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Ammar
 */
public class Snake {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
      game g=new game();
      g.setLocation(250, 300);
      g.setResizable(false);
   
      g.setVisible(true);
      while(true){
                
   g. repaint();
     Thread.sleep(70);
        
         }
     
    }

   
}
