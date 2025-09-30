package e1;

public class SubstitutionChiper {

    private String abcMayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String abcMinus = "abcdefghijklmnopqrstuvwxyz";

    public String encode(int key, String text) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            for (int j = 0; j < abcMayus.length(); j++) {
                if (c == abcMayus.charAt(j)) {
                    sb.append(abcMayus.charAt((j + key) % abcMayus.length()));
                } else if (c == abcMinus.charAt(j)) {
                    sb.append(abcMinus.charAt((j + key) % abcMayus.length()));
                }
            }

            sb.append(c);
        }

        return sb.toString();
    }

    public String decode(int key, String text) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            for (int j = 0; j < abcMayus.length(); j++) {
                if (c == abcMayus.charAt(j)) {
                    sb.append(abcMayus.charAt((j - key) % abcMayus.length()));
                } else if (c == abcMinus.charAt(j)) {
                    sb.append(abcMinus.charAt((j - key) % abcMayus.length()));
                }
            }

            sb.append(c);
        }

        return sb.toString();
    }
}
