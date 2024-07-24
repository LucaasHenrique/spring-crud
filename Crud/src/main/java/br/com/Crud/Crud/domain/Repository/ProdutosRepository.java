package br.com.Crud.Crud.domain.Repository;

import br.com.Crud.Crud.domain.entity.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
}
