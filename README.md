# Fórum API - Kotlin e Spring Boot

Projeto de API Rest desenvolvido durante a formação "Kotlin e Spring Boot" da Alura. O Spring Boot é atualmente o principal framework no ecossistema Java para o desenvolvimento de APIs Rest, e neste projeto ele é utilizado em conjunto com a linguagem Kotlin.

O objetivo do projeto é construir uma API Rest do zero, unindo a simplicidade da sintaxe do Kotlin com a robustez do ecossistema Spring, integrando ferramentas de persistência e infraestrutura até o deploy em ambiente cloud.

## O que foi implementado até agora

O projeto simula um fórum de dúvidas e discussões. A estrutura atual conta com as seguintes frentes:

- **Mapeamento de Entidades (JPA):** 
  - `Topic`: Tópicos e dúvidas criadas no fórum.
  - `Answer`: Respostas enviadas para os tópicos.
  - `Course`: Cursos e categorias do fórum.
  - `UserData`: Usuários da plataforma.
- **Controllers (Rotas REST):**
  - `TopicController`: Endpoints (`GET`, `POST`) para listar e registrar novos tópicos.
- **Padrão DTO e Mappers:** 
  - Separação clara de dados de entrada (`Request`) e saída (`View`).
  - Utilização de classes `Mapper` para converter entidades do banco de dados para os DTOs devolvidos na API.
- **Service Pattern:**
  - Camada de regras de negócio (`TopicService`) intermediando a comunicação entre o Controller e a interface do Repository.

## Tecnologias e Dependências

O projeto é gerenciado via **Maven** e o `pom.xml` conta com o seguinte ecossistema de dependências:

- **Kotlin** (Reflect, Stdlib e Jackson Module Kotlin para serialização de JSON)
- **Spring Boot**
  - **Spring Web MVC:** Para o desenvolvimento dos endpoints REST.
  - **Spring Data JPA:** Para persistência e comunicação com o banco de dados.
  - **Spring Validation:** Para validação de dados de entrada nos DTOs (como `@NotNull`, `@NotBlank`).
  - **Spring Boot DevTools:** Para hot-reload e facilidade no desenvolvimento local.
- **Banco de Dados e Migrations**
  - **MySQL:** Banco de dados relacional oficial do projeto.
  - **Flyway:** Para versionamento e execução das migrations do banco de dados.
  - **Docker:** Para conteinerização do banco MySQL localmente.

## Como rodar o projeto localmente

1. Certifique-se de ter o Java/JDK (versão 21) instalado em sua máquina.
2. Faça o clone do repositório.
3. Inicie o container do banco de dados MySQL via Docker.
4. Na raiz do projeto, execute o comando abaixo utilizando o Maven Wrapper para iniciar a aplicação:

No Windows:
```cmd
mvnw spring-boot:run
```

No Linux/Mac:
```bash
./mvnw spring-boot:run
```
