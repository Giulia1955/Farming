package Fazenda;

import Fazenda.Informacoes.Dinheiro;
import Fazenda.Informacoes.Inventario;
import Fazenda.Informacoes.Lotes;
import Fazenda.Informacoes.TipoLote;
import Fazenda.PlantaEAnimal.FomeSede;
import Fazenda.PlantaEAnimal.MatarPlantaAnimal;
import Fazenda.PlantaEAnimal.ReduzirContadores;

import java.util.Arrays;

public class AtualizarDiario {
    public void atualizarDados(Lotes lotes, Loja loja, Dinheiro dinheiro, Inventario inventario){
        Controle controle = new Controle();
        loja.Inicializar();
        controle.setPulouDia(false);
        ReduzirContadores reduzirContadores = new ReduzirContadores();
        reduzirContadores.reduzirVidaeDiasdeProd(lotes);
        Arrays.fill(controle.controleMortes, 0);
        MatarPlantaAnimal matar = new MatarPlantaAnimal();

        int qtd;
        qtd = matar.matarAnimal(lotes, TipoLote.GALINHA);
        controle.controleMortes[0] = qtd;
        qtd = matar.matarAnimal(lotes, TipoLote.OVELHA);
        controle.controleMortes[1] = qtd;
        qtd = matar.matarAnimal(lotes, TipoLote.VACA);
        controle.controleMortes[2] = qtd;
        qtd = matar.matarPlanta(lotes, TipoLote.MILHO);
        controle.controleMortes[3] = qtd;
        qtd = matar.matarPlanta(lotes, TipoLote.SOJA);
        controle.controleMortes[4] = qtd;
        qtd = matar.matarPlanta(lotes, TipoLote.TRIGO);
        controle.controleMortes[5] = qtd;

        FomeSede fomeSede = new FomeSede();
        fomeSede.colocarSede(lotes);
        fomeSede.colocarFome(lotes);
    }
}
