import java.util.Scanner;

public class ExercicioUm {

    public static void call(Scanner scanner) {
        System.out.println("=== EXERCÍCIOS - LISTA 1 ===");

        System.out.println("+-------------------------------------------------------+");
        System.out.println("| 1 - Calcule a Média                                   |");
        System.out.println("| 2 - Calcule a Área                                    |");
        System.out.println("| 3 - Calcule o Volume                                  |");
        System.out.println("| 4 - Valor é maior que o dobro de outro valor          |");
        System.out.println("| 5 - Cálculo de Bhaskara                               |");
        System.out.println("| 6 - Velocidade Média                                  |");
        System.out.println("| 7 - Percentual de Imposto                             |");
        System.out.println("| 8 - Valor é par ou ímpar                              |");
        System.out.println("| 9 - Comparar dois valores de String                   |");
        System.out.println("| 10 - Valor double em string e convertido para inteiro |");
        System.out.println("| 11 - Imposto de renda de um salário                   |");
        System.out.println("| 12 - DESAFIO                                          |");
        System.out.println("+-------------------------------------------------------+");

        int menu = 0;
        try {
            menu = scanner.nextInt();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            menu = 0;
        }

        switch (menu) {
            // 1) Crie um programa que calcule a média (`(nota1 + nota2 + nota3 / 3)`)
            case 1:
                
                System.out.println("=== Calculo da média ===");

                System.out.println("Insira a 1º nota: "); 
                double notaUm = scanner.nextDouble();
                System.out.println("Insira a 2º nota: ");
                double notaDois = scanner.nextDouble();
                System.out.println("Insira a 3º nota: ");
                double notaTres = scanner.nextDouble();

                double media = media(notaUm, notaDois, notaTres);

                System.out.println(media);

                break;
            // 2) Crie um programa que calcule a área (`lado1 * lado2`)
            case 2:
                System.out.println("=== Calculo da área ===");
                System.out.println("Insira o 1º lado: ");
                double ladoUm = scanner.nextDouble();
                System.out.println("Insira o 2º lado: ");
                double ladoDois = scanner.nextDouble();

                double area = area(ladoUm, ladoDois);

                System.out.println(area);
                
                break;
            // 3) Crie um programa que calcule o volume (`largura * altura * profundidade`)
            case 3:
                System.out.println("=== Calculo do volume ===");
                System.out.println("Insira a largura: ");
                double largura = scanner.nextDouble();
                System.out.println("Insira a altura: ");
                double altura = scanner.nextDouble();
                System.out.println("Insira a profundidade: ");
                double profundidade = scanner.nextDouble();

                double volume = volume(largura, altura, profundidade);

                System.out.println(volume);

                break;
            // 4) Crie um programa que avalie se um valor é maior do que o dobro de outro valor
            case 4:
                System.out.println("=== Valor é maior do que o dobro de outro valor ===");
                System.out.println("Insira o 1º valor: ");
                double base = scanner.nextDouble();
                System.out.println("Insira o 2º valor: ");
                double verificar = scanner.nextDouble();
                
                boolean result = valorMaiorQueDobro(base, verificar);

                System.out.println(result);
                
                break;
            // 5) Crie um programa que calcule _bhaskara_
            case 5:
                System.out.println("=== Cálculo de Bhaskara ===");

                System.out.println("Insira o valor de A: ");
                int a = scanner.nextInt();
                System.out.println("Insira o valor de B");
                int b = scanner.nextInt();
                System.out.println("Insira o valor de C");
                int c = scanner.nextInt();

                System.out.println(bhaskara(a, b, c));

                break;
            // 6) Crie um programa que calcule a velocidade média de uma viagem (`distancia (km) / tempo (h)`)
            case 6:
                System.out.println("=== Velocidade Média ===");

                System.out.println("Insira a distância: ");
                double distancia = scanner.nextDouble();
                System.out.println("Insira o tempo: ");
                double tempo = scanner.nextDouble();

                double mediaViagem = mediaViagem(distancia, tempo);

                System.out.println(mediaViagem);

                break;
            // 7) Crie um programa que calcule o percentual de imposto pago (`faturamento \ qtd imposto`)
            case 7:
                System.out.println("=== Percentual de Imposto ===");

                System.out.println("Insira o faturamento: ");
                double faturamento = scanner.nextDouble();
                System.out.println("Insira a quantidade de imposto: ");
                double qtdImposto = scanner.nextDouble();

                double percImposto = percentualImposto(faturamento, qtdImposto);

                System.out.println(percImposto);

                break;
            // 8) Crie um programa que teste se um valor é par ou ímpar
            case 8:
                System.out.println("=== Valor é par ou ímpar ===");
                System.out.println("Insira o valor: ");
                int valor = scanner.nextInt();

                boolean parOuImpar = parOuImpar(valor);

                if (parOuImpar==false) {
                    System.out.println("É impar");
                } else {
                    System.out.println("É par");
                }

                break;
            // 9) Crie um programa que compare dois valores Strings
            case 9:
                System.out.println("=== Comparar dois valores de String ===");
                System.out.println("Insira o 1º valor: ");
                String stringUm = scanner.nextLine();
                System.out.println("Insira o 2º valor: ");
                String stringDois = scanner.nextLine();

                boolean compareString = compareString(stringUm, stringDois);

                if (compareString==true) {
                    System.out.println("São iguais!");
                } else {
                    System.out.println("Não são iguais!");
                }

                break;
            // 10) Crie um programa que tenha uma variável com ponto em String e converta seu valor para inteiro
            case 10:
                System.out.println("=== Converter String para Inteiro ===");

                System.out.println("Insira o valor: ");
                String valorString = scanner.nextLine();
                
                int valorInt = convertString(valorString);

                System.out.println("Valor convertido:" + valorInt);
                
                break;
            // 11) Crie um programa que receba o salário e diga o valor de imposto de renda conforme abaixo:
            // Base                     | Alíquota
            // ---------                | ------
            // Até 1.903,98             | Isento
            // De 1.903,99 até 2.826,65 | 7,5%
            // De 2.826,66 até 3.751,05 | 15%
            // De 3.751,06 até 4.664,68 | 22,5%
            // Acima de 4.664,68        | 27,5%
            case 11:
                System.out.println("=== Imposto de Renda ===");

                System.out.println("Insira o salário: ");
                double salario = scanner.nextDouble();
            
                double valorImposto = percentualImpostoSalario(salario);

                System.out.println(valorImposto);

                break;
            // DESAFIO - Crie um programa que teste se um número é primo
            case 12:
                System.out.println("=== Número é primo ===");

                System.out.println("Insira o número: ");
                int valorVerificar = scanner.nextInt();

                boolean testePrimo = testePrimo(valorVerificar);

                if (testePrimo==true) {
                    System.out.println("É primo");
                } else {
                    System.out.println("Não é primo");
                }
                
                break;
            default:
                System.out.println("Operação inválida");
                break;
        }
    }

