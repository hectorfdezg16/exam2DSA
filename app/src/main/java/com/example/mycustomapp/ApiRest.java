package com.example.mycustomapp;

import com.example.mycustomapp.Models.Repo;
import com.example.mycustomapp.Models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRest {
    //en esta parte es donde vamos a llamar a retrofit y vamos a empezar a hacer consultas a la API
    String BASE_URL = "https://api.github.com/users/";


    
    @GET("user/repos")
    Call<List<Repo>> getRepos();

    @GET("user")
    Call<List<User>> getUser();

}
