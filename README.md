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
- O sistema atende a todos os requisitos mínimos solicitados pelo professor
- Inicialmente, implementamos um sistema de login de usuários que utiliza a coleção HashMap, onde não é permitido ter dois usuários com o mesmo nome de usuário. Os usuários são divididos em dois grupos: administradores e clientes. Na nossa biblioteca, os administradores são as classes Bibliotecário e Professor, e os clientes são as classes Aluno e Cliente.
- O bibliotecário possui o maior nível de permissão dentro do sistema e é capaz de realizar ações que nenhuma outra classe de pessoa dentro do sistema pode fazer. O professor também possui um nível de permissão maior do que o dos clientes, mas não tão grande quanto o do bibliotecário. Clientes e alunos têm os dois menores níveis de permissão, podendo realizar apenas ações básicas de um cliente em uma biblioteca.
- Achamos útil o uso do polimorfismo para manipular o ArrayList de livros, mesmo tendo várias classes diferentes de livros, pois todas elas são derivadas da classe-mãe Livro. Isso nos permite manipular objetos e implementar funções que incluam todas as classes, proporcionando a reutilização de código mesmo tratando-se de classes diferentes.
- Também consideramos útil o uso da abstração para idealizar melhor um modelo de Livro que não pode ser instanciado diretamente, já que determinamos bem as classes de livros presentes na nossa biblioteca.
- Utilizamos a interface Avalia para definir um contrato para o método "avalia", que é posteriormente chamado para ajudar na avaliação dos nossos livros.
- Achamos válido também o uso do encapsulamento para manter boas práticas de programação e uma melhor proteção tanto dos dados dos usuários quanto dos livros da biblioteca. Usamos modificadores de acesso como "private" e "public".
- O "try-catch" foi utilizado no método "Main" para informar ao usuário caso alguma entrada seja inválida.
- Consideramos bastante válido o nível de permissão ser gerenciado através do uso de herança (extends), pois conseguimos definir bem os diferentes tipos de pessoas que iriam interagir com o sistema e, assim, manipular suas permissões.
- O uso do "Override" no método "toString" para reescrever a impressão das classes foi extremamente útil, pois conseguimos imprimir de forma mais específica o que queríamos para cada classe do projeto.
- Também adicionamos um mini "easter egg" para o usuário, que é basicamente um mini spoiler para tornar o livro mais interessante antes da leitura.
- O uso de construtores também foi essencial para instanciar as classes de forma correta no sistema.
- Os alunos só podem fazer empréstimo de livros acadêmicos, enquanto os clientes podem pegar emprestados todos os livros, exceto os acadêmicos. Isso se reflete na exibição das listas de livros disponíveis para cada um, mostrando apenas aquilo com o qual eles podem interagir.
- Empréstimos funcionam através de um setStatus, que coloca o status do livro como false, devolução utiliza o setStatus para recolocar como true o status, caso seja false o status do livro, ele não aparece na lista de disponíveis, apenas na de indisponíveis, onde somente o bibliotecário tem acesso.
- Utilizamos bastante o "instaceof" para verificar nas funções quais eram os tipos das instâncias dos objetos no nosso sistema
  
# Interface de usuário
# Exemplo de algumas funções do menu do bibliotecario:

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

## Exibição de disponiveis após remoção do livro
![image](https://github.com/pedromota001/Library-system/assets/135559962/b0bdd21d-5e6f-4d8a-982b-72b94c3b5be6)

## Exibição de sinopse dos livros
![image](https://github.com/pedromota001/Library-system/assets/135559962/c141e2e9-7f53-4993-9c9b-0c8382d463bc)

## Exibição de todos os usuarios do sistema
![image](https://github.com/pedromota001/Library-system/assets/135559962/bb456d3f-acbc-47c2-a490-ccdf3ffe3372)

## Log in na conta do bibliotecario
![image](https://github.com/pedromota001/Library-system/assets/135559962/24580e17-b3be-4e12-8aac-8f6205d1b0b3)



# Exemplo de algumas funções do menu do professor:

## Criação de conta do professor:
![image](https://github.com/pedromota001/Library-system/assets/135559962/9d265414-6b45-4ebc-9ed8-e5af25a9d048)

## Log in na conta do professor:
![image](https://github.com/pedromota001/Library-system/assets/135559962/0f2027ba-2b51-432e-839d-7577b5d47da9)

## Registro de livro:
![image](https://github.com/pedromota001/Library-system/assets/135559962/870804dc-20f4-496a-bb35-b0dcabaaad94)


# Exemplo de algumas funções do menu de aluno:
## Criação de conta do aluno:
![image](https://github.com/pedromota001/Library-system/assets/135559962/c99faff8-1994-4072-962e-365b6b1e150b)

## Emprestimo de livro na conta do aluno
![image](https://github.com/pedromota001/Library-system/assets/135559962/5bacd014-a0c4-4049-b981-53944e00183a)


## Exibição da sua lista de livros apos o emprestimo
![image](https://github.com/pedromota001/Library-system/assets/135559962/bb364981-0612-4bda-9ab3-8568930ba277)


## Devolução de livros e exibição da sua lista livros apos a devolução
![image](https://github.com/pedromota001/Library-system/assets/135559962/4c299c15-f0fe-40fb-8d27-f1e582a190d3)


## Avaliação de livro e exibicao de disponiveis após a devolução e da avaliação do aluno
![image](https://github.com/pedromota001/Library-system/assets/135559962/7a84bb13-1ad1-426c-8caa-4d2663e1dfe3)



# Exemplos de algumas funções do menu do cliente:

## Log in na conta do cliente:
![image](https://github.com/pedromota001/Library-system/assets/135559962/861e27c1-13ed-41da-86b5-90c7012c9e1a)

## Emprestimo de livro na conta do cliente:
![image](https://github.com/pedromota001/Library-system/assets/135559962/419d8357-9b4c-4cbc-9d0f-b0c4665d2b0a)

## Exibindo lista de disponiveis apos o emprestimo
![image](https://github.com/pedromota001/Library-system/assets/135559962/7cc9fabc-9a75-4d39-a2b1-53b019a7611c)


# Saída do sistema

![image](https://github.com/pedromota001/Library-system/assets/135559962/5f4de2b8-6924-46b2-aafb-1a18e89ebd9c)



