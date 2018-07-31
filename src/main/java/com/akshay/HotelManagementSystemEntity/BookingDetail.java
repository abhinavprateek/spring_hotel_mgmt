
package com.akshay.HotelManagementSystemEntity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * 
 * @author Akshya purohit
 *
 */
@Entity
@Table(name = "booking_details")
public class BookingDetail implements Serializable {
	@Id
	@Column(name = "Booking_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
        @Column(name = "city")
	private String city;
        @Column(name = "hotel_name")
	private String hotelName;
        @ManyToOne
        @JoinColumn(name="id")
	HotelInformation hotelId;
	@Column(name = "check_in_date")
	private String checkInDate;
	@Column(name = "check_out_date")
	private String checkOutDate;
        @Column(name = "number_of_rooms")
	private String numberOfRooms;
        @Column(name = "total_amount")
        private String totalAmount;

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public HotelInformation getHotelId() {
        return hotelId;
    }

    public void setHotelId(HotelInformation hotelId) {
        this.hotelId = hotelId;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(String numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

     @Override
    public String toString() {
        return "BookingDetail{" + "bookingId=" + bookingId + ", city=" + city + ", hotelId=" + hotelId + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + ", numberOfRooms=" + numberOfRooms + ", totalAmount=" + totalAmount + '}';
    }

 

}