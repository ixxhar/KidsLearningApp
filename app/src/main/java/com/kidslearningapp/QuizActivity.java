package com.kidslearningapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class QuizActivity extends AppCompatActivity {

    TextView questionLabel, questionCountLabel, scoreLabel, levelo;
    EditText answerEdt;
    Button submitButton;
    ProgressBar progressBar;
    ArrayList<QuestionModel> questionModelArraylistlevelone;
    ArrayList<QuestionModel> questionModelArraylistleveltwo;
    ArrayList<QuestionModel> questionModelArraylistlevelthree;

    ArrayList<QuestionModel> questionModelArraylistWrong;
    int one = 1;
    int level=1;

    int currentPosition = 0;
    int numberOfCorrectAnswer = 0;

    int totalanswers=0;
    int totalquestions=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        trackHistory();

        questionCountLabel = findViewById(R.id.noQuestion);
        questionLabel = findViewById(R.id.question);
        scoreLabel = findViewById(R.id.score);

        answerEdt = findViewById(R.id.answer);
        submitButton = findViewById(R.id.submit);
        progressBar = findViewById(R.id.progress);
        levelo = (TextView) findViewById(R.id.textViewLevel);
        levelo.setText("Level "+level);

        questionModelArraylistlevelone = new ArrayList<>();
        questionModelArraylistleveltwo = new ArrayList<>();
        questionModelArraylistlevelthree = new ArrayList<>();

        questionModelArraylistWrong=new ArrayList<>();

        setUpQuestion();

        setData();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level==1){
                    checkAnswer();
                }else if (level==2){
                    checkAnswer2();
                }else if (level==3){
                    checkAnswer3();
                }

            }
        });

        answerEdt.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                Log.e("event.getAction()", event.getAction() + "");
                Log.e("event.keyCode()", keyCode + "");
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    if (level==1){
                        checkAnswer();
                    }else if (level==2){
                        checkAnswer2();
                    }else if (level==3){
                        checkAnswer3();
                    }
                    return true;
                }
                return false;
            }
        });

    }

    public void checkAnswer() {
        String answerString = answerEdt.getText().toString().trim();


        if (answerString.equalsIgnoreCase(questionModelArraylistlevelone.get(currentPosition).getAnswer())) {
            numberOfCorrectAnswer++;


            new SweetAlertDialog(QuizActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Good job!")
                    .setContentText("Right Asswer")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            currentPosition++;

                            setData();
                            answerEdt.setText("");
                            sweetAlertDialog.dismiss();
                        }
                    })
                    .show();


        } else {

            questionModelArraylistWrong.add(questionModelArraylistlevelone.get(currentPosition));
            new SweetAlertDialog(QuizActivity.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("Wrong Answer")
                    //.setContentText("The right answer is : " + questionModelArraylist.get(currentPosition).getAnswer())
                    .setConfirmText("OK")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismiss();

                            currentPosition++;

                            setData();
                            answerEdt.setText("");
                        }
                    })
                    .show();
        }


        int x = ((currentPosition + one) * 100) / questionModelArraylistlevelone.size();

        progressBar.setProgress(x);


    }

    public void checkAnswer2() {
        String answerString = answerEdt.getText().toString().trim();


        if (answerString.equalsIgnoreCase(questionModelArraylistleveltwo.get(currentPosition).getAnswer())) {
            numberOfCorrectAnswer++;


            new SweetAlertDialog(QuizActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Good job!")
                    .setContentText("Right Asswer")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            currentPosition++;

                            setData2();
                            answerEdt.setText("");
                            sweetAlertDialog.dismiss();
                        }
                    })
                    .show();


        } else {

            questionModelArraylistWrong.add(questionModelArraylistlevelone.get(currentPosition));
            new SweetAlertDialog(QuizActivity.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("Wrong Answer")
                    //.setContentText("The right answer is : " + questionModelArraylist.get(currentPosition).getAnswer())
                    .setConfirmText("OK")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismiss();

                            currentPosition++;

                            setData2();
                            answerEdt.setText("");
                        }
                    })
                    .show();
        }


        int x = ((currentPosition + one) * 100) / questionModelArraylistleveltwo.size();

        progressBar.setProgress(x);


    }

    public void checkAnswer3() {
        String answerString = answerEdt.getText().toString().trim();


        if (answerString.equalsIgnoreCase(questionModelArraylistlevelthree.get(currentPosition).getAnswer())) {
            numberOfCorrectAnswer++;

            new SweetAlertDialog(QuizActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Good job!")
                    .setContentText("Right Asswer")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            currentPosition++;

                            setData3();
                            answerEdt.setText("");
                            sweetAlertDialog.dismiss();
                        }
                    })
                    .show();


        } else {

            questionModelArraylistWrong.add(questionModelArraylistlevelthree.get(currentPosition));
            new SweetAlertDialog(QuizActivity.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("Wrong Answer")
                    //.setContentText("The right answer is : " + questionModelArraylist.get(currentPosition).getAnswer())
                    .setConfirmText("OK")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismiss();

                            currentPosition++;

                            setData3();
                            answerEdt.setText("");
                        }
                    })
                    .show();
        }


        int x = ((currentPosition + one) * 100) / questionModelArraylistlevelthree.size();

        progressBar.setProgress(x);


    }


    public void setUpQuestion() {


        questionModelArraylistlevelone.add(new QuestionModel("What is 1+2 ? ", "3"));
        questionModelArraylistlevelone.add(new QuestionModel("What is 8*8 ? ", "64"));
        questionModelArraylistlevelone.add(new QuestionModel("What is 9*12 ? ", "108"));

        questionModelArraylistleveltwo.add(new QuestionModel("What is 6*8 ? ", "48"));
        questionModelArraylistleveltwo.add(new QuestionModel("What is 12/3 ? ", "4"));
        questionModelArraylistleveltwo.add(new QuestionModel("what is 5*5 ? ", "25"));

        questionModelArraylistlevelthree.add(new QuestionModel("What is this '∀' ? ", "A"));
        questionModelArraylistlevelthree.add(new QuestionModel("What is this 'Ǝ' ? ", "E"));
        questionModelArraylistlevelthree.add(new QuestionModel("What is this 'Q' ? ", "Q"));



    }

    public void setData() {
        answerEdt.setInputType(InputType.TYPE_CLASS_NUMBER);


        if (questionModelArraylistlevelone.size() > currentPosition) {

            questionLabel.setText(questionModelArraylistlevelone.get(currentPosition).getQuestionString());

            scoreLabel.setText("Score :" + numberOfCorrectAnswer + "/" + questionModelArraylistlevelone.size());
            questionCountLabel.setText("Question No : " + (currentPosition + one));


        } else {

            if (numberOfCorrectAnswer>=2) {
                level++;

                new SweetAlertDialog(QuizActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("You have successfully completed level 1")
                        .setContentText("Your score is : " + numberOfCorrectAnswer + "/" + questionModelArraylistlevelone.size())
                        .setContentText(questionModelArraylistWrong.toString())
                        .setConfirmText("level 2")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {

                                sDialog.dismissWithAnimation();
                                currentPosition = 0;
                                numberOfCorrectAnswer = 0;
                                progressBar.setProgress(0);
                                setData2();
                            }
                        })
                        .setCancelText("Close")
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {

                                sDialog.dismissWithAnimation();
                                finish();
                            }
                        })
                        .show();

                totalanswers+=numberOfCorrectAnswer;
                totalquestions+=questionModelArraylistlevelone.size();
                levelo.setText("Level "+level);

            }else {
                new SweetAlertDialog(QuizActivity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("You have failed level 1")
                        .setContentText("Your score is : " + numberOfCorrectAnswer + "/" + questionModelArraylistlevelone.size())
                        .setContentText(questionModelArraylistWrong.toString())
                        .setConfirmText("restart")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {

                                sDialog.dismissWithAnimation();
                                currentPosition = 0;
                                numberOfCorrectAnswer = 0;
                                progressBar.setProgress(0);
                                setData();
                            }
                        })
                        .setCancelText("Close")
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {

                                sDialog.dismissWithAnimation();
                                finish();
                            }
                        })
                        .show();
            }

            questionModelArraylistWrong.clear();

        }

    }

    public void setData2() {
        answerEdt.setInputType(InputType.TYPE_CLASS_NUMBER);


        if (questionModelArraylistleveltwo.size() > currentPosition) {

            questionLabel.setText(questionModelArraylistleveltwo.get(currentPosition).getQuestionString());

            scoreLabel.setText("Score :" + numberOfCorrectAnswer + "/" + questionModelArraylistleveltwo.size());
            questionCountLabel.setText("Question No : " + (currentPosition + one));


        } else {

            if (numberOfCorrectAnswer>=2) {
                level++;

                new SweetAlertDialog(QuizActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("You have successfully completed level 2")
                        .setContentText("Your score is : " + numberOfCorrectAnswer + "/" + questionModelArraylistleveltwo.size())
                        .setContentText(questionModelArraylistWrong.toString())
                        .setConfirmText("level 3")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {

                                sDialog.dismissWithAnimation();
                                currentPosition = 0;
                                numberOfCorrectAnswer = 0;
                                progressBar.setProgress(0);
                                setData3();
                            }
                        })
                        .setCancelText("Close")
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {

                                sDialog.dismissWithAnimation();
                                finish();
                            }
                        })
                        .show();

                totalanswers+=numberOfCorrectAnswer;
                totalquestions+=questionModelArraylistleveltwo.size();
                levelo.setText("Level "+level);

            }else {
                new SweetAlertDialog(QuizActivity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("You have failed level 2")
                        .setContentText("Your score is : " + numberOfCorrectAnswer + "/" + questionModelArraylistleveltwo.size())
                        .setContentText(questionModelArraylistWrong.toString())
                        .setConfirmText("restart")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {

                                sDialog.dismissWithAnimation();
                                currentPosition = 0;
                                numberOfCorrectAnswer = 0;
                                progressBar.setProgress(0);
                                setData2();
                            }
                        })
                        .setCancelText("Close")
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {

                                sDialog.dismissWithAnimation();
                                finish();
                            }
                        })
                        .show();
            }

            questionModelArraylistWrong.clear();

        }

    }

    public void setData3() {
        answerEdt.setInputType(InputType.TYPE_CLASS_TEXT);

        if (questionModelArraylistlevelthree.size() > currentPosition) {

            questionLabel.setText(questionModelArraylistlevelthree.get(currentPosition).getQuestionString());

            scoreLabel.setText("Score :" + numberOfCorrectAnswer + "/" + questionModelArraylistlevelthree.size());
            questionCountLabel.setText("Question No : " + (currentPosition + one));


        } else {


            if (numberOfCorrectAnswer>=2) {
                level=1;

                new SweetAlertDialog(QuizActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("You have successfully completed level 3")
                        .setContentText("Your score is : " + numberOfCorrectAnswer + "/" + questionModelArraylistlevelthree.size())
                        .setContentText(questionModelArraylistWrong.toString())
                        .setConfirmText("Restart Quiz")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {

                                sDialog.dismissWithAnimation();
                                currentPosition = 0;
                                numberOfCorrectAnswer = 0;
                                progressBar.setProgress(0);
                                setData();
                            }
                        })
                        .setCancelText("Close")
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {

                                sDialog.dismissWithAnimation();
                                finish();
                            }
                        })
                        .show();

                totalanswers+=numberOfCorrectAnswer;
                totalquestions+=questionModelArraylistlevelthree.size();
                levelo.setText("Level "+level);
                trackScore("Your score is : " + totalanswers + "/" + totalquestions);

            }else {
                new SweetAlertDialog(QuizActivity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("You have failed level 3")
                        .setContentText("Your score is : " + numberOfCorrectAnswer + "/" + questionModelArraylistlevelthree.size())
                        .setContentText(questionModelArraylistWrong.toString())
                        .setConfirmText("Restart")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {

                                sDialog.dismissWithAnimation();
                                currentPosition = 0;
                                numberOfCorrectAnswer = 0;
                                progressBar.setProgress(0);
                                setData2();
                            }
                        })
                        .setCancelText("Close")
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {

                                sDialog.dismissWithAnimation();
                                finish();
                            }
                        })
                        .show();

            }

            questionModelArraylistWrong.clear();


        }

    }

    public void trackHistory() { //for tracking history
        DatabaseHelper mDatabaseHelper;
        mDatabaseHelper = new DatabaseHelper(this);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        final String timedate = dateFormat.format(new Date()); // Find todays date

        boolean insertData = mDatabaseHelper.addData("Quiz Activity", timedate);

        if (insertData) {
            Toast.makeText(getApplicationContext(), "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG).show();
        }

    }

    public void trackScore(String score) { //for tracking history
        DatabaseHelperScore databaseHelperScore;
        databaseHelperScore = new DatabaseHelperScore(this);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        final String timedate = dateFormat.format(new Date()); // Find todays date

        boolean insertData = databaseHelperScore.addData(score, timedate);

        if (insertData) {
            Toast.makeText(getApplicationContext(), "Score Successfully Inserted!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
