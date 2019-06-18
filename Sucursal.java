public class Sucursal {
	public final int MAXFIL = 3;
	public final int MAXCOL = 5;
	private int productos[][] = new int[MAXFIL][MAXCOL];
	public void  getProductos() {
			for(int j = 0; j<MAXCOL; j++){
				System.out.println("Id producto " +j + " min " +productos[1][j] + " cantidad " +productos[0][j] +" max " +productos[2][j]);
			}
		}
	public void setMaximo(int producto, int maximo){
		productos[2][producto]= maximo;
	}
	public int getMaximo(int producto){
		return productos[2][producto];
	}
	public void setMinimo(int producto, int minimo){
		productos[1][producto]= minimo;
	}
	public int getMinimo(int producto){
		return productos[1][producto];
	}
	public void setCantidad(int producto, int cantidad){
		productos[0][producto]= cantidad;
	}
	public void sumarCantidad(int producto, int cantidad){
		productos[0][producto]= productos[0][producto] + cantidad;
	}
	public int getCantidad(int producto){
		return productos[0][producto];
	}
	public void venderProducto(int producto, int cantidad){
		if(productos[0][producto] != -1){
			if((productos[0][producto]- cantidad) >= 0){
				productos[0][producto]= productos[0][producto] - cantidad;
				System.out.println("Vendiste " +cantidad+ " unidades del producto " +producto+ " ,quedaron " +productos[0][producto] +" en la sucursal");
			}else{
					System.out.println("No se puede vender esa cantidad, inserte un valor menor o igual a " +productos[0][producto]);
				}
		}else{
			System.out.println("Este producto no es operado en esta sucursal");

		}
		}
	public void inicializarSucursal(){
		for(int i = 0; i< MAXFIL; i++){
			for(int j = 0; j < MAXCOL; j++){
				productos[i][j] = -1;
			}
		}
	}
	}
