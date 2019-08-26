package com.selvamani.expandablerecyclerviewimageviewer.Remote;


import com.selvamani.expandablerecyclerviewimageviewer.Remote.Datamodel.ParentModel;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface VariableAPi {

//    @FormUrlEncoded
//    @POST("api/tokenlog")  //Login
//    Observable<Token> getResponseToken(@Field("sending") JsonObject object);
//
//    @FormUrlEncoded
//    @POST("api/post")  //Login
//    Observable<Token> sendTokens(@Field("Bearer") String tok);

    @GET("bins/109ghf")
    Observable<List<ParentModel>> getParenchildData();
}
