package com.svr.parcialcmovil2.interfaces;

import com.svr.parcialcmovil2.model.Empleado;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CrudEmpleadoInterface {

    @GET("/consultarAll")
    Call<List<Empleado>> getAll();

    @GET("/consultar/{nombre}")
    Call<List<Empleado>> consultarEmpleado();

    @POST("/login")
    Call<Empleado> getLogin(@Body Empleado empleado);

    @POST("/registro")
    Call<Void> registrarUsuario(@Body Empleado empleado);


}
