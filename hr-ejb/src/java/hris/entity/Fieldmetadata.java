/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hris.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.model.SelectItem;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author gouri
 */
@Entity
@Table(name = "fieldmetadata")
@NamedQueries({
  @NamedQuery(name = "Fieldmetadata.findAll", query = "SELECT f FROM Fieldmetadata f"),
  @NamedQuery(name = "Fieldmetadata.findByTenantID-ModuleID", query = "SELECT f FROM Fieldmetadata f WHERE f.tenantID = :tenantID AND f.moduleID = :moduleID ORDER BY f.name"),
  @NamedQuery(name = "Fieldmetadata.findByModuleID", query = "SELECT f FROM Fieldmetadata f WHERE f.moduleID = :moduleID"),
  @NamedQuery(name = "Fieldmetadata.findByName", query = "SELECT f FROM Fieldmetadata f WHERE f.name = :name")})
public class Fieldmetadata implements Serializable {
  @JoinColumn(name = "ModuleID", referencedColumnName = "ID", insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private Modules module;
  @JoinColumn(name = "TenantID", referencedColumnName = "ID", insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private Tenant tenant;
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Integer id;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "TenantID")
  private int tenantID;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "ModuleID")
  private int moduleID;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "Name")
  private String name;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 45)
  @Column(name = "Type")
  private String type;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 5)
  @Column(name = "Security")
  private String security;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 5)
  @Column(name = "IsVisible")
  private String isVisible;
  
  @Size(max = 45)
  @Column(name = "ValueCol")
  private String valueCol;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "Label")
  private String label;
  
  @Size(max = 5)
  @Column(name = "IsRequired")
  private String isRequired;
  
  @Column(name = "Attributes")
  private String attributes;
  
  @Column(name = "Choices")
  private String choices;
  
  @Transient
  private String valueStr;
  
  @Transient
  private List<String> valueList;
  
  @Transient
  private List<SelectItem> choiceList;
  
  @Transient 
  private Map<String,String> attributeMap;

  public Fieldmetadata() {
  }

  public Fieldmetadata(Integer id) {
    this.id = id;
  }

  public Fieldmetadata(Integer id, int tenantID, int moduleID, String name, String type, String security, String isVisible, String label) {
    this.id = id;
    this.tenantID = tenantID;
    this.moduleID = moduleID;
    this.name = name;
    this.type = type;
    this.security = security;
    this.isVisible = isVisible;
    this.label = label;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public int getTenantID() {
    return tenantID;
  }

  public void setTenantID(int tenantID) {
    this.tenantID = tenantID;
  }

  public int getModuleID() {
    return moduleID;
  }

  public void setModuleID(int moduleID) {
    this.moduleID = moduleID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getSecurity() {
    return security;
  }

  public void setSecurity(String security) {
    this.security = security;
  }

  public String getIsVisible() {
    return isVisible;
  }

  public void setIsVisible(String isVisible) {
    this.isVisible = isVisible;
  }

  public String getValueCol() {
    return valueCol;
  }

  public void setValueCol(String valueCol) {
    this.valueCol = valueCol;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getIsRequired() {
    return isRequired;
  }

  public void setIsRequired(String isRequired) {
    this.isRequired = isRequired;
  }

  public Map<String, String> getAttributeMap() {
    return attributeMap;
  }

  public void setAttributeMap(Map<String, String> attributeMap) {
    this.attributeMap = attributeMap;
  }

  public String getAttributes() {
    return attributes;
  }

  public void setAttributes(String attributes) {
    this.attributes = attributes;
  }

  public List<SelectItem> getChoiceList() {
    if(choiceList == null){
      choiceList = new ArrayList<SelectItem>();
    }
    return choiceList;
  }

  public void setChoiceList(List<SelectItem> choiceList) {
    this.choiceList = choiceList;
  }

  public String getChoices() {
    return choices;
  }

  public void setChoices(String choices) {
    this.choices = choices;
  }

  public List<String> getValueList() {
    return valueList;
  }

  public void setValueList(List<String> valueList) {
    this.valueList = valueList;
  }

  public String getValueStr() {
    return valueStr;
  }

  public void setValueStr(String valueStr) {
    this.valueStr = valueStr;
  }

  public Modules getModule() {
    return module;
  }

  public void setModule(Modules module) {
    this.module = module;
  }

  public Tenant getTenant() {
    return tenant;
  }

  public void setTenant(Tenant tenant) {
    this.tenant = tenant;
  }
  
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Fieldmetadata)) {
      return false;
    }
    Fieldmetadata other = (Fieldmetadata) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "hris.entity.Fieldmetadata[ id=" + id + " ]";
  }

  
  
}
