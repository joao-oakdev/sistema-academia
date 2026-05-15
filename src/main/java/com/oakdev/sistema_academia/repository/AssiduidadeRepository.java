package com.oakdev.sistema_academia.repository;

import com.oakdev.sistema_academia.model.Assiduidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssiduidadeRepository extends JpaRepository<Assiduidade, Long> {
}
