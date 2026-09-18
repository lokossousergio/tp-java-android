package com.sonou.connecteetusonou;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("inscription.php")
    Call<ModInscription> inscription(
            @Field("nom") String nom,
            @Field("prenom") String prenom,
            @Field("login") String login,
            @Field("sex") String sex,
            @Field("password") String password,
            @Field("cfrmpassword") String cfrmpassword
    );

    @FormUrlEncoded
    @POST("connexion.php")
    Call<Modconnexion> connexion(
            @Field("login") String login,
            @Field("password") String password
    );
}
