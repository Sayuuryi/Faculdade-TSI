import adapters.PerfilUsuario;
import adapters.SGBDAdapter;
import adapters.TransacaoAdapter;

public class main {
    public static void main(String[] args) {

        PerfilUsuario perfil = new PerfilUsuario();

        System.out.println("\n Perfil Gratuito (Paradox) ");
        SGBDAdapter gratuito = perfil.getAdapter("Gratuito");
        gratuito.connect();
        gratuito.create();
        gratuito.read();
        gratuito.update();
        gratuito.delete();
        gratuito.disconnect();

        System.out.println("\n Perfil Básico (Firebird) ");
        SGBDAdapter basico = perfil.getAdapter("Basico");
        basico.connect();
        basico.connect(); // testando multi usuário
        basico.create();
        basico.disconnect();
        basico.disconnect();

        System.out.println("\n Perfil Ultimate (MySQL) ");
        TransacaoAdapter ultimate = (TransacaoAdapter) perfil.getAdapter("Ultimate");
        ultimate.connect();
        ultimate.beginTransaction();
        ultimate.create();
        ultimate.commit();
        ultimate.rollback(); // testando sem transação ativa
        ultimate.disconnect();

    }
}