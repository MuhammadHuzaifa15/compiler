/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler.lexicalAnalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Muhammad Huzaifa
 */
public class RWFile {

    public static String ReadFile() throws IOException {

        String input = "";

        File file = new File(".\\src\\compiler\\Code.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        int st;
        while ((st = br.read()) != -1) {
            char character = (char) st;
            input += character;
        }
        return input;
    }

    public static void writeToFile(ArrayList<Token> tokenList) {
        try (FileWriter fw = new FileWriter(".\\src\\compiler\\TokenList.txt")) {

            String newLine = System.getProperty("line.separator");

            for (Token token : tokenList) {
                fw.write(token + newLine);
            }

        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
 
}
