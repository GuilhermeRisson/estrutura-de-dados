import java.util.ArrayList;
public class vetor {
    private int[] elementos;
    private int tamanho;

    public vetor(int capacidade) {
        this.elementos = new int[capacidade];
        this.tamanho = 0;
    }

    public void adicionar(int elemento) {
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
        } else {
            throw new IllegalArgumentException("Vetor cheio");
        }
    }

    public int buscaSequencial(int elemento) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i] == elemento) {
                return i;
            }
        }
        return -1;
    }

    public int buscaBinaria(int elemento) {
        int inicio = 0;
        int fim = this.tamanho - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (this.elementos[meio] == elemento) {
                return meio;
            } else if (this.elementos[meio] < elemento) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        throw new IllegalArgumentException("Não encontrado	");
    }
}
