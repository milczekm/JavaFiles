package pliki;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SumaLiczbZPliku {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj nazwę pliku: ");
        String nazwa = sc.nextLine();
        int suma = 0;
        File f = new File(nazwa);
        try {
            try (Scanner s = new Scanner(f)) {
                while (s.hasNextInt()) {
                    suma += s.nextInt();
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Nie moge otworzyć pliku");
            System.exit(1);
        }

        System.out.println("Suma wszystkich liczb z zadanego pliku wynosi: " + suma);
    }
}
