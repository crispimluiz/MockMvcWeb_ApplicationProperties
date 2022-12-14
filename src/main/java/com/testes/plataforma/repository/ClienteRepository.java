package com.testes.plataforma.repository;

import com.testes.plataforma.model.ClienteModel;
import com.testes.plataforma.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
}
