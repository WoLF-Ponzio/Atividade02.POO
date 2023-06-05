package br.espm.atividade.Atividade02;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/livros")
public class LivroResource {
    private LivroRepository livroRepository;

    @Autowired
    public LivroService livroService;

    public void LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping()
    public List<Livro> listarLivros(@RequestParam(name = "nome", defaultValue = "") String nome) {
        return livroService.listarLivros();
    }

    @GetMapping("/livros/buscar")
    public ResponseEntity<List<Livro>> buscarLivrosPorTitulo(@RequestParam String titulo) {
        List<Livro> livrosEncontrados = livroService.buscarLivrosPorTitulo(titulo);

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
    

}