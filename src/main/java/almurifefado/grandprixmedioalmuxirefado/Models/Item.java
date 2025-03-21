package almurifefado.grandprixmedioalmuxirefado.Models;

public class Item {
    private String codigo;
    private String nome;
    private String descrição;
    private int quantidade;

    public Item(String nome, String descrição, int quantidade, String codigo){
        this.nome = nome;
        this.descrição = descrição;
        this.quantidade = quantidade;
        this.codigo = codigo;
    }

    @Override
    public String toString(){
        return "Código: " + this.codigo + ", Nome: " + this.nome + ", Quantidade: " + this.quantidade;
    }
    public String getDescrição(){
        return "Descriçao: " + this.descrição;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return this.descrição;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public Item setNome(String nome){
        this.nome = nome;
        return this;
    }
    public Item setDescricao(String descrição){
        this.descrição = descrição;
        return this;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade >= 0){
        this.quantidade = quantidade;
        } else {
            throw new IllegalArgumentException("Não pode adicionar 0 ou negativo");
        }
    }
}
