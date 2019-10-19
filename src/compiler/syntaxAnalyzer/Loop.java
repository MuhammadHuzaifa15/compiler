/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler.syntaxAnalyzer;

import static compiler.syntaxAnalyzer.Body.MST;
import static compiler.syntaxAnalyzer.SyntaxAnalyzer.tokenList;
import static compiler.syntaxAnalyzer.SyntaxAnalyzer.index;

/**
 *
 * @author Muhammad Huzaifa
 */
public class Loop {

    static boolean forLoop() {
        if ("FOR".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())) {
            index++;
            if ("OBB".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())) {
                index++;
                if (f1()) {
                    if (f2()) {
                        if (f3()) {
                            if ("CBB".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())) {
                                index++;
                                if (Body.body()) {
                                    return true;
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
                index--;
                return false;
            }
            index--;
            return false;
        }
        return false;
    }

    static boolean f3() {
        if ("SC".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())) {
            index++;
            if ("ID".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())
                    || "INCDEC".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())) {
                if (Expression.IncDeCId()) {
                    return true;
                } else if (Expression.idIncDeC()) {
                    return true;
                } else if (Assignment.assigment()) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    static boolean f2() {
        return Condition.cond();
    }

    static boolean f1() {
        if ("SC".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())) {
            index++;
            return true;
        } else if (Assignment.assigment()) {
            if ("SC".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())) {
                index++;
                return true;
            }
            return false;
        }
        return false;
    }

    static boolean until() {
        if ("UNTIL".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())) {
            SyntaxAnalyzer.index++;
            if ("OBB".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())) {
                SyntaxAnalyzer.index++;
                if (Condition.cond()) {
                    if ("CBB".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())) {
                        SyntaxAnalyzer.index++;
                        if (Body.body()) {
                            return true;
                        }
                        return false;
                    }
                    return false;
                }
                SyntaxAnalyzer.index--;
                return false;
            }
            SyntaxAnalyzer.index--;
            return false;
        }
        return false;

    }

    static boolean do_until() {
        if ("DO".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())) {
            SyntaxAnalyzer.index++;
            if ("OCB".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())) {
                SyntaxAnalyzer.index++;
                if (MST()) {
                    if ("CCB".equals(tokenList.get(SyntaxAnalyzer.index).getClassName())) {
                        SyntaxAnalyzer.index++;
                        if ("UNTIL".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())) {
                            SyntaxAnalyzer.index++;
                            if ("OBB".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())) {
                                SyntaxAnalyzer.index++;
                                if (Condition.cond()) {
                                    if ("CBB".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())) {
                                        SyntaxAnalyzer.index++;
                                        return true;
                                    }
                                }
                                SyntaxAnalyzer.index--;
                                return false;
                            }
                            SyntaxAnalyzer.index--;
                            return false;
                        }
                        SyntaxAnalyzer.index--;
                        return false;
                    }
                    SyntaxAnalyzer.index--;
                    return false;
                }
                SyntaxAnalyzer.index--;
                return false;
            }
            return false;
        }
        return false;
    }

}
