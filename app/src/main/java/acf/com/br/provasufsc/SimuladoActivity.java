package acf.com.br.provasufsc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.Spinner;

public class SimuladoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulado);

        //Recuperar o spinner e o valor do spinner adicionand o listener no spinner para a DISCIPLINA
        Spinner spDisciplina = (Spinner)findViewById(R.id.spinner);
        spDisciplina.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ClassesStaticas.disciplinaSelecionada =  parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // sometimes you need nothing here
            }
        });

        //Recuperar o spinner e o valor do spinner adicionand o listener no spinner para a ANO
        Spinner sAno = (Spinner)findViewById(R.id.spAno);
        sAno.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ClassesStaticas.anoSelecionado =  parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // sometimes you need nothing here
            }
        });

        ClassesStaticas.carregarQuestoes = true;
        ClassesStaticas.salvarQuestoes = true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
             return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void openPerguntasSimulado(View v) {
        ClassesStaticas.revisarQuestoes = false;
        Intent it = new Intent(SimuladoActivity.this, PerguntaScrollingActivity.class);
        ClassesStaticas.carregarQuestoes = true;
        startActivity(it);
        finish();
    }

}
