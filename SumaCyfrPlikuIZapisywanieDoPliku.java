package pliki;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SumaCyfrPlikuIZapisywanieDoPliku {

    public static void sumaCyfrWierszami(String nazwaPlikuWejsciowego, String nazwaPlikuWyjsciowego) {
        File f = new File(nazwaPlikuWejsciowego);
        try {
            FileWriter f1 = new FileWriter(nazwaPlikuWyjsciowego);
            PrintWriter p = new PrintWriter(f1);
            Scanner sc = new Scanner(f);

            int liczbaWiersza = 1;
            while (sc.hasNextLine()) {
                int suma = 0;
                String line = sc.nextLine();
                Scanner lineScanner = new Scanner(line);
                while (lineScanner.hasNextInt()) {
                    int n = lineScanner.nextInt();
                    suma += n;
                }
                p.println("Suma " + liczbaWiersza + " wiersza wynosi: " + suma + ".");
                liczbaWiersza++;
            }
            sc.close();
            p.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Nie udało się otworzyć pliku!");
            System.exit(1);
        } catch (IOException ex) {
            System.out.println("Nie udało się zapisac do pliku!");
        }
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.print("Podaj nazwę pliku do odczytania cyfr: ");
        String nazwaPlikuDoOdczytu = s.nextLine();
        System.out.print("Podaj nazwę pliku do zapisania cyfr: ");
        String nazwaPlikuDoZapisu = s.nextLine();

        sumaCyfrWierszami(nazwaPlikuDoOdczytu, nazwaPlikuDoZapisu);
    }
}
