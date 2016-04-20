package com.epicodus.bogglesolitaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ResultsActivity extends AppCompatActivity {
    public static final String TAG = ResultsActivity.class.getSimpleName();
    @Bind(R.id.tvTotalScore) TextView mTotalScoreText;
    @Bind(R.id.tvLetterSet) TextView mLetterSetText;
    @Bind(R.id.lvValidWords) ListView mValidWordsList;
    @Bind(R.id.lvInvalidWords) ListView mInvalidWordsList;
    @Bind(R.id.buttonRestart) Button mRestartButton;
    private static String[] mLetterSet;
    private static ArrayList<String> mWordsGuessed;
    private static ArrayList<String> mValidWords;
    private static ArrayList<String> mInvalidWords;
    private static Integer mScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        ButterKnife.bind(this);

//

        Intent intent = getIntent();
        String letterString = intent.getStringExtra("letterDisplay");
        mLetterSet = letterString.split("  ");
        mWordsGuessed = intent.getStringArrayListExtra("wordsGuessed");
        mScore = 0;
        evaluateWords();

        ArrayAdapter validAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mValidWords);
        mValidWordsList.setAdapter(validAdapter);
        ArrayAdapter invalidAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mInvalidWords);
        mInvalidWordsList.setAdapter(invalidAdapter);



        mLetterSetText.setText(letterString);
        mTotalScoreText.setText(mScore.toString());
    }

    private static void evaluateWords(){
        mValidWords = new ArrayList<String>();
        mInvalidWords = new ArrayList<String>();
        for (String word : mWordsGuessed){
            String testWord = word.toUpperCase();
            for (int i = 0; i < mLetterSet.length; i++){
                int index = testWord.indexOf(mLetterSet[i]);
                if (index > -1){
                    testWord = testWord.replaceFirst(mLetterSet[i], "");
                }
            }
            if (testWord.length() > 0){
                mInvalidWords.add(word);
            } else {
                Integer score = getScore(word);
                mScore += score;
                String displayWord = word + " -- " + score;
                mValidWords.add(displayWord);
            }
        }

    }

    private static Integer getScore(String word) {
        Map<Integer, Integer> scoreValues = new HashMap<Integer, Integer>();
        scoreValues.put(3, 1);
        scoreValues.put(4, 1);
        scoreValues.put(5, 2);
        scoreValues.put(6, 3);
        scoreValues.put(7, 5);
        scoreValues.put(8, 11);
        return scoreValues.get(word.length());
    }
}
