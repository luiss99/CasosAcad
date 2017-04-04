/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import Entidades.TipoRequisito;
import javax.inject.Named;
import SessionBeans.TipoRequisitoFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;

        
/**
 *
 * @author Kira Luis
 */
@Named(value = "tipoRequisitoMB")
@ViewScoped
public class TipoRequisitoMB {

    @EJB
   private TipoRequisitoFacade tipoRequisitoFacade;
    
    public TipoRequisitoMB() {
    }
    
    public List<TipoRequisito> getFindAll() {
        return tipoRequisitoFacade.findAll();
    }
}

