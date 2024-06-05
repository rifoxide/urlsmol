package rifoxide.urlsmol;

import java.net.URI;
import java.security.SecureRandom;

public class Helpers {
    public static Boolean containsInvaidChars(String s) {
        s = s.toLowerCase();
        for (char c : s.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = SECURE_RANDOM.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }

    public static Boolean isValidUrl(String url) {
        try {
            URI parsed = new URI(url);
            parsed.toURL();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
