package almurifefado.grandprixmedioalmuxirefado.ConsoleApplication.LoginCadastro;

import java.util.Scanner;

import almurifefado.grandprixmedioalmuxirefado.Util.EmailAddress;

public class LoginCadastro {

    public void escolherOpção(){

        Scanner sc = new Scanner(System.in);


        System.out.println("      *****LOGIN*****");
        System.out.println("Bem vindo ao nosso sistema !!\n");
        System.out.println("Escolha uma dessas opções: ");
        System.out.println("1. já tenho uma conta");
        System.out.println("2. ainda não tenho minha conta");

        String opcao = sc.nextLine();

        switch(opcao){
            case "1":
                System.out.print("Digite seu Email: ");
                String stringEmail = sc.nextLine();
                EmailAddress email = new EmailAddress(stringEmail);

                System.out.print("Agora digite sua senha: ");
            break;

            case "2":

            break;
            default:
            System.out.println("Opção errada!");
        }
    }
}
