/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import compiler.syntaxAnalyzer.SyntaxAnalyzer;
import compiler.lexicalAnalyzer.TokenGenerator;
import compiler.lexicalAnalyzer.RWFile;
import java.io.IOException;

/**
 *
 * @author Muhammad Huzaifa
 */
public class Compiler {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String input = RWFile.ReadFile();
        TokenGenerator TG = new TokenGenerator();
        SyntaxAnalyzer sa = new SyntaxAnalyzer(TG.generator(input));
        if (sa.start()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

}
