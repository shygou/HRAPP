/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hris.session;

import hris.entity.Fieldmetadata;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author gouri
 */
@Local
public interface hrisSessionBeanLocal {

  public Map<String,Fieldmetadata> getStandardFields(int tenantID, int moduleID);
  public String saveEmployee(Map fieldMap);
  public void persist(Object o);
  public void merge(Object o);
  public void remove(Object o);
}
