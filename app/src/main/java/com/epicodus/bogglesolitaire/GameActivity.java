package com.epicodus.bogglesolitaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.concurrent.ThreadLocalRandom;

public class GameActivity extends AppCompatActivity {
    public static final String TAG = GameActivity.class.getSimpleName();
    private static ArrayList<Map> mAllDice;
    private static ArrayList<Character> mLetterSet;
    private static final Map<Integer, Character> die1;
    static {
        die1 = new HashMap<Integer, Character>();
        die1.put(1, 'a');
        die1.put(2, 'a');
        die1.put(3, 'e');
        die1.put(4, 'e');
        die1.put(5, 'g');
        die1.put(6, 'n');
    }
    private static final Map<Integer, Character> die2;
    static {
        die2 = new HashMap<Integer, Character>();
        die2.put(1, 'c');
        die2.put(2, 'i');
        die2.put(3, 'm');
        die2.put(4, 'o');
        die2.put(5, 't');
        die2.put(6, 'u');
    }
    private static final Map<Integer, Character> die3;
    static {
        die3 = new HashMap<Integer, Character>();
        die3.put(1, 'a');
        die3.put(2, 'o');
        die3.put(3, 'o');
        die3.put(4, 't');
        die3.put(5, 't');
        die3.put(6, 'w');
    }
    private static final Map<Integer, Character> die4;
    static {
        die4 = new HashMap<Integer, Character>();
        die4.put(1, 'e');
        die4.put(2, 'h');
        die4.put(3, 'r');
        die4.put(4, 't');
        die4.put(5, 'v');
        die4.put(6, 'w');
    }
    private static final Map<Integer, Character> die5;
    static {
        die5 = new HashMap<Integer, Character>();
        die5.put(1, 'd');
        die5.put(2, 'i');
        die5.put(3, 's');
        die5.put(4, 't');
        die5.put(5, 't');
        die5.put(6, 'y');
    }
    private static final Map<Integer, Character> die6;
    static {
        die6 = new HashMap<Integer, Character>();
        die6.put(1, 'a');
        die6.put(2, 'f');
        die6.put(3, 'f');
        die6.put(4, 'k');
        die6.put(5, 'p');
        die6.put(6, 's');
    }
    private static final Map<Integer, Character> die7;
    static {
        die7 = new HashMap<Integer, Character>();
        die7.put(1, 'd');
        die7.put(2, 'e');
        die7.put(3, 'l');
        die7.put(4, 'r');
        die7.put(5, 'v');
        die7.put(6, 'y');
    }
    private static final Map<Integer, Character> die8;
    static {
        die8 = new HashMap<Integer, Character>();
        die8.put(1, 'h');
        die8.put(2, 'l');
        die8.put(3, 'n');
        die8.put(4, 'n');
        die8.put(5, 'r');
        die8.put(6, 'z');
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mAllDice = new ArrayList<Map>();
        mAllDice.add(die1);
        mAllDice.add(die2);
        mAllDice.add(die3);
        mAllDice.add(die4);
        mAllDice.add(die5);
        mAllDice.add(die6);
        mAllDice.add(die7);
        mAllDice.add(die8);
        mLetterSet = new ArrayList<Character>();
        mLetterSet = generateLetters();


    }

    private ArrayList<Character> generateLetters(){
        Log.d(TAG, "i am within generateLetters");
        ArrayList<Character> letterList = new ArrayList<Character>();

        do{
            letterList.clear();
            Random rand = new Random();
            for (int i = 0; i < mAllDice.size(); i++) {
                int randomNum = rand.nextInt(6) + 1;
                Character letter = (Character) mAllDice.get(i).get(randomNum);
                letterList.add(Character.toUpperCase(letter));
                Log.d(TAG, letterList.get(letterList.size() - 1).toString());
            }

        } while(!vowelChecker(letterList));
        return letterList;
    }

    private boolean vowelChecker(ArrayList<Character> letterSet){
        Character[] vowels = {'A', 'E', 'I', 'O', 'U'};
        int counter = 0;
        for (int i = 0; i < letterSet.size(); i++){
            if (Arrays.asList(vowels).contains(letterSet.get(i))){
                counter++;
            }
        }
        if(counter > 1){
            return true;
        } else {
            return false;
        }
    }
}
