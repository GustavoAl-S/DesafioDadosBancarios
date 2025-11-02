# Simulador de Conta Bancária

Este projeto é uma aplicação em Java que simula uma conta bancária simples, utilizando entrada de dados via terminal. O usuário pode criar sua conta, visualizar o saldo, fazer depósitos e saques.

Atualização: O projeto recebeu um "update" e agora está Orientado a Objetos. Temos a classe Cliente, Conta, ContaCorrente e ContaPoupanca e com metodos para validar o tipo de conta, para sacar e depositar.

## Objetivo

O projeto foi desenvolvido como parte de um desafio com foco em praticar:

- Leitura de dados com `Scanner`
- Uso de estruturas de repetição e condicionais (`do/while`, `switch`)
- Validação de entrada de dados
- Formatação de saída no console
- Lógica de fluxo de um sistema bancário básico
- Orientação a Objetos e seus princípios como **encapsulamento**, **herança** e **polimorfismo**.

## Funcionalidades

- Criar conta bancária (Corrente ou Poupança)
- Definir saldo inicial com validação
- Consultar saldo
- Realizar depósitos (com validação de valor)
- Realizar saques (com verificação de saldo)
- Sair da aplicação

## Exemplo de uso

```text
Digite seu nome: 
João
Digite o seu tipo de conta (Corrente/Poupanca)
Corrente
Digite o valor do deposito inicial: 
1000

___________________________
Dados iniciais do cliente:

Nome:           João
Tipo de conta:  Corrente
Saldo inicial:  R$ 1000.00
___________________________

___________________________
Operaçoes disponiveis:

1- Consultar saldo
2- Depositar
3- Sacar
4- Sair

Digite a opção desejada:
```

## Estrutura do projeto
```
.
├── Main/
│   └── Aplicacao.java      # Classe principal, com o código de execução e interação com o usuário
├── Models/
│   ├── Cliente.java        # Classe que representa um cliente
│   ├── Conta.java          # Classe base para Conta Corrente e Conta Poupança
│   ├── ContaCorrente.java  # Classe que representa uma conta corrente
│   └── ContaPoupanca.java  # Classe que representa uma conta poupança
└── README.md               # Este arquivo
```

## Tecnologias utilizadas

- Java 21
- IntelliJ IDEA
- POO (Programação Orientada a Objetos) - utilizando os princípios de POO, como **encapsulamento**, **herança** e **polimorfismo**.


Feito com 💻 e ☕ por Gustavo Alves
