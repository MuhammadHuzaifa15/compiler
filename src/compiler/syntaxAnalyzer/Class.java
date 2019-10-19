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
public class Class {

    static boolean classDeclaration() {
        if (!"End of input".equals(tokenList.get(index).getClassName())) {
            if (Declaration.AM()) {
                if ("CLASS".equals(tokenList.get(index).getClassName())) {
                    index++;
                    if ("ID".equals(tokenList.get(index).getClassName())) {
                        index++;
                        if (ext()) {
                            if (imp()) {
                                if ("OCB".equals(tokenList.get(index).getClassName())) {
                                    index++;
                                    if (cMST()) {
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
                            return false;
                        }
                        index--;
                        return false;
                    }
                    index--;
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    static boolean cMST() {
        if (!"CCB".equals(tokenList.get(index).getClassName())) {
            if (cSST()) {
                return cMST();
            }
            return false;
        }
        return true;
    }

    static boolean declaration() {
        if (Declaration.list1()) {
            if (Declaration.init()) {
                if ("COL".equals(tokenList.get(index).getClassName())) {
                    index++;
                    if ("DATATYPE".equals(tokenList.get(index).getClassName())) {
                        index++;
                        return true;
                    }
                    index--;
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    static boolean cSST() {
        if ("SC".equals(tokenList.get(index).getClassName())) {
            index++;
            return true;
        } else if (Declaration.AM()) {
            if (ObjectCreation.objCreation()) {
                return true;
            } else if (FunctionDeclaration.FuncDec()) {
                return true;
            } else if ("ID".equals(tokenList.get(index).getClassName())) {
                index++;
                if (constructor()) {
                    return true;
                } else if (declaration()) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    static boolean constructor() {
        if ("OBB".equals(tokenList.get(index).getClassName())) {
            index++;
            if (FunctionDeclaration.d_Arg()) {
                if ("CBB".equals(tokenList.get(index).getClassName())) {
                    index++;
                    if ("OCB".equals(tokenList.get(index).getClassName())) {
                        index++;
                        if (conBody()) {
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
            }
            index--;
            return false;
        }
        return false;
    }

    static boolean conBody() {
        if ("SUPER".equals(tokenList.get(index).getClassName())) {
            index++;
            if ("OBB".equals(tokenList.get(index).getClassName())) {
                index++;
                if (FunctionCalling.c_Arg()) {
                    if ("CBB".equals(tokenList.get(index).getClassName())) {
                        index++;
                        if (Body.MST()) {
                            return true;
                        }
                        return false;
                    }
                }
                index--;
                return false;
            }
            index--;
            return false;
        } else if (Body.MST()) {
            return true;
        }
        return false;
    }

    static boolean ext() {
        if ("EXTENDS".equals(tokenList.get(index).getClassName())) {
            index++;
            if ("ID".equals(tokenList.get(index).getClassName())) {
                index++;
                return true;
            }
            return false;
        }
        return true;
    }

    static boolean imp() {
        if ("IMPLEMENTS".equals(tokenList.get(index).getClassName())) {
            index++;
            if ("ID".equals(tokenList.get(index).getClassName())) {
                index++;
                return true;
            }
            return false;
        }
        return true;
    }
}
