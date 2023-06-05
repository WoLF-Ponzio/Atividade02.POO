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
    String id_livro;

    @Column(name = "nome_livro")
    String nome_livro;

    @Column(name = "autor_livro")
    String autor_livro;

    @Column(name = "editora_livro")
    String editora_livro;

    @Column(name = "ano_livro")
    int ano_livro;

    @Column(name = "preco_livro")
    double preco_livro;

    public LivroModel(Livro livro){
        this.id_livro = livro.id_livro;
        this.autor_livro = livro.autor_livro;
        this.editora_livro = livro.editora_livro;
        this.ano_livro = livro.ano_livro;
        this.preco_livro = livro.preco_livro;
    }

    public Livro newLiv() {
        return new Livro(
            id_livro,
            nome_livro,
            autor_livro,
            editora_livro,
            ano_livro,
            preco_livro
        );
    }
    
}

