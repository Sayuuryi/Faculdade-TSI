public class Diretor extends Funcionario implements Autenticavel {
    private String senha;

    public Diretor(String nome, double salarioBase, double vendas, double taxaComissao, String senha) {
        super(nome, salarioBase, vendas, taxaComissao);
        this.senha = senha;
    }

    @Override
    public double calcSalario() {
        return getSalarioBase() + comissao() + 5000; 
    }

    @Override
    public boolean autenticar(String usuario, String senha) {
        return this.senha.equals(senha);
    }

}