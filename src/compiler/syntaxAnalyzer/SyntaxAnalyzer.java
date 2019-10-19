/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler.syntaxAnalyzer;

import compiler.lexicalAnalyzer.Token;
import java.util.ArrayList;

/**
 *
 * @author Muhammad Huzaifa
 */
public class SyntaxAnalyzer {

    static int index;
    static ArrayList<Token> tokenList;

    public SyntaxAnalyzer(ArrayList<Token> tokenList) {
        SyntaxAnalyzer.tokenList = tokenList;
    }

    public boolean start() {

        if (pub()) {
            if ("CLASS".equals(tokenList.get(index).getClassName())) {
                index++;
                if ("ID".equals(tokenList.get(index).getClassName())) {
                    index++;
                    if (Class.ext()) {
                        if (Class.imp()) {
                            if ("OCB".equals(tokenList.get(index).getClassName())) {
                                index++;
                                if (pub()) {
                                    if ("STATIC".equals(tokenList.get(index).getClassName())) {
                                        index++;
                                        if ("VOID".equals(tokenList.get(index).getClassName())) {
                                            index++;
                                            if ("MAIN".equals(tokenList.get(index).getClassName())) {
                                                index++;
                                                if ("OBB".equals(tokenList.get(index).getClassName())) {
                                                    index++;
                                                    if ("string".equals(tokenList.get(index).getValue())) {
                                                        index++;
                                                        if ("OSB".equals(tokenList.get(index).getClassName())) {
                                                            index++;
                                                            if ("CSB".equals(tokenList.get(index).getClassName())) {
                                                                index++;
                                                                if ("ID".equals(tokenList.get(index).getClassName())) {
                                                                    index++;
                                                                    if ("CBB".equals(tokenList.get(index).getClassName())) {
                                                                        index++;
                                                                        if ("OCB".equals(tokenList.get(index).getClassName())) {
                                                                            index++;
                                                                            if (Body.MST()) {
                                                                                if ("CCB".equals(tokenList.get(index).getClassName())) {
                                                                                    index++;
                                                                                    if (Class.cMST()) {
                                                                                        if ("CCB".equals(tokenList.get(index).getClassName())) {
                                                                                            index++;
                                                                                            if (Class.classDeclaration()) {
                                                                                                return true;
                                                                                            }
                                                                                            return false;
                                                                                        }
                                                                                        return false;
                                                                                    }
                                                                                    return false;
                                                                                }
                                                                                return false;
                                                                            }
                                                                            return false;
                                                                        }
                                                                        return false;
                                                                    }
                                                                    return false;
                                                                }
                                                                return false;
                                                            }
                                                        }
                                                        return false;
                                                    }
                                                    return false;
                                                }
                                                return false;
                                            }
                                            return false;
                                        }
                                        return false;
                                    }
                                    return false;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    boolean pub() {
        if ("AM".equals(tokenList.get(index).getClassName())) {
            if ("public".equals(tokenList.get(index).getValue())) {
                index++;
                return true;
            }
            return false;
        }
        return true;
    }

}
