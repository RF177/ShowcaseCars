package net.unibave.showcasecars.service;

import net.unibave.showcasecars.model.Categoria;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoriaService {

    @GET("categoria")
    Call<List<Categoria>> listar();


}
