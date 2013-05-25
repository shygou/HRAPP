/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hris.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Someone that is brand new
 */
@Entity
@Table(name = "tenant")
@NamedQueries({
  @NamedQuery(name = "Tenant.findAll", query = "SELECT t FROM Tenant t")})
public class Tenant implements Serializable {
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "tenant")
  private List<Fieldmetadata> fieldmetadataList;
  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "Name")
  private String name;

  public Tenant() {
  }

  public Tenant(Integer id) {
    this.id = id;
  }

  public Tenant(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
    if (!(object instanceof Tenant)) {
      return false;
    }
    Tenant other = (Tenant) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "hris.entity.Tenant[ id=" + id + " ]";
  }

  public List<Fieldmetadata> getFieldmetadataList() {
    return fieldmetadataList;
  }

  public void setFieldmetadataList(List<Fieldmetadata> fieldmetadataList) {
    this.fieldmetadataList = fieldmetadataList;
  }
  
}
