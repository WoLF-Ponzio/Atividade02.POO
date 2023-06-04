package br.espm.atividade.Atividade02;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Livro {
    @Id
    String id_livro;
    String nome_livro;
    String autor_livro;
    String editora_livro;
    int ano_livro;
    double preco_livro;

    public Livro(){

    }

    public Livro(String id, String titulo, String autor, String editora, int ano, double preco){
        this.id_livro = id;
        this.nome_livro = titulo;
        this.autor_livro = autor;
        this.editora_livro = editora;
        this.ano_livro = ano;
        this.preco_livro = preco;
    }

   @Override
   public String toString() {
    String aux = "";
    aux += "nome: " + nome_livro + "\n";
    aux += "autor: " + autor_livro + "\n";
    aux += "editora: " + editora_livro + "\n";
    aux += "ano: " + ano_livro + "\n";
    aux += "preco: " + preco_livro + "\n";
    return aux;
   }
}