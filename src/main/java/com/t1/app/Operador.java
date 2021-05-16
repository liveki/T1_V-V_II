package com.t1.app;

public class Operador {
  private String nome;

  public Operador(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  @Override
  public String toString() {
    String[] iniciaisNome = nome.split(" ");
    StringBuilder sb = new StringBuilder();

    for (String s : iniciaisNome) {
      sb.append(s.toUpperCase().charAt(0));
    }

    return sb.toString();
  }
}
