package almurifefado.grandprixmedioalmuxirefado.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CellphoneNumber {
    private String numero;

    public CellphoneNumber(String numero) {
        if (isValid(numero)) {
            this.numero = numero;
        } else {
            throw new IllegalArgumentException("Número de celular inválido.");
        }
    }

    public String getNumero() {
        return numero;
    }

    public boolean isValid(String numero) {
        String regex = "^\\(\\d{2}\\) \\d{5}-\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numero);
        return matcher.matches();
    }

    public String formatarNumero() {
        String numeroLimpo = numero.replaceAll("[^0-9]", "");
        return String.format("(%s) %s-%s",
                numeroLimpo.substring(0, 2),
                numeroLimpo.substring(2, 7),
                numeroLimpo.substring(7, 11));
    }

    @Override
    public String toString() {
        return formatarNumero();
    }

    public static boolean isValidCellphoneNumber(String numero) {
        try {
            CellphoneNumber c = new CellphoneNumber(numero);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
