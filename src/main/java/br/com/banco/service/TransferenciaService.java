package br.com.banco.service;

import br.com.banco.model.Transferencia;
import br.com.banco.repository.TransferenciaRepository;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransferenciaService {

    public final TransferenciaRepository transferenciaRepository;

    public TransferenciaService(TransferenciaRepository transferenciaRepository) {
        this.transferenciaRepository = transferenciaRepository;
    }

    public List<Transferencia> findAll(){
        return transferenciaRepository.findAll();
    }

    public Optional<Transferencia> findById(Long id){
        return transferenciaRepository.findById(id);
    }

    public Optional<Transferencia> findByDataTransferencia(LocalDateTime localDateTime){
        return transferenciaRepository.findByDataTransferencia(localDateTime);
    }

    public Optional<Transferencia> findByNomeOperadorTransacao(String nome){
        return transferenciaRepository.findByNomeOperadorTransacao(nome);
    }


    @Transactional
    public Transferencia save(Transferencia transferencia){
        return transferenciaRepository.save(transferencia);
    }
    @Transactional
    public void delete(Transferencia transferencia){
        transferenciaRepository.delete(transferencia);
    }



}
