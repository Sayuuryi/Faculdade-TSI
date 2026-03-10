class CorretoHotel {

    private Pagamento pagamento;

    public CorretoHotel(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void realizarPagamento() {
        pagamento.pagar();
    }

}