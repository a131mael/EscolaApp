package acf.com.br.provasufsc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.os.StrictMode;

import org.provasUfsc.aaf.model.UserService;
import org.provasUfsc.aaf.model.UsuarioDTO;
import org.provasUfsc.aaf.model.Utils;

import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Escola Adonai");
        setSupportActionBar(toolbar);



        try {
            String id = Utils.read(openFileInput(ClassesStaticas.idUserSaved));
            ClassesStaticas.user.setId(id != null ? Long.parseLong(id) :0L) ;
        } catch (FileNotFoundException e) {
            //saveUser();
        }
        if(ClassesStaticas.user == null || ClassesStaticas.user.getId() == null || ClassesStaticas.user.getId().equals(0L) ){
            //saveUser();
        }
        //else {

            //UsuarioDTO u = getUser();
//            if(u != null){
  //              ClassesStaticas.user = u;
  //          }else{
//                saveUser();
    //        }

        //}

    }

    private void saveUser(){
        UserService userService = new UserService();
        ClassesStaticas.user.setName(ClassesStaticas.nomeDoUsuario);
  //      UsuarioDTO userSaved = userService.save(ClassesStaticas.user);
        /*ClassesStaticas.idUsuario = userSaved.getId();
        ClassesStaticas.user = userSaved;*/
        try {
            Utils.save(ClassesStaticas.idUsuario.toString(), openFileOutput(ClassesStaticas.idUserSaved, MODE_WORLD_READABLE));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private UsuarioDTO getUser(){
        try{
            UserService userService = new UserService();
            return  userService.getUser(ClassesStaticas.user.getId());
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void openSimulado(View v) {
        Intent it = new Intent(MainActivity.this, SimuladoActivity.class);
        startActivity(it);
    }

    public void openMeusResultados(View v) {
        Intent it = new Intent(MainActivity.this, MeusResultados.class);
        startActivity(it);
    }

    public void openProfile(View v) {
        Intent it = new Intent(MainActivity.this, ProfileActivity.class);
        startActivity(it);
    }


    public void openRanking(View v) {
        Intent it = new Intent(MainActivity.this, RankingActivity.class);
        startActivity(it);
    }



}
