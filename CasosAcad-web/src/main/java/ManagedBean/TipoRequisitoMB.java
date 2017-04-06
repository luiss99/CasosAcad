/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import Entidades.TipoRequisito;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import SessionBeans.TipoRequisitoFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
        
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
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<TipoRequisito> findAll() {
        return tipoRequisitoFacade.findAll();
    }
    
    
    public TipoRequisitoMB() {
    }
    
}
