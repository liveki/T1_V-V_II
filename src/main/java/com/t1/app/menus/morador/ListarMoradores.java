package com.t1.app.menus.morador;

import java.util.List;

import com.t1.app.Condominio;
import com.t1.app.Morador;

public class ListarMoradores {
  public void run(Condominio condominio) {
    List<Morador> moradores = condominio.listarMoradores();

    String leftAlignFormat = "| %-20s | %-11s | %-10d |%n";

    System.out.format("+----------------------+-------------+------------+%n");
    System.out.format("|       Nome           |   RG        |  Apto      |%n");
    System.out.format("+----------------------+-------------+------------+%n");

    if (moradores.size() > 0) {
      for (Morador morador : moradores) {
        System.out.format(leftAlignFormat, morador.getNome(), morador.getRG(), morador.getNroApartamento());
        System.out.format("+----------------------+-------------+------------+%n");
      }
      System.out.println("\n\n");
    } else {
      System.out.println("Nenhum morador cadastrado");
    }
  }
}
