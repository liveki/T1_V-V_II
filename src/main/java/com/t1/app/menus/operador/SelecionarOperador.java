package com.t1.app.menus.operador;

import java.util.Scanner;

import com.t1.app.Condominio;
import com.t1.app.Operador;

public class SelecionarOperador {
  private Scanner scanner;

  public SelecionarOperador() {
    this.scanner = new Scanner(System.in);
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
    System.out.println("Listando todos os operadores...");

    for (int i = 0; i < condominio.getOperadores().size(); i++)
      System.out.println((i + 1) + " - " + condominio.getOperadores().get(i).getNome());

    System.out.println("\nSelecione um operador: ");
    int indiceOperador = recebeNumero();

    Operador operadorAtual = condominio.getOperadores().get(indiceOperador - 1);
    condominio.definirOperadorAtual(operadorAtual);
  }
}
