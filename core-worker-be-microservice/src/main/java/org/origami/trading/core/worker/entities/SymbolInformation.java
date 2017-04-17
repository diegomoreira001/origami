package org.origami.trading.core.worker.entities;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "symbols_information")
public class SymbolInformation {

  @Id
  private String siTicker;
  private String siInformation;


  public String getSiTicker() {
    return siTicker;
  }

  public void setSiTicker(String siTicker) {
    this.siTicker = siTicker;
  }


  public String getSiInformation() {
    return siInformation;
  }

  public void setSiInformation(String siInformation) {
    this.siInformation = siInformation;
  }

}
