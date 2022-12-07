import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ExercicioDois {


    public static void call(Scanner scanner) {
        System.out.println("=== EXERCÍCIOS - LISTA 2 ===");

        System.out.println("+-------------------------------------------------------+");
        System.out.println("| 1 - Calcule a Média                                   |");
        System.out.println("| 2 - Mês do Ano                                        |");
        System.out.println("| 3 - Forca                                             |");
        System.out.println("| 4 - Tabuada                                           |");
        System.out.println("| 5 - Letra a Letra                                     |");
        System.out.println("| 6 - Número ímpares multiplos de 7                     |");
        System.out.println("| 7 - Calcule a Média de Notas informadas               |");
        System.out.println("| 8 - Fatorial                                          |");
        System.out.println("| 9 - Calculo IMC                                       |");
        System.out.println("| 10 - Operadores                                       |");
        System.out.println("| 11 - DESAFIO                                          |");
        System.out.println("+-------------------------------------------------------+");

        int menu = 0;
        try {
            menu = scanner.nextInt();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            menu = 0;
        }

        Scanner sc = new Scanner(System.in);

        switch (menu) {
            // 1) Crie um programa que receba três notas calcule a média e diga se foi aprovado (`(nota1 + nota2 + nota3 / 3)`) e (`média maior que 7 para ser aprovado`).
            case 1:

                System.out.println("Insira suas três notas para verificar o resultado final:");
                double notaUm = sc.nextDouble();
                double notaDois = sc.nextDouble();
                double notaTres = sc.nextDouble();

                double media = calculaMedia(notaUm, notaDois, notaTres);

                if (media > 7) {
                    System.out.println("Você foi aprovado!");
                } else {
                    System.out.println("Você foi reprovado!");
                }

                break;
            // 2) Crie um programa que receba um número e indique o mês que representa.
            case 2:
                System.out.println("Insira o numero correspondente ao mês:");
                int mes = sc.nextInt();

                System.out.println(qualMes(mes));

                break;
            /* 3) Crie um programa que simule um jogo da forca, com a entrada da palavra oculta, a quantidade de tentativas para acerto e depois solicite a entrada da palavra. 
                A cada erro deve imprimir a quantidade de tentativas restantes e o 'membro' que foi marcado. Ao final deve imprimir se acertou ou não a palavra e se foi 'enforcado'. */
            case 3:
                System.out.println("======= Jogo da Forca =======");
                System.out.println("Insira a palavra oculta:");
                String palavraOculta = sc.nextLine();
                System.out.print("\033[H\033[2J"); /*Apagar o terminal*/
                System.out.flush();
                
                System.out.println("OK. Serão 7 tentativas para acertar sua palavra oculta!");
                int tentativas = 7;

                int tamanhoPalavra = palavraOculta.length();
                String letrasOcultas = new String(new char[tamanhoPalavra]).replace("\0","*");

                System.out.println(letrasOcultas);

                System.out.print("Vamos começar inserindo uma letra: ");
                String letra = sc.nextLine();
                
                while (tentativas > 0 && letrasOcultas.contains("*")) {
                    int index = palavraOculta.indexOf(letra);
                    if (index == -1) {
                        tentativas--;
                        System.out.println("Letra incorreta! Você ainda tem " + tentativas + " tentativas.");
                    } else {
                        letrasOcultas = letrasOcultas.substring(0, index) + letra + letrasOcultas.substring(index + 1);
                        System.out.println(letrasOcultas);
                    }
                    if (letrasOcultas.contains("*")) {
                        System.out.print("Insira uma nova letra: ");
                        letra = sc.nextLine();
                    }
                }

                if (tentativas == 0) {
                    System.out.println("Você foi enforcado! A palavra era: " + palavraOculta);
                } else {
                    System.out.println("Parabéns! Você acertou a palavra: " + palavraOculta);
                }

                break;
            // 4) Crie um programa que imprima a tabuada de 0 a 10.
            case 4:
                System.out.println("Insira o número para ver a tabuada:");
                int numero = sc.nextInt();

                tabuada(numero);
                break;
            // 5) Crie um programa que receba uma String e imprima linha a linha suas letras.
            case 5:
                
                System.out.println("Insira a palavra a ser separada:");
                String palavra = sc.nextLine();
                
                letraALetra(palavra);
                break;
            // 6) Crie um programa que de a soma de todos os números ímpares e múltiplos de 7 entre 1 e 500.
            case 6:
                System.out.println("A soma de todos os números ímpares e múltiplos de 7 entre 1 e 500 é" + numerosImpares());
                break;
            // 7) Crie um programa que tenha como entrada as notas de um aluno. Somente se encerrará quando for inserida uma nota negativa. Ao final deverá informar a média das notas.
            case 7:
                double nota = 0.0;
                ArrayList<Double> notas = new ArrayList<>();

                while (nota >= 0) {
                    System.out.println("Insira a nota do aluno: ");
                    nota = sc.nextDouble();
                    
                    notas.add(nota);
                }
                
                break;
            // 8) Crie um programa que receba um valor e imprima o fatorial desse número. Ex.: 3! = 3 x 2 x 1 = 6.
            case 8:

                System.out.println("Insira um numero para calcular o fatorial:");
                int number = sc.nextInt();

                fatorial(number);
                break;
            // 9) Crie um programa que receba a altera e o peso e calcule o IMC:
            // 
            // IMC | Classificação
            // --- | ------
            // Abaixo de 18,5 | Abaixo do Peso
            // Entre 18,6 e 24,9 | Peso Ideal
            // Entre 25,0 e 29,9 | Levemente acima do peso
            // Entre 30,0 e 34,9 | Obesidade Grau I
            // Entre 35,0 e 39,9 | Obesidade Grau II
            // Acima de 40 | Obesidade Grau III (mórbida)
            case 9:

                System.out.println("Insira a altura:");
                double altura = sc.nextDouble();
                System.out.println("Insira o peso:");
                double peso = sc.nextDouble();
                double imc = imc(altura, peso);

                if (imc > 18.5) {
                    System.out.println("Abaixo do peso");
                } else if (imc >= 18.6 && imc <= 24.9) {
                    System.out.println("Peso Ideal");
                } else if (imc >= 25.0 && imc <= 29.9){
                    System.out.println("Levemente acima do peso");
                } else if (imc >= 30.0 && imc <= 34.9){
                    System.out.println("Obesidade Grau I");
                } else if (imc >= 35.0 && imc <= 39.9){
                    System.out.println("Obesidade Grau II");
                } else if (imc >= 40.0){
                    System.out.println("Obesidade Grau III (mórbida)");
                }

                break;
            // 10) Crie um programa que receba dois valores e solicite a operação a ser realizada (+ - * /). Ao final imprima o resultado.
            case 10:
                System.out.println("Insira o primeiro numero:");
                int valorUm = sc.nextInt();
                System.out.println("Insira o segundo numero:");
                int valorDois = sc.nextInt();
                System.out.println("Insira a operação (+ - * /):");
                char operacao = sc.next().charAt(0);
                operador(valorUm, valorDois, operacao);

                break;
            // DESAFIO: Crie um programa que receba um valor em reais e determine qual o mínimo de notas necessárias para entregá-lo. <br> Notas: R$ 200, R$ 100, R$ 50, R$ 10, R$ 5, R$ 1 <br> Exemplo: R$ 15 -> 1 nota de R$ 10 e 1 nota de R$ 5
            case 11:
                System.out.println("Insira o valor em reais:");
                int valor = sc.nextInt();
                String valorString = Arrays.toString(notasNecessarias(valor));

                System.out.println(valorString);

                break;
            default:
                System.out.println("Operação inválida");
                break;

        }

        sc.close();
    }

    public static double calculaMedia(double notaUm, double notaDois, double notaTres) {

        double media = (notaUm + notaDois + notaTres)/3;

        return media;
    }

    public static String qualMes(int mes) {

        String mesString = "";
        switch (mes) {
            case 1:
                mesString = "Janeiro";
                break;
            case 2: 
                mesString = "Fevereiro";
                break;
            case 3:
                mesString = "Março"; 
                break;
            case 4: 
                mesString = "Abril";
                break;
            case 5: 
                mesString = "Maio";
                break;
            case 6: 
                mesString = "Junho";
                break;
            case 7: 
                mesString = "Julho";
                break;
            case 8: 
                mesString = "Agosto";
                break;
            case 9: 
                mesString = "Setembro";
                break;
            case 10: 
                mesString = "Outubro";
                break;
            case 11: 
                mesString = "Novembro";
                break;
            case 12: 
                mesString = "Dezembro";
                break;
            default:
                break;
        }
        return mesString;
    }

    public static int[] tabuada(int numero) {

        int[] tabuada = new int[10];

        for (int i = 0; i < 10; i++) {
            tabuada[i] = numero * (i+1);
            System.out.println(numero + " x " + (i+1) + " = " + tabuada[i]);
        }

        return tabuada;
    }

    public static char[] letraALetra(String palavra) {

        char[] letras = new char[palavra.length()];

        for (int i = 0; i < palavra.length(); i++) {
            letras[i] = palavra.charAt(i);
            System.out.println(letras[i]);
        }

        return letras;
    }

    public static int numerosImpares() {
        int soma = 0;

        for (int i = 1; i <= 500; i++) {
            if ((i%2 != 0)&&(i%7==0)) {
                soma += i;
            }
        }

        return soma;
    }

    public static double calculaMedia(double[] notas) {

        double sum = 0;

        for (int i = 0; i < notas.length; i++) {
            sum += notas[i];
        }

        return sum/notas.length;
    }

    public static int fatorial(int numero) {

        int fatorial = numero;

        System.out.print("Fatorial: " + numero + "! = ");

        for (int i = 1; i < numero; i++) {
            fatorial *= i;
            System.out.println(i + (i != 1 ? "x" : ""));
        }
        System.out.println("=");
        return fatorial;
    }

    public static double imc(double altura, double peso) {

        double imc = peso / (altura * 2);

        return imc;
    }

    public static double operador(int valorUm, int valorDois, char operacao) {

        double resultado = 0;

        switch (operacao) {
            case '+':
                resultado = valorUm + valorDois;
                break;
            case '-':
                resultado = valorUm - valorDois;
                break;
            case '*':
                resultado = valorUm * valorDois;
                break;
            case '/':
                resultado = valorUm / valorDois;
                break;
            default:
                System.out.println("Operação inválida");
                break;
        }

        return resultado;
    }

    public static int[] notasNecessarias(int valor) {

        double[] notas = new double[] { 200, 100, 50, 10, 5, 1 };
        int[] valorNotas = new int[6];

        for (int i = 0; i < notas.length; i++) {
            valorNotas[i] = (int) (valor/notas[i]);
            valor -= valorNotas[i] * notas[i];
        }

        return valorNotas;
    }
}
