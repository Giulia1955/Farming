package Fazenda;

import Fazenda.Animais.Animal;
import Fazenda.Animais.Galinha;
import Fazenda.Plantas.Planta;

/**
 * Representa um evento aleatório que pode ocorrer durante o jogo.
 * Esses eventos podem afetar diretamente os recursos da fazenda.
 *
 * Exemplos: prenhez de animais, devolução de empréstimos, etc.
 *
 * @author SeuNome
 * @version 1.0
 */
public class EventoRandomico {

    /**
     * Construtor padrão.
     */
    public EventoRandomico() {}

    /**
     * Executa um evento aleatório com base no valor sorteado.
     *
     * @param ValorRand o valor que determina qual evento será executado
     * @param Dia o dia atual do jogo
     * @param dinheiro o objeto que representa o dinheiro do jogador
     */
    public void executarEvento(int ValorRand, int Dia, Dinheiro dinheiro) {
        switch (ValorRand) {
            case 0: VacaPrenha(Dia); break;
            case 1: OvelhaPrenha(Dia); break;
            case 2: GalinhaChoca(Dia); break;
            case 3: Emprestimo(dinheiro); break;
        }
    }

    /**
     * Evento de prenhez de vaca.
     * @param Dia o dia atual
     * @return o novo dia com atraso de parto
     */
    public int VacaPrenha(int Dia) {
        System.out.println("Há uma vaca prenha! Reserve espaço para o novo membro da fazenda!");
        return Dia + 2;
    }

    /**
     * Evento de prenhez de ovelha.
     * @param Dia o dia atual
     * @return o novo dia com atraso de parto
     */
    public int OvelhaPrenha(int Dia) {
        System.out.println("Há uma ovelha prenha! Reserve espaço para o novo membro da fazenda!");
        return Dia + 2;
    }

    /**
     * Evento de galinha chocando ovos.
     * @param Dia o dia atual
     * @return o novo dia com atraso de nascimento
     */
    public int GalinhaChoca(int Dia) {
        System.out.println("Há uma galinha chocando ovos! Reserve espaço para os novos membros da fazenda!");
        return Dia + 2;
    }

    /**
     * Evento de recebimento de empréstimo.
     *
     * @param dinheiro o objeto de controle financeiro
     */
    public void Emprestimo(Dinheiro dinheiro) {
        System.out.println("Um vizinho devolveu um empréstimo de R$ 150,00 que você havia esquecido.");
        dinheiro.setValor(dinheiro.getValor() + 150.0);
    }
}
