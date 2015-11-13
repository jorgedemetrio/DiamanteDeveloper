/**
 *
 */
package com.br.alldreams.diamantedev.usuario.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alldreams.diamanetedev.dados.vo.StatusInformacaoEnum;
import br.com.alldreams.diamanetedev.usuario.vo.UsuarioVO;

import com.br.alldreams.diamantedev.usuario.domain.Usuario;
import com.br.alldreams.diamantedev.usuario.service.UsuarioService;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 06/11/2015 15:07:35
 */
@Component
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private Session session;

	private final Logger LOGGER = Logger.getLogger(UsuarioServiceImpl.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(UsuarioVO usuarioVO) {
		Usuario usuario = null;

		if (usuarioVO.getId() != null) {
			usuario = Usuario.class.cast(session.get(Usuario.class, usuarioVO.getId()));
			usuario.setAlterado(new Date());
			usuario.setAlterador(Usuario.class.cast(session.get(Usuario.class, usuarioVO.getAlterador().getId())));
			usuario.setStatus(StatusInformacaoEnum.REMOVIDO);
			session.persist(usuario);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<UsuarioVO> getAll() {
		final List usuarios = session.getNamedQuery(Usuario.GETLALL).list();
		CollectionUtils.transform(usuarios, new Transformer() {
			@Override
			public Object transform(Object input) {
				final Usuario usuario = Usuario.class.cast(input);
				final UsuarioVO usuarioVO = new UsuarioVO();
				try {
					BeanUtils.copyProperties(usuarioVO, usuario);
				} catch (IllegalAccessException | InvocationTargetException e) {
					LOGGER.error(e.getMessage(), e);
				}
				return usuarioVO;
			}
		});
		return usuarios;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UsuarioVO getUsuarioById(Integer id) {
		final UsuarioVO usuarioVO = null;
		final Usuario usuario = Usuario.class.cast(session.get(Usuario.class, id));
		try {
			BeanUtils.copyProperties(usuarioVO, usuario);
		} catch (IllegalAccessException | InvocationTargetException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return usuarioVO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(UsuarioVO usuarioVO) {
		Usuario usuario = null;

		if (usuarioVO.getId() != null) {
			usuario = Usuario.class.cast(session.get(Usuario.class, usuarioVO.getId()));
		} else {
			usuario = new Usuario();
			usuario.setCriado(new Date());
			usuario.setCriador(Usuario.class.cast(session.get(Usuario.class, usuarioVO.getCriador().getId())));
		}

		try {
			BeanUtils.copyProperties(usuario, usuarioVO);
		} catch (IllegalAccessException | InvocationTargetException e) {
			LOGGER.error(e.getMessage(), e);
		}

		usuario.setAlterado(new Date());
		usuario.setAlterador(Usuario.class.cast(session.get(Usuario.class, usuarioVO.getAlterador().getId())));
		session.persist(usuario);
	}
}
