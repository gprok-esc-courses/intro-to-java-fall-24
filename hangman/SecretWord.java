package hangman;

public class SecretWord {
    private String secret;

    public void getNewSecret() {
        WordCollection w  = new WordCollection();
        secret = w.getRandomWord();
    }

    public String getSecret(String correct) {
        String s = "" + secret.charAt(0);
        for(int i = 1; i <= secret.length() - 2; i++) {
            if(correct.contains("" + secret.charAt(i))) {
                s = s + " " + secret.charAt(i);
            }
            else {
                s = s + " _";
            }
        }
        s = s + " " + secret.charAt(secret.length() - 1);
        return s;
    }

    public static void main(String[] args) {
        SecretWord sw = new SecretWord();
        sw.getNewSecret();
        System.out.println(sw.getSecret(""));
    }

    public boolean contains(String letter) {
        if(secret.contains(letter)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean found(String correct) {
        for(int i = 1; i <= secret.length() - 2; i++) {
            if(!correct.contains("" + secret.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
