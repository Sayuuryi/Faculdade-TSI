package builder;

import produto.Veiculo;

public class MotoBuilder implements VeiculoBuilder {
    
    private Veiculo veiculo = new Veiculo();

    @Override
    public void construirMotor() {
        veiculo.setMotor("Motor 300cc");
    }

    @Override
    public void construirTransmissao() {
        veiculo.setTransmissao("Manual 6 marchas");
    }

    @Override
    public void construirPintura() {
        veiculo.setCor("Preto");
    }

    @Override
    public void construirRodas() {
        veiculo.setRodas("2 rodas aro 18");
    }

    @Override
    public Veiculo getVeiculo() {
        return veiculo;
    }
    
}
