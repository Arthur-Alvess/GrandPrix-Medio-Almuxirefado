package almurifefado.grandprixmedioalmuxirefado.Storage;

import java.util.ArrayList;
import almurifefado.grandprixmedioalmuxirefado.Models.Item;

public class CarrinhoItens {
    private ArrayList<Item> itens;

    public CarrinhoItens() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item, int quantidade, String nomeFuncionario) {
        item.setQuantidade(quantidade);
        itens.add(item);
    }

    public Item buscarItem(String codigo) {
        for (Item item : itens) {
            if (item.getCodigo().equals(codigo)) {
                return item;
            }
        }
        return null;
    }

    public void removerItem(Item item, int quantidade) {
        item.setQuantidade(item.getQuantidade() - quantidade);
        if (item.getQuantidade() <= 0) {
            itens.remove(item);
        }
    }

    public ArrayList<Item> getItens() {
        return itens;
    }
}