package logic;

import java.util.Random;

public class RandomSymbols {
    private static final String alphabet= "qwertyuiopasdfghjklzxcvbnm1234567890_";
    public static String randomString(int quantity) {
        StringBuilder randStr = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < quantity; i++) {
            randStr.append(alphabet.charAt(r.nextInt(alphabet.length())));
        }
        return randStr.toString();
    }

}
