package br.com.futurodev.primeiraapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pedido")
@SequenceGenerator(name= "seq_pedido", sequenceName = "seq_pedido", allocationSize = 1, initialValue = 1)
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pedido")
    private Long id;

    private LocalDateTime dataHoraCadastro = LocalDateTime.now();

    private LocalDateTime dataHoraAlteracao;

    @OneToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "id")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "idFormaPagamento", referencedColumnName = "id")
    private FormaPagamento formaPagamento;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itens = new ArrayList<>();
    @JsonBackReference
    public List<ItemPedido> getItens() {
        return itens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return id.equals(pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(LocalDateTime dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public LocalDateTime getDataHoraAlteracao() {
        return dataHoraAlteracao;
    }

    public void setDataHoraAlteracao(LocalDateTime dataHoraAlteracao) {
        this.dataHoraAlteracao = dataHoraAlteracao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
}
