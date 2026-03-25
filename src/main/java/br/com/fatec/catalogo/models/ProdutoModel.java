package br.com.fatec.catalogo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_PRODUTO")
public class ProdutoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProduto;

    @NotBlank(message = "O nome do produto é obrigatório.")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.")
    private String nome;

    @NotNull(message = "O valor é obrigatório.")
    @Positive(message = "O valor deve ser um número positivo.")
    private BigDecimal valor;

    // Construtores, Getters e Setters
    public ProdutoModel() {}

    public long getIdProduto() { return idProduto; }
    public void setIdProduto(long idProduto) { this.idProduto = idProduto; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }
}