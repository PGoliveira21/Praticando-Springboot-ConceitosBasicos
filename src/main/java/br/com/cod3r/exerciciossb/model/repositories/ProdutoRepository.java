package br.com.cod3r.exerciciossb.model.repositories;

import br.com.cod3r.exerciciossb.model.entities.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer> {
    public Iterable<Produto> findByNomeContainingIgnoreCase(String partNome);

    @Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")// consulta usando uma query Sql
        public Iterable<Produto> searchByNameLike(@Param("nome")String nome);

}
