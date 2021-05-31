package com.t1.app.menus.entrega;

import java.util.Scanner;

import com.t1.app.Condominio;

public class MenuEntregas {
  private Scanner scanner;
  private CadastrarEntrega cadastrarEntrega;
  private RetirarEntrega retirarEntrega;
  private ListarEntregasNaoRetiradas listarEntregasNaoRetiradas;
  private PesquisarPorDescricao pesquisarPorDescricao;
  private GerarRelatorio gerarRelatorio;
  private GerarDashboard gerarDashboard;

  public MenuEntregas() {
    this.scanner = new Scanner(System.in);
    this.cadastrarEntrega = new CadastrarEntrega();
    this.retirarEntrega = new RetirarEntrega();
    this.listarEntregasNaoRetiradas = new ListarEntregasNaoRetiradas();
    this.pesquisarPorDescricao = new PesquisarPorDescricao();
    this.gerarRelatorio = new GerarRelatorio();
    this.gerarDashboard = new GerarDashboard();
  }

  private Integer recebeNumero() {
    while (true) {
      String aux = this.scanner.nextLine();
      aux = aux.replaceAll(" ", "");
      if (aux.matches("^\\d+$")) {
        return Integer.parseInt(aux);
      }
      System.out.println("Valor inválido, digite um número válido: ");
    }
  }

  public void run(Condominio condominio) {
    System.out.println("1 - Cadastrar entrega");
    System.out.println("2 - Retirar entrega");
    System.out.println("3 - Listar entregas não retiradas");
    System.out.println("4 - Procurar entrega por descrição ");
    System.out.println("5 - Gerar relatório ");
    System.out.println("6 - Visualizar dashboard ");
    System.out.println("7 - Voltar ");

    this.scanner.reset();
    int numOpcao = recebeNumero();

    switch (numOpcao) {
      case 1:
        this.cadastrarEntrega.run(condominio);
        this.run(condominio);
        break;
      case 2:
        this.retirarEntrega.run(listarEntregasNaoRetiradas, condominio);
        this.run(condominio);
        break;
      case 3:
        this.listarEntregasNaoRetiradas.run(condominio);
        this.run(condominio);
        break;
      case 4:
        this.pesquisarPorDescricao.run(condominio);
        this.run(condominio);
        break;
      case 5:
        this.gerarRelatorio.run(condominio);
        this.run(condominio);
        break;
      case 6:
        this.gerarDashboard.run(condominio);
        this.run(condominio);
        break;
      case 7:
        return;
      default:
        System.out.println("Opção inexistente");
        this.run(condominio);
        break;
    }
  }
}
