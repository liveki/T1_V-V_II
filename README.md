# T1_V-V_II
Trabalho 1 da disciplina de Verificação e Validação de Software II

1. O sistema deverá permitir escolher o operador/usuário atual.
2. O sistema deverá permitir incluir um novo operador (não é necessário
implementar edição).
3. O sistema deverá permitir excluir um operador desde que não existam registros
associados a ele.
4. O sistema deverá permitir registrar uma nova entrega, com data e hora, descrição
e apartamento de destino, bem como o operador que recebeu a entrega. Sugerese gerar um ID numérico sequencial a cada nova entrega. (Sempre utilizar
referências aos objetos).
5. O sistema deverá manter uma lista de moradores (nome, RG e nro do
apartamento).
6. O sistema deverá permitir incluir um novo morador.
7. O sistema deverá permitir marcar um morador como “inativo” (não é necessário
implementar edição nem exclusão). Um morador inativo não poderá ser mais
associado a novas entregas.
8. O sistema deverá permitir ao operador registrar a retirada de uma entrega por um
morador. Registrar data e hora, o morador que retirou, relacionando com qual
entrega já registrada anteriormente.
9. Deverá ser possível listar todos os moradores do prédio.
10. Deverá ser possível procurar entregas pela descrição. Listar todas as encontradas.
11. Deverá ser possível listar todas as entregas que ainda não foram retiradas,
ordenadas pela data.
12. Deverá haver um painel (dashboard) com as seguintes informações:
a. Nro total de entregas nos últimos 30 dias.
b. Quantidade de entregas ainda não retiradas (total).
c. Tempo médio entre registro e retirada das entregas.
13. Deverá ser possível gerar um relatório como o exemplo abaixo, entre uma data
inicial e uma data final escolhidas pelo operador (note que há entregas ainda não
retiradas):
