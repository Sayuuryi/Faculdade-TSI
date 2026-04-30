package databases;

import adapters.TransacaoAdapter;

public class MySQLDB implements TransacaoAdapter {
    
    private int usuariosConectados = 0;
    private boolean transacaoAtiva = false;

    @Override
    public void connect() {
        usuariosConectados++;
        System.out.println("✅ Sucesso: usuário conectado! Total conectados: " + usuariosConectados);

    }

    @Override
    public void disconnect() {

        if (usuariosConectados > 0) {
            System.out.println("✅ Sucesso: usuário desconectado com sucesso!");
            usuariosConectados--;
        } else {
            System.out.println("❌ Erro: O usuário não está conectado.");
        }

    }

    @Override
    public void create() {
        
        if (usuariosConectados > 0) {
            System.out.println("✅ Sucesso: Registro no banco de dados criado com sucesso!");
        } else {
            System.out.println("❌ Erro: O usuário não está conectado.");
        }
    
    }

    @Override
    public void delete() {

        if (usuariosConectados > 0) {
            System.out.println("✅ Sucesso: Registro no banco de dados deletado com sucesso!");
        } else {
            System.out.println("❌ Erro: O usuário não está conectado.");
        }

    }

    @Override
    public void read() {

        if (usuariosConectados > 0) {
            System.out.println("✅ Sucesso: Registro no banco de dados exportado com sucesso ao console!");
        } else {
            System.out.println("❌ Erro: O usuário não está conectado.");
        }

    }

    @Override
    public void update() {

        if (usuariosConectados > 0) {
            System.out.println("✅ Sucesso: Registro no banco de dados atualizado com sucesso!");
        } else {
            System.out.println("❌ Erro: O usuário não está conectado.");
        }

    }

    @Override
    public void beginTransaction() {

        if (usuariosConectados > 0 && transacaoAtiva == false) {
            transacaoAtiva = true;
            System.out.println("✅ Sucesso: Sua transação foi iniciada!");
        } else {
            System.out.println("❌ Erro: Não foi possível concluir sua transação.");
        }

    }

    @Override
    public void commit() {

        if (usuariosConectados > 0 && transacaoAtiva == true ) {
            System.out.println("✅ Sucesso: Transação confirmada! Alterações salvas no banco.");
            transacaoAtiva = false;

        } else {
            System.out.println("❌ Erro: Não há nenhuma transação ativa no momento!");
        }

    }

    @Override
    public void rollback() {
        if (usuariosConectados > 0 && transacaoAtiva == true ) {
            transacaoAtiva = false;
            System.out.println("✅ Sucesso: Transação cancelada! Alterações desfeitas.");
        } else {
            System.out.println("❌ Erro: Não há nenhuma transação ativa para cancelar!");
        }
    }

    

}

