# Explorando Marte :rocket:

Projeto em Java para o Elo7 Academy, no qual temos o objetivo de representar uma área em Marte que pode ser explorada por sondas espaciais que recebem uma sequência de determinados comandos.

## Funcionamento:

Cada sonda é inserida na área apontando para uma direção (norte, leste, oeste ou sul). Dada essa posição inicial e uma sequência de movimentos (virar 90 graus para a esquerda, para a direita, ou mover-se um ponto a frente), o programa deve retornar a posição final da sonda.  
Se no decorrer da relização de comandos a sonda colidir com o limite do campo ou com um espaço já ocupado por outra sonda, a sonda irá virar 90 graus para a esquerda, alterando o restante de seu percurso.

## Entrada:

O primeiro input corresponde às coordenadas do canto superior direito do campo a ser explorado, tendo em mente que as coordenadas se iniciam do ponto inferior esquerdo (0,0).
```
>>> 5 5
```

Depois, cada sonda recebe duas linhas de informações.

Primeira linha: Coordenadas e direção da sonda no ponto inicial no formato "X Y D".
```
>>> 1 2 N
```
Segunda linha: Sequência de movimentos a serem realizados pela sonda (Exemplo: LMLMRMRM)
```
>>> LMLMRMRM
```

## Saída:

Cada sonda gera uma linha de saída, indicando sua coordenada final e direção no formato "X Y D".
```
1 3 N
```
