package day_individual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15927 {
    public static void main(String[] argv) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String pelin = br.readLine();

        boolean isPelin = true;
        for (int i = 0; i < pelin.length(); i++){
            if (pelin.charAt(i) != pelin.charAt(pelin.length() - 1 -i)){
                isPelin = false;
                break;
            }
        }

        boolean allSame = true;
        for (int i = 1; i < pelin.length(); i++) {
            if (pelin.charAt(i) != pelin.charAt(0)){
                allSame = false;
                break;
            }
        }

        if (allSame) {
            System.out.println(-1);
            return;
        }
        if (isPelin) {
            System.out.println(pelin.length() - 1);
        } else {
            System.out.println(pelin.length());
        }

    }
}
