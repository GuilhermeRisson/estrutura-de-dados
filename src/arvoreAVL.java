public class arvoreAVL {
    private noAVL raiz;

    public arvoreAVL() {
        this.raiz = null;
    }  

    private int altura(noAVL no) {
        if (no == null) {
            return 0;
        }
        return no.altura;
    }

    private noAVL inserir(noAVL no, int valor) {
        if (no == null) {
            return new noAVL(valor);
        } 

        if (valor < no.valor) {
            no.esquerda = inserir(no.esquerda, valor);
        } else {
            no.direita = inserir(no.direita, valor);
        }

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));

        int fatorBalanceamento = altura(no.esquerda) - altura(no.direita);
        
        if (fatorBalanceamento > 1 && valor < no.esquerda.valor) {
            return rotacaoDireita(no);
        }

        if (fatorBalanceamento < -1 && valor > no.direita.valor) {
            return rotacaoEsquerda(no);
        }

        if (fatorBalanceamento > 1 && valor > no.esquerda.valor) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }

        if (fatorBalanceamento < -1 && valor < no.direita.valor) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    private noAVL rotacaoDireita(noAVL y) {
        noAVL x = y.esquerda;
        noAVL T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    private noAVL rotacaoEsquerda(noAVL x) {
        noAVL y = x.direita;
        noAVL T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    public void inserir(int valor) {
        this.raiz = inserir(this.raiz, valor);
    }

    public boolean buscar(int valor) {
        return buscar(this.raiz, valor);
    }

    private boolean buscar(noAVL no, int valor) {
        if (no == null) {
            return false;
        }

        if (valor == no.valor) {
            return true;
        }

        if (valor < no.valor) {
            return buscar(no.esquerda, valor);
        } else {
            return buscar(no.direita, valor);
        }
    }
}
