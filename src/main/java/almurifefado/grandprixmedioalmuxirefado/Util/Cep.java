package almurifefado.grandprixmedioalmuxirefado.Util;

public class Cep {
    private String cep;

    public Cep(String cep) {
        if (isValidCep(cep)) {
            this.cep = cep;
        } else {
            throw new IllegalArgumentException("CEP inválido.");
        }
    }

    public String getCep() {
        return cep;
    }

    private boolean isValidCep(String cep) {
        return cep.matches("\\d{5}-\\d{3}");
    }

    public String formatarCep() {
        return cep.substring(0, 5) + "-" + cep.substring(5, 8);
    }

    @Override
    public String toString() {
        return formatarCep();
    }
}
