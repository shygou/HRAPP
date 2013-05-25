/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hris.session;

import hris.entity.Datavalues;
import hris.entity.Fieldmetadata;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author gouri
 */
@Stateless
public class hrisSessionBean implements hrisSessionBeanLocal {

  @PersistenceContext(unitName = "hris-ejbPU")
  private EntityManager em;
  @Resource(name = "jdbc/hris")
  private DataSource ds;

  // Add business logic below. (Right-click in editor and choose
  // "Insert Code > Add Business Method")
  @Override
  public Map<String, Fieldmetadata> getStandardFields(int tenantID, int moduleID) {
    try {
      System.out.println("moduleId is: " + moduleID);
      /*
       * Get the Fields for given moduleId and default Tenant(Id=0)
       */
      List<Fieldmetadata> stdFields = em.createNamedQuery("Fieldmetadata.findByTenantID-ModuleID").setParameter("moduleID", moduleID).setParameter("tenantID", 0).getResultList();

      /*
       * Get the Fields for given moduleId and given TenantId
       */
      List<Fieldmetadata> modifiedFields = em.createNamedQuery("Fieldmetadata.findByTenantID-ModuleID").setParameter("moduleID", moduleID).setParameter("tenantID", tenantID).getResultList();

      System.out.println("modifiedFilesd size: " + modifiedFields.size());
      /*
       * Replace the default Field metadata with tenant specific Field metadata
       */
      for (int i = 0; i < modifiedFields.size(); i++) {
        for (int j = 0; j < stdFields.size(); j++) {
          if (stdFields.get(j).getName().equals(modifiedFields.get(i).getName())) {
            //System.out.println(stdFields.get(j).getFieldName() + "%%%" + modifiedFields.get(i).getFieldName());
            stdFields.set(j, modifiedFields.get(i));
            break;
          }
        }
      }

      /*
       * Populate the transient fields - attributes and choices
       */
      Map<String, String> tempMap;
      String[] s1, s2; /*
       * Used for string manipulation below
       */
      for (int i = 0; i < stdFields.size(); i++) {
        if (stdFields.get(i).getAttributes() != null) {
          tempMap = new HashMap<String, String>();
          s1 = stdFields.get(i).getAttributes().split(";");
          for (int j = 0; j < s1.length; j++) {
            s2 = s1[j].split("==");
            System.out.println("s2: " + s2[0]);
            tempMap.put(s2[0], s2[1]);
          }
          stdFields.get(i).setAttributeMap(tempMap);
        }
        if (stdFields.get(i).getChoices() != null) {
          s1 = stdFields.get(i).getChoices().split(";");
          System.out.println("s1: " + s1[0]);
          for (int j = 0; j < s1.length; j++) {
            s2 = s1[j].split("==");
            System.out.println("s2: " + s2[0]);
            stdFields.get(i).getChoiceList().add(new SelectItem(s2[0], s2[1]));
          }
        }
      }
      Map<String, Fieldmetadata> map = new HashMap<String, Fieldmetadata>();
      for (Fieldmetadata i : stdFields) {
        map.put(i.getName(), i);
      }
      return map;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public String saveEmployee(Map fieldMap) {
    String message = "No Op";
    Connection conn = null;
    PreparedStatement pstmt = null;
    String str = "INSERT INTO DATAVALUES ";
    String colStr = " (", valStr = " VALUES(";
    try {
      conn = ds.getConnection();
      //List fList = (List) fieldMap..values();
      Fieldmetadata f;
      for (Object o : fieldMap.values()) {
        f = (Fieldmetadata) o;
        if (f.getValueList() != null) {
          valStr += StringUtils.join(f.getValueList(), ";") + ",";
          colStr += f.getValueCol() + ",";
        } else if(f.getValueStr() != null){
          valStr += f.getValueStr() + ",";
          colStr += f.getValueCol() + ",";
        }
      }
      valStr = valStr.substring(0, valStr.lastIndexOf(","));
      colStr = colStr.substring(0, colStr.lastIndexOf(","));
      str += colStr + ")" + valStr + ")";
      System.out.println("Insert String: " + str);
      message = "Success";
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return message;
  }

  public void persist(Object object) {
    em.persist(object);
  }
  
  public void merge(Object object){
    em.merge(object);
  }
  
  public void remove(Object object){
    
    em.remove(object);
  }
}
