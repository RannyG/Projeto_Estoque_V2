package repositorio;

import dominio.Produto;
import fakedb.ProdutoFakeDB;

public class ProdutoRepositorio extends BaseRepositorio<Produto> {

    private ProdutoFakeDB db;

    public ProdutoRepositorio(){
        this.db = new ProdutoFakeDB();
        this.dados = this.db.getTabela();
    }

    @Override
    public Produto Read(int chave) {
        for (Produto cp : dados) {
            if (cp.getCodigo() == chave) {
                return cp;
            }
        }
        return null;
    }

    @Override
    public Produto Edit(Produto instancia) {
        Produto cp = this.Read(instancia.getCodigo());
        if (cp != null) {
            cp.setDescricao(instancia.getDescricao());
            return cp;    
        }
        return null;
        
    }

    @Override
    public Produto Add(Produto instancia) {
        int proxchave = this.dados.getLast().getCodigo() + 1;
        instancia.setCodigo(proxchave);
        this.dados.add(instancia);
        return instancia;
    }

    @Override
    public Produto Delete(int chave) {
        Produto cp = this.Read(chave);
        if (cp != null) {
            this.dados.remove(cp);
            
        }
        return null;
    }
    
}
