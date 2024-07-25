package ocp.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is a better refactored solution to the OCP problem.
 * The responsibilities are separated based on the SRP principle.
 *
 * TODO: implement IHandler to all the Handlers to make them all of the same type.
 *
 * */

public class V2Parser {
  private String textToProcess;
  private Map<Character, IHandler> _handlers;

  public void setTextToProcess(String textToProcess) {
    this.textToProcess = textToProcess;
  }

  public V2Parser(Map<Character, IHandler> handlers) {
    this._handlers = handlers;
  }

  public void parse() throws IOException {
    BufferedReader reader = new BufferedReader(new StringReader(textToProcess));
    String line = reader.readLine();

    while (line != null) {
      IHandler handler = _handlers.get(line.charAt(0));
      handler.execute(line);
      line = reader.readLine();
    }
  }

  /** TODO: uncomment the following lines and implement IHandler to all the
   *  Handlers to make them all of the same type.
   **/
  public static void main(String[] args) {

    Map<Character, IHandler> handlers =new HashMap<>();
//    handlers.put('$', new VariableHandler());
//    handlers.put('#', new CustomCommandHandler());
//    handlers.put('@', new DirectiveHandler());

    V2Parser parser = new V2Parser(handlers);
  }
}
