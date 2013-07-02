/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.demo.cdi;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

/**
 *
 * @author Adouche Ali
 */
public class Producer {

    public static final Map<Locale, String> MAP_LOCALE_FORMAT;
    
    static {
        MAP_LOCALE_FORMAT = new HashMap<Locale, String>();
        MAP_LOCALE_FORMAT.put(Locale.FRANCE,"EEEE dd MMMM yyyy");
        MAP_LOCALE_FORMAT.put(Locale.FRENCH,"EEEE dd MMMM yyyy");
        MAP_LOCALE_FORMAT.put(Locale.CANADA_FRENCH,"EEEE dd MMMM yyyy");
        MAP_LOCALE_FORMAT.put(Locale.ENGLISH,"EEEE, MMMM dd  yyyy");
        MAP_LOCALE_FORMAT.put(Locale.UK,"EEEE, MMMM dd  yyyy");
        MAP_LOCALE_FORMAT.put(Locale.US,"EEEE, MMMM dd  yyyy");
    }
    
    @Produces @LocaleDate
    public String getDate() {
        Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        String pattern = MAP_LOCALE_FORMAT.get(locale);
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern, locale);
        return dateFormat.format(new Date());
    }
}
