package br.espm.atividade.Atividade02;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Livro {
    @Id
    private String id;
    private String titulo;
    private String autor;
    private String editora;
    private int ano;
    private double preco;

    public Livro(){

    }

    public Livro(String id, String titulo, String autor, String editora, int ano, double preco){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ano = ano;
        this.preco = preco;
    }

    public int getAno() {
        return ano;
    }
    public String getAutor() {
        return autor;
    }
    public String getEditora() {
        return editora;
    }
    public String getId() {
        return id;
    }
    public double getPreco() {
        return preco;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}