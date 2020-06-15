# Codata Seed Spring Boot API

Projeto Seed para aplicação Spring Boot API.

## Configuração da aplicação

O projeto é configurado através das seguintes variáveis de ambiente:

Variável          | Descrição                 | Exemplo
----------------- | ------------------------- | -----------------------------------
DATABASE_URL      | Url jdbc da base de dados | jdbc:postgresql://127.0.0.1:5432/db
DATABASE_USERNAME | Usuário da base de dados  | postgres
DATABASE_PASSWORD | Senha da base de dados    | postgres

Qualquer IDE moderna é capaz de configurar variáveis de ambiente.

O projeto utiliza o recurso de perfis do Spring, sendo configurado através da
variável de ambiente `SPRING_PROFILES_ACTIVE`:

```
SPRING_PROFILES_ACTIVE=dev
```

A variável de ambiente `SPRING_PROFILES_ACTIVE` configura o perfil `dev`
da aplicação, que configura o acesso à base de dados da seguinte forma:

```shell script
DATABASE_URL=jdbc:postgresql://localhost:5432/application
DATABASE_USERNAME=postgres
DATABASE_PASSWORD=postgres
```

### Schema da base de dados

O projeto utiliza o `flyway` para automaticamente criar e atualizar o schema
da base de dados atraves de script SQL localizados em `src/main/resource/db/migrations`.

O `flyway` é habilitado apenas quando executado com o perfil `dev`, sendo
desabilitado em produção.

## Executando o projeto

Para executar no terminal:

- Linux / MacOS / FreeBSD
```shell script
SPRING_PROFILES_ACTIVE=dev ./mvnw spring-boot:run
```

- Windows Powershell
```powershell
$Env:SPRING_PROFILES_ACTIVE=dev
cmd /c 'mvnw.cmd spring-boot:run'
```

A aplicação escutará em `http://localhost:8080`

Para configurar cada variável sem utilizar `SPRING_PROFILES_ACTIVE`:

- Linux / MacOS / FreeBSD:
```shell script
export DATABASE_URL=jdbc:postgresl://localhost:5432/application \
    DATABASE_USERNAME=postgres \
    DATABASE_PASSWORD=postgres

./mvnw spring-boot:run
```

- Windows Powershell
```powershell
$Env:DATABASE_URL='jdbc:postgresql://localhost:5432/db'
$Env:DATABASE_USERNAME='postgres'
$Env:DATABASE_PASSWORD='postgres'

cmd /c 'mvnw.cmd spring-boot:run'
```

### Utilizando docker-compose

Também é possível executar o projeto usando [docker-compose](https://docs.docker.com/compose/):

```shell script
docker-compose up
```

## Conteúdo do projeto 

Há um exemplo de implementação de duas classes modelo, `ExampleModel` e
`ExampleRelatedModel`, juntamente com classes repositório, service e controller.

É criada automaticamente a documentação swagger dos controllers
que pode ser acessada em `http://localhost:8080/swagger-ui.html`