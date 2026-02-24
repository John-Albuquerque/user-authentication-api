README — User Authentication API
🚀 Sobre o projeto

A User Authentication API é uma API REST que está sendo desenvolvida em Java com o objetivo de gerenciar autenticação e autorização de usuários utilizando JWT (JSON Web Token).

O projeto foi criado com foco em boas práticas de desenvolvimento backend, organização em camadas e segurança de aplicações.

🛠️ Tecnologias utilizadas

Java 17+

Spring Boot

Spring Security

Spring Data JPA

JWT (JSON Web Token)

Maven


📂 Estrutura do projeto

A aplicação segue uma arquitetura em camadas:

controller -> service -> repository -> entity

controller: recebe as requisições HTTP

service: contém as regras de negócio

repository: comunicação com o banco de dados

entity: representação das tabelas no banco

dto: transferência de dados entre camadas

security: configuração do JWT e autenticação

🔐 Funcionalidades

Cadastro de usuários

Login de usuário

Geração de token JWT

Autenticação via token

Proteção de rotas

Criptografia de senha com BCrypt

🔑 Autenticação

A autenticação é feita utilizando JWT:

O usuário faz login com email e senha

A API valida os dados

Um token JWT é gerado

O cliente deve enviar o token no header:

Authorization: Bearer {token}
📌 Endpoints principais
📍 Cadastro de usuário
POST /auth/register

Body:

{
    "email": "jonathan@gmail.com",
    "login": "jhon",
    "name": "Jonathan",
    "senha": "1234"
}
📍 Login
POST /auth/login

Body:

{
  "login": "jhon",
  "senha": "1234"
}

Resposta:

{
  "token": "jwt_token_aqui"
}
📍 Rota protegida 

Header:

Authorization: Bearer {token}
⚙️ Configuração
🔧 application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco
spring.datasource.username=root
spring.datasource.password=sua_senha

projeto.jwtSecret=sua_chave_secreta

chave liberada para testes: VGhpc0lzQVN1cGVyU2VjdXJlSldUU2VjcmV0S2V5Rm9ySFNBNTEyQW5kTXVzdEJlTG9uZ0Vub3VnaA==

projeto.jwtExpirationMs=86400000

▶️ Como rodar o projeto

Clone o repositório:

git clone https://github.com/seu-usuario/user-authentication-api.git

Entre na pasta:

cd user-authentication-api

Execute o projeto:

./mvnw spring-boot:run

Ou rode pela sua IDE.

📌 Melhorias futuras

Refresh Token

Controle de roles (ADMIN / USER)

Documentação com Swagger

Testes automatizados

Deploy na nuvem (AWS / Render)

👨‍💻 Autor

Desenvolvido por mim 
Focado em backend com Java e construção de APIs seguras.

💡 Observações

Este projeto foi desenvolvido com fins de estudo e prática de:

Autenticação segura

Boas práticas com Spring

Arquitetura em camadas

Integração com banco de dados (em andamento)
