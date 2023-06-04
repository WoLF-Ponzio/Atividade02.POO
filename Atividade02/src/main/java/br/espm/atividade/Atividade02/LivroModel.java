package br.espm.atividade.Atividade02;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "livro")
public class LivroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_livro")
    private String id;

    @Column(name = "nome_livro")
    private String nome;

    @Column(name = "autor_livro")
    private String autor;

    @Column(name = "editora_livro")
    private String editora;

    @Column(name = "ano_livro")
    private int ano;

    @Column(name = "preco_livro")
    private double preco;

    public LivroModel(Livro newLivro) {
        this.id = newLivro.getId();
        this.nome = newLivro.getTitulo();
        this.autor = newLivro.getAutor();
        this.editora = newLivro.getEditora();
        this.ano = newLivro.getAno();
        this.preco = newLivro.getPreco();

    }

    public Livro Livro() {
        return new Livro(
            id,
            nome,
            autor,
            editora,
            ano,
            preco
        );
    }
    
}

