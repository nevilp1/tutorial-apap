package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;

import java.util.List;

public interface HotelService {
    // Method untuk menambah Hotel
    void addHotel(HotelModel hotel);

    //Method untuk mendapatkan daftar hotel yang telah tersimpan
    List<HotelModel> getHotelList();

    // Method untuk mendapatkan data sebuah hotel berdasarkan id hotel
    HotelModel getHotelByIdHotel(Long idHotel);

    // Method untuk update hotel
    HotelModel updateHotel(HotelModel hotel);

    HotelModel deleteHotel(Long id);


    void deleteHotel(HotelModel hotel);

    void changeNumber(HotelModel hotel, String nomor);
}
