/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import Entidades.TipoPaso;
import SessionBeans.TipoPasoFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.Path;

/**
 *
 * @author Kira Luis
 */
@Named(value = "tipoPasoMB")
@ViewScoped
public class TipoPasoMB {

    @EJB
    private TipoPasoFacade tipoPasoFacade;
    
    
    public TipoPasoMB() {
    }
     public List<TipoPaso> getFindAll() {
        return tipoPasoFacade.findAll();
    }
}
