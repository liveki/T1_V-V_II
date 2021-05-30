# T1_V-V_II
Trabalho 1 da disciplina de Verificação e Validação de Software II

- [x] O sistema deverá permitir escolher o operador/usuário atual.
    
    Melhorias: Imprimir o operador nos submenus também.

- [x] O sistema deverá permitir incluir um novo operador (não é necessário
implementar edição).

- [x] O sistema deverá permitir excluir um operador desde que não existam registros associados a ele.

- [ ] O sistema deverá permitir registrar uma nova entrega, com data e hora, descrição e apartamento de destino, bem como o operador que recebeu a entrega. Sugere-se gerar um ID numérico sequencial a cada nova entrega. (Sempre utilizar referências aos objetos).
    
    Possiveis erros: Não validar operador, apartamento, (data e hora) automática?.

- [x] O sistema deverá manter uma lista de moradores (nome, RG e nro do
apartamento).

- [x] O sistema deverá permitir incluir um novo morador.

- [ ] O sistema deverá permitir marcar um morador como “inativo” (não é necessário
implementar edição nem exclusão). Um morador inativo não poderá ser mais
associado a novas entregas.
    
    Erro: Feature não incluida.

- [x] O sistema deverá permitir ao operador registrar a retirada de uma entrega por um
morador. Registrar data e hora, o morador que retirou, relacionando com qual
entrega já registrada anteriormente.

- [x] Deverá ser possível listar todos os moradores do prédio.

    Erro: Não possui só com os nomes, a lista que o app possui é com todos os dados.

- [x] Deverá ser possível procurar entregas pela descrição. Listar todas as encontradas.

- [x] Deverá ser possível listar todas as entregas que ainda não foram retiradas,
ordenadas pela data.

- [ ] Deverá haver um painel (dashboard) com as seguintes informações:
a. Nro total de entregas nos últimos 30 dias.
b. Quantidade de entregas ainda não retiradas (total).
c. Tempo médio entre registro e retirada das entregas.
    
    Erro: Feature não incluida.

- [x] Deverá ser possível gerar um relatório como o exemplo abaixo, entre uma data
inicial e uma data final escolhidas pelo operador (note que há entregas ainda não
retiradas):

Entrega Data/hora Descrição Apto Operador Retirada Morador
22 05/10/20 10:23 Caixa grande azul Submarino 201 JM 05/10/20 12:10 Carlos Silveira
23 05/10/20 14:18 Caixa nro 109244 302 PO
24 05/10/20 17:50 Envelope pequeno 602 TF 06/10/20 09:00 Marcia Duarte
25 06/10/20 08:20 Carta registrada nro 98/233 502 JM 06/10/20 08:50 Paula Borges
26 06/10/20 13:40 Caixa pequena Americanas 203 PL

    Erro: Quando definido horário inicial e horário final, o sistema quebra. 
