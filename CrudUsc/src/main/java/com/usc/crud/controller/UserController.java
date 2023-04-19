package com.usc.crud.controller;

import com.usc.crud.model.Empleado;
import com.usc.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    //login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Empleado empleado) {

        String msj = "";
        // Obtener las credenciales del cuerpo de la solicitud
        String nombre = empleado.getNombre();
        String password = empleado.getPassword();
        msj = "ingrso pendiente para: "+ nombre + password;

        empleado = service.login(nombre, password);
        if (empleado != null) {
            // Manejar login exitoso
            return ResponseEntity.ok(service.finByUser(empleado));
        } else {
            // Manejar error de autenticación
            msj = "Error de credenciales: "+ nombre+" "+ password;
            System.out.println(msj);
            return ResponseEntity.badRequest().build();
        }
    }

    //registro
    @PostMapping("/registro")
    public Empleado registrarUsuario(@RequestBody Empleado empleado) {
        return service.guardarUser(empleado);
    }

    //consultar empleado
    @GetMapping("/consultar/{nombre}")
    public ResponseEntity<?> consultar(@PathVariable Empleado empleado) {

        return ResponseEntity.ok(service.finByUser(empleado));

    }


    @GetMapping("/consultar/{id}")
    public ResponseEntity<?> filtrar(@PathVariable Empleado empleado) {

        return ResponseEntity.ok(service.finByUser(empleado));

    }


    // create employee rest api
    @PostMapping("/guardar")
    public Empleado createEmployee(@RequestBody Empleado empleado) {
        return service.guardarUser(empleado);
    }

    @GetMapping("/consultarAll")
    public ResponseEntity<?> consultarByUser() {

        return ResponseEntity.ok(service.buscarTdoso()
        );
    }



    // update employee rest api



    // delete employee rest api
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
       String msj = service.eliminarUser(id);
        return ResponseEntity.ok(msj);
    }



}
