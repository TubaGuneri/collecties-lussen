import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Bonus {

    public static void main(String[] args) {

        // Onderstaande code is uitgecommentarieerd. Haal de code uit de comment (delete /* en */) om aan de slag te gaan met de bonus
        // In de code staan op verschillende plekken comments tussen "/*...*/" als hint wat je moet doen


        HashSet<Integer> secretnumber = randomnumbergenerator();
        String stringnumber = setToStringConverter(secretnumber);
//        System.out.println(stringnumber);
        feedback(stringnumber);
//        System.out.println(secretnumber);

    }

    public static HashSet<Integer> randomnumbergenerator(/*Heeft deze methode nog parameter(s) nodig?*/) {
         /*
        Vul hier de body van de methode in.

        Stappenplan:
        - Maak een nieuwe variabele van type Random. (Tip: Zoek op internet hoe je Random kunt gebruiken)
        - Maak een nieuwe variabele van type HashSet.
        - Schrijf een while-loop om 4 random nummers aan de hashset toe te voegen
        - return de hashset
         */
        Random random = new Random();
        HashSet<Integer> hashSet = new HashSet<>();
        while (hashSet.size() < 4) {
            hashSet.add(random.nextInt(10));
        }
        return hashSet;
    }

    public static String setToStringConverter(HashSet<Integer> hashSet) {
        /*
        Vul hier de body van de methode in.

        Stappenplan:
        - Maak als eerst een String variabele met als waarde een lege String. (of gebruik een StringBuilder)
        - Schrijf vervolgens een for-loop om de items in de hashset een voor een aan de String variabele toe te voegen.
        - Return de (gevulde) String variabele
         */

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer number : hashSet) {
            stringBuilder.append(number);
        }
        return stringBuilder.toString();
    }


    public static void feedback(String stringnumber) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder feedback = new StringBuilder();
        Boolean isCorrect = false;
        System.out.println("+ = juiste nummer op de juiste plek, O = juiste nummer verkeerde plek, X = verkeerde nummer");
        System.out.println("Doe een gok, Let op vul 4 getallen in.");
        while (!isCorrect) {
            String guess = scanner.nextLine();
            if (Objects.equals(guess, stringnumber)) {
                System.out.println("gefeliciteerd je hebt het goed");
                isCorrect = true;
            } else {
                for (int i = 0; i < 4; i++) {
                    if (guess.substring(i, i + 1).equals(stringnumber.substring(i, i + 1))) {
                        feedback.append("+");
                    } else if (stringnumber.contains(guess.substring(i, i + 1))) {
                        feedback.append("0");
                    } else {
                        feedback.append("X");
                    }
                }
            }
            System.out.println(feedback.toString());
        feedback.delete(0,4);
        }
    }
}
