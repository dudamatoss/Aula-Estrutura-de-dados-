public class Complexidade {

    public static void bubbleSort(int[] vetor){
        int n = vetor.length;
        int interacoes = 0;
        int trocas = 0;
        double tempoInicial = System.nanoTime();


        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - 1 - i; j++){
                interacoes ++;
                if(vetor[j] > vetor[j + 1]){
                    trocas ++;
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }

        double tempoFinal = System.nanoTime();
        double tempo =  tempoInicial - tempoFinal;
        double tempoSeg = tempo / 1_000_000_000;
        System.out.println("Numero de Interações: " + interacoes);
        System.out.println("Numero de Trocas: " + trocas);
        System.out.println("Tempo gasto em segundos: " +   tempoSeg );

    }

    public static void selectionSort(int[] vetor){
        int n = vetor.length;
        for(int i = 0; i < n -1; i++){
            int indiceMinimo = i;
            for(int j = i + 1; j < n; j++){
                if(vetor[j] < vetor[indiceMinimo]){
                    indiceMinimo = j;
                }
            }
            int aux = vetor[indiceMinimo];
            vetor[indiceMinimo] = vetor[i];
            vetor[i] = aux;
        }
    }

    public static void insertionSort(int[] vetor){
        int n = vetor.length;
        for(int i = 1; i < n; i++){
            int valor = vetor[i];
            int j = i - 1;

            while(j >= 0 && vetor[j] > valor){
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = valor;
        }
    }

    public static void mergeSort(int [] vetor, int inicio, int fim){
        if (inicio < fim ){
            int meio = (inicio + fim)/2;
            mergeSort(vetor, inicio, meio);
            mergeSort(vetor, meio + 1, fim);
            merge(vetor, inicio, meio , fim);
        }
    }

    private static void merge(int [] vetor, int inicio, int meio, int fim) {
        // Passo 1: Determinar os tamanhos dos dois subarrays
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        // Passo 2: Criar arrays temporários para armazenar os subarrays
        int[] esquerda = new int[n1];
        int[] direita = new int[n2];

        // Passo 3: Copiar os dados para os arrays temporários
        for (int i = 0; i < n1; i++)
            esquerda[i] = vetor[inicio + i];
        for (int j = 0; j < n2; j++)
            direita[j] = vetor[meio + 1 + j];

        // Passo 4: Mesclar os arrays temporários de volta no array original
        int i = 0, j = 0;
        int k = inicio;
        while (i < n1 && j < n2) {
            if (esquerda[i] <= direita[j]) {
                vetor[k] = esquerda[i];
                i++;
            } else {
                vetor[k] = direita[j];
                j++;
            }
            k++;
        }
        // Passo 5: Copiar os elementos restantes de esquerda[], se houver
        while (i < n1) {
            vetor[k] = esquerda[i];
            i++;
            k++;
        }

        // Passo 6: Copiar os elementos restantes de direita[], se houver
        while (j < n2) {
            vetor[k] = direita[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            // Particiona o vetor e retorna o índice do pivô
            int indicePivo = particionar(vetor, inicio, fim);
            // Ordena a sublista à esquerda do pivô
            quickSort(vetor, inicio, indicePivo - 1);
            //Ordena a sublista à direita do pivô
            quickSort(vetor, indicePivo + 1, fim);
        }
    }

    private static int particionar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[fim]; // Escolhe o último elemento como pivô
        int i = (inicio - 1); // Índice do menor elemento

        for (int j = inicio; j < fim; j++) {
            if (vetor[j] <= pivo) { // Se o elemento atual é menor ou igual ao pivô
                i++;
                // Troca vetor[i] e vetor[j]
                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }
        // Troca vetor[i+1] com o pivô (vetor[fim])
        int temp = vetor[i + 1];
        vetor[i + 1] = vetor[fim];
        vetor[fim] = temp;

        return i + 1; // Retorna o índice do pivô
    }

}