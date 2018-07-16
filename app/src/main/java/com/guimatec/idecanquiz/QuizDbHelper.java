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
    private static final int DATABASE_VERSION = 8;

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


        Question q21  = new Question("Uma pesquisa interna feita em uma clínica terapêutica mostra que 80% dos pacientes são mulheres e apenas 20% são homens. A pesquisa também constatou que 60% das pacientes mulheres são dependentes de drogas. Do total de pacientes da clínica terapêutica, 60% são dependentes de drogas. O percentual do total de pacientes do sexo masculino que são dependentes de drogas é", "12%.", "18%.", "48%.", "52%.",1,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q21 );

        Question q22  = new Question("Dois tanques para piscicultura foram construídos com o mesmo comprimento, a mesma profundidade e larguras diferentes. O tanque A tem 10 m de largura e comporta 40 m3 de água. O tanque B tem 150 dm de largura. Um piscicultor pretende criar no tanque B peixes da espécie Neons Cardinalis e, segundo um especialista, para um cardume de 15 Neons Cardinalis é necessário um volume de água de aproximadamente 112,5 litros. Seguindo a risca as  orientações do especialista, a quantidade de peixes que o piscicultor colocará no tanque B será de, aproximadamente", "80.", "800.", "8.000.", "80.000.",3,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q22 );

        Question q23  = new Question("Em uma palestra motivacional o público inicial às 09h00min horas da manhã era de 704 pessoas, sendo 448 homens e 256 mulheres. Como o palestrante não estava atraindo a atenção do público, as pessoas foram saindo ininterruptamente. Se a cada 9 minutos metade dos homens presentes iam embora, e a cada 15 minutos a quarta parte das mulheres presentes saíam, quantos minutos após o início da palestra o público presente era de 18 pessoas?", "27 minutos.", "30 minutos.", "45 minutos.", "54 minutos.",3,  Question.DIFFICULTY_MEDIUM);
                addQuestion(q23 );

        Question q24  = new Question("Um pai deixou para seus três filhos uma herança que será dividida de forma diretamente proporcional às idades dos herdeiros. Danilo tem 35 anos e recebeu R$ 525.000,00, João tem 32 anos e Davi tem 23 anos. O valor que o pai deixou de herança é:", "R$ 1.250.000,00.", "R$ 1.300.000,00.", "R$ 1.350.000,00.", "R$ 1.400.000,00.",3,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q24 );



        Question q25  = new Question("Um bombeiro hidráulico cobra R$ 32,00 para visitar uma residência, e mais R$ 3,50 por cada meia hora gasta para realizar o serviço solicitado. Ao visitar uma residência, este bombeiro hidráulico recebeu uma quantia de R$ 49,50 pelos serviços prestados. Então é correto concluir que o tempo que ele gastou, em minutos, é um número compreendido entre", "10 e 50.", "51 e 100.", "101 e 130.", "131 e 180.",4,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q25 );

        Question q26  = new Question("Em um teatro a lotação máxima é de 360 pessoas. Em uma apresentação em que o número de pessoas na plateia correspondia a 70% da lotação máxima foram arrecadados um total de R$ 4.032,00 com ingressos. Logo, é correto afirmar que o valor do ingresso é de", "R$ 8,00.", "R$ 11,00.", "R$ 14,00.", "R$ 16,00.",4,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q26 );

        Question q27  = new Question("O selo de garantia de uma marca de relógio é um holograma em forma de pentágono regular com suas diagonais. Se o logotipo fosse trocado por um hexágono regular, o número de diagonais aumentaria em", "2.", "3.", "4.", "5.",1,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q27 );

        Question q28  = new Question("Considere a sequência de pares de vogais distintas a seguir: AE; AI; AO; AU; EA; EI; EO; EU; IA; .....; UO O número de pares dessa sequência é igual a", "15.", "16.", "20.", "24.",4,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q28 );

        Question q29  = new Question("Numa biblioteca encontram-se 23 estantes totalizando 5.405 livros. Se todas as estantes têm a mesma quantidade de livros, então quantos livros estão guardados em 7 dessas estantes?", "1.225.", "1.475.", "1.645.", "1.725.",4,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q29 );

        Question q30  = new Question("Numa videolocadora, os filmes de ação apresentam as seguintes numerações: 5; 10, 15, 20, ..., 2.295. Sendo assim, quantos filmes de ação essa locadora precisa adquirir para completar 500 filmes desse gênero?", "39.", "41.", "49.", "51.",2,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q30 );

        Question q31  = new Question("Sejam os intervalos de tempo a seguir: I = 0,12 hora; II = 7 minutos e 12 segundos; III = 7,2 minutos; IV = 0,005 dia; e, V = 432 segundos. ", "2.", "3.", "4.", "Todos",4,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q31 );



        Question q32  = new Question("Uma reta intercepta os eixos cartesianos nos pontos (0, 6) e (a, 0). Se a reta passa pelo ponto (1, 3), então o valor de *a* é:", "-1", "-3", "1", "3",2,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q32 );

        Question q33  = new Question("Um estrangeiro, ao visitar o Brasil, selecionou 10 capitais das quais pretende visitar no mínimo 5 e no máximo 8. De quantas maneiras ele poderá fazer a escolha das capitais que irá visitar?", "615", "627", "720", "745",2,  Question.DIFFICULTY_MEDIUM);
                addQuestion(q33 );

        Question q34  = new Question("Um produto foi colocado em liquidação em um supermercado e verificou-se que a cada 45 minutos foram vendidos três oitavos da quantidade disponível para a venda. Em quanto tempo o produto se esgotou?", "2 horas.", "1 hora e 50 minutos.", "2 horas e 10 minutos.", "2 horas e 25 minutos.",1,  Question.DIFFICULTY_MEDIUM);
                addQuestion(q34 );

        Question q35  = new Question("A sequência a seguir é uma progressão aritmética: 7, __, __, __,__,__, __, __, 111 O produto entre o quinto e o sexto termo dessa progressão é igual a:", "4.248.", "4.356.", "5.462.", "5.674.",1,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q35 );


        Question q36  = new Question("Os três primeiros termos de uma sequência numérica formam uma progressão geométrica crescente de razão 3 e os 3 últimos termos formam uma progressão aritmética decrescente de razão –4. Se a sequência é composta por cinco termos sendo o último deles 118, então a soma dos algarismos do primeiro termo é:", "4", "5", "6", "7",2,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q36 );

        Question q37  = new Question("Uma pizzaria vendeu em um dia trinta pizzas entre doces e salgadas e arrecadou R$ 855,00. Se o preço de cada pizza doce é R$ 25,00 e de cada pizza salgada é R$ 30,00, então a diferença entre o número de pizzas doces e salgadas vendidas no dia em questão foi igual a:", "10", "12", "13", "15",2,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q37 );

        Question q38  = new Question("Cláudia faz doces de abóbora, coco e abóbora com coco, e os vende em caixas. Considere que em cada caixa 2/3 dos doces têm coco e 5/9 têm abóbora. Qual a fração dos doces da caixa que corresponde aos doces de abóbora com coco?", "1/3", "1/6", "1/9", "2/9",4,  Question.DIFFICULTY_MEDIUM);
                addQuestion(q38 );

        Question q39  = new Question("Dois cubos têm áreas, respectivamente, iguais a 216 cm2 e 54 cm2. A razão entre o volume do cubo maior e o volume do cubo menor é igual a:", "4", "6", "8", "9",3,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q39 );

        Question q40  = new Question("Observe a sequência numérica a seguir. 10, 12, 24, 22,11, 13, 26, 24, 12, 14, 28, 26, 13, ... A soma dos próximos quatro termos dessa sequência é igual a:", "81", "87", "91", "97",2,  Question.DIFFICULTY_MEDIUM);
        addQuestion(q40 );




        //Informática
        Question q41  = new Question("Tão importante quanto o ato de criar ou editar uma apresentação de slides é o ato de gerenciar a execução da apresentação, isto é, exibi-la ao público-alvo. Assinale a alternativa que NÃO relaciona corretamente o comando de gerenciamento de apresentações à sua função no PowerPoint 2013.Tão importante quanto o ato de criar ou editar uma apresentação de slides é o ato de gerenciar a execução da apresentação, isto é, exibi-la ao público-alvo. Assinale a alternativa que NÃO relaciona corretamente o comando de gerenciamento de apresentações à sua função no PowerPoint 2013.", "CTRL + M: mostrar ou ocultar marcação à tinta.", "CTRL + M: mostrar ou ocultar marcação à tinta.", "CTRL + C: alternar o ponteiro do mouse para caneta.", "CTRL + B: alternar o ponteiro do mouse para borracha.",4,  Question.DIFFICULTY_HARD);
        addQuestion(q41 );

        Question q42  = new Question("No Sistema Operacional Windows 10, é possível acessar um aplicativo a partir da janela do programa Executar, digitando no campo “Abrir” o nome do arquivo executável do aplicativo que se quer utilizar. A desvantagem desse procedimento é que nem sempre o nome do arquivo executável do aplicativo é igual ao próprio nome no aplicativo. Por exemplo, no Pacote Office 2013, existe o aplicativo conhecido como “PowerPoint”, porém, o nome de seu arquivo executável é “powerpnt”. Qual das alternativas a seguir corresponde corretamente um aplicativo ao respectivo nome de seu arquivo executável?", "Paint: paintbrush.", "Internet Explorer: iexplor.", "Microsoft Office Excel: winexcel.", "Microsoft Office Word: winword.",4,  Question.DIFFICULTY_HARD);
        addQuestion(q42 );

        Question q43  = new Question("No navegador Internet Explorer 9 (Configuração Padrão – Idioma Português Brasil), as teclas de atalho para atualizar a página atual e abrir os favoritos são, respectivamente:", "F5 e Ctrl+I", "F6 e Ctrl+F", "F7 e Ctrl+N", "F8 e Ctrl+W",1,  Question.DIFFICULTY_HARD);
        addQuestion(q43 );

        Question q44  = new Question("Na ferramenta Microsoft Office Word 2003 (configuração padrão), a caixa de seleção Times New Roman é utilizada para:", "Alterar a fonte.", "Alterar a cor da fonte.", "Alterar o tamanho da fonte.", "Alterar o alinhamento da fonte.",1,  Question.DIFFICULTY_HARD);
        addQuestion(q44 );

        Question q45  = new Question("O navegador Internet Explorer 11 (configuração padrão) grava durante a navegação na internet, um registro com todos os sites acessados separados por data e hora. As informações armazenadas ficam disponíveis no:", "Histórico.", "Download.", "Complemento.", "Gerenciador de Favoritos.",1,  Question.DIFFICULTY_HARD);
        addQuestion(q45 );

        Question q46  = new Question("No aplicativo Microsoft Office Excel 2003 (configuração padrão), a função que retorna a raiz quadrada de um determinado número é:", "RAIZ.", "SQRT.", "RQUAD.", "QUADRADA.",1,  Question.DIFFICULTY_HARD);
        addQuestion(q46 );







        Question q47  = new Question("Sobre componentes de um computador, analise as afirmativas a seguir. I. É um dispositivo utilizado para armazenar dados de forma permanente. II. É um dispositivo utilizado para armazenar dados de forma temporária. É correto afirmar que as definições anteriores se referem, respectivamente, aos dispositivos:", "Placa de Vídeo e Placa Mãe.", "Disco rígido e memória RAM.", "Processador e memória ROM.", "Memória RAM e memória Flash.",2,  Question.DIFFICULTY_HARD);
        addQuestion(q47 );

        Question q48  = new Question("Um usuário utiliza o Sistema Operacional Microsoft Windows 8.1 (configuração padrão) para realizar as suas atividades diárias.” O procedimento para ocultar todos os ícones da área de trabalho do computador é clicar com o botão direito em uma área em branco da área de trabalho, apontar o cursor do mouse para", "Exibir e, em seguida, marcar a opção Ocultar ícones da área de trabalho.", "Exibir e, em seguida, marcar a opção Ocultar ícones da área de trabalho.Exibir e, em seguida, marcar a opção Ocultar ícones da área de trabalho.", "Configurações e, em seguida, marcar a opção Esconder ícones da área de trabalho.", "Configurações e, em seguida, desmarcar a opção Mostrar ícones da área de trabalho.",2,  Question.DIFFICULTY_HARD);
        addQuestion(q48 );

        Question q49  = new Question("Utilizando o prompt de comando MS-DOS de um computador, o usuário digitou o comando TREE.” Pode-se afirmar que com a execução deste comando", "todos os dados do prompt de comando foram limpados.", "a integridade e as especificações do disco foram todas verificadas.", "a árvore de diretórios foi exibida graficamente a partir do diretório raiz.", "o diretório corrente foi alterado a partir da pasta corrente com o nome especificado.",3,  Question.DIFFICULTY_HARD);
        addQuestion(q49 );

        Question q50  = new Question("Analise as afirmativas sobre a ferramenta Microsoft Office Word 2007 (configuração padrão). I. O recurso “Formatar Pincel” copia a formatação de um local para ser aplicada em outro. II. O alinhamento “Justificado” alinha o texto à esquerda e as imagens ao centro. III. O recurso “Hifenização” controla a quebra de páginas e seções.", "I.", "II.", "III.", "I e III.",1,  Question.DIFFICULTY_HARD);
                addQuestion(q50 );






        Question q51  = new Question("Sobre itens de hardware, analise as afirmativas a seguir. I. O monitor de vídeo é considerado um dispositivo de entrada pela característica de exibir os resultados processados pelo computador. II. Pratos, braços dinâmicos e transponders são partes internas de um disco rígido. III.O processador é o componente de hardware responsável por processar dados e transformar em informações.", "I.", "II.", "III", "II e III",3,  Question.DIFFICULTY_HARD);
                addQuestion(q51 );

        Question q52  = new Question("Utilizando um computador com o Sistema Operacional Windows 7 (configuração padrão), um usuário pressionou uma tecla em seu teclado que capturou a imagem da tela atual a qual estava utilizando. É correto afirmar que trata‐se da tecla:", "Num Lock.", "Save View.", "Scroll Lock.", "Print Screen.",4,  Question.DIFFICULTY_HARD);
        addQuestion(q52 );

        Question q53  = new Question("No Sistema Operacional Microsoft Windows 7 (configuração padrão), o procedimento para criar uma nova pasta na área de trabalho do computador é clicar com o botão", "direito do mouse, apontar para Novo e clicar em Pasta.", "direito do mouse, apontar para Opções e clicar em Criar Pasta.", "esquerdo do mouse, apontar para Novo e clicar em Nova pasta.", "esquerdo do mouse, apontar para Opções e clicar em Novo Diretório.",1,  Question.DIFFICULTY_HARD);
        addQuestion(q53 );







        Question q54  = new Question("No painel de controle do Sistema Operacional Microsoft Windows 7 (configuração padrão), as opções que têm a função de impedir que hackers ou programas mal-intencionados obtenham acesso ao computador e realizar alterações na conta do usuário são, respectivamente:", "Windows Update e Sistema.", "Firewall do Windows e Contas de usuário.", "Central de ações e Gerenciador de credenciais.", "Ferramentas administrativas e Central de Rede.",2,  Question.DIFFICULTY_HARD);
        addQuestion(q54 );

        Question q55  = new Question("Na ferramenta Microsoft Office Excel 2007 (configuração padrão), o procedimento para ocultar as linhas de células em uma planilha é: clicar na guia", "Exibir, no grupo Estilo marcar a caixa de seleção Ocultar Linhas.", "Página Inicial, no grupo Estilo marcar a caixa de seleção Ocultar Linhas.", "Exibir, no grupo Mostrar/Ocultar desmarcar a caixa de seleção Linhas de Grade.", "Revisão, no grupo Configurações de Planilha desmarcar a caixa de seleção Linhas de Grade.",3,  Question.DIFFICULTY_HARD);
        addQuestion(q55 );

        Question q56  = new Question("Um usuário que utilizou a ferramenta BrOffice Writer para realizar a digitação do seu trabalho de conclusão de curso, após concluir a digitação, verificou que existiam diversas palavras erradas em seu texto que necessitavam ser corrigidas. O procedimento que executado para acionar o corretor ortográfico da ferramenta em questão é: clicar no menu", "Formatar e clicar na opção corretor ortográfico.", "Formatar e clicar na opção Verificação ortográfica.", "Ferramentas e clicar na opção Verificação ortográfica.", "Editar, apontar para Opções e clicar na opção corretor ortográfico.",3,  Question.DIFFICULTY_HARD);
        addQuestion(q56 );

        Question q57  = new Question("Na ferramenta Microsoft Office Outlook 2007 (configuração padrão – idioma português Brasil), o procedimento para iniciar um envio/recebimento para a pasta atual, recuperando itens completos (cabeçalho, item e quaisquer anexos), é pressionar a(s) tecla(s)", "F7.", "F8.", "F10.", "Shift + F9.",4,  Question.DIFFICULTY_HARD);
                addQuestion(q57 );

        Question q58  = new Question("Sistemas Operacionais Linux são programas responsáveis por promover o funcionamento do computador, realizando a comunicação entre os dispositivos de hardware e softwares. Em relação a este sistema, é correto afirmar que KDE e GNOME são", "versões de Kernel.", "distribuições Linux.", "ambientes gráficos.", "editores de texto Linux.",3,  Question.DIFFICULTY_HARD);
                addQuestion(q58 );

        Question q59  = new Question("Um usuário de uma empresa de contabilidade utiliza no seu cotidiano a ferramenta Microsoft Office Excel 2007 para manipular as planilhas eletrônicas que possuem as informações dos clientes. Após a criação de uma nova política de utilização de softwares na empresa, as ferramentas do pacote Office foram substituídas pelas ferramentas do pacote BrOffice. Para continuar manipulando as planilhas, o usuário deverá utilizar a ferramenta", "Base.", "Calc.", "Match.", "Writer.",2,  Question.DIFFICULTY_HARD);
                addQuestion(q59);

        Question q60  = new Question("Utilizando o navegador Internet Explorer 8 (configuração padrão – idioma português Brasil), o procedimento que pode ser utilizado para que um usuário possa abrir uma nova janela para realizar a navegação é pressionar as teclas:", "Ctrl + J.", "Ctrl + F.", "Ctrl + H.", "Ctrl + N.",4,  Question.DIFFICULTY_HARD);
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