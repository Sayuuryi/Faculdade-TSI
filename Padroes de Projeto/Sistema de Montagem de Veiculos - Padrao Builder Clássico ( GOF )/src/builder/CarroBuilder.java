package builder;

import produto.Veiculo;

public class CarroBuilder implements VeiculoBuilder {

    private Veiculo veiculo = new Veiculo();
    
    @Override
    public void construirMotor() {
        veiculo.setMotor("Motor 2.0 Flex");
    }

    @Override
    public void construirTransmissao() {
        veiculo.setTransmissao("Automática 6 marchas");
    }

    @Override
    public void construirPintura() {
        veiculo.setCor("Vermelho");
    }

    @Override
    public void construirRodas() {
        veiculo.setRodas("4 rodas aro 17");
    }

    @Override
    public Veiculo getVeiculo() {
        return veiculo;
    }
    
}
