# Desafio

  Sistema para gerenciar os dados do portfólio de projetos de uma empresa. 
  
## Funcionamento

  Essa aplicação foi desenvolvida utilizando a IDE Eclipse. 
  
  Para a interface web, foi utilizado o framework JSF Primefaces.
  
  Para gerenciamento de dependências, foi utilizado o Maven.
  
  A versão do java utilizada é a 11.
  
  Antes de executar a aplicação, basta importá-la em uma IDE, rodar os comandos maven clean e maven install.
  
  Em seguida, executar a classe "CodeApplication.java".
  
  Para visualizar a página inicial, acessar o link http://localhost:8080/index.jsf localmente.

  Foi disponibilizado o endpoint http://localhost:8080/code/membro/incluir para inclusão de membro. Para a realização dessa operação, deverá ser realizado um post para o endpoint citado enviando um body no seguinte formato:
  {
    "nome": "nome do membro",
    "atribuicao": true,
    "id_projeto": 6
  }

Para que a persistência ocorra, estes parâmetros deverão estar exatamente como informados no cadastro de pessoa, inclusive o nome.
