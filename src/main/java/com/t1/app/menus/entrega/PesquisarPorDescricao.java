package com.t1.app.menus.entrega;

import java.util.List;
import java.util.Scanner;

import com.t1.app.Condominio;
import com.t1.app.DateFormatter;
import com.t1.app.Entrega;

public class PesquisarPorDescricao {
  private Scanner scanner;

  public PesquisarPorDescricao() {
    this.scanner = new Scanner(System.in);
  }

  public void run(Condominio condominio) {
    String leftAlignFormat = "| %-8d | %-10s | %-30s | %-4d | %-8s |%n";

    System.out.println("Digite a descrição desejada:");

    String descricao = scanner.nextLine();

    List<Entrega> entregasFiltradas = condominio.procurarEntregaPorDescricao(descricao);

    System.out.println("Entregas que contenham a descrição: " + descricao + "\n");

    System.out.format("+----------+----------------+--------------------------------+------+----------+%n");
    System.out.format("| Entrega  |    Data/Hora   | Descricao                      | Apto | Operador |%n");
    System.out.format("+----------+----------------+--------------------------------+------+----------+%n");

    if (entregasFiltradas.size() > 0) {
      for (Entrega entrega : entregasFiltradas) {
        String dataCompleta = DateFormatter.getDataEmFormatoTexto(entrega.getCriadaEm()) + " "
            + DateFormatter.getHorarioEmFormatoTexto(entrega.getCriadaEm());

        System.out.format(leftAlignFormat, entrega.getId(), dataCompleta, entrega.getDescricao(),
            entrega.getAptoDestino(), entrega.getOperador());
      }
      System.out.println("\n\n");
    } else {
      System.out.println("Nenhuma entrega contem a descrição buscada");
    }
  }
}
