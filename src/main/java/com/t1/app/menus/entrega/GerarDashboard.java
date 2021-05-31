package com.t1.app.menus.entrega;

import java.time.Duration;
import java.time.LocalDateTime;

import com.t1.app.Condominio;
import com.t1.app.DataHoraLocal;
import com.t1.app.Entrega;

public class GerarDashboard {
  public void run(Condominio condominio) {
    LocalDateTime dataInicial = DataHoraLocal.agora().minusDays(30);
    LocalDateTime dataFinal = DataHoraLocal.agora();

    int qtdEntregasNoPeriodo = condominio.gerarRelatorio(dataInicial, dataFinal).size();
    int qtdadeEntregasNaoRetiradas = condominio.listarEntregasNaoRetiradas().size();

    long mediaHoras = 0;

    for (Entrega entrega : condominio.getEntregas()) {
      if (entrega.getRetiradaEm() != null) {
        Duration duration = Duration.between(entrega.getCriadaEm(), entrega.getRetiradaEm());

        mediaHoras += duration.toHours();
      }
    }

    mediaHoras = mediaHoras / (condominio.getEntregas().size() - qtdadeEntregasNaoRetiradas);

    System.out.println("Nro total de entregas nos ultimos 30 dias: " + qtdEntregasNoPeriodo);
    System.out.println("Quantidade de entregas ainda não retiradas: " + qtdadeEntregasNaoRetiradas);
    System.out.println("Media em horas entre registro/retirada de entregas: " + mediaHoras);
  }
}
