package com.t1.app.menus.entrega;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.t1.app.Condominio;
import com.t1.app.Entrega;

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
    List<Entrega> entregas = condominio.getEntregas();
    List<Entrega> entregasEntreAsDatas = new ArrayList<>();

    for (Entrega entrega : entregas) {
      boolean isBefore = entrega.getCriadaEm().isBefore(dataFinal);
      boolean isAfter = entrega.getCriadaEm().isAfter(dataInicial);

      if (isBefore && isAfter) {
        entregasEntreAsDatas.add(entrega);
      }
    }

    String leftAlignFormat = "| %-8d | %-19s |";
    String leftAlignFormat2 = " %-50s | %-5d |";
    String leftAlignFormat3 = " %-8s | %-19s |";
    String leftAlignFormat4 = "%-20s |%n";
    System.out.format(
        "+----------+---------------------+----------------------+-----------------------------+-------+----------+---------------------+---------------------+%n");
    System.out.format(
        "| Entrega  |      Data/hora      |                    Descricao                       |  Apto | Operador |      Retirada       |        Morador      |%n");
    System.out.format(
        "+----------+---------------------+----------------------+-----------------------------+-------+----------+---------------------+---------------------+%n");
    for (Entrega entregasEntreAsData : entregasEntreAsDatas) {
      if (entregasEntreAsData.getRetiradaEm() == null && entregasEntreAsData.getRetiradaPor() == null) {
        System.out.format(leftAlignFormat, entregasEntreAsData.getId(),
            entregasEntreAsData.getCriadaEm().toString().substring(0, 19).replace('T', ' '));
        System.out.format(leftAlignFormat2, entregasEntreAsData.getDescricao(), entregasEntreAsData.getAptoDestino());
        System.out.format(leftAlignFormat3, entregasEntreAsData.getOperador(), "NR");
        System.out.format(leftAlignFormat4, "NR");
      } else {
        System.out.format(leftAlignFormat, entregasEntreAsData.getId(),
            entregasEntreAsData.getCriadaEm().toString().substring(0, 19).replace('T', ' '));
        System.out.format(leftAlignFormat2, entregasEntreAsData.getDescricao(), entregasEntreAsData.getAptoDestino());
        System.out.format(leftAlignFormat3, entregasEntreAsData.getOperador(),
            entregasEntreAsData.getRetiradaEm().toString().substring(0, 19).replace('T', ' '));
        System.out.format(leftAlignFormat4, entregasEntreAsData.getRetiradaPor().getNome());
      }
    }
    System.out.format(
        "+----------+---------------------+----------------------+-----------------------------+-------+----------+---------------------+---------------------+%n");
    System.out.println("NR = Nao retirado \n");
  }
}
