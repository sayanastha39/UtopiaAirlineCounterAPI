package com.ss.utopia.utopiaAirline.POJO;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Itinerary")
public class Itinerary implements Serializable{
 
	private static final long serialVersionUID = -3942671028586821599L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "itineraryId")
	private Integer itineraryId;
	
	@Column(name = "availableSeats")
	private Integer availableSeats;
	
	@Column(name = "departureDate")
	private Timestamp departureDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "flightNo")
	private Flights flightNo;
	
	@OneToMany(mappedBy = "itineraryId")
	private Collection<Ticket> Ticket;
	
	public Itinerary() {}

	public Itinerary(Integer itineraryId, Integer availableSeats, Timestamp departureDate, Flights flightNo) {
		super();
		this.itineraryId = itineraryId;
		this.availableSeats = availableSeats;
		this.departureDate = departureDate;
		this.flightNo = flightNo;
	}

	public Integer getItineraryId() {
		return itineraryId;
	}

	public void setItineraryId(Integer itineraryId) {
		this.itineraryId = itineraryId;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Timestamp getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Timestamp departureDate) {
		this.departureDate = departureDate;
	}

	public Flights getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(Flights flightNo) {
		this.flightNo = flightNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((availableSeats == null) ? 0 : availableSeats.hashCode());
		result = prime * result + ((departureDate == null) ? 0 : departureDate.hashCode());
		result = prime * result + ((flightNo == null) ? 0 : flightNo.hashCode());
		result = prime * result + ((itineraryId == null) ? 0 : itineraryId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Itinerary other = (Itinerary) obj;
		if (availableSeats == null) {
			if (other.availableSeats != null)
				return false;
		} else if (!availableSeats.equals(other.availableSeats))
			return false;
		if (departureDate == null) {
			if (other.departureDate != null)
				return false;
		} else if (!departureDate.equals(other.departureDate))
			return false;
		if (flightNo == null) {
			if (other.flightNo != null)
				return false;
		} else if (!flightNo.equals(other.flightNo))
			return false;
		if (itineraryId == null) {
			if (other.itineraryId != null)
				return false;
		} else if (!itineraryId.equals(other.itineraryId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Itinerary [itineraryId=" + itineraryId + ", availableSeats=" + availableSeats + ", departureDate="
				+ departureDate + ", flightNo=" + flightNo + "]";
	}
	
}