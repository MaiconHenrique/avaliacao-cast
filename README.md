# avaliacao-cast-java

# avaliacao-cast-java

Api java spring-boot com JPA

## Banco de dados Postgresql

Criando as tabelas:

```sh
create table tb_categoria (
	codigo integer primary key,
	descricao varchar(100)
)

create table tb_curso (
	id integer primary key,
	assunto varchar(200),
	datainicio timestamp,
	datatermino timestamp,
	qtdalunos integer,
	codigo integer, 
	FOREIGN KEY (codigo) REFERENCES tb_categoria (codigo)
)
```

Inserindo dados fixos de categorias:

```sh
insert into tb_categoria (codigo, descricao)
values (1,'Comportamental')

insert into tb_categoria (codigo, descricao)
values (2,'Programação')

insert into tb_categoria (codigo, descricao)
values (3,'Qualidade')

insert into tb_categoria (codigo, descricao)
values (4,'Processos')
```
## Configure seu arquivo application.properties:
```sh
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true

spring.datasource.url= jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=adm
spring.jpa.hibernate.ddl-auto=update
```

Pronto! agora execute o projeto
