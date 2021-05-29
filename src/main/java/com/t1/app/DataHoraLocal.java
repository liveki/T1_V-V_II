package com.t1.app;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DataHoraLocal {
  public static LocalDateTime agora() {
    return ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).toLocalDateTime();
  }
}
