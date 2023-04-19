package com.usc.crud.repository;

import com.usc.crud.model.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends CrudRepository<Empleado, Long> {

    //se que lo necesito para hacer el login pero no estoy seguro de que hace, pendiente por consultar
    //sentencia en sql puro (SELECT empleado FROM Empleado empleado WHERE nombre = nombre)
    String msj = "";
    @Query("SELECT nombre FROM Empleado nombre WHERE nombre.nombre = :nombre")
    Empleado findByNombreUsuario(String nombre);




}
