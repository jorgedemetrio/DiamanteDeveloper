/**
 *
 */
package br.com.alldreams.diamantedev.abstracts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.alldreams.diamanetedev.usuario.vo.UsuarioVO;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 06/11/2015 15:14:59
 */
public class AbstractController {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private HttpServletResponse response;

	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * @return the response
	 */
	public HttpServletResponse getResponse() {
		return response;
	}

	/**
	 * @return the usuarioLogado
	 */
	public UsuarioVO getUsuarioLogado() {
		return UsuarioVO.class.cast(request.getSession().getAttribute("perfil"));
	}

	/**
	 *
	 */
	public void getUsuarioLogado(UsuarioVO usuarioVO) {
		request.getSession().setAttribute("perfil", usuarioVO);
	}

	/**
	 * @param request
	 *            the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

}
