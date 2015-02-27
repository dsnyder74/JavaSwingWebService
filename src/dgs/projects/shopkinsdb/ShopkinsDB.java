package dgs.projects.shopkinsdb;

import java.util.Map;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ShopkinsDB {
	
	@RequestMapping("/")
	public ModelAndView helloWorld1() {
		return new ModelAndView("shopkin-page", "shopkin-entity", new Shopkin());
	}
	
    @RequestMapping(value="/process-shopkin")  
    public ModelAndView processPerson(@ModelAttribute Shopkin s) {  
        ModelAndView modelAndView = new ModelAndView();  
        modelAndView.setViewName("shopkin-result-page");  
          
        modelAndView.addObject("shopkin", s);  
          
        return modelAndView;  
    } 
    
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld(ModelMap model) {
 
		String message="QWERT";
		
		for (Map.Entry<String, Object> entry : model.entrySet()) {
			message = message + entry.getKey() + ":" + entry.getValue().toString();
		}

		message = message + "<br><div align='center'>"
			 + "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is comming from ShopkinsDB.java **********<br><br>";

		return new ModelAndView("welcome","message",message);
	}
}