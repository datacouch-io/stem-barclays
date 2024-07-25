package ocp.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;


/**
 * This class represents a refactored solution to the OCP problem.
 * This can be treated as an intermittent solution to the problem where
 * the responsibilities are separated based on the SRP principle.
 *
 * */
public class V1Parser {
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
          VariableHandler variableHandler = new VariableHandler();
          variableHandler.execute(line);
          break;
        case '#':
          CustomCommandHandler customCommandHandler = new CustomCommandHandler();
          customCommandHandler.execute(line);
          break;
        case '@':
          DirectiveHandler directiveHandler = new DirectiveHandler();
          directiveHandler.execute(line);
          break;
        default:
          ScopeHandler scopeHandler = new ScopeHandler();
          scopeHandler.execute(line);
          break;
      }
      line = reader.readLine();
    }
  }

}
