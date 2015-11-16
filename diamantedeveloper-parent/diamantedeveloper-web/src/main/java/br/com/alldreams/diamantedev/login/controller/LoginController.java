/**
 *
 */
package br.com.alldreams.diamantedev.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.alldreams.diamantedev.abstracts.AbstractController;

/**
 * @author Jorge Demetrio
 * @version 1.0
 * @since 06/11/2015 11:39:45
 */
@Controller
@RequestMapping("/login")
public class LoginController extends AbstractController {

	// @ResponseBody
	@RequestMapping(path = "/", method = { RequestMethod.POST })
	public ModelAndView carregar() {
		// final ModelAndView model = new
		// ModelAndView("redirect:/login/index.html");
		final ModelAndView model = new ModelAndView();

		return model;
	}

}
