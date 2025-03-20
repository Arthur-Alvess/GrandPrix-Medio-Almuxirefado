package almurifefado.grandprixmedioalmuxirefado.Models;

import almurifefado.grandprixmedioalmuxirefado.Util.CPF;
import almurifefado.grandprixmedioalmuxirefado.Util.CellphoneNumber;
import almurifefado.grandprixmedioalmuxirefado.Util.EmailAddress;

public class User {
    private String nome;
    private EmailAddress email;
    private CPF cpf;
    private CellphoneNumber cellphone;


    public User(String nome, EmailAddress email, CPF cpf, CellphoneNumber cellphone){
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.cellphone = cellphone;
    }

    @Override
    public String toString(){
        return "Nome: " + this.nome + ", Email: " + this.email + ", Cpf: " + this.cpf + ", " + this.cellphone;
    }
}
