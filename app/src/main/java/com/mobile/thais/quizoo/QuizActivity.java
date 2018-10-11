package com.mobile.thais.quizoo;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mobile.thais.quizoo.DataBase.QuizOpenHelper;

import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView viewPontuacao;
    private TextView viewContagemQuestao;
    private TextView viewEnunciadoQuestao;
    private TextView viewContagemTempo;
    private RadioGroup grupoAlternativas;
    private RadioButton rbAlter1;
    private RadioButton rbAlter2;
    private RadioButton rbAlter3;
    private RadioButton rbAlter4;
    private Button btnResponder;
    private Button btnPararJogo;

    private ColorStateList textColordefaultRb;

    private List<Questao> questaoList;
    private int questionCounter;
    private int questionCountTotal;
    private Questao questaoAtual;
    private int score = 0;
    private boolean answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        viewPontuacao = findViewById(R.id.viewPontuacaoAtual);
        viewContagemQuestao = findViewById(R.id.viewCountQuestao);
        viewEnunciadoQuestao = findViewById(R.id.viewQuestao);
        viewContagemTempo = findViewById(R.id.viewTempo);
        grupoAlternativas = findViewById(R.id.grupoAlternativas);
        rbAlter1 = findViewById(R.id.alternativaA);
        rbAlter2 = findViewById(R.id.alternativaB);
        rbAlter3 = findViewById(R.id.alternativaC);
        rbAlter4 = findViewById(R.id.alternativaD);
        btnResponder = findViewById(R.id.btnResponder);
        btnPararJogo = findViewById(R.id.btnPararJogo);

        textColordefaultRb = rbAlter1.getTextColors();

        QuizOpenHelper dbHelper = new QuizOpenHelper(this);
        questaoList = dbHelper.getAllQuestions();
        questionCountTotal = questaoList.size();
        Collections.shuffle(questaoList);

        mostrarProximaQuestao();

        btnResponder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!answered){
                    if(rbAlter1.isChecked() || rbAlter2.isChecked() || rbAlter3.isChecked() || rbAlter4.isChecked()){
                        checkAnswer();
                    } else {
                        Toast.makeText(QuizActivity.this, "Selecione uma alternativa!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    mostrarProximaQuestao();
                }
            }
        });

        btnPararJogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void mostrarProximaQuestao() {
        rbAlter1.setTextColor(textColordefaultRb);
        rbAlter2.setTextColor(textColordefaultRb);
        rbAlter3.setTextColor(textColordefaultRb);
        rbAlter4.setTextColor(textColordefaultRb);
        grupoAlternativas.clearCheck();

        if(questionCounter < questionCountTotal){
            questaoAtual = questaoList.get(questionCounter);
            viewEnunciadoQuestao.setText(questaoAtual.getQuestao());
            rbAlter1.setText(questaoAtual.getAlternativaA());
            rbAlter2.setText(questaoAtual.getAlternativaB());
            rbAlter3.setText(questaoAtual.getAlternativaC());
            rbAlter4.setText(questaoAtual.getAlternativaD());

            questionCounter++;
            viewContagemQuestao.setText("Questão: " + questionCounter + "/" + questionCountTotal);
            answered = false;
            btnResponder.setText("Responder");
        } else {
            finalizarQuiz();
        }
    }

    private void checkAnswer(){
        answered = true;

        RadioButton rbSelecionado = findViewById(grupoAlternativas.getCheckedRadioButtonId());
        int answerNum = grupoAlternativas.indexOfChild(rbSelecionado) + 1;

        if(answerNum == questaoAtual.getRespostaCorreta()){
            score++;
            viewPontuacao.setText("Pontuação: " + score);
        }

        mostrarSolucao();

    }

    private void mostrarSolucao() {
        rbAlter1.setTextColor(Color.RED);
        rbAlter2.setTextColor(Color.RED);
        rbAlter3.setTextColor(Color.RED);
        rbAlter4.setTextColor(Color.RED);

        switch (questaoAtual.getRespostaCorreta()){
            case 1:
                rbAlter1.setTextColor(Color.GREEN);
                break;
            case 2:
                rbAlter2.setTextColor(Color.GREEN);
                break;
            case 3:
                rbAlter3.setTextColor(Color.GREEN);
                break;
            case 4:
                rbAlter4.setTextColor(Color.GREEN);
                break;

        }

        if(questionCounter < questionCountTotal){
            btnResponder.setText("Próxima");
        } else {
            score = score - 2;
            btnResponder.setText("Finalizar");
        }
    }

    private void finalizarQuiz() {
        finish();
    }


}
