# Mapa Astral

Atividade desenvolvida para o Bootcamp Lets Code Itaú

## Requisitos

Você foi contratado para desenvolver o novo sistema de mapa astral de um grande banco. Esse mapa astral não segue
totalmente o padrão convencional, porque a empresa decidiu criar o seu próprio com algumas especificações que seguem
abaixo:

Você deve criar um método que receba a data/hora de nascimento e local de nascimento de uma pessoa. (Pode usar Scanner,
se quiser, mas não é obrigatório)
Baseado nessas informações, a equipe espera que você imprima:

- A idade da pessoa
- Data de nascimento formatada (dd/MM/yyyy HH:mm)
- ZoneOffset do local de nascimento (ex: +03:00, -01:00)
- Se o ano de nascimento é bissexto
- O signo da pessoa
- O ascedente
- Signo lunar

### O signo

    - Implementar pelo menos dois signos.
    - Se não for encontrado, pode retornar "Signo não encontrado" ou algo parecido.

### O ascendente

    - Implementar pelo menos um ascendente para cada signo, baseado na hora de nascimento.
    - Se não for encontrado, pode retornar "Ascendente não encontrado" ou algo parecido.

### Signo lunar (bônus)

    - Implementar o signo lunar baseado no local e hora de nascimento
        - Se a pessoa nasceu em Recife e depois das 12h00, deve retornar "Casimiro"
        - Se a pessoa nasceu em Cuiaba e antes das 12h00, deve retornar "Odin"
        - Se a pessoa nasceu em São Paulo (não importa o horário), deve retornar "Gandalf"
        - Se não atender nenhuma das condições acima, retornar Dinossauro.
