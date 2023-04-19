package com.svr.parcialcmovil2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.svr.parcialcmovil2.interfaces.CrudEmpleadoInterface;

import com.svr.parcialcmovil2.model.Empleado;
import com.svr.parcialcmovil2.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Registrar extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        findViewById(R.id.btnResgistrarU).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar();
            }
        });
    }

    private void registrar(){

    final TextView txtUserR = (EditText) findViewById(R.id.txtNombreR);
    final TextView txtEmailR = (EditText) findViewById(R.id.txtEmailR);
    final TextView txtPasswordR = (EditText)findViewById(R.id.txtPasswordR);




    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    CrudEmpleadoInterface crudempleado = retrofit.create(CrudEmpleadoInterface.class);

    Empleado empleado = new Empleado();
    empleado.setNombre(txtUserR.getText().toString());
    empleado.setEmail(txtEmailR.getText().toString());
    empleado.setPassword(txtPasswordR.getText().toString());

    Call<Void> call = crudempleado.registrarUsuario(empleado);
    call.enqueue(new Callback<Void>() {

        public void onResponse(Call<Void> call, Response<Void> response) {
            if(!response.isSuccessful()){

                Log.e("Response error: ", response.message());

            } else {
                Log.i("Registro: ", empleado.getNombre()+empleado.getEmail());
                finish();
            }
        }


        public void onFailure(Call<Void> call, Throwable t) {
            Log.e("Throw error: ", t.getMessage());
        }
    });
    }




}
