package br.com.futurodev.primeiraapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "item_pedido")
@SequenceGenerator(name= "seq_item_pedido", sequenceName = "seq_item_pedido", allocationSize = 1, initialValue = 1)
public class ItemPedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_item_pedido")
    private Long id;

    @OneToOne
    @JoinColumn(name = "idProduto", referencedColumnName = "id")
    private Produto produto;

    private int quantidade;

    private double valorItem;

    @ManyToOne
    @JoinColumn(name = "pedido_id", referencedColumnName = "id")
    @JsonBackReference
    private Pedido pedido;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido that = (ItemPedido) o;
        return id.equals(that.id);
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorItem() {
        return valorItem;
    }

    public void setValorItem(double valorItem) {
        this.valorItem = valorItem;
    }

}
