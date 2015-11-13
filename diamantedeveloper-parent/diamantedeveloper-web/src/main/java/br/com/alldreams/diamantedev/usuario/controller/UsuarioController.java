/**
 *
 */
package br.com.alldreams.diamantecrm.usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.alldreams.diamanetedev.usuario.vo.UsuarioVO;
import br.com.alldreams.diamantecrm.abstracts.AbstractController;

import com.br.alldreams.diamantecrm.usuario.service.UsuarioService;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 06/11/2015 11:40:13
 */
@Controller
@RequestMapping("/documentoItensTela")
public class UsuarioController extends AbstractController {

	@Autowired
	UsuarioService usuarioService;

	@RequestMapping("/documentoItensTela")
	public ModelAndView delete(java.lang.Integer id) {
		usuarioService.delete(new UsuarioVO(id));
		return null;
	}

	@RequestMapping(path = "/documentoItensTela", method = { RequestMethod.POST })
	public ModelAndView salvar(UsuarioVO usuarioVO) {

		usuarioVO.setCriador(getUsuarioLogado());
		usuarioVO.setAlterador(getUsuarioLogado());

		usuarioService.delete(usuarioVO);
		return null;
	}

	@RequestMapping("/documentoItensTela")
	public ModelAndView search(UsuarioVO usuarioVO) {

		return null;
	}
}
