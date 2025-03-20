package almurifefado.grandprixmedioalmuxirefado.Models;

import almurifefado.grandprixmedioalmuxirefado.Util.CPF;
import almurifefado.grandprixmedioalmuxirefado.Util.EmailAddress;
import almurifefado.grandprixmedioalmuxirefado.Util.StatusAtualFuncionario;

public class Funcionário {
    private String nome;
    private EmailAddress email;
    private CPF cpf;
    private int idade;
    private String descrição;
    private StatusAtualFuncionario statusAtualFuncionario;


    public Funcionário(String nome, EmailAddress email, CPF cpf, int idade, 
                        String descrição, StatusAtualFuncionario statusAtualFuncionario){
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.idade = idade;
        this.descrição = descrição;
        this.statusAtualFuncionario = StatusAtualFuncionario.ATIVO;
    }

    @Override
    public String toString(){
        return "Nome: " + this.nome + "Email: " + this.email + "CPF: " + this.cpf + "Idade: " + this.idade + "Status: " + this.statusAtualFuncionario;
    }
}
