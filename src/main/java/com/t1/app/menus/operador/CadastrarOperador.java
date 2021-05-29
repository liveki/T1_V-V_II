package com.t1.app.menus.operador;

import java.util.Scanner;

import com.t1.app.Condominio;
import com.t1.app.Operador;

public class CadastrarOperador {
  private Scanner scanner;

  public CadastrarOperador() {
    this.scanner = new Scanner(System.in);
  }

  public void run(Condominio condominio) {
    System.out.println("Digite o nome do operador: ");
    String nomeOperador = this.scanner.nextLine();

    Operador novoOperador = new Operador(nomeOperador);

    condominio.incluirOperador(novoOperador);

    System.out.println("Operador cadastrado com sucesso!");
    this.scanner.reset();
  }
}
