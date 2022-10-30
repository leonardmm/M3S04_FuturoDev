package br.com.futurodev.primeiraapi.repository;

import br.com.futurodev.primeiraapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {



}
