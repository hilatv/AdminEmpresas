package com.example.Yerizk.repositories;

import com.example.Yerizk.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioEmpresa extends JpaRepository<Empresa,Long>
{

}
