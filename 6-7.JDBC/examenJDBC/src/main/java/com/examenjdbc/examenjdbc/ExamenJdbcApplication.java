package com.examenjdbc.examenjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.relational.core.sql.Select;

import com.examenjdbc.examenjdbc.metodos.Metodos;

@SpringBootApplication
public class ExamenJdbcApplication {

	public static void main(String[] args) {

		System.out.println("Bienvenido a la Biblioteca / Libreria 😄");
		System.out.println();
		Connection conexion = null;
		Statement stat = null;
		Scanner scan = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/libreria_examen", "root", "");
			System.out.println("Conexion creada con exito.");
		} catch (Exception e) {
			System.out.println("No se ha podido establecer la conexion.");
		}

		try {
			stat = conexion.createStatement();
			System.out.println("Statement creado con exito.");
		} catch (Exception e) {
			System.out.println("No se ha podido crear el Statement");

		}
		int opcion;
		boolean validar = false;
		while (!validar) {
			System.out.println("¿Que quieres hacer?");
			System.out.println("1. Consultar titulos y autores de todos los libros.");
			System.out.println("2. Crear un nuevo libro en la base de datos.");
			System.out.println("0. Salir");
			System.out.print("Opcion: ");
			opcion = Metodos.validarInt(scan);

			switch (opcion) {
				case 1:
					System.out.println("Los titulos y los autores son:");
					System.out.println();
					try {
						ResultSet resultado = stat.executeQuery("SELECT titulo, autor FROM libreria_examen.libros");
						while (resultado.next()) {
							System.out.println("Titulo: " + resultado.getString("titulo") + ", Autor: "
									+ resultado.getString("autor"));
						}
						System.out.println();

					} catch (Exception e) {
						System.out.println("Error en la consulta.");
					}

					break;
				case 2:
					System.out.println("Vamos a añadir un libro nuevo.");
					System.out.println();
					System.out.print("Titulo: ");
					String titulo = scan.nextLine();
					System.out.print("Autor: ");
					String autor = scan.nextLine();
					System.out.print("Año Publicacion: ");
					int any = Metodos.validarInt(scan);
					System.out.print("Id Cliente: ");
					int cliente = Metodos.validarInt(scan);

					String query = "INSERT INTO libreria_examen.libros (titulo, autor, any_publicacion, id_cliente) VALUES(?,?,?,?);";

					try{
						PreparedStatement preparedQuery = conexion.prepareStatement(query);
						preparedQuery.setString(1, titulo);
						preparedQuery.setString(2, autor);
						preparedQuery.setInt(3, any);
						preparedQuery.setInt(4,cliente);
						preparedQuery.execute();
						System.out.println("Libro insertado correctamente al cliente "+cliente);
						System.out.println();

					}
					catch(Exception e){
						System.out.println("Se ha producido un error en la creación del libro. Recuerda que el cliente al que está asociado debe existir.");
					}

					break;
				case 0:
					validar = true;
					System.out.println("Gracias por venir! Nos vemos otro día!");
					break;
				default:
					System.out.println("Introduce una opción disponible");
					break;
			}

		}

	}

}
