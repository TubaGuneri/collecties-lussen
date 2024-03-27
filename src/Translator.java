import java.util.HashMap;

public class Translator {
    HashMap<Integer, String> numericAlpha = new HashMap<>();

    public Translator(String[] alphabetic, Integer[] numeric){
        for (int i = 0; i < alphabetic.length; i++) {
numericAlpha.put(numeric[i], alphabetic[i]);
        }
        System.out.println(numericAlpha);
    }
    public String translate(Integer number){
        return numericAlpha.get(number);

    }
}
