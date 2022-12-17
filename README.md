# jdbc-practice
<hr>
   <img src="http://img.shields.io/static/v1?label=STATUS&message=INDEFINIDO&color=RED&style=for-the-badge"/>
   
## Descrição do Projeto
Esse repositório é destinado às práticas utilizando a API JDBC.

<strong> JDBC </strong> é uma abstração do mundo java para lidar com diferentes tipos de banco de dados.

Nesse projeto, utilizei o MYSql como banco de dados.

## Etapa 1
O primeiro commit foi destinado a criar uma conexão com o banco de dados. Para isso, foi criado a classe [DB](https://github.com/RonaldAG/jdbc-practice/blob/main/src/db/DB.java) que lê o arquivo de propriedades com o login, senha e url
do projeto. 

Para isso, criei um método privado e estático que apenas faz essa leitura.

![image](https://user-images.githubusercontent.com/84423626/208240488-089929b1-d95a-4d11-a568-0de669c2b43e.png)

Em seguida, foi criado o método [getConnection()](https://github.com/RonaldAG/jdbc-practice/blob/main/src/db/DB.java) para iniciar a conexão com o banco de dados.

![image](https://user-images.githubusercontent.com/84423626/208240520-27f6f7d0-57e8-49ba-b45f-48c5d06764e2.png)

Por fim, o método [closeConnection()](https://github.com/RonaldAG/jdbc-practice/blob/main/src/db/DB.java) foi desenvolvido para encerrar a conexão.

![image](https://user-images.githubusercontent.com/84423626/208240558-80f6cbee-b10e-4572-9198-42f1c7455ad2.png)

## Etapa 2
O segundo commit trata da lógica de recuperação de dados. Refere-se a utilização das classes presentes no pacote java.sql para executar querys e obter os dados da tabela.
As classes usadas do pacote java.sql foram:
- `Statement`: Passa um comando SQL para o banco de dados;
- `ResultSet`: Armazena os dados da query;

Para isso, foi criado um novo método main que simplimente executa o query

![image](https://user-images.githubusercontent.com/84423626/208242929-674cab77-5398-4d0c-b196-fcfaf22ea162.png)

## Etapa 3
O terceiro commit adiciona a lógica de inserção de novas linhas na tabela. Para fazer isso, foi necessário utilizar as sequintes classes:
- `PreparedStatement`: Objeto que permite montar a consulta SQL, deixando os parâmetros para depois.
- `executeUpdate`: método que faz a inserção das novas linhas
- `Statement.RETURN_GENERATED_KEYS`: Recupera o ID do dado inserido
- `getGeneratedKeys`: Retorna os ID's de cada linha

Nessa etapa, fiz duas implementações, uma que retorna o [número de linhas afetadas](https://github.com/RonaldAG/jdbc-practice/blob/main/src/application/InsertDataUsingJDBC.java) após a nova inserção e outra que retorna os [id's de cada linha](https://github.com/RonaldAG/jdbc-practice/blob/main/src/application/InsertDataWithRowsID.java) inserida.
