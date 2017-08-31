package acf.com.br.provasufsc;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.provasUfsc.aaf.model.Question;
import org.provasUfsc.aaf.model.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FinishSimulate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_simulate);
        resultadosFinais();
        ClassesStaticas.carregarQuestoes = true;


    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        ClassesStaticas.salvarQuestoes = false;
        ClassesStaticas.carregarQuestoes = false;
        savedInstanceState.putInt("Respondidas", ClassesStaticas.numeroQuestoesRespondidas);
        savedInstanceState.putInt("Erroneamente", ClassesStaticas.numeroQuestoesRespondidasErroneamente);
        savedInstanceState.putInt("Corretamente", ClassesStaticas.numeroQuestoesRespondidasCorretaente);

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        ClassesStaticas.numeroQuestoesRespondidas = savedInstanceState.getInt("Respondidas");
        ClassesStaticas.numeroQuestoesRespondidasErroneamente =  savedInstanceState.getInt("Erroneamente");
        ClassesStaticas.numeroQuestoesRespondidasCorretaente =  savedInstanceState.getInt("Corretamente");
        resultadosFinais();
    }

    public void resultadosFinais(){
        TextView txtPergunta = (TextView) findViewById(R.id.txtPerguntasRespondidas);
        txtPergunta.setText(ClassesStaticas.numeroQuestoesRespondidasCorretaente + ClassesStaticas.numeroQuestoesRespondidasErroneamente  +"");


        TextView txtRespCerta = (TextView) findViewById(R.id.txtRespostasCertas);
        txtRespCerta.setText(ClassesStaticas.numeroQuestoesRespondidasCorretaente+"");


        TextView txtErrada = (TextView) findViewById(R.id.txtRespostasErradas);
        txtErrada.setText(ClassesStaticas.numeroQuestoesRespondidasErroneamente + "");
    }

    public void revisarQuestoesErradas(View v) {
        ClassesStaticas.revisarQuestoes = true;
        Intent it = new Intent(FinishSimulate.this, PerguntaScrollingActivity.class);
        startActivity(it);
        finish();
    }


}
