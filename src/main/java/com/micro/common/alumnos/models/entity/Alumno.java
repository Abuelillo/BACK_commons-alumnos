package com.micro.common.alumnos.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="alumnos")
public class Alumno {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String apellido;
	@NotEmpty
	@Email
	private String email;
	
	@Column(name="create_at")
	@Temporal(TemporalType.TIMESTAMP)//añade fecha y hora
	private Date createAt;
	
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}
	
	@Lob
	@JsonIgnore
	private byte[] foto;
	
	public Alumno() {
		super();
	}

	public Alumno(Long id, String nombre, String apellido, String email, Date createAt) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.createAt = createAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Integer getFotoHashCode() {
		return (this.foto != null) ? this.foto.hashCode() : null;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof Alumno)) {
			return false;
		}
		Alumno a = (Alumno) obj;
		
		return this.id != null && this.id.equals(a.getId());
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", createAt="
				+ createAt + "]";
	}	
}
