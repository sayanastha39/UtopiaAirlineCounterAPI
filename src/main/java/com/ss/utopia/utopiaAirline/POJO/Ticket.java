package com.ss.utopia.utopiaAirline.POJO;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ticket")
public class Ticket implements Serializable{
 
	private static final long serialVersionUID = -8307002474986779175L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "ticketId")
	private Integer ticketId;
	
	@Column(name = "flightPrice")
	private Integer flightPrice;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "reservationId")
	private Reservation reservationId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "itineraryId")
	private Itinerary itineraryId;
	
	public Ticket() {}

	public Ticket(Integer ticketId, Integer flightPrice, Reservation reservationId, Itinerary itineraryId) {
		super();
		this.ticketId = ticketId;
		this.flightPrice = flightPrice;
		this.reservationId = reservationId;
		this.itineraryId = itineraryId;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public Integer getFlightPrice() {
		return flightPrice;
	}

	public void setFlightPrice(Integer flightPrice) {
		this.flightPrice = flightPrice;
	}

	public Reservation getReservationId() {
		return reservationId;
	}

	public void setReservationId(Reservation reservationId) {
		this.reservationId = reservationId;
	}

	public Itinerary getItineraryId() {
		return itineraryId;
	}

	public void setItineraryId(Itinerary itineraryId) {
		this.itineraryId = itineraryId;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", flightPrice=" + flightPrice + ", reservationId=" + reservationId
				+ ", itineraryId=" + itineraryId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flightPrice == null) ? 0 : flightPrice.hashCode());
		result = prime * result + ((itineraryId == null) ? 0 : itineraryId.hashCode());
		result = prime * result + ((reservationId == null) ? 0 : reservationId.hashCode());
		result = prime * result + ((ticketId == null) ? 0 : ticketId.hashCode());
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
		Ticket other = (Ticket) obj;
		if (flightPrice == null) {
			if (other.flightPrice != null)
				return false;
		} else if (!flightPrice.equals(other.flightPrice))
			return false;
		if (itineraryId == null) {
			if (other.itineraryId != null)
				return false;
		} else if (!itineraryId.equals(other.itineraryId))
			return false;
		if (reservationId == null) {
			if (other.reservationId != null)
				return false;
		} else if (!reservationId.equals(other.reservationId))
			return false;
		if (ticketId == null) {
			if (other.ticketId != null)
				return false;
		} else if (!ticketId.equals(other.ticketId))
			return false;
		return true;
	}
	
}