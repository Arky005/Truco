package truco;

import com.sun.glass.ui.Application;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author otavio.morais
 */
class Jogo extends javax.swing.JFrame {

    private Baralho baralho;
    private static Jogador jogador1, jogador2;//, jogador3, jogador4;
    private final int numJogadores;
    private Thread threadJogo;
    private Runnable runa;
    
    /**
     * Creates new form Jogo
     */
    public Jogo(String nomeJogador, int numJogadores) {
       jogador1=new Jogador(nomeJogador);//jogador1 sempre o player
        jogador2=new Jogador();
        baralho=new Baralho();
        //prepararCartas();
        initComponents();
        //prepararCartas();
        setVisual();
        this.numJogadores=numJogadores;
        
        prepararCartas();
        iniciarJogo();
        
        
    }
    
    
    
    private void iniciarJogo(){
        
        /*
        
       threadJogo = new Thread(new Runnable(){
           boolean continuar=true;
           public void run(){
               
              
                   int jogadorSelecionado=(int)(Math.random()*2);
                    switch(jogadorSelecionado){
                        case 0:
                            Jogo.getJogador1().setTurno(true);
                        case 1:
                            Jogo.getJogador2().setTurno(true);
                    }

                    while(true){


                        if(Jogo.getJogador2().isTurno()){
                            jLabel1.setText("vez2");

                            if(centroj1.getIcon()!=null)

                            if(Jogo.getJogador2().getPontuacao()<10){

                            } else {

                            }

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            Jogo.getJogador2().setTurno(false);
                            Jogo.getJogador1().setTurno(true);
                        } else 

                        if(Jogo.getJogador1().isTurno()){
                            jLabel1.setText("vez1");
                            if(Jogo.getJogador1().getPontuacao()<10){

                            } else {

                            }
                            if(centroj1.getIcon()!=null){
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                Jogo.getJogador1().setTurno(false);
                                Jogo.getJogador2().setTurno(true);
                            }
                        }
                    
                   
               }
               
               
           }
           
         
       });
        
       threadJogo.start();
        */
    }
    
    private void setVisual(){
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
    //NAIPES: 0-10=paus, 10-19=copas, 20-29=ouros, 30-39=espadas 
    //FINAL: 1=A,2=2,3=3,4=4,5=5,6=6,7=7,8=Q,9=J,0=K
    
    private void prepararCartas(){
        
        j1carta1.clonarDe(Jogo.getJogador1().getMao().getCartas()[0]);
        j1carta2.clonarDe(Jogo.getJogador1().getMao().getCartas()[1]);
        j1carta3.clonarDe(Jogo.getJogador1().getMao().getCartas()[2]);
       
        j2carta1.clonarDe(Jogo.getJogador2().getMao().getCartas()[0]);
        j2carta2.clonarDe(Jogo.getJogador2().getMao().getCartas()[1]);
        j2carta3.clonarDe(Jogo.getJogador2().getMao().getCartas()[2]);
        
       // j2c1.setIcon(new ImageIcon(getClass().getResource(("/imgs/fechada.png"))));
       // j2c2.setIcon(new ImageIcon(getClass().getResource(("/imgs/fechada.png"))));
       // j2c3.setIcon(new ImageIcon(getClass().getResource(("/imgs/fechada.png"))));
        iconeBaralho.setIcon(new ImageIcon(getClass().getResource(("/imgs/fechada.png"))));
        
        /*
        new Thread(){ 
            public void run(){
                try {
                    Thread.sleep(3000);
                    iconeBaralho.setIcon(null);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        }.start();
        */
        new ThreadTimer(3000, iconeBaralho).start();
        
    
        //iconeBaralho.setIcon(null);
    }

    public static Jogador getJogador1() {
        return jogador1;
    }

    public static Jogador getJogador2() {
        return jogador2;
    }

    public int getNumJogadores() {
        return numJogadores;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        centroj1 = new javax.swing.JLabel();
        iconeBaralho = new javax.swing.JLabel();
        centroj2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        j1carta2 = new truco.Carta();
        j1carta1 = new truco.Carta();
        j1carta3 = new truco.Carta();
        j2carta1 = new truco.Carta();
        j2carta2 = new truco.Carta();
        j2carta3 = new truco.Carta();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        iconeBaralho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconeBaralhoMouseClicked(evt);
            }
        });

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconeBaralho, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(736, 736, 736))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(476, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(centroj1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(centroj2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel1)
                        .addGap(185, 185, 185)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(j2carta1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(j2carta2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(j2carta3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(j1carta1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j1carta2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j1carta3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(303, 303, 303))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(j2carta1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(j2carta2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(j2carta3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addComponent(centroj2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(iconeBaralho, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(j1carta1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(j1carta2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(j1carta3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(centroj1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(22, 22, 22))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iconeBaralhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconeBaralhoMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Tira a mão do baralho, LADRÃO!");
    }//GEN-LAST:event_iconeBaralhoMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel centroj1;
    private javax.swing.JLabel centroj2;
    private javax.swing.JLabel iconeBaralho;
    private truco.Carta j1carta1;
    private truco.Carta j1carta2;
    private truco.Carta j1carta3;
    private truco.Carta j2carta1;
    private truco.Carta j2carta2;
    private truco.Carta j2carta3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
