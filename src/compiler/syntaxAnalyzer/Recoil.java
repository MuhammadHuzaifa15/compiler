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
public class Recoil {

    static boolean recoil() {
        if ("RECOIL".equals(tokenList.get(index).getClassName())) {
            index++;
            if (recoil1()) {
                Terminator.sem();
                return true;
            }
            index--;
            return false;
        }
        return false;
    }

    static boolean recoil1() {
        return Expression.expression();
    }

}
