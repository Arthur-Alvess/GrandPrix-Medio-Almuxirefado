package almurifefado.grandprixmedioalmuxirefado.Models;

public class Item {
    private String nome;
    private String descrição;
    private int quantidade;

    public Item(String nome, String descrição, int quantidade){
        this.nome = nome;
        this.descrição = descrição;
        this.quantidade = quantidade;
    }

    @Override
    public String toString(){
        return "Nome: " + this.nome + "Quantidade: " + this.quantidade;
    }
    public String getDescrição(){
        return "Descriçao: " + this.descrição;
    }
}
