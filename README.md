# 📋 Lista de Tarefas 

Um programa em **Java** que implementa uma **Lista de Tarefas** com operações CRUD (Criar, Ler, Atualizar e Deletar), além de recursos extras como **marcar conclusão** e **exibir estatísticas**. O sistema funciona via **terminal**, com menu interativo para o usuário.  

---

## 💻 Tecnologias utilizadas  

- ☕ **Java** (JDK 8+)  

---

## 📜 Funcionalidades  

O programa oferece um menu interativo com as seguintes opções:  

1. 📖 **Visualizar tarefas** – listar todas, apenas pendentes ou apenas concluídas  
2. ➕ **Adicionar tarefas** – criar uma nova tarefa com título, descrição, status e prioridade  
3. 🗑️ **Remover tarefa** – excluir uma tarefa da lista  
4. ✅ **Marcar como concluída** – alterar o status de uma tarefa pendente para concluída  
5. ✏️ **Alterar dados** – editar título, descrição, status ou prioridade de uma tarefa existente  
6. 📊 **Estatísticas** – exibir número total de tarefas, concluídas, pendentes e percentual de conclusão  
7. ❌ **Sair do programa**  

Cada tarefa cadastrada possui:  
- **Título**  
- **Descrição**  
- **Status** (Concluído / Não concluído)  
- **Prioridade** (Baixa, Média ou Alta)  

---

## 🚀 Como executar  

### Pré-requisitos  
- Ter o **Java JDK** instalado na máquina  
- Configurar a variável de ambiente `JAVA_HOME` (opcional, mas recomendado)  

### Passos para execução  

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/lista-de-tarefas-unotion.git

# Acesse a pasta do projeto
cd lista-de-tarefas-unotion

# Compile o código
javac ListaDefinitiva.java

# Execute o programa
java ListaDefinitiva
