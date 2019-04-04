/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truco;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author 11821915
 */
public class ThreadJogo extends Thread {
    
    private boolean executar;
    private Jogo frame; 
    
    public ThreadJogo(){
        frame=Truco.getFrameJogo();
        executar=true;
    }
    
    @Override
    public void run(){
        
        int rodada1, rodada2, rodada3, rodadaAtual, valorTurno;
        int jogadorSelecionado=(int)(Math.random()*2);
        switch(jogadorSelecionado){
            case 0:
                frame.getJogador1().setTurno(true);
            case 1:
                frame.getJogador2().setTurno(true);
        }

        while(executar){

            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadJogo.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            if(frame.getCentroJ1()!=null && frame.getCentroJ2()!=null){
                
            }
        
            if(frame.getJogador2().isTurno()){ //se é a vez do jogador2
                frame.getjLabel1().setText("vez2");
                
                if(frame.getJogador2().getPontuacao()<10){

                    if(frame.getCentroJ1().getIcon()!=null){ //se o jogador 1 ja jogou
                    
                        //se a menor carta do bot ainda nao foi jogada
                        if(!frame.getJogador2().getMao().getMenor().isJogada() && 
                        //e ela é maior que a carta jogada pelo player
                            frame.getJogador2().getMao().getMenor().getValor()>frame.getCentroJ1().getValor()){
                            
                                frame.getCentroJ2().clonarDe(frame.getJogador2().getMao().getMenor());//envia a carta para o centro
                                frame.getCentroJ2().setIcon(frame.getCentroJ2().getIconById()); //mostra a carta do oponente no meio
                                
                                //muda o icone da carta jogada para null na mao
                                if(frame.getJ2carta1().getId()==frame.getJogador2().getMao().getMenor().getId())
                                    frame.getJ2carta1().setIcon(null);
                                else if(frame.getJ2carta2().getId()==frame.getJogador2().getMao().getMenor().getId())
                                    frame.getJ2carta2().setIcon(null);
                                else if(frame.getJ2carta3().getId()==frame.getJogador2().getMao().getMenor().getId())
                                    frame.getJ2carta3().setIcon(null);
                                
                                frame.getJogador2().getMao().getMenor().setJogada(true); //marca a carta como jogada
                            
                        } else
                        //se a carta de valor medio do bot ainda nao foi jogada
                        if(!frame.getJogador2().getMao().getMedia().isJogada() &&
                        //e ela é maior que a carta jogada pelo player
                            frame.getJogador2().getMao().getMedia().getValor()>frame.getCentroJ1().getValor()){
                                frame.getCentroJ2().clonarDe(frame.getJogador2().getMao().getMedia());//envia a carta para o centro
                                frame.getCentroJ2().setIcon(frame.getCentroJ2().getIconById());
                                
                                //muda o icone da carta jogada para null na mao
                                if(frame.getJ2carta1().getId()==frame.getJogador2().getMao().getMedia().getId())
                                    frame.getJ2carta1().setIcon(null);
                                else if(frame.getJ2carta2().getId()==frame.getJogador2().getMao().getMedia().getId())
                                    frame.getJ2carta2().setIcon(null);
                                else if(frame.getJ2carta3().getId()==frame.getJogador2().getMao().getMedia().getId())
                                    frame.getJ2carta3().setIcon(null);
                                
                                frame.getJogador2().getMao().getMedia().setJogada(true); //marca a carta como jogada
                                
                        } else
                        //se a carta de valor medio do bot ainda nao foi jogada   
                        if(!frame.getJogador2().getMao().getMaior().isJogada() &&
                        //e ela é maior que a carta jogada pelo player    
                            frame.getJogador2().getMao().getMaior().getValor()>frame.getCentroJ1().getValor()){
                            
                                frame.getCentroJ2().clonarDe(frame.getJogador2().getMao().getMaior());//envia a carta para o centro
                                frame.getCentroJ2().setIcon(frame.getCentroJ2().getIconById());
                                
                                //muda o icone da carta jogada para null na mao
                                if(frame.getJ2carta1().getId()==frame.getJogador2().getMao().getMaior().getId())
                                    frame.getJ2carta1().setIcon(null);
                                else if(frame.getJ2carta2().getId()==frame.getJogador2().getMao().getMaior().getId())
                                    frame.getJ2carta2().setIcon(null);
                                else if(frame.getJ2carta3().getId()==frame.getJogador2().getMao().getMaior().getId())
                                    frame.getJ2carta3().setIcon(null);
                                
                                frame.getJogador2().getMao().getMaior().setJogada(true); //marca a carta como jogada
                        }
                       
                        try {
                            Thread.sleep(1300);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ThreadJogo.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if(frame.getCentroJ2().getIcon()!=null){
                            frame.getCentroJ1().setIcon(null);
                            frame.getCentroJ2().setIcon(null);
                        }
                    }

                }
                
                frame.getJogador2().setTurno(false);
                frame.getJogador1().setTurno(true);
            } else 

            if(frame.getJogador1().isTurno()){
                frame.getjLabel1().setText("vez1");
                if(frame.getJogador1().getPontuacao()<10){

                } else {

                }
                if(frame.getCentroJ1().getIcon()!=null){
                    frame.getJogador1().setTurno(false);
                    frame.getJogador2().setTurno(true);
                }
            }
        }
        
        
    }
    
    public void parar(){
        this.executar=false;
    }
    
}
