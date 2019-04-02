package truco;

import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author otavio.morais
 */
public class Carta extends javax.swing.JLabel{
    
    private String nome, naipe;
    private URL srcImg;
    private int id, valor;
    private boolean manilha, jogada;

    public Carta(){ //gera carta vazia
       super();
       this.setId(-1);
    }
    
    public Carta(int id){
        super();
        this.setId(id);
        this.setValorById();
        this.setNomeById();
        this.setImgById();
        this.setIcon(new ImageIcon(this.getSrcImg()));
    }
    
    public String getNome() {
        return nome;
    }

    public String getNaipe() {
        return naipe;
    }

    public void setNaipe(String manilha) {
        this.naipe = manilha;
    }

    public URL getSrcImg() {
        return srcImg;
    }
   
    private void setImgById() {
        this.setSrcImg(getClass().getResource(("/imgs/"+this.getId()+".png")));
    }

    private void setSrcImg(URL srcImg) {
        this.srcImg = srcImg;
    }

    public int getId() {
        return this.id;
    }

    private void setId(int id) { //seta o valor que a carta representa e o nome quando seta o id
        this.id = id;   
    }

    public boolean isManilha() { //retorna se e manilha ou nao
        return manilha;
    }

    private void setManilha(boolean manilha) {
        this.manilha = manilha;
    }

    public int getValor() { //retorna o valor que a carta representa
        return valor;
    }

    public boolean isJogada() {
        return jogada;
    }

    public void setJogada(boolean jogada) {
        this.jogada = jogada;
    }
    
    public ImageIcon getIconById(){
        return new ImageIcon(getClass().getResource(("/imgs/"+this.getId()+".png")));
    }

    private void setNomeById(){ //seta o nome da carta correspondente ao id
        
        int numero=this.getId(); //numero utilizado para facilitar escolha de naipe
        if(id>=0&&id<=9){ //paus
            this.naipe=" de paus";
        } else if(id>=10&&id<=19){
            numero=numero-10;
            this.naipe=" de copas";
        } else if(id>=20&&id<=29){
            numero=numero-20;
            this.naipe=" de ouros";
        } else {
            numero=numero-30;
            this.naipe=" de espadas";
        }
        switch(numero){
            case 0:
                this.nome="K"+naipe;
                break;
            case 1:
                this.nome="A"+naipe;
                break;
            case 8:
                this.nome="Q"+naipe;
                break;
            case 9:
                this.nome="J"+naipe;
                break;
            default:
                nome=numero+naipe;
        }
    }
    
    private void setValorById() { //seta o valor que a carta representa e se é manilha
        switch(id){
            case 14: //4 de copas
            case 24: //4 de ouros
            case 34: //4 de espadas
                this.valor=1;
                break;
            case 5: //5 de paus
            case 15: //5 de copas
            case 25: //5 de ouros
            case 35: //5 de espadas
                this.valor=2;
                break;
            case 6: //6 de paus
            case 16: //6 de copas
            case 26: //6 de ouros
            case 36: //6 de espadas
                this.valor=3;
                break;
            case 7: //7 de paus
            case 37: //7 de espadas
                this.valor=4;
                break;
            case 8: //Q de paus
            case 18: //Q de copas
            case 28: //Q de ouros
            case 38: //Q de espadas
                this.valor=5;
                break;
            case 9: //J de paus
            case 19: //J de copas
            case 29: //J de ouros
            case 39: //J de espadas
                this.valor=6;
                break;
            case 0: //K de paus
            case 10: //K de copas
            case 20: //K de ouros
            case 30: //K de espadas
                this.valor=7;
                break;
            case 1: //A de paus
            case 11: //A de copas
            case 21: //A de ouros
                this.valor=8;
                break;
            case 2: //2 de paus
            case 12: //2 de copas
            case 22: //2 de ouros
            case 32: //2 de espadas
                this.valor=9;
                break;
            case 3: //3 de paus
            case 13: //3 de copas
            case 23: //3 de ouros
            case 33: //3 de espadas
                this.valor=10;
                break;
            case 27: //7 de ouros
                this.valor=11;
                this.setManilha(true);
                break;
            case 31: //A de espadas
                this.valor=12;
                this.setManilha(true);
                break;
            case 17: // 7 de copas
                this.valor=13;
                this.setManilha(true);
                break;
            case 4: //4 de paus
                this.valor=14;
                this.setManilha(true);
        }   
    }
    
    public void clonarDe(Carta carta){
        this.setIcon(carta.getIcon());
        this.setId(carta.getId());
        this.setValorById();
        this.setNomeById();
        this.setImgById();
    }
    
    
}
