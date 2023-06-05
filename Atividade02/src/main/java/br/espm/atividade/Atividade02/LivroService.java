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

    public Livro dadosLivro(String id) {
        return livroRepository.findById(id)
            .map(l -> new Livro(l.id_livro, l.nome_livro, l.autor_livro, l.editora_livro, l.ano_livro, l.preco_livro))
            .orElse(null);
    }   

    public List<Livro> buscarNomeAutor(String titulo){
        List<Livro> livros = new ArrayList<>();
        List<Livro> busca = new ArrayList<>();
            livroRepository.findAll().forEach(l -> livros.add(l));
            for (Livro livro : livros) {
                if (livro.nome_livro.contains(titulo) || livro.autor_livro.contains(titulo)) {
                    busca.add(livro);
                    break;
                }
            }
        return busca;
    }

    public void deletar(String id) {
        livroRepository.deleteById(id);
    }

    public Livro novoLivro(Livro livro) {
        LivroModel livModel = new LivroModel(livro);
        return livroRepository.save(livModel.newLiv());
    }

    public void atualizarLivro(String id, Livro livro) {
        livroRepository.findById(id).map(update -> {
            update.nome_livro = livro.nome_livro;
            update.autor_livro = livro.autor_livro;
            update.editora_livro = livro.editora_livro;
            update.ano_livro = livro.ano_livro;
            update.preco_livro = livro.preco_livro;
            return livroRepository.save(update);
        });
        
        
    }

}
