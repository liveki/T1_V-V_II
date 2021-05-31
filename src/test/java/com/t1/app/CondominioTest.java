package com.t1.app;

import java.util.Random;

import com.t1.app.exceptions.MoradorInativoException;
import com.t1.app.exceptions.MoradorNaoEncontradoException;
import com.t1.app.exceptions.OperadorComRegistrosException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CondominioTest {
  @Test
  public void excluiOperadorComEntregaVinculadaTest() throws MoradorInativoException, MoradorNaoEncontradoException {
    Condominio c = new Condominio();
    c.definirOperadorAtual(c.getOperadores().get(1));

    Entrega e1 = new Entrega(c.getOperadorAtual(), "Test", 798);
    c.registrarEntrega(e1);

    Assertions.assertThrows(OperadorComRegistrosException.class, () -> {
      c.excluirOperador(c.getOperadorAtual());
    });
  }

  @Test
  public void excluiOperadorSemEntregaVinculadaTest() {
    Condominio c = new Condominio();

    Operador op = new Operador("Operador");
    c.incluirOperador(op);

    int expected = c.getOperadores().size() - 1;

    try {
      c.excluirOperador(op);
    } catch (OperadorComRegistrosException e) {
      e.printStackTrace();
    }

    Assertions.assertTrue(expected == c.getOperadores().size());
  }

  @Test
  public void excluiOperadorInexistenteTest() {
    Condominio c = new Condominio();

    Operador op = new Operador("Operador");

    int expected = c.getOperadores().size();

    try {
      c.excluirOperador(op);
    } catch (OperadorComRegistrosException e) {
      e.printStackTrace();
    }

    Assertions.assertTrue(expected == c.getOperadores().size());
  }

  @Test
  public void marcaMoradorInativoExistenteTest() {
    Random r = new Random();
    Condominio c = new Condominio();

    Morador m = c.listarMoradores().get(r.nextInt(c.listarMoradores().size()));
    c.marcarMoradorInativo(m);

    Assertions.assertTrue(m.isAtivo() == false);
  }

  @Test
  public void marcaMoradorInativoNaoExistenteTest() {
    Condominio c = new Condominio();
    Morador m = new Morador("nome", "rG", 1000, true);

    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
      c.marcarMoradorInativo(m);
    });
  }

  @Test
  public void marcaMoradorInativoJaInativoTest() {
    Random r = new Random();
    Condominio c = new Condominio();

    Morador m = c.listarMoradores().stream().filter(mr -> mr.isAtivo() == false).findAny()
        .orElse(c.listarMoradores().get(r.nextInt(c.listarMoradores().size())));

    c.marcarMoradorInativo(m);

    Assertions.assertTrue(m.isAtivo() == false);
  }

  @Test
  public void retiraEntregaExistenteTest() {
    Random r = new Random();
    Condominio c = new Condominio();
    c.definirOperadorAtual(c.getOperadores().get(r.nextInt(c.getOperadores().size())));
    Entrega e = c.listarEntregasNaoRetiradas().get(r.nextInt(c.listarEntregasNaoRetiradas().size()));
    Morador m = c.listarMoradores().stream().filter(mr -> mr.getNroApartamento() == e.getAptoDestino()).findFirst()
        .orElse(new Morador("Nome", "rg", e.getAptoDestino(), true));

    try {
      c.retirarEntrega(e, m);
    } catch (MoradorInativoException e1) {
      e1.printStackTrace();
    }

    Assertions.assertTrue(e.getRetiradaPor() == m);

  }

  @Test
  public void retiraEntregaInexistenteTest() {
    Random r = new Random();
    Condominio c = new Condominio();
    c.definirOperadorAtual(c.getOperadores().get(r.nextInt(c.getOperadores().size())));
    Entrega e = new Entrega(c.getOperadorAtual(), "string", 101);
    Morador m = c.listarMoradores().get(r.nextInt(c.listarMoradores().size()));

    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
      c.retirarEntrega(e, m);
    });

  }

  @Test
  public void retiraEntregaMoradorInativoTest() {
    Random r = new Random();
    Condominio c = new Condominio();
    c.definirOperadorAtual(c.getOperadores().get(r.nextInt(c.getOperadores().size())));
    Entrega e = c.listarEntregasNaoRetiradas().get(r.nextInt(c.listarEntregasNaoRetiradas().size()));
    Morador m = c.listarMoradores().stream().filter(mr -> mr.isAtivo() == false).findAny()
        .orElse(c.listarMoradores().get(r.nextInt(c.listarMoradores().size())));
    m.setAtivo(false);

    Assertions.assertThrows(MoradorInativoException.class, () -> {
      c.retirarEntrega(e, m);
    });
  }
}
