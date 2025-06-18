package Fazenda.PlantaEAnimal.Animais;
import Fazenda.Informacoes.Inventario;
import Fazenda.Informacoes.Lotes;
import Fazenda.Informacoes.TipoLote;
import Fazenda.PlantaEAnimal.Ativo;
import Fazenda.Itens.La;
import Fazenda.Itens.FilhoteOvelha;
import Fazenda.Itens.SementeTrigo;

import java.util.ArrayList;

public class Ovelha extends Animal implements Ativo {
    public Ovelha() {
        super("Ovelha", new La(), false, 16, new SementeTrigo(), 2, 5, new FilhoteOvelha());
    }

    public TipoLote getTipo(){
        return TipoLote.OVELHA;
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
            if (ativo instanceof Ovelha ovelha && ovelha.prontoParaColeta()) {
                inventario.adicionar(ovelha.getItemProduzido(), ovelha.getQuantidadeProducao());
                ovelha.setDiasParaProduzir(this.getDiasParaProduzir());
                System.out.println(ovelha.getItemProduzido().getNome() + " coletado com sucesso!");
                return;
            }
        }
        System.out.println("Nenhum(a) " + this.getNome() + " pronto para coleta");
    }

    public void alimentar(Inventario inventario, Lotes lotes) {
        if (!inventario.contem(this.getComida())) {
            System.out.println("Não há comida para " + this.getNome() + " no inventário.");
            return;
        }

        int index = this.getTipo().ordinal();
        ArrayList<Ativo> lista = lotes.getLotes()[index];

        for (int i = 0; i < lista.size(); i++) {
            Ativo ativo = lista.get(i);
            if (ativo instanceof Ovelha ovelha && ovelha.isFome()) {
                if (inventario.remover(ovelha.getComida(), 1)) {
                    ovelha.setFome(false);
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
        if(inventario.remover(this.getFilhote(), 1)){
            Ativo ativo = new Ovelha();
            lotes.adicionar(ativo);
            System.out.println(this.getFilhote().getNome() + " colocado com sucesso, agora ele ja pode produzir!");
        }
    }

    @Override
    public String toString(){
        return getNome() + ":\n" +
                "   Vida: " + getVida() + " dias\n" +
                "   Come sementes de trigo\n" +
                "   Quanto produz: " + getQuantidadeProducao() + " lãs(s)\n" +
                "   Dias para produzir a proxima lã: " + getDiasParaProduzir() + "\n" +
                "   Está com fome: " + (this.isFome() ? "Sim" : "Não");
    }
}
