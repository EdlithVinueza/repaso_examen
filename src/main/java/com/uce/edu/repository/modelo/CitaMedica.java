package com.uce.edu.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name = "cita_medica")
@NamedQuery(name="CitaMedica.queryBuscarPorNumero", query = "SELECT c FROM CitaMedica c WHERE c.numeroTuerno =:numero")
public class CitaMedica {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cita_medica")
	@SequenceGenerator(name = "seq_cita_medica", sequenceName = "seq_cita_medica", allocationSize = 1)
	@Column(name = "cime_id")
	private Integer id;
	@Column(name = "cime_numero_turno")
	private String numeroTuerno;
	@Column(name = "cime_fecha_cita")
	private LocalDateTime fechaCita;
	@Column(name = "cime_costo_cita")
	private BigDecimal costoCita;
	@Column(name = "cime_lugar_cita")
	private String lugarCita;
	@Column(name = "cime_diagnostico")
	private String diagnostico;
	@Column(name = "cime_receta")
	private String receta;
	@Column(name = "cime_fecha_control")
	private LocalDateTime fechaControl;
	@ManyToOne
	@JoinColumn(name = "cime_id_doctor")
	private Doctor doctor;
	@ManyToOne 
	@JoinColumn(name = "cime_id_paciente")
	private Paciente paciente;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumeroTuerno() {
		return numeroTuerno;
	}
	public void setNumeroTuerno(String numeroTuerno) {
		this.numeroTuerno = numeroTuerno;
	}
	public LocalDateTime getFechaCita() {
		return fechaCita;
	}
	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}
	public BigDecimal getCostoCita() {
		return costoCita;
	}
	public void setCostoCita(BigDecimal costoCita) {
		this.costoCita = costoCita;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getReceta() {
		return receta;
	}
	public void setReceta(String receta) {
		this.receta = receta;
	}
	public LocalDateTime getFechaControl() {
		return fechaControl;
	}
	public void setFechaControl(LocalDateTime fechaControl) {
		this.fechaControl = fechaControl;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	@Override
	public String toString() {
		return "CitaMedica [id=" + id + ", numeroTuerno=" + numeroTuerno + ", fechaCita=" + fechaCita + ", costoCita="
				+ costoCita + ", diagnostico=" + diagnostico + ", receta=" + receta + ", fechaControl=" + fechaControl
				+ "]";
	}
	public String getLugarCita() {
		return lugarCita;
	}
	public void setLugarCita(String lugarCita) {
		this.lugarCita = lugarCita;
	}

	
}
