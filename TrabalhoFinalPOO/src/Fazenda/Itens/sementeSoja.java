package Fazenda.Itens;
import Fazenda.Plantas.Planta;
/**
 * Representa a {@code sementeSoja}, que é um tipo de {@link Item} produzido por plantas de Soja.
 * Vem como uma única unidade de semente e pode ser vendida pelo jogador.
 *
 * Esta classe define um item com preço fixo e nome padrão.
 *
 * @author Giulia
 * @version 1.0
 */


public class sementeSoja extends Item {
    public sementeSoja(){
        /**
         * Construtor da classe {@code sementeSoja}.
         * Inicializa uma semente de soja com valor fixo, descrição e nome padrão.
         */
        super (7, "sementes de soja", "Semente Soja");
    }
}
