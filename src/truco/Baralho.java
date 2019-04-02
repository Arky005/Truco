package truco;

import javax.swing.ImageIcon;

/**
 *
 * @author otavio.morais
 */
public class Baralho {
    
    private final Carta[] cartas;
    private final Mao maoJ1, maoJ2;
    
    public Baralho(){
        cartas=new Carta[12];
        maoJ1=new Mao();
        maoJ2=new Mao();
        gerarCartas();        
    }
    
    private boolean existe(int id, Carta[]array){
        boolean resp=false;
        if(array!=null){
            for(int i=0; i<array.length; i++){
                if(array[i]!=null){
                    if(array[i].getId()==id){
                        resp=true;
                        i=array.length;
                    }
                }
            }
        }
        return resp;
    }
    
    private void gerarCartas(){
        //cada naipe tem 10 cartas, ou seja, serao escolhidas randomicamente cartas em 40 numeros
        //NAIPE: 0-10=paus, 10-19=copas, 20-29=ouros, 30-39=espadas 
        //FINAL: 1=A,2=2,3=3,4=4,5=5,6=6,7=7,8=Q,9=J,0=K
        
        for (int i=0; i<cartas.length; i++) {
            //seleciona as cartas que serao distribuidas
            int numero=(int) (Math.random()*40); //gera carta randomica
            while(existe(numero, cartas)){ //checa se carta ja foi escolhida
                numero=(int) (Math.random()*40); //se sim, gera nova carta    
            }
            cartas[i]=new Carta(numero); //cria as cartas com o id correto
        }
        
        //envia as cartas para cada jogador
        maoJ1.setCartas(new Carta[]{cartas[0], cartas[1], cartas[2]});
        maoJ2.setCartas(new Carta[]{cartas[3], cartas[4], cartas[5]});
        //esconde as cartas do bot
        maoJ2.getCartas()[0].setIcon(new ImageIcon(getClass().getResource(("/imgs/fechada.png"))));
        maoJ2.getCartas()[1].setIcon(new ImageIcon(getClass().getResource(("/imgs/fechada.png"))));
        maoJ2.getCartas()[2].setIcon(new ImageIcon(getClass().getResource(("/imgs/fechada.png"))));
        
        Truco.getFrameJogo().getJogador1().setMao(maoJ1);
        Truco.getFrameJogo().getJogador2().setMao(maoJ2);
        Truco.getFrameJogo().getJogador1().getMao().mostrar();
        
    } 
        
}
    

