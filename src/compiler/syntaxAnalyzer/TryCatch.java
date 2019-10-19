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
public class TryCatch {

    static boolean tryCatch() {

        if ("TRY".equals(tokenList.get(index).getClassName())) {
            index++;
            if ("OCB".equals(tokenList.get(index).getClassName())) {
                index++;
                if (Body.MST()) {
                    if ("CCB".equals(tokenList.get(index).getClassName())) {
                        index++;
                        if ("FINALLY".equals(tokenList.get(index).getClassName())) {
                            index++;
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
                            index--;
                            return false;
                        } else if ("CATCH".equals(tokenList.get(index).getClassName())) {
                            index++;
                            if ("OBB".equals(tokenList.get(index).getClassName())) {
                                index++;
                                if (arg1()) {
                                    if ("CBB".equals(tokenList.get(index).getClassName())) {
                                        index++;
                                        if ("OCB".equals(tokenList.get(index).getClassName())) {
                                            index++;
                                            if (Body.MST()) {
                                                if ("CCB".equals(tokenList.get(index).getClassName())) {
                                                    index++;
                                                    if (catchE()) {
                                                        return true;
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
                index--;
                return false;
            }
            index--;
            return false;
        }
        return false;
    }

    static boolean catchE() {
        if ("CATCH".equals(tokenList.get(index).getClassName())) {
            index++;
            if ("OBB".equals(tokenList.get(index).getClassName())) {
                index++;
                if (arg1()) {
                    if ("CBB".equals(tokenList.get(index).getClassName())) {
                        index++;
                        if ("OCB".equals(tokenList.get(index).getClassName())) {
                            index++;
                            if (Body.MST()) {
                                if ("CCB".equals(tokenList.get(index).getClassName())) {
                                    index++;
                                    if (catchE()) {
                                        return true;
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
        } else if ("FINALLY".equals(tokenList.get(index).getClassName())) {
            index++;
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
            index--;
            return false;
        }
        return true;
    }

    static boolean arg1() {

        if ("ID".equals(tokenList.get(index).getClassName())) {
            index++;
            if ("COL".equals(tokenList.get(index).getClassName())) {
                index++;
                if (ex()) {
                    return true;
                }
                index--;
                return false;
            }
            return true;
        }
        return false;
    }

    static boolean ex() {
        if ("ID".equals(tokenList.get(index).getClassName())) {
            index++;
            if ("OR_B".equals(tokenList.get(index).getClassName())) {
                index++;
                if (ex()) {
                    return true;
                }
                index--;
                return false;
            }
            return true;
        }
        return false;
    }
}
