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
   - **Thymeleaf**

## **Escopo do Projeto**
   O projeto TrainSys tem como objetivo fornecer uma API para o gerenciamento de academias, permitindo:
   
  ## Funcionalidades

- Cadastro, listagem, atualização e remoção de usuários
- Cadastro, listagem, atualização e remoção de estudantes
- Cadastro, listagem, atualização e remoção de exercícios
- Cadastro, listagem, atualização e remoção de treinos
- Autenticação e autorização de usuários
- Dashboard com dados agregados de usuários, estudantes e planos

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

A aplicação estará disponível em http://localhost:8080.

**Testar a API**

   - Utilize o Postman ou outra ferramenta similar para testar os endpoints da API.

## **Endpoints**

### **Usuários**

   - `POST /api/users` - Cadastro de usuário
   - `GET /api/users` - Listagem de usuários
    
### **Estudantes**

   - `POST /api/students` - Cadastro de estudante
   - `GET /api/students` - Listagem de estudantes
   - `PUT /api/students/{id}` - Atualização de estudante
   - `DELETE /api/students/{id}` - Remoção de estudante
     
### **Exercícios**

   - `POST /api/exercises` - Cadastro de exercício
   - `GET /api/exercises` - Listagem de exercícios
   - `PUT /api/exercises/{id}` - Atualização de exercício
   - `DELETE /api/exercises/{id}` - Remoção de exercício

### **Treinos**

   - `POST /api/workouts` - Cadastro de treino
   - `GET /api/workouts/students/{id}/workouts` - Listagem de treinos por estudante
   - `PUT /api/workouts/{id}` - Atualização de treino
   - `DELETE /api/workouts/{id}` - Remoção de treino

### **Login**

   - `POST /api/login` - Autenticação de usuário

### **Dashboard**

   - `GET /api/dashboard` - Dados agregados de usuários, estudantes e planos
    
## **Estrutura do Projeto**

      src/
      ├── main/
      │   ├── java/
      │   │   └── com/
      │   │       └── GabrielaAlmeidaSilva/
      │   │           └── TrainSys/
      │   │               ├── Config/
      │   │               ├── Controller/
      │   │               ├── DTO/
      │   │               ├── Entities/
      │   │               ├── Repository/
      │   │               ├── Service/
      │   │               └── TrainSysApplication.java
      │   └── resources/
      │       ├── static/
      │       │   └── css/
      │       │       └── style.css
      │       ├── templates/
      │       │   └── index.html
      │       ├── application.properties
      │       └── data.sql
      └── test/
          └── java/
              └── com/
                  └── GabrielaAlmeidaSilva/
                      └── TrainSys/


# **Conclusão**

   O TrainSys é uma solução robusta para o gerenciamento de academias, utilizando as tecnologias mais modernas do ecossistema Java e Spring. Através desta documentação, você pode configurar e executar a aplicação em seu ambiente local para começar a gerenciar seus próprios dados de treino e alunos.


### **Contribuindo**
  Contribuições são bem-vindas! Por favor, abra um pull request ou reporte um issue no GitHub.
      
### **Licença**
Este projeto está licenciado sob a Licença MIT - veja o arquivo LICENSE para mais detalhes.

Autora • Desenvolvido por Gabriela Almeida Silva

   
   

      

      
   

   
