/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler.lexicalAnalyzer;

import java.util.ArrayList;

/**
 *
 * @author Muhammad Huzaifa
 */
public class ListItem {
    
    String className;
    ArrayList<String> keywords;

    public ListItem(String className, ArrayList<String> keywords) {
        this.className = className;
        this.keywords = keywords;
    }    
}
