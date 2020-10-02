package com.example.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    private TextView mScoreView, mQuestion;
    private ImageView mImageView;

    private  boolean mAnswer;
    private int mScore = 0;
    private  int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mScoreView = findViewById(R.id.points);
        mImageView = findViewById(R.id.imageView);
        mQuestion = findViewById(R.id.question);
        Button mFactButton = findViewById(R.id.trueButton); // might need to declare this out of onCreate
        Button mFakeButton = findViewById(R.id.falseButton); //this too

        updateQuestion();

        // Logic for fact button
        mFactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mAnswer){
                    mScore++; //updates score int variable
                    updateScore(mScore); //converts int variable to a string and adds it to mScoreview

                    //check before question update
                    if (mQuestionNumber == QuizBook.questions.length){
                        Intent i = new Intent(QuizActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }

                //if answer is wrong
                else {
                    if (mQuestionNumber == QuizBook.questions.length){
                        Intent i = new Intent(QuizActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
            }
        });


        // Logic for fake button
        mFakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!mAnswer){
                    mScore++; //updates score int variable
                    updateScore(mScore); //converts int variable to a string and adds it to mScoreview

                    //check before question update
                    if (mQuestionNumber == QuizBook.questions.length){
                        Intent i = new Intent(QuizActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }

                //if answer is wrong
                else {
                    if (mQuestionNumber == QuizBook.questions.length){
                        Intent i = new Intent(QuizActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }

                }
            }
        });
    }

    private void updateQuestion(){
        mImageView.setImageResource(QuizBook.images[mQuestionNumber]);

        //shuffleImages();
        mQuestion.setText(QuizBook.questions[mQuestionNumber]);
        mAnswer = QuizBook.answers[mQuestionNumber];
        mQuestionNumber++;
    }

    public void updateScore (int point){
        mScoreView.setText("" + mScore);
    }

    //public void shuffleImages(){
    //    Collections.shuffle(Arrays.asList(QuizBook.images));
    //}
}

