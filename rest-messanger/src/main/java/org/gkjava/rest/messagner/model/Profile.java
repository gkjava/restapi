package org.gkjava.rest.messagner.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1058432203169027980L;

	private long profileId;
	
	private String profileName;
	
	private String firstName;
	
	private Date created;
	
	public Profile(long profileId, String profileName, String firstName,
			String lastName) {
		super();
		this.profileId = profileId;
		this.profileName = profileName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.created = new Date();
	}

	private String lastName;

	public Profile() {
		super();
	}

	public long getProfileId() {
		return profileId;
	}

	public void setProfileId(long profileId) {
		this.profileId = profileId;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
