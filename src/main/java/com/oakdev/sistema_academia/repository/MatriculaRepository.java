package com.oakdev.sistema_academia.repository;

import com.oakdev.sistema_academia.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
