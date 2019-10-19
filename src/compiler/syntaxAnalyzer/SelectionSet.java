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
public class SelectionSet {

    static boolean ofFMST() {
        return ("THIS".equals(tokenList.get(index).getClassName())
                || "ID".equals(tokenList.get(index).getClassName())
                || "SUPER".equals(tokenList.get(index).getClassName())
                || "UNTIL".equals(tokenList.get(index).getClassName())
                || "DO".equals(tokenList.get(index).getClassName())
                || "FOR".equals(tokenList.get(index).getClassName())
                || "TRY".equals(tokenList.get(index).getClassName())
                || "WHENEVER".equals(tokenList.get(index).getClassName())
                || "RECOIL".equals(tokenList.get(index).getClassName())
                || "WHEN".equals(tokenList.get(index).getClassName())
                || "DT".equals(tokenList.get(index).getClassName())
                || "STOP".equals(tokenList.get(index).getClassName())
                || "PERDUE".equals(tokenList.get(index).getClassName()));
    }

    static boolean ofOE() {
        return ("ID".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())
                //                || "OBB".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())
                || "Char_Const".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())
                || "String_Const".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())
                || "FLOAT_CONST".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())
                || "INTEGER_CONST".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName()) //|| "End of input".equals(SyntaxAnalyzer.tokenList.get(SyntaxAnalyzer.index).getClassName())
                );
    }

}
