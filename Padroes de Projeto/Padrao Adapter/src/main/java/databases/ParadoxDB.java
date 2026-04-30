package databases;

import adapters.SGBDAdapter;

public class ParadoxDB implements SGBDAdapter {

    private boolean usuarioConectado = false;

    @Override
    public void connect() {

        if (usuarioConectado) {
            System.out.println("❌ Erro: O usuário já está conectado.");
        } else {
            System.out.println("✅ Sucesso: usuário conectado com sucesso!");
            usuarioConectado = true;
        }

    }

    @Override
    public void disconnect() {

        if (usuarioConectado) {
            System.out.println("✅ Sucesso: usuário desconectado com sucesso!");
            usuarioConectado = false;
        } else {
            System.out.println("❌ Erro: O usuário não está conectado.");
        }

    }

    @Override
    public void create() {
        
        if (usuarioConectado) {
            System.out.println("✅ Sucesso: Registro no banco de dados criado com sucesso!");
        } else {
            System.out.println("❌ Erro: O usuário não está conectado.");
        }
    
    }

    @Override
    public void delete() {

        if (usuarioConectado) {
            System.out.println("✅ Sucesso: Registro no banco de dados deletado com sucesso!");
        } else {
            System.out.println("❌ Erro: O usuário não está conectado.");
        }

    }

    @Override
    public void read() {

        if (usuarioConectado) {
            System.out.println("✅ Sucesso: Registro no banco de dados exportado com sucesso ao console!");
        } else {
            System.out.println("❌ Erro: O usuário não está conectado.");
        }

    }

    @Override
    public void update() {

        if (usuarioConectado) {
            System.out.println("✅ Sucesso: Registro no banco de dados atualizado com sucesso!");
        } else {
            System.out.println("❌ Erro: O usuário não está conectado.");
        }

    }
    
}