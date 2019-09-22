package pliki;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SzukanieFrazyIZapisywanieDoPliku {

    public static void szukanieFrazy(String nazwaPlikuWejsciowego, String nazwaPlikuWyjsciowego, String fraza) {
        File f = new File(nazwaPlikuWejsciowego);
        try {
            FileWriter f1 = new FileWriter(nazwaPlikuWyjsciowego);
            PrintWriter p = new PrintWriter(f1);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (line.contains(fraza)) {
                    p.println(line);
                }
            }
            s.close();
            p.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Nie udało się otworzyć pliku.");
        } catch (IOException ex) {
            System.out.println("Nie udało się utworzyć pliku do zapisu!");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Podaj plik do odczytu: ");
        String nazwaPlikuWejsciowego = sc.nextLine();
        System.out.print("Podaj plik do zapisu: ");
        String nazwaPlikuWyjsciowego = sc.nextLine();
        System.out.print("Podaj frazę do wyszukania: ");
        String fraza = sc.nextLine();

        szukanieFrazy(nazwaPlikuWejsciowego, nazwaPlikuWyjsciowego, fraza);

    }
}
