Dupla: Vinícius Cunha e Pedro Felipe

Imagine que você decidiu ir ver um filme no cinema hoje. Algumas coisas não mudaram desde a criação deste entretenimento: você vai comprar o ingresso e assistir ao filme. O que mudou é a forma como você faz isso. Hoje, as pessoas se informam em relação aos horários das sessões e os filmes exibidos através da internet. Poucos são os casos de pessoas que vão ao cinema e decidem o que verão "de bate e pronto". Indo além, a venda online de ingressos também modificou a forma como as pessoas consomem o cinema. Não é mais sobre chegar cedo para comprar um ingresso numa boa cadeira. A disputa agora também é online.
Dito isso, nossa dupla decidiu desenvolver um aplicativo onde as pessoas possam fazer isso, mas ao invés de ser um aplicativo de uma rede de cinemas específica, o aplicativo acolhe várias redes em um lugar só, evitando que o usuário precise verificar a disponibilidade de um filme em vários sites ou aplicativos diferentes.
O sistema gerencia a venda de ingresso para diversas redes de cinemas, onde cada unidade está localizada em uma cidade específica de um estado e pertence a uma determinada franquia.
Para oferecer uma boa experiência, os cinemas contam com diversos recursos, possuem múltiplas salas e cada sala é composta por várias cadeiras.
A programação é organizada por meio de sessões, que exibem filmes específicos (dirigidos por um ou mais diretores), permitindo que os clientes comprem seus ingressos vinculados a uma cadeira e a uma sessão escolhida.

<img width="1761" height="2430" alt="Cinema" src="https://github.com/user-attachments/assets/e3b22e2b-cecd-4238-a6cb-d639fd8687da" />

Requisitos para rodar o projeto:

- Java 17;
- IDE de sua preferência (Ex: IntelliJ IDEA, Eclipse ou VS Code);

Tecnologias e Dependências Utilizadas:

- Maven (Gerenciador de dependências);
- Spring Boot 4.0.6 (Framework);
- Spring Data JPA & Banco de Dados H2 (Persistência de dados em memória, dispensando instalação de bancos locais);
- Validation (Bean Validation / Jakarta) (Mapeamento de regras e consistência de dados dos DTOs via @Valid);
- Spring Security (Camada nativa de Autenticação e Autorização da API);
- Swagger / OpenAPI 3 (Documentação interativa automatizada dos endpoints da API);
- Lombok (Produtividade e eliminação de código boilerplate através de anotações como @Getter e @Setter).

Para executar a aplicação, rode o projeto através da classe principal CrvgApplication.java.
Após isso, a aplicação estará disponível em: http://localhost:8080.
A documentação dos endpoints da API foi gerada utilizando o Swagger/OpenAPI e pode ser acessada localmente através da URL: http://localhost:8080/swagger-ui/index.html com a aplicação em execução.
O link do Banco de Dados (H2 Console): http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:cinemadb)
username: sa (senha vazia)

Exemplo de execução:

Payload de Requisição (Request Body):

{
    "dataInicioExibicao": "2026-06-20T14:30:00",
    "dataFimExibicao": "2026-06-20T17:00:00",
    "horaDataSessao": "2026-06-20T14:30:00",
    "preco": 32.50,
    "idFilme": 1,
    "idSala": 1
}

Payload de Resposta (Response Body):

{
    "idSessao": 5,
    "dataInicioExibicao": "2026-06-20T14:30:00",
    "dataFimExibicao": "2026-06-20T17:00:00",
    "horaDataSessao": "2026-06-20T14:30:00",
    "preco": 32.50,
    "idFilme": 1,
    "idSala": 1
}
