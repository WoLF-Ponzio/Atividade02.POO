package br.espm.atividade.Atividade02;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, UUID> {
    //Livro findByAutor(String autor);
    //Livro findByTitulo(String titulo);
    //Livro findByAutorTitulo(String autor, String titulo);

}
