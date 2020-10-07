package apap.tutorial.traveloke.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import apap.tutorial.traveloke.model.HotelModel;

@Service
public class HotelInMemoryService implements HotelService{
    private List<HotelModel> listHotel;

    public HotelInMemoryService() {
        listHotel = new ArrayList<>();
    }

    @Override
    public void addHotel(HotelModel hotel) {
        listHotel.add(hotel);
    }

    @Override
    public List<HotelModel> getHotelList() {
        return listHotel;
    }

    @Override
    public HotelModel getHotelByIdHotel(String idHotel) {
        for (HotelModel hotelModel : listHotel) {
            if (hotelModel.getIdHotel().equals(idHotel)) {
                return hotelModel;
            }
        }
        return null;
    }
}
