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
public class Array {

    static boolean assign() {
        if ("ID".equals(tokenList.get(index).getClassName())) {
            index++;
            if ("OSB".equals(tokenList.get(index).getClassName())) {
                index++;
                if (Expression.expression()) {
                    if ("CSB".equals(tokenList.get(index).getClassName())) {
                        index++;
                        return true;
                    }
                    return false;
                }
                index--;
                return false;
            }
            index--;
            return false;
        }
        return false;
    }
}
