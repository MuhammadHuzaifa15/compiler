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
public class When {

    static boolean when() {
        if ("WHEN".equals(tokenList.get(index).getClassName())) {
            index++;
            if ("OBB".equals(tokenList.get(index).getClassName())) {
                index++;
                if (Expression.expression()) {
                    if ("CBB".equals(tokenList.get(index).getClassName())) {
                        index++;
                        if ("OCB".equals(tokenList.get(index).getClassName())) {
                            index++;
                            if (C_D()) {
                                if ("CCB".equals(tokenList.get(index).getClassName())) {
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
                index--;
                return false;
            }
            index--;
            return false;
        }
        return false;
    }

    static boolean C_D() {

        if ("FLOAT_CONST".equals(tokenList.get(index).getClassName()) || "INTEGER_CONST".equals(tokenList.get(index).getClassName())
                || "String_Const".equals(tokenList.get(index).getClassName()) || "Char_Const".equals(tokenList.get(index).getClassName())) {
            index++;
            if ("ARROW".equals(tokenList.get(index).getClassName())) {
                index++;
                if (Body.body()) {
                    return C_D();
                }
                index--;
                return false;
            }
            index--;
            return false;
        } else if ("BESIDE".equals(tokenList.get(index).getClassName())) {
            index++;
            if ("ARROW".equals(tokenList.get(index).getClassName())) {
                index++;
                if (Body.body()) {
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
