package adapters;

public interface TransacaoAdapter extends SGBDAdapter {

    void beginTransaction();
    void commit();
    void rollback();

}
