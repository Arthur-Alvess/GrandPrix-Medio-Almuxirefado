package almurifefado.grandprixmedioalmuxirefado.Util;

public class CPF {
    private String cpf;

    public CPF(String cpf) {
        if (isValidCPF(cpf)) {
            this.cpf = cpf;
        } else {
            this.cpf = null;
        }
    }

    public String getCpf() {
        return cpf;
    }

    public boolean isCpfValid() {
        return cpf != null;
    }

    public static boolean isValidCPF(String cpf) {
        if (cpf == null || cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        String cpfSemDigitos = cpf.substring(0, 9);
        int primeiroDigito = calcularDigito(cpfSemDigitos, 10);
        int segundoDigito = calcularDigito(cpfSemDigitos + primeiroDigito, 11);

        return cpf.equals(cpfSemDigitos + primeiroDigito + segundoDigito);
    }

    private static int calcularDigito(String base, int peso) {
        int soma = 0;
        for (int i = 0; i < base.length(); i++) {
            soma += Integer.parseInt(String.valueOf(base.charAt(i))) * (peso - i);
        }
        int digito = 11 - (soma % 11);
        return (digito > 9) ? 0 : digito;
    }

    public String formatarCPF() {
        if (cpf == null) {
            return "CPF inválido";
        }
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
    }

    @Override
    public String toString() {
        return formatarCPF();
    }
}