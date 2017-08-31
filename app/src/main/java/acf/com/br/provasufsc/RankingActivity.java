package acf.com.br.provasufsc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.provasUfsc.aaf.model.EndPoints;
import org.provasUfsc.aaf.model.GrupoService;
import org.provasUfsc.aaf.model.UserService;
import org.provasUfsc.aaf.model.UsuarioDTO;
import org.provasUfsc.aaf.model.Utils;

import java.io.FileNotFoundException;

public class RankingActivity extends AppCompatActivity {

    private TextView txtMeusPontosGeral;
    private TextView txtMeusPontosSemanal;
    private TextView txtMeusPontosMensal;
    private TextView txtPontosPrimeiroGeral;
    private TextView txtPontosPrimeiroMensal;
    private TextView txtPontosPrimeiroSemanal;
    //GRUPO1
    private TextView txtNomeGrupo;
    private TextView txtMeusPontosGeralG1;
    private TextView txtMeusPontosSemanalG1;
    private TextView txtMeusPontosMensalG1;
    private TextView txtPontosPrimeiroGeralG1;
    private TextView txtPontosPrimeiroMensalG1;
    private TextView txtPontosPrimeiroSemanalG1;

    //GRUPO2
    private TextView txtNomeGrupo2;
    private TextView txtMeusPontosGeralG2;
    private TextView txtMeusPontosSemanalG2;
    private TextView txtMeusPontosMensalG2;
    private TextView txtPontosPrimeiroGeralG2;
    private TextView txtPontosPrimeiroMensalG2;
    private TextView txtPontosPrimeiroSemanalG2;

    //GRUPO3
    private TextView txtNomeGrupo3;
    private TextView txtMeusPontosGeralG3;
    private TextView txtMeusPontosSemanalG3;
    private TextView txtMeusPontosMensalG3;
    private TextView txtPontosPrimeiroGeralG3;
    private TextView txtPontosPrimeiroMensalG3;
    private TextView txtPontosPrimeiroSemanalG3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtMeusPontosGeral = (TextView) findViewById(R.id.txtMeusPontosGeral);
        txtMeusPontosGeral.setText(String.valueOf(ClassesStaticas.user.getPontosGeral()));

        txtMeusPontosMensal = (TextView) findViewById(R.id.txtMeusPontosMes);
        txtMeusPontosMensal.setText(String.valueOf(ClassesStaticas.user.getPontosMes()));

        txtMeusPontosSemanal = (TextView) findViewById(R.id.txtMeusPontosSemana);
        txtMeusPontosSemanal.setText(String.valueOf(ClassesStaticas.user.getPontosSemana()));

        txtPontosPrimeiroGeral = (TextView) findViewById(R.id.txtPontosMelhorColocadoGeral);
        txtPontosPrimeiroGeral.setText(String.valueOf(getUsuario(null,1).getPontosGeral()));

        txtPontosPrimeiroMensal = (TextView) findViewById(R.id.txtPontosMelhorCoolocadoMes);
        txtPontosPrimeiroMensal.setText(String.valueOf(getUsuario(null,2).getPontosMes()));

        txtPontosPrimeiroSemanal = (TextView) findViewById(R.id.txtPontosSemana);
        txtPontosPrimeiroSemanal.setText(String.valueOf(getUsuario(null,3).getPontosSemana()));

