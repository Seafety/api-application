# Softtek-Preview Projeto de Backend em Java com Spring Boot
Este projeto é uma aplicação de backend desenvolvida em Java usando Spring Boot, JPA e PostgreSQL. Ele segue uma arquitetura de camadas para separar as responsabilidades e facilitar a manutenção e escalabilidade do sistema.

## Estrutura do Projeto
O projeto segue uma estrutura de diretórios organizada em diferentes pacotes, cada um com uma responsabilidade clara dentro da aplicação.

### 1. domain
   O pacote domain contém as classes de domínio da aplicação. Essas classes representam as entidades principais do sistema e são mapeadas para tabelas no banco de dados usando JPA.
#### Classes:
- **Project:** Representa um projeto no sistema. Um projeto pode ter módulos (modulo), tipos de demanda (tipoDemanda), uma pirâmide de vendas (PiramideVendas) e um custo de venda (CustoVenda).
- **Consultant:** Representa um consultor, com atributos como nome, senioridade, especialidades e informações sobre ausências.
- **Ticket:** Representa um chamado (ticket) relacionado a um projeto e a um consultor específico. Contém informações como o módulo do chamado, tipo, status, horas trabalhadas, e complexidade.
- **PiramideVendas:** Classe embutida no Project, representa a distribuição de diferentes níveis de experiência (expert, senior, pleno, etc.) em um projeto.
- **CustoVenda:** Classe embutida no Project, representa os custos associados a cada nível de experiência em um projeto.
- **Cost:** Representa uma tabela de custos associada a diferentes atividades (codigo_at) e categorias (como senioridade).
#### Relações:
- Project possui uma relação @OneToMany com as tabelas modulo e tipoDemanda, que são armazenadas em tabelas separadas no banco de dados.
- Project também incorpora as classes PiramideVendas e CustoVenda usando @Embedded, o que significa que os campos dessas classes são armazenados diretamente na tabela project.
- Consultant tem um campo codigo_at que se relaciona com a tabela Cost, mapeando o custo de atividades específicas.

### 2. repository
   O pacote repository contém as interfaces que implementam o padrão Repository. Estas interfaces são usadas para realizar operações de persistência (CRUD) no banco de dados sem a necessidade de escrever SQL manualmente.
#### Interfaces:
- **ProjectRepository:** Interface responsável por gerenciar as operações de persistência da entidade Project. Estende JpaRepository, que oferece métodos prontos para realizar operações CRUD.
- **ConsultantRepository:** Interface responsável por gerenciar as operações de persistência da entidade Consultant.
- **TicketRepository:** Interface responsável por gerenciar as operações de persistência da entidade Ticket.
#### Propósito:
- Os repositórios abstraem o acesso ao banco de dados, fornecendo uma interface simples para realizar operações de persistência. Eles são utilizados pelas classes de serviço para aplicar regras de negócio e gerenciar dados.

### 3. service
   O pacote service contém as classes que implementam a lógica de negócio da aplicação. Elas interagem com os repositórios para acessar e manipular os dados, aplicando as regras de negócio necessárias.
#### Classes:
- **ProjectService:** Contém a lógica de negócio relacionada a projetos, como validações, cálculos e regras específicas antes de persistir ou recuperar projetos do banco de dados.
- **ConsultantService:** Gerencia a lógica de negócio relacionada aos consultores, aplicando as regras antes de manipular dados de consultores.
- **TicketService:** Lida com a lógica de negócio associada aos tickets, garantindo que as operações realizadas estejam de acordo com as regras estabelecidas para os chamados.
#### Relações:
- As classes de serviço utilizam os repositórios (ProjectRepository, ConsultantRepository, TicketRepository) para acessar os dados persistidos no banco de dados.

### 4. controller
   O pacote controller contém as classes responsáveis por expor as APIs da aplicação. Elas recebem as requisições HTTP, invocam os serviços apropriados e retornam as respostas para os clientes.
#### Classes:
- **ProjectController:** Expõe as APIs para gerenciar projetos, permitindo operações como criação, atualização, busca e remoção de projetos.
- **ConsultantController:** Fornece endpoints para gerenciar consultores, incluindo operações CRUD.
- **TicketController:** Exibe as APIs para a gestão de tickets, permitindo a criação, atualização e consulta de chamados.
#### Relações:
- Os controladores invocam as classes de serviço para processar as requisições. As classes de serviço, por sua vez, interagem com os repositórios para realizar as operações necessárias no banco de dados.
Como Funciona
#### A aplicação segue o fluxo MVC (Model-View-Controller), onde:
- Requisições HTTP são recebidas pelos controladores (controller), que atuam como intermediários.
- Controladores chamam os serviços (service), que contêm a lógica de negócio e decidem como processar as requisições.
- Serviços interagem com os repositórios (repository) para acessar e manipular os dados no banco de dados.
- Entidades do domínio (domain) são usadas para representar os dados dentro da aplicação, mapeando as tabelas do banco de dados para objetos Java.

## Tecnologias Utilizadas
- **Java 11+:** Linguagem de programação usada para o desenvolvimento da aplicação.
- **Spring Boot:** Framework que simplifica a criação de aplicações Java empresariais.
- **Spring Data JPA:** Abstração que facilita o acesso a dados e a persistência, usando o JPA.
- **PostgreSQL:** Banco de dados relacional usado para persistir os dados.

## Configuração
Certifique-se de configurar o banco de dados PostgreSQL no arquivo application.properties ou application.yml para que a aplicação possa se conectar e criar as tabelas automaticamente.

