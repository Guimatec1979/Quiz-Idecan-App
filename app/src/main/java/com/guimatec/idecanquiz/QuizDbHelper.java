package com.guimatec.idecanquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.guimatec.idecanquiz.QuizContract.*;

import java.util.ArrayList;


public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyAwesomeQuiz.db";
    private static final int DATABASE_VERSION = 6;

    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER, " +
                QuestionsTable.COLUMN_DIFFICULTY + " TEXT" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {

        //Português
        Question q1 = new Question("Assinale a alternativa cujo conteúdo apresenta uso indevido do acento grave, indicador de crase na língua portuguesa."," Deixada à própria sorte, a metade ocidental durou pouco", "“... não seria nenhum absurdo que alguns costumes alimentares cristãos, como comer peixe às sextas-feiras, tivessem a força de lei, ...", "“... não seria nenhum absurdo que costumes alimentares cristãos tivessem a força de lei com penas severas àquele que degustasse uma costelinha no dia sagrado.", "... assim seria o Velho Mundo se o Império Romano não tivesse se desintegrado: uma única nação contornando o Mediterrâneo à caminho das costas europeia, asiática e africana”.",4, Question.DIFFICULTY_EASY);
        addQuestion(q1);

        Question q2 = new Question("Releia o trecho a seguir: “Nessa barafunda de problemas, tentou-se de tudo, até a divisão administrativa do império em dois, o do Ocidente (com sede em Roma) e o do Oriente (o Império Bizantino), com sede em Constantinopla (onde antes ficava Bizâncio).”Assinale a alternativa cujo conteúdo substituiria com maior precisão o termo destacado."," Discrição.", "Miscelânea", "Austeridade", "Compostura",2, Question.DIFFICULTY_EASY);
        addQuestion(q2);

        Question q3 = new Question("De acordo com a classe de palavras, assinale a relação INCORRETA.", "Essa (soma) de fatores faz com que as crianças cheguem muito tarde.”  – pronome.", "Já o segundo (câncer) mais frequente na infância é o tumor cerebral.”  – substantivo.", "“A medicina ainda não possui uma resposta do porquê desse câncer ser o mais (comum),...”  – conjunção."," Na verdade, se não (fosse) a demora que muitas vezes o paciente enfrenta até chegar à unidade de excelência, em alguns tipos de tumores o índice de cura poderia atingir 90%.  – verbo.", 3, Question.DIFFICULTY_EASY);
        addQuestion(q3);

        Question q4 = new Question("Em “Já o segundo câncer mais frequente na infância é o tumor cerebral.”  o termo destacado significa", "afetado.", "habitual.", "primitivo."," desequilibrado.", 2, Question.DIFFICULTY_EASY);
        addQuestion(q4);

        Question q5 = new Question("No trecho “A leucemia corresponde à maioria dos casos, e essa (prevalência) é mundial.”  a expressão destacada pode ser substituída, sem alteração de sentido, por", "análise.", "indicação.", "investigação."," predominância.", 4, Question.DIFFICULTY_EASY);
        addQuestion(q5);

        Question q6 = new Question("Das palavras transcritas do texto, assinale a única que apresenta dígrafo.", "Cura.", "Chance.", "Crianças."," Quimioterapia.", 3, Question.DIFFICULTY_EASY);
        addQuestion(q6);

        Question q7  = new Question("Em “Essa soma de fatores faz com que as crianças cheguem muito tarde.”  o ponto final ( . ) tem como objetivo", "realçar uma palavra.", "finalizar frase declarativa.", "fazer um questionamento.", "marcar pausa de curta duração.",2,  Question.DIFFICULTY_EASY);
        addQuestion(q7);

        Question q8  = new Question("“O que já se sabe, contudo, é que a microcefalia pode ser mais ou menos grave.”  O termo sublinhado trata-se de uma conjunção que pode ser substituída, corretamente, de acordo com o contexto, por:", "Assim.", "Porém.", "Portanto.", "Porquanto.",2,  Question.DIFFICULTY_EASY);
        addQuestion(q8 );

        Question q9  = new Question("“O Estado, até (agora), não conseguiu coletar os dados e apresentar soluções eficazes e responsáveis (sobre) a discussão do zika.”  Neste contexto empregado, os termos sublinhados são classificados, respectivamente, de acordo com a classe de palavras, como:", "Advérbio, conjunção e advérbio.", "Conjunção, conjunção e advérbio.", "Conjunção, preposição e advérbio.", "Advérbio, conjunção e preposição.",4,  Question.DIFFICULTY_EASY);
        addQuestion(q9 );

        Question q10 = new Question("“O que a Colômbia e García Márquez ensinam, no entanto, é que beleza e bondade podem se sobrepor à dor nos momentos mais difíceis.”  De acordo com o contexto, assinale a alternativa que substitui corretamente a expressão “no entanto”.", "Enfim.", "Todavia.", "Portanto.", "Porquanto.",2,  Question.DIFFICULTY_EASY);
        addQuestion(q10 );

        Question q11  = new Question("Dentre as frases apresentadas a seguir, só NÃO apresenta o correto uso do acento grave, indicador de crase na Língua Portuguesa:", "A prova deve ser feita à caneta", "Referia-se à mãe de sua amada esposa", "Preferia a roupa mais quente à mais fresca", "Queria muito agradecer àquele homem que lhe salvara a vida",1,  Question.DIFFICULTY_EASY);
        addQuestion(q11 );

        Question q12  = new Question("“Se as pessoas ________ um mínimo de sensibilidade neste mundo veloz, ainda _________ possível cultivar por muito tempo a beleza da música clássica.” Assinale a alternativa que completa correta e sequencialmente a afirmativa anterior.", "manter / será", "manter / seria", "manterem / seria", "mantiverem / será",4,  Question.DIFFICULTY_EASY);
        addQuestion(q12 );

        Question q13  = new Question("(Por ora), 356 pessoas que viviam por lá estão hospedadas em hotéis de Mariana.” (4º§) A expressão entre parênteses, de acordo com o contexto, é classificada como:", "Advérbio.", "Conjunção.", "Interjeição.", "Preposição.",1,  Question.DIFFICULTY_EASY);
        addQuestion(q13 );

        Question q14  = new Question("Assinale a alternativa cujo termo em destaque apresenta função sintática DIFERENTE dos demais.", "Perderam a vida (que) levavam", "A lama (que) saiu da barragem da Samarco,..", "As casas (que) não foram levadas viraram escombros", "Por ora, 356 pessoas (que) viviam por lá estão hospedadas em hotéis de Mariana",1,  Question.DIFFICULTY_EASY);
        addQuestion(q14 );

        Question q15  = new Question("Assinale a alternativa cujo tempo verbal se DIFERENCIA dos demais.", "A lama (varreu) de vez o distrito,...", "As casas que não foram levadas viraram escombros.", "...poucas casas e um ginásio (permaneceram) quase intactos..", "pessoas que viviam por lá estão hospedadas em hotéis de Mariana",4,  Question.DIFFICULTY_EASY);
        addQuestion(q15 );

        Question q16  = new Question("Em (Toda a história da cidade está ligada à mineração.), o acento grave indicador de crase está corretamente empregado. Assinale a alternativa em que o referido acento está INCORRETAMENTE empregado.", "Quanto à Samarco, a sua penalidade não está definida.", "A tragédia em Mariana provocou danos irreparáveis às vítimas", "À medida que a lama avança em direção ao mar, muitos peixes morrem.", "Vários repórteres que foram à Mariana e entrevistaram a população atingida.",4,  Question.DIFFICULTY_EASY);
                addQuestion(q16 );

        Question q17 = new Question("No trecho (Adolescentes são expostos anualmente a mais de 3 mil referências a bebidas enquanto ouvem canções pop.), o ponto final ( . ) foi utilizado para", "finalizar frase declarativa.", "expressar espanto, surpresa.", "marcar pausa de menor duração.", "interromper o pensamento do leitor.",1,  Question.DIFFICULTY_EASY);
        addQuestion(q17 );

        Question q18  = new Question("São palavras transcritas do texto que apresentam dígrafo, EXCETO:", "Vinho.", "Associado.", "Excessivo.", "Embriagam.",4,  Question.DIFFICULTY_EASY);
        addQuestion(q18 );

        Question q19  = new Question("Assinale a alternativa em que todas as palavras são acentuadas pelo mesmo motivo.", "é / saúde / está.", "mês / método / já.", "músicas / públicas / crítico.", "referências / também / álcool.",3,  Question.DIFFICULTY_EASY);
        addQuestion(q19 );

        Question q20  = new Question("Na frase (Meu médico disse que devo me afastar da bebida!), a palavra destacada expressa ideia de", "posse.", "dúvida.", "indicação.", "afirmação.",1,  Question.DIFFICULTY_EASY);
        addQuestion(q20 );



        //Matemática
        Question q21  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q21 );

        Question q22  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q22 );

        Question q23  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q23 );

        Question q24  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q24 );

        Question q25  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q25 );

        Question q26  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q26 );

        Question q27  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q27 );

        Question q28  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q28 );

        Question q29  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q29 );

        Question q30  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q30 );

        Question q31  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q31 );

        Question q32  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q32 );

        Question q33  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q33 );

        Question q34  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q34 );

        Question q35  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q35 );

        Question q36  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q36 );

        Question q37  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q37 );

        Question q38  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q38 );

        Question q39  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q39 );

        Question q40  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q40 );



        //Informática
        Question q41  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_HARD);
        addQuestion(q41 );

        Question q42  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_HARD);
        addQuestion(q42 );

        Question q43  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_HARD);
        addQuestion(q43 );

        Question q44  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_HARD);
        addQuestion(q44 );

        Question q45  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_HARD);
        addQuestion(q45 );

        Question q46  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_HARD);
        addQuestion(q46 );

        Question q47  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_HARD);
        addQuestion(q47 );

        Question q48  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_HARD);
        addQuestion(q48 );

        Question q49  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_HARD);
        addQuestion(q49 );

        Question q50  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_HARD);
        addQuestion(q50 );

        Question q51  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_HARD);
        addQuestion(q51 );

        Question q52  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_HARD);
        addQuestion(q52 );

        Question q53  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_HARD);
        addQuestion(q53 );

        Question q54  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_HARD);
        addQuestion(q54 );

        Question q55  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_HARD);
        addQuestion(q55 );

        Question q56  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_HARD);
        addQuestion(q56 );

        Question q57  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_HARD);
        addQuestion(q57 );

        Question q58  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_HARD);
        addQuestion(q58 );

        Question q59  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_HARD);
        addQuestion(q59);

        Question q60  = new Question("Easy: A is correct", "A", "B", "C", "D",1,  Question.DIFFICULTY_HARD);
        addQuestion(q60 );




    }



    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuestionsTable.COLUMN_DIFFICULTY, question.getDifficulty());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    public ArrayList<Question> getQuestions(String difficulty) {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();

        String[] selectionArgs = new String[]{difficulty};
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME +
                " WHERE " + QuestionsTable.COLUMN_DIFFICULTY + " = ?", selectionArgs);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
}