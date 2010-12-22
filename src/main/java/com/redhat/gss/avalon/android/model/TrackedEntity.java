package com.redhat.gss.avalon.android.model;

import java.io.Serializable;

import org.simpleframework.xml.Element;

public abstract class TrackedEntity implements Serializable {

	private static final long serialVersionUID = 4356197305201174666L;

	@Element
	protected String createdBy;

	@Element
	protected String lastModifiedBy;

	/**
	 * Gets the value of the createdBy property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets the value of the createdBy property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCreatedBy(String value) {
		this.createdBy = value;
	}

	/**
	 * Gets the value of the lastModifiedBy property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	/**
	 * Sets the value of the lastModifiedBy property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLastModifiedBy(String value) {
		this.lastModifiedBy = value;
	}

}

