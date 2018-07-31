
package com.akshay.HotelManagementSystemDaoImpl;

import com.akshay.HotelManagementSystemDao.HotelManagementSystemDao;
import com.akshay.HotelManagementSystemEntity.BookingDetail;
import com.akshay.HotelManagementSystemEntity.HotelInformation;
import com.akshay.HotelManagementSystemException.HotelManagementSystemException;
import java.util.ArrayList;
import org.hibernate.Query;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Akshya Purohit
 */

@Repository
public class HotelManagementSystemDaoImpl implements HotelManagementSystemDao {

    HibernateTemplate template;  
	
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  
	
        @Override
        public ArrayList<String> getCityNames() throws HotelManagementSystemException {
        ArrayList<String> cityNames=null;
        try{
	
		String query = "select distinct hotel.city from HotelInformation hotel";
		cityNames =(ArrayList<String>) template.find(query);
	}
	catch(Exception ex)
	{
		throw new HotelManagementSystemException("Exception occured in Database : "+ex);
	}
        return cityNames;
    }
        
        @Override
        public ArrayList<String> getHotelNames(String city) throws HotelManagementSystemException {
        ArrayList<String> hotelNames=null;
        try{
	
		String queryString = "select hotel.hotelName from HotelInformation hotel where hotel.city =?";
                Object[] queryParam = {city};
		hotelNames = (ArrayList<String>) template.find(queryString, queryParam);
	}
	catch(Exception ex)
	{
		throw new HotelManagementSystemException("Exception occured in Database : "+ex);
	}
        return hotelNames;
        }
        
        @Override
        public ArrayList<HotelInformation> getLowestPricedHotels(String cityName) throws HotelManagementSystemException {
            ArrayList<HotelInformation> hotelsList = null;
            try {
                String queryString;
                template.setMaxResults(5);
                if (cityName.equalsIgnoreCase("0")) {
                    queryString = "from HotelInformation hotel order by hotel.tariffPerDay";
                    hotelsList = (ArrayList<HotelInformation>) template.find(queryString);
                } else {
                    queryString = "from HotelInformation hotel where hotel.city=? order by hotel.tariffPerDay";
                    Object[] queryParam = {cityName};
                    hotelsList = (ArrayList<HotelInformation>) template.find(queryString, queryParam);
                }
                 template.setMaxResults(0);
            } catch (Exception ex) {
                throw new HotelManagementSystemException("Exception occured in Database : "+ex);
            }
            finally {
                template.setMaxResults(0);
            }
                return hotelsList;
            }
         
        @Override
        public ArrayList<HotelInformation> getHotelDetails(String hotelName) throws HotelManagementSystemException {
             ArrayList<HotelInformation> hotelDetails = null;
             try{
                 String query = "from HotelInformation hotel where hotel.hotelName=?";
                 Object[] queryParam = {hotelName};
                    hotelDetails = (ArrayList<HotelInformation>) template.find(query, queryParam);
             }
             catch(Exception ex)
             {
                 throw new HotelManagementSystemException("Exception occured in Database : "+ex);
             }
             return hotelDetails;
        }
        
        @Override
        @Transactional(readOnly = false)
        public void saveBookingDetails(BookingDetail bookingDetail) throws HotelManagementSystemException {
            int response=0;
            try{
               template.saveOrUpdate(bookingDetail);
            }
            catch(Exception ex)
             {
                 throw new HotelManagementSystemException("Exception occured in Database : "+ex);
             }
        }
        
        @Override
        @Transactional(readOnly = false)
        public ArrayList<BookingDetail> getBookingDetails(int rooms,int hotelId) throws HotelManagementSystemException {
            ArrayList<BookingDetail> bookingDetail=null;
            try{
                String query = "update HotelInformation hotel set hotel.numberOfRooms  = :rooms where hotel.hotelId = :hotelId";
                String queryString  = "from BookingDetail book order by book.bookingId desc";
                Query sessionQuery = template.getSessionFactory().getCurrentSession().createQuery(query);
                sessionQuery.setParameter("rooms",rooms);
                sessionQuery.setParameter("hotelId", hotelId);
                sessionQuery.executeUpdate();
                 template.setMaxResults(1);
                 bookingDetail = (ArrayList<BookingDetail>)template.find(queryString);    
                 template.setMaxResults(0);
               }
            catch(Exception ex)
            {
               throw new HotelManagementSystemException("Exception occured in Database : "+ex);
            }
            finally {
                 template.setMaxResults(0);
            }
            return bookingDetail;
        }
}
