# Instruções

### Criando o arquivo Jar
* Execute o comando na pasta raiz do projeto 

```mvn package```

* Executando o arquivo jar
Apois vá ate a parta target la voce deve abrir o terminal e executar o o comando

```java -jar cartoes-onibus-api-0.0.1-SNAPSHOT.jar --spring.datasource.username={user} --spring.datasource.password={senha}```

Onde ***{user}*** deve ser substistituido pelo usuario do seu banco de dados PostgreSQL,
e ***{senha}*** deve ser subistituida pela senha do seu banco de dados PostgreSQL

### Teste com Request
Para realizar testes de requisição o programa utilizado foi o insominia [Inominia](https://insomnia.rest/), voce pode baixar e importar o REQUESTS.json.
