package builder;

import produto.Veiculo;

public interface VeiculoBuilder {
    
    void construirMotor();
    void construirTransmissao();
    void construirPintura();
    void construirRodas();
    
    Veiculo getVeiculo();
}
