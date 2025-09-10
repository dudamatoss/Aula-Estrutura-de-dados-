public class Complexidade {

    private static int interacoes;
    private static int trocas;

    public static void bubbleSort(int[] vetor){
        int n = vetor.length;
        int interacoes = 0;
        int trocas = 0;
        double tempoInicial = System.nanoTime();

        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - 1 - i; j++){
                interacoes++;
                if(vetor[j] > vetor[j + 1]){
                    trocas++;
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }

        double tempoFinal = System.nanoTime();
        double tempo = tempoFinal - tempoInicial;
        double tempoSeg = tempo / 1_000_000_000;
        System.out.println("Numero de Interações: " + interacoes);
        System.out.println("Numero de Trocas: " + trocas);
        System.out.println("Tempo gasto em segundos: " + tempoSeg);

    }

    public static void selectionSort(int[] vetor){
        int n = vetor.length;
        int interacoes = 0;
        int trocas = 0;
        double tempoInicial = System.nanoTime();
        for(int i = 0; i < n -1; i++){
            int indiceMinimo = i;
            for(int j = i + 1; j < n; j++){
                interacoes++;
                if(vetor[j] < vetor[indiceMinimo]){
                    indiceMinimo = j;
                }
            }
            if(indiceMinimo != i){
                trocas++;
                int aux = vetor[indiceMinimo];
                vetor[indiceMinimo] = vetor[i];
                vetor[i] = aux;
            }
        }
        double tempoFinal = System.nanoTime();
        double tempo = tempoFinal - tempoInicial;
        double tempoSeg = tempo / 1_000_000_000;
        System.out.println("Numero de Interações: " + interacoes);
        System.out.println("Numero de Trocas: " + trocas);
        System.out.println("Tempo gasto em segundos: " + tempoSeg);
    }

    public static void insertionSort(int[] vetor){
        int n = vetor.length;
        int interacoes = 0;
        int trocas = 0;
        double tempoInicial = System.nanoTime();
        for(int i = 1; i < n; i++){
            int valor = vetor[i];
            int j = i - 1;

            while(j >= 0 && vetor[j] > valor){
                interacoes++;
                vetor[j + 1] = vetor[j];
                trocas++;
                j--;
            }
            if(j >= 0) {
                interacoes++;
            }
            vetor[j + 1] = valor;
            trocas++;
        }
        double tempoFinal = System.nanoTime();
        double tempo = tempoFinal - tempoInicial;
        double tempoSeg = tempo / 1_000_000_000;
        System.out.println("Numero de Interações: " + interacoes);
        System.out.println("Numero de Trocas: " + trocas);
        System.out.println("Tempo gasto em segundos: " + tempoSeg);
    }

    public static void mergeSort(int [] vetor){
        interacoes = 0;
        trocas = 0;
        double tempoInicial = System.nanoTime();
        mergeSort(vetor, 0, vetor.length - 1);
        double tempoFinal = System.nanoTime();
        double tempo = tempoFinal - tempoInicial;
        double tempoSeg = tempo / 1_000_000_000;
        System.out.println("Numero de Interações: " + interacoes);
        System.out.println("Numero de Trocas: " + trocas);
        System.out.println("Tempo gasto em segundos: " + tempoSeg);
    }

    private static void mergeSort(int [] vetor, int inicio, int fim){
        if (inicio < fim ){
            int meio = (inicio + fim)/2;
            mergeSort(vetor, inicio, meio);
            mergeSort(vetor, meio + 1, fim);
            merge(vetor, inicio, meio , fim);
        }
    }

    private static void merge(int [] vetor, int inicio, int meio, int fim) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        int[] esquerda = new int[n1];
        int[] direita = new int[n2];

        for (int i = 0; i < n1; i++)
            esquerda[i] = vetor[inicio + i];
        for (int j = 0; j < n2; j++)
            direita[j] = vetor[meio + 1 + j];

        int i = 0, j = 0;
        int k = inicio;
        while (i < n1 && j < n2) {
            interacoes++;
            if (esquerda[i] <= direita[j]) {
                vetor[k] = esquerda[i];
                i++;
            } else {
                vetor[k] = direita[j];
                j++;
            }
            trocas++;
            k++;
        }
        while (i < n1) {
            vetor[k] = esquerda[i];
            i++;
            k++;
            trocas++;
        }

        while (j < n2) {
            vetor[k] = direita[j];
            j++;
            k++;
            trocas++;
        }
    }

    public static void quickSort(int[] vetor){
        interacoes = 0;
        trocas = 0;
        double tempoInicial = System.nanoTime();
        quickSort(vetor, 0, vetor.length - 1);
        double tempoFinal = System.nanoTime();
        double tempo = tempoFinal - tempoInicial;
        double tempoSeg = tempo / 1_000_000_000;
        System.out.println("Numero de Interações: " + interacoes);
        System.out.println("Numero de Trocas: " + trocas);
        System.out.println("Tempo gasto em segundos: " + tempoSeg);
    }

    private static void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = particionar(vetor, inicio, fim);
            quickSort(vetor, inicio, indicePivo - 1);
            quickSort(vetor, indicePivo + 1, fim);
        }
    }

    private static int particionar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[fim];
        int i = (inicio - 1);

        for (int j = inicio; j < fim; j++) {
            interacoes++;
            if (vetor[j] <= pivo) {
                i++;
                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
                trocas++;
            }
        }
        int temp = vetor[i + 1];
        vetor[i + 1] = vetor[fim];
        vetor[fim] = temp;
        trocas++;

        return i + 1;
    }

}