/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.demo.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author Adouche Ali
 */
@Named
@SessionScoped
public class LocaleManagedBean implements Serializable {

    // La locale courante
    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

    public String getLanguage() {
        return locale.getLanguage();
    }

    public void setLanguage(String language) {
        locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }

    public Locale getLocale() {
        return locale;
    }

    //liste des locales supportées
    public SelectItem[] getLocales() {
        List<SelectItem> items = new ArrayList<SelectItem>();
        Application application = FacesContext.getCurrentInstance().getApplication();
        Iterator<Locale> supportedLocales = application.getSupportedLocales();//les locales supportées sont dans faces-config.xml
        
        while (supportedLocales.hasNext()) {
            Locale loc = supportedLocales.next();
            items.add(new SelectItem(loc.getLanguage(), loc.getDisplayName(locale)));
        }
        SelectItem[] locales = new SelectItem[items.size()];
        items.toArray(locales);
        return locales;
    }
}
