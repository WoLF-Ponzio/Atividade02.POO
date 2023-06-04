package br.espm.atividade.Atividade02;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Livro {
    @Id
    @JsonProperty("id_livro")
    String id_livro;
    @JsonProperty("nome_livro")
    String nome_livro;
    @JsonProperty("autor_livro")
    String autor_livro;
    @JsonProperty("editora_livro")
    String editora_livro;
    @JsonProperty("ano_livro")
    int ano_livro;
    @JsonProperty("preco_livro")
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