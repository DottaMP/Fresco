# Fresco

## Compra

### Model

| Atributo | Tipo | Quantidade de caracteres | Formatação
|----------|:----:|:------------------------:|:---------:
| id_compra | [PK] long | - | - |
| data | LocalDate | - | dd-MM-yyyy HH:mm:ss |
| forma_pgto | String | Entre 5 e 10 | - |
| status | String | Entre 8 e 25 | - |

#### Formas de pagamento
Débito  
Crédito  
Dinheiro

#### Status
Preparando  
À caminho  
Entregue  
Cancelado pelo restaurante  
Cancelado pelo cliente  

### Controller 

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | /compra | Listar todas as compras
| GET | /compra/{id} | Listar compra pelo ID
| POST | /compra | Adicionar compra
| PUT | /compra | Editar compra específica

Não será possível excluir uma compra já cadastrada, nesse caso seu status poderá ser atualizado para `cancelado`.
