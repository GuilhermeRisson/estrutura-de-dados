public class arvoreBinaria {
    private no raiz;

    public arvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(int valor) {
        this.raiz = inserirRecursivo(this.raiz, valor);
    }

    private no inserirRecursivo(no no, int valor) {
        if (no == null) {
            return new no(valor);
        }

        if (valor < no.valor) {
            no.esquerda = inserirRecursivo(no.esquerda, valor);
        } else {
            no.direita = inserirRecursivo(no.direita, valor);
        }

        return no;
    }

    public boolean buscar(int valor) {
        return buscarRecursivo(this.raiz, valor);
    }

    private boolean buscarRecursivo(no no, int valor) {
        if (no == null) {
            return false;
        }

        if (no.valor == valor) {
            return true;
        }

        if (valor < no.valor) {
            return buscarRecursivo(no.esquerda, valor);
        } else {
            return buscarRecursivo(no.direita, valor);
        }
    }   
}