        //GRUPO 1
        try {
            String nomeDoGrupo = Utils.read(openFileInput(ClassesStaticas.nameGrupo1));
            if(nomeDoGrupo != null && !nomeDoGrupo.equalsIgnoreCase("")){
                txtNomeGrupo = (TextView) findViewById(R.id.txtGrupo1);
                txtNomeGrupo.setText(nomeDoGrupo);

                txtMeusPontosGeralG1 = (TextView) findViewById(R.id.txtMeusPontosGeralG1);
                txtMeusPontosGeralG1.setText(String.valueOf(ClassesStaticas.user.getPontosGeral()));

                txtMeusPontosMensalG1 = (TextView) findViewById(R.id.txtMeusPontosMesG1);
                txtMeusPontosMensalG1.setText(String.valueOf(ClassesStaticas.user.getPontosMes()));

                txtMeusPontosSemanalG1 = (TextView) findViewById(R.id.txtMeusPontosSemanaG1);
                txtMeusPontosSemanalG1.setText(String.valueOf(ClassesStaticas.user.getPontosSemana()));

                txtPontosPrimeiroGeralG1 = (TextView) findViewById(R.id.txtPontosMelhorColocadoGeralG1);
                txtPontosPrimeiroGeralG1.setText(String.valueOf(getUsuario(null,1).getPontosGeral()));

                txtPontosPrimeiroMensalG1 = (TextView) findViewById(R.id.txtPontosMelhorCoolocadoMesG1);
                txtPontosPrimeiroMensalG1.setText(String.valueOf(getUsuario(null,2).getPontosMes()));

                txtPontosPrimeiroSemanalG1 = (TextView) findViewById(R.id.txtPontosSemanaG1);
                txtPontosPrimeiroSemanalG1.setText(String.valueOf(getUsuario(null, 3).getPontosSemana()));
            }else{
                txtNomeGrupo.setVisibility(View.GONE);
                txtMeusPontosGeralG1.setVisibility(View.GONE);
                txtMeusPontosMensalG1.setVisibility(View.GONE);
                txtMeusPontosSemanalG1.setVisibility(View.GONE);
                txtPontosPrimeiroGeralG1.setVisibility(View.GONE);
                txtPontosPrimeiroMensalG1.setVisibility(View.GONE);
                txtPontosPrimeiroSemanalG1.setVisibility(View.GONE);
            }

        } catch (FileNotFoundException e) {
         //Nao tem grupo salvo
        }

        //GRUPO 2
        try {
            String nomeDoGrupo2 = Utils.read(openFileInput(ClassesStaticas.nameGrupo2));
            if(nomeDoGrupo2 != null && !nomeDoGrupo2.equalsIgnoreCase("")){
                txtNomeGrupo2 = (TextView) findViewById(R.id.txtGrupo2);
                txtNomeGrupo2.setText(nomeDoGrupo2);

                txtMeusPontosGeralG2 = (TextView) findViewById(R.id.txtMeusPontosGeralG2);
                txtMeusPontosGeralG2.setText(String.valueOf(ClassesStaticas.user.getPontosGeral()));

                txtMeusPontosMensalG2 = (TextView) findViewById(R.id.txtMeusPontosMesG2);
                txtMeusPontosMensalG2.setText(String.valueOf(ClassesStaticas.user.getPontosMes()));

                txtMeusPontosSemanalG2 = (TextView) findViewById(R.id.txtMeusPontosSemanaG2);
                txtMeusPontosSemanalG2.setText(String.valueOf(ClassesStaticas.user.getPontosSemana()));

                txtPontosPrimeiroGeralG2 = (TextView) findViewById(R.id.txtPontosMelhorColocadoGeralG2);
                txtPontosPrimeiroGeralG2.setText(String.valueOf(getUsuario(null,1).getPontosGeral()));

                txtPontosPrimeiroMensalG2 = (TextView) findViewById(R.id.txtPontosMelhorCoolocadoMesG2);
                txtPontosPrimeiroMensalG2.setText(String.valueOf(getUsuario(null,2).getPontosMes()));

                txtPontosPrimeiroSemanalG2 = (TextView) findViewById(R.id.txtPontosSemanaG2);
                txtPontosPrimeiroSemanalG2.setText(String.valueOf(getUsuario(null, 3).getPontosSemana()));
            }else{
                txtNomeGrupo2.setVisibility(View.GONE);
                txtMeusPontosGeralG2.setVisibility(View.GONE);
                txtMeusPontosMensalG2.setVisibility(View.GONE);
                txtMeusPontosSemanalG2.setVisibility(View.GONE);
                txtPontosPrimeiroGeralG2.setVisibility(View.GONE);
                txtPontosPrimeiroMensalG2.setVisibility(View.GONE);
                txtPontosPrimeiroSemanalG2.setVisibility(View.GONE);
            }

        } catch (FileNotFoundException e) {
            //Nao tem grupo salvo
        }

