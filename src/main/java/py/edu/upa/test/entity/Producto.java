package py.edu.upa.test.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="producto", schema="public")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "Producto_id_producto_seq", sequenceName = "Producto_id_producto_seq", allocationSize = 1, schema= "public")
    @GeneratedValue(generator = "Producto_id_producto_seq")
	
	@Column(name="id_producto")
	private Integer idProducto;
	

	private String nombre;

	private Integer precio;
	
	private String descripcion;

	private Integer stock;
	
	private boolean favorito;

	public Producto() {
	}
	
	@ManyToOne
	@JoinColumn(name="id_proveedor")
	Proveedor proveedor;

	public Boolean getFavorito () {
		return this.favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}


	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}


	}
