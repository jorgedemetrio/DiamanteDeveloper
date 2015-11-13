/**
 *
 */
package com.br.alldreams.diamantedev.usuario.service;

import java.util.List;

import br.com.alldreams.diamanetedev.usuario.vo.UsuarioVO;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 06/11/2015 13:39:37
 */
public interface UsuarioService {

	/**
	 * Apaga o usuário lógicamente.
	 *
	 * @param usuarioVO
	 */
	public void delete(UsuarioVO usuarioVO);

	/**
	 * Retorna todos usuários.
	 *
	 * @param id
	 * @return
	 */
	public List<UsuarioVO> getAll();

	/**
	 * Pega o usuário por ID.
	 *
	 * @param id
	 * @return
	 */
	public UsuarioVO getUsuarioById(Integer id);

	/**
	 *
	 * @param usuarioVO
	 */
	public void save(UsuarioVO usuarioVO);
}
