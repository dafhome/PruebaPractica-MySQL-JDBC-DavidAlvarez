# PruebaPractica-MySQL-JDBC-DavidAlvarez
 
1- (2 ptos) Crea dos tablas: LIBROS y CLIENTES
La tabla libros contiene el id, titulo, autor y año de publicación La tabla clientes contiene id, nombre y e-mail
2- (1 pto) Relaciona ambas tablas (un cliente, muchos libros)
4- (1 pto) Rellena los datos en ambas tablas, al menos 5 filas de libros y 3 de clientes
5- (4 ptos) Realiza las siguientes consultas:
5.1- Obtener los libros publicados después de 2005
5.2- Obtener los clientes cuyo nombre contiene la letra “e”
5.3- Contar el número total de libros
5.4- ¿Cuál es el título del libro con el ID 3?
5.5- ¿Cuántos clientes tienen una dirección de correo electrónico que termina en “@gmail.com”? 5.6- ¿Cuál es el título del libro más antiguo?
5.7- JOIN: Obtener los libros junto con los nombres de los clientes que los poseen
5.8- JOIN: Obtener los clientes que no tienen libros
6-(1 pto) JDBC: usa tu propia plantilla JDBC o la que te pase el profesor. Realiza una consulta para ver todos los titulos y los autores de todos los libros desde un statement normal directo. Del tipo: System.out.println(“titulo: “ + resultado1.getString(“titulo”) + “, banda: “ + resultado1.getString(“banda”)
7- (1 pto) JDBC. Sobre esa misma plantilla, realiza un insert con un PreparedStatement para registrar una nueva fila en en la tabla Clientes. Verifica que aparece el nuevo libro en la base de datos. Del tipo:
String actualizar2 = “UPDATE discos SET lanzamiento = ? WHERE id = ?”; *
* el ejemplo es un UPDATE, no un INSERT como se está pidiendo. Se pueden introducir los datos por scanner o mediante asigna- ción de variables