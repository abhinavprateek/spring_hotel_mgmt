
package com.akshay.HotelManagementSystemService;

import com.akshay.HotelManagementSystemEntity.BookingDetail;
import com.akshay.HotelManagementSystemEntity.HotelInformation;
import com.akshay.HotelManagementSystemException.HotelManagementSystemException;
import java.util.ArrayList;


/**
 * 
 * @author Akshya Purohit
 *
 */
public interface HotelManagementSystemService {
    
    public ArrayList<String> getCityNames() throws HotelManagementSystemException;
    public ArrayList<String> getHotelNames(String city) throws HotelManagementSystemException;
    public ArrayList<HotelInformation> getLowestPricedHotels(String cityName) throws HotelManagementSystemException;
    public ArrayList<HotelInformation> getHotelDetails(String hotelName) throws HotelManagementSystemException;
    public void saveBookingDetails(BookingDetail bookingDetail)throws HotelManagementSystemException;
    public ArrayList<BookingDetail> getBookingDetails(int rooms,int hotelId) throws HotelManagementSystemException;
}
