package com.t1.app;

import java.time.LocalDateTime;
import java.util.UUID;

public class Entrega {
  private UUID id;
  private Morador retiradaPor;
  private LocalDateTime criadaEm;
  private LocalDateTime retiradaEm;
  private Operador operador;
  private String descricao;
  private int aptoDestino;

  public Entrega(Operador operador, String descricao, int aptoDestino) {
    this.id = UUID.randomUUID();
    this.criadaEm = LocalDateTime.now();
    this.operador = operador;
    this.descricao = descricao;
    this.aptoDestino = aptoDestino;
  }

  public UUID getId() {
    return id;
  }

  public void setUUID(UUID id) {
    this.id = id;
  }

  public Morador getRetiradaPor() {
    return retiradaPor;
  }

  public void setRetiradaPor(Morador retiradaPor) {
    this.retiradaPor = retiradaPor;
  }

  public LocalDateTime getCriadaEm() {
    return criadaEm;
  }

  public void setCriadaEm(LocalDateTime criadaEm) {
    this.criadaEm = criadaEm;
  }

  public LocalDateTime getRetiradaEm() {
    return retiradaEm;
  }

  public void setRetiradaEm(LocalDateTime retiradaEm) {
    this.retiradaEm = retiradaEm;
  }

  public Operador getOperador() {
    return operador;
  }

  public String getDescricao() {
    return descricao;
  }

  public int getAptoDestino() {
    return aptoDestino;
  }

  public void setAptoDestino(int aptoDestino) {
    this.aptoDestino = aptoDestino;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append(this.getCriadaEm() + "|").append(this.descricao + "|    ").append(this.getAptoDestino() + "   |")
        .append(this.operador.toString() + "|");

    return sb.toString();
  }
}
