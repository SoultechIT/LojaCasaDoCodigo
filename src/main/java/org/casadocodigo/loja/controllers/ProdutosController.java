package org.casadocodigo.loja.controllers;

import javax.validation.Valid;

import org.casadocodigo.loja.daos.ProductDao;
import org.casadocodigo.loja.models.BookType;
import org.casadocodigo.loja.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Transactional
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	private ProductDao productDao;
	
	/*@InitBinder
	private void InitBinder(WebDataBinder binder) {
		binder.setValidator(new ProductValidator());
	}*/
	
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView save(@Valid Product produto, BindingResult bindingResult, 
    		RedirectAttributes redirectAttributes){
    	if(bindingResult.hasErrors()) {
    		return form(produto);
    	}
        productDao.save(produto);
        redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");
        //return "products/ok";
        /*ModelAndView modelAndView = new ModelAndView("redirect:produtos");
        modelAndView.addObject("sucesso", "Produto cadastrado com sucesso!");
        return modelAndView;*/
        return new ModelAndView("redirect:produtos");
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView list() {
    	ModelAndView modelAndView = new ModelAndView("products/list");
    	modelAndView.addObject("products", productDao.list());
    	return modelAndView;
    }
  
    
    @RequestMapping("/form")
    public ModelAndView form(Product produto) {
    	ModelAndView modelAndView = new ModelAndView("products/form");
    	modelAndView.addObject("types", BookType.values());
    	return modelAndView;
    }
}
