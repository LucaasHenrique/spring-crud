package br.com.Crud.Crud.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//DTO
public record RequestProduto(long id,
        @NotBlank
        String nome,
        @NotNull
        Integer preco_em_centavos) {
}
