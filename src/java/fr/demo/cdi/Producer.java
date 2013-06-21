/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.demo.cdi;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

/**
 *
 * @author Adouche Ali
 */
public class Producer {

    @Produces @LocaleDate
    public String getDate() {
        Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        String pattern;
        if (Locale.FRENCH.equals(locale)) {
           pattern = "EEEE dd MMMM yyyy";
        }
        else {
             pattern = "EEEE, MMMM dd  yyyy";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern, locale);
        return dateFormat.format(new Date());
    }
}
