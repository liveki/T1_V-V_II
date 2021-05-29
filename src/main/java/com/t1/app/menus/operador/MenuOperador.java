package com.t1.app.menus.operador;

import java.util.Scanner;

import com.t1.app.Condominio;

public class MenuOperador {
  private Scanner scanner;
  private CadastrarOperador cadastrarOperador;
  private SelecionarOperador selecionarOperador;
  private ExcluirOperador excluirOperador;

  public MenuOperador() {
    this.scanner = new Scanner(System.in);
    this.cadastrarOperador = new CadastrarOperador();
    this.selecionarOperador = new SelecionarOperador();
    this.excluirOperador = new ExcluirOperador();
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
    System.out.println("1 - Cadastrar operador");
    System.out.println("2 - Selecionar operador");
    System.out.println("3 - Excluir operador");
    System.out.println("4 - Voltar ");

    this.scanner.reset();
    int numOpcao = recebeNumero();

    switch (numOpcao) {
      case 1:
        this.cadastrarOperador.run(condominio);
        this.run(condominio);
        break;
      case 2:
        this.selecionarOperador.run(condominio);
        this.run(condominio);
        break;
      case 3:
        this.excluirOperador.run(condominio);
        this.run(condominio);
        break;
      case 4:
        return;
      default:
        System.out.println("Opção inexistente");
        this.run(condominio);
        break;
    }
  }
}
