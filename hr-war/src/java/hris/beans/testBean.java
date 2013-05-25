/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hris.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author gouri
 */
@ManagedBean(name = "tBean")
@ViewScoped
public class testBean implements Serializable {
private String val;
  private List<String> vals;

  public String getVal() {
    return val;
  }

  public void setVal(String val) {
    this.val = val;
  }

  public List<String> getVals() {
    return vals;
  }

  public void setVals(List<String> vals) {
    this.vals = vals;
  }

  /**
   * Creates a new instance of testBean
   */
  public testBean() {
  }
  
  public void hello(){
    System.out.println("Hello");
  }
}
