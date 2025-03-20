package almurifefado.grandprixmedioalmuxirefado.Models;

import almurifefado.grandprixmedioalmuxirefado.Util.CPF;
import almurifefado.grandprixmedioalmuxirefado.Util.CellphoneNumber;
import almurifefado.grandprixmedioalmuxirefado.Util.EmailAddress;

public class User {
    private String nomeCompleto;
    private EmailAddress email;
    private CPF cpf;
    private CellphoneNumber cellphone;


    public User(String nomeCompleto, EmailAddress email, CPF cpf, CellphoneNumber cellphone){
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.cpf = cpf;
        this.cellphone = cellphone;
    }

    @Override
    public String toString(){
        return "Nome: " + this.nomeCompleto + ", Email: " + this.email + ", Cpf: " + this.cpf + ", " + this.cellphone;
    }
}
