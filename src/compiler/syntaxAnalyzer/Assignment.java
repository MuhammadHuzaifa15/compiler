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
public class Assignment {

    static boolean assigment() {
        if (option1()) {
            if (option2()) {
                return true;
            }
            return false;
        }
        return false;
    }

    static boolean option3() {
        if (Id.id()) {
            return option4();
        } else if (Id.thisId()) {
            return option4();
        } else if (Id.superId()) {
            return option4();
        } else if (Expression.constant()) {
            return true;
        } else if (Expression.expression()) {
            return true;
        } else if (FunctionCalling.funcCalling()) {
            return true;
        } else if (FunctionCalling.super_F()) {
            return true;
        } else if (FunctionCalling.this_F()) {
            return true;
        }
        return false;
    }

    static boolean option4() {
        if ("EE".equals(tokenList.get(index).getClassName())) {
            index++;
            if (option3()) {
                return true;
            }
            index--;
            return false;
        }
        return true;
    }

    static boolean option2() {
        if ("EE".equals(tokenList.get(index).getClassName())) {
            index++;
            if (option3()) {
                return true;
            }
            index--;
            return false;
        }
        return false;
    }

    static boolean option1() {
        if (Id.id()) {
            return true;
        } else if (Array.assign()) {
            return true;
        } else if (Id.thisId()) {
            return true;
        } else if (Id.superId()) {
            return true;
        }
        return false;
    }
}
