public class Circunferencia {
    double raio;

    public Circunferencia(double raio) {
        this.raio = raio;
    }

    public double area() {
        return 2 * Math.PI * this.raio;
    }

    public double circunferencia() {
        return Math.PI * (this.raio * this.raio);
    }
}
