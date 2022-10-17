package com.example.Yerizk.controllers;


import com.example.Yerizk.dto.EmpresaDto;
import com.example.Yerizk.model.Empleado;
import com.example.Yerizk.model.Empresa;
import com.example.Yerizk.model.UserResponse;
import com.example.Yerizk.repositories.RepositorioEmpresa;
import com.example.Yerizk.services.EmpresaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EmpresaController {

    private final EmpresaService EmpresaService;


    public EmpresaController(EmpresaService EmpresaService) {
        this.EmpresaService = EmpresaService;
    }

    @GetMapping("/enterprise")
    public ResponseEntity<List<Empresa>> ListarEmpresas() {
        return ResponseEntity.ok().body(this.EmpresaService.ListarEmpresas());

    }

    @GetMapping("/enterprise/{id}")
    public ResponseEntity<Object> getEmpleado(@PathVariable Long id){

        try {
            Empresa empresa = EmpresaService.getEmpresa(id);
            return new ResponseEntity<>(empresa,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/enterprise")
    public ResponseEntity<UserResponse> postEmpresa(@RequestBody Empresa empresa){
        return new ResponseEntity<>(

                new UserResponse("Empresa Creado Exitosamente",
                        EmpresaService.saveEmpresa(empresa))

                ,HttpStatus.OK);
    }
    @PutMapping("/enterpraise/actualizar/{id}")
    public ResponseEntity<UserResponse> putEmpresa(@RequestBody Empresa empresa){
        return new ResponseEntity<>(
                new UserResponse("Empresa Actualizada Exitosamente", EmpresaService.putEmpresa(empresa))
                ,HttpStatus.OK);
    }

    @DeleteMapping("/enterprise/eliminar/{id}")
    public ResponseEntity<UserResponse> eliminarEmpresa(@PathVariable Long id) {
        return new ResponseEntity<>(

                new UserResponse(EmpresaService.eliminarEmpresa(id), null),
                HttpStatus.OK
        );
    }

    @PatchMapping("/Empresa/actualizar/{id}")

    public ResponseEntity<UserResponse> patchEmpresa (@RequestBody Empresa empresa, @PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    new UserResponse("Actualizacion Exitosa", EmpresaService.patchEmpresa(empresa, id)),
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