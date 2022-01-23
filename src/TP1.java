import java.util.Scanner;

public class TP1 {
    public static void main(String[] args) {

        menu();
    }

    public static void menu() {
        System.out.println("------------ Menu ------------");
        System.out.println("1. Gerenciar Temas");
        System.out.println("2. Gerenciar Palavras");
        System.out.println("3. Jogar");
        System.out.println("4. Sair");

        Scanner sc = new Scanner(System.in);
        int choose = sc.nextInt();

        switch (choose) {
            case 1:
                gerenciarTemas();
                break;
            case 2:
                gerenciarPalavras();
                break;
            case 3:
                jogar();
                break;
            case 4:
                sair();
                break;
            default:
                System.out.println("Opção Inválida");
        }
    }

    public static void gerenciarTemas() {

    }

    public static void gerenciarPalavras() {

    }

    public static void jogar() {

    }

    public static void sair() {

    }
}
