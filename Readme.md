    # SpringBoot FORSALES
- Desenvolver API REST utilizando Spring Boot p/ controle de candidatos e cartões de crédito, nesta API deve conter rotas CRUD p/ controle dos candidatos e p/ controle dos cartões de créditos dos candidatos, o projeto deve seguir até o ponto que salvaria os dados no banco de dados utilizando o Hibernate.
Requisitos:
- Criar camada de segurança sobre todas as rotas do sistema e deixar somente a rota para deletar um candidato pública.
## Alguns pontos:
- Utilizado lombok para nao precisar perder tempo com codigo automaticamente gerado
- Criei com base de dados embbed para se quiser rodar localmente nao precisar instalar uma base de dados
- Testei utilizando sopaui e tudo correu bem fica um ponto de atenção que quando apaga o registro o da erro mesmo que faça bem o redirect faz com que apareça a mensagem sem permissão mas isto ja é depois de apagar. Não perdi tempo a resolver isto pois juguei que o objetivo era somente testar se a exclusao acontecia ou não-
- Para alteticar com basic autetication utilizar:
  diego
  password