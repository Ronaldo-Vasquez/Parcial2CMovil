package com.svr.parcialcmovil2;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.svr.parcialcmovil2.interfaces.CrudEmpleadoInterface;
import com.svr.parcialcmovil2.model.Empleado;
import com.svr.parcialcmovil2.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<Empleado> listEmpleado;
    CrudEmpleadoInterface crudempleado;

/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getAll();
    }

 */

    private void getAll(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        crudempleado = retrofit.create(CrudEmpleadoInterface.class);
        Call<List<Empleado>> call = crudempleado.getAll();

        call.enqueue(new Callback<List<Empleado>>(){
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse (Call<List<Empleado>> call, Response<List<Empleado>> response){
                if(!response.isSuccessful()){
                    //System.out.println(response.message());
                    Log.e("Response error: ", response.message());
                    return;
                }
                listEmpleado = response.body();
                //listEmpleado.forEach(p-> System.out.println(p.toString()));
                for (Empleado p : listEmpleado) {
                    Log.i("Empleado: ", p.toString());
                }

            }

            @Override
            public void onFailure(Call<List<Empleado>> call, Throwable t){
                //System.out.println(t.getMessage());
                Log.e("Throw error: ", t.getMessage());
            }
        });
    }







    //Creando Login, no funciona metodo post de login

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getAll();

        findViewById(R.id.btnLog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getLogin();
            }
        });

        findViewById(R.id.btnRegistrar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Registrar.class));
            }
        });

    }


    private void getLogin(){

        final TextView txtUser = (TextView) findViewById(R.id.textViewLogUser);
        final TextView txtPassword = (TextView)findViewById(R.id.textViewLogPass);

        Empleado empleado = new Empleado();
        empleado.setNombre(txtUser.getText().toString());
        empleado.setPassword(txtPassword.getText().toString());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Call<Empleado> call = crudempleado.getLogin(empleado);

        call.enqueue(new Callback<Empleado>() {
            @Override
            public void onResponse(Call<Empleado> call, Response<Empleado> response) {
                /*
                if(response.body().getError()!=null){
                    Toast.makeText(getApplicationContext(), ""+response.body().getError(), Toast.LENGTH_SHORT).show();
                    Log.e("Response error: ", response.message());
                }else{

                    Log.i("Inicio Correcto: ", txtUser.getText().toString() + txtPassword.getText().toString());
                }*/
                if(!response.isSuccessful()){
                    Log.e("Response error: ", response.message());
                }else{
                    Log.i("Inicio Correcto: ", txtUser.getText().toString() + txtPassword.getText().toString());
                    startActivity(new Intent(getApplicationContext(), Menu.class));
                }




                //PROFE POR EL MOMENTO SE PUEDE INICAR SESION CON CUALQUIER COSA;
            }

            @Override
            public void onFailure(Call<Empleado> call, Throwable t) {
                Log.e("Throw error: ", t.getMessage());
            }
        });

        }






}