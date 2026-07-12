package br.com.ifba.bookboxd.listaleitura.service;

import br.com.ifba.bookboxd.infrastruture.util.StringUtil;
import br.com.ifba.bookboxd.listaleitra.entity.ListaLeitura;
import br.com.ifba.bookboxd.livro.entity.Livro;
import br.com.ifba.bookboxd.listaleitura.repository.ListaLeituraRepository;
import br.com.ifba.bookboxd.livro.repository.LivroRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ListaLeituraService implements ListaLeituraIService{
    private final ListaLeituraRepository listaLeituraRepository;
    private final LivroRepository livroRepository;
    
    private void validarLista(ListaLeitura lista){
        if(lista == null){
            throw new RuntimeException("Dados da lista não preenchidos");
        }
        if(StringUtil.isEmpty(lista.getNomeLista())){
            throw new RuntimeException("O nome da lista é obrigatório");
        }
        if(lista.getUsuario() == null){
            throw new RuntimeException("A lista precisa estar vinculada a um Usuario");
        }
    }
    
    private void validarId(Long id) {
        if (!StringUtil.isIdValido(id)) {
            throw new RuntimeException("Id inválido");
        }
    }
    
    @Override
    public ListaLeitura save(ListaLeitura lista) {
        validarLista(lista);
        
        if (lista.getId() != null) {
            throw new RuntimeException("Lista já existe no banco de dados");
        }
        log.info("Salvando lista: {}", lista.getNomeLista());
        return listaLeituraRepository.save(lista);
    }
    
    @Override
    public ListaLeitura update(ListaLeitura lista) {
        validarLista(lista);
        validarId(lista.getId());
        
        if (!listaLeituraRepository.existsById(lista.getId())) {
            throw new RuntimeException("Lista não encontrada com id: " + lista.getId());
        }
        log.info("Atualizando lista: {}", lista.getNomeLista());
        return listaLeituraRepository.save(lista);
    }
    
    @Override
    public Optional<ListaLeitura> findById(Long id) {
        validarId(id);
        
        log.info("Buscando lista por ID: {}", id);
        Optional<ListaLeitura> lista = listaLeituraRepository.findById(id);
        if (lista.isEmpty()) {
            throw new RuntimeException("Lista não encontrada com id: " + id);
        }
        return lista;
    }

    @Override
    public void delete(Long id) {
        validarId(id);

        if (!listaLeituraRepository.existsById(id)) {
            throw new RuntimeException("Lista não encontrada com id: " + id);
        }

        log.info("Deletando lista com ID: {}", id);
        listaLeituraRepository.deleteById(id);
    }

    @Override
    public List<ListaLeitura> findAll() {
        log.info("Listando todas as listas de leitura");
        List<ListaLeitura> listas = listaLeituraRepository.findAll();

        if (listas.isEmpty()) {
            throw new RuntimeException("Nenhuma lista de leitura cadastrada");
        }
        return listas;
    }

    @Override
    public List<ListaLeitura> findByUsuarioId(Long usuarioId) {
        validarId(usuarioId);
        log.info("Buscando listas do usuário ID: {}", usuarioId);
        List<ListaLeitura> listas = listaLeituraRepository.findByUsuarioId(usuarioId);

        if (listas.isEmpty()) {
            throw new RuntimeException("Nenhuma lista encontrada para o usuário id: " + usuarioId);
        }
        return listas;
    }

    @Override
    public void adicionarLivro(Long listaId, Long livroId) {
        validarId(listaId);
        validarId(livroId);
        
        ListaLeitura lista = listaLeituraRepository.findById(listaId)
                .orElseThrow(() -> new RuntimeException("Lista não encontrada com id: " + listaId));

        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com id: " + livroId));
        
        log.info("Adicionando livro '{}' à lista ID: {}", livro.getTitulo(), listaId);
        lista.adicionarLivro(livro);
        listaLeituraRepository.save(lista);
    }

    @Override
    public void removerLivro(Long listaId, Long livroId) {
        validarId(listaId);
        validarId(livroId);

        ListaLeitura lista = listaLeituraRepository.findById(listaId)
                .orElseThrow(() -> new RuntimeException("Lista não encontrada com id: " + listaId));

        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com id: " + livroId));

        log.info("Removendo livro '{}' da lista ID: {}", livro.getTitulo(), listaId);
        lista.removerLivro(livro);
        listaLeituraRepository.save(lista);
    }

    @Override
    public void esvaziarLista(Long listaId) {
        validarId(listaId);

        ListaLeitura lista = listaLeituraRepository.findById(listaId)
                .orElseThrow(() -> new RuntimeException("Lista não encontrada com id: " + listaId));

        log.info("Esvaziando lista ID: {}", listaId);
        lista.esvaziarLista();
        listaLeituraRepository.save(lista);
    }
    
}
