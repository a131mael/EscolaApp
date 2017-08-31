package acf.com.br.provasufsc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.provasUfsc.aaf.model.GroupService;
import org.provasUfsc.aaf.model.GrupoDTO;
import org.provasUfsc.aaf.model.UserService;
import org.provasUfsc.aaf.model.UsuarioDTO;
import org.provasUfsc.aaf.model.Utils;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ProfileActivity extends AppCompatActivity {

    private EditText inputName;
    private EditText inputGrupo1;
    private EditText inputGrupo2;
    private EditText inputGrupo3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        inputName = (EditText)findViewById(R.id.inputName);
        inputGrupo1 = (EditText)findViewById(R.id.inputGrupo1);
        inputGrupo2 = (EditText)findViewById(R.id.inputGrupo2);
        inputGrupo3 = (EditText)findViewById(R.id.inputGrupo3);


        try {
            inputName.setText(Utils.removeSpecialCharacter(Utils.read(openFileInput(ClassesStaticas.nomeDoUsuario))));
            inputGrupo1.setText(Utils.removeSpecialCharacter(Utils.read(openFileInput("grupo1"))));
            inputGrupo2.setText(Utils.removeSpecialCharacter(Utils.read(openFileInput("grupo2"))));
            inputGrupo3.setText(Utils.removeSpecialCharacter(Utils.read(openFileInput("grupo3"))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void saveProfile(View view){

        try {
            String nomeDoUsuario = Utils.removeSpecialCharacter(inputName.getText().toString());
            Utils.save(nomeDoUsuario,openFileOutput(ClassesStaticas.nomeDoUsuario, MODE_WORLD_READABLE));
            Utils.save(Utils.removeSpecialCharacter(inputGrupo1.getText().toString()), openFileOutput("grupo1", MODE_WORLD_READABLE));
            Utils.save(Utils.removeSpecialCharacter(inputGrupo2.getText().toString()), openFileOutput("grupo2", MODE_WORLD_READABLE));
            Utils.save(Utils.removeSpecialCharacter(inputGrupo3.getText().toString()), openFileOutput("grupo3", MODE_WORLD_READABLE));

            String id = Utils.read(openFileInput(ClassesStaticas.idUserSaved));
            ClassesStaticas.user.setId(id != null ? Long.parseLong(id) : 0L) ;

            saveUser();
            saveGroups();

            Utils.showMessage(getApplicationContext(), "Salvo com Sucesso!");
        } catch (FileNotFoundException e) {
            saveUser();
            saveGroups();
        }

    }

    private void saveUser(){
        UserService userService = new UserService();

        ClassesStaticas.user.setName(Utils.removeSpecialCharacter(inputName.getText().toString()));
        UsuarioDTO user = userService.save(ClassesStaticas.user);

        try {
            Utils.save(user.getId().toString(), openFileOutput(ClassesStaticas.idUserSaved, MODE_WORLD_READABLE));
        } catch (FileNotFoundException e1) {
            Utils.showMessage(getApplicationContext(), "Deu ruim!");
        }
    }

    private void saveGroups(){
        try {

            GrupoDTO g = new GrupoDTO();
            String id = Utils.read(openFileInput(ClassesStaticas.idUserSaved));

            g.setIdUsuario(Long.parseLong(id));
            g.setNomeGrupo1(Utils.removeSpecialCharacter(inputGrupo1.getText().toString()));
            g.setNomeGrupo2(Utils.removeSpecialCharacter(inputGrupo2.getText().toString()));
            g.setNomeGrupo3(Utils.removeSpecialCharacter(inputGrupo3.getText().toString()));

            GroupService groupService = new GroupService();
            GrupoDTO grupoDTO = groupService.save(g);

            Utils.save(Utils.removeSpecialCharacter(inputGrupo1.getText().toString()), openFileOutput(ClassesStaticas.nameGrupo1, MODE_WORLD_READABLE));
            Utils.save(Utils.removeSpecialCharacter(inputGrupo2.getText().toString()), openFileOutput(ClassesStaticas.nameGrupo2, MODE_WORLD_READABLE));
            Utils.save(Utils.removeSpecialCharacter(inputGrupo3.getText().toString()), openFileOutput(ClassesStaticas.nameGrupo3, MODE_WORLD_READABLE));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

}
