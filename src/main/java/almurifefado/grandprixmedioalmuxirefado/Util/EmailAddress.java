package almurifefado.grandprixmedioalmuxirefado.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailAddress {
    private String email;

    public EmailAddress(String email) {
        if (isValidEmail(email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Endereço de e-mail inválido.");
        }
    }

    public String getEmail() {
        return email;
    }

    private boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    public String toString() {
        return email;
    }

    public void setEmail(String email) {
        if (isValidEmail(email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Endereço de e-mail inválido.");
        }
    }
}
