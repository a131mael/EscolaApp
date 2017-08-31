package acf.com.br.provasufsc;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import org.provasUfsc.aaf.model.Question;
import org.provasUfsc.aaf.model.QuestionsService;
import org.provasUfsc.aaf.model.UserService;
import org.provasUfsc.aaf.model.UsuarioDTO;
import org.provasUfsc.aaf.model.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import uk.co.senab.photoview.PhotoViewAttacher;

public class PerguntaScrollingActivity extends AppCompatActivity {

    private Question question;
    private Map<Integer,Map<String, List>> questions2 = null;
    private TextView txtContadorPergunta;
    private List<Question> questions = new ArrayList<>();
    private TextView txtPergunta;
    private TextView txtPerguntaUnder;
    private CheckBox checkBox;
    private CheckBox txtOpcao2;
    private CheckBox txtOpcao4;
    private CheckBox txtOpcao8;
    private CheckBox txtOpcao16;
    private CheckBox txtOpcao32;
    private ImageView imgViewer;
    private ImageView imgViewerUnder;
    private PhotoViewAttacher mAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta_scrolling);

        txtPergunta = (TextView) findViewById(R.id.txtPergunta);
        txtPerguntaUnder = (TextView) findViewById(R.id.txtPerguntaUnder);
        checkBox = (CheckBox) findViewById(R.id.checkBox1);
        txtOpcao2 = (CheckBox) findViewById(R.id.checkBox2);
        txtOpcao4 = (CheckBox) findViewById(R.id.checkBox4);
        txtOpcao8 = (CheckBox) findViewById(R.id.checkBox8);
        txtOpcao16 = (CheckBox) findViewById(R.id.checkBox16);
        txtOpcao32 = (CheckBox) findViewById(R.id.checkBox32);
        imgViewer = (ImageView) findViewById(R.id.imageView);
        imgViewerUnder = (ImageView) findViewById(R.id.imageViewUnder);
        txtContadorPergunta = (TextView) findViewById(R.id.txtContadorPergunta);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(ClassesStaticas.anoSelecionado + ", " + ClassesStaticas.disciplinaSelecionada);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pintarQuestoesCorretas();
            }
        });

        FloatingActionButton btFinalizar = (FloatingActionButton) findViewById(R.id.btFinalizar);
        btFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishSimulate(null);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        ClassesStaticas.numeroQuestaoSelecionada = 1;
        if(ClassesStaticas.carregarQuestoes){
             if(ClassesStaticas.revisarQuestoes){
                 questions.clear();
                 questions.addAll(ClassesStaticas.questoesErradas) ;
                 ClassesStaticas.questoesErradas.clear();
                 ClassesStaticas.revisarQuestoes = false;
            }else{
                questions = getQuestionsCorreto(ClassesStaticas.disciplinaSelecionada, ClassesStaticas.anoSelecionado);
            }
            montarProximaQuestao();
            zerarContador();
        }
    }

    private void zerarContador(){
        ClassesStaticas.numeroQuestoesRespondidas=0;
        ClassesStaticas.numeroQuestoesRespondidasErroneamente=0;
        ClassesStaticas.numeroQuestoesRespondidasCorretaente = 0;
    }

    private void montarProximaQuestao(){

        txtContadorPergunta.setText(ClassesStaticas.numeroQuestaoSelecionada + "/" + questions.size());
        getNextQuestion(null);

        if(question != null){
            montarImagem(question.getFilePergunta(), imgViewer);
            montarImagem(question.getFilePerguntaUnder(), imgViewerUnder);

        }else{
            imgViewer.setVisibility(View.GONE);
            imgViewerUnder.setVisibility(View.GONE);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        ClassesStaticas.carregarQuestoes = false;
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("QuestaoSelecionada", ClassesStaticas.numeroQuestaoSelecionada);
        savedInstanceState.putSerializable("Questions", (ArrayList<Question>) questions);

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        ClassesStaticas.numeroQuestaoSelecionada = savedInstanceState.getInt("QuestaoSelecionada");

        ClassesStaticas.numeroQuestaoSelecionada --;

        questions = (List<Question>) savedInstanceState.getSerializable("Questions");

        montarProximaQuestao();
    }

    private void popularQuestao(Question question){
        this.question= question;

        /*PERGUNTA*/
        txtPergunta.setText(Html.fromHtml(question.getQuestion())); // interpretaHTML
        txtPergunta.setTextSize(question.getFontSizeQuestion()); ;


        txtPerguntaUnder.setText(Html.fromHtml(question.getQuestionUnder())); // interpretaHTML
        txtPerguntaUnder.setTextSize(question.getFontSizeQuestion()); ;


        /*OPCOES*/
        /*OPCAO1*/
        //TODO verificar html nas opcoes
        checkBox.setText(Html.fromHtml(question.getOpcao1()));
        checkBox.setChecked(false);
        checkBox.setBackgroundColor(Color.TRANSPARENT);
        if(question.getOpcao1().trim().equalsIgnoreCase("")){
            checkBox.setVisibility(View.GONE);
        }else{
            checkBox.setVisibility(View.VISIBLE);
        }

        /*OPCAO2*/
        txtOpcao2.setText(Html.fromHtml(question.getOpcao2()));
        txtOpcao2.setChecked(false);
        txtOpcao2.setBackgroundColor(Color.TRANSPARENT);
        if(question.getOpcao2().trim().equalsIgnoreCase("")){
            txtOpcao2.setVisibility(View.GONE);
        }else{
            txtOpcao2.setVisibility(View.VISIBLE);
        }

        /*OPCAO4*/
        txtOpcao4.setText(Html.fromHtml(question.getOpcao3()));
        txtOpcao4.setChecked(false);
        txtOpcao4.setBackgroundColor(Color.TRANSPARENT);
        if(question.getOpcao3().trim().equalsIgnoreCase("")){
            txtOpcao4.setVisibility(View.GONE);
        }else{
            txtOpcao4.setVisibility(View.VISIBLE);
        }

        /*OPCAO8*/
        txtOpcao8.setText(Html.fromHtml(question.getOpcao4()));
        txtOpcao8.setChecked(false);
        txtOpcao8.setBackgroundColor(Color.TRANSPARENT);
        if(question.getOpcao4().trim().equalsIgnoreCase("")){
            txtOpcao8.setVisibility(View.GONE);
        }else{
            txtOpcao8.setVisibility(View.VISIBLE);
        }

        /*OPCAO16*/
        txtOpcao16.setText(Html.fromHtml(question.getOpcao5()));
        txtOpcao16.setChecked(false);
        txtOpcao16.setBackgroundColor(Color.TRANSPARENT);
        if(question.getOpcao5().trim().equalsIgnoreCase("")){
            txtOpcao16.setVisibility(View.GONE);
        }else{
            txtOpcao16.setVisibility(View.VISIBLE);
        }

        /*OPCAO32*/
        txtOpcao32.setText(Html.fromHtml(question.getOpcao6()));
        txtOpcao32.setChecked(false);
        txtOpcao32.setBackgroundColor(Color.TRANSPARENT);
        if(question.getOpcao6().trim().equalsIgnoreCase("")){
            txtOpcao32.setVisibility(View.GONE);
        }else{
            txtOpcao32.setVisibility(View.VISIBLE);
        }
    }

   private void pintarQuestoesCorretas(){
        if(question.isOpcao1Certa()){
            checkBox.setBackgroundColor(Color.GREEN);
        }
        if(question.isOpcao2Certa()){
            txtOpcao2.setBackgroundColor(Color.GREEN);
        }
        if(question.isOpcao3Certa()){
            txtOpcao4.setBackgroundColor(Color.GREEN);
        }
        if(question.isOpcao4Certa()){
            txtOpcao8.setBackgroundColor(Color.GREEN);
        }
        if(question.isOpcao5Certa()){
            txtOpcao16.setBackgroundColor(Color.GREEN);
        }
        if(question.isOpcao6Certa()){
            txtOpcao32.setBackgroundColor(Color.GREEN);
        }

    }

   private List<Question>getQuestionsCorreto(String discipline, String year){
        QuestionsService questionsService = new QuestionsService();

        List<Question> questions = questionsService.getQuestionsByDiscipline(discipline,year);

        return questions;
    }

   public void getNextQuestion(View v){
        if((ClassesStaticas.numeroQuestaoSelecionada -1) == questions.size()){
            finishSimulate(null);
        }else {
            question = questions.get(ClassesStaticas.numeroQuestaoSelecionada-1);

            /*if(question.isBigQuestion()){
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);

            }else {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED); //remover rotacao
            }*/

            popularQuestao(question);
            montarImagem(question.getFilePergunta(),imgViewer);
            montarImagem(question.getFilePerguntaUnder(),imgViewerUnder);

            txtContadorPergunta.setText(ClassesStaticas.numeroQuestaoSelecionada + "/" + questions.size());

            ClassesStaticas.numeroQuestaoSelecionada ++;
        }

    }

    public void responder(View v){
        boolean isRight =verifyAwnser();
        if(isRight){
            ClassesStaticas.numeroQuestoesRespondidasCorretaente++;

        }else{
            ClassesStaticas.numeroQuestoesRespondidasErroneamente++;
            ClassesStaticas.questoesErradas.add(question);
        }
        sumValue(isRight);
        getNextQuestion(v);


    }

    private void sumValue(boolean isRight){
        switch (question.getDisciplina()){
            case "Portugues":
                if(isRight){
                    ClassesStaticas.acertoPTV++;
                }
                ClassesStaticas.totalPT++;
                break;
            case "Ingles":
                if(isRight){
                    ClassesStaticas.acertoING++;
                }
                ClassesStaticas.totalING++;
                break;

            case "Espanhol":
                if(isRight){
                    ClassesStaticas.acertoESP++;
                }
                ClassesStaticas.totalESP++;
                break;


            case "Matematica":
                if(isRight){
                    ClassesStaticas.acertoMTMV++;
                }
                ClassesStaticas.totalMTM++;
                break;

            case "Fisica":
                if(isRight){
                    ClassesStaticas.acertoFIS++;
                }
                ClassesStaticas.totalFIS++;
                break;


            case "Quimica":
                if(isRight){
                    ClassesStaticas.acertoQMC++;
                }
                ClassesStaticas.totalQMC++;
                break;


            case "Historia":
                if(isRight){
                    ClassesStaticas.acertoHIST++;
                }
                ClassesStaticas.totalHIST++;
                break;


            case "Geografia":
                if(isRight){
                    ClassesStaticas.acertoGEO++;
                }
                ClassesStaticas.totalGEO++;
                break;

            case "Biologia":
                if(isRight){
                    ClassesStaticas.acertoBIO++;
                }
                ClassesStaticas.totalBIO++;
                break;

            default:
               break;
        }
    }

    public boolean verifyAwnser(){
        boolean isOk = true;

        if(question.isOpcao1Certa()!= checkBox.isChecked()){
            isOk = false;
        }
        if(question.isOpcao2Certa()!= txtOpcao2.isChecked()){
            isOk = false;
        }
        if(question.isOpcao3Certa()!= txtOpcao4.isChecked()){
            isOk = false;
        }
        if(question.isOpcao4Certa()!= txtOpcao8.isChecked()){
            isOk = false;
        }
        if(question.isOpcao5Certa()!= txtOpcao16.isChecked()){
            isOk = false;
        }
        if(question.isOpcao6Certa()!= txtOpcao32.isChecked()){
            isOk = false;
        }

        return isOk;
    }

    private void montarImagem(byte[] chartData2, ImageView ImagemViewr){
        if(chartData2 != null){
            ImagemViewr.setVisibility(View.VISIBLE);

            Bitmap bm = BitmapFactory.decodeByteArray(chartData2, 0, chartData2.length);
            DisplayMetrics dm = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(dm);

            ImagemViewr.setMinimumHeight(dm.heightPixels/2);
            ImagemViewr.setMinimumWidth(dm.widthPixels);
            ImagemViewr.setImageBitmap(bm);

            //mAttacher = new PhotoViewAttacher(imgViewer);
        }else{
            ImagemViewr.setVisibility(View.GONE);
            }

        //TODO remover esse trecho aqui em baixo e colocar em outro metodo
        if(question.getQuestion()!= null && !question.getQuestion().equalsIgnoreCase("")){
            txtPergunta.setVisibility(View.VISIBLE);
        }else{
            txtPergunta.setVisibility(View.GONE);
        }

        if(question.getQuestionUnder()!= null && !question.getQuestionUnder().equalsIgnoreCase("")){
            txtPerguntaUnder.setVisibility(View.VISIBLE);
        }else{
            txtPerguntaUnder.setVisibility(View.GONE);
        }

    }

    public void finishSimulate(View v) {
        saveValues();

        Intent it = new Intent(PerguntaScrollingActivity.this, FinishSimulate.class);
        startActivity(it);
        ClassesStaticas.numeroQuestaoSelecionada = 1;
        finish();
    }

    private void saveValues(){
        /*SALVAR OS VALORES NO DISPOSITIVO*/
        /*SALVA o total de questoes feitas*/
        String tmp = read(ClassesStaticas.totalSimuladoFeitoFile);
        Integer totG = tmp!= null? Integer.parseInt(tmp):0;
        totG++;
        save(ClassesStaticas.totalSimuladoFeitoFile, totG.toString());
        /*Salva quantidade questoes respondidas*/
        saveValue(ClassesStaticas.qtdeQuestoesTotalFile, (ClassesStaticas.numeroQuestoesRespondidasCorretaente + ClassesStaticas.numeroQuestoesRespondidasErroneamente));
        /*Salva quantidade de acertos*/
        saveValue(ClassesStaticas.qtdeQuestoesTotalCertoFile, (ClassesStaticas.numeroQuestoesRespondidasCorretaente));

        /*Salva as questoes de portugues*/
        saveValue(ClassesStaticas.totalAcertosPT,ClassesStaticas.acertoPTV);
        saveValue(ClassesStaticas.totalQuestoesPT, ClassesStaticas.totalPT);

        /*Salva as questoes de ingles*/
        saveValue(ClassesStaticas.totalAcertosING, ClassesStaticas.acertoING);
        saveValue(ClassesStaticas.totalQuestoesPT,ClassesStaticas.totalING);

        /*Salva as questoes de ingles*/
        saveValue(ClassesStaticas.totalAcertosESP, ClassesStaticas.acertoESP);
        saveValue(ClassesStaticas.totalQuestoesESP,ClassesStaticas.totalESP);


        /*Salva as questoes de matematica*/
        saveValue(ClassesStaticas.totalAcertosMTM,ClassesStaticas.acertoMTMV);
        saveValue(ClassesStaticas.totalQuestoesMTM, ClassesStaticas.totalMTM);

        /*Salva as questoes de fisica*/
        saveValue(ClassesStaticas.totalAcertosFIS,ClassesStaticas.acertoFIS);
        saveValue(ClassesStaticas.totalQuestoesFIS, ClassesStaticas.totalFIS);

        /*Salva as questoes de quimica*/
        saveValue(ClassesStaticas.totalAcertosQMC,ClassesStaticas.acertoQMC);
        saveValue(ClassesStaticas.totalQuestoesQMC, ClassesStaticas.totalQMC);

        /*Salva as questoes de historia*/
        saveValue(ClassesStaticas.totalAcertosHIST,ClassesStaticas.acertoHIST);
        saveValue(ClassesStaticas.totalQuestoesHIST, ClassesStaticas.totalHIST);

        /*Salva as questoes de geografia*/
        saveValue(ClassesStaticas.totalAcertosGEO,ClassesStaticas.acertoGEO);
        saveValue(ClassesStaticas.totalQuestoesGEO, ClassesStaticas.totalGEO);

        /*Salva as questoes de biologia*/
        saveValue(ClassesStaticas.totalAcertosBIO,ClassesStaticas.acertoBIO);
        saveValue(ClassesStaticas.totalQuestoesBIO, ClassesStaticas.totalBIO);


        /*SALVAR PONTOS NO BANCO*/
        try {
        Long pontos = generatePoints();
        ClassesStaticas.user.setPontosSemana(ClassesStaticas.user.getPontosSemana() + pontos);
        ClassesStaticas.user.setPontosGeral(ClassesStaticas.user.getPontosGeral() + pontos);
        ClassesStaticas.user.setPontosMes(ClassesStaticas.user.getPontosMes() + pontos);

        String id = null;

            id = Utils.read(openFileInput(ClassesStaticas.idUserSaved));
            ClassesStaticas.user.setId(id != null ? Long.parseLong(id) : 0L) ;

            UserService userService = new UserService();

            UsuarioDTO user = userService.save(ClassesStaticas.user);
            Utils.save(user.getId().toString(), openFileOutput(ClassesStaticas.idUserSaved, MODE_WORLD_READABLE));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private Long generatePoints() {

        Long pontos = ClassesStaticas.numeroQuestoesRespondidasCorretaente *64L;
        Long pontosPerdidos = ClassesStaticas.numeroQuestoesRespondidasErroneamente * 16L;
        Long pontosTotal = pontos - pontosPerdidos;

        return pontosTotal >0 ? pontosTotal:0L;
    }

    private void saveValue(String variavel, int total){
         /*Salva as Total de ingles*/
        String tmpPTTotal2 = read(variavel);
        Integer totPTTotal2 = tmpPTTotal2!= null? Integer.parseInt(tmpPTTotal2):0;
        totPTTotal2+=total;
        save(variavel, totPTTotal2.toString());
    }

    public void save(String file, String data){

        try {
            FileOutputStream fOut = openFileOutput(file, MODE_WORLD_READABLE);
            fOut.write(data.getBytes());
            fOut.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public String read(String file){
        try{
            FileInputStream fin = openFileInput(file);
            int c;
            String temp="";
            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c);
            }

            return temp;

        }catch(Exception e){
            return null;
        }

    }


}
