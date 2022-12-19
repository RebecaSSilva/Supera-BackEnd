package br.com.banco.controller;

import br.com.banco.model.Transferencia;
import br.com.banco.service.TransferenciaService;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaController {

    final TransferenciaService transferenciaService;

    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @GetMapping
    public ResponseEntity<List<Transferencia>> getAllTransferencia(){
        return ResponseEntity.status(HttpStatus.OK).body(transferenciaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTransferenciaById(@PathVariable Long id){

        Optional<Transferencia> transferenciaOptional = transferenciaService.findById(id);

        if(transferenciaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(transferenciaOptional.get());

    }

    @PostMapping()
    public ResponseEntity<Object> saveTransferencias(@RequestBody Transferencia transferencia){
        transferencia.setDataTransferencia(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.OK).body(transferenciaService.save(transferencia));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTransferencia(@PathVariable Long id){
        Optional<Transferencia> transferenciaOptional = transferenciaService.findById(id);

        if(transferenciaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado.");
        }
        transferenciaService.delete(transferenciaOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Excluído com sucesso.");

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTransferencia(@PathVariable Long id, @RequestBody Transferencia transferencia){
        Optional<Transferencia> transferenciaOptional = transferenciaService.findById(id);
        if (transferenciaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Não foi encontrado.");
        }
        Transferencia transferenciaModel = new Transferencia();
        BeanUtils.copyProperties(transferencia, transferenciaModel);
        transferenciaModel.setId(transferenciaOptional.get().getId());
        transferenciaModel.setDataTransferencia(transferenciaOptional.get().getDataTransferencia());
        return ResponseEntity.status(HttpStatus.OK).body(transferenciaService.save(transferenciaModel));
    }

    @GetMapping("/data")
    public ResponseEntity<Object> getTransferenciaByData(LocalDateTime localDateTime){

        Optional<Transferencia> transferenciaOptional = transferenciaService.findByDataTransferencia(localDateTime);

        if(transferenciaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(transferenciaOptional.get());

    }

    @GetMapping("/nome")
    public ResponseEntity<Object> getTransferenciaByNomeOperador(String nome){

        Optional<Transferencia> transferenciaOptional = transferenciaService.findByNomeOperadorTransacao(nome);

        if(transferenciaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(transferenciaOptional.get());

    }



}
