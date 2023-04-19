package com.svr.parcialcmovil2;

/*
public class consultarModificar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consultar);

        findViewById(R.id.btnConsultarPerfil).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultarEmpleado();
            }
        });
    }


    private void consultarEmpleado(){

        CrudEmpleadoInterface crudempleado;

        List<Empleado> listEmpleado;

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
}*/
