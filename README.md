Projeto CRUD de Produtos - Loja

Este projeto implementa um sistema CRUD (Create, Read, Update, Delete) para gerenciar produtos em uma loja fictícia. O sistema permite a adição, visualização, edição e exclusão de produtos, além de armazenar as informações no banco de dados MySQL.
Funcionalidades

    Cadastro de Produtos: Permite adicionar novos produtos com informações como nome, preço e descrição.
    Edição de Produtos: Permite editar os detalhes de produtos existentes.
    Exclusão de Produtos: Permite excluir produtos do sistema.
    Listagem de Produtos: Exibe uma lista de todos os produtos cadastrados, com a possibilidade de editar ou excluir cada um.

Tecnologias Utilizadas

    Java: A aplicação foi desenvolvida utilizando Java e servlets para a lógica do servidor.
    JSP (JavaServer Pages): Utilizado para a interface de usuário.
    MySQL: O banco de dados MySQL é utilizado para armazenar os dados dos produtos.
    Servlets: Utilizados para controlar a lógica de requisições de criação, leitura, atualização e exclusão de produtos.

Pré-requisitos

Antes de rodar o projeto, você precisará de um ambiente com o seguinte:

    MySQL instalado em sua máquina.
    Apache Tomcat ou outro servidor de servlet configurado para rodar a aplicação Java.
    IDE de Java (exemplo: IntelliJ IDEA, Eclipse, NetBeans).

Configuração do Banco de Dados

Para iniciar o projeto, é necessário configurar o banco de dados MySQL. Execute os seguintes comandos no MySQL para criar o banco de dados e a tabela de produtos:

-- Criação do banco de dados
CREATE DATABASE loja;

-- Criação da tabela de produtos
CREATE TABLE produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    descricao TEXT
);

Como Rodar o Projeto

    Clone este repositório em sua máquina:

    git clone https://github.com/seu-usuario/projeto-crud-produtos.git

    Configure o banco de dados MySQL conforme as instruções acima.

    Importe o projeto para sua IDE de preferência e configure o servidor (por exemplo, Apache Tomcat).

    Execute o projeto e acesse a aplicação pelo navegador.

Como Contribuir

Se você deseja contribuir para este projeto, siga os passos abaixo:

    Faça um fork deste repositório.
    Crie uma branch para a sua feature (git checkout -b minha-feature).
    Faça as mudanças e commit com uma mensagem clara (git commit -am 'Adiciona minha feature').
    Envie suas mudanças para o seu repositório (git push origin minha-feature).
    Abra um pull request explicando suas alterações.

Licença

Este projeto é licenciado sob a Licença MIT - veja o arquivo LICENSE para mais detalhes.
