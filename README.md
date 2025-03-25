# Sistema de Gerenciamento de Estoque - Media Fidelidade

**Autores:**
- Arthur Araújo Marzano
- Arthur Augusto Alves Araújo
- Gabriel Arthur Jesus

Este repositório contém o código do **Sistema de Gerenciamento de Estoque** desenvolvido para otimizar o controle de almoxarifados, com funcionalidades completas de cadastro de usuários, gerenciamento de funcionários, controle de estoque e muito mais.

## Funcionalidades

### **1. Cadastro e Login:**

- **Cadastro ou Login:**
  - Usuários podem criar uma conta ou acessar uma conta existente para entrar no sistema de gerenciamento de estoque.
  
- **Criação Automática de Perfil no Almoxarifado:**
  - Se o usuário for novo, ao realizar o cadastro, um perfil será automaticamente criado para ele no "Perfis do Almoxarifado".

---

### **2. Gerenciamento de Funcionários**

- **Cadastro de Funcionários (PseudoPerfis):**
  - O Administrador (ADM) pode criar perfis para funcionários, incluindo informações como nome, CPF, descrição, etc.
  
- **Visualização de Funcionários:**
  - O ADM pode visualizar todos os perfis dos usuários do sistema, com informações detalhadas (nome, e-mail, CPF, histórico de retiradas, etc).
  
- **Exclusão/Desativação de Funcionários:**
  - Caso um funcionário seja desligado, o ADM pode desativá-lo ou excluí-lo do sistema de forma simples.

---

### **3. Gerenciamento de Estoque**

- **Adicionar Itens no Estoque:**
  - O ADM pode adicionar novos itens ao estoque, fornecendo código do produto, nome, descrição, quantidade, localização e categoria.
  
- **Editar Itens no Estoque:**
  - O ADM pode editar os itens já cadastrados no estoque, ajustando nome, descrição, quantidade, etc.
  
- **Remover Itens do Estoque:**
  - O ADM pode excluir itens que não são mais necessários.
  
- **Visualização do Estoque:**
  - O ADM pode visualizar todos os itens cadastrados, com filtros por categoria ou outras métricas.

---

### **4. Galeria de Itens**

- **Retirar Itens:**
  - Funcionários podem selecionar itens a serem retirados, colocando-os no "Carrinho de retirada" e indicando a quantidade. Após a confirmação, o sistema gera um relatório da retirada.
  
- **Cancelar Retirada:**
  - O ADM pode revisar os itens adicionados ao "Carrinho de Retirada" e remover qualquer item antes da confirmação final.
  
- **Devolver Itens:**
  - Funcionários podem devolver itens retirados anteriormente, e o ADM registra a devolução no sistema.

---

### **5. Segurança e Monitoramento**

- **Histórico de Ações:**
  - O ADM pode acessar o histórico completo de todas as transações no almoxarifado, como entradas, saídas e retiradas, garantindo total controle e transparência das operações.

