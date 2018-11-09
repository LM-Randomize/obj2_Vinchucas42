package main.java;

public class Ubicacion {
	
	private double latitud;
	

	private double longitud;
	
	public Ubicacion(double latitud, double longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
	}
	
	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	//Retorna la distancia entre las coordenadas de la ubicacion actual y la que recibe por parametro.
	public double distanciaCon(Ubicacion ubicacion) {
		double lat1 = this.latitud;
		double lng1 = this.longitud;
		double lat2 = ubicacion.getLatitud();
		double lng2 = ubicacion.getLongitud();
		
        //double radioTierra = 3958.75;//en millas  
        double radioTierra = 6371;//en km  
        double dLat = Math.toRadians(lat2 - lat1);  
        double dLng = Math.toRadians(lng2 - lng1);  
        double sindLat = Math.sin(dLat / 2);  
        double sindLng = Math.sin(dLng / 2);  
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)  
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));  
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));  
        double distancia = radioTierra * va2;  
   
        return distancia;  
	}
	
}
