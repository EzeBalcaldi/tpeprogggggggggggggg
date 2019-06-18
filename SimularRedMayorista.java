public class SimularRedMayorista {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Central c = new Central();
		Sucursal s = new Sucursal();
		Sucursal d = new Sucursal();
		Sucursal e = new Sucursal();
		c.agregarSucursal(s);
		c.agregarSucursal(d);
		c.agregarSucursal(e);
		c.imprimirEstado();
		//c.imprimirArreglo();
		c.setMaximo(0, 70);
		c.setMinimo(0, 50);
		c.setCantidad(0, 100);
		s.setCantidad(0, 40);
		s.setMaximo(0, 60);
		s.setMinimo(0, 45);
		//c.imprimirEstado();
		//c.adquirirProductos();
		c.completarProductos();
		//c.imprimirEstado(); 
		s.venderProducto(0, 50);
		//c.productosFaltantes(s);
		//c.adquirirProductos();
		//c.imprimirEstado();
		c.productosFaltantes(s);
	}

}
