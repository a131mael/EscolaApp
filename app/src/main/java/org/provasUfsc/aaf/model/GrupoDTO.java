package org.provasUfsc.aaf.model;

import java.io.Serializable;
import java.util.List;

public class GrupoDTO implements Serializable{

	private Long id;

	private String nameUsuario;

	private Long idUsuario;

	private String nomeGrupo1;
	private String nomeGrupo2;
	private String nomeGrupo3;

	public String getNameUsuario() {
		return nameUsuario;
	}

	public void setNameUsuario(String nameUsuario) {
		this.nameUsuario = nameUsuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeGrupo1() {
		return nomeGrupo1;
	}

	public void setNomeGrupo1(String nomeGrupo1) {
		this.nomeGrupo1 = nomeGrupo1;
	}

	public String getNomeGrupo2() {
		return nomeGrupo2;
	}

	public void setNomeGrupo2(String nomeGrupo2) {
		this.nomeGrupo2 = nomeGrupo2;
	}

	public String getNomeGrupo3() {
		return nomeGrupo3;
	}

	public void setNomeGrupo3(String nomeGrupo3) {
		this.nomeGrupo3 = nomeGrupo3;
	}
}
