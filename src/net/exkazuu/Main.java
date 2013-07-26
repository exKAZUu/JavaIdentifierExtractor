package net.exkazuu;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import parser.JavaLexer;

public class Main {
  public static void main(String[] args) {
    CharStream input = new ANTLRInputStream("public class A { } class B { }");
    JavaLexer lexer = new JavaLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    tokens.fill();
    System.out.println("size: " + tokens.size());
    for (int i = 0; i < tokens.size(); i++) {
      if (tokens.get(i).getType() == JavaLexer.Identifier) {
        System.out.println(tokens.get(i).getText());
      }
    }
  }
}