    public static double media(double notaUm, double notaDois, double notaTres) {
        
        double media = (notaUm + notaDois + notaTres)/3;
        return media;
    }

    public static double area(double ladoUm, double ladoDois) {

        double area = ladoUm*ladoDois;        
        return area;
    }

    public static double volume(double largura, double altura, double profundidade) {

        double volume = largura*altura*profundidade;
        return volume;
    }

    public static boolean valorMaiorQueDobro(double base, double verificar) {

        if ((verificar*2)<base)
            return true;
        else 
            return false;
    }

    public static double[] bhaskara(int a, int b, int c) {
        
        double delta = (b*b) - (4*a*c);
        double raiz = Math.sqrt(delta);

        double[] x = new double[2];

        x[0] = ((b*(-1)) + raiz)/(2*a);
        x[1] = ((b*(-1)) - raiz)/(2*a);

        return x; 
    }

    public static double mediaViagem(double distancia, double tempo) {
        double velocidadeMedia = distancia/tempo;

        return velocidadeMedia;
    }

    public static double percentualImposto(double faturamento, double qtdImposto) {
        double percImposto = ((qtdImposto*100)/faturamento);

        return percImposto;
    }

    public static boolean parOuImpar(int valor) {
        if ((valor%2)==0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean compareString(String stringUm, String stringDois) {

        if (stringUm.equals(stringDois)) {
            return true;
        } else {
            return false;
        }
    }

    public static int convertString(String valor) {

        double valorDouble = Double.parseDouble(valor);

        int valorInt = (int) valorDouble;

        return valorInt;
    }

    public static double percentualImpostoSalario(double salario) {

        double imposto = 0;

        if (salario <= 1903.98) {
            imposto =  0.0;
        } else if (salario >= 1903.99 && salario <= 2826.65){
            imposto = 7.5; //salario*0.075
        } else if (salario >= 2826.66 && salario <= 3751.05) {
            imposto = 15;
        } else if (salario >= 3751.06 && salario <= 4664.68) {
            imposto = 22.5;
        } else if (salario >= 4664.69) {
            imposto = 27.5;
        }

        return imposto;
    }

    public static boolean testePrimo(int valor) {
        int count = 0;
        for (int i = 1; i <= valor; i++) {
            if (valor%i==0) {
                count++;
            }
        }

        if (count == 2) {
            return true;
        } else {
            return false;
        }
    }
}