package repositorio;

import dominio.SubClasseProduto;
import fakedb.SubClasseProdutoFakeDB;

public class SubClasseProdutoRepositorio extends BaseRepositorio<SubClasseProduto> {

    private SubClasseProdutoFakeDB db;

    public SubClasseProdutoRepositorio(){
        this.db = new SubClasseProdutoFakeDB();
        this.dados = this.db.getTabela();
    }

    @Override
    public SubClasseProduto Read(int chave) {
        for (SubClasseProduto cp : dados) {
            if (cp.getCodigo()==chave) {
                return cp;
            }
            
        }
        return null;
    }

    @Override
    public SubClasseProduto Edit(SubClasseProduto instancia) {
        SubClasseProduto cp = this.Read(instancia.getCodigo());
        if (cp!=null) {
            cp.setDescricao(instancia.getDescricao());
            return cp;
        }
        return null;
    }

    @Override
    public SubClasseProduto Add(SubClasseProduto instancia) {
        int proxchave = this.dados.getLast().getCodigo()+1;
        instancia.setCodigo(proxchave);
        this.dados.add(instancia);
        return instancia;
    }

    @Override
    public SubClasseProduto Delete(int chave) {
        SubClasseProduto cp = this.Read(chave);
        if (cp != null) {
            this.dados.remove(cp);
            
        }
        return null;
    }
    
}
