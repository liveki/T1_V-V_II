package com.t1.app.menus.entrega;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.t1.app.Condominio;
import com.t1.app.DateFormatter;
import com.t1.app.Entrega;
import com.t1.app.Morador;

public class GerarRelatorio {
  private Scanner scanner;

  public GerarRelatorio() {
    this.scanner = new Scanner(System.in);
  }

  public void run(Condominio condominio) {
    System.out.println("Insira a data inicial do relatorio (dd/MM/yyyy HH:mm)");
    String pegaDataInicial = scanner.nextLine().trim();

    if (pegaDataInicial.length() == 16) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
      LocalDateTime dataInicial = LocalDateTime.parse(pegaDataInicial, formatter);

      System.out.println("Agora Insira a data final do relatorio (dd/MM/yyyy HH:mm)");

      String pegaDataFinal = scanner.nextLine().trim();

      if (pegaDataFinal.length() == 16) {
        LocalDateTime dataFinal = LocalDateTime.parse(pegaDataFinal, formatter);
        this.gerarRelatorio(dataInicial, dataFinal, condominio);
      } else {
        System.out.println("Data invalida.");
      }
    } else {
      System.out.println("Data invalida.");
    }
  }

  private void gerarRelatorio(LocalDateTime dataInicial, LocalDateTime dataFinal, Condominio condominio) {
    List<Entrega> entregasEntreAsDatas = condominio.gerarRelatorio(dataInicial, dataFinal);

    if (entregasEntreAsDatas.size() == 0) {
      System.out.println("Nenhum entrega entre as datas escolhias.");
      return;
    }

    String leftAlignFormat = "| %-8d | %-10s | %-30s | %-4d | %-8s | %-15s | %-20s |%n";

    System.out.println("Resultado:\n");

    System.out.format(
        "+----------+----------------+--------------------------------+------+----------+-----------------+----------------------+%n");
    System.out.format(
        "| Entrega  |    Data/Hora   | Descricao                      | Apto | Operador |     Retirada    |       Morador        |%n");
    System.out.format(
        "+----------+----------------+--------------------------------+------+----------+-----------------+----------------------+%n");

    for (Entrega entrega : entregasEntreAsDatas) {
      LocalDateTime retiradaEm = entrega.getRetiradaEm();
      String criadaEm = DateFormatter.getDataEmFormatoTexto(entrega.getCriadaEm()) + " "
          + DateFormatter.getHorarioEmFormatoTexto(entrega.getCriadaEm());

      String dataRetirada = retiradaEm == null ? ""
          : DateFormatter.getDataEmFormatoTexto(retiradaEm) + " " + DateFormatter.getHorarioEmFormatoTexto(retiradaEm);
      Morador morador = entrega.getRetiradaPor();

      String retiradaPor = morador == null ? "" : morador.getNome();

      System.out.format(leftAlignFormat, entrega.getId(), criadaEm, entrega.getDescricao(), entrega.getAptoDestino(),
          entrega.getOperador().toString(), dataRetirada, retiradaPor);
    }
    System.out.format(
        "+----------+----------------+--------------------------------+------+----------+-----------------+----------------------+%n");
    System.out.println("NR = Nao retirado \n");
  }
}
