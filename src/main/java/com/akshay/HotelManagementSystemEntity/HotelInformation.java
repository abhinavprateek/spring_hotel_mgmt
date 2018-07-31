
package com.akshay.HotelManagementSystemEntity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author Akshya purohit
 *
 */
@Entity
@Table(name = "hotel_information")
public class HotelInformation implements Serializable {
	@Id
	@Column(name = "id")
	private int hotelId;
	@Column(name = "name")
	private String hotelName;
	@Column(name = "address")
	private String address;
	@Column(name = "city")
	private String city;
	@Column(name = "number_of_rooms")
	private int numberOfRooms;
	@Column(name = "star_rating")
	private float starRating;
        @Column(name = "tariff_per_day")
	private float tariffPerDay;

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public float getStarRating() {
        return starRating;
    }

    public void setStarRating(float starRating) {
        this.starRating = starRating;
    }

    public float getTariffPerDay() {
        return tariffPerDay;
    }

    public void setTariffPerDay(float tarrifPerDay) {
        this.tariffPerDay = tarrifPerDay;
    }

    @Override
    public String toString() {
        return "Hotel{" + "hotelId=" + hotelId + ", hotelName=" + hotelName + ", address=" + address + ", city=" + city + ", numberOfRooms=" + numberOfRooms + ", starRating=" + starRating + ", tariffPerDay=" + tariffPerDay + '}';
    }

	
	
}
