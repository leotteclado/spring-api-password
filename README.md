#  PASSWORD - API REST

## Descrição 
  API de validação de senha.

  Uma senha válida precisa seguir os requisitos abaixo:
  * Nove ou mais caracteres
  * Ao menos 1 dígito
  * Ao menos 1 letra minúscula
  * Ao menos 1 letra maiúscula
  * Ao menos 1 caractere especial
  * Não possuir caracteres repetidos


API Retorna um objeto JSON com atributo **valid = false** e uma lista de erros para requisitos não conteplados ou com atributo **valid = true** e lista sem erros quando todos requisitos foram contemplados.

##### Exemplo: 

**Senha : password**

A senha é inválida e retorna o objeto abaixo:

      {
        "valid": false,
        "errors": [
        "at least one number",
        "at least one special character",
        "at least one uppercase letter",
        "repeated character",
        "less than 9 digit"
        ]
      }

**Senha : P@s5word1**

A senha é válida e retorna o objeto abaixo:

      {
        "valid": true,
        "errors": []
      }




## Requisitos
  * Java 8
  * Maven 
    
## Executando aplicação

  ##### DEV 
    mvnw spring-boot:run -Dspring.profiles.active=dev

  ##### PROD 
    mvnw spring-boot:run -Dspring.profiles.active=prod


## Testando aplicação

  ##### DEV 
  http://localhost:8090/api/password/validation/

  ##### PROD 
  http://localhost/api/password/validation/

  * Method: POST
  * Raw
  * Content-Type: application/json

   #### JSON entrada:

    {
      "password": "password"
    }


## Executando Testes Unitários
    mvn test


### SOLUÇÃO JAVA

### Framework
* Spring Boot

### Documentação da API REST

#### Swagger 
  ##### DEV profile
  http://localhost:8090/api/swagger-ui.html

  ##### PROD profile
  http://localhost/api/swagger-ui.html

### Design Patterns Utilizados
* Strategy

### Alguns Principios 
* Testes de unidade 
* Abstração, acoplamento, extensibilidade e coesão
* Design de API
* Clean Code
* SOLID


