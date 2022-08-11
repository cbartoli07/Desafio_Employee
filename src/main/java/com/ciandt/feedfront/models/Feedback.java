package com.ciandt.feedfront.models;

import java.time.LocalDate;

public class Feedback {
    private String id;
    private LocalDate data;
    private Employee autor;
    private Employee proprietario;
    private String descricao;
    private String arquivo;
    private String oqueMelhora;
    private String comoMelhora;

    public Feedback(String id, LocalDate data, Employee autor, Employee proprietario, String descricao, String arquivo) {
        this.id = id;
        this.data = data;
        this.autor = autor;
        this.proprietario = proprietario;
        this.descricao = descricao;
        this.arquivo = arquivo;
    }

    public Feedback(String id, LocalDate data, Employee autor, Employee proprietario, String descricao, String arquivo, String oqueMelhora, String comoMelhora) {
        this.id = id;
        this.data = data;
        this.autor = autor;
        this.proprietario = proprietario;
        this.descricao = descricao;
        this.arquivo = arquivo;
        this.oqueMelhora = oqueMelhora;
        this.comoMelhora = comoMelhora;
    }
}
