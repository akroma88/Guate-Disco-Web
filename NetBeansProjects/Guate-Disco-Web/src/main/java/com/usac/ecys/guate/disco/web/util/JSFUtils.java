
package com.usac.ecys.guate.disco.web.util;

import java.util.Iterator;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author David
 */
public class JSFUtils {
    /**
   * Returns the current HTTP session.
   */
  public static HttpSession getHttpSession() {
    FacesContext facescontext = FacesContext.getCurrentInstance();
    HttpSession session = (HttpSession) facescontext.getExternalContext().getSession(true);
    return session;
  }

  /**
   * Returns the current servlet response object instance.
   */
  public static HttpServletResponse getHttpServletResponse() {
    FacesContext facescontext = FacesContext.getCurrentInstance();
    HttpServletResponse response=(HttpServletResponse)facescontext.getExternalContext().getResponse();
    return response;
  }

  /**
   * Returns the current servlet request object instance.
   */
  public static HttpServletRequest getHttpServletRequest() {
    FacesContext facescontext = FacesContext.getCurrentInstance();
    HttpServletRequest request=(HttpServletRequest)facescontext.getExternalContext().getRequest();
    return request;
  }

  /**
   * Returns the servlet context.
   */
  public static ServletContext getServletContext() {
    ServletContext context = getHttpSession().getServletContext();
    return context;
  }

  /**
   * Creates or returns the backing bean.
   *
   * @param name The name of the bean.
   * @return The backing bean.
   */
  public static Object getBackingBean(String name) {
    Object bean = getHttpSession().getAttribute(name);
    if (bean == null) {
      FacesContext facescontext = FacesContext.getCurrentInstance();
      bean = facescontext.getApplication().createValueBinding("#{"+name+"}").getValue(facescontext); //$NON-NLS-1$ //$NON-NLS-2$
    }
    return bean;
  }
  /**
   * Adds a SEVERE message.
   *
   * @param message The message.
   */
  public static void addErrorMessage(String message) {
    FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
    FacesContext context = FacesContext.getCurrentInstance();
      context.addMessage(null, facesMsg);
  }
  /**
   * Adds an INFO message.
   *
   * @param message The message.
   */
  public static void addInfoMessage(String message) {
    FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, message, message);
    FacesContext context = FacesContext.getCurrentInstance();
      context.addMessage(null, facesMsg);
  }
  /**
   * Adds a WARNING message.
   *
   * @param message The message.
   */
  public static void addWarningMessage(String message) {
    FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, message, message);
    FacesContext context = FacesContext.getCurrentInstance();
      context.addMessage(null, facesMsg);
  }

  /**
   * Removes all current messages held by the JSF framework.
   */
  @SuppressWarnings("unchecked") //$NON-NLS-1$
  public static void resetMessages() {
    FacesContext context = FacesContext.getCurrentInstance();
      Iterator iter = context.getMessages();
      while (iter.hasNext()) {
        iter.next();
        iter.remove();
    }
  }
  
  public static String redirectPage(String pageWithExtention) {
      FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, pageWithExtention);  
      return FacesContext.getCurrentInstance().getApplication().getNavigationHandler().toString(); 
  }
  
  public static String redirectPage(String pageWithExtention, String params) {
      FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, pageWithExtention + "?" + params);  
      return FacesContext.getCurrentInstance().getApplication().getNavigationHandler().toString(); 
  }
}
