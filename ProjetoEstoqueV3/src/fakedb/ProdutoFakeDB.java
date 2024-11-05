package fakedb;

import java.time.LocalDate;
import java.util.ArrayList;
import dominio.Produto;

public class ProdutoFakeDB extends BaseFakeDB<Produto> {

    @Override
    protected void preencherDados() {
        this.tabela = new ArrayList<>();
        this.tabela.add(new Produto(1, "Maminha", LocalDate.now(), 1, 29.00));
        this.tabela.add(new Produto(2, "Picanha", LocalDate.now(), 1, 59.00));
        this.tabela.add(new Produto(1, "Bacon", LocalDate.now(), 2, 11.00));
        this.tabela.add(new Produto(2, "Linguiça", LocalDate.now(), 2, 11.00));
    }
    public ProdutoFakeDB(){
        super();
    }
}
