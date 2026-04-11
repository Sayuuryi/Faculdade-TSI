package fabrica;

import arma.*;
import personagem.*;
import transporte.*;

public class FabricaFantasia implements FabricaTema {

    @Override
    public Personagem criarPersonagem() {
        return new Mago();
    }

    @Override
    public Arma criarArma() {
        return new Cajado();
    }

    @Override
    public Transporte criarTransporte() {
        return new Vassoura();
    }

}