package com.t1.app.menus.entrega;

import java.util.List;
import java.util.Scanner;

import com.t1.app.Condominio;
import com.t1.app.Entrega;
import com.t1.app.Morador;
import com.t1.app.exceptions.MoradorInativoException;
import com.t1.app.exceptions.MoradorNaoEncontradoException;

public class RetirarEntrega {
  private Scanner scanner;

  public RetirarEntrega() {
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

  public void run(ListarEntregasNaoRetiradas listarEntregasNaoRetiradas, Condominio condominio) {
    boolean isInvalidNumber = true;
    boolean isInvalidId = true;
    List<Entrega> entregasNaoRetiradas = condominio.listarEntregasNaoRetiradas();
    Morador moradorQueVaiRetirar = null;
    Entrega entrega = null;

    listarEntregasNaoRetiradas.run(condominio);

    if (condominio.listarEntregasNaoRetiradas().size() > 0) {

      while (isInvalidId) {
        System.out.print("Selecione o id da entrega que deseja retirar: ");
        int id = recebeNumero();

        entrega = entregasNaoRetiradas.stream().filter(e -> e.getId() == id).findFirst().orElse(null);

        if (entrega == null) {
          System.out.println("id de entrega inválido!");
        } else {
          isInvalidId = false;
        }
      }

      while (isInvalidNumber) {
        System.out.print("Coloque o numero do apartamento do morador que vai retirar a entrega: ");
        int numeroApartamento = recebeNumero();

        moradorQueVaiRetirar = condominio.procurarMoradorPorApto(numeroApartamento);
        isInvalidNumber = false;
      }

      try {
        condominio.retirarEntrega(entrega, moradorQueVaiRetirar);
      } catch (MoradorInativoException e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
