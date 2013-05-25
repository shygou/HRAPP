/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hris.beans;

import java.io.Serializable;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author gouri
 */
public class Field implements Serializable {
    private String name;
    private String type;
    private String required;
    private String value;
    private List<SelectItem> choices;
    
    public Field(String name, String type, String required, List<SelectItem> choices) {
        this.name = name;
        this.type = type;
        this.required = required;
        this.choices = choices;
    }

    public Field(String name, String type, String required) {
        this.name = name;
        this.type = type;
        this.required = required;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

  public List<SelectItem> getChoices() {
    return choices;
  }

  public void setChoices(List<SelectItem> choices) {
    this.choices = choices;
  }
    
}
