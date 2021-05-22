package com.t1.app.exceptions;

public class MoradorInativoException extends Exception {
  public MoradorInativoException(String morador) {
    super("O morador " + morador + " não pode ser associado a entregas por que está inativo.");
  }
}
