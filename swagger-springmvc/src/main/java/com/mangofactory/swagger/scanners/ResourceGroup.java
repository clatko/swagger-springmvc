package com.mangofactory.swagger.scanners;

import com.google.common.base.Objects;
import org.apache.commons.lang.builder.EqualsBuilder;

public class ResourceGroup {
  private String title;
  private String groupName;
  private Integer position = 0;

  public ResourceGroup(String groupName) {
    this.groupName = groupName;
  }

  public ResourceGroup(String title, String groupName, Integer position) {
    this.title = title;
    this.groupName = groupName;
    this.position = position;
  }

  public void setTitle(String title) {
      this.title = title;
    }

    public String getTitle() {
      return title;
    }

    public String getGroupName() {
    return groupName;
  }

  public void setPosition(Integer position) {
    this.position = position;
  }

  public Integer getPosition() {
    return position;
  }

  @Override
  public boolean equals(Object obj) {

    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    if (obj.getClass() != getClass()) {
      return false;
    }
    ResourceGroup rhs = (ResourceGroup) obj;
    return new EqualsBuilder()
            .append(this.groupName, rhs.groupName)
            .isEquals();
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(groupName);
  }

  @Override
  public String toString() {
    return "ResourceGroup{" +
            "groupName='" + groupName + '\'' +
            '}';
  }
}
