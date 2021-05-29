package com.t1.app.menus.morador;

import java.util.Scanner;

import com.t1.app.Condominio;

public class MenuMorador {
  private Scanner scanner;
  private ListarMoradores listarMoradores;
  private CadastrarMorador cadastrarMorador;
  private MarcarMoradorInativo marcarMoradorInativo;

  public MenuMorador() {
    this.scanner = new Scanner(System.in);
    this.cadastrarMorador = new CadastrarMorador();
    this.listarMoradores = new ListarMoradores();
    this.marcarMoradorInativo = new MarcarMoradorInativo();
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
    System.out.println("1 - Cadastrar morador");
    System.out.println("2 - Marcar morador inativo");
    System.out.println("3 - Listar moradores");
    System.out.println("4 - Voltar ");

    this.scanner.reset();
    int numOpcao = recebeNumero();

    switch (numOpcao) {
      case 1:
        this.cadastrarMorador.run(condominio);
        this.run(condominio);
        break;
      case 2:
        this.marcarMoradorInativo.run(condominio);
        this.run(condominio);
        break;
      case 3:
        this.listarMoradores.run(condominio);
        this.run(condominio);
        break;
      case 4:
        break;
      default:
        System.out.println("Opção inexistente");
        this.run(condominio);
        break;
    }
  }
}
