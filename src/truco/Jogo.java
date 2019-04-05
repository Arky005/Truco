package truco;


import java.awt.Color;
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
    
    public void novaRodada(){
        baralho=new Baralho();
        prepararCartas();
        
    }
    
    private void setVisual(){
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        //this.setContentPane(new JLabel(new ImageIcon(getClass().getResource("/imgs/fechada.png"))));
        //this.getContentPane().setBackground(Color.BLACK);
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
        
        j2carta1.setDeBot(true);
        j2carta2.setDeBot(true);
        j2carta3.setDeBot(true);
        
        j2carta1.setIcon(new ImageIcon(getClass().getResource(("/imgs/fechada.png"))));
        j2carta2.setIcon(new ImageIcon(getClass().getResource(("/imgs/fechada.png"))));
        j2carta3.setIcon(new ImageIcon(getClass().getResource(("/imgs/fechada.png"))));
        
        iconeBaralho.setIcon(new ImageIcon(getClass().getResource(("/imgs/fechada.png"))));
    }
    
    private void iniciarJogo(){
        threadJogo = new ThreadJogo();
        threadJogo.start();
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

 
    public int getNumJogadores() {
        return numJogadores;
    }

    public JLabel getVisorJ1() {
        return visorJ1;
    }

    public JLabel getVisorJ2() {
        return visorJ2;
    }

    public JLabel getLabelRodada() {
        return labelRodada;
    }

    public void setLabelRodada(JLabel labelRodada) {
        this.labelRodada = labelRodada;
    }

    public JLabel getPontosj1() {
        return pontosj1;
    }

    public void setPontosj1(JLabel pontosj1) {
        this.pontosj1 = pontosj1;
    }

    public JLabel getPontosj2() {
        return pontosj2;
    }

    public void setPontosj2(JLabel pontosj2) {
        this.pontosj2 = pontosj2;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        j1carta2 = new truco.Carta();
        j1carta1 = new truco.Carta();
        j1carta3 = new truco.Carta();
        j2carta1 = new truco.Carta();
        j2carta2 = new truco.Carta();
        j2carta3 = new truco.Carta();
        iconeBaralho = new truco.Carta();
        centroJ1 = new truco.Carta();
        centroJ2 = new truco.Carta();
        visorJ2 = new javax.swing.JLabel();
        visorJ1 = new javax.swing.JLabel();
        pontosj2 = new javax.swing.JLabel();
        pontosj1 = new javax.swing.JLabel();
        labelRodada = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        j1carta2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                j1carta2MouseClicked(evt);
            }
        });

        j1carta1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                j1carta1MouseClicked(evt);
            }
        });

        j1carta3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                j1carta3MouseClicked(evt);
            }
        });

        pontosj2.setText("Pontos j2");

        pontosj1.setText("Pontos j1");

        labelRodada.setText("rodada");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(iconeBaralho, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(visorJ2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(centroJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(j2carta1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(j2carta2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(j2carta3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(visorJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(j1carta1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(j1carta2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(j1carta3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(centroJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pontosj1)
                    .addComponent(pontosj2))
                .addGap(210, 210, 210))
            .addGroup(layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(labelRodada)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(visorJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(j2carta1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(j2carta2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(j2carta3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(centroJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(pontosj2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(labelRodada)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(centroJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(pontosj1)
                                .addGap(84, 84, 84))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(j1carta1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(j1carta2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(j1carta3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(iconeBaralho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(visorJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        threadJogo.parar();
    }//GEN-LAST:event_formWindowClosed

    
    private void j1carta1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j1carta1MouseClicked
        // TODO add your handling code here:
        //if turno e centro==null
        if(this.getJogador1().isTurno() && this.getCentroJ1().getIcon()==null){
            centroJ1.clonarDe(j1carta1);
            j1carta1.setIcon(null);
            getJogador1().getMao().getCartas()[0].setJogada(true);   
        }
    }//GEN-LAST:event_j1carta1MouseClicked

    private void j1carta2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j1carta2MouseClicked
        // TODO add your handling code here:
        if(this.getJogador1().isTurno() && this.getCentroJ1().getIcon()==null){
            centroJ1.clonarDe(j1carta2);
            j1carta2.setIcon(null);
            getJogador1().getMao().getCartas()[1].setJogada(true);
        }
    }//GEN-LAST:event_j1carta2MouseClicked

    private void j1carta3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j1carta3MouseClicked
        // TODO add your handling code here:
        if(this.getJogador1().isTurno() && this.getCentroJ1().getIcon()==null){
            centroJ1.clonarDe(j1carta3);
            j1carta3.setIcon(null);
            getJogador1().getMao().getCartas()[2].setJogada(true);
        }
    }//GEN-LAST:event_j1carta3MouseClicked

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
    private javax.swing.JLabel labelRodada;
    private javax.swing.JLabel pontosj1;
    private javax.swing.JLabel pontosj2;
    private javax.swing.JLabel visorJ1;
    private javax.swing.JLabel visorJ2;
    // End of variables declaration//GEN-END:variables
}
