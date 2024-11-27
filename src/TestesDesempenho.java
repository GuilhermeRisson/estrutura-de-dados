import java.util.Random;

public class TestesDesempenho {
    private static final int[] TAMANHOS = {100, 1000, 10000};
    private static final int REPETICOES = 5;

    public static void main(String[] args) {
        for (int tamanho : TAMANHOS) {
            System.out.println("\n=== Testes para tamanho: " + tamanho + " ===");
            realizarTestes(tamanho);
        }
    }

    private static void realizarTestes(int tamanho) {
        
        int[] dadosOrdenados = gerarDadosOrdenados(tamanho);
        int[] dadosInversos = gerarDadosInversos(tamanho);
        int[] dadosAleatorios = gerarDadosAleatorios(tamanho);

        System.out.println("\n--- Testes com dados ORDENADOS ---");
        testarTodasEstruturas(dadosOrdenados, "ordenada");
        
        System.out.println("\n--- Testes com dados INVERSOS ---");
        testarTodasEstruturas(dadosInversos, "inversa");
        
        System.out.println("\n--- Testes com dados ALEATÓRIOS ---");
        testarTodasEstruturas(dadosAleatorios, "aleatória");
    }

    private static void testarTodasEstruturas(int[] dados, String tipo) {
        testarVetor(dados, tipo);
        testarArvoreBinaria(dados, tipo);
        testarArvoreAVL(dados, tipo);
    }

    private static void testarVetor(int[] dados, String tipo) {
        System.out.println("\nTestes com Vetor - Inserção " + tipo + ":");
        
       
        long mediaInsercao = 0;
        long mediaBuscaPrimeiro = 0;
        long mediaBuscaMeio = 0;
        long mediaBuscaUltimo = 0;
        long mediaBuscaInexistente = 0;

        for (int i = 0; i < REPETICOES; i++) {
            vetor v = new vetor(dados.length);
            
           
            long inicio = System.nanoTime();
            for (int num : dados) {
                v.adicionar(num);
            }
            long fim = System.nanoTime();
            mediaInsercao += (fim - inicio);

            
            inicio = System.nanoTime();
            v.buscaSequencial(dados[0]); 
            fim = System.nanoTime();
            mediaBuscaPrimeiro += (fim - inicio);

            inicio = System.nanoTime();
            v.buscaSequencial(dados[dados.length/2]); 
            fim = System.nanoTime();
            mediaBuscaMeio += (fim - inicio);

            inicio = System.nanoTime();
            v.buscaSequencial(dados[dados.length-1]); 
            fim = System.nanoTime();
            mediaBuscaUltimo += (fim - inicio);

            inicio = System.nanoTime();
            v.buscaSequencial(-1);
            fim = System.nanoTime();
            mediaBuscaInexistente += (fim - inicio);
        }

        System.out.printf("Média tempo de inserção: %.3f ms%n", (mediaInsercao/REPETICOES) / 1_000.0);
        System.out.printf("Média busca primeiro elemento: %.3f ms%n", (mediaBuscaPrimeiro/REPETICOES) / 1_000.0);
        System.out.printf("Média busca elemento meio: %.3f ms%n", (mediaBuscaMeio/REPETICOES) / 1_000.0);
        System.out.printf("Média busca último elemento: %.3f ms%n", (mediaBuscaUltimo/REPETICOES) / 1_000.0);
        System.out.printf("Média busca elemento inexistente: %.3f ms%n", (mediaBuscaInexistente/REPETICOES) / 1_000.0);
    }

