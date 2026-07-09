package br.com.ifba.bookboxd.pessoa.service;

import br.com.ifba.bookboxd.pessoa.service.PessoaIService;
import br.com.ifba.bookboxd.pessoa.entity.Pessoa;
import br.com.ifba.bookboxd.infrastruture.util.StringUtil;
import br.com.ifba.bookboxd.pessoa.repository.PessoaRepository;
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
    
    private void validarPessoa(Pessoa pessoa){
        if (pessoa == null){
            throw new RuntimeException("Dados da Pessoa não preenchidos");
        }
        if (StringUtil.isEmpty(pessoa.getNome())){
            throw new RuntimeException("Nome da pessoa é obrigatóriio");
        }
        if(StringUtil.isDataNascimentoValida(pessoa.getDataNascimento())){
            throw new RuntimeException("Data de nascimento inválida ou não informda");
        }
    }
    
    private void validarId(Long id){
        if (!StringUtil.isIdValido(id)){
            throw new RuntimeException("Id inválido");
        }
    }
    
    @Override
    public Pessoa save(Pessoa pessoa) {
        validarPessoa(pessoa);
        if(pessoa.getId() != null){
            throw new RuntimeException("Pessoa já existe no banco de dados");
        }
        log.info("Salvando pessoa: {}", pessoa.getNome());
        return pessoaRepository.save(pessoa);
    }
      
    @Override
    public Optional<Pessoa> findById(Long id) {
        validarId(id);
        
        log.info("Buscando pessoa por ID: {}", id);
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        
        if(pessoa.isEmpty()){
            throw new RuntimeException("Pessoa não encontrada com id: " + id);
        }
        return pessoa;
    }

    @Override
    public void delete(Long id) {
        validarId(id);
        
        if(!pessoaRepository.existsById(id)){
            throw new RuntimeException("Pessoa não econtrada com id: " + id);
        }
        
        log.info("Deletando pessoa com ID: {}", id);
        pessoaRepository.deleteById(id);
    }

    @Override
    public List<Pessoa> findAll() {
        log.info("Listando todas as pessoas");
        List<Pessoa> pessoas = pessoaRepository.findAll();
        
        if(pessoas.isEmpty()){
            throw new RuntimeException("Nenhuma pessoa cadastrada");
        }
        
        return pessoas;
    }

    @Override
    public List<Pessoa> findByNome(String nome) {
        if(StringUtil.isEmpty(nome)){
            throw new RuntimeException("Nome para busca não pode ser vazio");
        }
      
        log.info("Buscando pessoa pelo nome: {}", nome);
        List<Pessoa> pessoas = pessoaRepository.findByNomeContainingIgnoreCase(nome);
        
        if(pessoas.isEmpty()){
            throw new RuntimeException("Nenhuma pessoa encontrada com o nome: " + nome);
        }
        
        return pessoas;
    }

    @Override
    public int obterIdade(Long pessoaId) {
        validarId(pessoaId);
        log.info("Obtendo idade da pessoa id: {}", pessoaId);
        return pessoaRepository.findById(pessoaId).map(Pessoa::obterIdade)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com id: " + pessoaId));
    }

    @Override
    public String exibirPerfil(Long pessoaId) {
        validarId(pessoaId);
        log.info("Exibindo perfil da pessoa Id: {}", pessoaId);
        return pessoaRepository.findById(pessoaId).map(Pessoa::exibirPerfil)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com id: " + pessoaId));
    }

   
} 
