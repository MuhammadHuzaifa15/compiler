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
public class FunctionDeclaration {

    static boolean FuncDec() {
        if ("FUN".equals(tokenList.get(index).getClassName())) {
            index++;
            if ("ID".equals(tokenList.get(index).getClassName())) {
                index++;
                if ("OBB".equals(tokenList.get(index).getClassName())) {
                    index++;
                    if (d_Arg()) {
                        if ("CBB".equals(tokenList.get(index).getClassName())) {
                            index++;
                            if ("COL".equals(tokenList.get(index).getClassName())) {
                                index++;
                                if (rt()) {
                                    if ("OCB".equals(tokenList.get(index).getClassName())) {
                                        index++;
                                        if (Body.MST()) {
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
            index--;
            return false;
        }
        return false;
    }

    static boolean rt() {
        if ("VOID".equals(tokenList.get(index).getClassName()) || "DT".equals(tokenList.get(index).getClassName())) {
            index++;
            return true;
        }
        return false;
    }

    static boolean d_Arg() {
        if ("ID".equals(tokenList.get(index).getClassName())) {
            index++;
            if ("COL".equals(tokenList.get(index).getClassName())) {
                index++;
                if (d_Arg1()) {
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

    static boolean d_Arg1() {
        if ("DATATYPE".equals(tokenList.get(index).getClassName())) {
            index++;
            if (option()) {
                return true;
            }
            index--;
            return false;
        } else if ("ID".equals(tokenList.get(index).getClassName())) {
            index++;
            if (option()) {
                return true;
            }
            index--;
            return false;
        }
        return false;
    }

    static boolean option() {
        if ("COM".equals(tokenList.get(index).getClassName())) {
            index++;
            if ("ID".equals(tokenList.get(index).getClassName())) {
                index++;
                if ("COL".equals(tokenList.get(index).getClassName())) {
                    index++;
                    if (option2()) {
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
        return true;
    }

    static boolean option2() {

        if ("DT".equals(tokenList.get(index).getClassName())) {
            index++;
            if (option()) {
                return true;
            }
            index--;
            return false;
        } else if ("ID".equals(tokenList.get(index).getClassName())) {
            index++;
            if (option()) {
                return true;
            }
            index--;
            return false;
        }
        return false;
    }
}
