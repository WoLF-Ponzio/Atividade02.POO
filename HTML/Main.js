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

async function cadastrarLivro() {
    var livro = {
        "ID": uuidv4(),
        "Nome": document.getElementById('detail-nome_livro').value,
        "Autor": document.getElementById('detail-autor_livro').value,
        "Editora": document.getElementById('detail-editora_livro').value,
        "Ano": document.getElementById('detail-ano_livro').value,
        "Preço": document.getElementById('detail-preco_livro').value   
    }

    try {
        const response = await fetch('http://localhost:8080/livros/post', {
            method: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'            },
            body: JSON.stringify(livro)
        });
       listLivros();
    } catch (error) {
        console.error("Error:", error);
    }
}

async function explodirLivro(id) {
    try {
        const response = await fetch(`http://localhost:8080/livros/${id}`, {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json"
            }
        });
        listMoedas();
    } catch (error) {
        console.error("Error:", error);
    }
}

async function detailMoeda(id) {
    try {
        const result = await fetch(`http://localhost:8080/livros/${id}`, {
            method: "GET",
            headers: {
                "Content-Type": "application/json"
            }
        });
        var moeda = await result.json();
        document.getElementById('detail-id').value = moeda.id;
        document.getElementById('detail-nome').value = moeda.nome;
        document.getElementById('detail-sigla').value = moeda.sigla;
        document.getElementById('detail-simbolo').value = moeda.simbolo;
    } catch (error) {
        console.error("Error:", error);
    }
}

async function filterMoedas() {
    var filter = document.getElementById('id_livro').value.toString().trim();
    if (filter.length < 3) return;
    listLivros();
}

async function calvarLivro() {
    document.getElementById('detail-id_livro').value = '';
    document.getElementById('detail-nome_livro').value = '';
    document.getElementById('detail-autor_livro').value = '';
    document.getElementById('detail-editora_livro').value = '';
    document.getElementById('detail-ano_livro').value = '';
    document.getElementById('detail-preco_livro').value = '';
}

async function buscarLivro() {
    try{
        const result = await fetch(`http//localhost:8080/livros/buscar`, {
            method: "GET",
            headers: {
                "Content-Type": "application/json"
            }
        });
        var livrosPesq = await result.json();
        document.getElementById('detail-id_livro').value = livro.id;
        document.getElementById('detail-nome_livro').value = livro.nome;
        document.getElementById('detail-autor_livro').value = livro.autor;
        document.getElementById('detail-editora_livro').value = livro.editora;
        document.getElementById('detail-ano_livro').value = livro.ano;
        document.getElementById('detail-preco_livro').value = livro.preco;

    } catch (error) {
    console.error("Error:", error);
    }
}

