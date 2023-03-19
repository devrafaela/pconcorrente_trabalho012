package model;

import javafx.scene.control.Label;

public class StatusLabel extends Thread {
  
  private final String STATUS;
  private final Label LABEL;

  public StatusLabel(String status, Label label) {
    this.STATUS = status;
    this.LABEL = label;
  }

  public void run() {
    System.out.println(STATUS);
    LABEL.setText(STATUS);
  }
}
