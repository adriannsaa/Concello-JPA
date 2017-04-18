package jsf;

import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * LanguageBean Provides the spanish and the english languages
 * 
 * @author ansaa
 *
 */

@ApplicationScoped
@Named(value = "languageBean")
public class LanguageBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

	public Locale getLocale() {
		return locale;
	}

	public String getLanguage() {
		return locale.getLanguage();
	}

	public void changeLanguage(String language) {
		locale = new Locale(language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language));
	}

}
