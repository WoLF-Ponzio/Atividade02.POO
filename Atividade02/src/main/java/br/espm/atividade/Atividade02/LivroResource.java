package br.espm.atividade.Atividade02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/livros")
public class LivroResource {

    private LivroService livroService;

    @Autowired
    public LivroResource(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping()
    public List<Livro> listarLivros(@RequestParam(name = "nome", defaultValue = "") String nome) {
        return livroService.listarLivros();
    }

    @GetMapping("/buscar/{id}")
    public Livro dadosLivro(@PathVariable("id") String id) {
        return livroService.dadosLivro(id);
    }

    @Query("/buscar")
    public ResponseEntity<List<Livro>> buscarNomeAutor(@Param("busca") String busca) {
        List<Livro> livrosEncontrados = livroService.buscarNomeAutor(busca);

        if (!livrosEncontrados.isEmpty()) {
            return ResponseEntity.ok(livrosEncontrados);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/post")
    public Livro adicionarLivro(@RequestBody Livro livro) {
        return livroService.novoLivro(livro);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> atualizarLivro(@RequestBody Livro livro, @PathVariable String id) {
        livroService.atualizarLivro(id, livro);
        return ResponseEntity.ok("Recurso atualizado com sucesso");
    }
    
    @DeleteMapping("/{id}")
    public void deleteLivro(@PathVariable("id") String id) {
        livroService.deletar(id);
    }
}