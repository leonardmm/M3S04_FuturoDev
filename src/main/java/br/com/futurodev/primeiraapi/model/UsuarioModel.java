package br.com.futurodev.primeiraapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.swing.plaf.metal.MetalIconFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(unique = true)
    private String login;

    @Column(unique = true)
    private String senha;

    private String nome;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<TelefoneModel> telefones = new ArrayList<TelefoneModel>();
    @JsonManagedReference
    public List<TelefoneModel> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<TelefoneModel> telefones) {
        this.telefones = telefones;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioModel that = (UsuarioModel) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
