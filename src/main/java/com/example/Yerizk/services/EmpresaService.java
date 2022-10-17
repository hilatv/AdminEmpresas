package com.example.Yerizk.services;

import com.example.Yerizk.model.Empresa;
import com.example.Yerizk.model.MovimientoDinero;
import com.example.Yerizk.repositories.RepositorioEmpresa;
import com.example.Yerizk.repositories.RepositorioMovimientoDinero;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    private final RepositorioEmpresa RepositorioEmpresa;
    private final RepositorioMovimientoDinero RepositorioMovimientoDinero;
    private Long id;

    public EmpresaService(RepositorioEmpresa RepositorioEmpresa, RepositorioMovimientoDinero RepositorioMovimientoDinero) {
        this.RepositorioEmpresa = RepositorioEmpresa;
        this.RepositorioMovimientoDinero = RepositorioMovimientoDinero;
    }

    public List<Empresa> ListarEmpresas() {
        return this.RepositorioEmpresa.findAll();
    }

    public List<MovimientoDinero> ListarMovimientos() {
        return this.RepositorioMovimientoDinero.findAll();
    }

    public Empresa getEmpresa(Long id) throws Exception {
        Optional<Empresa> empresaOptional = RepositorioEmpresa.findById(id);
        if(empresaOptional.isPresent()){
            return empresaOptional.get();
        }else{
            throw new Exception("Empresa No Existe");
        }
    }

    public MovimientoDinero getMovimientoDinero(Long id) throws Exception {
        Optional<MovimientoDinero> movimientoDineroOptional = RepositorioMovimientoDinero.findById(id);
        if(movimientoDineroOptional.isPresent()){
            return movimientoDineroOptional.get();
        }else{
            throw new Exception("Movimiento No Existe");
        }
    }

    public Empresa saveEmpresa(Empresa empresa_param){
        return RepositorioEmpresa.save(empresa_param);
    }

    public Empresa putEmpresa(Empresa empresa_param){
        return RepositorioEmpresa.save(empresa_param);
    }
    public String eliminarEmpresa(Long id) {
        RepositorioEmpresa.deleteById(id);
        return "Empresa eliminada Exitosamente";
    }
    public Empresa patchEmpresa(Empresa empresa_param, Long id) throws Exception {
        try {
            Empresa EmpresaBd = getEmpresa(id);

            if (empresa_param.getNombre() != null) {
                EmpresaBd.setNombre(empresa_param.getNombre());
            }
            if (empresa_param.getDireccion() != null) {
                EmpresaBd.setDireccion(empresa_param.getDireccion());
            }
            if (empresa_param.getTelefono() != null) {
                EmpresaBd.setTelefono(empresa_param.getTelefono());
            }
            if (empresa_param.getNit() != null) {
                EmpresaBd.setNit(empresa_param.getNit());
            }
            return saveEmpresa(EmpresaBd);

        } catch (Exception e) {
            throw new Exception("Empresa no se actualizo, porque no existe");
        }
    }


    public MovimientoDinero saveMovimiento(MovimientoDinero movimientoDinero) {
        MovimientoDinero nuevoMovimiento = new MovimientoDinero();
        nuevoMovimiento.setMontoDinero(movimientoDinero.getMontoDinero());
        nuevoMovimiento.setMontoPositivo(movimientoDinero.getMontoPositivo());
        nuevoMovimiento.setMontoNegativo(movimientoDinero.getMontoNegativo());
        nuevoMovimiento.setConceptoMovimiento(movimientoDinero.getConceptoMovimiento());
        nuevoMovimiento.setEmpleado(movimientoDinero.getEmpleado());
        this.RepositorioMovimientoDinero.save(nuevoMovimiento);
        return movimientoDinero;
    }


    public MovimientoDinero updateMovimiento(MovimientoDinero movimientoDinero) {
        Optional<MovimientoDinero> MovimientoUpdate = this.RepositorioMovimientoDinero.findById(movimientoDinero.getId());
        if (MovimientoUpdate.isPresent()) {
            MovimientoUpdate.get().setMontoDinero(movimientoDinero.getMontoDinero());
            MovimientoUpdate.get().setMontoPositivo(movimientoDinero.getMontoPositivo());
            MovimientoUpdate.get().setMontoNegativo(movimientoDinero.getMontoNegativo());
            MovimientoUpdate.get().setConceptoMovimiento(movimientoDinero.getConceptoMovimiento());
            MovimientoUpdate.get().setEmpleado(movimientoDinero.getEmpleado());
            this.RepositorioMovimientoDinero.save(MovimientoUpdate.get());
            return MovimientoUpdate.get();
        }
        return new MovimientoDinero();
    }


    public String deleteMovimiento(Long id) {
        RepositorioEmpresa.deleteById(id);
        return "Movimiento eliminado Exitosamente";
    }

    public MovimientoDinero patchMovimientoDinero(MovimientoDinero movimiento_param, Long id) throws Exception {
        try {
            MovimientoDinero movimientoBd = getMovimientoDinero(id);

            if(movimiento_param.getMontoDinero() != null){
                movimientoBd.setMontoDinero(movimiento_param.getMontoDinero());
            }
            if(movimiento_param.getMontoPositivo() != null){
                movimientoBd.setMontoPositivo(movimiento_param.getMontoPositivo());
            }
            if(movimiento_param.getMontoNegativo() != null){
                movimientoBd.setMontoNegativo(movimiento_param.getMontoNegativo());
            }
            if(movimiento_param.getConceptoMovimiento() != null){
                movimientoBd.setConceptoMovimiento(movimiento_param.getConceptoMovimiento());
            }
            if(movimiento_param.getEmpleado() != null){
                movimientoBd.setEmpleado(movimiento_param.getEmpleado());
            }

            return saveMovimiento(movimientoBd);

        } catch (Exception e) {
            throw new Exception("movimiento no se actualizo, porque no existe");
        }
    }


}