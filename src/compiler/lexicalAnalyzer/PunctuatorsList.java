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
public class PunctuatorsList {

    ArrayList<ListItem> punctuators = new ArrayList<>();

    ArrayList<String> Col = new ArrayList<>();
    ArrayList<String> SC = new ArrayList<>();
    ArrayList<String> Com = new ArrayList<>();
    ArrayList<String> OBB = new ArrayList<>();
    ArrayList<String> CBB = new ArrayList<>();
    ArrayList<String> OCB = new ArrayList<>();
    ArrayList<String> CCB = new ArrayList<>();
    ArrayList<String> OSB = new ArrayList<>();
    ArrayList<String> CSB = new ArrayList<>();

    public PunctuatorsList() {

        Col.add(":");
        ListItem pl = new ListItem("COL", Col);
        punctuators.add(pl);

        SC.add(";");
        pl = new ListItem("SC", SC);
        punctuators.add(pl);

        Com.add(",");
        pl = new ListItem("COM", Com);
        punctuators.add(pl);

        OBB.add("(");
        pl = new ListItem("OBB", OBB);
        punctuators.add(pl);

        CBB.add(")");
        pl = new ListItem("CBB", CBB);
        punctuators.add(pl);

        OCB.add("{");
        pl = new ListItem("OCB", OCB);
        punctuators.add(pl);

        CCB.add("}");
        pl = new ListItem("CCB", CCB);
        punctuators.add(pl);

        OSB.add("[");
        pl = new ListItem("OSB", OSB);
        punctuators.add(pl);

        CSB.add("]");
        pl = new ListItem("CSB", CSB);
        punctuators.add(pl);

    }
}
