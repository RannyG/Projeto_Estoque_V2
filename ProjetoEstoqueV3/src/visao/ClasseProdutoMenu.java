package visao;

import java.time.LocalDate;
import java.util.ArrayList;

import dominio.ClasseProduto;
import servico.ClasseProdutoServico;

public class ClasseProdutoMenu extends BaseMenu {
    
    private ClasseProdutoServico srv;

    public ClasseProdutoMenu(){
        super();
        this.srv = new ClasseProdutoServico();
    }

    @Override
    public void ExibirMenu(){
        int opcao = 0;
        while (opcao != 0) {
            Util.LimparConsole();
            System.out.println("Cadastro de Classes de Produto");
            System.out.println("1 - Listar");
            System.out.println("2 - Localizar");
            System.out.println("3 - Adicionar");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Remover");
            System.out.println("9 - Sair");
            System.out.println("Selecione uma das opções: ");
            opcao = this.scanner.nextInt();
            switch (opcao) {
                case 1:
                    this.Listar();
                    break;
                case 2:
                    this.Localizar();
                    break;
                case 3:
                    this.Adicionar();
                    break;
                case 4:
                    this.Atualizar();
                    break;
                case 5:
                    this.Remover();
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }

        }
    }

    @Override
    public void Listar(){
        Util.LimparConsole();
        System.out.println("Listando");
        ArrayList<ClasseProduto> lista = this.srv.Navegar();
        for (ClasseProduto cp : lista) {
            this.ImprimirPorLinha(cp);
        }

        System.out.println("Clique <ENTER> para continuar");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Localizar(){
        Util.LimparConsole();
        System.out.println("Localizando");

        System.out.print("Informe o código da Classe de Produto: ");
        int cod = this.scanner.nextInt();

        ClasseProduto cp = this.srv.Ler(cod);
        if (cp != null) {
            this.ImprimirPorLinha(cp);
        }else{
            System.out.println("Problema -- Classe de Produto não encontrada");
        }
        
        System.out.println("Clique <ENTER> para continuar");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Adicionar(){
        Util.LimparConsole();
        System.out.println("Adicionando");

        System.out.print("Informe a descrição");
        String descricao = this.scanner.next();
        ClasseProduto cp = new ClasseProduto();
        cp.setDescricao(descricao);
        cp.setDataDeInclusao(LocalDate.now());
        if (this.srv.Adicionar(cp) != null) {
            System.out.println("Classe de Produto adicionada com sucesso");
        }else{
            System.out.println("Porblema -- Erro ao adicionar Classe de produto");
        }

        System.out.println("Clique <ENTER> para continuar");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Atualizar(){
        Util.LimparConsole();
        System.out.println("Atualizando");

        System.out.println("Informe o código da Classe de Produto: ");
        int cod = this.scanner.nextInt();

        ClasseProduto cp = this.srv.Ler(cod);
        if (cp != null) {
            System.out.println("Informe a nova descrição");
            String descricao = this.scanner.next();
            cp.setDescricao(descricao);
            if (this.srv.Editar(cp) != null) {
                System.out.println("Alteração realizada com sucesso");
            }else{
                System.out.println("Problema - Alteração não foi realizada");
            }
        }else{
            System.out.println("Problema - Classe de produto não encontrado");
        }
        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Remover(){
        Util.LimparConsole();
        System.out.println("Removendo");

        System.out.println("Informe o codigo da classe para remoção");
        int cod = this.scanner.nextInt();
        ClasseProduto cp = this.srv.Ler(cod);
        if (cp != null) {
            if (this.srv.Deletar(cod) != null) {
                System.out.println("Classe de produto removida com sucesso");
            }else{
                System.out.println("Problema - Classe de produto não pode ser removida");
            }
        }else{
            System.out.println("Problema - Classe de produto não foi encontrada");
        }
        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    private void ImprimirPorLinha(ClasseProduto cp){
        String mensagem = "";
        mensagem+="Classe De Produto: ";
        mensagem+="Código: " + cp.getCodigo() + "|"; 
        mensagem+="Descrição" + cp.getDescricao() + "|";
        mensagem+="Data de Inclusão" + cp.getDataDeInclusao();
        System.out.println(mensagem);
    }

}