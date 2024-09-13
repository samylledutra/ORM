# Aplicação de Captação de Leads - Loja de Pudins

Aplicação de captação de leads para uma loja de pudins, desenvolvida como uma API REST utilizando Spring Boot. Seguindo uma arquitetura monolítica, inclui persistência de dados em banco de dados relacional, segurança com Spring Security, queries customizadas e documentação da API com OpenAPI 3 e Swagger.

## Requisitos Funcionais

- **Gerenciamento de Campanhas**: O sistema permite a criação, atualização, listagem e exclusão de campanhas de marketing.
- **Gerenciamento de Leads**: O sistema coleta e gerencia leads captados através da landing page.
- **Gerenciamento de Produtos**: O sistema permite a gestão de produtos na loja de pudins, com funcionalidades para criar, listar, atualizar e excluir produtos.
- **Gerenciamento de Usuários**: O sistema possibilita o cadastro, atualização, listagem e exclusão de usuários.
- **Autenticação e Autorização**: Controle de acesso para diferentes funcionalidades, dependendo do perfil de usuário.

## Relacionamentos Entre as Classes

- **Campanha** tem um relacionamento de muitos-para-um com **Usuario** (usuário responsável pela criação da campanha).
- **Lead** pode estar relacionado a **Usuario** (um lead pode ser captado por um usuário).
- **Produto** pode estar relacionado a **Usuario** (produtos adicionados pelo usuário).
- **Usuario** possui associação com as classes **Campanha**, **Lead**, e **Produto**.


![Capturar](https://github.com/user-attachments/assets/cda89c47-edbd-4f85-9c3d-cdedc3163970)

## Endpoints da API

### Campanhas

- `GET /api/campanhas`: Retorna a lista de todas as campanhas.
- `GET /api/campanhas/{id}`: Retorna uma campanha específica pelo seu ID.
- `POST /api/campanhas`: Cria uma nova campanha.
- `PUT /api/campanhas/{id}`: Atualiza uma campanha existente.
- `DELETE /api/campanhas/{id}`: Remove uma campanha pelo ID.

### Leads
- `GET /api/leads`: Retorna a lista de todos os leads.
- `GET /api/leads/{id}`: Retorna um lead específico pelo ID.
- `POST /api/leads`: Cria um novo lead.
- `PUT /api/leads/{id}`: Atualiza um lead existente.
- `DELETE /api/leads/{id}`: Remove um lead pelo ID.

### Produtos
- `GET /api/produtos`: Retorna a lista de todos os produtos.
- `GET /api/produtos/{id}`: Retorna um produto específico pelo ID.
- `POST /api/produtos`: Cria um novo produto.
- `PUT /api/produtos/{id}`: Atualiza um produto existente.
- `DELETE /api/produtos/{id}`: Remove um produto pelo ID.

### Usuários
- `GET /api/usuarios`: Retorna a lista de todos os usuários.
- `GET /api/usuarios/{id}`: Retorna um usuário específico pelo ID.
- `POST /api/usuarios`: Cria um novo usuário.
- `PUT /api/usuarios/{id}`: Atualiza um usuário existente.
- `DELETE /api/usuarios/{id}`: Remove um usuário pelo ID.

