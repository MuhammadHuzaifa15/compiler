/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler.lexicalAnalyzer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Muhammad Huzaifa
 */
public class TokenGenerator {

    ArrayList<Token> tokenList = new ArrayList<>();

    public ArrayList<Token> generator(String input) {

        int i = 0, line = 1;

        while (i < input.length()) {

            char temp = input.charAt(i);

            //Identifiers
            if (temp == '_') {
                String temp2 = Character.toString(temp);
                i++;
                if (i < input.length()) {
                    while (true) {
                        if (i < input.length()) {
                            if (input.charAt(i) == ' ') {
                                i--;
                                break;
                            } else if (input.charAt(i) == '\r') {
                                i--;
                                break;
                            } else if (input.charAt(i) == ';') {
                                i--;
                                break;
                            } else if (checkOperators(Character.toString(input.charAt(i)))) {
                                i--;
                                break;
                            } else if (checkPunctuators(Character.toString(input.charAt(i))) != "") {
                                i--;
                                break;
                            } else if (input.charAt(i) == '.') {
                                i--;
                                break;
                            }
                            temp2 += input.charAt(i);
                            i++;
                        } else {
                            i--;
                            break;
                        }
                    }
                    if (checkIdentifier(temp2)) {
                        Token t = new Token("ID", temp2, line);
                        tokenList.add(t);
                    } else {
                        Token t = new Token("Invalid Token", temp2, line);
                        tokenList.add(t);
                    }
                    System.out.println(temp2);
                } else {
                    Token t = new Token("Invalid Token", temp2, line);
                    tokenList.add(t);
                }
            } //Identifiers Or Keywords
            else if (checkAlph(Character.toString(temp))) {

                String temp2 = Character.toString(temp);
                i++;
                if (i < input.length()) {
                    while (true) {
                        if (i < input.length()) {
                            if (input.charAt(i) == ' ') {
                                i--;
                                break;
                            } else if (input.charAt(i) == '\r') {
                                i--;
                                break;
                            } else if (input.charAt(i) == ';') {
                                i--;
                                break;
                            } else if (checkOperators(Character.toString(input.charAt(i)))) {
                                i--;
                                break;
                            } else if (!"".equals(checkPunctuators(Character.toString(input.charAt(i))))) {
                                i--;
                                break;
                            } else if (input.charAt(i) == '.') {
                                i--;
                                break;
                            }
                            temp2 += input.charAt(i);
                            i++;
                        } else {
                            i--;
                            break;
                        }
                    }
                    if (checkIdentifier(temp2)) {
                        String className = checkKeyword(temp2);
                        if (!"".equals(className)) {
                            Token t = new Token(className, temp2, line);
                            tokenList.add(t);
                        } else {
                            Token t = new Token("ID", temp2, line);
                            tokenList.add(t);
                        }
                    } else {
                        Token t = new Token("Invalid Token", temp2, line);
                        tokenList.add(t);
                    }
                } else {
                    if (checkIdentifier(temp2)) {
                        String className = checkKeyword(temp2);
                        if (!"".equals(className)) {
                            Token t = new Token(className, temp2, line);
                            tokenList.add(t);
                        } else {
                            Token t = new Token("ID", temp2, line);
                            tokenList.add(t);
                        }
                    } else {
                        Token t = new Token("Invalid Token", temp2, line);
                        tokenList.add(t);
                    }

                }
            } //Punctuators
            else if (!"".equals(checkPunctuators(Character.toString(temp)))) {
                String className = checkPunctuators(Character.toString(temp));
                Token t = new Token(className, Character.toString(temp), line);
                tokenList.add(t);
            }//Operators 
            else if (checkOperators(Character.toString(temp))) {

                i++;
                if (i < input.length()) {

                    String temp2 = Character.toString(input.charAt(i));

                    if (checkOperators(temp2)) {

                        String temp3 = Character.toString(temp) + temp2;
                        String className = checkOperatorsList(temp3);
                        if ("//".equals(temp3)) {
                            while (i < input.length() && input.charAt(i) != '\r') {
                                i++;
                            }
                            line++;
                        } else if (!"".equals(className)) {
                            Token t = new Token(className, temp3, line);
                            tokenList.add(t);
                        } else {
                            String tempClassName = checkOperatorsList(Character.toString(temp));
                            Token t = new Token(tempClassName, Character.toString(temp), line);
                            tokenList.add(t);
                            i--;
                        }

                    } else {
                        String className = checkOperatorsList(Character.toString(temp));
                        Token t = new Token(className, Character.toString(temp), line);
                        tokenList.add(t);
                        i--;
                    }
                } else {
                    String className = checkOperatorsList(Character.toString(temp));
                    if (!"".equals(className)) {
                        Token t = new Token(className, Character.toString(temp), line);
                        tokenList.add(t);
                    } else {
                        Token t = new Token("Invalid Token", Character.toString(temp), line);
                        tokenList.add(t);
                    }
                    i--;
                }
            }//String Constant
            else if (temp == '"') {
                String temp2 = Character.toString(temp);
                i++;
                if (i < input.length()) {
                    while (true) {
                        if (i < input.length()) {

                            if (input.charAt(i) == '"') {
                                temp2 += input.charAt(i);
                                break;
                            } else if (input.charAt(i) == '\r') {
                                i--;
                                break;
                            }
                            if (input.charAt(i) == '\\') {
                                temp2 += input.charAt(i);
                                i++;
                            }
                            temp2 += input.charAt(i);
                            i++;
                        } else {
                            i--;
                            break;
                        }

                    }
                    if (stringValidate(temp2)) {
                        String temp3 = "";
                        for (int j = 1; j < temp2.length() - 1; j++) {
                            temp3 += Character.toString(temp2.charAt(j));
                        }
                        Token t = new Token("String_Const", temp3, line);
                        tokenList.add(t);
                    } else {
                        Token t = new Token("Invalid Token", temp2, line);
                        tokenList.add(t);
                    }
                } else {
                    Token t = new Token("Invalid Token", temp2, line);
                    tokenList.add(t);
                }
            }//Character Constant
            else if (temp == '\'') {
                String temp2 = Character.toString(temp);
                i++;
                if (i < input.length()) {
                    if (input.charAt(i) == '\\') {
                        temp2 += Character.toString(input.charAt(i));
                        i++;
                    }
                    if (i < input.length()) {
                        if (input.charAt(i) == '\r' || input.charAt(i) == '\n') {
                            Token t = new Token("Invalid Token", temp2, line);
                            tokenList.add(t);
                        } else {

                            temp2 += Character.toString(input.charAt(i));
                            i++;

                            if (i < input.length()) {
                                if (input.charAt(i) != '\r' && input.charAt(i) != '\n') {
                                    temp2 += Character.toString(input.charAt(i));
                                } else {
                                    i--;
                                }
                            } else {
                                i--;
                            }
                            if (charValidate(temp2)) {

                                String temp3 = "";
                                for (int j = 1; j < temp2.length() - 1; j++) {
                                    temp3 += Character.toString(temp2.charAt(j));
                                }

                                Token t = new Token("Char_Const", temp3, line);
                                tokenList.add(t);
                            } else {
                                Token t = new Token("Invalid Token", temp2, line);
                                tokenList.add(t);
                            }
                        }
                    } else {
                        Token t = new Token("Invalid Token", temp2, line);
                        tokenList.add(t);
                        i--;
                    }
                } else {
                    Token t = new Token("Invalid Token", temp2, line);
                    tokenList.add(t);
                }
            } //Float Constant
            else if (temp == '.' || Character.isDigit(temp)) {

                String temp2 = Character.toString(temp);
                i++;
                if (i < input.length()) {
                    if (temp == '.') {
                        if (Character.isDigit(input.charAt(i))) {
                            while (true) {
                                if (i < input.length()) {
                                    if (Character.isDigit(input.charAt(i)) || Character.isLetter(input.charAt(i))) {
                                        temp2 += Character.toString(input.charAt(i));
                                        i++;
                                    } else if (input.charAt(i) == '\r') {
                                        i--;
                                        break;
                                    } else if (input.charAt(i) == ';') {
                                        i--;
                                        break;
                                    } else if ((input.charAt(i) == '+' || input.charAt(i) == '-')
                                            && (input.charAt(i - 1) == 'e' || input.charAt(i - 1) == 'E')
                                            && (Character.isDigit(input.charAt(i - 2)) || input.charAt(i - 2) == '.')) {
                                        temp2 += Character.toString(input.charAt(i));
                                        i++;
                                    } else if (checkOperators(Character.toString(input.charAt(i)))) {
                                        i--;
                                        break;
                                    } else if (!"".equals(checkPunctuators(Character.toString(input.charAt(i))))) {
                                        i--;
                                        break;
                                    } else if (input.charAt(i) == ' ') {
                                        i--;
                                        break;
                                    } else {
                                        i--;
                                        break;
                                    }

                                } else {
                                    i--;
                                    break;
                                }
                            }
                            if (checkFloat(temp2)) {
                                Token t = new Token("FLOAT_CONST", temp2, line);
                                tokenList.add(t);
                            } else {
                                Token t = new Token("INVALID_TOKEN", temp2, line);
                                tokenList.add(t);
                            }

                        } else {

                            Token t = new Token("DOT", "", line);
                            tokenList.add(t);
                            i--;
                        }
                    } else if (Character.isDigit(temp)) {
                        boolean flag = true;
                        while (true) {
                            if (i < input.length()) {
                                if (Character.isDigit(input.charAt(i)) || Character.isLetter(input.charAt(i))) {
                                    temp2 += Character.toString(input.charAt(i));
                                    i++;
                                } else if (input.charAt(i) == '\r') {
                                    i--;
                                    break;
                                } else if (input.charAt(i) == '\n') {
                                    i--;
                                    break;
                                } else if (input.charAt(i) == ';') {
                                    i--;
                                    break;
                                } else if ((input.charAt(i) == '+' || input.charAt(i) == '-')
                                        && (input.charAt(i - 1) == 'e' || input.charAt(i - 1) == 'E')
                                        && Character.isDigit(input.charAt(i - 2))) {
                                    temp2 += Character.toString(input.charAt(i));
                                    i++;
                                } else if (flag && input.charAt(i) == '.') {
                                    if (checkAlph(Character.toString(input.charAt(i + 1))) || checkAlph(Character.toString(input.charAt(i - 1)))) {
                                        i--;
                                        break;
                                    } else {
                                        temp2 += Character.toString(input.charAt(i));
                                        flag = false;
                                        i++;
                                    }
                                } else if (checkOperators(Character.toString(input.charAt(i)))) {
                                    i--;
                                    break;
                                } else if (!"".equals(checkPunctuators(Character.toString(input.charAt(i))))) {
                                    i--;
                                    break;
                                } else {
                                    i--;
                                    break;
                                }
                            } else {
                                i--;
                                break;
                            }
                        }
                        if (checkFloat(temp2)) {
                            Token t = new Token("FLOAT_CONST", temp2, line);
                            tokenList.add(t);
                        } else if (checkInt(temp2)) {
                            Token t = new Token("INTEGER_CONST", temp2, line);
                            tokenList.add(t);
                        } else {
                            Token t = new Token("INVALID_TOKEN", temp2, line);
                            tokenList.add(t);
                        }
                    }

                } else if (".".equals(temp2)) {
                    Token t = new Token("DOT", "", line);
                    tokenList.add(t);
                    i--;
                } else {
                    Token t = new Token("INTEGER_CONST", Character.toString(temp), line);
                    tokenList.add(t);
                    i--;
                }

            } //Invalid Token
            else {
                if (!allowedChars(Character.toString(temp))) {
                    Token t = new Token("Invalid Token", Character.toString(temp), line);
                    tokenList.add(t);
                } else if (input.charAt(i) == '\r') {
                    line++;
                }
            }
            i++;
        }
        Token t = new Token("End of input", "$", line);
        tokenList.add(t);
        RWFile.writeToFile(tokenList);
        return tokenList;
    }

