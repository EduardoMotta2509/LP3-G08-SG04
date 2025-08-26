package EP1;

import java.util.Scanner;

public class Gestor {
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		Administrador admin = new Administrador("Administrador general", "admin");
		
		Docente d1 = new Docente(0, "Mario Santillana");
        Docente d2 = new Docente(0, "Karime Guevara");
        Docente d3 = new Docente(0, "Mary Dueñas");
        Docente d4 = new Docente(0, "Whinders Fernandez");
        Docente d5 = new Docente(0, "Wilson Cabana");
        Docente d6 = new Docente(0, "Victor Paniagua");
        Docente d7 = new Docente(0, "Alejandra Salas");
        Docente d8 = new Docente(0, "Karina Rosas");
        Docente d9 = new Docente(0, "Javier Angulo");
        Docente d10 = new Docente(0, "Jose Esquicha");
        Docente d11 = new Docente(0, "Eveling Castro");
        Docente d12 = new Docente(0, "María Vasquez");
        
        Curso[] cursos = new Curso[10];
        cursos[0] = new Curso("Lenguajes de Programación III", d1, 3, 5, "Programación", "A1");
        cursos[1] = new Curso("Lenguajes de Programación III", d2, 3, 5, "Programación", "A2");
        cursos[2] = new Curso("Cálculo Integral", d3, 3, 5, "Matemáticas", "B1");
        cursos[3] = new Curso("Cálculo Integral", d3, 3, 5, "Matemáticas", "B2");
        cursos[4] = new Curso("Física II", d4, 3, 5, "Ciencias", "C1");
        cursos[5] = new Curso("Física II", d5, 3, 5, "Ciencias", "C2");
        cursos[6] = new Curso("Fundamentos de SI", d6, 3, 5, "Informática", "D1");
        cursos[7] = new Curso("Computación en Red I", d8, 3, 5, "Redes", "E1");
        cursos[8] = new Curso("Tutoría", d10, 2, 5, "Formación", "F1");
        cursos[9] = new Curso("Argumentación", d12, 2, 5, "Talleres", "G1");
        
        Alumno[] alumnos = new Alumno[14];
        alumnos[0] = new Alumno("Nicolás Calle");
        alumnos[1] = new Alumno("Alvaro Chata");
        alumnos[2] = new Alumno("Gabriel Cuba");
        alumnos[3] = new Alumno("Luis Fernandez");
        alumnos[4] = new Alumno("Leandro Lagos");
        alumnos[5] = new Alumno("Andre Lazo");
        alumnos[6] = new Alumno("Adrian Maldonado");
        alumnos[7] = new Alumno("Samir Mancilla");
        alumnos[8] = new Alumno("Carlos Mita");
        alumnos[9] = new Alumno("Sebastián Montoya");
        alumnos[10] = new Alumno("Orlando Palao");
        alumnos[11] = new Alumno("Adriano Soca");
        alumnos[12] = new Alumno("Alexis Subia");
        alumnos[13] = new Alumno("Eduardo Motta");
        
        int codigo;
        do {
        	System.out.println("----Sistema de Matrícula UCSM----");
        	System.out.println("Por favor, ingrese su código: (Ingrese 0 si desea salir)");
        	codigo=sc.nextInt();
        	if (codigo==0) {
        		break;
        	}
        	
        	if(codigo==admin.getCodigo()) {
        		System.out.println("Ingrese contraseña de administrador: ");
        		sc.nextLine();
        		String contraseña= sc.nextLine();
        		if (admin.login(contraseña)) {
        			int opcion;
        			do {
        				System.out.println("Bienvenido administrador, seleccione una opción: ");
        				System.out.println("0. Salir");
        				System.out.println("1. Ver lista de alumnos");
        				System.out.println("2. Ver cursos disponibles");
        				System.out.println("3. Ver alumnos matriculados en cada curso");
        				opcion=sc.nextInt();
        				
        				switch(opcion) {
        				case 1:
        					for (Alumno a:alumnos) {
        						a.informacion();
        						System.out.println("--------------------");
        					}
        					break;
        				case 2:
        					for (Curso c: cursos) {
        						c.info();
        						System.out.println("--------------------");
        					}
        					break;
        				case 3:
        					for (Curso c: cursos) {
        						c.lista();
        						System.out.println("--------------------");
        					}
        					break;
        				}        				
        			}while (opcion!=0);
        		}else {
        			System.out.println("Contraseña incorrecta. ");
        		}
        		
        	}else {
        		int validacion=0;
        		Alumno cuentaActiva=null;
        		for (Alumno a:alumnos) {
        			if (a.getCodigo()==codigo) {
        				validacion++;
        				cuentaActiva=a;
        			}
        		}
        		if (validacion==0) {
        			System.out.println("CÓDIGO NO ENCONTRADO, INGRESE DE NUEVO");
        		}else {
        			System.out.println("Bienvenido "+cuentaActiva);
        			int opcion;
        			cuentaActiva.informacion();
        			do {
        				System.out.println("Seleccione una opción: ");
        				System.out.println("0. Salir");
        				System.out.println("1. Ver cursos disponibles");
        				System.out.println("2. Matricularse en un curso");
        				System.out.println("3. Ver información");
        				opcion=sc.nextInt();
        				
        				switch(opcion) {
        				case 1:
        					for (int i=0; i<cursos.length;i++) {
        						System.out.println("\n"+(i+1)+".");
        						cursos[i].info();
        					}
        					break;
        				case 2:
        					int cursoSelec=0;
        					do{
        						System.out.println("Ingrese el número del curso: ");
        						cursoSelec=sc.nextInt()-1;        							
        						if (cursoSelec>=cursos.length || cursoSelec<0) {
        							System.out.println("ERROR, curso no válido");
        						}else {
        							cuentaActiva.matricular(cursos[cursoSelec]);
        						}
        						
        					}while (cursoSelec>cursos.length && cursoSelec<0);
        					break;
        				case 3:
        					cuentaActiva.informacion();
        					break;
        				}
        			}while (opcion!=0);
        		}
        	}
        	
        }while (codigo!=0);
	}

}
