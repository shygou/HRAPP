/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hris.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author gouri
 */
@Entity
@Table(name = "datavalues")
@NamedQueries({
  @NamedQuery(name = "Datavalues.findAll", query = "SELECT d FROM Datavalues d")})
public class Datavalues implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID")
  private Integer id;
  @Column(name = "value1")
  private Integer value1;
  @Basic(optional = false)
  @NotNull
  @Column(name = "moduleID")
  private int moduleID;
  @Basic(optional = false)
  @NotNull
  @Column(name = "tenantID")
  private int tenantID;
  @Column(name = "value2")
  private Integer value2;
  @Column(name = "value3")
  private Integer value3;
  @Column(name = "value4")
  private Integer value4;
  @Column(name = "value5")
  private Integer value5;
  @Column(name = "value6")
  private Long value6;
  @Column(name = "value7")
  private Long value7;
  @Column(name = "value8")
  private Long value8;
  @Column(name = "value9")
  private Long value9;
  @Column(name = "value10")
  @Temporal(TemporalType.DATE)
  private Date value10;
  @Column(name = "value11")
  @Temporal(TemporalType.DATE)
  private Date value11;
  @Column(name = "value12")
  @Temporal(TemporalType.DATE)
  private Date value12;
  @Column(name = "value13")
  @Temporal(TemporalType.DATE)
  private Date value13;
  @Size(max = 250)
  @Column(name = "value14")
  private String value14;
  @Size(max = 245)
  @Column(name = "value15")
  private String value15;
  @Size(max = 245)
  @Column(name = "value16")
  private String value16;
  @Size(max = 245)
  @Column(name = "value17")
  private String value17;
  @Size(max = 245)
  @Column(name = "value18")
  private String value18;
  @Size(max = 245)
  @Column(name = "value19")
  private String value19;
  @Size(max = 245)
  @Column(name = "value20")
  private String value20;
  @Size(max = 245)
  @Column(name = "value21")
  private String value21;
  @Size(max = 250)
  @Column(name = "value22")
  private String value22;
  @Size(max = 245)
  @Column(name = "value23")
  private String value23;
  @Size(max = 245)
  @Column(name = "value24")
  private String value24;
  @Size(max = 250)
  @Column(name = "value25")
  private String value25;

  public Datavalues() {
  }

  public Datavalues(Integer id) {
    this.id = id;
  }

  public Datavalues(Integer id, int moduleID, int tenantID) {
    this.id = id;
    this.moduleID = moduleID;
    this.tenantID = tenantID;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getValue1() {
    return value1;
  }

  public void setValue1(Integer value1) {
    this.value1 = value1;
  }

  public int getModuleID() {
    return moduleID;
  }

  public void setModuleID(int moduleID) {
    this.moduleID = moduleID;
  }

  public int getTenantID() {
    return tenantID;
  }

  public void setTenantID(int tenantID) {
    this.tenantID = tenantID;
  }

  public Integer getValue2() {
    return value2;
  }

  public void setValue2(Integer value2) {
    this.value2 = value2;
  }

  public Integer getValue3() {
    return value3;
  }

  public void setValue3(Integer value3) {
    this.value3 = value3;
  }

  public Integer getValue4() {
    return value4;
  }

  public void setValue4(Integer value4) {
    this.value4 = value4;
  }

  public Integer getValue5() {
    return value5;
  }

  public void setValue5(Integer value5) {
    this.value5 = value5;
  }

  public Long getValue6() {
    return value6;
  }

  public void setValue6(Long value6) {
    this.value6 = value6;
  }

  public Long getValue7() {
    return value7;
  }

  public void setValue7(Long value7) {
    this.value7 = value7;
  }

  public Long getValue8() {
    return value8;
  }

  public void setValue8(Long value8) {
    this.value8 = value8;
  }

  public Long getValue9() {
    return value9;
  }

  public void setValue9(Long value9) {
    this.value9 = value9;
  }

  public Date getValue10() {
    return value10;
  }

  public void setValue10(Date value10) {
    this.value10 = value10;
  }

  public Date getValue11() {
    return value11;
  }

  public void setValue11(Date value11) {
    this.value11 = value11;
  }

  public Date getValue12() {
    return value12;
  }

  public void setValue12(Date value12) {
    this.value12 = value12;
  }

  public Date getValue13() {
    return value13;
  }

  public void setValue13(Date value13) {
    this.value13 = value13;
  }

  public String getValue14() {
    return value14;
  }

  public void setValue14(String value14) {
    this.value14 = value14;
  }

  public String getValue15() {
    return value15;
  }

  public void setValue15(String value15) {
    this.value15 = value15;
  }

  public String getValue16() {
    return value16;
  }

  public void setValue16(String value16) {
    this.value16 = value16;
  }

  public String getValue17() {
    return value17;
  }

  public void setValue17(String value17) {
    this.value17 = value17;
  }

  public String getValue18() {
    return value18;
  }

  public void setValue18(String value18) {
    this.value18 = value18;
  }

  public String getValue19() {
    return value19;
  }

  public void setValue19(String value19) {
    this.value19 = value19;
  }

  public String getValue20() {
    return value20;
  }

  public void setValue20(String value20) {
    this.value20 = value20;
  }

  public String getValue21() {
    return value21;
  }

  public void setValue21(String value21) {
    this.value21 = value21;
  }

  public String getValue22() {
    return value22;
  }

  public void setValue22(String value22) {
    this.value22 = value22;
  }

  public String getValue23() {
    return value23;
  }

  public void setValue23(String value23) {
    this.value23 = value23;
  }

  public String getValue24() {
    return value24;
  }

  public void setValue24(String value24) {
    this.value24 = value24;
  }

  public String getValue25() {
    return value25;
  }

  public void setValue25(String value25) {
    this.value25 = value25;
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
    if (!(object instanceof Datavalues)) {
      return false;
    }
    Datavalues other = (Datavalues) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "hris.entity.Datavalues[ id=" + id + " ]";
  }
  
}
