public class Pessoa {
    String nome;
    double peso;
    double altura;
    String dataNascimento;

    public Pessoa(String nome, double peso, double altura, String dataNascimento) {
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
        this.dataNascimento = dataNascimento;
    }
    public double imc() {
        return this.peso/(this.altura*this.altura);
    }

    public String imcTexto() {

        double imc = this.imc();
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc < 25) {
            return "Peso normal";
        } else if (imc < 30) {
            return "Sobrepeso";
        } else if (imc < 35) {
            return "Obesidade Grau I";
        } else if (imc < 40) {
            return "Obesidade Grau II";
        } else {
            return "Obesidade Grau III";
        }
    }
    
    public String toString() {
        return "{" +
            " nome='" + nome + "'" +
            ", peso='" + peso + "'" +
            ", altura='" + altura + "'" +
            ", dataNascimento='" + dataNascimento + "'" +
            "}";
    }
}
