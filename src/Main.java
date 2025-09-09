import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] vetor = new int[10];

        Random r = new Random();

        for(int i =0; i < vetor.length; i++){
            vetor[i] = r.nextInt(10);
        }


        Complexidade.bubbleSort(vetor);



    }
}