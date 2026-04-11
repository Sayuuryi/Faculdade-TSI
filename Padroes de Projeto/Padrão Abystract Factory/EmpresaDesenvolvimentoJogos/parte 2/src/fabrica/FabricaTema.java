package fabrica;

import arma.Arma;
import personagem.Personagem;
import transporte.Transporte;

public interface FabricaTema {

    Personagem criarPersonagem();
    Arma criarArma();
    Transporte criarTransporte();

}