public class Secretario extends Funcionario{

    public Secretario(String nome, double salarioBase, double vendas, double taxaComissao) {
        super(nome, salarioBase, vendas, taxaComissao);
    }

    @Override
    public double calcSalario() {
        return getSalarioBase();
    }
}
