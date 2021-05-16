package com.t1.app;

public class Morador {
  private String nome;
  private String RG;
  private int nroApartamento;
  private boolean isAtivo;

  public Morador(String nome, String rG, int nroApartamento, boolean isAtivo) {
    this.nome = nome;
    RG = rG;
    this.nroApartamento = nroApartamento;
    this.isAtivo = isAtivo;
  }

  public String getNome() {
    return nome;
  }

  public String getRG() {
    return RG;
  }

  public int getNroApartamento() {
    return nroApartamento;
  }

  public boolean isAtivo() {
    return isAtivo;
  }

  public void setAtivo(boolean isAtivo) {
    this.isAtivo = isAtivo;
  }
}
