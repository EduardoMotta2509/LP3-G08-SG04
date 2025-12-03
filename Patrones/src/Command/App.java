package Command;

public class App {
	public static void main(String[] args) {
		// 1. Crear el Receptor (El documento sobre el que se trabaja)
		Documento doc = new Documento();

		// 2. Crear los Comandos (Encapsulan la acción + el objeto que la realiza)
		CommandEditor cmdCopiar = new CopyCommand(doc);
		CommandEditor cmdPegar = new PasteCommand(doc);

		// 3. Crear los Invocadores (Los botones de la interfaz)
		Boton botonCopiar = new Boton();
		Boton botonPegar = new Boton();

		// 4. Configuración (Asignamos qué comando ejecuta cada botón)
		// Esto suele hacerse al iniciar la aplicación gráfica
		botonCopiar.setComando(cmdCopiar);
		botonPegar.setComando(cmdPegar);

		// ---------------------------------------------------------
		// SIMULACIÓN DE USO DEL USUARIO
		// ---------------------------------------------------------

		System.out.println("--- Usuario hace clic en 'Copiar' ---");
		botonCopiar.click(); // Internamente llama a cmdCopiar.execute() -> doc.copiar()

		System.out.println("\n--- Usuario hace clic en 'Pegar' ---");
		botonPegar.click();  // Internamente llama a cmdPegar.execute() -> doc.pegar()

		// Ejemplo de reutilización (Command permite reasignar acciones)
		System.out.println("\n--- Reasignando botón ---");
		botonCopiar.setComando(cmdPegar); // Ahora el botón de copiar pegará (error de config o cambio dinámico)
		botonCopiar.click(); 
	}
}