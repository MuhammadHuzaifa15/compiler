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
public class Id {
     static boolean thisId() {
        if ("THIS".equals(tokenList.get(index).getClassName())) {
            index++;
            if ("DOT".equals(tokenList.get(index).getClassName())) {
                index++;
                if ("ID".equals(tokenList.get(index).getClassName())) {
                    index++;
                    if (idDash()) {
                        return true;
                    }
                    index--;
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

    static boolean superId() {
        if ("SUPER".equals(tokenList.get(index).getClassName())) {
            index++;
            if ("DOT".equals(tokenList.get(index).getClassName())) {
                index++;
                if ("ID".equals(tokenList.get(index).getClassName())) {
                    index++;
                    if (idDash()) {
                        return true;
                    }
                    index--;
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

    static boolean id() {
        if ("ID".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())) {
            SyntaxAnalyzer.index++;
            return idDash();
        }
        return false;
    }

    static boolean idDash() {

        if ("DOT".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())) {
            SyntaxAnalyzer.index++;
            if ("ID".equals(tokenList.get(index).getClassName())) {
                index++;
                if (idDash()) {
                    return true;
                }
                index--;
                return false;
            }
            index--;
            return false;
        }
        return true;
    }
}
