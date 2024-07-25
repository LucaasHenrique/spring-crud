package br.com.Crud.Crud.domain.Repository;

import br.com.Crud.Crud.domain.entity.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
    List<Produtos> findAllByActiveTrue();
}
