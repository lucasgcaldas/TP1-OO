import java.util.*;

public class TP1 {

    static String[][] temasPalavras = new String[][]{
            {"ALIMENTO", "ARROZ", "PIZZA", "LASANHA", "CHURRASCO", "FEIJAO", "BATATA", "STROGONOFF", "SALADA", "MACARRAO", "SANDUICHE"},
            {"CIDADE", "BRASILIA", "LUZIANIA", "GOIANIA", "ANAPOLIS", "VALPARAISO", "GAMA", "CRISTALINA", "FORMOSA", "SOBRADINHO", "PLANALTINA"},
            {"ANIMAL", "CAVALO", "GATO", "CACHORRO", "ABELHA", "GALINHA", "PATO", "OVELHA", "SAPO", "URSO", "FOCA"},
            {"COR", "AZUL", "BRANCO", "VERMELHO", "VERDE", "PRETO", "ROSA", "LARANJA", "MARROM", "CINZA", "ROXO"},
            {"TESTE"},
            {"NOME", "LUCAS", "BIANCA", "FELIPE", "SIMONE", "SIDNEY", "INGRID", "JOAO", "JENIFER", "RAFAEL", "LETICIA"}};
    static String[][] novoTemasPalavras = new String[temasPalavras.length + 1][];
    static Scanner sc = new Scanner(System.in);
    static boolean achouTema = true;
    static int tema = 0;
    static String palavra = null;
    static int posI = 0, posJ = 0;
    static char choose;
    static String checaTema = "";

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.println("------------ Menu ------------");
        System.out.println("1. Gerenciar Temas");
        System.out.println("2. Gerenciar Palavras");
        System.out.println("3. Jogar");
        System.out.println("4. Sair");

        choose = sc.next().charAt(0);

        switch (choose) {
            case '1' -> gerenciarTemas();
            case '2' -> gerenciarPalavras();
            case '3' -> jogar();
            case '4' -> sair();
            default -> System.out.println("Opção Inválida");
        }

