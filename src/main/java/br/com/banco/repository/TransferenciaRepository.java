package br.com.banco.repository;

import br.com.banco.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    public Optional<Transferencia> findByDataTransferencia(LocalDateTime localDateTime);
    public Optional<Transferencia> findByNomeOperadorTransacao(String nomeOperadorTransacao);



}
