import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o nome de usuário para autenticação: ");
        String usuario = scanner.nextLine();
        
        System.out.print("Digite a senha para autenticação: ");
        String senha = scanner.nextLine();

        SistemaLogin.getInstance().autenticar(usuario, senha);
    }

}
