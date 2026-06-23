package br.com.ifba.bookboxd.service;

import br.com.ifba.bookboxd.entity.Pessoa;
import br.com.ifba.bookboxd.repository.PessoaRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PessoaService implements PessoaIService{

    private final PessoaRepository pessoaRepository;
    
    @Override
    public Pessoa save(Pessoa pessoa) {
        log.info("Salvando pessoa: {}", pessoa.getNome());
        return pessoaRepository.save(pessoa);
    }

    @Override
    public Optional<Pessoa> findById(Long id) {
        log.info("Buscando pessoa por ID: {}", id);
        return pessoaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.info("Deletando pessoa com ID: {}", id);
        pessoaRepository.deleteById(id);
    }

    @Override
    public List<Pessoa> findAll() {
        log.info("Listando todas as pessoas");
        return pessoaRepository.findAll();
    }

    @Override
    public List<Pessoa> findByNome(String nome) {
        log.info("Buscando pessoa pelo nome: {}", nome);
        return pessoaRepository.findByNomeContainingIgnoreCase(nome);
    }

    @Override
    public int obterIdade(Long pessoaId) {
        log.info("Obtendo idade da pessoa id: {}", pessoaId);
        return pessoaRepository.findById(pessoaId).map(Pessoa::obterIdade).orElse(0);
    }

    @Override
    public String exibirPerfil(Long pessoaId) {
        log.info("Exibindo perfil da pessoa Id: {}", pessoaId);
        return pessoaRepository.findById(pessoaId).map(Pessoa::exibirPerfil).orElse("Pessoa não encontrada.");    
    }
    
}
