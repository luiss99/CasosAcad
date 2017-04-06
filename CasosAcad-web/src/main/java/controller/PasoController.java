package controller;

import Entidades.Paso;
import SessionBeans.PasoFacade;
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

@Named("pasoController")
@SessionScoped
public class PasoController implements Serializable {

    @EJB
    private PasoFacade ejbFacade;
    private List<Paso> items = null;
    private Paso selected;

    public PasoController() {
    }

    public Paso getSelected() {
        return selected;
    }

    public void setSelected(Paso selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getPasoPK().setIdTipoPaso(selected.getTipoPaso().getIdTipoPaso());
    }

    protected void initializeEmbeddableKey() {
        selected.setPasoPK(new Entidades.PasoPK());
    }

    private PasoFacade getFacade() {
        return ejbFacade;
    }

    public Paso prepareCreate() {
        selected = new Paso();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("PasoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PasoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PasoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Paso> getItems() {
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

    public Paso getPaso(Entidades.PasoPK id) {
        return getFacade().find(id);
    }

    public List<Paso> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Paso> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Paso.class)
    public static class PasoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PasoController controller = (PasoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "pasoController");
            return controller.getPaso(getKey(value));
        }

        Entidades.PasoPK getKey(String value) {
            Entidades.PasoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new Entidades.PasoPK();
            key.setIdPaso(Integer.parseInt(values[0]));
            key.setIdTipoPaso(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(Entidades.PasoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdPaso());
            sb.append(SEPARATOR);
            sb.append(value.getIdTipoPaso());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Paso) {
                Paso o = (Paso) object;
                return getStringKey(o.getPasoPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Paso.class.getName()});
                return null;
            }
        }

    }

}
