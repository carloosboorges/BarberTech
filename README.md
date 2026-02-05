# 💈 BarberTech – Sistema de Gestão para Barbearias

O **BarberTech** é uma **API REST completa** desenvolvida em **Java com Spring Boot**, voltada para a **gestão de barbearias**.  
O sistema permite o controle de **clientes, barbeiros, serviços, combos, produtos, vendas e agendamentos**, seguindo boas práticas de arquitetura, validação, documentação e persistência de dados.

Projeto pensado para simular um **cenário real de mercado**, com foco em organização, clareza de código e escalabilidade.

---

## 🚀 Funcionalidades

### 👤 Clientes
- Cadastro de clientes
- Atualização de dados
- Busca por ID
- Listagem de clientes
- Validação de CPF e e-mail
- Tratamento de erros padronizado

---

### ✂️ Barbeiros
- Cadastro de barbeiros
- Atualização de informações
- Ativação e inativação
- Busca por ID
- Listagem geral
- Validação de CPF, telefone e e-mail

---

### 🧴 Serviços
- Cadastro de serviços
- Atualização
- Listagem
- Busca por ID
- Definição de valor e duração estimada
- Valores monetários tratados com **BigDecimal**

---

### 🎁 Combos
- Criação de combos com múltiplos serviços
- Cálculo automático de:
  - valor original
  - valor com desconto
- Ativação e inativação de combos
- Busca por status (ATIVO / INATIVO)
- Listagem geral e por ID

---

### 📦 Produtos
- Cadastro de produtos
- Controle de estoque
- Atualização de dados
- Listagem e busca por ID
- Valores tratados com **BigDecimal**

---

### 💰 Vendas
- Registro de vendas para clientes
- Venda composta por múltiplos itens
- Cálculo automático de:
  - subtotal por item
  - valor total da venda
- Atualização de estoque após venda
- Listagem de vendas
- Listagem de vendas por cliente
- Status da venda (FINALIZADA, CANCELADA, etc.)

---

### 📅 Agendamentos
- Agendamento de atendimento
- Associação obrigatória:
  - **OU** serviço
  - **OU** combo (nunca os dois)
- Associação com cliente e barbeiro
- Validação de data futura
- Controle de status do agendamento
- Retorno de dados resumidos para o front

---

## 🧱 Arquitetura do Projeto

O projeto segue uma **arquitetura em camadas**, separando bem responsabilidades:

```text
controller  → endpoints REST
service     → regras de negócio
repository  → acesso ao banco (JPA)
entity      → entidades do domínio
dto         → entrada e saída de dados
validation  → validações customizadas
exception   → tratamento global de erros


## 🛡️ Validações e Tratamento de Erros

- Validações com **Bean Validation**
- Validações customizadas (ex: CPF)
- Regras de negócio protegidas na camada **Service**
- **GlobalExceptionHandler** para respostas padronizadas
- Retorno de erros consistente:

```json
{
  "status": 400,
  "mensagem": "CPF inválido",
  "timestamp": "2026-02-05T14:32:10"
}

📘 Documentação com Swagger

O projeto é totalmente documentado com Swagger (OpenAPI 3).
- Documentação automática dos endpoints
- Exemplos de request e response
- Descrição de regras de negócio
- Visualização clara no Swagger UI

📍 Acesse após rodar o projeto: http://localhost:8080/swagger-ui.html

## 🗄️ Banco de Dados e Migrations

- Banco em desenvolvimento/testes: **H2**
- Preparado para produção: **MySQL**
- Controle de versão do banco com **Flyway**
- Migrations versionadas (`V1__`, `V2__`, …)
- Conversão segura de `Double` → `BigDecimal` para valores monetários

---

## ⚙️ Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Bean Validation
- Flyway
- H2 Database
- MySQL (preparado para produção)
- Swagger / OpenAPI
- Lombok
- Maven

---

## ▶️ Como executar o projeto

### Pré-requisitos
- Java 17+
- Maven
- Git

### Passos
```bash
git clone https://github.com/seu-usuario/BarberTech.git
cd BarberTech
mvn spring-boot:run

## 📌 Padrões adotados

- DTOs para entrada e saída
- Nenhuma entidade exposta diretamente
- Valores financeiros com **BigDecimal**
- Histórico de banco controlado por **migration**
- Código organizado e legível

---



