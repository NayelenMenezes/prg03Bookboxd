package br.com.ifba.bookboxd.controller;

import br.com.ifba.bookboxd.entity.ListaLeitura;
import br.com.ifba.bookboxd.entity.Livro;
import br.com.ifba.bookboxd.service.ListaLeituraIService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ListaLeituraController implements ListaLeituraIController{
    private final ListaLeituraIService listaLeituraService;

    @Override
    public ListaLeitura save(ListaLeitura lista) {
        log.info("Controller: salvando lista: {}", lista.getNomeLista());
        return listaLeituraService.save(lista);
    }

    @Override
    public Optional<ListaLeitura> findById(Long id) {
        log.info("Controller: buscando lista por ID: {}", id);
        return listaLeituraService.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.info("Controller: deletando lista ID: {}", id);
        listaLeituraService.delete(id);
    }

    @Override
    public List<ListaLeitura> findAll() {
        log.info("Controller: listando todas as listas");
        return listaLeituraService.findAll();
    }

    @Override
    public List<ListaLeitura> findByUsuarioId(Long usuarioId) {
        log.info("Controller: buscando listas do usuário ID: {}", usuarioId);
        return listaLeituraService.findByUsuarioId(usuarioId);
    }

    @Override
    public void adicionarLivro(Long listaId, Livro livro) {
        log.info("Controller: adicionando livro à lista ID: {}", listaId);
        listaLeituraService.adicionarLivro(listaId, livro);
    }

    @Override
    public void removerLivro(Long listaId, Livro livro) {
        log.info("Controller: removendo livro da lista ID: {}", listaId);
        listaLeituraService.removerLivro(listaId, livro);
    }

    @Override
    public void esvaziarLista(Long listaId) {
        log.info("Controller: esvaziando lista ID: {}", listaId);
        listaLeituraService.esvaziarLista(listaId);
    }
}
