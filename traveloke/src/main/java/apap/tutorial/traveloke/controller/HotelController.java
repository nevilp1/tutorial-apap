package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.HotelService;
import apap.tutorial.traveloke.service.KamarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HotelController {
    String statusHalaman;
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    private KamarService kamarService;

    @GetMapping("/")
    private String home(Model model){
        statusHalaman = "Home";
        model.addAttribute("statusHalaman", statusHalaman);
        return "home";
    }

    @GetMapping("/hotel/add")
    public String addHotelFormPage(Model model){
        statusHalaman = "Form add hotel";
        model.addAttribute("statusHalaman", statusHalaman);
        model.addAttribute("hotel", new HotelModel());
        return "form-add-hotel";
    }

    @PostMapping("/hotel/add")
    public String addHotelSubmit(
            @ModelAttribute HotelModel hotel,
            Model model
    ){
        statusHalaman = "Form add hotel";
        model.addAttribute("statusHalaman", statusHalaman);

        hotelService.addHotel(hotel);
        model.addAttribute("idHotel", hotel.getId());
        return "add-hotel";
    }

    @GetMapping("/hotel/change/{idHotel}")
    public String changeHotelFormPage(
            @PathVariable Long idHotel,
            Model model

    ){
        statusHalaman = "Form change hotel";
        model.addAttribute("statusHalaman", statusHalaman);
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        model.addAttribute("hotel", hotel);
        return "form-update-hotel";
    }

    @PostMapping("/hotel/change")
    public String changeHotelFormSubmit(
            @ModelAttribute HotelModel hotel,
            Model model
    ){
        statusHalaman = "Form change hotel";
        model.addAttribute("statusHalaman", statusHalaman);
        HotelModel hotelUpdated = hotelService.updateHotel(hotel);
        model.addAttribute("hotel", hotel);
        return "update-hotel";
    }

    @GetMapping("/hotel/view")
    public String viewDetailHotel(
            @RequestParam(value = "idHotel") Long idHotel,
            Model model
    ){

        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        List<KamarModel> listKamar = kamarService.findAllKamarByIdHotel(idHotel);
        Integer size = kamarService.getSizeList(idHotel);

        statusHalaman = "View hotel";
        model.addAttribute("statusHalaman", statusHalaman);
        model.addAttribute("size", size);
        model.addAttribute("hotel", hotel);
        model.addAttribute("listKamar", listKamar);
        return "view-hotel";
    }

    @RequestMapping("/hotel/viewall")
    public String viewAllHotel(
            Model model
    ) {
        List<HotelModel> listHotel = hotelService.getHotelList();

        // Add variabel semua HotelModel ke 'listHotel' untuk dirender pada thymeleaf
        model.addAttribute("listHotel", listHotel);
        statusHalaman = "View all hotel";
        model.addAttribute("statusHalaman", statusHalaman);
        // Return view template yang diinginkan
        return "viewall-hotel";

    }
    @GetMapping(value = "hotel/delete/{idHotel}")
    public String deleteHotelWithPathVariable(
            @PathVariable(value = "idHotel") Long idHotel,
            Model model
    ){
        // Menghapus Hotel sesuai dengan idHotel
        HotelModel hotel = hotelService.deleteHotel(idHotel);
        statusHalaman = "Delete hotel";
        model.addAttribute("statusHalaman", statusHalaman);
        model.addAttribute("hotel", hotel);

        return "delete-hotel";
    }
}
