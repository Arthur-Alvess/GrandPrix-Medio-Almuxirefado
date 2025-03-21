package almurifefado.grandprixmedioalmuxirefado.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CellphoneNumber {
    private String numero;

    public CellphoneNumber(String numero) {
        String numeroLimpo = limparNumero(numero);
        if (isValid(numeroLimpo)) {
            this.numero = formatarNumero(numeroLimpo);
        } else {
            throw new IllegalArgumentException("Número de celular inválido.");
        }
    }

    public String getNumero() {
        return numero;
    }

    private String limparNumero(String numero) {
        return numero.replaceAll("[^0-9]", "");
    }

    public boolean isValid(String numero) {
        String regex = "^(\\d{11})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numero);
        return matcher.matches();
    }

    private String formatarNumero(String numero) {
        if (numero.length() != 11) {
            throw new IllegalArgumentException("Número deve ter exatamente 11 dígitos.");
        }

        return String.format("(%s) %s-%s",
                numero.substring(0, 2),
                numero.substring(2, 7),
                numero.substring(7, 11)
        );
    }

    @Override
    public String toString() {
        return numero;
    }

    public static boolean isValidCellphoneNumber(String numero) {
        try {
            String numeroLimpo = numero.replaceAll("[^0-9]", "");
            return numeroLimpo.matches("^\\d{11}$");
        } catch (Exception e) {
            return false;
        }
    }
}
