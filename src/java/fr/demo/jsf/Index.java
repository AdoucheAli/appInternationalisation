/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.demo.jsf;

import fr.demo.cdi.LocaleDate;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author Adouche Ali
 */
@Model
public class Index {
    
    @Inject @LocaleDate
    private String date;

    public String getDate() {
        return date;
    }
}
