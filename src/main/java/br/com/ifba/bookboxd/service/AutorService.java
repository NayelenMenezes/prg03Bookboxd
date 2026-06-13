package br.com.ifba.bookboxd.service;

import br.com.ifba.bookboxd.entity.Autor;
import br.com.ifba.bookboxd.repository.AutorRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AutorService implements AutorIService{
    private final AutorRepository autorRepository;
    
    @Override
    public Autor save(Autor autor) {
        log.info("Salvando autor: {}", autor.getPessoa().getNome());
        return autorRepository.save(autor);
    }

    @Override
    public Optional<Autor> findById(Long id) {
        log.info("Buscando autor por ID: {}", id);
        return autorRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.info("Deletando autor com ID: {}", id);
        autorRepository.deleteById(id);
    }

    @Override
    public List<Autor> findAll() {
        log.info("Listando todos os autores");
        return autorRepository.findAll();
    }

    @Override
    public List<Autor> findByNacionalide(String nacionalidade) {
        log.info("Buscando autor pela nacionalidade: {}", nacionalidade);
        return autorRepository.findByNacionalidade(nacionalidade);
    }
    
}
