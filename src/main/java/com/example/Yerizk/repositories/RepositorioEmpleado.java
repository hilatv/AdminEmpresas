package com.example.Yerizk.repositories;

import com.example.Yerizk.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEmpleado extends JpaRepository<Empleado,Long>
{

}
