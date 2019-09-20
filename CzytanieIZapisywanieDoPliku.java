package pliki;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CzytanieIZapisywanieDoPliku {

    public static void pisanieDoPliku(String nazwaPlikuWynikowego, String nazwaPlikuWejsciowego) {

        File plikOdczyt = new File(nazwaPlikuWejsciowego);

        try {
            FileWriter plikZapis = new FileWriter(nazwaPlikuWynikowego);
            try (PrintWriter p = new PrintWriter(plikZapis);
                    Scanner sc = new Scanner(plikOdczyt)) {
                int nrWiersza = 1;
                while (sc.hasNextLine()) {
                    String s = sc.nextLine();
                    System.out.println(nrWiersza + ": " + s);
                    p.println(nrWiersza + ": " + s);
                    nrWiersza++;
                }
                p.close();
                sc.close();
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Nie udało się otworzyć pliku.");
        } catch (IOException ex) {
            System.out.println("Nie udało się utworzyc pliku do zapisu.");
            System.exit(1);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Podaj plik do odczytu: ");
        String nazwaPlikuWejsciowego = sc.nextLine();
        System.out.print("Podaj plik do zapisu: ");
        String nazwaPlikuWyjsciowego = sc.nextLine();
        pisanieDoPliku(nazwaPlikuWyjsciowego, nazwaPlikuWejsciowego);

    }

}
