package com.example.Yerizk.controllers;

import com.example.Yerizk.model.Empleado;
import com.example.Yerizk.model.MovimientoDinero;
import com.example.Yerizk.services.EmpleadoService;
import com.example.Yerizk.services.EmpresaService;
import com.example.Yerizk.services.UsuarioServicio;
import com.example.Yerizk.services.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistroControlador {

    @Autowired
    private UsuarioServicio servicio;

    @Autowired
    EmpresaService empresaService;

    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/login")
    public String iniciarSesion()
    {
        return "login";
    }

    @GetMapping("/")
    public String verPaginaDeInicio(Model modelo) {
        //modelo.addAttribute("usuarios", servicio.listarUsuarios());
        return "index";
    }


    @GetMapping("/movimientos")
    public String getMovements(Model modelo){
        modelo.addAttribute("movements", empresaService.ListarMovimientos());
        return "movimientos";
    }

    @GetMapping("/crearmovimiento")
    public String getCrearMovimiento(Model modelo){
        modelo.addAttribute("nuevoMovimiento",new MovimientoDinero());
        modelo.addAttribute("empleados",empleadoService.ListarEmpleados());
        return "crearmovimiento";
    }


    @PostMapping("/movimiento/front")
    public String postMovimiento(@ModelAttribute("nuevoMovimiento") MovimientoDinero movimientoDinero){
        empresaService.saveMovimiento(movimientoDinero);
        return "redirect:/movimientos";
    }



}