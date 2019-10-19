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
public class KeywordsList {

    ArrayList<ListItem> keyword = new ArrayList<>();

    ArrayList<String> DataType = new ArrayList<>();
    ArrayList<String> AM = new ArrayList<>();
    ArrayList<String> TF = new ArrayList<>();
    ArrayList<String> VOID = new ArrayList<>();
    ArrayList<String> UNTIL = new ArrayList<>();
    ArrayList<String> DO = new ArrayList<>();
    ArrayList<String> FOR = new ArrayList<>();
    ArrayList<String> STOP = new ArrayList<>();
    ArrayList<String> PERDUE = new ArrayList<>();
    ArrayList<String> RECOIL = new ArrayList<>();
    ArrayList<String> EXTENDS = new ArrayList<>();
    ArrayList<String> FINAL = new ArrayList<>();
    ArrayList<String> IMPLEMENTS = new ArrayList<>();
    ArrayList<String> INTERFACE = new ArrayList<>();
    ArrayList<String> CLASS = new ArrayList<>();
    ArrayList<String> CREATE = new ArrayList<>();
    ArrayList<String> SUPER = new ArrayList<>();
    ArrayList<String> THIS = new ArrayList<>();
    ArrayList<String> TRY = new ArrayList<>();
    ArrayList<String> CATCH = new ArrayList<>();
    ArrayList<String> FINALLY = new ArrayList<>();
    ArrayList<String> FUN = new ArrayList<>();
    ArrayList<String> WHENEVER = new ArrayList<>();
    ArrayList<String> BESIDE = new ArrayList<>();
    ArrayList<String> WHEN = new ArrayList<>();
    ArrayList<String> STATIC = new ArrayList<>();

    public KeywordsList() {

        DataType.add("int");
        DataType.add("float");
        DataType.add("long");
        DataType.add("short");
        DataType.add("char");
        DataType.add("string");
        Collections.sort(DataType);
        ListItem dt = new ListItem("DATATYPE", DataType);
        keyword.add(dt);

        AM.add("private");
        AM.add("public");
        AM.add("protected");
        Collections.sort(AM);
        dt = new ListItem("AM", AM);
        keyword.add(dt);

        STATIC.add("static");
        dt = new ListItem("STATIC", STATIC);
        keyword.add(dt);

        STATIC = new ArrayList<>();
        STATIC.add("main");
        dt = new ListItem("MAIN", STATIC);
        keyword.add(dt);

        TF.add("true");
        TF.add("false");
        Collections.sort(TF);
        dt = new ListItem("TF", TF);
        keyword.add(dt);

        VOID.add("void");
        Collections.sort(VOID);
        dt = new ListItem("VOID", VOID);
        keyword.add(dt);

        UNTIL.add("until");
        Collections.sort(UNTIL);
        dt = new ListItem("UNTIL", UNTIL);
        keyword.add(dt);

        DO.add("do");
        Collections.sort(DO);
        dt = new ListItem("DO", DO);
        keyword.add(dt);

        FOR.add("for");
        Collections.sort(FOR);
        dt = new ListItem("FOR", FOR);
        keyword.add(dt);

        STOP.add("until");
        Collections.sort(STOP);
        dt = new ListItem("STOP", STOP);
        keyword.add(dt);

        PERDUE.add("perdue");
        Collections.sort(PERDUE);
        dt = new ListItem("PERDUE", PERDUE);
        keyword.add(dt);

        FINALLY.add("finally");
        dt = new ListItem("FINALLY", FINALLY);
        keyword.add(dt);

        RECOIL.add("recoil");
        Collections.sort(RECOIL);
        dt = new ListItem("RECOIL", RECOIL);
        keyword.add(dt);

        FINAL.add("final");
        Collections.sort(FINAL);
        dt = new ListItem("FINAL", FINAL);
        keyword.add(dt);

        EXTENDS.add("extends");
        Collections.sort(EXTENDS);
        dt = new ListItem("EXTENDS", EXTENDS);
        keyword.add(dt);

        IMPLEMENTS.add("implements");
        Collections.sort(IMPLEMENTS);
        dt = new ListItem("IMPLEMENTS", IMPLEMENTS);
        keyword.add(dt);

        INTERFACE.add("interface");
        Collections.sort(INTERFACE);
        dt = new ListItem("INTERFACE", INTERFACE);
        keyword.add(dt);

        CLASS.add("class");
        Collections.sort(CLASS);
        dt = new ListItem("CLASS", CLASS);
        keyword.add(dt);

        CREATE.add("create");
        Collections.sort(CREATE);
        dt = new ListItem("CREATE", CREATE);
        keyword.add(dt);

        SUPER.add("super");
        Collections.sort(SUPER);
        dt = new ListItem("SUPER", SUPER);
        keyword.add(dt);

        THIS.add("this");
        Collections.sort(THIS);
        dt = new ListItem("THIS", THIS);
        keyword.add(dt);

        TRY.add("try");
        Collections.sort(TRY);
        dt = new ListItem("TRY", TRY);
        keyword.add(dt);

        CATCH.add("catch");
        Collections.sort(CATCH);
        dt = new ListItem("CATCH", CATCH);
        keyword.add(dt);

        FUN.add("fun");
        Collections.sort(FUN);
        dt = new ListItem("FUN", FUN);
        keyword.add(dt);

        WHENEVER.add("whenever");
        Collections.sort(WHENEVER);
        dt = new ListItem("WHENEVER", WHENEVER);
        keyword.add(dt);

        BESIDE.add("beside");
        Collections.sort(BESIDE);
        dt = new ListItem("BESIDE", BESIDE);
        keyword.add(dt);

        WHEN.add("when");
        Collections.sort(WHEN);
        dt = new ListItem("WHEN", WHEN);
        keyword.add(dt);

    }

}
