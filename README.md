# Teste Sinqia

Este sistema é responsável por fazer o cadastro, validação de login e edição de perfil de um usuário.

## Requisitos

Para montar o ambiente do projeto é necessário:

* Java 8
* NodeJS
* Git
* Maven

## Configuração do Frontend

O frontend trabalha com o gerenciado de dependências 'npm'. Para configurar e iniciar o front, basta executar os comandos abaixo dentro da pasta **cliente-web**:

    $ npm install

Depois da instalação das dependências é necessário iniciar a aplicação frontend:

    $ npm start

O comando acima irá iniciar o servidor node na porta 4200. Para acessar a aplicação, basta acessar a url baixo:

    http://localhost:4200


## Configuração do Backend

Este projeto foi desenvolvido utilizando a arquitetura Spring Cloud para seu funcionamento basta rode o comando na pasta raiz do projeto:

    ./mvnw

## Configurações dos projetos nas IDEs

Este projeto é um projeto Maven. Com isso, o processo de configuração dele é o padrão de qualquer projeto maven.

Basta importar um novo projeto maven apontando para o pom parent localizado na raíz do projeto.

Os demais detalhes de configurações fica a critério de cada IDE utilizada.
