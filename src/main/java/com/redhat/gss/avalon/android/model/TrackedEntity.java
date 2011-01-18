package com.redhat.gss.avalon.android.model;

import java.io.Serializable;
import java.util.Calendar;

import org.simpleframework.xml.Element;

/**
 * Note: This is a clone of the model object in Support Services API.
 * 
 * Base class to abstract tracking information on domain entities.
 * 
 * @author Brian Dill
 * 
 */
public abstract class TrackedEntity implements Serializable {

	private static final long serialVersionUID = 4356197305201174666L;

	@Element
	protected String createdBy;

	@Element
	protected Calendar createdDate;

	@Element
	protected String lastModifiedBy;

	@Element
	protected Calendar lastModifiedDate;

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
	 * Gets the value of the createdDate property.
	 *
	 * @return possible object is {@link Calendar }
	 *
	 */
	public Calendar getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the value of the createdDate property.
	 *
	 * @param value
	 *		    allowed object is {@link Calendar }
	 *
	 */
	public void setCreatedDate(Calendar value) {
		this.createdDate = value;
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

	/**
	 * Gets the value of the lastModifiedDate property.
	 *
	 * @return possible object is {@link Calendar }
	 *
	 */
	public Calendar getLastModifiedDate() {
		return lastModifiedDate;
	}

	/**
	 * Sets the value of the lastModifiedDate property
	 *
	 * @param value
	 *		    allowed object is {@link Calendar }
	 *
	 */
	public void setLastModifiedDate(Calendar value) {
		this.lastModifiedDate = value;
	}
}
