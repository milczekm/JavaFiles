package pliki;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class LiczbaWystapienWyrazowWPliku {

    public static HashMap<String, Integer> wyrazyZeScannera(Scanner wejscie) {
        HashMap<String, Integer> wyrazy = new HashMap<>();
        while (wejscie.hasNext()) {
            String wyraz = wejscie.next();
            if (wyrazy.containsKey(wyraz)) {
                int liczbaWystapien = wyrazy.get(wyraz);
                wyrazy.put(wyraz, liczbaWystapien + 1);
            } else {
                wyrazy.put(wyraz, 1);
            }
        }
        return wyrazy;
    }

    public static void sprawdzajWyrazy(Scanner s, HashMap<String, Integer> wyrazy) {
        while (true) {
            System.out.println("Podaj wyraz: ");
            String wyraz = s.nextLine();
            if (wyraz.equals("")) {
                break;
            }
            System.out.println("Liczba wystąpień: "
                    + (wyrazy.containsKey(wyraz) ? wyrazy.get(wyraz) : 0));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę pliku: ");
        String nazwaPliku = scanner.nextLine();

        File plik = new File(nazwaPliku);

        try {
            Scanner wejscie = new Scanner(plik);
            HashMap<String, Integer> wyrazy = wyrazyZeScannera(wejscie);
            sprawdzajWyrazy(scanner, wyrazy);
        } catch (FileNotFoundException ex) {

            System.out.println("Nie moge otworzyc pliku");
        }
    }
}
