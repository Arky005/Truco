package truco;

/**
 *
 * @author otavio.morais
 */
public class Jogador extends Truco{
    
    private String nome;
    private int pontuacao;
    private Mao mao;
    private boolean turno;
    private Carta ultimaJogada;

    public Jogador(String nome){
        this.nome=nome;
        pontuacao=0;
    }
    
    public Jogador(){
        pontuacao=0;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Mao getMao() {
        return mao;
    }

    public void setMao(Mao mao) {
        this.mao = mao;
    }
    

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public Carta getUltimaJogada() {
        return this.ultimaJogada;
    }

    public void setUltimaJogada(Carta ultimaJogada) {
        this.ultimaJogada = ultimaJogada;
    }
    
    
    
}
