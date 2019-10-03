/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truco;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author otavio.morais
 */
public class ThreadJogo extends Thread {
    
    private boolean executar;
    private final Jogo frame; 
    private int rodada1, rodada2, rodada3, rodadaAtual, valorMao; //2, 4, 6, 10, 12
    private boolean ultimaEmpatou, botAceitouMao10;
    
    public ThreadJogo(){
        frame=Truco.getFrameJogo();
        executar=true;
    }
    
    
    private void jogarMenor(){
        //envia a carta para o centro
        frame.getCentroJ2().clonarDe(frame.getJogador2().getMao().getMenor());
        frame.getCentroJ2().setIcon(frame.getCentroJ2().getIconById()); 
        //muda o icone da carta jogada para null na mao
        if(frame.getJ2carta1().getId()==frame.getJogador2().getMao().getMenor().getId())
            frame.getJ2carta1().setIcon(null);
        else if(frame.getJ2carta2().getId()==frame.getJogador2().getMao().getMenor().getId())
            frame.getJ2carta2().setIcon(null);
        else if(frame.getJ2carta3().getId()==frame.getJogador2().getMao().getMenor().getId())
            frame.getJ2carta3().setIcon(null);
        //marca a carta como jogada
        frame.getJogador2().getMao().getMenor().setJogada(true);
    }
    
    private void jogarMedia(){
        //envia a carta para o centro
        frame.getCentroJ2().clonarDe(frame.getJogador2().getMao().getMedia());
        frame.getCentroJ2().setIcon(frame.getCentroJ2().getIconById());
        //muda o icone da carta jogada para null na mao
        if(frame.getJ2carta1().getId()==frame.getJogador2().getMao().getMedia().getId())
            frame.getJ2carta1().setIcon(null);
        else if(frame.getJ2carta2().getId()==frame.getJogador2().getMao().getMedia().getId())
            frame.getJ2carta2().setIcon(null);
        else if(frame.getJ2carta3().getId()==frame.getJogador2().getMao().getMedia().getId())
            frame.getJ2carta3().setIcon(null);
        frame.getJogador2().getMao().getMedia().setJogada(true); //marca a carta como jogada 
    }
    
