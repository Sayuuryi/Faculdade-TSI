public class Engenheiro extends Funcionario{

    public Engenheiro(String nome, double salarioBase, double vendas, double taxaComissao) {
        super(nome, salarioBase, vendas, taxaComissao);
    }
    
    @Override
    public double calcSalario() {
        return getSalarioBase();
    }

    @Override
    public double comissao() {
        return 0;
    }
}
