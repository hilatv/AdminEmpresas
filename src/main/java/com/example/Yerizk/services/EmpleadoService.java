package com.example.Yerizk.services;

import com.example.Yerizk.dto.EmpresaDto;
import com.example.Yerizk.model.Empleado;
import com.example.Yerizk.repositories.RepositorioEmpleado;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    private final  RepositorioEmpleado RepositorioEmpleado;
    private Long id;

    public EmpleadoService(RepositorioEmpleado RepositorioEmpleado){
        this.RepositorioEmpleado=RepositorioEmpleado;
    }

    public List<Empleado> ListarEmpleados() {
        return this.RepositorioEmpleado.findAll();
    }

    public Empleado getEmpleado(Long id) throws Exception {
        Optional<Empleado> empleadoOptional = RepositorioEmpleado.findById(id);
        if(empleadoOptional.isPresent()){
            return empleadoOptional.get();
        }else{
            throw new Exception("Empleado No Existe");
        }
    }

    public Empleado saveEmpleado(Empleado empleado_param){
        return RepositorioEmpleado.save(empleado_param);
    }

    public Empleado putEmpleado(Empleado empleado_param){
        return RepositorioEmpleado.save(empleado_param);
    }

    public Empleado patchEmpleado(Empleado empleado_param, Long id) throws Exception {
        try {
            Empleado empleadoBd = getEmpleado(id);

            if(empleado_param.getNombre() != null){
                empleadoBd.setNombre(empleado_param.getNombre());
            }
            if(empleado_param.getCorreo() != null){
                empleadoBd.setCorreo(empleado_param.getCorreo());
            }
            if(empleado_param.getEmpresa() != null){
                empleadoBd.setEmpresa(empleado_param.getEmpresa());
            }
            if(empleado_param.getRol() != null){
                empleadoBd.setRol(empleado_param.getRol());
            }

            return saveEmpleado(empleadoBd);

        } catch (Exception e) {
            throw new Exception("Empleado no se actualizo, porque no existe");
        }
    }

    public String deleteEmpleado(Long id){
        RepositorioEmpleado.deleteById(id);
        return "Empleado eliminado Exitosamente";
    }

}









