package com.project.mountains.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="mountains")
public class Mountain {
	
	@Column(name="name")
	@NotNull(message="* Name is Required")
	private String name;
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rank")
	@NotNull(message="* Rank is Required")
	//@Size(min=1, message="is required")
	@Min(value=1, message="* Rank must be positive Integer value")
	private Integer rank;
	
	@Column(name="known_as")
	private String knownAs;
	
	@NotNull(message="* Location is Required")
	@Column(name="location")
	private String location;
	
	@NotNull(message="* Height is Required")
	@Column(name="height")
	private String height;
	
	
	@Column(name="first_ascent")
	//@NotNull(message="* First Ascent is Required")
	//@Pattern(regexp="^[0-9]{4}$",message="* First Ascent should be a valid year")
	private Integer firstAscent;
	
	@Column(name="image_url")
	private String imageUrl;

	
	public Mountain(){
		
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getKnownAs() {
		return knownAs;
	}

	public void setKnownAs(String knownAs) {
		this.knownAs = knownAs;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public Integer getFirstAscent() {
		return firstAscent;
	}

	public void setFirstAscent(Integer firstAscent) {
		this.firstAscent = firstAscent;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Mountain [name=" + name + ", rank=" + rank + ", knownAs=" + knownAs + ", location=" + location
				+ ", height=" + height + ", firstAscent=" + firstAscent + ", imageUrl=" + imageUrl + "]";
	}
	
	
}
