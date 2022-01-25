import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class TP1 {

    public static String[][] temasPalavras = {
            {"ALIMENTO", "ARROZ", "PIZZA", "LASANHA", "CHURRASCO", "FEIJAO", "BATATA", "STROGONOFF", "SALADA", "MACARRAO", "SANDUICHE"},
            {"CIDADE", "BRASILIA", "LUZIANIA", "GOIANIA", "ANAPOLIS", "VALPARAISO", "GAMA", "CRISTALINA", "FORMOSA", "SOBRADINHO", "PLANALTINA"},
            {"ANIMAL", "CAVALO", "GATO", "CACHORRO", "ABELHA", "GALINHA", "PATO", "OVELHA", "SAPO", "URSO", "FOCA"},
            {"COR", "AZUL", "BRANCO", "VERMELHO", "VERDE", "PRETO", "ROSA", "LARANJA", "MARROM", "CINZA", "ROXO"},
            {"TESTE"},
            {"NOME", "LUCAS", "BIANCA", "FELIPE", "SIMONE", "SIDNEY", "INGRID", "JOAO", "JENIFER", "RAFAEL", "LETICIA"}};

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

        Scanner sc = new Scanner(System.in);
        char choose = sc.next().charAt(0);

        switch (choose) {
            case 'a':
                System.out.println("Qual tema deseja cadastrar?");
                sc.nextLine();
                String cadasTema = sc.nextLine().toUpperCase(Locale.ROOT);

                boolean achouTema = true;
                String[][] novoTemasPalavras = new String[temasPalavras.length + 1][];

                for (String[] temasPalavra : temasPalavras) {
                    achouTema = cadasTema.equals(temasPalavra[0]);
                }

                if (achouTema) {
                    System.out.println("Tema existente!");
                } else {
                    for (int i = 0, k = 0; i < novoTemasPalavras.length; i++) {
                        if (i < novoTemasPalavras.length - 1) {
                            novoTemasPalavras[k++] = temasPalavras[i];
                        } else {
                            novoTemasPalavras[k++] = new String[]{cadasTema};
                        }
                    }
                    temasPalavras = novoTemasPalavras;
                }

                for (String[] temasPalavra : temasPalavras) {
                    System.out.println(Arrays.toString(temasPalavra));
                }
                menu();
            case 'b':
                System.out.println("Qual tema deseja excluir?");
                for (int i = 0; i < temasPalavras.length; i++) {
                    System.out.println(i + 1 + ". " + temasPalavras[i][0]);
                }
                int tema = sc.nextInt();
                if (temasPalavras[tema - 1].length - 1 != 0) {
                    System.out.println("Não foi possível excluir o tema. Verifique se existem palavras cadastradas nesse tema");
                } else {
                    novoTemasPalavras = new String[temasPalavras.length - 1][];

                    for (int i = 0, k = 0; i < temasPalavras.length; i++) {
                        if (i != tema - 1) {
                            novoTemasPalavras[k++] = temasPalavras[i];
                        }
                    }
                    temasPalavras = novoTemasPalavras;
                    System.out.println("Tema excluído!");
                }
                menu();
            case 'c':
                System.out.println("Qual tema deseja buscar?");
                sc.nextLine();
                String checaTema = sc.nextLine().toUpperCase(Locale.ROOT);

                achouTema = true;

                for (String[] temasPalavra : temasPalavras) {
                    if (checaTema.equals(temasPalavra[0])) {
                        System.out.println("Tema existente!");
                        System.out.println(Arrays.toString(temasPalavra));
                        achouTema = true;
                    } else {
                        achouTema = false;
                    }
                }

                if (!achouTema) {
                    System.out.println("Tema não encontrado!");
                }

                menu();
            default:
                System.out.println("Opção Inválida");
                menu();
        }

        sc.close();
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
