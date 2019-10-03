/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truco;

/**
 *
 * @author Otávio Morais
 */
public class Mao {
    
    private Carta[] cartas; //cartas desordenadas para a montagem da mao
    private Carta[] cartasOrdenadas;
    
    public Mao(){
        
    }
    
    private void selecao()
    {
        Carta temp;
        for(int i=0; i<cartasOrdenadas.length-1; i++)
        {
            int vmenor=i;
            for(int j=i+1; j<cartasOrdenadas.length; j++)
            {
                if(cartasOrdenadas[j].getValor()<cartasOrdenadas[vmenor].getValor())
                vmenor=j;
            }
            temp=cartasOrdenadas[vmenor];
            cartasOrdenadas[vmenor]=cartasOrdenadas[i];
            cartasOrdenadas[i]=temp;
        }  
    }
    
    public void mostrar(){
        
        for(int i=0; i<cartasOrdenadas.length; i++){
            System.out.println(cartasOrdenadas[i].getNome());
        }
    }

    public Carta getMaior() {
        return cartasOrdenadas[2];
    }

    public Carta getMenor() {
        return cartasOrdenadas[0];
    }

    public Carta getMedia() {
        return cartasOrdenadas[1];
    }

    public Carta[] getCartas() {
        return cartas;
    }

    public void setCartas(Carta[] cartas) {
        this.cartas = cartas;
        cartasOrdenadas=cartas;
        selecao();
    }
    
    
    
}
