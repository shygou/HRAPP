/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hris.beans;

import hris.entity.Fieldmetadata;
import hris.entity.Modules;
import hris.entity.Tenant;
import hris.session.hrisSessionBeanLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author gouri
 */
@ManagedBean(name = "manageModuleBean")
@ViewScoped
public class ManageModuleBean implements Serializable {
  //@PersistenceContext(unitName = "hris-ejbPU")

  private EntityManagerFactory emf;
  private EntityManager em;
  @EJB
  private hrisSessionBeanLocal hrisSessionBean;
  List<Fieldmetadata> fields, tenantFields;
  List<Tenant> tenants;
  List<Modules> modules;
  Fieldmetadata selField;
  String selModule, selTenant, name;

  /**
   * Creates a new instance of ManageModuleBean
   */
  public ManageModuleBean() {
    emf = Persistence.createEntityManagerFactory("hris-ejbPU");
    em = emf.createEntityManager();
    em.setFlushMode(FlushModeType.COMMIT);
  }

  @PostConstruct
  private void init() {
    // Get all Tenants to populate the Tenant dropdown
    tenants = new ArrayList();
    tenants = em.createNamedQuery("Tenant.findAll").getResultList();
    // Get all modules to populate modules dropdown
    modules = new ArrayList();
    modules = em.createNamedQuery("Modules.findAll").getResultList();
  }

  public void onStdFieldEdit(RowEditEvent e) {
    Fieldmetadata f = (Fieldmetadata) e.getObject();
    if (this.getSelTenant().equals("1")) {
      Fieldmetadata field = em.find(Fieldmetadata.class, f.getId());
      field.setLabel(f.getLabel());
      hrisSessionBean.merge(f);

    } else {
      System.out.println("IN persist");
      f.setTenantID(Integer.parseInt(this.getSelTenant()));
      hrisSessionBean.persist(f);
    }
    //em.flush();
    fields = em.createNamedQuery("Fieldmetadata.findByTenantID-ModuleID").setParameter("moduleID", Integer.parseInt(this.getSelModule())).setParameter("tenantID", 1).getResultList();
    em.refresh(f);

  }

  public void onCustomFieldEdit(RowEditEvent e) {
    Fieldmetadata f = (Fieldmetadata) e.getObject();
    System.out.println("type: " + f.getType());
      System.out.println("M: " + f.getModuleID());
      System.out.println("T: " + f.getTenantID());
      System.out.println("Sec: " + f.getSecurity());
      System.out.println("isvis: " + f.getIsVisible());
      System.out.println("name: " + f.getName() + "label" + f.getLabel());
    if(f.getId() == null){
      hrisSessionBean.persist(f);
      
    } else {
      hrisSessionBean.merge(f);
    }
    
    tenantFields = em.createNamedQuery("Fieldmetadata.findByTenantID-ModuleID").setParameter("moduleID", Integer.parseInt(this.getSelModule())).setParameter("tenantID", Integer.parseInt(this.getSelTenant())).getResultList();
//    em.refresh(f);
    System.out.println("Added Custom Field: " + f.getName());
  }

  public void addField(ActionEvent e) {
    Fieldmetadata f = new Fieldmetadata();
    f.setTenantID(Integer.parseInt(this.getSelTenant()));
    f.setModuleID(Integer.parseInt(this.getSelModule()));
    f.setSecurity("Full");
    tenantFields.add(f);
  }
  
  public void delField(ActionEvent e){
    System.out.println("Del field Name" + selField.getName());
    //hrisSessionBean.remove(selField);
    tenantFields = em.createNamedQuery("Fieldmetadata.findByTenantID-ModuleID").setParameter("moduleID", Integer.parseInt(this.getSelModule())).setParameter("tenantID", Integer.parseInt(this.getSelTenant())).getResultList();
  }
  
  public void addEntity(ActionEvent e) {
    System.out.println("Tenant name: " + this.name);
    //em.setFlushMode(FlushModeType.COMMIT);
    Modules m = new Modules();
    m.setName(this.name);

    hrisSessionBean.persist(m);
    modules = em.createNamedQuery("Modules.findAll").getResultList();
  }

  public void getFieldsByTenantModule(ActionEvent e) {
    System.out.println(this.getSelTenant());
    fields = em.createNamedQuery("Fieldmetadata.findByTenantID-ModuleID").setParameter("moduleID", Integer.parseInt(this.getSelModule())).setParameter("tenantID", 1).getResultList();
    tenantFields = em.createNamedQuery("Fieldmetadata.findByTenantID-ModuleID").setParameter("moduleID", Integer.parseInt(this.getSelModule())).setParameter("tenantID", Integer.parseInt(this.getSelTenant())).getResultList();
  }

  public Fieldmetadata getSelField() {
    return selField;
  }

  public void setSelField(Fieldmetadata selField) {
    this.selField = selField;
  }

  public List<Fieldmetadata> getTenantFields() {
    return tenantFields;
  }

  public void setTenantFields(List<Fieldmetadata> tenantFields) {
    this.tenantFields = tenantFields;
  }

  public List<Fieldmetadata> getFields() {
    return fields;
  }

  public void setFields(List<Fieldmetadata> fields) {
    this.fields = fields;
  }

  public List<Modules> getModules() {
    return modules;
  }

  public void setModules(List<Modules> modules) {
    this.modules = modules;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSelModule() {
    return selModule;
  }

  public void setSelModule(String selModule) {
    this.selModule = selModule;
  }

  public String getSelTenant() {
    return selTenant;
  }

  public void setSelTenant(String selTenant) {
    this.selTenant = selTenant;
  }

  public List<Tenant> getTenants() {
    return tenants;
  }

  public void setTenants(List<Tenant> tenants) {
    this.tenants = tenants;
  }
}
