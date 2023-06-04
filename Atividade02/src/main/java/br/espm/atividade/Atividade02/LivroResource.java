package br.espm.atividade.Atividade02;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroResource {
    private LivroRepository livroRepository;

    public void LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping
    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    //@GetMapping
    //public Livro listarLivrosByAutor(String autor) {
    //   return livroRepository.findByAutor(autor);
    //}
    //@GetMapping
    //public Livro listarLivrosByTitulo(String titulo) {
    //   return livroRepository.findByTitulo(titulo);
    //}
    //@GetMapping
    //public Livro listarLivrosByAutorTitulo(String autor, String titulo) {
    //   return livroRepository.findByAutorTitulo(autor, titulo);
    //}
    @PostMapping
    public Livro adicionarLivro(@RequestBody Livro livro) {
        return livroRepository.save(livro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable UUID id, @RequestBody Livro livroAtualizado) {
        Livro livroExistente = livroRepository.findById(id).orElse(null);

        if (livroExistente == null) {
            return ResponseEntity.notFound().build();
        }

        livroExistente.setTitulo(livroAtualizado.getTitulo());
        livroExistente.setAutor(livroAtualizado.getAutor());
        livroExistente.setEditora(livroAtualizado.getEditora());
        livroExistente.setAno(livroAtualizado.getAno());
        livroExistente.setPreco(livroAtualizado.getPreco());

        livroAtualizado = livroRepository.save(livroExistente);
        return ResponseEntity.ok(livroAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerLivro(@PathVariable UUID id) {
        livroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}