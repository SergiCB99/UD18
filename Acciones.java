import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import java.sql.Statement;

public class Acciones {

	public static Connection conexion;
	
	//METODO QUE ABRE LA CONEXION CON SERVER MYSQL
		public static void openConnection() {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conexion=DriverManager.getConnection("jdbc:mysql://192.168.93.201:3306?useTimezone=true&serverTimezone=UTC","remote","TsysteMS*2021");//credenciales temporales
				System.out.println("Server Connected");
				
			}catch(SQLException | ClassNotFoundException ex  ){
				System.out.println("No se ha podido conectar con mi base de datos");
				System.out.println(ex.getMessage());
				
			}
			
		}
			
		//METODO QUE CIERRA LA CONEXION CON SERVER MYSQL
		public static void closeConnection() {
			try {
		
				conexion.close();
				System.out.println("Server Disconnected");
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error cerrando conexion");
			}
		}
		
		//METODO QUE CREA LA BASE DE DATOS
		public static void createDB(String name) {
			try {
				String Query="CREATE DATABASE "+ name;
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("DB creada con exito!");
				
			JOptionPane.showMessageDialog(null, "Se ha creado la DB " +name+ "de forma exitosa.");
			}catch(SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error creando la DB.");
			}	
		}
		
		//CREATE TABLE
		public static void createFabricantes(String db) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "CREATE TABLE IF NOT EXISTS Fabricantes(\r\n" + 
						"codigo int AUTO_INCREMENT PRIMARY KEY,\r\n" + 
						"nombre VARCHAR(100)\r\n" + 
						");";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");
				
			}
			
		}
		
		public static void createArticulos(String db) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "CREATE TABLE IF NOT EXISTS Articulos( codigo int AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(100), precio int, nombre_fabricante int, KEY (nombre_fabricante), FOREIGN KEY (nombre_fabricante) REFERENCES Fabricantes (codigo));";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");
				
			}
			
		}
		
		public static void createDepartamentos(String db) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "CREATE TABLE IF NOT EXISTS Departamentos(\r\n" + 
						"codigo int AUTO_INCREMENT PRIMARY KEY,\r\n" + 
						"nombre VARCHAR(100),\r\n" + 
						"presupuesto int\r\n" + 
						");";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");
				
			}
			
		}
		
		public static void createEmpleados(String db) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "CREATE TABLE IF NOT EXISTS Empleados(\r\n" + 
						"DNI VARCHAR(8) PRIMARY KEY,\r\n" + 
						"nombre VARCHAR(100),\r\n" + 
						"apellidos VARCHAR(255),\r\n" + 
						"departamento int,\r\n" + 
						"KEY (departamento),\r\n" + 
						"FOREIGN KEY (departamento) REFERENCES Departamentos(codigo)\r\n" + 
						");";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");
				
			}
			
		}
		
		public static void createAlmacenes(String db) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "CREATE TABLE IF NOT EXISTS Almacenes(\r\n" + 
						"codigo int AUTO_INCREMENT PRIMARY KEY,\r\n" + 
						"lugar VARCHAR(100),\r\n" + 
						"capacidad int\r\n" + 
						");";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");
				
			}
			
		}
		
		public static void createCajas(String db) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "CREATE TABLE IF NOT EXISTS Cajas(\r\n" + 
						"NumReferencia CHAR(8) PRIMARY KEY,\r\n" + 
						"contenido VARCHAR(100),\r\n" + 
						"valor int,\r\n" + 
						"almacen int,\r\n" + 
						"KEY (almacen),\r\n" + 
						"FOREIGN KEY (almacen) REFERENCES Almacenes(codigo)\r\n" + 
						");";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");
				
			}
			
		}
		
		public static void createPeliculas(String db) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "CREATE TABLE IF NOT EXISTS Peliculas(\r\n" + 
						"codigo int AUTO_INCREMENT PRIMARY KEY,\r\n" + 
						"nombre VARCHAR(100),\r\n" + 
						"calificacionedad int\r\n" + 
						");";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");
				
			}
			
		}
		
		public static void createSalas(String db) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "CREATE TABLE IF NOT EXISTS Salas(\r\n" + 
						"codigo int AUTO_INCREMENT PRIMARY KEY,\r\n" + 
						"nombre VARCHAR(100),\r\n" + 
						"pelicula int,\r\n" + 
						"KEY (pelicula),\r\n" + 
						"FOREIGN KEY (pelicula) REFERENCES Peliculas(codigo)\r\n" + 
						");";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");
				
			}
			
		}
		
		public static void createDespachos(String db) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "CREATE TABLE IF NOT EXISTS Despachos(\r\n" + 
						"numero int PRIMARY KEY,\r\n" + 
						"capacidad int\r\n" + 
						");";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");
				
			}
			
		}
		
		public static void createDirectores(String db) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "CREATE TABLE IF NOT EXISTS Directores(\r\n" + 
						"DNI varchar(8) PRIMARY KEY,\r\n" + 
						"NomApels NVARCHAR(100),\r\n" + 
						"DNI_JEFE varchar(8),\r\n" + 
						"Despacho int,\r\n" + 
						"KEY (DNI_JEFE),\r\n" + 
						"FOREIGN KEY (DNI_JEFE) REFERENCES Directores(DNI) ON DELETE CASCADE ON UPDATE CASCADE,\r\n" + 
						"KEY (Despacho),\r\n" + 
						"FOREIGN KEY (Despacho) REFERENCES Despachos(numero) ON DELETE CASCADE ON UPDATE CASCADE\r\n" + 
						");";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");
				
			}
			
		}
		
		public static void createPiezas(String db) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "CREATE TABLE IF NOT EXISTS Piezas(\r\n" + 
						"codigo int auto_increment PRIMARY KEY,\r\n" + 
						"nombre NVARCHAR(100)\r\n" + 
						");";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");
				
			}
			
		}
		
		public static void createProveedores(String db) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "CREATE TABLE IF NOT EXISTS Proveedores(\r\n" + 
						"ID char(4) PRIMARY KEY,\r\n" + 
						"Nombre NVARCHAR(100)\r\n" + 
						");";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");
				
			}
			
		}
		
		public static void createSuministra(String db) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "CREATE TABLE IF NOT EXISTS Suministra(\r\n" + 
						"CodigoPieza int,\r\n" + 
						"IdProveedor CHAR(4),\r\n" + 
						"Precio int,\r\n" + 
						"primary key(CodigoPieza,IDProveedor),\r\n" + 
						"FOREIGN KEY (CodigoPieza) REFERENCES Piezas(codigo) ON DELETE CASCADE ON UPDATE CASCADE,\r\n" + 
						"FOREIGN KEY (IdProveedor) REFERENCES Proveedores(ID) ON DELETE CASCADE ON UPDATE CASCADE\r\n" + 
						");";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");
				
			}
			
		}
		
		public static void createCientificos(String db) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "CREATE TABLE IF NOT EXISTS Cientificos(\r\n" + 
						"DNI varchar(8) PRIMARY KEY,\r\n" + 
						"NomApels NVARCHAR(255)\r\n" + 
						");";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");
				
			}
			
		}
		
		public static void createProyecto(String db) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "CREATE TABLE IF NOT EXISTS Proyecto(\r\n" + 
						"ID char(4) PRIMARY KEY,\r\n" + 
						"Nombre NVARCHAR(255),\r\n" + 
						"Horas int\r\n" + 
						");";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");
				
			}
			
		}
		
		public static void createAsignado_A(String db) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "CREATE TABLE IF NOT EXISTS Asignado_A(\r\n" + 
						"Cientifico varchar(8),\r\n" + 
						"Proyecto CHAR(4),\r\n" + 
						"primary key(Cientifico,Proyecto),\r\n" + 
						"FOREIGN KEY (Cientifico) REFERENCES Cientificos(DNI) ON DELETE CASCADE ON UPDATE CASCADE,\r\n" + 
						"FOREIGN KEY (Proyecto) REFERENCES Proyecto(ID) ON DELETE CASCADE ON UPDATE CASCADE\r\n" + 
						");";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");
				
			}
			
		}
		
		public static void createCajeros(String db) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "CREATE TABLE IF NOT EXISTS Cajeros(\r\n" + 
						"Codigo int auto_increment PRIMARY KEY,\r\n" + 
						"NomApels NVARCHAR(255)\r\n" + 
						");";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");
				
			}
			
		}
		
		public static void createProductos(String db) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "CREATE TABLE IF NOT EXISTS Productos(\r\n" + 
						"Codigo int auto_increment PRIMARY KEY,\r\n" + 
						"Nombre NVARCHAR(100),\r\n" + 
						"Precio int\r\n" + 
						");";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");
				
			}
			
		}
		
		public static void createMaquinas_Registradoras(String db) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "CREATE TABLE IF NOT EXISTS Maquinas_Registradoras(\r\n" + 
						"Codigo int auto_increment PRIMARY KEY,\r\n" + 
						"Piso int\r\n" + 
						");";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");
				
			}
			
		}
		
		public static void createVenta(String db) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "CREATE TABLE IF NOT EXISTS Venta(\r\n" + 
						"Cajero int,\r\n" + 
						"Maquina int,\r\n" + 
						"Producto int,\r\n" + 
						"primary key(Cajero,Maquina,Producto),\r\n" + 
						"FOREIGN KEY (Cajero) REFERENCES Cajeros(Codigo) ON DELETE CASCADE ON UPDATE CASCADE,\r\n" + 
						"FOREIGN KEY (Maquina) REFERENCES Maquinas_Registradoras(Codigo) ON DELETE CASCADE ON UPDATE CASCADE,\r\n" + 
						"FOREIGN KEY (Producto) REFERENCES Productos(Codigo) ON DELETE CASCADE ON UPDATE CASCADE\r\n" + 
						");";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");
				
			}
			
		}
		
		public static void createFacultad(String db) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "CREATE TABLE IF NOT EXISTS Facultad(\r\n" + 
						"Codigo int PRIMARY KEY,\r\n" + 
						"Nombre NVARCHAR(100)\r\n" + 
						");";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");
				
			}
			
		}
		
		public static void createInvestigadores(String db) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "CREATE TABLE IF NOT EXISTS Investigadores(\r\n" + 
						"DNI varchar(8) PRIMARY KEY,\r\n" + 
						"NomApels NVARCHAR(255),\r\n" + 
						"Facultad int,\r\n" + 
						"FOREIGN KEY (Facultad) REFERENCES Facultad(Codigo) ON DELETE CASCADE ON UPDATE CASCADE\r\n" + 
						");";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");
				
			}
			
		}
		
		public static void createEquipos(String db) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "CREATE TABLE IF NOT EXISTS Equipos(\r\n" + 
						"NumSerie char(4) PRIMARY KEY,\r\n" + 
						"Nombre NVARCHAR(100),\r\n" + 
						"Facultad int,\r\n" + 
						"FOREIGN KEY (Facultad) REFERENCES Facultad(Codigo) ON DELETE CASCADE ON UPDATE CASCADE\r\n" + 
						");";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");
				
			}
			
		}
		
		public static void createReserva(String db) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = "CREATE TABLE IF NOT EXISTS Reserva(\r\n" + 
						"DNI varchar(8),\r\n" + 
						"NumSerie char(4),\r\n" + 
						"Comienzo datetime,\r\n" + 
						"Fin datetime,\r\n" + 
						"primary key(DNI,NumSerie),\r\n" + 
						"FOREIGN KEY (DNI) REFERENCES Investigadores(DNI) ON DELETE CASCADE ON UPDATE CASCADE,\r\n" + 
						"FOREIGN KEY (NumSerie) REFERENCES Equipos(NumSerie) ON DELETE CASCADE ON UPDATE CASCADE\r\n" + 
						");";
				Statement st= conexion.createStatement();
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");
				
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");
				
			}
			
		}
		
		public static void insertFabricante(String db,String name) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO Fabricantes (Nombre) VALUE(" 
						+ "\"" + name + "\"); ";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		public static void insertArticulos(String db, String name, int precio, int nombre_f) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO Articulos (Nombre, Precio, Nombre_fabricante) VALUE(" 
						+ "\"" + name + "\", "
						+ "\"" + precio + "\", "
						+ "\"" + nombre_f + "\"); ";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		public static void insertDepartamento(String db,String name, int presupuesto) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO Departamentos (Nombre, Presupuesto) VALUE(" 
						+ "\"" + name + "\", "
						+ "\"" + presupuesto + "\"); ";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		public static void insertEmpleados(String db,String DNI, String name,String apellidos,int departamento) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO Empleados (DNI,Nombre,Apellidos,Departamento) VALUE(" 
						+ "\"" + DNI + "\", "
						+ "\"" + name + "\", "
						+ "\"" + apellidos + "\", "
						+ "\"" + departamento + "\"); ";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		public static void insertAlmacenes(String db,String lugar, int capacidad) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO Almacenes (lugar,capacidad) VALUE(" 
						+ "\"" + lugar + "\", "
						+ "\"" + capacidad + "\"); ";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		public static void insertCajas(String db,String num_referencia,String contenido,int valor,int almacen) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO Cajas (NumReferencia,contenido,valor,almacen) VALUE(" 
						+ "\"" + num_referencia + "\", "
						+ "\"" + contenido + "\", "
						+ "\"" + valor + "\", "
						+ "\"" + almacen + "\"); ";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		public static void insertPelicula(String db,String nombre,int califedad) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO Peliculas (nombre,calificacionedad) VALUE(" 
						+ "\"" + nombre + "\", "
						+ "\"" + califedad + "\"); ";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		public static void insertSalas(String db,String nombre,int pelicula) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO Salas (nombre,pelicula) VALUE(" 
						+ "\"" + nombre + "\", "
						+ "\"" + pelicula + "\"); ";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		public static void insertDespachos(String db,int numero,int capacidad) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO Despachos (numero,capacidad) VALUE(" 
						+ "\"" + numero + "\", "
						+ "\"" + capacidad + "\"); ";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		public static void insertDirectores(String db,String DNI,String NomApels,String DNI_Jefe,int despacho) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO Directores (DNI,NomApels,DNI_JEFE,Despacho) VALUE(" 
						+ "\"" + DNI + "\", "
						+ "\"" + NomApels + "\", "
						+ "\"" + DNI_Jefe + "\", "
						+ "\"" + despacho + "\"); ";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		public static void insertPiezas(String db,String nombre) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO Piezas (nombre) VALUE(" 
						+ "\"" + nombre + "\"); ";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		public static void insertProveedores(String db,int id,String nombre) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO Proveedores (id,nombre) VALUE(" 
						+ "\"" + id + "\", "
						+ "\"" + nombre + "\"); ";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		public static void insertSuministra(String db,int id_pieza,int id_proveedor,int precio) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO Suministra (CodigoPieza,IDProveedor,Precio) VALUE(" 
						+ "\"" + id_pieza + "\", "
						+ "\"" + id_proveedor + "\", "
						+ "\"" + precio + "\"); ";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		public static void insertCientificos(String db,String dni,String NomApels) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO Cientificos (DNI,NomApels) VALUE(" 
						+ "\"" + dni + "\", "
						+ "\"" + NomApels + "\"); ";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		public static void insertProyectos(String db,int id,String Nombre,int horas) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO Proyecto (ID,Nombre,Horas) VALUE(" 
						+ "\"" + id + "\", "
						+ "\"" + Nombre + "\", "
						+ "\"" + horas + "\"); ";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		public static void insertAsignado_A(String db,String cientifico,int proyecto) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO Asignado_A (Cientifico,Proyecto) VALUE(" 
						+ "\"" + cientifico + "\", "
						+ "\"" + proyecto + "\"); ";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		public static void insertCajeros(String db,String NomApels) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO Cajeros (NomApels) VALUE(" 
						+ "\"" + NomApels + "\"); ";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		public static void insertProductos(String db,String nombre,int precio) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO Productos (Nombre,Precio) VALUE(" 
						+ "\"" + nombre + "\", "
						+ "\"" + precio + "\"); ";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		public static void insertMaquinas_Registradoras(String db,int piso) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO Maquinas_Registradoras (Piso) VALUE(" 
						+ "\"" + piso + "\"); ";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		public static void insertVenta(String db,int cajero,int maquina,int producto) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO Venta (Cajero,Maquina,Producto) VALUE(" 
						+ "\"" + cajero + "\", "
						+ "\"" + maquina + "\", "
						+ "\"" + producto + "\"); ";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		public static void insertFacultad(String db,int codigo,String nombre) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO Facultad (Codigo,Nombre) VALUE(" 
						+ "\"" + codigo + "\", "
						+ "\"" + nombre + "\"); ";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		public static void insertEquipos(String db,int numserie,String nombre,int facultad) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO Equipos (NumSerie,Nombre,Facultad) VALUE(" 
						+ "\"" + numserie + "\", "
						+ "\"" + nombre + "\", "
						+ "\"" + facultad + "\"); ";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		public static void insertInvestigadores(String db,String DNI,String nombre,int facultad) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO Investigadores (DNI,NomApels,Facultad) VALUE(" 
						+ "\"" + DNI + "\", "
						+ "\"" + nombre + "\", "
						+ "\"" + facultad + "\"); ";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		public static void insertReserva(String db,String dni,int numserie,String fecha_inicio,String fecha_fin) {
			try {
				String Querydb = "USE "+db+";";
				Statement stdb= conexion.createStatement();
				stdb.executeUpdate(Querydb);
							
				String Query = "INSERT INTO Reserva (DNI,NumSerie,Comienzo,Fin) VALUE(" 
						+ "\"" + dni + "\", "
						+ "\"" + numserie + "\", "
						+ "\"" + fecha_inicio + "\", "
						+ "\"" + fecha_fin + "\"); ";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);
				
				System.out.println("Datos almacenados correctamente");;
				
			} catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}
						
		}
		
		
}