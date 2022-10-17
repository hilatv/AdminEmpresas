package com.example.Yerizk.controllers;

import com.example.Yerizk.model.UserResponse;
import com.example.Yerizk.services.EmpresaService;
import com.example.Yerizk.services.EmpleadoService;
import com.example.Yerizk.model.MovimientoDinero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class MovimientoDineroController {

    private final EmpleadoService EmpleadoService;
    private final EmpresaService EmpresaService;


    public MovimientoDineroController(EmpresaService EmpresaService, EmpleadoService EmpleadoService) {
        this.EmpresaService = EmpresaService;
        this.EmpleadoService = EmpleadoService;
    }

    @GetMapping("/enterprises/movimientos/{id}")
    public ResponseEntity<List<MovimientoDinero>> ListarMovimientos() {
        return ResponseEntity.ok().body(this.EmpresaService.ListarMovimientos());
    }

    //@GetMapping("/enterprise/{id}")
    //public ResponseEntity<Object> getMovimientoDinero(@PathVariable Long id){

    // try {
    // MovimientoDinero Movimiento = EmpresaService.getMovimientoDinero(id);
    //  return new ResponseEntity<>(Movimiento,HttpStatus.OK);
    //} catch (Exception e) {
    // return new ResponseEntity<>(e.getMessage(),
    // HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    //}

    @PostMapping("/enterprises/movements")
    public MovimientoDinero crearMovimiento(@RequestBody MovimientoDinero Movimiento) {
        return EmpresaService.saveMovimiento(Movimiento);
    }

    @PutMapping("/enterprises/movements/{id}")
    public ResponseEntity<MovimientoDinero> MovimientoDineroUpdate(@RequestBody MovimientoDinero Movimiento) {
        return ResponseEntity.ok().body(this.EmpresaService.updateMovimiento(Movimiento));
    }

    @DeleteMapping("/enterprises/movements/{id}")
    public ResponseEntity<UserResponse> deleteMovimiento(@PathVariable Long id) {
        return new ResponseEntity<>(

                new UserResponse(EmpresaService.deleteMovimiento(id), null), HttpStatus.OK
        );
    }
    @PatchMapping("/movements/actualizar/{id}")
    public ResponseEntity<UserResponse> patchMovimientoDinero (@RequestBody MovimientoDinero Movimiento, @PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    new UserResponse("Actualizacion Exitosa", EmpresaService.patchMovimientoDinero(Movimiento, id)),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new UserResponse(e.getMessage(), null),
                    HttpStatus.OK
            );
        }


    }

}
