class Hotel {

    private PagamentoCartao pagamento = new PagamentoCartao();

    public void realizarPagamento() {
        pagamento.pagar();
    }

}