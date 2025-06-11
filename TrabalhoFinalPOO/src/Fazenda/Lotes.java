package Fazenda;

import java.util.HashMap;
import Fazenda.Animais.Animal;
import Fazenda.Plantas.Planta;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Lotes {
    private int qtdMaxima;
    private ArrayList<Ativo>[] lotes;

    public Lotes() {
        int tamanho = TipoLote.TAMANHO;
        this.lotes = new ArrayList[tamanho];
        for (int i = 0; i < tamanho; i++) {
            lotes[i] = new ArrayList<>();
        }
        qtdMaxima = 30;
    }

    public int getQtdMaxima() {
        return qtdMaxima;
    }

    public void setQtdMaxima(int qtdMaxima) {
        this.qtdMaxima = qtdMaxima;
    }

    public ArrayList<Ativo>[] getLotes() {
        return lotes;
    }

    public void setLotes(ArrayList<Ativo>[] lotes) {
        this.lotes = lotes;
    }

    public boolean temDisponivel(TipoLote tipo) {
        return !lotes[tipo.ordinal()].isEmpty();
    }

    public boolean estaCheio() {
        int total = 0;
        for (ArrayList<Ativo> lote : lotes) {
            total += lote.size();
        }
        return total >= this.getQtdMaxima();
    }

    public int quantidadeDisponivel(TipoLote tipo) {
        return lotes[tipo.ordinal()].size();
    }

    public void adicionar(Ativo ativo) {
        if(this.estaCheio()){
            System.out.println("Nenhum lote disponível.");
        }else{
            ArrayList<Ativo> lote = lotes[ativo.getTipo().ordinal()];
            lote.add(ativo);
        }
    }

    public void remover(TipoLote tipo) {
        ArrayList<Ativo> lote = lotes[tipo.ordinal()];
        if (!lote.isEmpty()) {
            lote.remove(0);
        }
    }
}


