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
        try{
            log.info("Controller: salvando pessoa: {}", pessoa.getNome());
            return pessoaService.save(pessoa);
        } catch(RuntimeException e){
            log.error("Controller: erro ao salvar pessoa - {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public Optional<Pessoa> findById(Long id) {
        try{
            log.info("Controller: buscando pessoa por ID: {}", id);
            return pessoaService.findById(id);
        } catch(RuntimeException e) {
            log.error("Controller: erro ao buscar pessoa por id {} - {}", id, e.getMessage());
            throw e;
        } 
    }

    @Override
    public void delete(Long id) {
        try {
            log.info("Controller: deletando pessoa com ID: {}", id);
            pessoaService.delete(id);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao deletar pessoa id {} - {}", id, e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Pessoa> findAll() {
        try {
            log.info("Controller: listando todas as pessoas");
            return pessoaService.findAll();
        } catch (RuntimeException e) {
            log.error("Controller: erro ao listar pessoas - {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Pessoa> findByNome(String nome) {
        try {
            log.info("Controller: buscando pessoas pelo nome: {}", nome);
            return pessoaService.findByNome(nome);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao buscar pessoas pelo nome {} - {}", nome, e.getMessage());
            throw e;
        }
    }

    @Override
    public int obterIdade(Long pessoaId) {
        try {
            log.info("Controller: obtendo idade da pessoa Id: {}", pessoaId);
            return pessoaService.obterIdade(pessoaId);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao obter idade da pessoa id {} - {}", pessoaId, e.getMessage());
            throw e;
        }
    }

    @Override
    public String exibPerfil(Long pessoaId) {
        try {
            log.info("Controller: exibindo perfil pessoa ID: {}", pessoaId);
            return pessoaService.exibirPerfil(pessoaId);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao exibir perfil da pessoa id {} - {}", pessoaId, e.getMessage());
            throw e;
        }
    }
}
