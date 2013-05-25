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
 * @author gouri
 */
@Entity
@Table(name = "modules")
@NamedQueries({
  @NamedQuery(name = "Modules.findAll", query = "SELECT m FROM Modules m")})
public class Modules implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "Name")
  private String name;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "module")
  private List<Fieldmetadata> fieldmetadataList;

  public Modules() {
  }

  public Modules(Integer id) {
    this.id = id;
  }

  public Modules(Integer id, String name) {
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

  public List<Fieldmetadata> getFieldmetadataList() {
    return fieldmetadataList;
  }

  public void setFieldmetadataList(List<Fieldmetadata> fieldmetadataList) {
    this.fieldmetadataList = fieldmetadataList;
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
    if (!(object instanceof Modules)) {
      return false;
    }
    Modules other = (Modules) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "hris.entity.Modules[ id=" + id + " ]";
  }
  
}
