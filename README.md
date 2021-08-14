# Projeto Final Compiladores 

## Features
### Itens obrigatórios

- [x] Possuir 2 tipos de variáveis (pelo menos 1 deles String)
- [x] Possuir a instrução if-else
- [x] Pelo menos 1 estrutura de repetição (while)
- [x] Verificar atribuição de variáveis (erro semântico) - compatibilidade de tipos
- [x] Possui operações de Entrada e Saída
- [x] Aceitar números decimais
- [x] Verificar se variável foi ou não declarada
- [x] Verificar se variável declarada foi ou não utilizada
- [x] Linguagem Destino (C/Java/Python): Java

### Itens adicionais
- [x] Estrutura adicional de loop (for)
- [x] Comentário
- [x] Temporizador de compilação
- [x] Potenciação e resto de divisão
- [x] Raiz quadrada

## Getting started
1 - Adicione o ANTLR jar no Classpath do projeto

2 - Para gerar o código da documentação IsiLang.g4, rode o seguinte comando no primeiro nível do projeto
 (>{path ate o projeto}/IsiLanguageEmbrião)

```sh
java -cp .:antlr-4.7.1-complete.jar org.antlr.v4.Tool IsiLang.g4 -package br.com.professorisidro.isilanguage.parser -o ./src/br/com/professorisidro/isilanguage/parser
```

3-Execute o run na MainClass.java dentro do pacote main

Seguindo esses comandos, o projeto compilará o documento input.isi e gerará os retornos tanto dos prints dos objetos Command quanto o código em Java na file MainClass.java do root
