import java.util.Scanner;

public class TP1 {
    public static void main(String[] args) {

        String[][] temasPalavras = {
                {"ALIMENTO", "ARROZ", "PIZZA", "LASANHA", "CHURRASCO", "FEIJAO", "BATATA", "STROGONOFF", "SALADA", "MACARRAO", "SANDUICHE"},
                {"CIDADE", "BRASILIA", "LUZIANIA", "GOIANIA", "ANAPOLIS", "VALPARAISO", "GAMA", "CRISTALINA", "FORMOSA", "SOBRADINHO", "PLANALTINA"},
                {"ANIMAL", "CAVALO", "GATO", "CACHORRO", "ABELHA", "GALINHA", "PATO", "OVELHA", "SAPO", "URSO", "FOCA"},
                {"COR", "AZUL", "BRANCO", "VERMELHO", "VERDE", "PRETO", "ROSA", "LARANJA", "MARROM", "CINZA", "ROXO"},
                {"NOME", "LUCAS", "BIANCA", "FELIPE", "SIMONE", "SIDNEY", "INGRID", "JOAO", "JENIFER", "RAFAEL", "LETICIA"}};

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
            case 1 -> gerenciarTemas();
            case 2 -> gerenciarPalavras();
            case 3 -> jogar();
            case 4 -> sair();
            default -> System.out.println("Opção Inválida");
        }

        sc.close();
    }

    public static void gerenciarTemas() {
        System.out.println("(a) Cadastro");
        System.out.println("(b) Exclusão");
        System.out.println("(c) Busca");


    }

    public static void gerenciarPalavras() {
        System.out.println("(a) Cadastro");
        System.out.println("(b) Exclusão");
        System.out.println("(c) Busca");
        System.out.println("(d) Listagem");
    }

    public static void jogar() {
        System.out.println("(a) Seleção de tema");
        System.out.println("(b) Jogo");
        System.out.println("(c) Jogar novamente");
        System.out.println("(d) Sair");

    }

    public static void sair() {
        System.exit(1);
    }
}
