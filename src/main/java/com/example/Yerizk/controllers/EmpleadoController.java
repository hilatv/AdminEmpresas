package com.example.Yerizk.controllers;

import com.example.Yerizk.model.Empleado;
import com.example.Yerizk.model.UserResponse;
import com.example.Yerizk.services.EmpleadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {

    private final EmpleadoService EmpleadoService;
    public EmpleadoController(EmpleadoService EmpleadoService){this.EmpleadoService = EmpleadoService;}

    @GetMapping("/users")
    public ResponseEntity<List<Empleado>> getEmpleados(){
        return new ResponseEntity<List<Empleado>>(
                EmpleadoService.ListarEmpleados(),
                HttpStatus.OK
        );
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Object> getUsuario(@PathVariable Long id){

        try {
            Empleado empleado = EmpleadoService.getEmpleado(id);
            return new ResponseEntity<>(empleado,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/users")
    public ResponseEntity<UserResponse> postEmpleado(@RequestBody Empleado empleado){
        return new ResponseEntity<>(

                new UserResponse("Empleado Creado Exitosamente",
                        EmpleadoService.saveEmpleado(empleado))

                ,HttpStatus.OK);
    }

    @PutMapping("/user")
    public ResponseEntity<UserResponse> putEmpleado(@RequestBody Empleado empleado){
        return new ResponseEntity<>(
                new UserResponse("Empleado Actualizado Exitosamente", EmpleadoService.putEmpleado(empleado))
                ,HttpStatus.OK);
    }

    @PatchMapping("/user/{id}")
    public ResponseEntity<UserResponse> patchEmpleado(@RequestBody Empleado empleado, @PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    new UserResponse("Actualizacion Exitosa", EmpleadoService.patchEmpleado(empleado, id)),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new UserResponse(e.getMessage(), null),
                    HttpStatus.OK
            );
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<UserResponse> deleteEmpleado(@PathVariable Long id){
        return new ResponseEntity<>(

                new UserResponse(EmpleadoService.deleteEmpleado(id), null),
                HttpStatus.OK
        );
    }





}
