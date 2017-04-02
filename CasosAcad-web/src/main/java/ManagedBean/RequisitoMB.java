/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import SessionBeans.RequisitoFacade;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Path;

/**
 *
 * @author Kira Luis
 */
@Named(value = "requisitoMB")
@RequestScoped
@Path("requisito")
public class RequisitoMB {

    @EJB
    RequisitoFacade requisitoFacade;
    
    public RequisitoMB() {
    }
    
}
