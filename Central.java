

public class Central {
	final int MAXSUC = 10;
	final int MAXFIL = 3;
	final int MAXCOL = 5;
	private Sucursal[] sucursales = new Sucursal[MAXSUC];
	private int cantidadSucursales = 0;
	private int productos[][] = new int[MAXFIL][MAXCOL];
	public void imprimirEstado(){
		this.getProductos();
		for(int i = 0; i < sucursales.length; i++){
			if(sucursales[i] != null){
				System.out.println("Sucursal " +i);
				sucursales[i].getProductos();
			}
		}
	}
	public void imprimirArreglo(){
		for(int i = 0; i < sucursales.length; i++){
			System.out.println(sucursales[i]);
		}
	}
	public void getProductos() {
		System.out.println("Central");
		for(int i = 0; i< 1; i++){
			for(int j = 0; j<MAXCOL; j++){
				System.out.println("Id producto " +j + " min " +productos[1][j] + " cantidad " +productos[0][j] +" max " +productos[2][j]);
			}
		}
	}
	public void setProductos(int productos[][]) {
		this.productos = productos;
	}
	public void agregarSucursal(Sucursal s){
		boolean insertado = false;
		while(cantidadSucursales < MAXSUC -1 && !insertado){
			if(sucursales[cantidadSucursales] == null){
				s.inicializarSucursal();
				sucursales[cantidadSucursales] = s;
				insertado = true;	
			}
			cantidadSucursales++;
		}
		}
	public void setMaximo(int producto, int maximo){
		productos[2][producto]= maximo;
	}
	public int getMaximo(int producto){
		return 	productos[2][producto];
	}
	public int getMinimo(int producto){
		return 	productos[1][producto];
	}
	public int getCantidad(int producto){
		return productos[0][producto];
	}
	public void setMinimo(int producto, int minimo){
		productos[1][producto]= minimo;
	}
	public void setCantidad(int producto, int cantidad){
		productos[0][producto]= cantidad;
	}
	public void restarCantidad(int producto, int cantidad){
		productos[0][producto]=  productos[0][producto] - cantidad;	
	}
	public void productosFaltantes(Sucursal s){
		for(int i = 0; i<cantidadSucursales; i++){
				for(int j = 0; j< MAXCOL; j++){
					if(sucursales[i].getMinimo(j)> sucursales[i].getCantidad(j)){
						int cantidad =((sucursales[i].getMaximo(j)+sucursales[i].getMinimo(j))/2) - sucursales[i].getCantidad(j);
						System.out.println("en la sucursal " +i + " se necesitan " +cantidad+ " del producto " + j);

			}	
			}
		}
	}
	public void completarProductos(){
		for(int i = 0; i<cantidadSucursales; i++){
			for(int j = 0; j< MAXCOL; j++){
				if(sucursales[i].getMinimo(j)> sucursales[i].getCantidad(j)){
					int cantidad =((sucursales[i].getMaximo(j)+sucursales[i].getMinimo(j))/2) - sucursales[i].getCantidad(j);
					if((cantidad < this.getCantidad(j)) && (this.getCantidad(j) - cantidad >= 0)){
						sucursales[i].sumarCantidad(j, cantidad);
						this.restarCantidad(j, cantidad);
						System.out.println("Se restaron " +cantidad+ " del producto "+j+ " ,quedaron " +this.getCantidad(j)+" en la central.");
					}
					else{
						System.out.println("cantidad de producto numero " +j +" insuficientes en la central");
					}
		}	
		}
	}
	}
//	public void adquirirProductos(){
//		int aux = 0;
//		int aux1 = 0;
//		int aux2 = 0;
//		int aux3 = 0;
//		int aux4 = 0;
//		for(int i = 0; i < cantidadSucursales; i++){
//			for(int j = 0; j < MAXCOL; j++){
//				//aux =sucursales[i].getMaximo(j) - sucursales[i].getMinimo(j);
//				//System.out.println(aux);
//				if(j == 0){
//					aux += sucursales[i].getMaximo(j) - sucursales[i].getCantidad(j);
//				}
//				if(j == 1){
//					aux1 += sucursales[i].getMaximo(j) - sucursales[i].getCantidad(j);
//				}
//				if(j == 2){
//					aux2 += sucursales[i].getMaximo(j) - sucursales[i].getCantidad(j);
//				}
//				if(j == 3){
//					aux3 += sucursales[i].getMaximo(j) - sucursales[i].getCantidad(j);
//				}
//				if(j == 4){
//					aux4 += sucursales[i].getMaximo(j) - sucursales[i].getCantidad(j);
//				}
//			}
//		}
//			for(int a = 0; a < 1; a++){
//				for(int b = 0; b < MAXCOL; b++){
//					if(b == 0){
//						aux += this.getMaximo(b) - this.getCantidad(b);
//					}
//					if(b == 1){
//						aux1 += this.getMaximo(b) - this.getCantidad(b);
//					}
//					if(b == 2){
//						aux2 += this.getMaximo(b) - this.getCantidad(b);
//					}
//					if(b == 3){
//						aux3 += this.getMaximo(b) - this.getCantidad(b);
//					}
//					if(b == 4){
//						aux4 += this.getMaximo(b) - this.getCantidad(b);
//					}
//					
//				}
//			}
//			System.out.println("Del producto 0 se adquirieron " +aux );
//			this.sumarCantidad(0, aux);
//			System.out.println("Del producto 1 se adquirieron " +aux1 );
//			this.sumarCantidad(1, aux1);
//			System.out.println("Del producto 2 se adquirieron " +aux2 );
//			this.sumarCantidad(2, aux2);
//			System.out.println("Del producto 3 se adquirieron " +aux3 );
//			this.sumarCantidad(3, aux3);
//			System.out.println("Del producto 4 se adquirieron " +aux4 );
//			this.sumarCantidad(4, aux4);
//	}
	public void adquirirProductos(){
		int aux = 0;
		for(int j = 0; j < MAXCOL; j++){
			for(int i = 0; i < cantidadSucursales; i++){
					aux += sucursales[i].getMaximo(j) - sucursales[i].getCantidad(j);
			}
			aux += this.getMaximo(j) - this.getCantidad(j);
			System.out.println("Del producto " + j + " se adquirieron " + aux );
			aux = 0;
		}
	}
	
	public void inicializarCentral(){
		for(int i = 0; i< MAXFIL; i++){
			for(int j = 0; j < MAXCOL; j++){
				productos[i][j] = 0;
			}
		}
	}
	public int getCantidadSucursales(){
		return cantidadSucursales;
	}
	public void sumarCantidad(int producto, int cantidad){
		productos[0][producto]= productos[0][producto] + cantidad;
	}
	
}