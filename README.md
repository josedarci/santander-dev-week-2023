# 💳 Banking API - Spring Boot

Projeto desenvolvido como parte do desafio da **Santander Dev Week 2023**, com aprimoramentos pessoais para compor meu portfólio como desenvolvedor backend. Esta API simula funcionalidades bancárias como gestão de contas, clientes e cartões.

## 🚀 Tecnologias Utilizadas

- ✅ Java 17 (LTS)
- ✅ Spring Boot 3
- ✅ Spring Data JPA
- ✅ Swagger / OpenAPI
- ✅ Gradle
- ✅ H2 (banco de dados em memória)
- ✅ Deploy com Railway (opcional)

## 📦 Como executar localmente

### Pré-requisitos

- Java 17+
- Gradle ou suporte ao wrapper (`./gradlew`)
- IntelliJ ou IDE de sua preferência

### Passos para execução

```bash
# Clone o repositório
git clone https://github.com/josedarci/banking-api-springboot.git
cd banking-api-springboot
```
A aplicação será executada em: 📍 http://localhost:8080  <hr></hr>
🔍 Documentação da API
Acesse a documentação Swagger: 👉 http://localhost:8080/swagger-ui/index.html  <hr></hr>

🛠 Endpoints principais
📂 Usuários e Contas
GET /clients – Lista todos os clientes

POST /accounts – Cria uma nova conta

💳 Cartões
GET /cards – Lista cartões disponíveis

💰 Transações Bancárias
POST /transactions/deposit – Realiza um depósito em uma conta

POST /transactions/withdraw – Realiza um saque de uma conta

POST /transactions/transfer – Transfere valores entre contas

GET /transactions/account/{accountId} – Retorna histórico de transações de uma conta

⚠️ Os endpoints podem evoluir conforme novas funcionalidades forem sendo implementadas.

<hr></hr>
☁️ Deploy na Nuvem (Railway)
Você pode clonar este projeto e implantar facilmente no Railway:  
Acesse: https://railway.app
Clique em "New Project" → "Deploy from GitHub"
Selecione este repositório
Configure variáveis de ambiente (se necessário)
<hr></hr>
👨‍💻 Autor
Desenvolvido por José Darci Rodrigues Junior 🔗 https://github.com/josedarci  Projeto inspirado e baseado no evento Santander Dev Week 2023, com melhorias e estrutura profissional aplicadas para fins de portfólio.

Principais melhorias:
- Separação visual com linhas horizontais (`---`)
- Blocos de código bem delimitados
- Listas e links organizados
- Destaque para comandos e URLs