    public boolean checkInt(String a) {

        Pattern p = Pattern.compile("([+]|-)?[0-9]+((e|E)[+-]?[0-9]+)?");
        Matcher m = p.matcher(a);
        return m.matches();
    }

    public boolean allowedChars(String a) {
        Pattern p = Pattern.compile("\n|\r| ");
        Matcher m = p.matcher(a);
        return m.matches();
    }

    public boolean checkFloat(String a) {

        Pattern p = Pattern.compile("([+-]?[0-9]*[.][0-9]+((e|E)[+-]?[0-9]+)?)");
        Matcher m = p.matcher(a);
        return m.matches();

    }

    public boolean charValidate(String a) {

        Pattern p = Pattern.compile("'([^\\\\\']|(\\\\[nrtfb0\\\\\"\']))'");
        Matcher m = p.matcher(a);
        return m.matches();
    }

    public boolean stringValidate(String a) {

        Pattern p = Pattern.compile("\"([^\\\\\"]|(\\\\[nrtfb0\\\\\"\']))*\"");
        Matcher m = p.matcher(a);
        return m.matches();
    }

    public boolean checkOperators(String a) {

        Pattern p = Pattern.compile("[+]|[-]|[=]|[/]|[*]|[&]|[!]|[<]|[>]|[%]|[~]|[|]");
        Matcher m = p.matcher(a);
        return m.matches();

    }

