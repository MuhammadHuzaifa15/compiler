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
public class ObjectCreation {

    static boolean objCreation() {
        if ("ID".equals(tokenList.get(index).getClassName())) {
            index++;
            if ("ID".equals(tokenList.get(index).getClassName())) {
                index++;
                if (option()) {
                    return true;
                }
                index--;
            }
            index--;
            return false;
        }
        return false;
    }

    static boolean option() {
        if ("EE".equals(tokenList.get(index).getClassName())) {
            index++;
            if ("CREATE".equals(tokenList.get(index).getClassName())) {
                index++;
                if ("ID".equals(tokenList.get(index).getClassName())) {
                    index++;
                    if ("OBB".equals(tokenList.get(index).getClassName())) {
                        index++;
                        if (FunctionCalling.c_Arg()) {
                            if ("CBB".equals(tokenList.get(index).getClassName())) {
                                index++;
                                Terminator.sem();
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
                index--;
            }
            index--;
            return false;
        }
        return false;
    }

}
