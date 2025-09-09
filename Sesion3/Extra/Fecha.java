package Actividad1;

public class Fecha{
	public int dia, mes, anio;

	public Fecha(int dia, int mes, int anio) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}
	
	public boolean antesQue(Fecha f2) {
		if( anio != f2.anio) {
			return anio<f2.anio;
		}
		if( mes!= f2.mes) {
			return mes<f2.mes;
		}
		return dia<f2.dia;
	}
	
	public boolean despuesQue(Fecha f2) {
		if( anio != f2.anio) {
			return anio>f2.anio;
		}
		if( mes!= f2.mes) {
			return mes>f2.mes;
		}
		return dia>=f2.dia;
	}
	
	public boolean estaEntre(Fecha inicio, Fecha fin) {
		return 	!this.antesQue(inicio) && !this.despuesQue(fin);
	}

	public String toString() {
		return dia+"/"+mes+"/"+anio;
	}
}
