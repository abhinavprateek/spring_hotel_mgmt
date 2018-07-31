
package com.akshay.HotelManagementSystemException;

/**
 * @author Akshya Purohit
 *
 */
public class HotelManagementSystemException extends Exception {

    private static final long serialVersionUID = 1L;

    public HotelManagementSystemException() {
        super();
    }

    public HotelManagementSystemException(String message) {
        System.out.println(message);

    }

    public HotelManagementSystemException(Throwable cause) {
        super(cause);

    }

    @Override
    public String toString() {
        return "";

    }

    @Override
    public String getMessage() {
        return "";
    }

}

