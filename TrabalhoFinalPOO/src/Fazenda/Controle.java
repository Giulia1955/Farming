package Fazenda;

import java.util.Scanner;

import Fazenda.Informacoes.TipoLote;
import Fazenda.Arquivo.Arquivo;
import Fazenda.Arquivo.EstadoJogo;
import Fazenda.Informacoes.Dinheiro;
import Fazenda.Informacoes.Inventario;
import Fazenda.Informacoes.Lotes;


public class Controle {
    int dias;
    boolean jogoAcontecendo, pulouDia;
    int[] controleMortes;

    public Controle(){
        jogoAcontecendo = true;
        pulouDia = false;
        dias = 1;
        controleMortes = new int[TipoLote.TAMANHO];
    }

    public boolean isJogoAcontecendo() { return jogoAcontecendo; }

    public void setJogoAcontecendo(boolean jogoAcontecendo) {
        this.jogoAcontecendo = jogoAcontecendo;
    }

    public boolean isPulouDia() {
        return pulouDia;
    }

    public void setPulouDia(boolean pulouDia) {
        this.pulouDia = pulouDia;
    }

    public int getDias() {
        return dias;
    }
    public void setDias(int dias) {
        this.dias = dias;
    }

    public void iniciar(){
        Inventario inventario = new Inventario();
        Lotes lotes = new Lotes();
        Scanner scanner = new Scanner(System.in);
        Loja loja = new Loja();
        Dinheiro dinheiro = new Dinheiro();
        EstadoJogo estado = new EstadoJogo(inventario,dinheiro,lotes,dias);
        CartaIntroducao introducao = new CartaIntroducao();
        AtualizarDiario atualizar = new AtualizarDiario();
        ExibirResumo resumo = new ExibirResumo();
        Escolhas escolhas = new Escolhas();

        System.out.print("Deseja carregar o jogo salvo? (s/n): ");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("s")) {
            estado = Arquivo.carregarJogo("fazenda.sav");
            if (estado != null) {
                inventario = estado.getInventario();
                dinheiro = estado.getDinheiro();
                lotes = estado.getLotes();
                dias = estado.getDias();
                System.out.println("Jogo carregado com sucesso.");
            } else {
                introducao.exibirIntroducao();
            }
        }
        else{
            introducao.exibirIntroducao();
        }
        while(this.isJogoAcontecendo()){
            EventoRandomico evento = new EventoRandomico();
            atualizar.atualizarDados(lotes, loja, dinheiro, inventario);
            resumo.exibirResumoDiario(inventario, lotes, loja, dinheiro, evento);
            while(!this.isPulouDia()){
                escolhas.exibirEscolhas(scanner, loja, lotes, inventario, dinheiro);
            }
            Arquivo arquivo = new Arquivo();
            arquivo.perguntarSalvar(inventario,dinheiro,lotes,this,scanner, dias);
            setDias(getDias() + 1);
        }
        scanner.close();
    }
}
