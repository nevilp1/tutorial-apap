package apap.tutorial.traveloke.controller;


import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.HotelService;
import apap.tutorial.traveloke.service.KamarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class KamarController {
    String statusHalaman;

    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    private KamarService kamarService;

    @GetMapping("/kamar/add/{idHotel}")
    private String addKamarFormPage(
            @PathVariable Long idHotel,
            Model model
    ){
        KamarModel kamar = new KamarModel();
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        kamar.setHotel(hotel);

        model.addAttribute("idHotel", idHotel);
        model.addAttribute("kamar", kamar);
        statusHalaman = "Form add kamar";
        model.addAttribute("statusHalaman", statusHalaman);

        return "form-add-kamar";

    }
    @PostMapping(path="/kamar/add/{idHotel}", params = "add_baris")
    private String addBaris(Model model
    ){
        HotelModel hotel = new HotelModel();
        hotel.getListKamar().add(new KamarModel());
        model.addAttribute("hotel", hotel.getListKamar());
        return "form-add-kamar";
    }

    @PostMapping("/kamar/add")
    private String addKamarSubmit(
        @ModelAttribute KamarModel kamar,
        Model model
    ){
        statusHalaman = "Add kamar";
        model.addAttribute("statusHalaman", statusHalaman);
        kamarService.addKamar(kamar);

        model.addAttribute("kamar", kamar);

        return "add-kamar";
    }

    @GetMapping("/kamar/change/{noKamar}")
    public String changeKamarFormPage(
            @PathVariable Long noKamar,
            Model model

    ){
        statusHalaman = "Form update kamar";
        model.addAttribute("statusHalaman", statusHalaman);
        KamarModel kamar = kamarService.getKamarById(noKamar);
        model.addAttribute("kamar", kamar);
        return "form-update-kamar";
    }

    @PostMapping("/kamar/change")
    public String changeHotelFormSubmit(
            @ModelAttribute KamarModel kamar,
            Model model
    ){
        KamarModel updateKamar = kamarService.kamarUpdate(kamar);
        model.addAttribute("kamar", kamar);
        statusHalaman = "Update kamar";
        model.addAttribute("statusHalaman", statusHalaman);
        return "update-kamar";
    }
    @PostMapping(path = "/kamar/delete")
    public String deleteKamarFormSubmit(
            @ModelAttribute HotelModel hotel,
            Model model
    ){
        model.addAttribute("kamarCount",hotel.getListKamar().size());

        for(KamarModel kamar : hotel.getListKamar()){
            kamarService.deleteKamar(kamar);
        }
        statusHalaman = "Delete kamar";
        model.addAttribute("statusHalaman", statusHalaman);
        return "delete-kamar";
    }

    @GetMapping(value = "kamar/delete/{noKamar}")
    public String deleteHotelWithPathVariable(
            @PathVariable(value = "noKamar") Long noKamar,
            Model model
    ){
        // Menghapus Hotel sesuai dengan nomorKamar
        kamarService.deleteKamarId(noKamar);

        return "delete-kamar";
    }
}
