package py.edu.upa.test.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="proveedor", schema="public")
public class Proveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "Proveedor_id_Proveedor_seq_1", sequenceName = "Proveedor_id_Proveedor_seq_1", allocationSize = 1, schema= "public")
    @GeneratedValue(generator = "Proveedor_id_Proveedor_seq_1")
	
	@Column(name="id_proveedor")
	private Integer idProveedor;

	private Integer ruc;

	private Integer telefono;
	
	private String nombre;

	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Proveedor() {
	}

	public Integer getId_producto() {
		return idProveedor;
	}

	public void setId_producto(Integer id_producto) {
		this.idProveedor = id_producto;
	}

	public Integer getRuc() {
		return ruc;
	}

	public void setRuc(Integer ruc) {
		this.ruc = ruc;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	
}