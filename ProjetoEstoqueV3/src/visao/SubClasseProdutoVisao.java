package visao;

import java.time.LocalDate;
import java.util.ArrayList;
import dominio.SubClasseProduto;
import fakedb.SubClasseProdutoFakeDB;
import servico.SubClasseProdutoServico;

public class SubClasseProdutoVisao {

    private SubClasseProdutoServico srv;

    public SubClasseProdutoVisao(){
        this.srv = new SubClasseProdutoServico();
    }

    public void Criar(){
        SubClasseProduto cp = new SubClasseProduto();
        cp.setCodigo(0);
        cp.setDescricao("teste");
        cp.setDataDeInclusao(LocalDate.now());
        this.srv.Adicionar(cp);
    }
    
    public void Exibir(){
        SubClasseProdutoFakeDB db = new SubClasseProdutoFakeDB();
        ArrayList<SubClasseProduto> lista = db.getTabela();
        System.out.println("============================================================");
        for (SubClasseProduto cp : lista) {
            this.Imprimir(cp);
    }
}

    public void ExibirPorLinha(){
        SubClasseProdutoFakeDB db = new SubClasseProdutoFakeDB();
        ArrayList<SubClasseProduto> lista = db.getTabela();
        System.out.println("============================================================");
        for (SubClasseProduto cp : lista) {
            this.ImprimirPorLinha(cp);
    }
    

    
}
    public void Imprimir(SubClasseProduto cp){
        System.out.println("SubClasse de Produto");
        System.out.println("Codigo: "+ cp.getCodigo());
        System.out.println("Descrição: "+ cp.getDescricao());
        System.out.println("Data de Inclusão: "+ cp.getDataDeInclusao());
        System.out.println("Código da Classe: "+ cp.getCodigoClasse());
        System.out.println("------------------------------------------------------------");
}
    public void ImprimirPorLinha(SubClasseProduto cp){
        String mensagem = "";
        mensagem+="Classe de Produto: ";
        mensagem+="Codigo: "+ cp.getCodigo() + "|";
        mensagem+="Descrição: "+ cp.getDescricao() + "|";
        mensagem+="Data de Inclusão: " + cp.getDataDeInclusao() + "|";
        System.out.println(mensagem);
        System.out.println("------------------------------------------------------------");
    }
}