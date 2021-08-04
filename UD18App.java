
public class UD18App {

	public static void main(String[] args) {

		Acciones.openConnection();
		Acciones.createDB("UD18Ejercicio1");
			Acciones.createFabricantes("UD18Ejercicio1");
				Acciones.insertFabricante("UD18Ejercicio1", "Sergi");
			Acciones.createArticulos("UD18Ejercicio1");
				Acciones.insertArticulos("UD18Ejercicio1", "Placa Base", 250,1);
		Acciones.createDB("UD18Ejercicio2");
			Acciones.createDepartamentos("UD18Ejercicio2");
				Acciones.insertDepartamento("UD18Ejercicio2", "Departamento 1", 40000);
			Acciones.createEmpleados("UD18Ejercicio2");
				Acciones.insertEmpleados("UD18Ejercicio2", "12345678", "Sergi", "CB", 1);
		Acciones.createDB("UD18Ejercicio3");
			Acciones.createAlmacenes("UD18Ejercicio3");
				Acciones.insertAlmacenes("UD18Ejercicio3", "Reus", 5);
			Acciones.createCajas("UD18Ejercicio3");
				Acciones.insertCajas("UD18Ejercicio3","14523", "Papel", 25, 1);
		Acciones.createDB("UD18Ejercicio4");
			Acciones.createPeliculas("UD18Ejercicio4");
				Acciones.insertPelicula("UD18Ejercicio4", "Toy Story", 0);
			Acciones.createSalas("UD18Ejercicio4");
				Acciones.insertSalas("UD18Ejercicio4", "Sala 1", 1);
		Acciones.createDB("UD18Ejercicio5");
			Acciones.createDespachos("UD18Ejercicio5");
				Acciones.insertDespachos("UD18Ejercicio5", 1, 5);
			Acciones.createDirectores("UD18Ejercicio5");
				Acciones.insertDirectores("UD18Ejercicio5", "12345678", "Sergi CB","12345678", 1);
		Acciones.createDB("UD18Ejercicio6");
			Acciones.createPiezas("UD18Ejercicio6");
				Acciones.insertPiezas("UD18Ejercicio6", "Pieza 1");
			Acciones.createProveedores("UD18Ejercicio6");
				Acciones.insertProveedores("UD18Ejercicio6", 1, "Proveedor 1");
			Acciones.createSuministra("UD18Ejercicio6");
				Acciones.insertSuministra("UD18Ejercicio6", 1, 1, 50);
		Acciones.createDB("UD18Ejercicio7");
			Acciones.createCientificos("UD18Ejercicio7");
				Acciones.insertCientificos("UD18Ejercicio7","87654321","Sergi CB");
			Acciones.createProyecto("UD18Ejercicio7");
				Acciones.insertProyectos("UD18Ejercicio7", 1, "Proyecto 1", 150);
			Acciones.createAsignado_A("UD18Ejercicio7");
				Acciones.insertAsignado_A("UD18Ejercicio7", "87654321", 1);
		Acciones.createDB("UD18Ejercicio8");
			Acciones.createCajeros("UD18Ejercicio8");
				Acciones.insertCajeros("UD18Ejercicio8", "SergiCB");
			Acciones.createProductos("UD18Ejercicio8");
				Acciones.insertProductos("UD18Ejercicio8", "Producto 1", 10);
			Acciones.createMaquinas_Registradoras("UD18Ejercicio8");
				Acciones.insertMaquinas_Registradoras("UD18Ejercicio8", 1);
			Acciones.createVenta("UD18Ejercicio8");
				Acciones.insertVenta("UD18Ejercicio8", 1, 1, 1);
		Acciones.createDB("UD18Ejercicio9");
			Acciones.createFacultad("UD18Ejercicio9");
				Acciones.insertFacultad("UD18Ejercicio9", 1, "Facultad 1");
			Acciones.createInvestigadores("UD18Ejercicio9");
				Acciones.insertInvestigadores("UD18Ejercicio9", "12345678","Sergi", 1);
			Acciones.createEquipos("UD18Ejercicio9");
				Acciones.insertEquipos("UD18Ejercicio9", 1, "Equipo 1", 1);
			Acciones.createReserva("UD18Ejercicio9");
				Acciones.insertReserva("UD18Ejercicio9", "12345678", 1, "2021-7-27", "2021-7-30");
			
		Acciones.closeConnection();
		
	}
	
}
