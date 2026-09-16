package com.sonou.connecteetusonou;

import retrofit2.Call;
import retrofit2.http.Field;

import retrofit2.http.POST;

public interface ApiService {

    @POST("inscription.php")
    Call<ModInscription> inscription(
            @Field("nom") String nom,
            @Field("prenom") String prenom,
            @Field("login") String login,
            @Field("sex") String sex,
            @Field("password") String password
    );
}
