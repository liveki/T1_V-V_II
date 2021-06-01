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
    String nomeMorador = "";
    String rgMorador = "";
    Integer numeroApartamento = -1;
    /*
     * while (nomeMorador.length() <= 3) {
     * System.out.println("Digite o nome do morador: "); nomeMorador =
     * this.scanner.nextLine(); if (condominio.procurarMoradorPorNome(nomeMorador)
     * != null) {
     * System.out.println("Ja existe um morador cadastrado com esse nome ");
     * nomeMorador = "ab"; } }
     */
    boolean isInvalidNome = true;
    while (isInvalidNome) {
      System.out.print("Digite o nome do morador: ");
      nomeMorador = this.scanner.nextLine();

      if (nomeMorador.length() <= 5) {
        System.out.println("Nome Invalido! ");
      } else {
        isInvalidNome = false;
      }
    }
    while (rgMorador.length() != 10) {
      System.out.println("Digite o RG do morador: ");
      rgMorador = this.scanner.nextLine();
      if (condominio.procurarMoradorPorRG(rgMorador) != null) {
        System.out.println("Ja existe um morador cadastrado com esse RG ");
        rgMorador = "0";
      }
    }
    while (numeroApartamento <= -1) {
      System.out.println("Digite o número do apartamento: ");
      numeroApartamento = recebeNumero();
      if (condominio.procurarMoradorPorApto(numeroApartamento) != null) {
        System.out.println("Ja existe um morador cadastrado neste apartamento ");
        numeroApartamento = -1;
      }
    }
    final Morador morador = new Morador(nomeMorador, rgMorador, numeroApartamento, true);

    condominio.incluirMorador(morador);
  }
}
