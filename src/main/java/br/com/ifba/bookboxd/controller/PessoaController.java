package br.com.ifba.bookboxd.controller;

import br.com.ifba.bookboxd.entity.Pessoa;
import br.com.ifba.bookboxd.service.PessoaIService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PessoaController implements PessoaIController{
    private final PessoaIService pessoaService;

    @Override
    public Pessoa save(Pessoa pessoa) {
        log.info("Controller: salvando pessoa: {}", pessoa.getNome());
        return pessoaService.save(pessoa);
    }

    @Override
    public Optional<Pessoa> findById(Long id) {
        log.info("Controller: buscando pessoa por ID: {}", id);
        return pessoaService.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.info("Controller: deletando pessoa com ID: {}", id);
        pessoaService.delete(id);
    }

    @Override
    public List<Pessoa> findAll() {
        log.info("Controller: listando todas as pessoas");
        return pessoaService.findAll();
    }

    @Override
    public List<Pessoa> findByNome(String nome) {
        log.info("Controller: buscando pessoas pelo nome: {}", nome);
        return pessoaService.findByNome(nome);
    }

    @Override
    public int obterIdade(Long pessoaId) {
        log.info("Controller: obtendo idade da pessoa Id: {}", pessoaId);
        return pessoaService.obterIdade(pessoaId);
    }

    @Override
    public String exibPerfil(Long pessoaId) {
        log.info("Controller: exibindo perfil pessoa ID: {}", pessoaId);
        return pessoaService.exibirPerfil(pessoaId);
    }
}
