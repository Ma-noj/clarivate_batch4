package edu.clarivate.manytoone_example.controller;

import java.util.Arrays;
import java.util.List;

import edu.clarivate.manytoone_example.dao.HotelDao;
import edu.clarivate.manytoone_example.dao.RoomDao;
import edu.clarivate.manytoone_example.entity.Hotel;
import edu.clarivate.manytoone_example.entity.Room;

public class HotelManagementController {

	public static void main(String[] args) {
		Hotel hotel = readHotelInfo();
		List<Room> listOfRooms = readRoomInfo(hotel);
		HotelDao hotelDao = new HotelDao();
		hotelDao.saveHotel(hotel);
		RoomDao roomDao = new RoomDao();
		for (Room room : listOfRooms) {
			roomDao.saveRoom(room);
		}

		System.out.println("Hotel Info With the Room Detalies Saved!!!");
	}

	public static List<Room> readRoomInfo(Hotel hotel) {
		Room room1 = new Room();
		room1.setId(104);
		room1.setName("F102");
		room1.setNumberOfUser(3);
		room1.setType("Non-Ac");
		room1.setPrice(1200);
		room1.setHotel(hotel);

		Room room2 = new Room();
		room2.setId(105);
		room2.setName("S103");
		room2.setNumberOfUser(2);
		room2.setType("Ac");
		room2.setPrice(1800);
		room2.setHotel(hotel);

		Room room3 = new Room();
		room3.setId(106);
		room3.setName("S104");
		room3.setNumberOfUser(4);
		room3.setType("Ac");
		room3.setPrice(3000);
		room3.setHotel(hotel);

		return Arrays.asList(room1, room2, room3);
	}

	public static Hotel readHotelInfo() {
		Hotel hotel = new Hotel();
		hotel.setId(1002);
		hotel.setName("Empire");
		hotel.setLocation("USA");
		return hotel;
	}

}
