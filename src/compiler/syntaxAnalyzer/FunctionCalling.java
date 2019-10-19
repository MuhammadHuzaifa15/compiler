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
public class FunctionCalling {

    static boolean funcCalling() {
        if (Id.id()) {
            if (Id.idDash()) {
                if ("OBB".equals(tokenList.get(index).getClassName())) {
                    index++;
                    if (c_Arg()) {
                        if ("CBB".equals(tokenList.get(index).getClassName())) {
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
        return false;
    }

    static boolean super_F() {
        if ("SUPER".equals(tokenList.get(index).getClassName())) {
            index++;
            if ("DOT".equals(tokenList.get(index).getClassName())) {
                index++;
                if ("ID".equals(tokenList.get(index).getClassName())) {
                    index++;
                    if (Id.idDash()) {
                        if ("OBB".equals(tokenList.get(index).getClassName())) {
                            index++;
                            if (c_Arg()) {
                                if ("CBB".equals(tokenList.get(index).getClassName())) {
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
            index--;
            return false;
        }
        return false;
    }

    static boolean this_F() {
        if ("THIS".equals(tokenList.get(index).getClassName())) {
            index++;
            if ("DOT".equals(tokenList.get(index).getClassName())) {
                index++;
                if ("ID".equals(tokenList.get(index).getClassName())) {
                    index++;
                    if (Id.idDash()) {
                        if ("OBB".equals(tokenList.get(index).getClassName())) {
                            index++;
                            if (c_Arg()) {
                                if ("CBB".equals(tokenList.get(index).getClassName())) {
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
            index--;
            return false;
        }
        return false;
    }

    static boolean ca() {
        if ("CREATE".equals(tokenList.get(index).getClassName())) {
            index++;
            if ("ID".equals(tokenList.get(index).getClassName())) {
                index++;
                if ("OBB".equals(tokenList.get(index).getClassName())) {
                    index++;
                    if (ca()) {
                        if ("CBB".equals(tokenList.get(index).getClassName())) {
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
            index--;
            return false;
        }
        return false;
    }

    static boolean c_Arg() {
        if (Id.id()) {
            return c_ArgDash();
        } else if (Id.thisId()) {
            return c_ArgDash();
        } else if (Id.superId()) {
            return c_ArgDash();
        } else if (ca()) {
            return c_ArgDash();
        } else if (Expression.constant()) {
            return c_ArgDash();
        } else if (Expression.expression()) {
            return c_ArgDash();
        }
        return true;
    }

    static boolean c_ArgDash() {
        if ("COM".equals(tokenList.get(index).getClassName())) {
            index++;
            if (Id.id()) {
                return c_ArgDash();
            } else if (Id.thisId()) {
                return c_ArgDash();
            } else if (ca()) {
                return c_ArgDash();
            } else if (Id.superId()) {
                return c_ArgDash();
            } else if (Expression.constant()) {
                return c_ArgDash();
            }
            index--;
            return false;
        }
        return true;
    }

}
