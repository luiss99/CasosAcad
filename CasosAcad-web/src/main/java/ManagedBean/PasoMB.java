/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import SessionBeans.PasoFacade;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Path;

/**
 *
 * @author Kira Luis
 */
@Named(value = "pasoMB")
@RequestScoped
@Path("paso")
public class PasoMB {

    @EJB
    PasoFacade pasoFacade;
    
    public PasoMB() {
    }
    
}
