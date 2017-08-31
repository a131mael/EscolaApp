package org.provasUfsc.aaf.model;

import com.cedarsoftware.util.io.JsonWriter;

import org.json.JSONObject;

/**
 * Created by Abimael Fidencio on 10/11/2016.
 */


public class GrupoService extends Service{

    public GrupoDTO save(GrupoDTO grupo) {
        JSONObject jo = JSONPPost.postJson(JsonWriter.objectToJson(grupo), EndPoints.SAVE_GROUP);
        return (GrupoDTO) Service.getObject(jo);

    }

    public UsuarioDTO getUser(String endPoint ,String name) {
        String endPointFinal =  endPoint.replace("*1", name);
        return (UsuarioDTO)getObject(endPointFinal);
    }
}
