package diretor;

import builder.VeiculoBuilder;

public class Diretor {

    private VeiculoBuilder builder;

    public Diretor(VeiculoBuilder builder) {
        this.builder = builder;
    }

    public void construir() {
        builder.construirMotor();
        builder.construirTransmissao();
        builder.construirPintura();
        builder.construirRodas();
    }
    
}