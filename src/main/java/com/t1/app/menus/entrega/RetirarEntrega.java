package com.t1.app.menus.entrega;

import java.util.List;
import java.util.Scanner;

import com.t1.app.Condominio;
import com.t1.app.Entrega;
import com.t1.app.Morador;
import com.t1.app.exceptions.MoradorInativoException;

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
    boolean testandoNumeroApartamento = false;
    boolean testandoId = false;
    List<Entrega> entregasNaoRetiradas = condominio.listarEntregasNaoRetiradas();

    listarEntregasNaoRetiradas.run(condominio);

    if (condominio.listarEntregasNaoRetiradas().size() > 0) {
      System.out.print("Selecione o id da entrega que deseja retirar: ");
      int id = recebeNumero();

      for (Entrega entregasNaoRetirada : entregasNaoRetiradas) {
        if (id == entregasNaoRetirada.getId()) {
          testandoId = true;
        }
      }

      if (testandoId) {
        List<Morador> moradorQueVaiRetirar = condominio.listarMoradores();
        System.out.print("Coloque o numero do apartamento do morador que vai retirar a entrega: ");
        int numeroApartamento = recebeNumero();
        for (Morador morador : moradorQueVaiRetirar) {
          if (numeroApartamento == morador.getNroApartamento()) {
            testandoNumeroApartamento = true;
            for (Entrega entregaNaoRetirada : entregasNaoRetiradas) {
              if (id == entregaNaoRetirada.getId()) {
                try {
                  condominio.retirarEntrega(entregaNaoRetirada, morador);
                } catch (MoradorInativoException e) {
                  System.out.println(e.getMessage());
                }
              }
            }
          }
        }
      }
      if (!testandoId) {
        System.out.println("Erro: Id nao localizado");
      } else if (!testandoNumeroApartamento) {
        System.out.println("Erro: Numero de apartamento nao localizado");
      }
    }
  }
}
