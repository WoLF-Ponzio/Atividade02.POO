package br.espm.atividade.Atividade02;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroResource {
    private LivroRepository livroRepository;

    @Autowired
    public LivroService livroService;

    public void LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping()
    public String listarLivros(@RequestParam(name = "nome", defaultValue = "") String nome) {
        return livroService.listarLivros().toString();
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

        livroExistente.id_livro = livroAtualizado.id_livro;
        livroExistente.autor_livro = livroAtualizado.autor_livro;
        livroExistente.editora_livro =livroAtualizado.editora_livro;
        livroExistente.ano_livro = livroAtualizado.ano_livro;
        livroExistente.preco_livro = livroAtualizado.preco_livro;

        livroAtualizado = livroRepository.save(livroExistente);
        return ResponseEntity.ok(livroAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerLivro(@PathVariable UUID id) {
        livroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}