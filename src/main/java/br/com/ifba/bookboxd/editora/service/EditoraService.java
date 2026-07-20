package br.com.ifba.bookboxd.editora.service;

import br.com.ifba.bookboxd.editora.entity.Editora;
import br.com.ifba.bookboxd.livro.entity.Livro;
import br.com.ifba.bookboxd.editora.repository.EditoraRepository;
import br.com.ifba.bookboxd.infrastruture.util.StringUtil;
import br.com.ifba.bookboxd.livro.repository.LivroRepository;
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
public class EditoraService implements EditoraIService{

    private final EditoraRepository editoraRepository;
    private final LivroRepository livroRepository;
    
    private void validarEditora(Editora editora){
        if(editora == null){
            throw new RuntimeException("Dados de editora não preenchidos");
        }
        if(StringUtil.isEmpty(editora.getNome())){
            throw new RuntimeException("Nome da editora é obrigatório");
        }
        if(StringUtil.isEmpty(editora.getSite())){
            throw new RuntimeException("Site da editora é obrigatório");
        }
    }
    
    private void validarId(Long id){
        if(!StringUtil.isIdValido(id)){
            throw new RuntimeException("id inválido");
        }
    }
    
    @Override
    public Editora save(Editora editora) {
        validarEditora(editora);
        
        if(editora.getId() != null){
            throw new RuntimeException("Editora já existe no banco de dados");
        }
        
        log.info("Salvando editora: {}", editora.getNome());
        return editoraRepository.save(editora);
    }

    @Override
    public Editora update(Editora editora) {
        validarEditora(editora);
        validarId(editora.getId());
        
        if(!editoraRepository.existsById(editora.getId())){
            throw new RuntimeException("Editora não encontrada com id: " + editora.getId());
        }
        
        log.info("Atualizando editora: {}", editora.getNome());
        return editoraRepository.save(editora);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Editora> findById(Long id) {
        validarId(id);
        log.info("Buscando editora por ID: {}", id);
        Optional<Editora> editora = editoraRepository.findById(id);

        if (editora.isEmpty()) {
            throw new RuntimeException("Editora não encontrada com id: " + id);
        }

        Hibernate.initialize(editora.get().getLivros());
        editora.get().getLivros().forEach(l -> Hibernate.initialize(l.getAvaliacoes()));

        return editora;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        validarId(id);
        
        Editora editora = editoraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Editora não encontrada com id: " + id));
        
        if(!editora.getLivros().isEmpty()){
            log.info("Desvinculando {} livro(s) da editora ID: {} antes de excluir", editora.getLivros().size(), id);
            for(Livro livro : editora.getLivros()){
                livro.setEditora(null);
                livroRepository.save(livro);
            }
        }
        
        log.info("Deletando editora com ID: {}", id);
        editoraRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Editora> findAll() {
        log.info("Listando todas as editoras");
        List<Editora> editoras = editoraRepository.findAll();
        
        if(editoras.isEmpty()){
            throw new RuntimeException("Nenhuma editora cadastrada");
        }
        editoras.forEach(e -> Hibernate.initialize(e.getLivros()));
        return editoras;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Editora> findByNome(String nome) {
        if(StringUtil.isEmpty(nome)){
            throw new RuntimeException("Nome para busca não pdode ser vazio");
        }
        log.info("Buscando editoras pelo nome: {}", nome);
        List<Editora> editoras = editoraRepository.findByNomeContainingIgnoreCase(nome);
        
        if(editoras.isEmpty()){
            throw new RuntimeException("Nenhuma editora encontrada com o nome: " + nome);
        }
        
        editoras.forEach(e -> Hibernate.initialize(e.getLivros()));
        return editoras;
    }

    @Override
    public void atualizarDadosContato(Long editoraId, String novoSite) {
        validarId(editoraId);
        
        if(StringUtil.isEmpty(novoSite)){
            throw new RuntimeException("Dados do site não preenchidos");
        }
        Editora editora = editoraRepository.findById(editoraId)
                .orElseThrow(() -> new RuntimeException("editora não encontrada com id: " + editoraId));
        
        log.info("Adicionando site '{}' da editora ID: {}", novoSite, editoraId);
        editora.atualizarDadosContato(novoSite);
        editoraRepository.save(editora);
    }
    
    //adiciona novos livros a editora
    @Override
    @Transactional
    public void adicionarLivro(Long editoraId, Long livroId) {
        validarId(editoraId);
        
        if(!StringUtil.isIdValido(livroId)){
            throw new RuntimeException("id do livro inválido");
        }
        
        Editora editora = editoraRepository.findById(editoraId)
                .orElseThrow(() -> new RuntimeException("editora não encontrada com id: " + editoraId));
        
        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com id: " + livroId));
        
        log.info("Adicionando livro '{}' a editora ID: {}", livro.getTitulo(), editoraId);
        editora.adicionarLivro(livro);
        editoraRepository.save(editora);
    }
}
