async function listLivros() {
    try {
        const response = await fetch('http://localhost:8080/livros', {
            method: "GET",
            headers: {
                "Content-Type": "application/json"
            }
        });
        const result = await response.json();
        var lista = document.getElementById('lista');
        lista.innerHTML = '';
        result.forEach(livroModel => {
            var linha = document.createElement('tr');

            var id = document.createElement('td');
            id.innerHTML = '<a href="javascript:detaillivroModel(\'' + livroModel.id_livro + '\');">' + livroModel.id_livro + '</a>';
            linha.appendChild(id);

            var titulo = document.createElement('td');
            titulo.innerHTML = livroModel.nome_livro;
            linha.appendChild(titulo);

            var autor = document.createElement('td');
            autor.innerHTML = livroModel.autor_livro;
            linha.appendChild(autor);

            var editora = document.createElement('td');
            editora.innerHTML = livroModel.editora_livro;
            linha.appendChild(editora);

            var ano = document.createElement('td');
            ano.innerHTML = livroModel.ano_livro;
            linha.appendChild(ano);

            var preco = document.createElement('td');
            preco.innerHTML = livroModel.preco_livro;
            linha.appendChild(preco);


            var acoes = document.createElement('td');
            acoes.innerHTML = '<button onClick="deletelivroModel(\'' + livroModel.id_livro + '\');">x</button>';
            linha.appendChild(acoes);

            lista.appendChild(linha);
        });
    } catch (error) {
        console.error("Error:", error);
    }
}

const uuidv4 = () => {
    return ([1e7]+-1e3+-4e3+-8e3+-1e11).replace(/[018]/g, c =>
        (c ^ crypto.getRandomValues(new Uint8Array(1))[0] & 15 >> c / 4).toString(16)
    );
}