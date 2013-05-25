/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hris.beans;

import hris.entity.Fieldmetadata;
import hris.session.hrisSessionBeanLocal;
import java.io.Serializable;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author gouri
 */
@ManagedBean(name = "employeeBean")
@ViewScoped
public class EmployeeBean implements Serializable{

  @EJB
  private hrisSessionBeanLocal hrisSessionBean;
  private Map<String,Fieldmetadata> stdFields;
  
  /**
   * Creates a new instance of EmployeeBean
   */
  public EmployeeBean() {
    //populateStandardFields();
    //customizeStandardFields();
    //populateCustomFields();
  }

  @PostConstruct
  private void init() {
    if (hrisSessionBean == null) {
      System.out.println("Null SB");
    } else {
      stdFields = hrisSessionBean.getStandardFields(1234, 1);
      //stdFields = (Fieldmetadata[]) res.toArray(new Fieldmetadata[res.size()]);
      Fieldmetadata f = (Fieldmetadata)stdFields.get("StartDate");
      System.out.println("$$$$$$$$: " + f.getAttributeMap().get("mask"));
      //fieldValues = new String[][];
    }
    
  }

  public void hello(ActionEvent e) {
    System.out.println("Do nothing");
  }
  public void saveEmployee(ActionEvent e) {
    //Do complex UI validations - for ex. check if age is greater than 18 and less than 70
    // validateEmployee();
    System.out.println("Inside saveEmployee");
    String message = hrisSessionBean.saveEmployee(stdFields);
    if(message.equals("Success")){
      //Maybe throw a dialog saying employee added
    } else{
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Save did not work: " + message));
    }
    
  }

  public Map<String,Fieldmetadata> getStdFields() {
    return stdFields;
  }

  public void setStdFields(Map<String,Fieldmetadata> stdFields) {
    this.stdFields = stdFields;
  }

  

}
