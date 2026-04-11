package fabrica;

import arma.*;
import personagem.*;

public class FabricaMedieval implements FabricaTema {

    @Override
    public Personagem criarPersonagem() {
        return new Cavaleiro();
    }

    @Override
    public Arma criarArma() {
        return new Espada();
    }

}