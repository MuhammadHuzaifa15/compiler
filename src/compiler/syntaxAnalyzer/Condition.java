/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler.syntaxAnalyzer;

import static compiler.syntaxAnalyzer.Expression.expression;
import static compiler.syntaxAnalyzer.SyntaxAnalyzer.index;
import static compiler.syntaxAnalyzer.SyntaxAnalyzer.tokenList;

/**
 *
 * @author Muhammad Huzaifa
 */
public class Condition {

    static boolean cond() {

        if ("TF".equals(tokenList.get(index).getClassName())) {
            index++;
            return true;
        } else if (Expression.expression()) {
            return true;
        } else if ("NOT_L".equals(tokenList.get(index).getClassName())) {
            index++;
            if (Expression.expression()) {
                return true;
            }
            index--;
            return false;
        } else if ("NOT_L".equals(tokenList.get(index).getClassName())) {
            index++;
            if ("TF".equals(tokenList.get(index).getClassName())) {
                index++;
                return true;
            }
//            if (expression()) {
//                if ("R_OPERATORS".equals(tokenList.get(index).getClassName())) {
//                    index++;
//                    if (expression()) {
//                        return true;
//                    }
//                    index--;
//                    return false;
//                }
//                return false;
//            }
//        } else if (expression()) {
//            if ("R_OPERATORS".equals(tokenList.get(index).getClassName())) {
//                index++;
//                if (expression()) {
//                    return true;
//                }
//                index--;
//                return false;
//            }
            return false;
        }
        return false;
    }

}
