/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler.syntaxAnalyzer;

import static compiler.syntaxAnalyzer.Body.MST;
import static compiler.syntaxAnalyzer.Condition.cond;
import static compiler.syntaxAnalyzer.SyntaxAnalyzer.tokenList;
import static compiler.syntaxAnalyzer.SyntaxAnalyzer.index;

/**
 *
 * @author Muhammad Huzaifa
 */
public class WheneverBeside {

    static boolean Whenever() {
        if ("WHENEVER".equals(tokenList.get(index).getClassName())) {
            index++;
            if ("OBB".equals(tokenList.get(index).getClassName())) {
                index++;
                if (cond()) {
                    if ("CBB".equals(tokenList.get(index).getClassName())) {
                        index++;
                        if ("OCB".equals(tokenList.get(index).getClassName())) {
                            index++;
                            if (MST()) {
                                if ("CCB".equals(tokenList.get(index).getClassName())) {
                                    index++;
                                    if (besides()) {
                                        return true;
                                    }
                                    index--;
                                    return false;
                                }
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

    static boolean besides() {
        if ("BESIDE".equals(tokenList.get(index).getClassName())) {
            index++;
            if ("OCB".equals(tokenList.get(index).getClassName())) {
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
            index--;
            return false;
        }
        return true;
    }

}
