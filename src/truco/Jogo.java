package truco;


import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 *
 * @author otavio.morais
 */
class Jogo extends javax.swing.JFrame {

    private Baralho baralho;
    private final Jogador jogador1, jogador2;//, jogador3, jogador4;
    private final int numJogadores;
    private ThreadJogo threadJogo;
    
    /**
     * Creates new form Jogo
     */
    public Jogo(String nomeJogador, int numJogadores) {
        Truco.setFrameJogo(this);
        jogador1=new Jogador(nomeJogador);//jogador1 sempre o player
        jogador2=new Jogador();
        baralho=new Baralho();
        initComponents();
        setVisual();
        this.numJogadores=numJogadores;
        prepararCartas();
        iniciarJogo();
    }
    
    private void setVisual(){
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
    //NAIPES: 0-10=paus, 10-19=copas, 20-29=ouros, 30-39=espadas 
    //FINAL: 1=A,2=2,3=3,4=4,5=5,6=6,7=7,8=Q,9=J,0=K
    
    private void prepararCartas(){
        
        j1carta1.clonarDe(getJogador1().getMao().getCartas()[0]);
        j1carta2.clonarDe(getJogador1().getMao().getCartas()[1]);
        j1carta3.clonarDe(getJogador1().getMao().getCartas()[2]);
       
        j2carta1.clonarDe(getJogador2().getMao().getCartas()[0]);
        j2carta2.clonarDe(getJogador2().getMao().getCartas()[1]);
        j2carta3.clonarDe(getJogador2().getMao().getCartas()[2]);
        
       
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
       
        
    
        //iconeBaralho.setIcon(null);
    }
    
    private void iniciarJogo(){
        
        
        threadJogo = new ThreadJogo();
        threadJogo.start();
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

    public Jogador getJogador1() {
        return jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public Carta getCentroJ1() {
        return centroJ1;
    }
    

    public Carta getCentroJ2() {
        return centroJ2;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    
    
    public int getNumJogadores() {
        return numJogadores;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        j1carta2 = new truco.Carta();
        j1carta1 = new truco.Carta();
        j1carta3 = new truco.Carta();
        j2carta1 = new truco.Carta();
        j2carta2 = new truco.Carta();
        j2carta3 = new truco.Carta();
        iconeBaralho = new truco.Carta();
        centroJ1 = new truco.Carta();
        centroJ2 = new truco.Carta();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        j1carta1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                j1carta1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(iconeBaralho, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(j1carta1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(j1carta2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j1carta3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(centroJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(centroJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(j2carta1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(j2carta2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(j2carta3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(306, 306, 306))
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
                .addGap(18, 18, 18)
                .addComponent(centroJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(centroJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(j1carta1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(j1carta2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(j1carta3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(iconeBaralho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        threadJogo.parar();
    }//GEN-LAST:event_formWindowClosed

    
    private void j1carta1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j1carta1MouseClicked
        // TODO add your handling code here:
        centroJ1.clonarDe(j1carta1);
        j1carta1.setIcon(null);
        getJogador1().getMao().getCartas()[0].setJogada(true);
        
        
    }//GEN-LAST:event_j1carta1MouseClicked

    public Carta getJ2carta1() {
        return j2carta1;
    }

    public Carta getJ2carta2() {
        return j2carta2;
    }

    public Carta getJ2carta3() {
        return j2carta3;
    }

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private truco.Carta centroJ1;
    private truco.Carta centroJ2;
    private truco.Carta iconeBaralho;
    private truco.Carta j1carta1;
    private truco.Carta j1carta2;
    private truco.Carta j1carta3;
    private truco.Carta j2carta1;
    private truco.Carta j2carta2;
    private truco.Carta j2carta3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
