package visao;
import java.time.LocalDate;
import java.util.ArrayList;

import dominio.Produto;
import fakedb.ProdutoFakeDB;
import servico.ProdutoServico;

public class ProdutoVisao {
    private ProdutoServico srv;
    public ProdutoVisao(){
        this.srv = new ProdutoServico();
    }

    public void Criar(){
        Produto cp = new Produto();
        cp.setCodigo(0);
        cp.setDescricao("teste");
        cp.setDataDeInclusao(LocalDate.now());
        this.srv.Adicionar(cp);
    }

    public void Exibir(){
        ProdutoFakeDB db = new ProdutoFakeDB();
        ArrayList<Produto> lista = db.getTabela();
        System.out.println("=======================================================");
        for (Produto cp : lista) {
            this.imprimir(cp);
        }
    }

    public void ExibirPorLinha(){
        ProdutoFakeDB db = new ProdutoFakeDB();
        ArrayList<Produto> lista = db.getTabela();
        System.out.println("=======================================================");
        for (Produto cp : lista) {
            this.imprimir(cp);
        }
    }

    public void imprimir(Produto cp){
        System.out.println("Produto");
            System.out.println("Codigo do Produto: "+ cp.getCodigo());
            System.out.println("Descrição: "+ cp.getDescricao());
            System.out.println("Data de Inclusão: "+ cp.getDataDeInclusao());
            System.out.println("Codigo da subClasse: "+ cp.getCodigoSubClasse());
            System.out.println("Valor: "+ cp.getValor());
            System.out.println("-------------------------------------------------------------");
    }

    public void ImprimirPorLinha(Produto cp){
        String mensagem = "";
        mensagem+="Classe de Produto: ";
        mensagem+="Codigo: "+ cp.getCodigo() + "|";
        mensagem+="Descrição: "+ cp.getDescricao() + "|";
        mensagem+="Data de Inclusão: " + cp.getDataDeInclusao() + "|";
        System.out.println(mensagem);
        System.out.println("------------------------------------------------------------");
    }
}
