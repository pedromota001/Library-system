# Library-system
## Esse projeto idealiza um sistema de biblioteca em Java, utilizando dos conceitos básicos da linguagem junto a conceitos de orientação a objetos, como polimorfismo, abstração e encapsulamento, atendendo assim a todos os requisitos básicos requisitados.


# Grupo:
Pedro Mota, Miguel Procopio, Gustavo Porto, Rondon Guilherme

# Classes
Pessoas: Pessoa(classe-mae), Aluno, Cliente, Bibliotecario, Professor.
Livros: LivroAcademico, LivroRomance, LivroFiccao.
Tambem conta com uma classe biblioteca e outra classe GerenciaListaUsuarios, alem do Main.
Interfaces: Avalia.

# Sobre o projeto
- O sistema consta com todos os requisitos minimos solicitados pelo professor
- Inicialmente implementamos um sistema de login de usuarios que consiste no uso da collection HashMap, onde nao e permitido ter 2 usuarios com o mesmo nome de usuario. Os usuarios sao divididos em 2 grupos, administradores e clientes, no caso da nossa biblioteca os administradores sao as classes Bibliotecario e Professor e cliente sao as classes Aluno e Cliente.
- Bibliotecario possui o maior nivel de permissao dentro do sistema e eh capaz de realizar acoes que nenhuma outra classe de Pessoa dentro do sistema pode fazer. Professor tambem possui um certo nivel de permissao maior que o dos clientes porem, nao tao grande como o do bibliotecario. Cliente e Alunos sao os 2 menores niveis de permissao, onde podem realizar apenas acoes basicas de um cliente dentro de uma biblioteca.
- Achamos util o uso de polimorfismo para conseguir manipular o ArrayList de livros mesmo possuindo varias classes diferentes de livro, porem todas elas sendo um extend da classe mae Livro, possibilitando manipularmos objetos e implementar funcoes que incluissem todas as classes e que proporcionasse a reutilizacao de codigos mesmo se tratando de classes diferentes.
- Tambem achamos util o uso da abstracao para idealizar melhor um modelo de Livro onde o mesmo nao pode ser instaciado, ja que determinamos bem as classes de livros que tera na nossa biblioteca.
- O uso do Comparator (.sort) foi util para a ordenacao do ArrayList de forma alfabetica para melhor organizacao da nossa lista de livros.
- Tambem utilizamos da interface Avalia para definir um contrato do metodo avalia que posteriormente 'e chamado para ajudar na avaliacao dos nossos livros
- Achamos valido tambem o uso de encapsulamento para manter as boas praticas de programacao e visando tambem uma melhor protecao tanto dos dados dos usuarios como dos livros da biblioteca. Utilizamos de modificadores de acesso como private e public.
- O try catch foi utilizado no Main para adiantar ao usuario caso alguma entrada seja invalida.
- Achamos bastante valido o nivel de permissao ser gerenciado atraves dos extends(Herancas) pois conseguimos definir bem os diferentes tipos de pessoa que iriam interagir com o nosso sistema e assim manipular suas permissoes
- O uso do Override do toString para reescrever as impressao das classes foi extremamente util pois assim, conseguimos imprimir de forma mais especifica o que queriamos para cada classe do nosso projeto.
- Tambem adicionamos um mini easter egg ao usuario que seria basicamente um mini spoiler que deixaria o livro mais interessante antes da leitura
- O uso de construtores tambem foi essencial para conseguirmos instaciar as classes de forma correta no nosso sistema.
- Alunos so podem fazer emprestimo de livros academicos, clientes podem fazer emprestimo de todos os livros menos os academicos. Isso se inclui na parte da exibicao das listas de disponiveis para cada um, exibindo somente aquilo que ele pode interagir.
- Emprestimos funcionam atraves de um setStatus, que coloca o status do livro como false, devolucao utiliza o setStatus para recolocar como true o status, caso seja false o status do livro, ele nao aparece na lista de disponiveis, apenas na de indisponiveis, onde somente o bibliotecario tem acesso.

  
# Interface de usuario
# Exemplo de algumas funcoes do menu do bibliotecario:

