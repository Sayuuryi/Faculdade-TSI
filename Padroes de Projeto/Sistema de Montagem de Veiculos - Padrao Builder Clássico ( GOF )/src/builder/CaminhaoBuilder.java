package builder;

import produto.Veiculo;

public class CaminhaoBuilder implements VeiculoBuilder {
    
    private Veiculo veiculo = new Veiculo();

    @Override
    public void construirMotor() {
        veiculo.setMotor("Motor Diesel 6.0 Turbo");
    }

    @Override
    public void construirTransmissao() {
        veiculo.setTransmissao("Manual 12 marchas");
    }

    @Override
    public void construirPintura() {
        veiculo.setCor("Branco");
    }

    @Override
    public void construirRodas() {
        veiculo.setRodas("6 rodas aro 22");
    }

    @Override
    public Veiculo getVeiculo() {
        return veiculo;
    }
}
