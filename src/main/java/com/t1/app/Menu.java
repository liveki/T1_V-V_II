package com.t1.app;

import java.util.Scanner;

import com.t1.app.menus.entrega.MenuEntregas;
import com.t1.app.menus.morador.MenuMorador;
import com.t1.app.menus.operador.MenuOperador;

public class Menu {
  private Condominio condominio;
  private Scanner scanner;
  private MenuMorador menuMorador;
  private MenuOperador menuOperador;
  private MenuEntregas menuEntregas;

  public Menu(Condominio condominio) {
    this.condominio = condominio;
    this.scanner = new Scanner(System.in);
    this.menuMorador = new MenuMorador();
    this.menuOperador = new MenuOperador();
    this.menuEntregas = new MenuEntregas();
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

  public void run() {
    System.out.println("Operador atual: "
        + (condominio.getOperadorAtual() == null ? "Nenhum" : condominio.getOperadorAtual().getNome()));
    System.out.println("-- Menu -- \n");
    System.out.println("1 - Entregas");
    System.out.println("2 - Moradores");
    System.out.println("3 - Operadores");
    System.out.println("4 - Sair");

    this.scanner.reset();
    int numOpcao = recebeNumero();

    this.executarAcao(numOpcao);
  }

  public void executarAcao(int numOpcao) {
    switch (numOpcao) {
      case 1:
        this.menuEntregas.run(condominio);
        this.run();
        break;
      case 2:
        this.menuMorador.run(condominio);
        this.run();
        break;
      case 3:
        this.menuOperador.run(condominio);
        this.run();
        break;
      case 4:
        System.out.println("\nSaindo...");
        break;
      default:
        System.out.println("Opção inexistente");
        this.run();
        break;
    }
  }
}