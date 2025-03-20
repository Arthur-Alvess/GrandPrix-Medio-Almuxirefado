package almurifefado.grandprixmedioalmuxirefado.Util;

import almurifefado.grandprixmedioalmuxirefado.Util.Cep;

public class UserAddress {
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private Cep cep;

    public UserAddress(String rua, String numero, String bairro, String cidade, Cep cep) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Cep getCep() {
        return cep;
    }

    public void setCep(Cep cep) {
        this.cep = cep;
    }

    public String getFullAddress() {
        return rua + ", " + numero + " - " + bairro + ", " + cidade + " - " + cep;
    }
}