        sc.close();
    }

    public static void gerenciarTemas() {
        System.out.println("(a) Cadastro");
        System.out.println("(b) Exclusão");
        System.out.println("(c) Busca");

        choose = sc.next().charAt(0);

        switch (choose) {
            case 'a':
                cadastroTemas();
                menu();
            case 'b':
                exclusaoTemas();
                menu();
            case 'c':
                buscaTemas();
                menu();
            default:
                System.out.println("Opção Inválida");
                menu();
        }

        sc.close();
    }

    public static void cadastroTemas() {
        System.out.println("Qual tema deseja cadastrar?");
        sc.nextLine();
        String cadasTema = sc.nextLine().toUpperCase(Locale.ROOT);

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
    }

    public static void exclusaoTemas() {
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
    }

    public static void buscaTemas() {
        System.out.println("Qual tema deseja buscar?");
        sc.nextLine();
        checaTema = sc.nextLine().toUpperCase(Locale.ROOT);

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

    }

    public static void gerenciarPalavras() {
        System.out.println("(a) Cadastro");
        System.out.println("(b) Exclusão");
        System.out.println("(c) Busca");
        System.out.println("(d) Listagem");

        choose = sc.next().charAt(0);

        switch (choose) {
            case 'a':
                cadastroPalavra();
                menu();
            case 'b':
                exclusaoPalavra();
                menu();
            case 'c':
                buscaPalavra();
                menu();
            case 'd':
                listagemPalavra();
                menu();
            default:
                System.out.println("Opção Inválida");
                menu();
        }

        sc.close();
    }

    public static void cadastroPalavra() {
        System.out.println("Em qual tema deseja cadastrar uma palavra?");
        for (int i = 0; i < temasPalavras.length; i++) {
            System.out.println(i + 1 + ". " + temasPalavras[i][0]);
        }
        tema = sc.nextInt();

        System.out.println("Qual palavra deseja cadastrar?");
        sc.nextLine();
        palavra = sc.nextLine().toUpperCase();

        novoTemasPalavras = new String[temasPalavras.length][51];

        for (int i = 0; i < temasPalavras[tema - 1].length; i++) {
            if (Objects.equals(temasPalavras[tema - 1][i], palavra)) {
                System.out.println("Essa palavra ja existe! Tente cadastrar outra palavra.");
                gerenciarPalavras();
            } else {
                for (int j = 0; j < temasPalavras.length; j++) {
                    for (int k = 0; k < temasPalavras[j].length + 1; k++) {
                        if (j == tema - 1 && k <= temasPalavras[tema - 1].length + 1) {
                            if (k < temasPalavras[j].length) {
                                novoTemasPalavras[j][k] = temasPalavras[tema - 1][k];
                            } else {
                                novoTemasPalavras[j][k] = palavra;
                            }
                        } else {
                            if (k > temasPalavras[j].length && j == tema - 1) {
                                k--;
                                novoTemasPalavras[j][k] = temasPalavras[j][k];
                            } else if (k == temasPalavras[j].length) {
                                k--;
                                novoTemasPalavras[j][k] = temasPalavras[j][k];
                                break;
                            }
                            novoTemasPalavras[j][k] = temasPalavras[j][k];
                        }
                    }
                }
            }
        }

        temasPalavras = novoTemasPalavras;

        for (String[] temasPalavra : temasPalavras) {
            System.out.println(Arrays.toString(temasPalavra));
        }
    }

    public static void exclusaoPalavra() {
        System.out.println("Qual palavra deseja excluir?");
        sc.nextLine();
        palavra = sc.nextLine().toUpperCase();

        posI = 0;
        posJ = 0;

        for (int i = 0; i < temasPalavras.length; i++) {
            for (int j = 0; j < temasPalavras[i].length; j++) {
                if (temasPalavras[i][j].equals(palavra)) {
                    posI = i;
                    posJ = j;
                    break;
                }
            }
        }

        novoTemasPalavras = new String[temasPalavras.length][50];

        for (int i = 0; i < temasPalavras.length; i++) {
            for (int j = 0; j < temasPalavras[i].length; j++) {
                if (posI == i) {
                    if (posJ > j || posJ < j) {
                        novoTemasPalavras[posI][j] = temasPalavras[posI][j];
                    }
                } else {
                    novoTemasPalavras[i][j] = temasPalavras[i][j];
                }
            }
        }
        temasPalavras = novoTemasPalavras;
    }

    public static void buscaPalavra() {
        System.out.println("Qual palavra deseja buscar?");
        sc.nextLine();
        palavra = sc.nextLine().toUpperCase();

        boolean achou = true;

        for (int i = 0; i < temasPalavras.length; i++) {
            for (int j = 0; j < temasPalavras[i].length; j++) {
                if (temasPalavras[i][j].equals(palavra)) {
                    posI = i;
                    achou = true;
                    System.out.println("Palavra encontrada no tema " + temasPalavras[posI][0]);
                    break;
                } else {
                    achou = false;
                }
            }
        }

        if (!achou) {
            System.out.println("Palavra não encontrada");
        }
    }

    public static void listagemPalavra() {
        System.out.println("Em qual tema deseja ver todas as palavras cadastrada?");
        for (int i = 0; i < temasPalavras.length; i++) {
            System.out.println(i + 1 + ". " + temasPalavras[i][0]);
        }
        tema = sc.nextInt();

        System.out.println(Arrays.toString(temasPalavras[tema - 1]));
    }

    public static void jogar() {
        System.out.println("(a) Seleção de tema");
        System.out.println("(b) Sair");

        choose = sc.next().charAt(0);

        switch (choose) {
            case 'a':
                selecaoTemaJogar();
            case 'b':
                menu();
            default:
                System.out.println("Opção Inválida");
                menu();
        }
    }

    public static void selecaoTemaJogar() {
        System.out.println("Qual tema deseja buscar a palavra?");
        for (int i = 0; i < temasPalavras.length; i++) {
            System.out.println(i + 1 + ". " + temasPalavras[i][0]);
        }
        int tema = sc.nextInt() - 1;

        if (tema >= temasPalavras.length) {
            System.out.println("Tema inválido, tente novamente!");
        } else {
            jogoJogar(tema);
        }
    }

    public static void jogoJogar(int tema) {
        palavra = null;
        while (palavra == null) {
            Random random = new Random();
            int numRandom = random.nextInt((temasPalavras[tema].length - 2) + 1) + 1;

            palavra = temasPalavras[tema][numRandom];
        }

        boolean ganhou;
        boolean perdeu;
        int vida = 5;
        char[] acertos = new char[palavra.length()];

        for (int i = 0; i < acertos.length; i++) {
            acertos[i] = 0;

            if (palavra.charAt(i) == '-') {
                acertos[i] = 1;
            }
        }

        StringBuilder letrasUtilizadas = new StringBuilder();
        char letra;

        for (int i = 0; i < palavra.length(); i++) {
            if (acertos[i] == 1) {
                System.out.print(" - ");
            } else {
                System.out.print(" _ ");
            }
        }

        do {
            ganhou = true;
            perdeu = true;
            System.out.println();
            System.out.println("Total de vidas: " + vida);
            System.out.println("Letras utilizadas: " + letrasUtilizadas);
            System.out.println("Digite a letra");

            letra = sc.next().toUpperCase().charAt(0);

            while (letrasUtilizadas.toString().contains(String.valueOf(letra))) {
                System.out.println("Letra ja digitada. Digite outra letra!");
                letra = sc.next().toUpperCase().charAt(0);
            }

            letrasUtilizadas.append(" ").append(letra);

            for (int i = 0; i < palavra.length(); i++) {
                if (letra == palavra.charAt(i)) {
                    acertos[i] = letra;
                    perdeu = false;
                }
            }

            if (perdeu) {
                vida--;
            }

            for (int i = 0; i < palavra.length(); i++) {
                if (acertos[i] == 0) {
                    System.out.print(" _ ");
                    ganhou = false;
                } else {
                    ganhou = true;
                    System.out.print(" " + palavra.charAt(i) + " ");
                }
            }

            System.out.println();
        } while (!ganhou && vida > 0);

        if (vida != 0) {
            System.out.println("Parabéns! Você acertou a palavra! Deseja jogar novamente?");
            jogarNovamente();
        } else {
            System.out.println("Você perdeu! Deseja Deseja jogar novamente?");
            jogarNovamente();
        }
    }

    public static void jogarNovamente() {
        System.out.println("1. Sim");
        System.out.println("2. Não");

        choose = sc.next().charAt(0);

        switch (choose) {
            case '1' -> selecaoTemaJogar();
            case '2' -> menu();
            default -> System.out.println("Opção Inválida");
        }
    }

    public static void sair() {
        System.exit(1);
    }
}
