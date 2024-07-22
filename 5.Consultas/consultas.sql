/* 5- (4 ptos) Realiza las siguientes consultas: */
/* 5.1- Obtener los libros publicados después de 2005 */

SELECT * FROM libreria_examen.libros l 
WHERE any_publicacion > 2005;

/* 5.2- Obtener los clientes cuyo nombre contiene la letra “e” */

SELECT * FROM libreria_examen.clientes c 
WHERE nombre LIKE '%e%';

/* 5.3- Contar el número total de libros */

SELECT COUNT(*) AS total_libros FROM libreria_examen.libros l;

/* 5.4- ¿Cuál es el título del libro con el ID 3? */

SELECT * FROM libreria_examen.libros l 
WHERE id_libro = 3;

/* 5.5- ¿Cuántos clientes tienen una dirección de correo electrónico que termina en “@gmail.com”? */

SELECT COUNT(*) AS no_clientes_gmail FROM libreria_examen.clientes c 
WHERE email LIKE '%gmail.com';

/* 5.6- ¿Cuál es el título del libro más antiguo? */

SELECT titulo FROM libreria_examen.libros l
WHERE any_publicacion = (SELECT MIN(any_publicacion) FROM libreria_examen.libros);


/* 5.7- JOIN: Obtener los libros junto con los nombres de los clientes que los poseen */

SELECT * FROM libreria_examen.libros l 
JOIN libreria_examen.clientes c 
ON l.id_cliente = c.id_cliente ;


/* 5.8- JOIN: Obtener los clientes que no tienen libros */

SELECT c.id_cliente, c.nombre, c.email, COUNT(l.id_libro) AS numero_libros FROM libreria_examen.clientes c 
LEFT JOIN libreria_examen.libros l 
ON l.id_cliente = c.id_cliente
GROUP BY c.id_cliente, c.nombre, c.email
HAVING numero_libros = 0;