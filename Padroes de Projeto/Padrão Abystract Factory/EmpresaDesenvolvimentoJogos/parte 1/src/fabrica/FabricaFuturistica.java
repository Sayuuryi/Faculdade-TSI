package fabrica;

import arma.*;
import personagem.*;

public class FabricaFuturistica implements FabricaTema {

    @Override
    public Personagem criarPersonagem() {
        return new Androide();
    }

    @Override
    public Arma criarArma() {
        return new Laser();
    }

}