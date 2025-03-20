package almurifefado.grandprixmedioalmuxirefado.Models;

import almurifefado.grandprixmedioalmuxirefado.Util.CPF;
import almurifefado.grandprixmedioalmuxirefado.Util.CellphoneNumber;
import almurifefado.grandprixmedioalmuxirefado.Util.EmailAddress;
import almurifefado.grandprixmedioalmuxirefado.Util.UserAddress;

public class User {
    private String nome;
    private EmailAddress email;
    private CPF cpf;
    private CellphoneNumber cellphone;
    private UserAddress address;


    public User(String nome, EmailAddress email, CPF cpf, CellphoneNumber cellphone, UserAddress address){
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.cellphone = cellphone;
        this.address = address;
    }

    @Override
    public String toString(){
        return "Nome: " + nome + ", Email: " + email + ", Cpf: " + cpf + ", " + cellphone + ", " + address;
    }
}
