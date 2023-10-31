# Gerenciamento Tributário

## Descrição

O projeto **Gerenciamento Tributário** é uma aplicação que oferece soluções para o gerenciamento de questões tributárias. Ele é construído em Java com o framework Spring Boot e usa o banco de dados H2. O projeto segue a arquitetura Modelo-Visão-Controlador (MVC) para facilitar o desenvolvimento e a manutenção.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Banco de Dados H2
- Arquitetura MVC

## Como Rodar

Para executar o projeto em sua máquina local, siga estas etapas:

1. Clone o repositório: https://github.com/Gzanella1/Gerenciamento-Tributario.git
2. Abra o arquivo.
3. Execute a aplicação.
4. Use o Postman ou qualquer outra ferramenta para interagir com os endpoints.


### Endpoints e Urls

A aplicação disponibiliza os seguintes endpoints para interagir com os recursos:

1. Cadastro do Contribuinte
   - URL: `http://localhost:8080/contribuinte`
   - Método: POST
   - Corpo da Requisição:
     ```json
     {
       "codigoContribuinte": "456789",
       "cpf": "19412345677",
       "nome": "pedro",
       "telefone": "47999354040",
       "email": "pedro@gmail.com"
     }
     ```
     ```json
     {
       "codigoContribuinte": "723687",
       "cpf": "19412345677",
       "nome": "giovani",
       "telefone": "47999444997",
       "email": "giovani@gmail.com"
     }
     ```

2. Cadastro de Imóvel
   - URL: `http://localhost:8080/imovel`
   - Método: POST
   - Corpo da Requisição:
     ```json
     {
       "codigoImovel": 50550,
       "dataInscricao": "2023-08-02T15:00:00",
       "proprietario": {
         "codigoContribuinte": "456789"
       },
       "area": 100.0,
       "valorVenal": 100000.0,
       "tipoImovel": "CONDOMINIO"
     }
     ```

3. Cadastro de Tributos do Tipo IPTU
   - URL: `http://localhost:8080/tributos/iptu`
   - Método: POST
   - Corpo da Requisição:
     ```json
     {
       "dataLancamento": "2023-08-02T15:00:00",
       "valor": "40",
       "imovel": {
         "codigoImovel": 50550
       },
       "anoCompetencia": "2001"
     }
     ```

4. Cadastro de Tributos do Tipo ITBI
   - URL: `http://localhost:8080/tributos/itbi`
   - Método: POST
   - Corpo da Requisição:
     ```json
     {
       "dataLancamento": "2023-08-02T15:00:00",
       "valor": "40",
       "imovel": {
         "codigoImovel": 50550
       },
       "dataTransferencia": "2023-08-02T15:00:00",
       "proprietarioAtual": {
         "codigoContribuinte": "456789"
       },
       "novoProprietario": {
         "codigoContribuinte": "723687"
       }
     }
     ```

5. Retorno de Todos os Imóveis ordenado pelo codigo
   - URL: `http://localhost:8080/imovel/todos`
   - Método: GET

6. Retorno dos Imóveis de um Determinado Contribuinte, passando o seu codigo como parametro
   - URL: `http://localhost:8080/imovel/busca?codigoContribuinte=456789`
   - Método: GET

7. Retorno dos tributos do tipo IPTU
    - URL: `http://localhost:8080/tributos/iptu`
    - Método: GET

7. Retorno dos tributos do tipo ITBI
    - URL: `http://localhost:8080/tributos/itbi`
    - Método: GET


Certifique-se de utilizar o Postman ou qualquer outra ferramenta de teste de API para interagir com os endpoints e acessar as funcionalidades da aplicação.





## Como Acessar o H2

Para visualizar os dados armazenados no banco de dados H2, siga estas etapas:

1. Após iniciar o aplicativo, acesse o H2 Console no seu navegador:http://localhost:8080/h2/
2. Certifique-se de usar as configurações corretas no H2 Console:
- Driver Class: `org.h2.Driver`
- JDBC URL: `jdbc:h2:mem:publica`
- Username: `root`
- Password: (deixe em branco)

o banco de dados H2 é usado para fins de desenvolvimento e teste, e os dados não são persistentes.























































