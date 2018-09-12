package estoquesystem.model;

import java.util.Scanner;

/**
 * @class Menu responsável por toda a interface do programa que é executado
 * diretamente no prompt
 * @attr Scanner, Estoque
 */
public class Menu {

    private Scanner entrada = new Scanner(System.in);
    private Estoque estoque = new Estoque();

    /**
     * @contructor construtor inicial
     *
     */
    public Menu() {
        System.out.println("----------------------------------");
        System.out.println("<<-----|| ESTOQUE SYSTEM ||----->>");
    }

    /**
     * @method Responsavel por trazer o primeiro menu com as principais opções
     * que o sistema oferece
     * @attr Scanner, opcao
     */
    public void menuPrincipal() {
        int opcao = 0;
        do {
            this.entrada = new Scanner(System.in);
            System.out.println("----------------------------------");
            System.out.println("--------> MENU PRINCIPAL <--------");
            System.out.println("----------------------------------");
            System.out.println("1 - Cadastrar Novo Produto");
            System.out.println("2 - Alterar Produto do Estoque");
            System.out.println("3 - Excluir Produto do Estoque");
            System.out.println("4 - Listar Produtos do Estoque");
            System.out.println("----------------------------------");
            System.out.println("5 - Créditos");
            System.out.println("----------------------------------");
            System.out.println("6 - Sair");
            System.out.println("----------------------------------");
            System.out.print("Informe sua opção: ");

            try {
                opcao = this.entrada.nextInt();
            } catch (Exception e) {
                System.out.println("==================================");
                System.out.println("Opção inválida!");
                System.out.println("==================================");
            }
        } while (opcao == 0);

        switch (opcao) {
            case 1:
                this.menuCadastrar();
                break;
            case 2:
                this.menuAlterar();
                break;
            case 3:
                this.menuExcluir();
                break;
            case 4:
                this.menuListar();
                break;
            case 5:
                this.menuCreditos();
                break;
            case 6:
                System.out.println("----------------------------------");
                System.err.println("Saindo do Sistema...");
                System.exit(0);
                break;
            default:
                opcao = 0;
                System.out.println("==================================");
                System.out.println("Opção inválida!");
                System.out.println("==================================");
                this.menuPrincipal();
                break;
        }
    }

