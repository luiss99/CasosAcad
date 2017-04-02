/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import SessionBeans.TipoRequisitoFacade;
import javax.ejb.EJB;
import javax.ws.rs.Path;
        
/**
 *
 * @author Kira Luis
 */
@Named(value = "tipoRequisitoMB")
@RequestScoped
@Path("tiporequisito")
public class TipoRequisitoMB {

    @EJB
    TipoRequisitoFacade tipoRequisitoFacade;
    
    public TipoRequisitoMB() {
    }
    
}
