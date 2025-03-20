package almurifefado.grandprixmedioalmuxirefado.Util;

public class CPF {
    private String cpf;

    public CPF(String cpf) {
        if (isCpfValid(cpf)) {
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF inválido.");
        }
    }

    public String getCpf() {
        return cpf;
    }

    public boolean isCpfValid(String cpf) {
        if (cpf == null || cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        String cpfSemDigitos = cpf.substring(0, 9);
        int primeiroDigito = calcularDigito(cpfSemDigitos, 10);
        int segundoDigito = calcularDigito(cpfSemDigitos + primeiroDigito, 11);

        return cpf.equals(cpfSemDigitos + primeiroDigito + segundoDigito);
    }

    private int calcularDigito(String base, int peso) {
        int soma = 0;
        for (int i = 0; i < base.length(); i++) {
            soma += Integer.parseInt(String.valueOf(base.charAt(i))) * (peso - i);
        }
        int digito = 11 - (soma % 11);
        return (digito > 9) ? 0 : digito;
    }

    public String formatarCPF() {
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
    }

    @Override
    public String toString() {
        return formatarCPF();
    }

    public static boolean isValidCPF(String cpf) {
        try {
            CPF c = new CPF(cpf);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
