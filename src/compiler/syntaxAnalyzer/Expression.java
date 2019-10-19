/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler.syntaxAnalyzer;

/**
 *
 * @author Muhammad Huzaifa
 */
public class Expression {

    static boolean IncDeCId() {
        if ("ID".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())) {
            SyntaxAnalyzer.index++;
            if ("INCDEC".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())) {
                SyntaxAnalyzer.index++;
                return true;
            }
            SyntaxAnalyzer.index--;
            return false;
        }
        return false;
    }

    static boolean idIncDeC() {
        if ("INCDEC".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())) {
            SyntaxAnalyzer.index++;
            if ("ID".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())) {
                SyntaxAnalyzer.index++;
                return true;
            }
            SyntaxAnalyzer.index--;
            return false;
        }
        return false;
    }

    static boolean expression() {
        if (SelectionSet.ofOE()) {
            if (ae()) {
                return expressiondash();
            }
            return false;
        }
        return true;
    }

    static boolean expressiondash() {
        if ("OR_L".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())) {
            SyntaxAnalyzer.index++;
            if (ae()) {
                return expressiondash();
            }
            SyntaxAnalyzer.index--;
            return false;
        }
        return true;
    }

    static boolean ae() {
        if (re()) {
            return aedash();
        }
        return false;
    }

    static boolean aedash() {
        if ("AND_L".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())) {
            SyntaxAnalyzer.index++;
            if (re()) {
                return aedash();
            }
            SyntaxAnalyzer.index--;
            return false;
        }
        return true;
    }

    static boolean re() {
        if (e()) {
            return redash();
        }
        return false;
    }

    static boolean redash() {
        if ("R_OPERATORS".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())) {
            SyntaxAnalyzer.index++;
            if (e()) {
                return redash();
            }
            SyntaxAnalyzer.index--;
            return false;
        }
        return true;
    }

    static boolean f() {
        if (id()) {
            return true;
        } else if (constant()) {
            return true;
        }
        return false;
    }

    static boolean id() {
        if ("ID".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())) {
            SyntaxAnalyzer.index++;
            return iddash();
        }
        return false;
    }

    static boolean iddash() {

        if ("DOT".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())) {
            SyntaxAnalyzer.index++;
            if (id()) {
                return true;
            }
            SyntaxAnalyzer.index--;
            return false;
        }
        return true;
    }

    static boolean e() {
        if (t()) {
            return edash();
        }
        return false;
    }

    static boolean edash() {
        if ("PM".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())) {
            SyntaxAnalyzer.index++;
            if (t()) {
                return edash();
            }
            SyntaxAnalyzer.index--;
            return false;
        }
        return true;
    }

    static boolean t() {
        if (f()) {
            return tdash();
        }
        return false;
    }

    static boolean tdash() {
        if ("MDM".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())) {
            SyntaxAnalyzer.index++;
            if (f()) {
                return tdash();
            }
            SyntaxAnalyzer.index--;
            return false;
        }
        return true;
    }

    static boolean constant() {
        if ("String_Const".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName()) || "Char_Const".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())
                || "FLOAT_CONST".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName()) || "INTEGER_CONST".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())) {
            SyntaxAnalyzer.index++;
            return true;
        }
        return false;
    }

}
