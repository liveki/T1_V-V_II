package com.t1.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

import com.t1.app.exceptions.MoradorInativoException;
import com.t1.app.exceptions.OperadorComRegistrosException;

public class Condominio {
  private Operador operadorAtual;
  private List<Operador> listaOperadores;
  private List<Morador> listaMoradores;
  private List<Entrega> listaEntregas;

  public Condominio() {
    carregarMoradores();
    carregarOperadores();
    carregarEntregas();
  }

  public void definirOperadorAtual(Operador operador) {
    this.operadorAtual = operador;
  }

  public void incluirOperador(Operador operador) {
    this.listaOperadores.add(operador);
  }

  public void excluirOperador(Operador operador) throws OperadorComRegistrosException {
    boolean temEntregasVinculadas = listaEntregas.stream()
        .anyMatch(entrega -> entrega.getOperador().getNome().equals(operador.getNome()));

    if (temEntregasVinculadas) {
      throw new OperadorComRegistrosException(operador.getNome());
    }

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

  public void retirarEntrega(Entrega entrega, Morador morador) throws MoradorInativoException {
    if (morador.isAtivo()) {
      throw new MoradorInativoException(morador.getNome());
    }

    int indexEntrega = encontrarEntrega(entrega);

    Entrega entregaEncontrada = this.listaEntregas.get(indexEntrega);

    entregaEncontrada.setRetiradaEm(LocalDateTime.now());
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

  private void carregarOperadores() {
    String path = "src/inputFiles/dadosOperador.csv";

    try {
      File arquivo = new File(path);
      Scanner leitor = new Scanner(arquivo);

      List<Operador> operadores = new ArrayList<>();
      leitor.useDelimiter(",");

      while (leitor.hasNextLine()) {
        String data = leitor.nextLine();
        if (!data.isEmpty()) {
          operadores.add(new Operador(data));
        }
      }

      this.listaOperadores = operadores;
      leitor.close();
    } catch (FileNotFoundException e) {
      System.out.println("Erro ao ler o arquivo.");
      e.printStackTrace();
    }
  }

  private void carregarMoradores() {
    String path = "src/inputFiles/dadosMorador.csv";

    try {
      File arquivo = new File(path);
      Scanner leitor = new Scanner(arquivo);

      leitor.useDelimiter(",");
      List<Morador> moradores = new ArrayList<>();

      while (leitor.hasNextLine()) {
        String[] data = leitor.nextLine().split(",");
        moradores.add(new Morador(data[0], data[1], Integer.parseInt(data[2]), Boolean.parseBoolean(data[3])));
      }

      this.listaMoradores = moradores;
      leitor.close();
    } catch (FileNotFoundException e) {
      System.out.println("Erro ao ler o arquivo.");
      e.printStackTrace();
    }
  }

  private void carregarEntregas() {
    String path = "src/inputFiles/dadosEntrega.csv";
    try {
      File arquivo = new File(path);
      Scanner leitor = new Scanner(arquivo);

      leitor.useDelimiter(",");
      List<Entrega> entregas = new ArrayList<>();

      while (leitor.hasNextLine()) {
        String[] data = leitor.nextLine().split(",");

        Operador operadorResponsavel = procurarOperadorPorNome(data[4]);
        Entrega entrega = new Entrega(operadorResponsavel, data[2], Integer.parseInt(data[3]));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime novaData = LocalDateTime.parse(data[1], formatter);

        entrega.setUUID(UUID.nameUUIDFromBytes(data[0].getBytes()));
        entrega.setCriadaEm(novaData);

        if (data.length > 5) {
          Morador moradorQueRetirou = procurarMoradorPorRG(data[6]);
          entrega.setRetiradaPor(moradorQueRetirou);
          entrega.setRetiradaEm(LocalDateTime.parse(data[5]));
        }
        entregas.add(entrega);

      }

      this.listaEntregas = entregas;
      leitor.close();

    } catch (FileNotFoundException e) {
      System.out.println("Erro ao ler o arquivo.");
      e.printStackTrace();
    }
  }

  private Operador procurarOperadorPorNome(String nome) {
    Optional<Operador> operador = listaOperadores.stream().filter(op -> op.toString().equals(nome)).findFirst();

    if (operador.isPresent()) {
      return operador.get();
    }

    return null;
  }

  private Morador procurarMoradorPorRG(String rg) {
    Optional<Morador> morador = listaMoradores.stream().filter(m -> m.getRG().equals(rg)).findFirst();

    if (morador.isPresent()) {
      return morador.get();
    }

    return null;
  }

  public List<Operador> getOperadores() {
    return listaOperadores;
  }
}