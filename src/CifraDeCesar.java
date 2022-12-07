public class CifraDeCesar {

    String mensagem;
    int seed;
    
    public CifraDeCesar(String mensagem, int seed) {
        this.mensagem = mensagem;
        this.seed = seed;
    }

    public String mensagemCifrada() {

        String mensagem = this.mensagem;
        int valor = 0;
        if (this.seed < 27) {
            valor = this.seed;
        } else {
            valor = this.seed - 26;
        }

        int i, n = mensagem.length();
        String saux = "";

        for (i=0; i<n; i++) {
            saux = saux + (char)(mensagem.charAt(i) + valor);
        }

        return(saux);
    }
    
}
