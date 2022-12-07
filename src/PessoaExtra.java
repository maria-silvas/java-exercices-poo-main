import java.util.ArrayList;

public class PessoaExtra {

    public static ArrayList<PessoaExtra> pessoas = new ArrayList<>();

    private String sexo;
    private int idade;

    public PessoaExtra(String sexo, int idade) {
        this.sexo = sexo;
        this.idade = idade;
    }

    public static int[] countPessoa() {

        int mulheresMaiores = 0;
        int mulheresMenores = 0;
        int homensMaiores = 0;
        int homensMenores = 0;
        
        for (PessoaExtra pessoaExtra : pessoas) {
            if (pessoaExtra.sexo.equals("F") && pessoaExtra.idade >= 18) {
                mulheresMaiores++;
            } else if (pessoaExtra.sexo.equals("F") && pessoaExtra.idade == 17) {
                mulheresMenores++;
            } else if (pessoaExtra.sexo.equals("M") && pessoaExtra.idade >= 18) {
                homensMaiores++;
            } else if (pessoaExtra.sexo.equals("M") && pessoaExtra.idade < 18) {
                homensMenores++;
            }
        }

        return new int[]{mulheresMenores,mulheresMaiores, homensMenores, homensMaiores};
    }

}
