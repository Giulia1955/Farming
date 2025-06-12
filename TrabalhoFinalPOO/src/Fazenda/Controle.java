package Fazenda;

import java.util.Scanner;

public class Controle {
    boolean jogoAcontecendo, pulouDia;

    public Controle(){
        jogoAcontecendo = true;
        pulouDia = false;
    }

    public boolean isJogoAcontecendo() {
        return jogoAcontecendo;
    }

    public void setJogoAcontecendo(boolean jogoAcontecendo) {
        this.jogoAcontecendo = jogoAcontecendo;
    }

    public boolean isPulouDia() {
        return pulouDia;
    }

    public void setPulouDia(boolean pulouDia) {
        this.pulouDia = pulouDia;
    }

    public void atualizarDados(Lotes lotes, Loja loja){

    }

    public void exibirResumoDiario(Inventario inventario, Lotes lotes, Loja loja){

    }

    public void exibirEscolhas(){

    }

    public void tratarEscolha(Scanner scanner, Inventario inventario, Lotes lotes, Loja loja){

    }

}
