package agenda.telefonica.entidad;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;










/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity

public class Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private String cedula;
	private String  nombre;
	private String apellido;
	@Column( unique = true , nullable = false)
	private String correo;
	private String password;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	private Set<Telefono> telefonos ;

	public Usuario() {
		super();
		
	}
	public Usuario(String cedula,String nombre,String apellido,String correo,String password) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.password = password;
	}
	
	//generar getters and setters
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Telefono> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(Set<Telefono> telefonos) {
		this.telefonos = telefonos;
	}
	public void addTelefonos(Telefono telefono) {
		this.telefonos.add(telefono);
	}

	public void removeTelefono(Telefono telefono) {
		this.telefonos.remove(telefono);
	}

	@Override
	public String toString() {
		return "Usuario [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo
				+ ", password=" + password + ", telefonos=" + telefonos + "]";
	}
	
	
	
   
}
