class Concessionaria extends Hotel {

    @Override
    public void vender() {
        throw new UnsupportedOperationException("Concessionaria nao vende apartamentos!");
    }

}