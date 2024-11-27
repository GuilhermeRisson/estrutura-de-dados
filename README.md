# Análise de Estruturas de Dados

## Descrição
Este projeto implementa e compara o desempenho de diferentes estruturas de dados (Vetor, Árvore Binária e Árvore AVL) em operações de inserção e busca com diferentes conjuntos de dados (ordenados, inversos e aleatórios).

## Pré-requisitos
- Java JDK 8 ou superior
- IDE Java

## Instalação

1. Clone o repositório
2. Abra o projeto em sua IDE preferida

## Como executar

Para executar os testes de desempenho:


## Estrutura do Projeto
src/
├── App.java # Classe principal
├── TestesDesempenho.java # Implementação dos testes de performance
├── Ordenacao.java # Algoritmos de ordenação (BubbleSort e QuickSort)
├── vetor.java # Implementação da estrutura Vetor
├── arvoreBinaria.java # Implementação da Árvore Binária
├── arvoreAVL.java # Implementação da Árvore AVL
├── no.java # Classe nó para Árvore Binária
└── noAVL.java # Classe nó para Árvore AVL

## Estruturas Implementadas

### Vetor
- Implementação básica de um vetor com busca sequencial e binária
- Métodos: adicionar(), buscaSequencial(), buscaBinaria()

### Árvore Binária
- Implementação de uma árvore binária de busca
- Métodos: inserir(), buscar()

### Árvore AVL
- Implementação de uma árvore AVL (árvore binária balanceada)
- Métodos: inserir(), buscar()
- Inclui rotações para manter o balanceamento

## Testes de Desempenho

O projeto inclui testes comparativos entre as estruturas com:
- Diferentes tamanhos de entrada (100, 1000, 10000 elementos)
- Diferentes tipos de dados:
  - Ordenados
  - Inversos
  - Aleatórios
- Métricas medidas:
  - Tempo de inserção
  - Tempo de busca (primeiro elemento)
  - Tempo de busca (elemento do meio)
  - Tempo de busca (último elemento)
  - Tempo de busca (elemento inexistente)

## Algoritmos de Ordenação
- BubbleSort: implementação do algoritmo básico de ordenação
- QuickSort: implementação do algoritmo avançado de ordenação

## Autor
Guilherme Risson
