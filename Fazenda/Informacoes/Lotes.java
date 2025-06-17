package Fazenda.Informacoes;

import Fazenda.PlantaEAnimal.Ativo;

import java.io.Serializable;
import java.util.ArrayList;

public class Lotes implements Serializable {
    private static final long serialVersionUID = 1L;

    private int qtdMaxima;
    private ArrayList<Ativo>[] lotes;

    public Lotes() {
        try {
            int tamanho = TipoLote.TAMANHO;
            this.lotes = new ArrayList[tamanho];
            for (int i = 0; i < tamanho; i++) {
                lotes[i] = new ArrayList<>();
            }
            qtdMaxima = 30;
        } catch (Exception e) {
            System.err.println("Erro ao inicializar lotes: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void imprimirLotes(Lotes lotes){
        int contador = 1;

        ArrayList<Ativo>[] arrayLotes = lotes.getLotes();
        System.out.println("Lotes ocupados: ");

        for (ArrayList<Ativo> arrayTipo : arrayLotes) {
            for(Ativo ativo : arrayTipo) {
                System.out.println("Lote: " + contador);
                System.out.println(ativo);
                contador++;
            }
            System.out.println();
        }
    }

    public int getQtdMaxima() {
        return qtdMaxima;
    }

    public void setQtdMaxima(int qtdMaxima) {
        if (qtdMaxima > 0) {
            this.qtdMaxima = qtdMaxima;
        } else {
            System.err.println("Quantidade máxima deve ser positiva.");
        }
    }

    public ArrayList<Ativo>[] getLotes() {
        return lotes;
    }

    public void setLotes(ArrayList<Ativo>[] lotes) {
        if (lotes != null) {
            this.lotes = lotes;
        } else {
            System.err.println("Lotes não podem ser nulos.");
        }
    }

    public boolean temDisponivel(TipoLote tipo) {
        try {
            return !lotes[tipo.ordinal()].isEmpty();
        } catch (Exception e) {
            System.err.println("Erro ao verificar disponibilidade do lote: " + e.getMessage());
            return false;
        }
    }

    public boolean estaCheio() {
        try {
            int total = 0;
            for (ArrayList<Ativo> lote : lotes) {
                total += lote.size();
            }
            return total >= this.getQtdMaxima();
        } catch (Exception e) {
            System.err.println("Erro ao verificar se os lotes estão cheios: " + e.getMessage());
            return true; // assume cheio por segurança
        }
    }

    public int quantidadeDisponivel(TipoLote tipo) {
        try {
            return lotes[tipo.ordinal()].size();
        } catch (Exception e) {
            System.err.println("Erro ao obter quantidade disponível: " + e.getMessage());
            return 0;
        }
    }

    public void adicionar(Ativo ativo) {
        try {
            if (ativo == null) {
                System.err.println("Ativo nulo não pode ser adicionado.");
                return;
            }

            if (this.estaCheio()) {
                System.out.println("Nenhum lote disponível.");
            } else {
                ArrayList<Ativo> lote = lotes[ativo.getTipo().ordinal()];
                lote.add(ativo);
            }
        } catch (Exception e) {
            System.err.println("Erro ao adicionar ativo ao lote: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void remover(TipoLote tipo) {
        try {
            ArrayList<Ativo> lote = lotes[tipo.ordinal()];
            if (!lote.isEmpty()) {
                lote.remove(0);
            } else {
                System.out.println("Não há itens para remover neste lote.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao remover ativo do lote: " + e.getMessage());
            e.printStackTrace();
        }
    }
}