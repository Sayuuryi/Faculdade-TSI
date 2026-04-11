package fabrica;

import personagem.Personagem;
import arma.Arma;

public interface FabricaTema {

    Personagem criarPersonagem();
    Arma criarArma();

}