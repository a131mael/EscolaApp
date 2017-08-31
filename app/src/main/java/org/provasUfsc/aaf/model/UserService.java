package org.provasUfsc.aaf.model;

import java.util.List;
import com.cedarsoftware.util.io.JsonWriter;

import org.json.JSONObject;

/**
 * Created by Abimael Fidencio on 10/11/2016.
 */


public class UserService extends Service{

    public UsuarioDTO save(String name) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setName(name);
        usuarioDTO.setPontosGeral(0L);
        usuarioDTO.setPontosMes(0L);
        usuarioDTO.setPontosSemana(0L);
        JSONObject jo = JSONPPost.postJson(JsonWriter.objectToJson(usuarioDTO), EndPoints.SAVE_USER);
        return (UsuarioDTO) Service.getObject(jo.toString());
    }

    public UsuarioDTO save(UsuarioDTO user) {
        JSONObject jo = JSONPPost.postJson(JsonWriter.objectToJson(user), EndPoints.SAVE_USER);
        return (UsuarioDTO) Service.getObject(jo);

    }

    public UsuarioDTO getUser(Long id) {
        String endPoint =  EndPoints.GET_USER_BY_ID.replace("*1", id.toString());
        return (UsuarioDTO)getObject(endPoint);
    }

    public UsuarioDTO getMaiorPontuadorGeral() {
        String endPoint =  EndPoints.USER_MAIOR_PONTUADOR;
        return (UsuarioDTO)getObject(endPoint);
    }

    public UsuarioDTO getMaiorPontuadorMensal() {
        String endPoint =  EndPoints.USER_MAIOR_PONTUADOR_MES;
        return (UsuarioDTO)getObject(endPoint);
    }

    public UsuarioDTO getMaiorPontuadorSemanal() {
        String endPoint =  EndPoints.USER_MAIOR_PONTUADOR_SEMANA;
        return (UsuarioDTO)getObject(endPoint);
    }
}
