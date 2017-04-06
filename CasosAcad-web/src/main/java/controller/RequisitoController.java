package controller;

import Entidades.Requisito;
import SessionBeans.RequisitoFacade;
import util.JsfUtil;
import util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("requisitoController")
@SessionScoped
public class RequisitoController implements Serializable {

    @EJB
    private RequisitoFacade ejbFacade;
    private List<Requisito> items = null;
    private Requisito selected;

    public RequisitoController() {
    }

    public Requisito getSelected() {
        return selected;
    }

    public void setSelected(Requisito selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getRequisitoPK().setIdTipoRequisito(selected.getTipoRequisito().getIdTipoRequisito());
    }

    protected void initializeEmbeddableKey() {
        selected.setRequisitoPK(new Entidades.RequisitoPK());
    }

    private RequisitoFacade getFacade() {
        return ejbFacade;
    }

    public Requisito prepareCreate() {
        selected = new Requisito();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("RequisitoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("RequisitoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("RequisitoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Requisito> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Requisito getRequisito(Entidades.RequisitoPK id) {
        return getFacade().find(id);
    }

    public List<Requisito> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Requisito> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Requisito.class)
    public static class RequisitoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            RequisitoController controller = (RequisitoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "requisitoController");
            return controller.getRequisito(getKey(value));
        }

        Entidades.RequisitoPK getKey(String value) {
            Entidades.RequisitoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new Entidades.RequisitoPK();
            key.setIdRequisito(Integer.parseInt(values[0]));
            key.setIdTipoRequisito(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(Entidades.RequisitoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdRequisito());
            sb.append(SEPARATOR);
            sb.append(value.getIdTipoRequisito());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Requisito) {
                Requisito o = (Requisito) object;
                return getStringKey(o.getRequisitoPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Requisito.class.getName()});
                return null;
            }
        }

    }

}
