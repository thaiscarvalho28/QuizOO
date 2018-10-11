package com.mobile.thais.quizoo;

import android.provider.BaseColumns;

public final class QuizContract {

    public QuizContract(){}

    public static class QuestionsTable implements BaseColumns {
        public static final String TABLE_NAME = "QuizOO";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_ALTERNATIVE1 = "alternativeA";
        public static final String COLUMN_ALTERNATIVE2 = "alternativeB";
        public static final String COLUMN_ALTERNATIVE3 = "alternativeC";
        public static final String COLUMN_ALTERNATIVE4 = "alternativeD";
        public static final String COLUMN_ANSWER_NUM = "answer_num";

    }
}

