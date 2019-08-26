package com.selvamani.expandablerecyclerviewimageviewer.Remote.Deserializers;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.selvamani.expandablerecyclerviewimageviewer.Remote.Datamodel.ChildModel;
import com.selvamani.expandablerecyclerviewimageviewer.Remote.Datamodel.ParentModel;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ParentModelDeserializer implements JsonDeserializer<ParentModel> {

    @Override
    public ParentModel deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final JsonObject jsonObject=json.getAsJsonObject();
        ParentModel parentModel=new ParentModel();


        if (jsonObject.get("id") != null) {
            if(!jsonObject.get("id").isJsonNull()) {
                parentModel.setId(jsonObject.get("id").getAsInt());
            }else {
                parentModel.setId(0);
            }
        }
        else {
            parentModel.setId(0);
        }

        if (jsonObject.get("image_URL") != null) {
            if(!jsonObject.get("image_URL").isJsonNull()) {
                parentModel.setImage_URL(jsonObject.get("image_URL").getAsString());
            }else {
                parentModel.setImage_URL("");
            }
        }

        final JsonArray objectAsJsonArray = jsonObject.getAsJsonArray("childarray");
        ArrayList<ChildModel> childModelArrayList = new ArrayList<ChildModel>();

        if(!objectAsJsonArray.isJsonNull()) {
            for (int i = 0; i < objectAsJsonArray.size(); i++) {
                JsonObject jObj = objectAsJsonArray.get(i).getAsJsonObject();
                childModelArrayList.add(new ChildModelDeserializer().deserialize(jObj, ChildModel.class, context));
            }
            parentModel.setChildarray(childModelArrayList);
        }


        return parentModel;

    }

}


