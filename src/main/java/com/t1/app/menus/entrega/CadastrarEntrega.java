package com.t1.app.menus.entrega;

import java.util.Scanner;

import com.t1.app.Condominio;
import com.t1.app.Entrega;
import com.t1.app.Operador;

public class CadastrarEntrega {
  private Scanner scanner;

  public CadastrarEntrega() {
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
    System.out.println("Digite a descrição da entrega: ");

    String descricaoPedido = this.scanner.nextLine();

    System.out.println("Digite o nome do operador que recebeu: ");
    String nomeOperador = this.scanner.nextLine();

    System.out.println("Digite o número do apartamento: ");
    Integer numeroApartamento = recebeNumero();

    Operador operadorResponsavel = new Operador(nomeOperador);
    Entrega entrega = new Entrega(operadorResponsavel, descricaoPedido, numeroApartamento);

    condominio.registrarEntrega(entrega);

    System.out.println("Entrega cadastrada ");
  }
}
