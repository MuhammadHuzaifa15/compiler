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
public class Body {

    static boolean body() {
        if (SelectionSet.ofFMST() || "OCB".equals(tokenList.get(index).getClassName())) {
            if (SST()) {
                return true;
            } else if ("OCB".equals(tokenList.get(index).getClassName())) {
                index++;
                if (MST()) {
                    if ("CCB".equals(tokenList.get(index).getClassName())) {
                        index++;
                        return true;
                    }
                    return false;
                }
                index--;
                return false;
            }

            return false;
        }
        return true;
    }

    static boolean SST() {
        if (Loop.until() || Loop.forLoop() || Loop.do_until() || WheneverBeside.Whenever()
                || When.when() || Recoil.recoil() || ObjectCreation.objCreation() || Declaration.declaration()
                || Assignment.assigment()
                || Expression.IncDeCId() || Expression.idIncDeC()) {
            return true;
        } else if ("SC".equals(tokenList.get(index).getClassName())) {
            index++;
            return true;
        }
        return false;
    }

    static boolean MST() {
        if (!"CCB".equals(tokenList.get(index).getClassName())) {
            if (SST()) {
                return MST();
            }
            return false;
        }
        return true;
    }

}
