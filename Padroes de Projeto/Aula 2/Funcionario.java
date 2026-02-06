public class Funcionario {
    private String nome;
    private double salarioBase;
    private double vendas;
    private double taxaComissao;

    public Funcionario(String nome, double salarioBase, double vendas, double taxaComissao) {
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.vendas = vendas;
        this.taxaComissao = taxaComissao;
    }
    
    public double comissao(){
        return vendas * taxaComissao;
    }

    public double calcSalario() {
        return salarioBase + comissao();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getVendas() {
        return vendas;
    }

    public void setVendas(double vendas) {
        this.vendas = vendas;
    }

    public double getTaxaComissao() {
        return taxaComissao;
    }

    public void setTaxaComissao(double taxaComissao) {
        this.taxaComissao = taxaComissao;
    }
    
}