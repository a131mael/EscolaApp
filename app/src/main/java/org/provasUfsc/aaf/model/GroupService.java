package org.provasUfsc.aaf.model;

import com.cedarsoftware.util.io.JsonWriter;

import org.json.JSONObject;

/**
 * Created by Abimael Fidencio on 10/11/2016.
 */


public class GroupService extends Service{

    public GrupoDTO save(GrupoDTO user) {
        JSONObject jo = JSONPPost.postJson(JsonWriter.objectToJson(user), EndPoints.SAVE_GROUP);
        return (GrupoDTO) Service.getObject(jo);

    }

}
