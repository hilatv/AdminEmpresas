package com.example.Yerizk.repositories;

import com.example.Yerizk.model.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioMovimientoDinero extends JpaRepository<MovimientoDinero,Long>
{

}
