package net.unibave.showcasecars.service;

import net.unibave.showcasecars.model.Carro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CarroService {

    @GET("categoria/{idCategoria}/carro")
    Call<List<Carro>> listar(@Path("idCategoria") Long idCategoria);

}
