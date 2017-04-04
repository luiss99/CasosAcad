/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import Entidades.Requisito;
import SessionBeans.RequisitoFacade;
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
@Named(value = "requisitoMB")
@ViewScoped
public class RequisitoMB {

    @EJB
    private RequisitoFacade requisitoFacade;
    
    public RequisitoMB() {
    }
     public List<Requisito> getFindAll() {
        return requisitoFacade.findAll();
    }
}
