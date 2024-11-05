package fakedb;

import java.time.LocalDate;
import java.util.ArrayList;
import dominio.SubClasseProduto;

public class SubClasseProdutoFakeDB extends BaseFakeDB<SubClasseProduto>{

    @Override
    protected void preencherDados() {
        this.tabela = new ArrayList<>();
        this.tabela.add(new SubClasseProduto(1, "Bovino", LocalDate.now(), 1));
        this.tabela.add(new SubClasseProduto(2, "Suino", LocalDate.now(), 1));
        this.tabela.add(new SubClasseProduto(3, "Equino", LocalDate.now(), 1));
        this.tabela.add(new SubClasseProduto(1, "Sucos", LocalDate.now(), 2));
        this.tabela.add(new SubClasseProduto(2, "Cervejas", LocalDate.now(), 2));
        this.tabela.add(new SubClasseProduto(3, "Refrigerantes", LocalDate.now(), 2));
        this.tabela.add(new SubClasseProduto(1, "Leite", LocalDate.now(), 3));
        this.tabela.add(new SubClasseProduto(2, "Queijos", LocalDate.now(), 3));
        this.tabela.add(new SubClasseProduto(3, "Requeijões", LocalDate.now(), 3));





    }
    public SubClasseProdutoFakeDB(){
        super();
    }
    
}
