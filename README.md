Simulador de Autômatos Finitos Determinísticos feito em JAVA, sem interface gráfica, rodando apenas no terminal.

Solicitações de input:
-Quantidade de estados (número inteiro maior que 0. Vai dizer quantos estados o seu autômato tem)

-Alfabeto (Uma string de caracteres distintos. Não pode haver separação de espaços, para que o método toCharArray funcione corretamente)

-Transição para quando X receber C (Aqui é definido para qual estado o seu autômato vai quando ele estiver no estado X recebendo o símbolo C)
Exemplo: Se meu autômato sai do estado 1 para o estado 2 quando o estado 1 recebe um "a", então deve ser colocado "2" quando solicitado para esse caso especifico.

-Estado inicial (Inteiro correspondente ao estado inicial)

-Estado(s) de aceitação (Estados finais do automato. Inteiros separados por espaço, para que o método split funcione corretamente)
