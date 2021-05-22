package com.t1.app.exceptions;

public class OperadorComRegistrosException extends Exception {
  public OperadorComRegistrosException(String operador) {
    super("Não é possivel excluir. O operador " + operador + " está vinculado a uma ou mais entregas.");
  }
}
