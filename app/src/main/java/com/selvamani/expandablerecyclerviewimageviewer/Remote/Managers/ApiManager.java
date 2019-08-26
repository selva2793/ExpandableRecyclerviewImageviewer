package com.selvamani.expandablerecyclerviewimageviewer.Remote.Managers;


import com.selvamani.expandablerecyclerviewimageviewer.Remote.Datamodel.ParentModel;
import com.selvamani.expandablerecyclerviewimageviewer.Remote.VariableAPi;

import java.util.List;

import rx.Observable;

/**
 * Created by ${Selva} on 09/08/19.
 */

public class ApiManager {

    VariableAPi api;
//
    public ApiManager(VariableAPi api){
        this.api = api;
    }

//    public Observable<Token> getResponseToken(JsonObject object) {
//        return  api.getResponseToken(object);
//    }
//
//    public Observable<Token> sendTokens(String  tok) {
//        return  api.sendTokens(tok);
//    }

    public Observable<List<ParentModel>> getParenchildData() {
        return api.getParenchildData();
    }
//
//    public Observable<List<LoginModel>> getLoginresponse() {
//        return api.getLoginresponse();
//    }
//    public Observable<List<DealerListModel>> getDealerList(){
//        return api.getDealerList();
//    }

//    public Observable<List<QuestionBankModel>> getQuestionBank() {
//        return api.getQuestionBank();
//    }
}