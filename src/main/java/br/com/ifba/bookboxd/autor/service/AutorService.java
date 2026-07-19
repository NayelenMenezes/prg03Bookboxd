package br.com.ifba.bookboxd.autor.service;

import br.com.ifba.bookboxd.autor.entity.Autor;
import br.com.ifba.bookboxd.livro.entity.Livro;
import br.com.ifba.bookboxd.infrastruture.util.StringUtil;
import br.com.ifba.bookboxd.autor.repository.AutorRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AutorService implements AutorIService{
    private final AutorRepository autorRepository;
    
    private void validarAutor(Autor autor) {
        if(autor == null) {
            throw new RuntimeException("Dados do Autor não preenchidos");
        }
        if(autor.getPessoa() == null) {
            throw new RuntimeException("O Autor precisa estar vinculado a uma Pessoa");
        }
        if(StringUtil.isEmpty(autor.getNacionalidade())) {
            throw new RuntimeException("A nacionalidade do Autor é obrigatória");
        }
    }

    private void validarId(Long id) {
        if (!StringUtil.isIdValido(id)) {
            throw new RuntimeException("Id inválido");
        }
    }
    
    @Override
    public Autor save(Autor autor) {
        validarAutor(autor);
        
        if(autor.getId() != null){
            throw new RuntimeException("Autor já existe no banco de dados");
        }
        
        log.info("Salvando autor: {}", autor.getPessoa().getNome());
        return autorRepository.save(autor);
    }
    
    @Override
    public Autor update(Autor autor) {
        validarAutor(autor);
        validarId(autor.getId());
        
        if(!autorRepository.existsById(autor.getId())){
            throw new RuntimeException("Autor não encontrado com id: " + autor.getId());
        }
        
        log.info("Atualizando autor: {}", autor.getPessoa().getNome());
        return autorRepository.save(autor);
    }
    
    @Override
    @Transactional(readOnly = true)
        public Optional<Autor> findById(Long id) {
            validarId(id);
        log.info("Buscando autor por ID: {}", id);
        Optional<Autor> autor = autorRepository.findById(id);

        if (autor.isEmpty()) {
            throw new RuntimeException("Autor não encontrado com id: " + id);
        }

        inicializarLivrosEAvaliacoes(autor.get());
        return autor;
    }

    @Override
    public void delete(Long id) {
        validarId(id);

        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado com id: " + id));

        if (autor.contarLivrosPublicados() > 0) {
            throw new RuntimeException(
                "Não é possível deletar este autor: ele possui " + autor.contarLivrosPublicados() +
                " livro(s) cadastrado(s). Delete ou reatribua os livros primeiro.");
        }

        log.info("Deletando autor com ID: {}", id);
        autorRepository.deleteById(id);
    }

    @Override
    public List<Autor> findAll() {
        log.info("Listando todos os autores");
        List<Autor> autores = autorRepository.findAll();

        if (autores.isEmpty()) {
            throw new RuntimeException("Nenhum autor cadastrado");
        }
        autores.forEach(a -> Hibernate.initialize(a.getLivros()));
        return autores;
    }

    @Override
    public List<Autor> findByNacionalide(String nacionalidade) {
        if(StringUtil.isEmpty(nacionalidade)){
            throw new RuntimeException("Nacionalidade para busca não pode tá vazia");
        }
        log.info("Buscando autor pela nacionalidade: {}", nacionalidade);
        List<Autor> autores = autorRepository.findByNacionalidade(nacionalidade);
        
        if(autores.isEmpty()){
            throw new RuntimeException("Nanhum autor encontrado com a nacionalidade: " + nacionalidade);
        }
        return autores;
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Autor> findByNomePessoa(String nome) {
        if (StringUtil.isEmpty(nome)) {
            throw new RuntimeException("Nome para busca não pode ser vazio");
        }

        log.info("Buscando autor pelo nome: {}", nome);
        List<Autor> autores = autorRepository.findByPessoaNomeContainingIgnoreCase(nome);

        if (autores.isEmpty()) {
            throw new RuntimeException("Nenhum autor encontrado com o nome: " + nome);
        }

        autores.forEach(a -> Hibernate.initialize(a.getLivros()));
        return autores;
    }

    @Override
    public void adicionarLivro(Long autorId, Livro livro) {
        validarId(autorId);
        
        if(livro == null){
            throw new RuntimeException("Dados do livro não preenchidos");
        }
        if(StringUtil.isEmpty(livro.getTitulo())){
            throw new RuntimeException("Título do livro é obrigatório");
        }
        
        Autor autor = autorRepository.findById(autorId)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado com id: " + autorId));
        
        log.info("Adicionando livro '{}' ao autor ID: {}", livro.getTitulo(), autorId);
        autor.adicionarLivro(livro);
        autorRepository.save(autor);
    }

    @Override
    public int contarLivrosPublicados(Long autorId) {
        validarId(autorId);
        log.info("Contando livros publicados do autor ID: {}", autorId);
        return autorRepository.findById(autorId).map(Autor::contarLivrosPublicados)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado com id: " + autorId));
    }  
    
    private void inicializarLivrosEAvaliacoes(Autor autor) {
        Hibernate.initialize(autor.getLivros());
        autor.getLivros().forEach(livro -> Hibernate.initialize(livro.getAvaliacoes()));
    }
}
