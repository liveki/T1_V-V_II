package com.t1.app.exceptions;

public class MoradorNaoEncontradoException extends Exception {
  public MoradorNaoEncontradoException() {
    super("Morador não encontrado");
  }
}
