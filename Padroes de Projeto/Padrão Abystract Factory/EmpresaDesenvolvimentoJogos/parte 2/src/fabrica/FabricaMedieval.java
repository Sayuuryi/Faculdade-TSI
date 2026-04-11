package fabrica;

import arma.*;
import personagem.*;
import transporte.*;

public class FabricaMedieval implements FabricaTema {

    @Override
    public Personagem criarPersonagem() {
        return new Cavaleiro();
    }

    @Override
    public Arma criarArma() {
        return new Espada();
    } 

    @Override
    public Transporte criarTransporte() {
        return new Cavalo();
    }

}