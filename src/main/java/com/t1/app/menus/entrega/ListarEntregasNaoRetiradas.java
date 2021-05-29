package com.t1.app.menus.entrega;

import java.util.Comparator;
import java.util.List;

import com.t1.app.Condominio;
import com.t1.app.DateFormatter;
import com.t1.app.Entrega;

public class ListarEntregasNaoRetiradas {
  public void run(Condominio condominio) {
    List<Entrega> entregasNaoRetiradas = condominio.listarEntregasNaoRetiradas();
    Comparator<Entrega> comparaData = Comparator.comparing(Entrega::getCriadaEm).reversed();
    entregasNaoRetiradas.sort(comparaData);

    String leftAlignFormat = "| %-8d | %-10s | %-30s | %-4d | %-8s |%n";

    System.out.println("Entregas não retiradas:\n");

    System.out.format("+----------+----------------+--------------------------------+------+----------+%n");
    System.out.format("| Entrega  |    Data/Hora   | Descricao                      | Apto | Operador |%n");
    System.out.format("+----------+----------------+--------------------------------+------+----------+%n");

    if (entregasNaoRetiradas.size() > 0) {
      for (Entrega entrega : entregasNaoRetiradas) {
        String dataCompleta = DateFormatter.getDataEmFormatoTexto(entrega.getCriadaEm()) + " "
            + DateFormatter.getHorarioEmFormatoTexto(entrega.getCriadaEm());

        System.out.format(leftAlignFormat, entrega.getId(), dataCompleta, entrega.getDescricao(),
            entrega.getAptoDestino(), entrega.getOperador());
      }
      System.out.format("+----------+----------------+--------------------------------+------+----------+%n");
    } else {
      System.out.println("Todas as entregas foram retiradas");
    }
  }
}
