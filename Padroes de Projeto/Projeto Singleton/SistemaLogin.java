import java.util.Scanner;
import java.util.Random;

public class SistemaLogin {
    
    private static SistemaLogin instance;
    private String usuario = "admin";
    private String senha = "159758";

    private SistemaLogin() {
    }

    public static SistemaLogin getInstance() {
        if (instance == null) {
            instance = new SistemaLogin();
        }
        return instance;
    }

    // Verificação anti-bot
    public boolean verificarBot() {
        Random random = new Random();
        int num1 = random.nextInt(10);
        int num2 = random.nextInt(10);
        int resultadoCorreto = num1 + num2;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Verificação anti-bot: Quanto é " + num1 + " + " + num2 + "?");
        int respostaUsuario = scanner.nextInt();

        return respostaUsuario == resultadoCorreto;
    }

    public boolean autenticar(String usuario, String senha) {

        if (usuario.equals(this.usuario) && senha.equals(this.senha)) {
            
            while (!verificarBot ()) {
                System.out.println("Verificação de bot falhou. Tente novamente.");
        }
            
            System.out.println("Acesso concedido!");
            return true;
        
        } else {
            System.out.println("Usuário ou senha incorretos. ");
            return false;      
                 
        }
    
    }
}
