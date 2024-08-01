package ocp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class V0Parser {

  private String textToProcess;

  public void setTextToProcess(String textToProcess) {
    this.textToProcess = textToProcess;
  }

  public void parse() throws IOException {

    BufferedReader reader = new BufferedReader(new StringReader(textToProcess));
    String line = reader.readLine();

    while (line != null) {
      switch (line.charAt(0)) {
        case '$':
          addToVariables(line);
          break;
        case '#':
          runCustomCommand(line);
          break;
        case '@':
          processDirective(line);
          break;
        default:
          executeScope(line);
          break;
      }
      line = reader.readLine();
    }
  }

  private void processDirective(String line) {
    // process directive
  }

  private void runCustomCommand(String line) {
    // custom command parser
  }

  private void executeScope(String scope) {
    // execute scope
  }

  private void addToVariables(String line) {
    // add to variables
  }
}
