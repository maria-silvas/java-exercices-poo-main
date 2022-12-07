import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ExercicioExtra {

    public static void call(Scanner scanner) {
        System.out.println("=== EXERCÍCIOS - LISTA EXTRA ===");

        System.out.println("+-------------------------------------------------------+");
        System.out.println("| 01 - Palindromo                                       |");
        System.out.println("| 02 - Juros                                            |");
        System.out.println("| 03 - Fibonacci                                        |");
        System.out.println("| 04 - Inteiro para Binário                             |");
        System.out.println("| 05 - Tabuada e Sequencia                              |");
        System.out.println("| 06 - Data de Nascimento (Anos, Meses, Dias)           |");
        System.out.println("| 07 - Número Sorteado                                  |");
        System.out.println("| 08 - Pirâmide                                         |");
        System.out.println("| 09 - Sexo e Idade                                     |");
        System.out.println("| 10 - Adivinhar Número                                 |");
        System.out.println("+-------------------------------------------------------+");

        int menu = 0;
        try {
            menu = scanner.nextInt();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            menu = 0;
        }

        switch (menu) {
            // 1) Escreva um programa que determine se uma cadeia de caracteres é um palíndromo ou não. Um palíndromo é uma cadeia que é igual à sua inversa.
            case 1:
                String palavra = "A base do teto desaba";
                System.out.println(palindromo(palavra));
                break;
            /* 2) Um banco realiza empréstimos nas seguintes condições:
             *  * são tomados “P” reais emprestados;
             *  * “A” reais serão pagos cada mês até que o empréstimo seja quitado; 
             *  * parte do pagamento mensal serão juros, calculados como "i" por cento do saldo corrente; 
             *  * o restante será aplicado no pagamento da dívida.
             *  Escreva um programa que leia estes três valores: P, A, i e determine:
             *  * Para cada mês:
             *  a) valor em dinheiro dos juros pagos;
             *  b) valor em dinheiro aplicada no pagamento da dívida;
             *  c) valor acumulado de juros já pagos;
             *  d) valor ainda por pagar do empréstimo no fim de cada mês;
             *  * No final do programa:
             *  e) número de meses necessários para pagar o empréstimo;
             *  f) quantidade da última prestação.
             */                
            case 2:
                double p = 1000;
                double a = 200;
                double i = 1.5;
                juros(p, a, i);
                break;
            // 3) Escreva um programa que carregue um carregue um número inteiro pelo teclado e indique se ele faz parte da sequência de Fibonacci.
            case 3:
                int number = 10;
                isFibonacci(number);
                break;
            // 4) Escreva um programa que leia um número inteiro e mostre a sua conversão em binário.
            case 4:
                number = 10;
                toBinary(number);
                break;
            /*
             * 5) Escreva um programa que mostre um menu com as seguintes opções: 
             * 1 – Tabuada, 2 – Sequencia, 3 Sair. 
             * Ao escolher a opção 1, o usuário deve digitar 
             * um número entre 1 e 10 (nem maior, nem menor) e o programa exibirá a tabuada desse número (use um laço).
             *  Ex: 2 x 1 = 2 2 x 2 = 4...
             *  Ao escolher a opção 2, o programa pede para o usuário 
             * digitar dois valores e mostra todos os números entre eles.
             *  Ex: Digitou 5 e 15, o programa mostra: 5, 6, 7, 8, 9, 10, 11 ,12 ,13, 14, 15
             *  Ao escolher a opção 3, o programa encerra. Se escolher qualquer outra opção que não essas, mostre uma mensagem de erro “opção inválida”.
             */
            case 5:
                System.out.println("1 - Tabuada");
                System.out.println("2 - Sequencia");
                System.out.println("3 - Sair");
                number = scanner.nextInt();
                int valor = 0;
                if (number == 1) {
                    do {
                        System.out.println("Digite um número entre 1 e 10");
                        valor = scanner.nextInt();
                    } while (valor < 1 || valor > 10);
                    tabuadaESequencia(number);
                } else {
                    System.out.println("Digite o primeiro valor");
                    int first = scanner.nextInt();
                    System.out.println("Digite o segundo valor");
                    int last = scanner.nextInt();
                    tabuadaESequencia(first, last);
                }
                break;
            // 6) Escreva um programa que leia a data de nascimento de uma pessoa e mostre-a expressa em dias, meses e anos.
            case 6:
                String dataString = "27-09-2000";
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");      
                Date dataNascimento;
                try {
                    dataNascimento = formatter.parse(dataString);
                    int[] datas = printDataDeNascimento(dataNascimento);
                    System.out.println("Dias: " + datas[0]);
                    System.out.println("Meses: " + datas[1]);
                    System.out.println("Anos: " + datas[2]);
                } catch (ParseException e) {
                    e.printStackTrace();
                } 
                
                break;
            // 7) Escreva um programa que receba dois valores e sorteie um número entre eles.
            case 7:
                int min = 1;
                int max = 10;
                sortNumber(min, max);
                break;
            /*
             * 8) Escreva uma pirâmide de números conforme um número informado. Exemplo: Número 11
             *  01 <br>
             *  02 02 <br>
             *  03 03 03 <br>
             *  04 04 04 04 <br>
             *  05 05 05 05 05 <br>
             *  06 06 06 06 06 06 <br>
             *  07 07 07 07 07 07 07 <br>
             *  08 08 08 08 08 08 08 08 <br>
             *  09 09 09 09 09 09 09 09 09 <br>
             *  10 10 10 10 10 10 10 10 10 10 <br>
             *  11 11 11 11 11 11 11 11 11 11 11<br>
             */
            case 8:
                piramid(11);
                break;
            // 9) Escreva um programa que pergunte o sexo e a idade
            // de uma lista indeterminada de pessoas. 
            // O usuário deverá informar a quantidade de pessoas e ao 
            // final deverá imprimir a quantidade de homens e mulheres maiores e menores de idade
            case 9:
                countPessoas();
                break;
            // 10) Escreva um programa que sorteie um número de 0 a 100 e que permita tentar
            // acertar este número, o programa só irá parar ao acertar.
            // A cada tentativa, deverá exibir se o número é maior ou menor do que o informado.
            case 10:
                sortNumber();
                break;
            default:
                System.out.println("Operação inválida");
                break;
        }

    }
    
    public static boolean palindromo(String palavra) {

        String palavraInvertida = new StringBuilder(palavra).reverse().toString().replace(" ", "");
        System.out.println(palavraInvertida);

        if ((palavra.replace(" ", "")).equalsIgnoreCase(palavraInvertida)) {
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<Double[]> juros(double p, double a, double i) {
        return new ArrayList<Double[]>();
    }

    public static boolean isFibonacci(int number) {

        // fibonacci algorithm
        int n1 = 0;
        int n2 = 1;
        int n3 = 0;

        while (n3 < number) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }

        if (n3 == number) {
            return true;
        } else {
            return false;
        }

    }

    public static String toBinary(int number) {

        // binary algorithm
        String binary = "";
        int resto = 0;

        while (number > 0) {
            resto = number % 2;
            number = number / 2;
            binary = resto + binary;
        }

        return binary;

    }

    public static void tabuadaESequencia(int number) {
        int[] tabuada = new int[10];
        for (int i = 0; i < 10; i++) {
            tabuada[i] = number * (i+1);
            System.out.print(number + " x " + (i+1) + " = " + tabuada[i] + "\n");
        }
    }

    public static void tabuadaESequencia(int first, int last) {
        for (int i = first; i <= last; i++) {
            System.out.print(i + "\n");
        }
    }

    public static int[] printDataDeNascimento(Date dataNascimento) {

        Calendar dataAtual = Calendar.getInstance();
        Calendar dataNascimentoCalendar = Calendar.getInstance();
        dataNascimentoCalendar.setTime(dataNascimento);

        int anoAtual = dataAtual.get(Calendar.YEAR);
        int anoNascimento = dataNascimentoCalendar.get(Calendar.YEAR);

        int mesAtual = dataAtual.get(Calendar.MONTH);
        int mesNascimento = dataNascimentoCalendar.get(Calendar.MONTH);

        int diaAtual = dataAtual.get(Calendar.DAY_OF_MONTH);
        int diaNascimento = dataNascimentoCalendar.get(Calendar.DAY_OF_MONTH);

        int idadeEmAnos = anoAtual - anoNascimento;

        if (mesAtual < mesNascimento) {
            idadeEmAnos--;
        } else if (mesAtual == mesNascimento) {
            if (diaAtual < diaNascimento) {
                idadeEmAnos--;
            }
        }

        int idadeEmMeses = idadeEmAnos * 365;
        int idadeEmDias = idadeEmMeses * 12;

        return new int[] {idadeEmDias, idadeEmMeses, idadeEmAnos};
    }

    public static int sortNumber(int min, int max) {

        Random random = new Random();
        int number = random.nextInt(max - min + 1) + min;

        return number;
    }

    public static void piramid(int number) {
        
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == i)
                    System.out.print(String.format("%02d", i));
                else
                    System.out.print(String.format("%02d", i) + " ");
            }
            System.out.print("\n");
        }
    }

    public static void countPessoas() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe a quantidade de pessoas: ");
        int quantidadePessoas = scanner.nextInt();

        PessoaExtra pessoa;

        for (int i = 0; i < quantidadePessoas; i++) {
            System.out.println("Informe o sexo da pessoa: ");
            String sexo = scanner.next();
            System.out.println("Informe a idade da pessoa: ");
            int idade = scanner.nextInt();

            pessoa = new PessoaExtra(sexo, idade);
        }
        
            int[] dados = PessoaExtra.countPessoa();
            System.out.println(dados[0]);
            System.out.println(dados[1]);
            System.out.println(dados[2]);
            System.out.println(dados[3]);

        scanner.close();
    }

    public static void sortNumber() {
     
        Scanner scanner = new Scanner(System.in);
        int number = sortNumber(0, 100);
        int tentativa = 0;
        int tentativaAnterior = 0;
        int tentativaAtual = 0;
        boolean acertou = false;

        while (!acertou) {
            System.out.println("Informe um número: ");
            tentativa = scanner.nextInt();
            tentativaAtual = tentativa;
            if (SortNumber.isNumber(tentativaAtual)) {
                acertou = true;
            } else if (tentativa > SortNumber.getSortedNumber()) {
                System.out.println("O número é menor");
            } else {
                System.out.println("O número é maior");
            }
            tentativaAnterior = tentativaAtual;
        }

        System.out.println("Você acertou o número " + number + " em " + tentativa + " tentativas");
        scanner.close();
    }
}
