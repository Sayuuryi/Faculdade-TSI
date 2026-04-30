package adapters;

import databases.FirebirdDB;
import databases.MySQLDB;
import databases.ParadoxDB;

public class PerfilUsuario {

    public SGBDAdapter getAdapter(String perfil) {

        switch (perfil) {
            case "Gratuito":
                return new ParadoxDB();
            case "Basico":
                return new FirebirdDB();
            case "Ultimate":
                return new MySQLDB();
            default:
                System.out.println("❌ Erro: Perfil inválido!");
                return null;

        }

    }

}