## Criação de conta

![image](https://github.com/pedromota001/Library-system/assets/135559962/51a589b4-5563-42ce-98f5-09d05f85a01a)

## Registro de Livros

![image](https://github.com/pedromota001/Library-system/assets/135559962/fc0648e1-8d40-4218-8381-3a5e185452c7)

![image](https://github.com/pedromota001/Library-system/assets/135559962/b026fa50-4cef-47ce-8bae-437744a5f1e1)

![image](https://github.com/pedromota001/Library-system/assets/135559962/10af5a8d-c298-4f43-b3b0-fa01e14075ba)

## Exibir lista de livros

![image](https://github.com/pedromota001/Library-system/assets/135559962/2e50330a-a011-4cf5-aa1c-748f359dc42e)

## Remover livro do sistema
![image](https://github.com/pedromota001/Library-system/assets/135559962/463670b2-8cab-473f-9ea9-ed645d8d5779)

## Exibicao de disponiveis apos remocao do livro
![image](https://github.com/pedromota001/Library-system/assets/135559962/b0bdd21d-5e6f-4d8a-982b-72b94c3b5be6)

## Exibicao de sinopse dos livros
![image](https://github.com/pedromota001/Library-system/assets/135559962/c141e2e9-7f53-4993-9c9b-0c8382d463bc)

## Exibicao de todos os usuarios do sistema
![image](https://github.com/pedromota001/Library-system/assets/135559962/bb456d3f-acbc-47c2-a490-ccdf3ffe3372)

## Log in na conta do bibliotecario
![image](https://github.com/pedromota001/Library-system/assets/135559962/24580e17-b3be-4e12-8aac-8f6205d1b0b3)



# Exemplo de algumas funcoes do menu do professor:

## Criacao de conta do professor:
![image](https://github.com/pedromota001/Library-system/assets/135559962/9d265414-6b45-4ebc-9ed8-e5af25a9d048)

## Log in na conta do professor:
![image](https://github.com/pedromota001/Library-system/assets/135559962/0f2027ba-2b51-432e-839d-7577b5d47da9)

## Registro de livro:
![image](https://github.com/pedromota001/Library-system/assets/135559962/870804dc-20f4-496a-bb35-b0dcabaaad94)


# Exemplo de algumas funcoes do menu de aluno:
## Criacao de conta do aluno:
![image](https://github.com/pedromota001/Library-system/assets/135559962/c99faff8-1994-4072-962e-365b6b1e150b)

## Emprestimo de livro na conta do aluno
![image](https://github.com/pedromota001/Library-system/assets/135559962/5bacd014-a0c4-4049-b981-53944e00183a)


## Exibicao da sua lista de livros apos o emprestimo
![image](https://github.com/pedromota001/Library-system/assets/135559962/bb364981-0612-4bda-9ab3-8568930ba277)


## Devolucao de livros e exibicao da sua lista livros apos a devolucao
![image](https://github.com/pedromota001/Library-system/assets/135559962/4c299c15-f0fe-40fb-8d27-f1e582a190d3)


## Avaliacao de livro e exibicao de disponiveis apos a devolucao e da avaliacao do aluno
![image](https://github.com/pedromota001/Library-system/assets/135559962/7a84bb13-1ad1-426c-8caa-4d2663e1dfe3)



# Exemplos de algumas funcoes do menu do cliente:

## Log in na conta do cliente:
![image](https://github.com/pedromota001/Library-system/assets/135559962/861e27c1-13ed-41da-86b5-90c7012c9e1a)

## Emprestimo de livro na conta do cliente:
![image](https://github.com/pedromota001/Library-system/assets/135559962/419d8357-9b4c-4cbc-9d0f-b0c4665d2b0a)

## Exibindo lista de disponiveis apos o emprestimo
![image](https://github.com/pedromota001/Library-system/assets/135559962/7cc9fabc-9a75-4d39-a2b1-53b019a7611c)


# Saida do sistema

![image](https://github.com/pedromota001/Library-system/assets/135559962/5f4de2b8-6924-46b2-aafb-1a18e89ebd9c)