    private static void testarArvoreBinaria(int[] dados, String tipo) {
        System.out.println("\nTestes com Árvore Binária - Inserção " + tipo + ":");
        
        long mediaInsercao = 0;
        long mediaBuscaPrimeiro = 0;
        long mediaBuscaMeio = 0;
        long mediaBuscaUltimo = 0;
        long mediaBuscaInexistente = 0;

        for (int i = 0; i < REPETICOES; i++) {
            arvoreBinaria arvore = new arvoreBinaria();
            
            long inicio = System.nanoTime();
            for (int num : dados) {
                arvore.inserir(num);
            }
            long fim = System.nanoTime();
            mediaInsercao += (fim - inicio);

        
            inicio = System.nanoTime();
            arvore.buscar(dados[0]);
            fim = System.nanoTime();
            mediaBuscaPrimeiro += (fim - inicio);

            inicio = System.nanoTime();
            arvore.buscar(dados[dados.length/2]);
            fim = System.nanoTime();
            mediaBuscaMeio += (fim - inicio);

            inicio = System.nanoTime();
            arvore.buscar(dados[dados.length-1]);
            fim = System.nanoTime();
            mediaBuscaUltimo += (fim - inicio);

            inicio = System.nanoTime();
            arvore.buscar(-1);
            fim = System.nanoTime();
            mediaBuscaInexistente += (fim - inicio);
        }

        System.out.printf("Média tempo de inserção: %.3f ms%n", (mediaInsercao/REPETICOES) / 1_000.0);
        System.out.printf("Média busca primeiro elemento: %.3f ms%n", (mediaBuscaPrimeiro/REPETICOES) / 1_000.0);
        System.out.printf("Média busca elemento meio: %.3f ms%n", (mediaBuscaMeio/REPETICOES) / 1_000.0);
        System.out.printf("Média busca último elemento: %.3f ms%n", (mediaBuscaUltimo/REPETICOES) / 1_000.0);
        System.out.printf("Média busca elemento inexistente: %.3f ms%n", (mediaBuscaInexistente/REPETICOES) / 1_000.0);
    }

    private static void testarArvoreAVL(int[] dados, String tipo) {
        System.out.println("\nTestes com Árvore AVL - Inserção " + tipo + ":");
        
        long mediaInsercao = 0;
        long mediaBuscaPrimeiro = 0;
        long mediaBuscaMeio = 0;
        long mediaBuscaUltimo = 0;
        long mediaBuscaInexistente = 0;

        for (int i = 0; i < REPETICOES; i++) {
            arvoreAVL arvore = new arvoreAVL();
            
            
            long inicio = System.nanoTime();
            for (int num : dados) {
                arvore.inserir(num);
            }
            long fim = System.nanoTime();
            mediaInsercao += (fim - inicio);

        
            inicio = System.nanoTime();
            arvore.buscar(dados[0]);
            fim = System.nanoTime();
            mediaBuscaPrimeiro += (fim - inicio);

            inicio = System.nanoTime();
            arvore.buscar(dados[dados.length/2]);
            fim = System.nanoTime();
            mediaBuscaMeio += (fim - inicio);

            inicio = System.nanoTime();
            arvore.buscar(dados[dados.length-1]);
            fim = System.nanoTime();
            mediaBuscaUltimo += (fim - inicio);

            inicio = System.nanoTime();
            arvore.buscar(-1);
            fim = System.nanoTime();
            mediaBuscaInexistente += (fim - inicio);
        }

        System.out.printf("Média tempo de inserção: %.3f ms%n", (mediaInsercao/REPETICOES) / 1_000.0);
        System.out.printf("Média busca primeiro elemento: %.3f ms%n", (mediaBuscaPrimeiro/REPETICOES) / 1_000.0);
        System.out.printf("Média busca elemento meio: %.3f ms%n", (mediaBuscaMeio/REPETICOES) / 1_000.0);
        System.out.printf("Média busca último elemento: %.3f ms%n", (mediaBuscaUltimo/REPETICOES) / 1_000.0);
        System.out.printf("Média busca elemento inexistente: %.3f ms%n", (mediaBuscaInexistente/REPETICOES) / 1_000.0);
    }

    private static int[] gerarDadosOrdenados(int tamanho) {
        int[] dados = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            dados[i] = i;
        }
        return dados;
    }

    private static int[] gerarDadosInversos(int tamanho) {
        int[] dados = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            dados[i] = tamanho - i - 1;
        }
        return dados;
    }

    private static int[] gerarDadosAleatorios(int tamanho) {
        int[] dados = new int[tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            dados[i] = random.nextInt(tamanho * 10);
        }
        return dados;
    }
} 