        //GRUPO 3
        try {
            String nomeDoGrupo3 = Utils.read(openFileInput(ClassesStaticas.nameGrupo3));
            if(nomeDoGrupo3 != null && !nomeDoGrupo3.equalsIgnoreCase("")){
                txtNomeGrupo3 = (TextView) findViewById(R.id.txtGrupo3);
                txtNomeGrupo3.setText(nomeDoGrupo3);

                txtMeusPontosGeralG3 = (TextView) findViewById(R.id.txtMeusPontosGeralG3);
                txtMeusPontosGeralG3.setText(String.valueOf(ClassesStaticas.user.getPontosGeral()));

                txtMeusPontosMensalG3 = (TextView) findViewById(R.id.txtMeusPontosMesG3);
                txtMeusPontosMensalG3.setText(String.valueOf(ClassesStaticas.user.getPontosMes()));

                txtMeusPontosSemanalG3 = (TextView) findViewById(R.id.txtMeusPontosSemanaG3);
                txtMeusPontosSemanalG3.setText(String.valueOf(ClassesStaticas.user.getPontosSemana()));

                txtPontosPrimeiroGeralG3 = (TextView) findViewById(R.id.txtPontosMelhorColocadoGeralG3);
                txtPontosPrimeiroGeralG3.setText(String.valueOf(getUsuario(null,1).getPontosGeral()));

                txtPontosPrimeiroMensalG3 = (TextView) findViewById(R.id.txtPontosMelhorCoolocadoMesG3);
                txtPontosPrimeiroMensalG3.setText(String.valueOf(getUsuario(null,2).getPontosMes()));

                txtPontosPrimeiroSemanalG3 = (TextView) findViewById(R.id.txtPontosSemanaG3);
                txtPontosPrimeiroSemanalG3.setText(String.valueOf(getUsuario(null, 3).getPontosSemana()));
            }else{
                txtNomeGrupo2.setVisibility(View.GONE);
                txtMeusPontosGeralG2.setVisibility(View.GONE);
                txtMeusPontosMensalG2.setVisibility(View.GONE);
                txtMeusPontosSemanalG2.setVisibility(View.GONE);
                txtPontosPrimeiroGeralG2.setVisibility(View.GONE);
                txtPontosPrimeiroMensalG2.setVisibility(View.GONE);
                txtPontosPrimeiroSemanalG2.setVisibility(View.GONE);
            }

        } catch (FileNotFoundException e) {
            //Nao tem grupo salvo
        }



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private UsuarioDTO getUsuario(String grupo, int periodo){
        UserService us = new UserService();
        GrupoService gs = new GrupoService();

        if(grupo ==null){
            switch (periodo){
                case 1:
                       return us.getMaiorPontuadorGeral();
                case 2:
                      return us.getMaiorPontuadorMensal();

                case 3:
                    return us.getMaiorPontuadorSemanal();

                default:
                    break;
            }
        }else{
            String nomeDoGrupo1 = null;
            String nomeDoGrupo2 = null;
            String nomeDoGrupo3 = null;
            try {
                    nomeDoGrupo1 = Utils.read(openFileInput(ClassesStaticas.nameGrupo1));
                    nomeDoGrupo2 = Utils.read(openFileInput(ClassesStaticas.nameGrupo2));
                    nomeDoGrupo3 = Utils.read(openFileInput(ClassesStaticas.nameGrupo3));

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            switch (periodo){
                case 1:
                    return gs.getUser(EndPoints.GROUP_MAIOR_PONTUADOR,nomeDoGrupo1);
                case 2:
                    return gs.getUser(EndPoints.GROUP_MAIOR_PONTUADOR_MES, nomeDoGrupo2);

                case 3:
                    return gs.getUser(EndPoints.GROUP_MAIOR_PONTUADOR_SEMANA, nomeDoGrupo3);

                default:
                    break;
            }
        }
        return null;
    }

}
