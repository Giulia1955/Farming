package Fazenda.Itens;
import Fazenda.Plantas.Planta;
/**
 * Representa a {@code sementeMilho}, que é um tipo de {@link Item} produzido por plantas de Milho.
 * Vem como uma única unidade de semente e pode ser vendida pelo jogador.
 *
 * Esta classe define um item com preço fixo e nome padrão.
 *
 * @author Giulia
 * @version 1.0
 */


public class sementeMilho extends Item {
    public sementeMilho(){
        /**
         * Construtor da classe {@code sementeMilho}.
         * Inicializa uma semente de milho com valor fixo, descrição e nome padrão.
         */
        super (5, "sementes de milho", "Semente Milho");
    }


}
