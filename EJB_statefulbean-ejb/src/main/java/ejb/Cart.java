/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author Pawel
 */
@Stateful 
public class Cart implements CartLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
//   @PersistenceContext(unitName = "pu", type = PersistenceContextType.EXTENDED)
  // private EntityManager em;
   private List<Product> products;
   
   @PostConstruct
   private void initBean() {
       products = new ArrayList<>();
   }
   @Override
   public void addProductToCart(Product p) {
       products.add(p);
   }
   @Override
   @TransactionAttribute(TransactionAttributeType.REQUIRED)
   public void checkout() {
       for(Product p : products) {
         //  em.persist(p);
       }
       products.clear();
   }
}
