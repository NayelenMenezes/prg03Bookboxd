package br.com.ifba.bookboxd.repository;

import br.com.ifba.bookboxd.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByEmail(String email);
    
    boolean existsByEmail(String email);
    
    Optional<Usuario> findByPessoaId(Long pessoaId);
}
