package com.t1.app;

public class GeradorId {
  private int id = 1;

  public GeradorId(int comecaEm) {
    this.id = comecaEm;
  }

  public int getProximoId() {
    return id++;
  }
}
