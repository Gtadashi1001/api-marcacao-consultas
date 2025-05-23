package com.fiap.emr.api_marcacao_consultas.repository;
import com.fiap.emr.api_marcacao_consultas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}