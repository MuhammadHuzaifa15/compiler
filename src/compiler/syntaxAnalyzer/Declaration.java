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
public class Declaration {

    static boolean declaration() {
        if (AM()) {
            if ("ID".equals(tokenList.get(index).getClassName())) {
                index++;
                if (list1()) {
                    if (init()) {
                        return dec();
                    }
                    return false;
                }
                index--;
                return false;
            }
            return false;
        }
        return false;
    }

    static boolean dec() {
        if ("COl".equals(tokenList.get(index).getClassName())) {
            index++;
            if ("DATATYPE".equals(tokenList.get(index).getClassName())) {
                index++;
                return true;
            }
            return false;
        }
        return false;
    }

    static boolean list1() {

        if ("COM".equals(tokenList.get(index).getClassName())) {
            index++;
            if ("ID".equals(tokenList.get(index).getClassName())) {
                index++;
                if (list1()) {
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

    static boolean init() {
        if ("EE".equals(tokenList.get(index).getClassName())) {
            index++;
            if (init2()) {
                return true;
            }
            index--;
            return false;
        }
        return true;
    }

    static boolean init2() {
        if (Id.id()) {
            return init();
        } else if (Expression.constant()) {
            return true;
        }
        return false;
    }

    static boolean AF() {
        if (AM()) {
            return F();
        } else if (F()) {
            return AM();
        }
        return false;
    }

    static boolean AM() {
        if ("AM".equals(tokenList.get(index).getClassName())) {
            index++;
            return true;
        }
        return true;
    }

    static boolean F() {
        if ("FINAL".equals(tokenList.get(index).getClassName())) {
            index++;
            return true;
        }
        return true;
    }

}
