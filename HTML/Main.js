async function listarLivros() {
    try {
        const response = await fetch(`http://127.0.0.1:8080/livros`, {
            method: "GET",
            headers: {
                "Content-Type": "application/json"
            }
        });
        const result = await response.json();
        var lista = document.getElementById('texto');
        lista.innerHTML = '';
        result.forEach(Livro => {  
            lista += Livro.nome_livro;
        });
    } catch (error) {
        console.error("Error:", error);
    }
}