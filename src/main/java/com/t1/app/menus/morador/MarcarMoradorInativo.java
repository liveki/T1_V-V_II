package com.t1.app.menus.morador;

import java.util.List;
import java.util.Scanner;

import com.t1.app.Condominio;
import com.t1.app.Morador;

public class MarcarMoradorInativo {
  private Scanner scanner;

  public MarcarMoradorInativo() {
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

  private void listarMoradores(List<Morador> moradores) {
    int indice = 1;

    for (Morador morador : moradores) {
      System.out.println(indice + " - " + morador.getNome());
      indice++;
    }
  }

  public void run(Condominio condominio) {
    listarMoradores(condominio.getMoradores());

    System.out.println("\nSelecione um morador: ");
    int indiceMorador = recebeNumero();

    condominio.getMoradores().get(indiceMorador - 1).setAtivo(false);
  }
}
