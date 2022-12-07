import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ExercicioTres {
    public static void call(Scanner scanner) throws IOException {
        System.out.println("=== EXERCÍCIOS - LISTA 3 ===");

        System.out.println("+-------------------------------------------------------+");
        System.out.println("| 1 - Tabuada com Arquivo                               |");
        System.out.println("| 2 - Ler e imprimir arquivo de texto                   |");
        System.out.println("| 3 - Operações básicas com a Main                      |");
        System.out.println("| 4 - Exponenciação com Precisão Arbitrária             |");
        System.out.println("| 5 - Nome aleatório de 5 pessoas                       |");
        System.out.println("| 6 - Calcular Raio e Área                              |");
        System.out.println("| 7 - Avaliar se TXT tem JAVA                           |");
        System.out.println("| 8 - 10 primeiros dígitos                              |");
        System.out.println("| 9 - Área com a Main                                   |");
        System.out.println("| 10 - Receba nome de arquivo na Main com valores       |");
        System.out.println("| 11 - Ler e imprimir arquivo de texto                  |");
        System.out.println("+-------------------------------------------------------+");

        int menu = 0;
        try {
            menu = scanner.nextInt();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            menu = 0;
        }

        switch (menu) {
            // 1) Crie um programa que receba um valor e calcule a tabuada deste valor, salvando seu resultado em um arquivo de texto.
            case 1:
                System.out.println("Insira um número para calcular a tabuada: ");
                int numero = scanner.nextInt();
                tabuada(numero);

                System.out.println("Tabuada salva em arquivo de texto na pasta \\txt");
                break;
            // 2) Crie um programa que leia e imprima no console todas as linhas de um arquivo de texto.
            case 2:
                System.out.println("Lendo arquivo de texto na pasta \\txt");
                String arquivo = "src/archives/arquivo_para_leitura.txt";
                lerArquivoTexto(arquivo);

                break;
            // 3) Crie um programa que receba como entrada da classe Main dois valores numéricos e calcule as operações básicas com eles.
            case 3:
                System.out.println("Insira dois números para calcular as operações básicas: ");
                int numeroUm = scanner.nextInt();
                int numeroDois = scanner.nextInt();
                operacoesBasicas(numeroUm, numeroDois);

                break;
            // 4) Crie um programa que execute uma operação de Exponenciação com o valor inteiro com precisão arbitrária.
            case 4:
                System.out.println("Insira um número para calcular a exponenciação: ");
                BigInteger base = scanner.nextBigInteger();
                System.out.println("Insira o expoente: ");
                int pow = scanner.nextInt();

                System.out.println("Resultado: " + bigIntExpo(base, pow));
                
                break;
            // 5) Crie um programa que receba o nome de 5 pessoas e aleatorize eles.
            case 5:

                String[] nomes = new String[5];

                System.out.println("Insira 5 nomes para gerar um nome aleatório: ");
                
                for (int i = 0; i < 5; i++) {
                    System.out.println("Nome " + (i + 1) + ": ");
                    nomes[i] = scanner.nextLine();
                }

                aleatorizarPessoas(nomes);
                break;
            // 6) Crie um programa que calcule o raio e a área de uma circunferência (`C = 2πr` e `A = π(r²)`).
            case 6:
                System.out.println("Insira o raio da circunferência: ");
                double raio = scanner.nextDouble();

                System.out.println(areaECircunferencia(raio));;

                break;
            // 7) Crie um programa que avalie se um arquivo de texto possui a string "JAVA".
            case 7:
                System.out.println("Insira o caminho do arquivo para verificar se possui JAVA: ");
                String caminho = scanner.nextLine();
                hasJava(caminho);

                if (hasJava(caminho) == true) {
                    System.out.println("O arquivo possui JAVA");
                } else {
                    System.out.println("O arquivo não possui JAVA");
                }

                break;
            // 8) Crie um programa que leia as linhas de um arquivo e imprima no console apenas os 10 primeiros digitos de cada linha.
            case 8:
                System.out.println("Insira o caminho do arquivo para ler os 10 primeiros dígitos: ");
                String caminhoArquivo = scanner.nextLine();
                dezDigitos(caminhoArquivo);
                
                break;
            // 9) Crie um programa que receba como entrada da classe Main dois valores numéricos e calcule a área dos valores (`area = lado1 * lado2`).
            case 9:
                System.out.println("Insira dois números para calcular a área: ");
                int localUm = scanner.nextInt();
                int localDois = scanner.nextInt();
                
                System.out.println("Área: " + calculaArea(localUm, localDois));

                break;
            // 10) Crie um programa que receba como entrada da classe Main o nome de um arquivo de texto que contenha valores numéricos e some todos os valores, imprimindo no console a soma.
            case 10:
                System.out.println("Insira o caminho do arquivo para somar os valores: ");
                String caminhoArquivoSoma = scanner.nextLine();
                
                System.out.println("Soma: " + somaValoresArquivo(caminhoArquivoSoma));
                break;
            // ## DESAFIO - Crie um Jogo da Forca com Arquivos de Texto**
            case 11:
                // forcaComTxt();
                break;
            default:
                System.out.println("Operação inválida");
                break;
        }
        
    }

    public static void tabuada(int numero) throws IOException {

        FileWriter arquivo = new FileWriter("exercicio_tres_tabuada.txt");
        PrintWriter gravarArquivo = new PrintWriter(arquivo);
        
        int[] tabuada = new int[10];
        for (int i = 0; i < 10; i++) {
            tabuada[i] = numero * (i+1);
            gravarArquivo.println(numero + " x " + (i+1) + " = " + tabuada[i]);
        }

        arquivo.close();
    }

    public static void lerArquivoTexto(String arquivo) throws FileNotFoundException {

        Scanner arq = new Scanner(new FileReader(arquivo));
        String linha = "";

        while (arq.hasNextLine()) {
            linha = arq.nextLine();
            System.out.print(linha + "\n");
        }

    }

    public static int[] operacoesBasicas(int numeroUm, int numeroDois) {

        int[] operacoes = new int[4];

        operacoes[0] = numeroUm + numeroDois;
        operacoes[1] = numeroUm - numeroDois;
        operacoes[2] = numeroUm * numeroDois;
        operacoes[3] = numeroUm / numeroDois;

        return operacoes;
    }

    public static BigInteger bigIntExpo(BigInteger base, int pow) {

        BigInteger resultado = base.pow(pow);

        return resultado;
    }

    public static void aleatorizarPessoas(String pessoas[]) {

        List <String> lista = Arrays.asList(pessoas);

        Collections.shuffle(lista);
        lista.toArray(pessoas);

        System.out.println("Lista Emabaralhada: " + Arrays.toString(pessoas));
        
    }

    public static double[] areaECircunferencia(double raio) {
        //`C = 2πr` e `A = π(r²)`)
        double[] areaECircunferencia = new double[2];

        areaECircunferencia[0] = (2 * Math.PI) * raio;
        areaECircunferencia[1] = Math.PI * Math.pow(raio, 2);

        return areaECircunferencia;
    }

    public static boolean hasJava(String arquivo) throws FileNotFoundException {

        Scanner text = new Scanner(new FileReader(arquivo));

        while (text.hasNextLine()) {
            String linha = text.nextLine();
            if (linha.contains("JAVA")) {
                return true;
            }
        }

        return false;
    }

    public static void dezDigitos(String arquivo) throws FileNotFoundException {

        Scanner text = new Scanner(new FileReader(arquivo));
        String linha = "";
        while (text.hasNextLine()) {
            linha = linha + text.nextLine();
        }
        
        System.out.print(linha.substring(0, 9) + "\n");
    }

    public static double calculaArea(double numeroUm, double numeroDois) {

        double area = numeroUm * numeroDois;

        return area;
    }

    public static double somaValoresArquivo(String arquivo) throws FileNotFoundException {

        Scanner valores = new Scanner(new FileReader(arquivo));
        double soma = 0;

        while (valores.hasNextLine()) {
            String linha = valores.nextLine();
            double valor = Double.parseDouble(linha);
            soma += valor;
        }

        return soma;
    }

    public static void forcaComTxt() {
        
    }
}