    public String checkOperatorsList(String a) {

        OperatorsList ol = new OperatorsList();

        for (int i = 0; i < ol.operators.size(); i++) {
            int temp = Collections.binarySearch(ol.operators.get(i).keywords, a);
            if (temp >= 0) {
                return ol.operators.get(i).className;
            }
        }

        return "";
    }

    public String checkPunctuators(String a) {
        PunctuatorsList pl = new PunctuatorsList();

        for (int i = 0; i < pl.punctuators.size(); i++) {
            int temp = Collections.binarySearch(pl.punctuators.get(i).keywords, a);
            if (temp >= 0) {
                return pl.punctuators.get(i).className;
            }
        }
        return "";
    }

    public String checkKeyword(String a) {
        KeywordsList kw = new KeywordsList();

        for (int i = 0; i < kw.keyword.size(); i++) {
            int temp = Collections.binarySearch(kw.keyword.get(i).keywords, a);
            if (temp >= 0) {
                return kw.keyword.get(i).className;
            }
        }
        return "";
    }

    public boolean checkAlph(String a) {
        Pattern p = Pattern.compile("[A-Za-z]");
        Matcher m = p.matcher(a);
        return m.matches();
    }

    public boolean checkIdentifier(String a) {

        Pattern p = Pattern.compile("_[_(\\w)]+|[A-Za-z][_(\\w)]*");
        Matcher m = p.matcher(a);
        return m.matches();
    }

}
