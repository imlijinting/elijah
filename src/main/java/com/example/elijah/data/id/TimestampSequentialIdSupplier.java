package com.example.elijah.data.id;

import static org.apache.commons.lang3.StringUtils.EMPTY;

import com.example.elijah.config.CustomApplicationProperties;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Generates 19-digit ids. 60*1_000*1_000 per minute in max.
 *
 * @author lijinting01
 */
@Component
public class TimestampSequentialIdSupplier implements IdSupplier {

  private static final int SEQUENCE_POW = 3;

  /**
   * sequence max = 1000
   */
  private static final int SEQUENCE_MAX = 1_000;

  private static final char SEQUENCE_PAD = '0';

  /**
   * Timestamp to millisecond
   */
  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmssSSS");

  private final String idcCode;

  private JdbcTemplate jdbcTemplate;

  public TimestampSequentialIdSupplier(CustomApplicationProperties properties,
      JdbcTemplate jdbcTemplate) {

    int idc = properties.getIdcCode();
    if (idc < 0 || idc > 9) {
      throw new IllegalArgumentException("idc-code shall range from 0-9");
    }
    this.idcCode = String.valueOf(idc);
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public String get() {
    String timestamp = formatter.format(LocalDateTime.now());
    return String.join(EMPTY, timestamp, idcCode, nextId());
  }

  private String nextId() {
    int next = Optional.ofNullable(jdbcTemplate
        .queryForObject("SELECT seq_id_counter.nextval FROM dual", Integer.class))
        .orElseThrow(IllegalStateException::new);
    if (next < SEQUENCE_MAX) {
      return padSequence(next);
    }
    return padSequence(next % SEQUENCE_MAX);
  }

  private String padSequence(int next) {
    return StringUtils
        .leftPad(String.valueOf(next), SEQUENCE_POW, SEQUENCE_PAD);
  }
}
