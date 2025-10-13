package EP3Modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Archivo {
	private File file;
	
    public Archivo(String nombreArchivo) {
        this.file = new File(nombreArchivo);
    }
    
    public void guardarEmpleados(List<Empleado> empleados) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            for (Empleado e : empleados) {
                pw.println(e);
            }
        } catch (IOException e) {
            System.out.println("Error al guardar archivo: " + e.getMessage());
        }
    }
    
    
    
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
    
    
}
