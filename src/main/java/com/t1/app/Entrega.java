package com.t1.app;

import java.time.LocalDate;

public class Entrega {
  private int id;
  private Morador retiradaPor;
  private LocalDate criadaEm;
  private LocalDate retiradaEm;
  private Operador operador;
  private String descricao;

  public Entrega(int id, Operador operador, String descricao) {
    this.id = id;
    this.criadaEm = LocalDate.now();
    this.operador = operador;
    this.descricao = descricao;
  }

  public int getId() {
    return id;
  }

  public Morador getRetiradaPor() {
    return retiradaPor;
  }

  public void setRetiradaPor(Morador retiradaPor) {
    this.retiradaPor = retiradaPor;
  }

  public LocalDate getCriadaEm() {
    return criadaEm;
  }

  public LocalDate getRetiradaEm() {
    return retiradaEm;
  }

  public void setRetiradaEm(LocalDate retiradaEm) {
    this.retiradaEm = retiradaEm;
  }

  public Operador getOperador() {
    return operador;
  }

  public String getDescricao() {
    return descricao;
  }
}
