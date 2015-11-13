/**
 *
 */
package com.br.alldreams.diamantedev.usuario.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.alldreams.diamanetedev.dados.vo.StatusInformacaoEnum;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 03/11/2015 18:26:34
 */
@Entity
@Table(name = "tb_usuario")
@NamedQueries({ @NamedQuery(name = Usuario.GETLALL, query = "SELECT u FROM Usuario u WHERE u.status <> 'REMOVIDO' ") })
public class Usuario implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -7609438078966683149L;

	public static final String GETLALL = "Usuario.getAll";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, updatable = false, nullable = true)
	private Integer id;

	@Column(name = "dt_validade", insertable = true, updatable = true, nullable = true, unique = false)
	private Date validade;

	@Column(name = "dt_bloqueado", insertable = false, updatable = true, nullable = true, unique = false)
	private Date bloqueado;

	@Column(name = "str_usuario", insertable = true, updatable = false, nullable = true, unique = true, length = 150)
	private String usuario;

	@Column(name = "str_senha", insertable = true, updatable = false, nullable = true, unique = false, length = 150)
	private String senha;

	@Column(name = "token", insertable = true, updatable = false, unique = true, nullable = false, length = 100)
	private String token;

	@Column(name = "dt_criado", insertable = true, updatable = true, unique = false, nullable = false)
	private Date criado;

	@Column(name = "dt_alterado", insertable = true, updatable = true, unique = false, nullable = true)
	private Date alterado;

	@ManyToOne
	@JoinColumn(name = "criador", insertable = true, updatable = true, unique = false, nullable = false)
	private Usuario criador;

	@ManyToOne
	@JoinColumn(name = "alterador", insertable = true, updatable = true, unique = false, nullable = false)
	private Usuario alterador;

	@Column(name = "alterador", insertable = true, updatable = true, unique = false, nullable = false, length = 50)
	@Enumerated(EnumType.STRING)
	private StatusInformacaoEnum status;

	@Column(name = "host_ip_criador", insertable = true, updatable = true, unique = false, nullable = false, length = 30)
	private String ipCriado;

	@Column(name = "host_ip_alterador", insertable = true, updatable = true, unique = false, nullable = true, length = 30)
	private String ipAlterado;

	@Column(name = "versao", insertable = true, updatable = true, unique = false, nullable = true)
	private Integer versao;

	/**
	 * @return the alterado
	 */
	public Date getAlterado() {
		return alterado;
	}

	/**
	 * @return the alterador
	 */
	public Usuario getAlterador() {
		return alterador;
	}

	/**
	 * @return the bloqueado
	 */
	public Date getBloqueado() {
		return bloqueado;
	}

	/**
	 * @return the criado
	 */
	public Date getCriado() {
		return criado;
	}

	/**
	 * @return the criador
	 */
	public Usuario getCriador() {
		return criador;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the ipAlterado
	 */
	public String getIpAlterado() {
		return ipAlterado;
	}

	/**
	 * @return the ipCriado
	 */
	public String getIpCriado() {
		return ipCriado;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @return the status
	 */
	public StatusInformacaoEnum getStatus() {
		return status;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @return the validade
	 */
	public Date getValidade() {
		return validade;
	}

	/**
	 * @return the versao
	 */
	public Integer getVersao() {
		return versao;
	}

	/**
	 * @param alterado
	 *            the alterado to set
	 */
	public void setAlterado(Date alterado) {
		this.alterado = alterado;
	}

	/**
	 * @param alterador
	 *            the alterador to set
	 */
	public void setAlterador(Usuario alterador) {
		this.alterador = alterador;
	}

	/**
	 * @param bloqueado
	 *            the bloqueado to set
	 */
	public void setBloqueado(Date bloqueado) {
		this.bloqueado = bloqueado;
	}

	/**
	 * @param criado
	 *            the criado to set
	 */
	public void setCriado(Date criado) {
		this.criado = criado;
	}

	/**
	 * @param criador
	 *            the criador to set
	 */
	public void setCriador(Usuario criador) {
		this.criador = criador;
	}

	// ************************* CONTROLE

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param ipAlterado
	 *            the ipAlterado to set
	 */
	public void setIpAlterado(String ipAlterado) {
		this.ipAlterado = ipAlterado;
	}

	/**
	 * @param ipCriado
	 *            the ipCriado to set
	 */
	public void setIpCriado(String ipCriado) {
		this.ipCriado = ipCriado;
	}

	/**
	 * @param senha
	 *            the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(StatusInformacaoEnum status) {
		this.status = status;
	}

	/**
	 * @param token
	 *            the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @param validade
	 *            the validade to set
	 */
	public void setValidade(Date validade) {
		this.validade = validade;
	}

	/**
	 * @param versao
	 *            the versao to set
	 */
	public void setVersao(Integer versao) {
		this.versao = versao;
	}

}
