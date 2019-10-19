/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler.lexicalAnalyzer;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Muhammad Huzaifa
 */
public class OperatorsList {

    ArrayList<ListItem> operators = new ArrayList<>();

    ArrayList<String> MDM = new ArrayList<>();
    ArrayList<String> PM = new ArrayList<>();
    ArrayList<String> IncDec = new ArrayList<>();

    ArrayList<String> r_operators = new ArrayList<>();

    ArrayList<String> And_B = new ArrayList<>();
    ArrayList<String> Or_B = new ArrayList<>();
    ArrayList<String> Not_B = new ArrayList<>();

    ArrayList<String> And_L = new ArrayList<>();
    ArrayList<String> Or_L = new ArrayList<>();
    ArrayList<String> Not_L = new ArrayList<>();

    ArrayList<String> IE = new ArrayList<>();
    ArrayList<String> EE = new ArrayList<>();

    ArrayList<String> Arrow = new ArrayList<>();

    public OperatorsList() {

        MDM.add("/");
        MDM.add("*");
        MDM.add("%");
        Collections.sort(MDM);
        ListItem ol = new ListItem("MDM", MDM);
        operators.add(ol);

        PM.add("+");
        PM.add("-");
        Collections.sort(PM);
        ol = new ListItem("PM", PM);
        operators.add(ol);

        IncDec.add("++");
        IncDec.add("--");
        Collections.sort(IncDec);
        ol = new ListItem("INCDEC", IncDec);
        operators.add(ol);

        r_operators.add(">");
        r_operators.add("<");
        r_operators.add("<=");
        r_operators.add(">=");
        r_operators.add("==");
        r_operators.add("!=");
        Collections.sort(r_operators);
        ol = new ListItem("R_OPERATORS", r_operators);
        operators.add(ol);

        Or_B.add("|");
        Collections.sort(Or_B);
        ol = new ListItem("OR_B", Or_B);
        operators.add(ol);

        And_B.add("&");
        Collections.sort(And_B);
        ol = new ListItem("AND_B", And_B);
        operators.add(ol);

        Not_B.add("~");
        Collections.sort(Not_B);
        ol = new ListItem("NOT_B", Not_B);
        operators.add(ol);

        Or_B.add("|");
        Collections.sort(Or_B);
        ol = new ListItem("OR_B", Or_B);
        operators.add(ol);

        And_L.add("&&");
        Collections.sort(And_L);
        ol = new ListItem("AND_L", And_L);
        operators.add(ol);

        Or_L.add("||");
        Collections.sort(Or_L);
        ol = new ListItem("OR_L", Or_L);
        operators.add(ol);

        Not_L.add("!");
        Collections.sort(Not_L);
        ol = new ListItem("NOT_L", Not_L);
        operators.add(ol);

        IE.add("+=");
        IE.add("-=");
        IE.add("*=");
        IE.add("/=");
        IE.add("%=");
        Collections.sort(IE);
        ol = new ListItem("IE", IE);
        operators.add(ol);

        EE.add("=");
        Collections.sort(EE);
        ol = new ListItem("EE", EE);
        operators.add(ol);

        Arrow.add("->");
        ol = new ListItem("ARROW", Arrow);
        operators.add(ol);
    }

}
