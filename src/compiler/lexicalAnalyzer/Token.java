/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler.lexicalAnalyzer;

/**
 *
 * @author Muhammad Huzaifa
 */
public class Token {
    
    String className,value;
    int lineNo;

    public Token(String className, String value, int lineNo) {
        this.className = className;
        this.value = value;
        this.lineNo = lineNo;
    }

    @Override
    public String toString() {
        return "( " + className + " , " + value + " , " + lineNo + " )";
    }

    public String getClassName() {
        return className;
    }

    public String getValue() {
        return value;
    } 
    
}
