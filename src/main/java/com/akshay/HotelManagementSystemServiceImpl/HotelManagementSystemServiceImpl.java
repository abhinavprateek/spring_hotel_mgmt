
package com.akshay.HotelManagementSystemServiceImpl;

import com.akshay.HotelManagementSystemDao.HotelManagementSystemDao;
import com.akshay.HotelManagementSystemEntity.BookingDetail;
import com.akshay.HotelManagementSystemEntity.HotelInformation;
import com.akshay.HotelManagementSystemException.HotelManagementSystemException;
import com.akshay.HotelManagementSystemService.HotelManagementSystemService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Akshya Purohit
 */
@Service
public class HotelManagementSystemServiceImpl implements HotelManagementSystemService {
    
    @Autowired
    HotelManagementSystemDao hotelManagementSystemDao;

    public void setHotelManagementSystemDao(HotelManagementSystemDao hotelManagementSystemDao) {
        this.hotelManagementSystemDao = hotelManagementSystemDao;
    }
    
    @Transactional
    public ArrayList<String> getCityNames() throws HotelManagementSystemException {
        ArrayList<String> cityNames = null;
        try {
            cityNames = hotelManagementSystemDao.getCityNames();
        } catch (Exception ex) {
            throw new HotelManagementSystemException("Exception occured in Database : " + ex);
        }
        return cityNames;
    }

    @Transactional
    public ArrayList<String> getHotelNames(String city) throws HotelManagementSystemException {

        ArrayList<String> hotelNames = null;
        try {
            hotelNames = hotelManagementSystemDao.getHotelNames(city);
        } catch (Exception ex) {
            throw new HotelManagementSystemException("Exception occured in Database : " + ex);
        }
        return hotelNames;
    }

    @Transactional
    public ArrayList<HotelInformation> getLowestPricedHotels(String cityName) throws HotelManagementSystemException {
        ArrayList<HotelInformation> hotelsList = null;
        try {
            hotelsList = hotelManagementSystemDao.getLowestPricedHotels(cityName);
        } catch (Exception ex) {
            throw new HotelManagementSystemException("Exception occured in Database : " + ex);
        }
        return hotelsList;
    }

    @Transactional
    public ArrayList<HotelInformation> getHotelDetails(String hotelName) throws HotelManagementSystemException {
        ArrayList<HotelInformation> hotelDetails = null;
        try {
            hotelDetails = hotelManagementSystemDao.getHotelDetails(hotelName);
        } catch (Exception ex) {
            throw new HotelManagementSystemException("Exception occured in Database : " + ex);
        }
        return hotelDetails;
    }

    @Transactional
    public void saveBookingDetails(BookingDetail bookingDetail) throws HotelManagementSystemException {
        try {
            hotelManagementSystemDao.saveBookingDetails(bookingDetail);
        } catch (Exception ex) {
            throw new HotelManagementSystemException("Exception occured in Database : " + ex);
        }
    }

    @Transactional
    public ArrayList<BookingDetail> getBookingDetails(int rooms, int hotelId) throws HotelManagementSystemException {
        ArrayList<BookingDetail> bookingDetails = null;
        try {
            bookingDetails = hotelManagementSystemDao.getBookingDetails(rooms, hotelId);
        } catch (Exception ex) {
            throw new HotelManagementSystemException("Exception occured in Database : " + ex);
        }
        return bookingDetails;
    }
}