    /**
     * @method Responsavel pelo meno de cadastro de novos produtos na lista do
     * estoque
     * @attr novoProduto, opcao
     */
    public void menuCadastrar() {
        Produto novoProduto = new Produto("Sem Nome", "Sem Categoria", 0.0D, 0);
        Character decisao;
        int opcao = 0;

        System.out.println("----------------------------------");
        System.out.println("------> CADASTRAR PRODUTO <-------");
        System.out.println("----------------------------------");

        do {
            this.entrada = new Scanner(System.in);
            System.out.println("==================================");
            System.out.println(novoProduto.toString());
            System.out.println("==================================");
            System.out.println("1 - Nome do Produto");
            System.out.println("2 - Categoria");
            System.out.println("3 - Valor");
            System.out.println("4 - Quantidade");
            System.out.println("----------------------------------");
            System.out.println("5 - Concluir Operação");
            System.out.println("6 - Cancelar Operação");
            System.out.println("----------------------------------");
            System.out.print("Informe a opção: ");

            try {
                opcao = this.entrada.nextInt();
            } catch (Exception e) {
                System.out.println("==================================");
                System.out.println("Opção inválida!");
                System.out.println("==================================");
            }

            switch (opcao) {
                case 1:
                    this.entrada = new Scanner(System.in);
                    System.out.println("----------------------------------");
                    System.out.print("Insira o Nome do Produto: ");
                    novoProduto.setNome(this.entrada.nextLine().trim());
                    break;
                case 2:
                    this.entrada = new Scanner(System.in);
                    System.out.println("----------------------------------");
                    System.out.print("Insira a Categoria do Produto: ");
                    novoProduto.setCategoria(this.entrada.nextLine().trim());
                    break;
                case 3:
                    this.entrada = new Scanner(System.in);
                    System.out.println("----------------------------------");
                    System.out.print("Insira o Valor do Produto: ");
                    String in = this.entrada.nextLine().replaceAll(",", ".");
                    novoProduto.setValor(Double.parseDouble(in));
                    break;
                case 4:
                    this.entrada = new Scanner(System.in);
                    System.out.println("----------------------------------");
                    System.out.print("Insira Quantidade disponível : ");
                    novoProduto.setQuantidade(this.entrada.nextInt());
                    break;
                case 5:
                    do {
                        this.entrada = new Scanner(System.in);
                        System.out.println("==================================");
                        System.out.println(novoProduto.toString());
                        System.out.println("==================================");
                        System.out.print("Deseja confirmar a inclusão(Y/N)?");
                        decisao = Character.toUpperCase(this.entrada.next().charAt(0));
                    } while (!(decisao == 'Y' || decisao == 'N'));

                    switch (decisao) {
                        case 'Y':
                            if (!this.estoque.adicionar(novoProduto)) {
                                do {
                                    this.entrada = new Scanner(System.in);
                                    System.out.println("----------------------------------");
                                    System.out.print("Produto já cadastrado!\n"
                                            + "Deseja subscrever os dados(Y/N)? ");
                                    decisao = Character.toUpperCase(this.entrada.next().charAt(0));
                                } while (!(decisao == 'Y' || decisao == 'N'));

                                switch (decisao) {
                                    case 'Y':
                                        this.estoque.substituir(novoProduto);
                                        System.out.println("==================================");
                                        System.out.println("Dados atualizados com sucesso!");
                                        System.out.println("==================================");
                                        this.menuPrincipal();
                                        break;
                                    case 'N':
                                        System.out.println("==================================");
                                        System.out.println("Operação cancelada!");
                                        System.out.println("==================================");
                                        this.menuPrincipal();
                                        break;
                                    default:
                                        System.out.println("==================================");
                                        System.out.println("Opção inválida!");
                                        System.out.println("==================================");
                                        break;
                                }

                            } else {
                                System.out.println("==================================");
                                System.out.println("Produto incluso com sucesso!");
                                System.out.println("==================================");
                                this.menuPrincipal();
                            }
                            break;
                        case 'N':
                            System.out.println("==================================");
                            System.out.println("Operação cancelada!");
                            System.out.println("==================================");
                            this.menuPrincipal();
                            break;
                        default:
                            System.out.println("==================================");
                            System.out.println("Opção inválida!");
                            System.out.println("==================================");
                            break;
                    }
                    break;
                case 6:
                    do {
                        this.entrada = new Scanner(System.in);
                        System.out.println("==================================");
                        System.out.println(novoProduto.toString());
                        System.out.println("==================================");
                        System.out.print("Deseja cancelar a inclusão(Y/N)?");
                        decisao = Character.toUpperCase(this.entrada.next().charAt(0));
                    } while (!(decisao == 'Y' || decisao == 'N'));

                    switch (decisao) {
                        case 'Y':
                            System.out.println("==================================");
                            System.out.println("Operação cancelada!");
                            System.out.println("==================================");
                            this.menuPrincipal();
                            break;
                        case 'N':
                            this.menuAlterar();
                            break;
                        default:
                            System.out.println("==================================");
                            System.out.println("Opção inválida!");
                            System.out.println("==================================");
                            break;
                    }
                    break;
                default:
                    System.out.println("==================================");
                    System.out.println("Opção inválida!");
                    System.out.println("==================================");
                    this.menuCadastrar();
                    break;
            }
        } while (!(opcao == 5 || opcao == 6));

    }

    /**
     * @method Responsavel buscar um produto pelo id e chamar o method para a
     * alteração deste produto
     * @attr id
     */
    public void menuAlterar() {
        int id = 0;
        System.out.println("----------------------------------");
        System.out.println("-------> ALTERAR PRODUTO <--------");
        System.out.println("----------------------------------");

        do {
            System.out.print("Informe o ID ou 1 para voltar: ");
            this.entrada = new Scanner(System.in);

            try {
                id = this.entrada.nextInt();

                switch (id) {
                    case 1:
                        this.menuPrincipal();
                        break;
                    default:
                        Produto produto = this.estoque.buscar(id);
                        if (produto != null) {
                            this.menuAlterarProduto(produto);
                        } else {
                            System.out.println("==================================");
                            System.out.println("Verifique se o Id está correto.");
                            System.out.println("==================================");
                            this.menuAlterar();
                        }
                        break;
                }
            } catch (Exception e) {
                System.out.println("==================================");
                System.out.println("Os dados estão incorretos!");
                System.out.println("==================================");
            }
        } while (id == 0);
    }

