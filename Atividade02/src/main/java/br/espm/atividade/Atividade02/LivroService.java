package br.espm.atividade.Atividade02;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> listarLivros() {
        List<Livro> livros = new ArrayList<>();
            livroRepository.findAll().forEach(l -> livros.add(new Livro(l.id_livro,l.nome_livro,l.autor_livro,l.editora_livro,l.ano_livro,l.preco_livro)));
        return livros;
    }
}
