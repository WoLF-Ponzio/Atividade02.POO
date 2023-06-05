package br.espm.atividade.Atividade02;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, String> {
    @Query("SELECT * FROM Livro WHERE nome_livro LIKE %:busca% OR autor_livro LIKE %:busca%")
    List<Livro> buscarPorTermo(@Param("busca") String busca);
}
