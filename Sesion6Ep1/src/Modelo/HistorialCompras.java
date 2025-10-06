package Modelo;

import java.util.ArrayList;

public class HistorialCompras {
	private ArrayList<Compra> historialCompras;
	
	public HistorialCompras() {
		historialCompras=new ArrayList<>();
	}
	
	public ArrayList<Compra> getHistorialCompras(){
		return historialCompras;
	}
}
