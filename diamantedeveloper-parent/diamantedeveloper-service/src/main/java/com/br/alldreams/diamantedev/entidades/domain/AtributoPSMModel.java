/**
 *
 */
package com.br.alldreams.diamantedev.entidades.domain;

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

import com.br.alldreams.diamantedev.projeto.domain.Projeto;
import com.br.alldreams.diamantedev.usuario.domain.Usuario;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 13/11/2015 14:27:41
 */
@Entity
@Table(name = "tb_atributo_psm_m")
@NamedQueries({ @NamedQuery(name = AtributoPSMModel.GETLALL, query = "SELECT u FROM AtributoPSMModel u WHERE u.status <> 'REMOVIDO' ") })
public class AtributoPSMModel implements Serializable {

	public static final String GETLALL = "AtributoPSM.getAll";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, updatable = false, nullable = true)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_projeto", insertable = true, updatable = true, unique = false, nullable = false)
	private Projeto projeto;

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
}
