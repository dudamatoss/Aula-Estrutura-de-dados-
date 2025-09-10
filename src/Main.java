import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] vetor = new int[10];

        Random r = new Random();

        for(int i = 0; i < vetor.length; i++){
            vetor[i] = r.nextInt(10);
        }

        int[] v1 = Arrays.copyOf(vetor, vetor.length);
        int[] v2 = Arrays.copyOf(vetor, vetor.length);
        int[] v3 = Arrays.copyOf(vetor, vetor.length);
        int[] v4 = Arrays.copyOf(vetor, vetor.length);
        int[] v5 = Arrays.copyOf(vetor, vetor.length);

        System.out.println("Bubble Sort:");
        Complexidade.bubbleSort(v1);

        System.out.println("\nSelection Sort:");
        Complexidade.selectionSort(v2);

        System.out.println("\nInsertion Sort:");
        Complexidade.insertionSort(v3);

        System.out.println("\nMerge Sort:");
        Complexidade.mergeSort(v4);

        System.out.println("\nQuick Sort:");
        Complexidade.quickSort(v5);

    }
}