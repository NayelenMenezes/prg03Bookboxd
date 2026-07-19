package br.com.ifba.bookboxd.usuario.repository;

import br.com.ifba.bookboxd.usuario.entity.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByEmail(String email);
    
    boolean existsByEmail(String email);
    
    Optional<Usuario> findByPessoaId(Long pessoaId);
    
    List<Usuario> findByPessoaNomeContainingIgnoreCase(String nome);
    
    Optional<Usuario> findByEmailContainingIgnoreCase(String email);
}
