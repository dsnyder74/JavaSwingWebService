package dgs.projects.shopkinsdb;

import javax.persistence.*;

@Entity
@Table
public class Shopkin {
  
	@Id
	private String id;
	
	private String name;  
    
	public String getId() {  
		  return id;  
	}  
    
	public void setId(String i) {  
		this.id = i;  
	}  
    
	public String getName() {  
		return name;  
	}  
    
	public void setName(String n) {  
		this.name = n;  
	} 
}
