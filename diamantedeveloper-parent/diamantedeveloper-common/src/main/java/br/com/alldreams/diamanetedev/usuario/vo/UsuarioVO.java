/**
 *
 */
package br.com.alldreams.diamanetedev.usuario.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.alldreams.diamanetedev.dados.vo.StatusInformacaoEnum;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 06/11/2015 13:33:49
 */
public class UsuarioVO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 2181122543628369545L;

	private Integer id;

	private Date validade;

	// private Contato contato;

	private Date bloqueado;

	private String usuario;

	private String senha;

	private String token;

	private Date criado;

	private Date alterado;

	private UsuarioVO criador;

	private UsuarioVO alterador;

	private StatusInformacaoEnum status;

	private String ipCriado;

	private String ipAlterado;

	private Integer versao;

	/**
	 *
	 */
	public UsuarioVO() {
	}

	/**
	 * Construr para criar a entidade com o Id já atribuido .
	 *
	 * @param id
	 */
	public UsuarioVO(Integer id) {
		this.id = id;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object arg0) {
		return getId() != null && arg0 != null && arg0 instanceof UsuarioVO && getId().equals(UsuarioVO.class.cast(arg0).getId());
	}

	/**
	 * @return the alterado
	 */
	public Date getAlterado() {
		return alterado;
	}

	/**
	 * @return the alterador
	 */
	public UsuarioVO getAlterador() {
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
	public UsuarioVO getCriador() {
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
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return getId().intValue();
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
	public void setAlterador(UsuarioVO alterador) {
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
	public void setCriador(UsuarioVO criador) {
		this.criador = criador;
	}

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

	/**
	 * JSON Format
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// \"contato\":\""+contato+"\",
		final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
		return "{\"id\":\"" + id + "\",\"validade\":\"" + sdf.format(validade) + "\",\"bloqueado\":\"" + bloqueado + "\",\"usuario\":\"" + usuario
				+ "\",\"senha\":\"" + senha + "\",\"token\":\"" + token + "\",\"criado\":\"" + sdf.format(criado) + "\",\"alterado\":\"" + sdf.format(alterado)
				+ "\",\"status\":\"" + status.name() + "\",\"ipCriado\":\"" + ipCriado + "\",\"ipAlterado\":\"" + ipAlterado + "\",\"versao\":\"" + versao
				+ "\"}";
	}

}
