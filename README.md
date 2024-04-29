# Library-system
## Esse projeto idealiza um sistema de biblioteca em Java, utilizando dos conceitos básicos da linguagem junto a conceitos de orientação a objetos, como polimorfismo, abstração e encapsulamento, atendendo assim a todos os requisitos básicos requisitados.

# Classes
Pessoas: Pessoa(classe-mae), Aluno, Cliente, Bibliotecario, Professor.
Livros: LivroAcademico, LivroRomance, LivroFiccao.
Tambem conta com uma classe biblioteca e outra classe GerenciaListaUsuarios, alem do Main.
Interfaces: Avalia.

# Sobre o projeto
- O sistema consta com todos os requisitos minimos solicitados pelo professor
- Inicialmente implementamos um sistema de login de usuarios que consiste no uso da collection HashMap, onde nao e permitido ter 2 usuarios com o mesmo nome de usuario. Os usuarios sao divididos em 2 grupos, administradores e clientes, no caso da nossa biblioteca os administradores sao as classes Bibliotecario e Professor e cliente sao as classes Aluno e Cliente.
- Bibliotecario possui o maior nivel de permissao dentro do sistema e eh capaz de realizar acoes que nenhuma outra classe de Pessoa dentro do sistema pode fazer. Professor tambem possui um certo nivel de permissao maior que o dos clientes porem, nao tao grande como o do bibliotecario. Cliente e Alunos sao os 2 menores niveis de permissao, onde podem realizar apenas acoes basicas de um cliente dentro de uma biblioteca.
- Achamos util o uso de polimorfismo para conseguir manipular o ArrayList de livros mesmo possuindo varias classes diferentes de livro, porem todas elas sendo um extend da classe mae Livro
- Tambem achamos util o uso da abstracao para idealizar melhor um modelo de Livro onde o mesmo nao pode ser instaciado, ja que determinamos bem as classes de livros que tera na nossa biblioteca
- O uso do Comparator (.sort) foi util para a ordenacao do ArrayList de forma alfabetica para melhor organizacao da nossa lista de livros
- Tambem utilizamos da interface Avalia para definir um contrato do metodo avalia que posteriormente 'e chamado para ajudar na avaliacao dos nossos livros
- Achamos valido tambem o uso de encapsulamento para manter as boas praticas de programacao e visando tambem uma melhor protecao tanto dos dados dos usuarios como dos livros da biblioteca. Utilizamos de modificadores de acesso como private e public
- O try catch foi utilizado no Main para adiantar ao usuario caso alguma entrada seja invalida
- Achamos bastante valido o nivel de permissao ser gerenciado atraves dos extends(Herancas) pois conseguimos definir bem os diferentes tipos de pessoa que iriam interagir com o nosso sistema e assim manipular suas permissoes
- O uso do Override do toString para reescrever as impressao das classes foi extremamente util pois assim, conseguimos imprimir de forma mais especifica o que queriamos para cada classe do nosso projeto.
- 
