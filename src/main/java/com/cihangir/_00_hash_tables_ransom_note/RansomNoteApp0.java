package com.cihangir._00_hash_tables_ransom_note;

import java.util.HashMap;
import java.util.Map;

public class RansomNoteApp0 {

    public static void main(String[] args) {


        //String magazineString = "give me one grand today night";
        //String noteString = "give one grand today";


        //String magazineString = "two times three is not four";
        //String noteString = "two times two is four";


        //String magazineString = "ive got a lovely bunch of coconuts";
        //String noteString = "ive got some coconuts";



        String magazineString = "apgo clm w lxkvg mwz elo bg elo lxkvg elo apgo apgo w elo bg";
        String noteString = "elo lxkvg bg mwz clm w";


        String[] magazine = magazineString.split(" ");
        String[] note = noteString.split(" ");

        checkMagazine(magazine, note);

    }


    // Complete the checkMagazine function below.
    static String checkMagazine(String[] magazine, String[] note) {

        final Map<String, Integer> noteWordsMap = new HashMap<>();
        for (String noteWord : note) {
            int count = noteWordsMap.containsKey(noteWord) ? noteWordsMap.get(noteWord)+1 : 1;
            noteWordsMap.put(noteWord, count);
        }


        for (String magazineWord : magazine) {
            if ( noteWordsMap.containsKey(magazineWord)){
                int count = noteWordsMap.get(magazineWord)-1;
                noteWordsMap.put(magazineWord, count);
            }
        }

        String messsage = "Yes";
        for ( int frequency : noteWordsMap.values()){
            // it means notes not available magazine
            if ( frequency > 0 ){
                messsage = "No";
                break;
            }
        }

        System.out.println(messsage);
        return messsage;
    }


}
