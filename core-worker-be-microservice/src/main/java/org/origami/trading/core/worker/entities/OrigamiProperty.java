package org.origami.trading.core.worker.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "origami_properties")
public class OrigamiProperty {

  @Id
  private String opId;
  private String opValue;


  public String getOpId() {
    return opId;
  }

  public void setOpId(String opId) {
    this.opId = opId;
  }


  public String getOpValue() {
    return opValue;
  }

  public void setOpValue(String opValue) {
    this.opValue = opValue;
  }

}
