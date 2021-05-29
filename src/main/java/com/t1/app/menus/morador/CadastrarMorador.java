package com.t1.app.menus.morador;

import java.util.Scanner;

import com.t1.app.Condominio;
import com.t1.app.Morador;

public class CadastrarMorador {
  private Scanner scanner;

  public CadastrarMorador() {
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
    System.out.println("Digite o nome do morador: ");
    final String nomeOperador = this.scanner.nextLine();

    System.out.println("Digite o RG do morador: ");
    final String rgMorador = this.scanner.nextLine();

    System.out.println("Digite o número do apartamento: ");
    final Integer numeroApartamento = recebeNumero();

    final Morador morador = new Morador(nomeOperador, rgMorador, numeroApartamento, true);

    condominio.incluirMorador(morador);
  }
}
