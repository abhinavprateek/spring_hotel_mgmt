
package com.akshay.HotelManagementSystemController;

import com.akshay.HotelManagementSystemEntity.BookingDetail;
import com.akshay.HotelManagementSystemEntity.HotelInformation;
import com.akshay.HotelManagementSystemService.HotelManagementSystemService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author Akshya Purohit
 */
@Controller
public class HotelManagementSystemController {
    
    @Autowired
    private HotelManagementSystemService hotelManagementSystemService;
  
    public void setHotelManagementSystemService(HotelManagementSystemService hotelManagementSystemService) {
        this.hotelManagementSystemService = hotelManagementSystemService;
    }

    @RequestMapping("/bookRoom")
    public ModelAndView getCityNames() {
        try {
            ArrayList<String> hotelNames = new ArrayList<String>();
            ArrayList<String> cityNames = new ArrayList<String>();
            ModelAndView model = new ModelAndView("bookRoom");
            BookingDetail bookingDetails = new BookingDetail();
            cityNames = hotelManagementSystemService.getCityNames();
            model.addObject("cityNames", cityNames);
            model.addObject("bookingDetail", bookingDetails);
            model.addObject("hotelNames", hotelNames);
            model.addObject("display","none");
            return model;
        } catch (Exception ex) {
            ModelAndView model1 = new ModelAndView("error");
            return model1;
        }

    }

    @RequestMapping("/hotelNames")
    public ModelAndView getHotelNames(@RequestParam("cityName") String cityName) {
        try {
            ArrayList<String> hotelNames = new ArrayList<String>();
            if (!cityName.equalsIgnoreCase("0")) {
                hotelNames = hotelManagementSystemService.getHotelNames(cityName);
            }
            ModelAndView model = new ModelAndView("hotelList");
            BookingDetail bookingDetails = new BookingDetail();
            model.addObject("bookingDetail", bookingDetails);
            model.addObject("hotelNames", hotelNames);
            model.addObject("forEach","none");
            return model;
        } catch (Exception ex) {
            ModelAndView model1 = new ModelAndView("error");
            return model1;
        }
    }

    @RequestMapping("/lowestPricedHotels")
    public ModelAndView getLowestPricedHotels() {
        try {
            ModelAndView model = new ModelAndView("lowestPriceHotels");
            ArrayList<HotelInformation> hotelsList = new ArrayList<HotelInformation>();
            String cityName = "0";
            ArrayList<String> cityNames = new ArrayList<String>();
            BookingDetail bookingDetails = new BookingDetail();
            cityNames = hotelManagementSystemService.getCityNames();
            hotelsList = hotelManagementSystemService.getLowestPricedHotels(cityName);
            model.addObject("cityNames", cityNames);
            model.addObject("hotels", hotelsList);
            model.addObject("bookingDetail", bookingDetails);
            return model;
        } catch (Exception ex) {
            ModelAndView model1 = new ModelAndView("error");
            return model1;
        }
    }

    @RequestMapping("/lowestPricedHotelByCity")
    public ModelAndView getLowestPricedHotelsByCity(@RequestParam("cityName") String cityName) {
        try {
            ModelAndView model = new ModelAndView("hotelList");
            ArrayList<HotelInformation> hotelsList = new ArrayList<HotelInformation>();
            BookingDetail bookingDetails = new BookingDetail();
            ArrayList<String> cityNames = new ArrayList<String>();
            cityNames = hotelManagementSystemService.getCityNames();
            hotelsList = hotelManagementSystemService.getLowestPricedHotels(cityName);
            model.addObject("cityNames", cityNames);
            model.addObject("bookingDetail", bookingDetails);
            model.addObject("hotels", hotelsList);
            model.addObject("select","none");
            return model;
        } catch (Exception ex) {
            ModelAndView model1 = new ModelAndView("error");
            return model1;
        }
    }
    
    @RequestMapping("/saveBooking")
    public ModelAndView saveBookingDetails(@ModelAttribute("bookingDetail") BookingDetail bookingDetail) {
        try {
            
            ArrayList<HotelInformation> hotelDetails = hotelManagementSystemService.getHotelDetails(bookingDetail.getHotelName());
             if (hotelDetails.get(0).getNumberOfRooms() >= Integer.parseInt(bookingDetail.getNumberOfRooms())) {
            ArrayList<BookingDetail> bookedDetail = new ArrayList<BookingDetail>();
            ModelAndView model = new ModelAndView("showBookingDetails");
            if (hotelDetails != null && !hotelDetails.isEmpty()) {
                float numberOfRooms = Float.valueOf(bookingDetail.getNumberOfRooms());
                String totalAmount = String.valueOf((hotelDetails.get(0).getTariffPerDay()) * (numberOfRooms));
                bookingDetail.setTotalAmount(totalAmount);
                bookingDetail.setHotelId(hotelDetails.get(0));
                hotelManagementSystemService.saveBookingDetails(bookingDetail);
            }
            int bookedRooms = Integer.parseInt(bookingDetail.getNumberOfRooms());
            int remainingRooms = (hotelDetails.get(0).getNumberOfRooms() - bookedRooms);
            bookedDetail = hotelManagementSystemService.getBookingDetails(remainingRooms, hotelDetails.get(0).getHotelId());
            model.addObject("bookingId", bookedDetail.get(0).getBookingId());
            model.addObject("details", bookedDetail);
            return model;
             }
             else {
                  ModelAndView model = new ModelAndView("bookRoom");
                 model = getCityNames();
                 model.addObject("value","Rooms Are Not Available In "+bookingDetail.getCheckInDate());
                 model.addObject("display","block");
                 return model;
             }
        } catch (Exception ex) {
            ModelAndView model1 = new ModelAndView("error");
            return model1;
        }
    }
}
