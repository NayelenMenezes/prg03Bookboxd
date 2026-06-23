package br.com.ifba.bookboxd.service;

import br.com.ifba.bookboxd.entity.ListaLeitura;
import br.com.ifba.bookboxd.entity.Livro;
import br.com.ifba.bookboxd.repository.ListaLeituraRepository;
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
    
    @Override
    public ListaLeitura save(ListaLeitura lista) {
        log.info("Salvando lista: {}", lista.getNomeLista());
        return listaLeituraRepository.save(lista);
    }

    @Override
    public Optional<ListaLeitura> findById(Long id) {
        log.info("Buscando lista por ID: {}", id);
        return listaLeituraRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.info("Deletando lista com ID: {}", id);
        listaLeituraRepository.deleteById(id);
    }

    @Override
    public List<ListaLeitura> findAll() {
        log.info("Listando todas as listas de leitura");
        return listaLeituraRepository.findAll();
    }

    @Override
    public List<ListaLeitura> findByUsuarioId(Long usuarioId) {
        log.info("Buscando listas do usuário ID: {}", usuarioId);
        return listaLeituraRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public void adicionarLivro(Long listaId, Livro livro) {
        log.info("Adicionando livro '{}' à lista ID: {}", livro.getTitulo(), listaId);
        listaLeituraRepository.findById(listaId).ifPresent(lista -> {
            lista.adicionarLivro(livro);
            listaLeituraRepository.save(lista);
        });
    }

    @Override
    public void removerLivro(Long listaId, Livro livro) {
        log.info("Removendo livro '{}' da lista ID: {}", livro.getTitulo(), listaId);
        listaLeituraRepository.findById(listaId).ifPresent(lista -> {
            lista.removerLivro(livro);
            listaLeituraRepository.save(lista);
        });
    }

    @Override
    public void esvaziarLista(Long listaId) {
        log.info("Esvaziando lista ID: {}", listaId);
        listaLeituraRepository.findById(listaId).ifPresent(lista -> {
            lista.esvaziarLista();
            listaLeituraRepository.save(lista);
        });
    }
    
}
