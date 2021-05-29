package com.t1.app.menus.entrega;

import java.util.List;
import java.util.Scanner;

import com.t1.app.Condominio;
import com.t1.app.Entrega;

public class PesquisarPorDescricao {
  private Scanner scanner;

  public PesquisarPorDescricao() {
    this.scanner = new Scanner(System.in);
  }

  public void run(Condominio condominio) {
    System.out.println("Digite a descrição desejada:");

    String descricao = scanner.nextLine();

    List<Entrega> entregasFiltradas = condominio.procurarEntregaPorDescricao(descricao);

    System.out.println("-- Entregas que contenham a descrição: " + descricao + " -- \n");

    if (entregasFiltradas.size() > 0) {
      for (Entrega entrega : entregasFiltradas) {
        System.out.println(entrega.toString());
      }
      System.out.println("\n\n");
    } else {
      System.out.println("Nenhuma entrega contem a descrição buscada");
    }
  }
}