    /**
     * @method Responsavel por ofrecer as opções para alteração dos produtos
     * @param produto
     * @attr opcao
     */
    public void menuAlterarProduto(Produto produto) {
        int opcao = 0;
        Character decisao;
        do {
            System.out.println("==================================");
            System.out.println(produto.toString());
            System.out.println("==================================");
            System.out.println("1 - Alterar Nome do Produto");
            System.out.println("2 - Alterar Categoria");
            System.out.println("3 - Alterar Valor");
            System.out.println("4 - Alterar Quantidade");
            System.out.println("----------------------------------");
            System.out.println("5 - Concluir Operação");
            System.out.println("6 - Cancelar Operação");
            System.out.println("----------------------------------");
            System.out.print("Informe sua opção: ");
            this.entrada = new Scanner(System.in);

            try {
                opcao = this.entrada.nextInt();
            } catch (Exception e) {
                System.out.println("==================================");
                System.out.println("Opção inválida!");
                System.out.println("==================================");
            }
            switch (opcao) {
                case 1:
                    this.entrada = new Scanner(System.in);
                    System.out.println("----------------------------------");
                    System.out.print("Insira o novo Nome: ");
                    produto.setNome(this.entrada.nextLine().trim());
                    break;
                case 2:
                    this.entrada = new Scanner(System.in);
                    System.out.println("----------------------------------");
                    System.out.print("Insira a nova Categoria: ");
                    produto.setCategoria(this.entrada.nextLine().trim());
                    break;
                case 3:
                    this.entrada = new Scanner(System.in);
                    System.out.println("----------------------------------");
                    System.out.print("Insira o novo Valor: ");
                    String in = this.entrada.nextLine().replaceAll(",", ".");
                    produto.setValor(Double.parseDouble(in));
                    break;
                case 4:
                    this.entrada = new Scanner(System.in);
                    System.out.println("----------------------------------");
                    System.out.print("Insira a nova Quantidade: ");
                    produto.setQuantidade(this.entrada.nextInt());
                    break;
                case 5:
                    do {
                        this.entrada = new Scanner(System.in);
                        System.out.println("==================================");
                        System.out.println(produto.toString());
                        System.out.println("==================================");
                        System.out.print("Confirmar a alteração(Y/N)?");
                        decisao = Character.toUpperCase(this.entrada.next().charAt(0));
                    } while (!(decisao == 'Y' || decisao == 'N'));

                    if (decisao == 'Y') {
                        System.out.println("==================================");
                        System.out.println("Atualizado com sucesso!");
                        System.out.println("==================================");
                        this.menuPrincipal();
                    } else {
                        System.out.println("==================================");
                        System.out.println("Operação cancelada!");
                        System.out.println("==================================");
                        this.menuAlterar();
                    }
                    break;
                case 6:
                    do {
                        this.entrada = new Scanner(System.in);
                        System.out.println("==================================");
                        System.out.println(produto.toString());
                        System.out.println("==================================");
                        System.out.print("Deseja cancelar a alteração(Y/N)?");
                        decisao = Character.toUpperCase(this.entrada.next().charAt(0));
                    } while (!(decisao == 'Y' || decisao == 'N'));

                    switch (decisao) {
                        case 'Y':
                            System.out.println("==================================");
                            System.out.println("Operação cancelada!");
                            System.out.println("==================================");
                            this.menuPrincipal();
                            break;
                        case 'N':
                            this.menuAlterar();
                            break;
                        default:
                            System.out.println("==================================");
                            System.out.println("Opção inválida!");
                            System.out.println("==================================");
                            break;
                    }
                    break;
                default:
                    System.out.println("==================================");
                    System.out.println("Opção inválida!");
                    System.out.println("==================================");
                    this.menuPrincipal();
                    break;
            }

        } while (!(opcao == 5 || opcao == 6));

    }

    /**
     * @method Responsavel pelo meno de exclusão de produtos
     * @attr id
     */
    public void menuExcluir() {
        int id = 0;
        System.out.println("----------------------------------");
        System.out.println("--------> EXCLUIR PRODUTO <-------");
        System.out.println("----------------------------------");

        do {
            System.out.print("Informe o ID ou 1 para voltar: ");
            this.entrada = new Scanner(System.in);

            try {
                id = this.entrada.nextInt();
            } catch (Exception e) {
                System.out.println("==================================");
                System.out.println("Os dados estão incorretos!");
                System.out.println("==================================");
            }
        } while (id == 0);

        switch (id) {
            case 1:
                this.menuPrincipal();
                break;
            default:
                Produto produto = this.estoque.buscar(id);
                if (produto != null) {
                    System.out.println("==================================");
                    System.out.println(produto.toString());
                    System.out.println("==================================");
                    Character decisao;
                    do {
                        this.entrada = new Scanner(System.in);
                        System.out.print("Confirmar a exclusão(Y/N)?");
                        decisao = Character.toUpperCase(this.entrada.next().charAt(0));

                    } while (!(decisao == 'Y' || decisao == 'N'));

                    switch (decisao) {
                        case 'Y':
                            if (this.estoque.deletar(produto)) {
                                System.out.println("==================================");
                                System.out.println("Exclusão realizada com sucesso!");
                                System.out.println("==================================");
                                this.menuPrincipal();
                            }
                            break;
                        case 'N':
                            System.out.println("==================================");
                            System.out.println("Operação cancelada!");
                            System.out.println("==================================");
                            this.menuPrincipal();
                            break;
                        default:
                            System.out.println("==================================");
                            System.out.println("Opção inválida!");
                            System.out.println("==================================");
                            this.menuExcluir();
                            break;
                    }
                } else {
                    System.out.println("==================================");
                    System.out.println("Verifique se o Id está correto.");
                    System.out.println("==================================");
                    this.menuExcluir();
                }
                break;
        }
    }

