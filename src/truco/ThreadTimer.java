/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truco;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author 11821915
 */
public class ThreadTimer extends Thread {
    
    private boolean executar;
    private long ms;
    private JLabel carta;
    
    public ThreadTimer(long tempo, JLabel carta){
        this.ms=tempo;
        this.executar=true;
        this.carta=carta;
    }
    
    @Override
    public void run(){
        
        while(executar){
            try {
                Thread.sleep(ms);
                carta.setIcon(null);
                parar();
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadTimer.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
            }
        }
        
    }
    
    public void parar(){
        executar=false;
    }
    
}
