package com.mobile.thais.quizoo.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.mobile.thais.quizoo.Questao;
import com.mobile.thais.quizoo.QuizContract.*;

import java.util.ArrayList;
import java.util.List;

public class QuizOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "QuizOO";
    private static final int DATABASE_VERSION = 3;

    private SQLiteDatabase db;

    public QuizOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_ALTERNATIVE1 + " TEXT, " +
                QuestionsTable.COLUMN_ALTERNATIVE2 + " TEXT, " +
                QuestionsTable.COLUMN_ALTERNATIVE3 + " TEXT, " +
                QuestionsTable.COLUMN_ALTERNATIVE4 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NUM + " INTEGER" +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        preencherTabela();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void preencherTabela() {
        Questao q1 = new Questao("Em POO (Programação Orientada a Objetos), dizer que a classe A estende a classe B é o mesmo que dizer que:",
                "a) a classe B é subclasse de A;",
                "b) a classe A é superclasse de B;",
                "c) a classe A é derivada de B;",
                "d) a classe B é derivada de A;",
                3);
        addQuestion(q1);

        Questao q2 = new Questao("Em POO (programação orientada a objetos), dizer que a classe A é superclasse de B é o mesmo que dizer que:",
                "a) A é derivada de B;",
                "b) B é derivada de A;",
                "c) A estende B;",
                "d) B implementa A;",
                2);
        addQuestion(q2);

        Questao q3 = new Questao("Na programação orientada a objetos, os métodos representam:",
                "a) a implementação das ações das classes definidas;",
                "b) as associações estabelecidas entre as classes;",
                "c) o tipo de herança existente entre as classes;",
                "d) os tipos de linguagens de programação utilizados;",
                1);
        addQuestion(q3);

        Questao q4 = new Questao("As alterações dos atributos devem ocorrer por meio de métodos adequados, criados para acesso e modificação desses atributos. Essa característica é conhecida como:",
                "a) encapsulamento;",
                "b) herança;",
                "c) generalização;",
                "d) polimorfismo;",
                1);
        addQuestion(q4);

        Questao q5 = new Questao("Acerca da OO, OVERLOADING é a habilidade de poder definir diversas propriedades, métodos ou procedimentos em uma classe com o mesmo nome, que também pode ser definida como:",
                "a) Pirâmide;",
                "b) Pilha;",
                "c) Morphing;",
                "d) Sobrecarga;",
                4);
        addQuestion(q5);

        Questao q6 = new Questao("Em OO, para que uma subclasse de uma classe possa ter seu próprio comportamento, e mesmo assim compartilhar algumas das funcionalidades da classe pai, deve-se implementar:",
                "a) composição;",
                "b) generalização;",
                "c) polimorfismo;",
                "d) agregação;",
                3);
        addQuestion(q6);

        Questao q7 = new Questao("Assinale a alternativa que apresenta, corretamente, o conceito de programação orientada a objetos que promove a reutilização de software.",
                "a) Abstração de dados;",
                "b) Sobrecarga de operadores;",
                "c) Herança;",
                "d) Polimorfismo;",
                3);
        addQuestion(q7);

        Questao q8 = new Questao("Em um programa orientado a objetos, verifica-se que a classe X estende a classe Y. Ou seja, pode-se afirmar, pelos preceitos da POO, que:",
                "a) a classe X é derivada de Y;",
                "b) a classe Y é subclasse de X;",
                "c) a classe X é uma interface de Y;",
                "d) a classe X é superclasse de Y;",
                1);
        addQuestion(q8);

        Questao q9 = new Questao("Na orientação a objetos, a alteração do comportamento dos métodos herdados das superclasses para um comportamento mais específico nas subclasses, de forma a se criar um novo método na classe filha que contém a mesma assinatura e o mesmo tipo de retorno, relaciona-se a:",
                "a) portabilidade;",
                "b) sobrescrita;",
                "c) sobrecarga;",
                "d) abstração;",
                2);
        addQuestion(q9);

        Questao q10 = new Questao("Na orientação a objetos, o conceito de encapsulamento corresponde à propriedade de:",
                "a) receber, por uma classe, uma mensagem sem parâmetros;",
                "b) utilizar estruturas de matrizes quadradas nos programas desenvolvidos;",
                "c) ter um conjunto de objetos com a mesma classe;",
                "d) esconder ou ocultar detalhes da implementação de uma dada classe de outras classes;",
                4);
        addQuestion(q10);

        Questao q11 = new Questao("Na programação orientada a objetos são utilizados classes e métodos. Um método:",
                "a) com determinado nome não pode aparecer mais de uma vez na mesma classe, mesmo que receba parâmetros de tipos diferentes;",
                "b) em uma superclasse pode ser sobrescrito nas subclasses de uma relação de herança;",
                "c) em Java pode receber diversos parâmetros e ter diversas operações de retorno consecutivas de tipos diferentes;",
                "d) deve ter assinatura e corpo quando aparecer em uma interface Java e deve ser público;",
                2);
        addQuestion(q11);

        Questao q12 = new Questao("Em OO, o símbolo (#) representa qual visibilidade de um atributo:",
                "a) pacote;",
                "b) protegido;",
                "c) privado;",
                "d) público;",
                2);
        addQuestion(q12);

        Questao q13 = new Questao("Em OO, o símbolo (+) representa qual visibilidade de um atributo:",
                "a) pacote;",
                "b) protegido;",
                "c) privado;",
                "d) público;",
                4);
        addQuestion(q13);

        Questao q14 = new Questao("Em OO, o símbolo (-) representa qual visibilidade de um atributo:",
                "a) pacote;",
                "b) protegido;",
                "c) privado;",
                "d) público;",
                3);
        addQuestion(q14);

        Questao q15 = new Questao("Correspondem a vantagens do uso dos conceitos de herança, EXCETO:",
                "a) Permitir a reutilização de código escrito e já testado, economizando tempo e esforço;",
                "b) Organizar classes de acordo com a herança;",
                "c) Forçar subclasses a herdar todo o código da superclasse;",
                "d) Evitar duplicação de código;",
                3);
        addQuestion(q15);

        Questao q16 = new Questao("Acerca de orientação a objetos, assinale a opção correta:",
                "a) Membros de dados podem ser acessados diretamente, mas somente podem ser alterados por meio de métodos específicos;",
                "b) O polimorfismo caracteriza-se pela possibilidade de vários métodos terem o mesmo nome, porém com assinaturas diferentes;",
                "c) Os desenvolvedores de um sistema devem ter como objetivo a construção de classes com baixa coesão e alto acoplamento;",
                "d) A abstração caracteriza-se pela possibilidade de vários métodos terem o mesmo nome, porém com assinaturas diferentes;",
                1);
        addQuestion(q16);

        Questao q17 = new Questao("Na programação orientada a objetos, o relacionamento do tipo herança entre classes traz alguns benefícios dos quais se destacam:",
                "a) A subclasse recebe todos os objetos da classe pai;",
                "b) A superclasse melhora seu desempenho na execução de operações;",
                "c) Reuso de programa ou partes do modelo, definição consistente de definição de interfaces e traz suporte ao desenvolvimento incremental;",
                "d) A superclasse recebe da subclasse um conjunto de operações já implementadas;",
                3);
        addQuestion(q17);

        Questao q18 = new Questao("Quanto aos tipos de relacionamentos do paradigma orientado a objetos, a:",
                "a) generalização permite que os objetos da classe-filha possam ser utilizados em qualquer local em que a classe-mãe ocorra e vice-versa;",
                "b) especialização define uma relação entre itens gerais, chamados classes-filha, e itens específicos, chamados classes-mãe, dos itens gerais;",
                "c) associação especifica que objetos de um item estão conectados a objetos de outro item;",
                "d) dependência determina que um item utiliza as informações e os serviços de outro item e vice-versa;",
                3);
        addQuestion(q18);

        Questao q19 = new Questao("Na programação Orientada a Objetos:",
                "a) as Classes definem o comportamento dinâmico de uma instância;",
                "b) a união de todos os objetos de uma classe forma seu método construtor;",
                "c) as Classes definem os serviços que podem ser solicitados a um construtor;",
                "d) as Classes são tipos de objetos que descrevem as informações armazenadas e os serviços providos por um objeto;",
                4);
        addQuestion(q19);

        Questao q20 = new Questao("As alternativas a seguir apresentam opções que podem ser feitas com uma classe abstrata em Java, à exceção de uma. Assinale-a.",
                "a) Definir variáveis de classe (estáticas);",
                "b) Herdar de outra classe abstrata;",
                "c) Herdar de uma classe concreta (não abstrata).;",
                "d) Instanciar objetos da classe;",
                4);
        addQuestion(q20);

        Questao q21 = new Questao("Polimorfismo é um conceito usado em programação orientada a objetos, e envolve a seleção dinâmica baseada:",
                "a) no objeto referenciado em vez do tipo da referência ao objeto, quando há a sobrescrita (overriding) de métodos;",
                "b) no objeto referenciado em vez do tipo da referência ao objeto, quando há a sobrecarga (overloading) de métodos;",
                "c) no tipo da referência ao objeto em vez do objeto referenciado, quando há a sobrescrita (overriding) de métodos;",
                "d) no tipo da referência ao objeto em vez do objeto referenciado, quando há a sobrecarga (overloading) de métodos;",
                1);
        addQuestion(q21);

        Questao q22 = new Questao("Sobre Orientação a Objetos, analise as seguintes afirmações:\n" +
                "I. Uma classe abstrata só possui métodos abstratos.\n" +
                "II. Uma interface não contém métodos implementados.\n" +
                "III. Uma classe abstrata não pode ser instanciada, logo ela não pode ter um construtor.\n" +
                "IV. Uma interface pode ser utilizada como um tipo de dado.\n" +
                "É correto o que se afirmar somente em:",
                "a) IV",
                "b) II, III e IV",
                "c) I e III",
                "d) I e II",
                2);
        addQuestion(q22);

        Questao q23 = new Questao("No contexto da orientação a objetos, ___________ é um conceito que encapsula dados e abstrações procedurais necessárias para descrever o conteúdo e comportamento de alguma entidade do mundo real.\n" +
                "A alternativa que contém o termo que completa corretamente a lacuna do texto acima é:",
                "a) Herança;",
                "b) Polimorfismo;",
                "c) Classe;",
                "d) Método;",
                3);
        addQuestion(q23);

        Questao q24 = new Questao("__________ é uma característica que reduz bastante o esforço necessário para ampliar o projeto de um sistema orientado a objetos, permitindo que várias operações diferentes tenham o mesmo nome.\n" +
                "Assinale a alternativa que preenche corretamente a lacuna do texto acima:",
                "a) Encapsulamento;",
                "b) Agregação;",
                "c) Acoplamento;",
                "d) Polimorfismo;",
                4);
        addQuestion(q24);

        Questao q25 = new Questao("Em relação ao paradigma orientado a objetos, é CORRETO afirmar que:",
                "a) um objeto consiste em um conjunto de operações encapsuladas e um estado que grava e recupera os efeitos dessas operações;",
                "b) mensagens são requisições enviadas de um atributo para outro, para que o objeto receptor forneça algum resultado por meio da execução de uma operação;",
                "c) classe define as características de um conjunto de atributos que podem herdar dados de outras classes;",
                "d) polimorfismo permite que mensagens sejam propagadas somente utilizando um único método para diferentes classes;",
                1);
        addQuestion(q25);
    }

    private void addQuestion(Questao question){
        ContentValues contentValues = new ContentValues();
        contentValues.put(QuestionsTable.COLUMN_QUESTION, question.getQuestao());
        contentValues.put(QuestionsTable.COLUMN_ALTERNATIVE1, question.getAlternativaA());
        contentValues.put(QuestionsTable.COLUMN_ALTERNATIVE2, question.getAlternativaB());
        contentValues.put(QuestionsTable.COLUMN_ALTERNATIVE3, question.getAlternativaC());
        contentValues.put(QuestionsTable.COLUMN_ALTERNATIVE4, question.getAlternativaD());
        contentValues.put(QuestionsTable.COLUMN_ANSWER_NUM, question.getRespostaCorreta());
        db.insert(QuestionsTable.TABLE_NAME, null, contentValues);
    }

    public List<Questao> getAllQuestions(){
        List<Questao> questaoList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if(cursor.moveToFirst()){
            do{
                Questao questao = new Questao();
                questao.setQuestao(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                questao.setAlternativaA(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_ALTERNATIVE1)));
                questao.setAlternativaB(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_ALTERNATIVE2)));
                questao.setAlternativaC(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_ALTERNATIVE3)));
                questao.setAlternativaD(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_ALTERNATIVE4)));
                questao.setRespostaCorreta(cursor.getInt(cursor.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NUM)));
                questaoList.add(questao);
            } while(cursor.moveToNext());
        }

        cursor.close();
        return questaoList;
    }
}
