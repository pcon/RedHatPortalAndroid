package com.redhat.gss.avalon.android.model;

import java.io.Serializable;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.redhat.gss.strata.model.TrackedEntity;

/**
 * This is a clone of the model object in Support Services API.
 * 
 * @author Brian Dill
 * 
 */
// Currently not strict because Calendar is not handled
@Root(strict = false)
public class Case extends TrackedEntity implements Serializable {

	private static final long serialVersionUID = 7428830188443011412L;

	@Element(required = false)
	protected String id;
	@Element(required = false)
	protected String uri;
	@Element(required = false)
	protected String summary;
	@Element(required = false)
	protected String description;
	@Element(required = false)
	protected String status;
	@Element(required = false)
	protected String product;
	@Element(required = false)
	protected String component;
	@Element(required = false)
	protected String version;
	@Element(required = false)
	protected String type;
	@Element(required = false)
	protected String accountNumber;
	@Element(required = false)
	protected String reference;
	@Element(required = false)
	protected String notes;
	@Element(required = false)
	protected Boolean escalated;
	@Element(required = false)
	protected String contactName;
	@Element(required = false)
	protected String origin;
	@Element(required = false)
	protected String owner;
	@Element(required = false)
	protected String internalPriority;
	@Element(required = false)
	protected String internalStatus;
	@Element(required = false)
	protected String suppliedName;
	@Element(required = false)
	protected String suppliedPhone;
	@Element(required = false)
	protected String suppliedEmail;
	@Element(required = false)
	protected String severity;
	@Element(required = false)
	protected String folderNumber;
	@Attribute(required = false)
	protected String alternateId;
	@Attribute
	protected String caseNumber;
	@Attribute(required = false)
	protected Boolean closed;

	/**
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setId(String value) {
		this.id = value;
	}

	/**
	 * Gets the value of the uri property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * Sets the value of the uri property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUri(String value) {
		this.uri = value;
	}

	/**
	 * Gets the value of the summary property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * Sets the value of the summary property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSummary(String value) {
		this.summary = value;
	}

	/**
	 * Gets the value of the description property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the value of the description property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Gets the value of the status property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the value of the status property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setStatus(String value) {
		this.status = value;
	}

	/**
	 * Gets the value of the product property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getProduct() {
		return product;
	}

	/**
	 * Sets the value of the product property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setProduct(String value) {
		this.product = value;
	}

	/**
	 * Gets the value of the component property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getComponent() {
		return component;
	}

	/**
	 * Sets the value of the component property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setComponent(String value) {
		this.component = value;
	}

	/**
	 * Gets the value of the version property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Sets the value of the version property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setVersion(String value) {
		this.version = value;
	}

	/**
	 * Gets the value of the type property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the value of the type property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setType(String value) {
		this.type = value;
	}

	/**
	 * Gets the value of the accountNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Sets the value of the accountNumber property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAccountNumber(String value) {
		this.accountNumber = value;
	}

	/**
	 * Gets the value of the reference property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * Sets the value of the reference property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setReference(String value) {
		this.reference = value;
	}

	/**
	 * Gets the value of the notes property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * Sets the value of the notes property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNotes(String value) {
		this.notes = value;
	}

	/**
	 * Gets the value of the escalated property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isEscalated() {
		return escalated;
	}

	/**
	 * Sets the value of the escalated property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setEscalated(Boolean value) {
		this.escalated = value;
	}

	/**
	 * Gets the value of the contactName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getContactName() {
		return contactName;
	}

	/**
	 * Sets the value of the contactName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setContactName(String value) {
		this.contactName = value;
	}

	/**
	 * Gets the value of the origin property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * Sets the value of the origin property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOrigin(String value) {
		this.origin = value;
	}

	/**
	 * Gets the value of the owner property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Sets the value of the owner property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOwner(String value) {
		this.owner = value;
	}

	/**
	 * Gets the value of the internalPriority property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getInternalPriority() {
		return internalPriority;
	}

	/**
	 * Sets the value of the internalPriority property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInternalPriority(String value) {
		this.internalPriority = value;
	}

	/**
	 * Gets the value of the internalStatus property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getInternalStatus() {
		return internalStatus;
	}

	/**
	 * Sets the value of the internalStatus property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInternalStatus(String value) {
		this.internalStatus = value;
	}

	/**
	 * Gets the value of the suppliedName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSuppliedName() {
		return suppliedName;
	}

	/**
	 * Sets the value of the suppliedName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSuppliedName(String value) {
		this.suppliedName = value;
	}

	/**
	 * Gets the value of the suppliedPhone property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSuppliedPhone() {
		return suppliedPhone;
	}

	/**
	 * Sets the value of the suppliedPhone property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSuppliedPhone(String value) {
		this.suppliedPhone = value;
	}

	/**
	 * Gets the value of the suppliedEmail property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSuppliedEmail() {
		return suppliedEmail;
	}

	/**
	 * Sets the value of the suppliedEmail property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSuppliedEmail(String value) {
		this.suppliedEmail = value;
	}

	/**
	 * Gets the value of the severity property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * Sets the value of the severity property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSeverity(String value) {
		this.severity = value;
	}

	/**
	 * Gets the value of the folderNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFolderNumber() {
		return folderNumber;
	}

	/**
	 * Sets the value of the folderNumber property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFolderNumber(String value) {
		this.folderNumber = value;
	}

	/**
	 * Gets the value of the alternateId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAlternateId() {
		return alternateId;
	}

	/**
	 * Sets the value of the alternateId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAlternateId(String value) {
		this.alternateId = value;
	}

	/**
	 * Gets the value of the caseNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCaseNumber() {
		return caseNumber;
	}

	/**
	 * Sets the value of the caseNumber property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCaseNumber(String value) {
		this.caseNumber = value;
	}

	/**
	 * Gets the value of the closed property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isClosed() {
		return closed;
	}

	/**
	 * Sets the value of the closed property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setClosed(Boolean value) {
		this.closed = value;
	}

	/**
	 * TODO Use ToStringBuilder from Apache commons.
	 */
	@Override
	public String toString() {
		return "Case " + caseNumber;
	}

}

