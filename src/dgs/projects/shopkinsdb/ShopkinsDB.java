package dgs.projects.shopkinsdb;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dgs.projects.shopkinsdb.util.HibernateUtil;
import org.hibernate.Criteria;

@Controller
public class ShopkinsDB {
	
	@RequestMapping("/")
	public ModelAndView addShopkin1() {
		
		//ModelAndView model = new ModelAndView("shopkin-page", "shopkin-entity", new Shopkin());
        ModelAndView modelAndView = new ModelAndView();  
        modelAndView.setViewName("shopkin-page");
        modelAndView.addObject("shopkin-entity", new Shopkin());
        
    	Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			
	        @SuppressWarnings("unchecked")
	        List<Shopkin> listUser = (List<Shopkin>) session
	                .createCriteria(Shopkin.class)
	                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	        
			modelAndView.addObject("allshopkins", listUser);
			
		} catch (RuntimeException e) {
			if(trns != null){
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		} 
		
		return modelAndView;
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
    
}