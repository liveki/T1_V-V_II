package com.t1.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Comdominio {
  private Operador operadorAtual;
  private List<Operador> listaOperadores;
  private List<Morador> listaMoradores;
  private List<Entrega> listaEntregas;

  public Comdominio(Operador operadorAtual, List<Operador> listaOperadores, List<Morador> listaMoradores,
      List<Entrega> listaEntregas) {
    this.operadorAtual = operadorAtual;
    this.listaOperadores = listaOperadores;
    this.listaMoradores = listaMoradores;
    this.listaEntregas = listaEntregas;
  }

  public void definirOperadorAtual(Operador operador) {
    this.operadorAtual = operador;
  }

  public void incluirOperador(Operador operador) {
    this.listaOperadores.add(operador);
  }

  public void excluirOperador(Operador operador) {
    this.listaOperadores.remove(operador);
  }

  public void registrarEntrega(Entrega entrega) {
    this.listaEntregas.add(entrega);
  }

  public void incluirMorador(Morador morador) {
    this.listaMoradores.add(morador);
  }

  public List<Morador> listarMoradores() {
    return this.listaMoradores;
  }

  public void marcarMoradorInativo(Morador morador) {
    int indexMorador = encontrarMorador(morador);

    Morador moradorEncontrado = this.listaMoradores.get(indexMorador);

    moradorEncontrado.setAtivo(false);
  }

  private int encontrarMorador(Morador morador) {
    int indexMorador = -1;

    for (int i = 0; i < listaMoradores.size(); i++) {
      Morador moradorAtual = listaMoradores.get(i);

      if (moradorAtual.getRG().equals(morador.getRG())) {
        indexMorador = i;
        break;
      }
    }

    return indexMorador;
  }

  public void retirarEntrega(Entrega entrega, Morador morador) {
    int indexEntrega = encontrarEntrega(entrega);

    Entrega entregaEncontrada = this.listaEntregas.get(indexEntrega);

    entregaEncontrada.setRetiradaEm(LocalDate.now());
    entregaEncontrada.setRetiradaPor(morador);
  }

  private int encontrarEntrega(Entrega entrega) {
    int indexEntrega = -1;

    for (int i = 0; i < listaEntregas.size(); i++) {
      Entrega entregaAtual = listaEntregas.get(i);

      if (entregaAtual.getId() == entrega.getId()) {
        indexEntrega = i;
        break;
      }
    }

    return indexEntrega;
  }

  public List<Entrega> procurarEntregaPorDescricao(String termoPesquisa) {
    List<Entrega> entregasEncontradas = new ArrayList<>(0);

    for (Entrega entrega : listaEntregas) {
      if (entrega.getDescricao().contains(termoPesquisa)) {
        entregasEncontradas.add(entrega);
      }
    }

    return entregasEncontradas;
  }

  public List<Entrega> listarEntregasNaoRetiradas() {
    List<Entrega> entregasEncontradas = new ArrayList<>(0);

    listaEntregas.forEach(e -> {
      if (e.getRetiradaPor() == null) {
        entregasEncontradas.add(e);
      }
    });

    return entregasEncontradas;
  }

  public String gerarDadosDashboard() {
    /*
     * 12. Deverá haver um painel (dashboard) com as seguintes informações: a. Nro
     * total de entregas nos últimos 30 dias. b. Quantidade de entregas ainda não
     * retiradas (total). c. Tempo médio entre registro e retirada das entrega
     */
    return "";
  }

  public String gerarRelatorioEntregas(LocalDate dataInicial, LocalDate dataFinal) {
    /*
     * Deverá ser possível gerar um relatório como o exemplo abaixo, entre uma data
     * inicial e uma data final escolhidas pelo operador (note que há entregas ainda
     * não retiradas):
     */
    return "";
  }

  public void carregarOperadores() {
    // TODO: LER UM ARQUIVO .TXT COM DADOS PREVIAMENTE CADASTRADOS
  }

  public void carregarMoradores() {
    // TODO: LER UM ARQUIVO .TXT COM DADOS PREVIAMENTE CADASTRADOS
  }

  public void carregarEntregas() {
    // TODO: LER UM ARQUIVO .TXT COM DADOS PREVIAMENTE CADASTRADOS
  }
}
