package br.com.Crud.Crud.domain.entity;

import br.com.Crud.Crud.domain.RequestProduto;
import jakarta.persistence.*;

@Table(name="produtos")
@Entity(name="produtos")
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private Integer preco_em_centavos;
    private Boolean active;

    public Produtos() {

    }

    public Produtos (RequestProduto requestProduto) {
        this.nome = requestProduto.nome();
        this.preco_em_centavos = requestProduto.preco_em_centavos();
        this.active = true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPreco_em_centavos() {
        return preco_em_centavos;
    }

    public void setPreco_em_centavos(Integer preco_em_centavos) {
        this.preco_em_centavos = preco_em_centavos;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
