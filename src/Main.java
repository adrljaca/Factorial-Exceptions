//Napiši Java program koji omogućuje korisniku unos broja, a zatim računa faktorijel tog broja.
//Program treba obraditi iznimke koje se mogu pojaviti tijekom unosa i računanja faktorijela.
//Ispiši poruku korisniku da unese broj.
//Koristi Scanner za unos broja od korisnika.
//Obradi iznimke koje se mogu pojaviti tijekom unosa.
// Ako korisnik unese nešto što nije broj, ispiši odgovarajuću poruku i zatraži ponovni unos.
//Računaj faktorijel unesenog broja.
//Obradi iznimke koje se mogu pojaviti tijekom računanja faktorijela.
// Na primjer, obradi situaciju kada korisnik unese negativan broj jer faktorijel nije definiran za negativne brojeve.
//Ispiši rezultat ili poruku o greški, ovisno o tome je li računanje faktorijela uspješno ili ne.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Unesite prirodni broj: ");
                String unos = scan.nextLine();

                int broj = Integer.parseInt(unos);

                long faktorijel = izracunajFaktorijel(broj);

                String rez = "";
                for (int i = 1; i <= broj; i++) {
                    if (i > 1) rez += "*";
                    rez += i;
                }

                System.out.println("\nVaš faktorijel iznosi...");
                System.out.println(rez + " = " + faktorijel);
                break;

            } catch (NumberFormatException e) {
                System.out.println("Pogreška, nije unesen prirodni broj!");
            } catch (NegativniBrIznimka | PrevelikBroj e) {
                System.out.println(e.getMessage());
            } catch (ArithmeticException e) {
                System.out.println("Pogreška, broj je prevelik da bi se izračunao njegov faktorijel!");
            }
        }

        scan.close();
    }

    public static int izracunajFaktorijel(int broj) throws NegativniBrIznimka, PrevelikBroj {
        if (broj < 0) {
            throw new NegativniBrIznimka("Pogreška, unešen je negativan broj!");
        }

        if (broj > 1000) {
            throw new PrevelikBroj("Pogreška, unesite broj manji od 1000!");
        }

        int faktorijel = 1;
        for (int i = 1; i <= broj; i++) {
            faktorijel *= i;
        }

        return faktorijel;
    }
}