    private void jogarMaior(){
        //envia para o centro
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
    
    private void executarLogicaBot(){
        
        if(frame.getCentroJ1().getIcon()!=null){ //se o jogador 1 ja jogou
                    
            //se o bot ainda n jogou
            if(frame.getCentroJ2().getIcon()==null){

                //se a menor do bot ainda nao foi jogada
                if(!frame.getJogador2().getMao().getMenor().isJogada()){

                    //se a menor do bot é maior que a carta jogada pelo player
                    //ou se a maior do bot for menor que a do player, joga a menor
                    if( frame.getJogador2().getMao().getMenor().getValor()>frame.getCentroJ1().getValor() ||
                           frame.getJogador2().getMao().getMaior().getValor()<frame.getCentroJ1().getValor() ){  

                        jogarMenor(); 

                    }
                }
            }

            //se o bot ainda n jogou
            if(frame.getCentroJ2().getIcon()==null){

                //se a carta media do bot ainda nao foi jogada
                if (!frame.getJogador2().getMao().getMedia().isJogada()){

                    //se a carta media do bot for maior que a carta jogada pelo player
                    if(frame.getJogador2().getMao().getMedia().getValor()>frame.getCentroJ1().getValor()){

                        jogarMedia();

                    }

                }

            }

            //se o bot ainda n jogou
            if(frame.getCentroJ2().getIcon()==null){

                //se a maior do bot ainda nao foi jogada
                if (!frame.getJogador2().getMao().getMaior().isJogada()){

                    //se a carta media do bot for maior que a carta jogada pelo player
                    if(frame.getJogador2().getMao().getMaior().getValor()>=frame.getCentroJ1().getValor()){

                        jogarMaior();

                    } //else if igual
                    //
                    //
                    //


                }

            }

            //se ainda nao conseguiu jogar
            if(frame.getCentroJ2().getIcon()==null){
                if (!frame.getJogador2().getMao().getMenor().isJogada()){
                    jogarMenor();
                } else if (!frame.getJogador2().getMao().getMedia().isJogada()){
                    jogarMedia();
                } else if (!frame.getJogador2().getMao().getMaior().isJogada()){
                    jogarMaior();
                }

            }                       

            try {
                //Aguarda 1300ms para o jogador ver o que foi jogado pelo bot
                Thread.sleep(700);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadJogo.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        //se e a vez do bot e o jogador1 nao jogou
        } else {
            
            try {
                //Aguarda 1300ms para o jogador ver o que foi jogado pelo bot
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadJogo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(!frame.getJogador2().getMao().getMedia().isJogada())
                jogarMedia();
            else if(!frame.getJogador2().getMao().getMenor().isJogada())
                jogarMenor();
            else if(!frame.getJogador2().getMao().getMaior().isJogada())
                jogarMaior();
                
            
            //frame.getCentroJ2().setIcon(null);   
            
        }
        
    }
    
    @Override
    public void run(){
        
        rodada1=rodada2=rodada3=0; //Jogador1 venceu: 1 / Jogador2 venceu: 2 / ninguem venceu: 0
        rodadaAtual=1; //1-3
        valorMao=2; //2, 4, 6, 10, 12
        ultimaEmpatou=false;
        botAceitouMao10=false;
        
        //define quem começa a jogar
        int jogadorSelecionado=(int)(Math.random()*2);
        switch(jogadorSelecionado){
            case 0:
                frame.getJogador1().setTurno(true);
                break;
            case 1:
                frame.getJogador2().setTurno(true);
        }

        while(executar){
            
            frame.getPontosj1().setText("Pontos j1: "+frame.getJogador1().getPontuacao());
            frame.getPontosj2().setText("Pontos j2: "+frame.getJogador2().getPontuacao());
            frame.getLabelRodada().setText("Rodada: "+rodadaAtual);

            try {
                //Faz uma pausa de 300ms entre uma execução e outra para melhorar o desempenho
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadJogo.class.getName()).log(Level.SEVERE, null, ex);
            }
    
            
            /////////////////////////////////////////////////////////////////////////////////////////
            ///////////////////////          ADMINISTRADOR DE PONTUAÇÕES         ////////////////////
            /////////////////////////////////////////////////////////////////////////////////////////
            
            //quando os dois ja jogaram, olha o resultado
            if(frame.getCentroJ1().getIcon()!=null && frame.getCentroJ2().getIcon()!=null){
                
                try {
                    
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadJogo.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //se a ultima rodada foi empate
                if(ultimaEmpatou){
                    //se ninguem fez a primeira rodada da os pontos pra quem mandou a maior agora
                    if(rodada1==0){
                        //se a carta do jogador 1 é maior que a do bot
                        if(frame.getCentroJ1().getValor()>frame.getCentroJ2().getValor()){
                            frame.getJogador1().setPontuacao(frame.getJogador1().getPontuacao()+valorMao);
                            //reseta os valores para a proxima mao
                            valorMao=2;
                            rodada1=rodada2=rodada3=0;
                            rodadaAtual=1;
                            frame.novaRodada();
                            ultimaEmpatou=false;
                            frame.getJogador1().setTurno(true);
                        //se a carta do bot é maior que a do jogador
                        } else if (frame.getCentroJ2().getValor()>frame.getCentroJ1().getValor()){
                            frame.getJogador2().setPontuacao(frame.getJogador2().getPontuacao()+valorMao);
                            //reseta os valores para a proxima mao
                            valorMao=2;
                            rodada1=rodada2=rodada3=0;
                            rodadaAtual=1;
                            frame.novaRodada();
                            ultimaEmpatou=false;
                            frame.getJogador2().setTurno(true);
                        //se sao iguais dnv
                        } else {
                            
                        }
                    }
                } 
                //se nao empatou e se a carta do jogador 1 é maior que a do bot
                else if(frame.getCentroJ1().getValor()>frame.getCentroJ2().getValor()){
                    //se esta na primeira rodada
                    if(rodadaAtual==1){
                            //seta o jogador1 como vencedor da atual rodada
                            rodada1=1;
                            rodadaAtual++;
                            frame.getJogador1().setTurno(true);
                    //se esta na rodada final, da os pontos a quem venceu
                    } else if(rodadaAtual==3){
                        //seta o jogador1 como vencedor da rodada3
                        rodada3=1;
                        frame.getJogador1().setPontuacao(frame.getJogador1().getPontuacao()+valorMao);
                        valorMao=2;
                        rodada1=rodada2=rodada3=0;
                        rodadaAtual=1;
                        frame.novaRodada();
                        frame.getJogador1().setTurno(true);
                    } else if(rodadaAtual==2){
                        //seta o jogador1 como vencedor da atual rodada
                        rodada2=1;
                        rodadaAtual++;
                        frame.getJogador1().setTurno(true);
                        //mas se o jogador1 venceu a primeira e segunda rodadas
                        if(rodada1==1){
                            //seta como vencedor da mao
                            frame.getJogador1().setPontuacao(frame.getJogador1().getPontuacao()+valorMao);
                            valorMao=2;
                            rodada1=rodada2=rodada3=0;
                            rodadaAtual=1;
                            frame.novaRodada(); 
                        }  
                    }      
                }   
                //se a carta do bot é maior do que a do jogador 1
                else if(frame.getCentroJ2().getValor()>frame.getCentroJ1().getValor()){
                    //se esta na primeira rodada
                    if(rodadaAtual==1){
                            //seta o bot como vencedor da atual rodada
                            rodada1=2;
                            rodadaAtual++;
                            frame.getJogador2().setTurno(true);                         
                    //se esta na rodada final, da os pontos a quem venceu
                    } else if(rodadaAtual==3){
                        //seta o bot como vencedor da rodada3
                        rodada3=2;
                        //seta como vencedor da mao
                        frame.getJogador2().setPontuacao(frame.getJogador2().getPontuacao()+valorMao);
                        valorMao=2;
                        rodada1=rodada2=rodada3=0;
                        rodadaAtual=1;                       
                        frame.novaRodada();
                        frame.getJogador2().setTurno(true);
                    } else if(rodadaAtual==2){
                        //seta o bot como vencedor da atual rodada
                        rodada2=2;
                        rodadaAtual++;
                        frame.getJogador2().setTurno(true);
                        //mas se o bot venceu a primeira e segunda rodadas
                        if(rodada1==2){
                            //seta como vencedor da mao
                            frame.getJogador2().setPontuacao(frame.getJogador2().getPontuacao()+valorMao);
                            valorMao=2;
                            rodada1=rodada2=rodada3=0;
                            rodadaAtual=1;
                            frame.novaRodada();
                        }  
                    }   
                } 
                //se empatou 
                else {
                    ultimaEmpatou=true;
                    rodadaAtual++;
                }
                frame.getCentroJ1().setIcon(null);
                frame.getCentroJ2().setIcon(null);    
            }
        
            //////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////          LOGICA DO BOT        ///////////////////////////////
            //////////////////////////////////////////////////////////////////////////////////////
    
            if(frame.getJogador2().isTurno()){ //se é a vez do bot
                frame.getVisorJ2().setIcon(new ImageIcon(getClass().getResource("/imgs/visor.png")));
                frame.getVisorJ1().setIcon(null);
                
                if(frame.getJogador2().getPontuacao()<10){

                    executarLogicaBot();

                //se e mao de 10 do bot ou venceu
                } else {
                    
                     
                    
                }
                
                frame.getJogador2().setTurno(false);
                frame.getJogador1().setTurno(true);
            } else 

            if(frame.getJogador1().isTurno()){
                
                frame.getVisorJ1().setIcon(new ImageIcon(getClass().getResource("/imgs/visor.png")));
                frame.getVisorJ2().setIcon(null);
                
                if(frame.getJogador1().getPontuacao()<10){

                } else {

                }
                if(frame.getCentroJ1().getIcon()!=null){
                    frame.getJogador1().setTurno(false);
                    frame.getJogador2().setTurno(true);
                }
            }
            
            if(frame.getJogador2().getPontuacao()==10){
                        
                //se os valores derem mais que 30 aceita mao de 10
                if( (frame.getJogador2().getMao().getMaior().getValor()+
                     frame.getJogador2().getMao().getMaior().getValor()+
                     frame.getJogador2().getMao().getMaior().getValor()) 
                        <25 &&(frame.getJogador1().getPontuacao()<10)){

                    executarLogicaBot();

                //correu    
                } else {
                    JOptionPane.showMessageDialog(frame, "Não quero, vou correr.");
                    //seta o jogador1 como vencedor da mao
                    frame.getJogador1().setPontuacao(frame.getJogador1().getPontuacao()+valorMao);
                    valorMao=2;
                    rodada1=rodada2=rodada3=0;
                    rodadaAtual=1;
                    frame.novaRodada();

                }

            //bot ganhou
            } else if (frame.getJogador2().getPontuacao()==12) {
                frame.getPontosj2().setText("Pontos j2: 12");
                frame.getJogador1().setPontuacao(0);
                frame.getJogador2().setPontuacao(0);
                JOptionPane.showMessageDialog(frame, "PERDEU CORNO! BORA OUTRA");
                rodada1=rodada2=rodada3=0; 
                rodadaAtual=1;
                valorMao=2;
                ultimaEmpatou=false;
                botAceitouMao10=false;
                frame.prepararCartas();

            }
            
        }
        
        
    }

    public int getValorMao() {
        return valorMao;
    }
    
    
    public void parar(){
        this.executar=false;
    }
    
}
