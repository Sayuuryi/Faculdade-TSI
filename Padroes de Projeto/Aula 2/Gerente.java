public class Gerente extends Funcionario implements Autenticavel {

    public Gerente(String nome, double salarioBase, double vendas, double taxaComissao, String senha) {
        super(nome, salarioBase, vendas, taxaComissao);
    }

    @Override
    public double calcSalario() {
        return getSalarioBase() + comissao() + 3000; 
    }

    @Override
    public boolean autenticar(String usuario, String senha) {
        return false;
    }
}