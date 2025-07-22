# desafio-alura-musicas

![Spring Boot](https://img.shields.io/badge/Spring_Boot-v3.5.3-brightgreen)
![Java](https://img.shields.io/badge/Java-17-orange)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-14-blue)
![Hibernate](https://img.shields.io/badge/Hibernate-6.6.18-red)

---

## Descrição

Projeto desenvolvido em Java com Spring Boot para gerenciar um catálogo de músicas e artistas via linha de comando (CLI). Implementa funcionalidades essenciais de CRUD, com persistência em banco de dados PostgreSQL usando Spring Data JPA e Hibernate.

Esse desafio foi proposto pelas instrutoras Iasmin Araújo e Jacqueline Oliveira no curso de Java: persistência de dados e consultas com Spring Data JPA na plataforma ALURA.
---

## Funcionalidades

* **Gerenciamento de Artistas**

  * Listar todos os artistas cadastrados
  * Adicionar novos artistas
  * Deletar artistas (com tratamento para evitar violação de integridade referencial)

* **Gerenciamento de Músicas**

  * Listar todas as músicas cadastradas
  * Salvar novas músicas vinculadas a artistas
  * Procurar músicas pelo ID
  * Deletar músicas individualmente ou em grupo

* **Relacionamento entre Entidades**

  * Artista possui várias músicas (`OneToMany`)
  * Ao deletar um artista, suas músicas associadas são corretamente tratadas para evitar erros de chave estrangeira

* **Tratamento de Exceções e Integridade**

  * Erros de integridade referencial tratados e reportados ao usuário
  * Uso de transações para garantir consistência ao deletar dados

---

## Tecnologias Utilizadas

* Java 17
* Spring Boot 3.5.3
* Spring Data JPA (Hibernate 6.6.18)
* PostgreSQL 14
* Maven para gerenciamento de dependências
* Hibernate ORM para mapeamento objeto-relacional

---

## Estrutura do Projeto

* `domain/` — Entidades JPA (`Artist`, `Music`)
* `repository/` — Interfaces de repositório Spring Data JPA
* `service/` — Serviços com lógica de negócio e transações
* `controller/` — Controladores para orquestrar operações entre a camada de serviço e a interface CLI
* `view/` — Classe principal de interação com o usuário via terminal
* `resources/application.properties` — Configurações do banco e Spring Boot

---

## Como Rodar o Projeto

1. Clone o repositório:

```bash
git clone https://github.com/victor-jesus/desafio-alura-musicas.git
cd desafio-alura-musicas
```

2. Configure o banco PostgreSQL e atualize as credenciais no `application.properties`.

3. Compile e execute:

```bash
mvn clean package
java -jar target/desafio-alura-musicas.jar
```

4. Siga o menu no terminal para gerenciar artistas e músicas.

---

## Exemplos de Uso

```
---- ScreenMusics ----

1 - Salvar musica
2 - Procurar musicas
3 - Deletar musicas
4 - Salvar artista
5 - Listar artistas
6 - Deletar Artista
7 - Listar todas as musicas

0 - Sair
```

Ao escolher, por exemplo, `6`, o sistema lista artistas e permite deletar selecionando os IDs, garantindo que não haja erros de chave estrangeira.

---

## FIM
