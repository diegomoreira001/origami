CREATE SCHEMA origami;
CREATE TABLE origami.origami_properties (
  op_id VARCHAR(32) not null,
  op_value VARCHAR(32) not null
);

CREATE TABLE origami.symbols_information (
  si_ticker VARCHAR(8) not null,
  si_information VARCHAR(512) NOT NULL
);
CREATE TABLE origami.historical_daily_bars (
  hi_ticker VARCHAR(8) not null,
  hi_timestamp TIMESTAMP not null,
  hi_close FLOAT not null,
  hi_open FLOAT,
  hi_low FLOAT,
  hi_high FLOAT,
  hi_change FLOAT
);
