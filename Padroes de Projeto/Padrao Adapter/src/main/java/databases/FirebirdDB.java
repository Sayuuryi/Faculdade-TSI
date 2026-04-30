package databases;

import adapters.SGBDAdapter;

public class FirebirdDB implements SGBDAdapter {
    
    private int usuariosConectados = 0;

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

}
