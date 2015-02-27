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
import org.hibernate.Session;
import org.hibernate.Transaction;

import dgs.projects.shopkinsdb.util.HibernateUtil;

@Controller
public class ShopkinsDB {
	
	@RequestMapping("/")
	public ModelAndView addShopkin1() {
		return new ModelAndView("shopkin-page", "shopkin-entity", new Shopkin());
	}
	
    @RequestMapping(value="/process-shopkin")  
    public ModelAndView addShopkin1(@ModelAttribute Shopkin s) {
    	
    	Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(s);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if(trns != null){
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		} 
    	
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