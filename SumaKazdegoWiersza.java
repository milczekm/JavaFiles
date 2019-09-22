package pliki;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SumaKazdegoWiersza {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj nazwę pliku: ");
        String nazwa = sc.nextLine();

        File f = new File(nazwa);
        try {
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                Scanner lineScanner = new Scanner(line);
                int suma = 0;
                while (lineScanner.hasNextInt()) {
                    int n = lineScanner.nextInt();
                    suma += n;
                }
                System.out.println(suma);
            }
            s.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Nie moge otworzyć pliku");
            System.exit(1);
        }
    }
}
