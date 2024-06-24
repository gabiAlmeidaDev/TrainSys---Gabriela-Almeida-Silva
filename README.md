# **Projeto TrainSys**

## **Descrição do Projeto**
   TrainSys é uma API RESTful desenvolvida para gerenciar treinamentos em academias. A aplicação permite que instrutores cadastrem e gerenciem alunos, exercícios e treinos, além de fornecer uma visão geral dos dados através de um dashboard.

## **Técnicas e Linguagens Utilizadas**
   - **Java 21**
   - **Spring Boot 3.3.0**
     - Spring Data JPA
     - Spring Security
     - Spring Web
     - Spring Boot DevTools
     - Spring Boot Actuator
   - **PostgreSQL**
   - **Maven**
   - **Lombok**
   - **Docker**

## **Escopo do Projeto**
   O projeto TrainSys tem como objetivo fornecer uma API para o gerenciamento de academias, permitindo:
   - Cadastro e autenticação de usuários.
   - Cadastro, listagem e deleção de exercícios.
   - Cadastro, listagem e deleção de estudantes.
   - Cadastro, listagem e deleção de treinos.
   - Dashboard com visão geral dos dados.

## **Como Executar o Sistema**

### Pré-requisitos
   - Docker
   - JDK 21
   - Maven
   - PostgreSQL

### Passo a Passo

1. **Clone o repositório do projeto**
   ```bash
   git clone https://github.com/seu-usuario/TrainSys.git
   cd TrainSys

2. **Configuração do Banco de Dados**

   - Certifique-se de que o Docker está instalado e em execução.
   - Execute o comando abaixo para iniciar um contêiner PostgreSQL:
   
   ```bash
   docker run --name postgres-trainsys -e POSTGRES_PASSWORD=academia -e POSTGRES_DB=trainsys -p 5432:5432 -d postgres

3. **Configuração do arquivo `application.properties`**

   - Abra o arquivo src/main/resources/application.properties e configure conforme necessário:

   ```properties

   spring.application.name=TrainSys

   # Configuração do PostgreSQL
   spring.datasource.url=jdbc:postgresql://localhost:5432/trainsys
   spring.datasource.username=postgres
   spring.datasource.password=academia
   spring.datasource.driver-class-name=org.postgresql.Driver

   # Configuração do JPA e Hibernate
   spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.format_sql=true

   # Configuração adicional para logar todas as SQL queries
   logging.level.org.hibernate.SQL=DEBUG
   logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
   logging.level.org.springframework.security=DEBUG

   # Actuator Configuration
   management.endpoints.web.exposure.include=*

   # Configuração para carregar o data.sql
   spring.datasource.initialization-mode=always

   server.port=8080

4. **Compilar e Executar a Aplicação**

   - Navegue até o diretório raiz do projeto e execute o comando Maven para compilar o projeto:

   ```bash
   mvn clean install

  - Após a compilação, execute o seguinte comando para iniciar a aplicação:

     ```bash
     mvn spring-boot:run

**Testar a API**

   - Utilize o Postman ou outra ferramenta similar para testar os endpoints da API.

### **Testar a API com Postman**

  Configurar e Enviar Requisições
      
   1. Abrir o Postman:

      - Inicie o Postman no seu computador.

   2. Criar uma Nova Requisição:

      - Clique em `New`no canto superior esquerdo.
      - Selecione `Request`.

   3. Configurar a Requisição de Cadastro de Usuário:

      - Nomeie a requisição como `Register User`.
      - Defina o método HTTP como POST e a URL como `http://localhost:8080/api/users`.
      - Vá para a aba `Body` e selecione `raw` e `JSON` no menu suspenso.
      - Adicione o seguinte payload JSON:
   
            {
              "name": "Gabriela Almeida Silva",
              "email": "gabriela_silva33@estudante.sesisenai.org.br",
              "password": "password123",
              "cpf": "111.222.333-44",
              "dateOfBirth": "1986-05-14",
              "planId": 1
            }
  
  - Clique em `Send` para enviar a requisição.
     
   5. Criar uma Nova Requisição para Listagem de Estudantes:

      - Nomeie a requisição como `List Students`.
      - Defina o método HTTP como `GET` e a URL como `http://localhost:8080/api/students`.
      - Clique em `Send` para enviar a requisição e ver a lista de estudantes.

   6. Criar uma Nova Requisição para Cadastro de Exercícios:

      - Nomeie a requisição como `Register Exercise`.
      - Defina o método HTTP como `POST` e a URL como `http://localhost:8080/api/exercises`.
      - Vá para a aba `Body` e selecione `raw` e `JSON` no menu suspenso.
      - Adicione o seguinte payload JSON:
     
             {
                "description": "Supino Reto",
                "user": {
                "id": 1
                }
            }
     
      - Clique em Send para enviar a requisição.

   7. Criar uma Nova Requisição para Listagem de Treinos por Estudante:

      - Nomeie a requisição como `List Workouts by Student`.
      - Defina o método HTTP como `GET` e a URL como `http://localhost:8080/api/students/1/workouts`.
      - Clique em `Send` para enviar a requisição e ver a lista de treinos do estudante com ID 1.

# **Conclusão**

   O TrainSys é uma solução robusta para o gerenciamento de academias, utilizando as tecnologias mais modernas do ecossistema Java e Spring. Através desta documentação, você pode configurar e executar a aplicação em seu ambiente local para começar a gerenciar seus próprios dados de treino e alunos.





   
   

      

      
   

   
