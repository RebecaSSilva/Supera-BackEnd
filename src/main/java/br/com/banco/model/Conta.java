package br.com.banco.model;

import javax.persistence.*;

@Entity
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Long id;
    private String nomeResponsavel;


    public Conta(){}

    public Conta(Long id) {
        this.id = id;
    }

    public Conta(Long id, String nomeResponsavel) {
        this.id = id;
        this.nomeResponsavel = nomeResponsavel;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }


}
