package Modelos;

import java.time.LocalDate;

public class Empregado {
        private Long id;
        private String nome;
        private String email;
        private String tipo;
        private String status;
        private LocalDate data;

    @Override
    public String toString() {
        return id + " -- " + nome +" -- " + email + " -- " + tipo + " -- " + status +" -- " + data;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
