package br.com.banco.service;

import br.com.banco.model.Conta;
import br.com.banco.repository.ContaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ContaService {

    public final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public List<Conta> findAll(){
        return contaRepository.findAll();
    }

    public Optional<Conta> findById(Long id){
        return contaRepository.findById(id);
    }
    public Conta save(Conta conta){
        return contaRepository.save(conta);
    }


}
