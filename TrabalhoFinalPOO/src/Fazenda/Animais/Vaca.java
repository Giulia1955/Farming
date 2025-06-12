package Fazenda.Animais;
import Fazenda.*;
import Fazenda.Itens.Leite;
import Fazenda.Itens.FilhoteVaca;
import Fazenda.Itens.SementeSoja;

import java.util.ArrayList;

public class Vaca extends Animal implements Ativo{
    public Vaca() {
        super("Vaca", new Leite(), false, 20, new SementeSoja(), 5, 7, 1, new FilhoteVaca());
    }

    public TipoLote getTipo(){
        return TipoLote.VACA;
    }

    public boolean prontoParaColeta() {
        return this.getDiasParaProduzir() <= 0;
    }

    public void coletar(Inventario inventario, Lotes lotes) {
        if (!lotes.temDisponivel(this.getTipo())) {
            System.out.println("Não há " + this.getNome() + " na fazenda");
            return;
        }

        int index = this.getTipo().ordinal();
        ArrayList<Ativo> lista = lotes.getLotes()[index];

        for (int i = 0; i < lista.size(); i++) {
            Ativo ativo = lista.get(i);
            if (ativo instanceof Vaca vaca && vaca.prontoParaColeta()) {
                inventario.adicionar(vaca.getItemProduzido(), vaca.getQuantidadeProducao());
                vaca.setDiasParaProduzir(this.getDiasParaProduzir());
                System.out.println(vaca.getItemProduzido().getNome() + " coletado com sucesso!");
                return;
            }
        }
        System.out.println("Nenhum(a) " + this.getNome() + " pronto para coleta");
    }

    public void alimentar(Inventario inventario, Lotes lotes) {
        if(!inventario.contem(this.getComida())){
            System.out.println("Não há comida para " + this.getNome() + " no inventario.");
            return;
        }

        int index = this.getTipo().ordinal();
        ArrayList<Ativo> lista = lotes.getLotes()[index];

        for (int i = 0; i < lista.size(); i++) {
            Ativo ativo = lista.get(i);
            if (ativo instanceof Vaca vaca && vaca.isFome()) {
                if(inventario.remover(vaca.getItemProduzido(), 1)){
                    vaca.setFome(false);
                    System.out.println(this.getNome() + " alimentado(a) com sucesso.");
                    return;
                }
            }
        }

        System.out.println("Nenhum(a) " + this.getNome() + " com fome.");
    }

    public void colocar(Inventario inventario, Lotes lotes) {
        if(lotes.estaCheio()){
            System.out.println("Não há lotes disponíveis.");
            return;
        }
        inventario.remover(this.getFilhote(), 1);
        Ativo ativo = new Vaca();
        lotes.adicionar(ativo);
        System.out.println(this.getFilhote().getNome() + " colocado com sucesso, agora ele ja pode produzir!");
    }
}
