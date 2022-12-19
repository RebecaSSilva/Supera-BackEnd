package br.com.banco.controller;

import br.com.banco.model.Conta;
import br.com.banco.model.Transferencia;
import br.com.banco.service.ContaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/conta")
public class ContaController {

    public ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @GetMapping
    public List<Conta> findAll(){
        return contaService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getContaById(@PathVariable Long id){

        Optional<Conta> contaOptional = contaService.findById(id);

        if(contaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(contaOptional.get());
    }

    @PostMapping
    public ResponseEntity<Object> saveContas(@RequestBody Conta conta){
        return ResponseEntity.status(HttpStatus.OK).body(conta);
    }


}
