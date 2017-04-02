/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import SessionBeans.TipoPasoFacade;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Path;

/**
 *
 * @author Kira Luis
 */
@Named(value = "tipoPasoMB")
@RequestScoped
@Path("tipopaso")
public class TipoPasoMB {

    @EJB
    TipoPasoFacade tipoPasoFacade;
    
    
    public TipoPasoMB() {
    }
    
}