    /**
     * @method Responsavel por trazer a lista de produtos ja formada no menu
     * @attr opcao
     */
    public void menuListar() {
        int opcao = 0;
        do {
            this.entrada = new Scanner(System.in);
            System.out.println("----------------------------------");
            System.out.println("--------> LISTAR PRODUTOS <-------");
            System.out.println("----------------------------------");
            System.out.println("|    ID    |    PRODUTO           |");
            System.out.println("==================================");
            this.estoque.listar();
            System.out.println("==================================");
            System.out.println("1 - Detalhar Produto");
            System.out.println("----------------------------------");
            System.out.println("2 - Voltar");
            System.out.println("----------------------------------");
            System.out.println("3 - Excluir Produto");
            System.out.println("----------------------------------");
            System.out.print("Informe sua opção: ");
            try {
                opcao = this.entrada.nextInt();
            } catch (Exception e) {
                System.out.println("==================================");
                System.out.println("Opção inválida!");
                System.out.println("==================================");
            }
        } while (opcao == 0);

        switch (opcao) {
            case 1:
                this.menuDetalhesProduto();
                break;
            case 2:
                this.menuPrincipal();
                break;
            case 3:
                this.menuExcluir();
                break;
            default:
                System.out.println("==================================");
                System.out.println("Opção inválida!");
                System.out.println("==================================");
                this.menuListar();
                break;
        }
    }

    public void menuDetalhesProduto() {
        int opcao = 0;
        int id = 0;
        System.out.println("----------------------------------");
        System.out.println("------> DETALHES DO PRODUTO <-----");
        System.out.println("----------------------------------");

        do {
            System.out.print("Informe o ID ou 1 para voltar: ");
            this.entrada = new Scanner(System.in);

            try {
                id = this.entrada.nextInt();
            } catch (Exception e) {
                System.out.println("==================================");
                System.out.println("Os dados estão incorretos!");
                System.out.println("==================================");
            }

            switch (id) {
                case 1:
                    this.menuListar();
                    break;
                default:
                    Produto produto = this.estoque.buscar(id);
                    if (produto != null) {
                        do {
                            this.entrada = new Scanner(System.in);
                            System.out.println("==================================");
                            System.out.println(produto.toString());
                            System.out.println("==================================");
                            System.out.println("1 - Alterar Produto");
                            System.out.println("----------------------------------");
                            System.out.println("2 - Voltar");
                            System.out.println("----------------------------------");
                            System.out.print("Informe sua opção: ");
                            opcao = entrada.nextInt();

                        } while (opcao == 0);

                        switch (opcao) {
                            case 1:
                                this.menuAlterarProduto(produto);
                                break;
                            case 2:
                                this.menuListar();
                        }

                    } else {
                        System.out.println("==================================");
                        System.out.println("Verifique se o Id está correto.");
                        System.out.println("==================================");
                        this.menuDetalhesProduto();
                    }
                    break;
            }
        } while (id == 0);
    }

    /**
     * @method Responsavel por trazer no menu o nome dos desenvolvedores do sis
     * tema
     */
    public void menuCreditos() {

        int opcao = 0;
        do {
            System.out.println("==================================");
            System.out.println("                                  ");
            System.out.println("       || ESTOQUE SYSTEM ||       ");
            System.out.println("            Versão 1.03           ");
            System.out.println("                                  ");
            System.out.println("==================================");
            System.out.println("-----------> CRÉDITOS <-----------");
            System.out.println("----------------------------------");
            System.out.println(
                    "Programa desenvolvido por:\n"
                    + "==================================\n"        
                    + "Lucas Barretto         RA 2481400\n"
                    + "Brenda Gliceria        RA 2565256\n"
                    + "Nicholas Muniz         RA 2717138\n"
                    + "Diogo Costa            RA 1909108\n"
                    + "Bruno Amaral           RA 2674380");

            System.out.println("==================================");
            System.out.println("1 - Voltar");
            System.out.println("----------------------------------");
            System.out.print("Informe sua opção: ");
            this.entrada = new Scanner(System.in);

            try {
                opcao = this.entrada.nextInt();
            } catch (Exception e) {
                System.out.println("==================================");
                System.out.println("Opção inválida!");
                System.out.println("==================================");
            }
        } while (opcao == 0);

        switch (opcao) {
            case 1:
                this.menuPrincipal();
                break;
            default:
                System.out.println("==================================");
                System.out.println("Opção inválida!");
                System.out.println("==================================");
                this.menuCreditos();
                break;
        }
    }
}
