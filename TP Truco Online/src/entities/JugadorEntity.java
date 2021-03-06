package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="jugadores")
public class JugadorEntity {
	@Id
	private String apodo;
	private String email;
	private String password;
	@Embedded
	private CategoriaEntity categoria;
	@ManyToMany(mappedBy="miembros")
	private List<GrupoEntity> grupos;
	private String loggedSession;
	
	public List<GrupoEntity> getGrupos() {
		return grupos;
	}
	public void setGrupos(ArrayList<GrupoEntity> grupos) {
		this.grupos = grupos;
	}
	public JugadorEntity(String apodo, String email, String password, CategoriaEntity categoria, String loggedSession) {
		this.apodo = apodo;
		this.email = email;
		this.password = password;
		this.categoria = categoria;
		this.loggedSession = loggedSession;
	}
	public JugadorEntity(String apodo) {
		this.apodo = apodo;
	}
	public JugadorEntity() {
	}
	public String getApodo() {
		return apodo;
	}
	public void setApodo(String apodo) {
		this.apodo = apodo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public CategoriaEntity getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaEntity categoria) {
		this.categoria = categoria;
	}
	public String getLoggedSession() {
		return loggedSession;
	}
	public void setLoggedSession(String loggedSession) {
		this.loggedSession = loggedSession;
	}
	public void setGrupos(List<GrupoEntity> grupos) {
		this.grupos = grupos;
	}
}
