/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler.syntaxAnalyzer;

import static compiler.syntaxAnalyzer.SyntaxAnalyzer.tokenList;
import static compiler.syntaxAnalyzer.SyntaxAnalyzer.index;

/**
 *
 * @author Muhammad Huzaifa
 */
public class Terminator {

    static boolean sem() {
        if ("SEM".equals(tokenList.get(index).getClassName())) {
            index++;
            return true;
        }
        return true;
    }
}
