package apap.tutorial.traveloke.restcontroller;

import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.KamarRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class KamarRestController {
    @Autowired
    private KamarRestService kamarRestService;

    @PostMapping(value = "kamar")
    private ResponseEntity<String> createKamar(
            @Valid @RequestBody KamarModel kamar,
            BindingResult bindingResult
    ){
        if (bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field"
            );
        }
        else {
            kamarRestService.createKamar(kamar);
            return ResponseEntity.ok("Add kamar success!");
        }
    }

    @PutMapping(value = "/kamar/{kamarId}")
    private ResponseEntity<String> updateKamar(
            @PathVariable(value = "kamarId") Long kamarId,
            @RequestBody KamarModel kamar
    ){
        try{
            kamarRestService.changeKamar(kamarId, kamar);
            return ResponseEntity.ok("Update kamar success!");

        }catch(NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"Kamar with ID " + String.valueOf(kamarId)+" Not Found!"
            );
        }
    }
    @GetMapping(value = "/kamar/{kamarId}")
    private KamarModel retrieveKamar(
            @PathVariable("kamarId") Long kamarId
    ){
        try{
            return kamarRestService.getKamarByIdKamar(kamarId);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ID Kamar"+String.valueOf(kamarId)+" Not Found"
            );
        }
    }
    @GetMapping(value = "/kamar-all")
    private List<KamarModel> retrieveListKamar(){
        return kamarRestService.retrieveListKamar();
    }

    @DeleteMapping(value = "/kamar/{kamarId}")
    private ResponseEntity<String> deletekamar(@PathVariable("kamarId") Long kamarId){
        try{
            kamarRestService.deleteKamar(kamarId);
            return ResponseEntity.ok("Kamar with ID " + String.valueOf(kamarId)+ " has been Deleted!");
        }catch(NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Kamar with ID " + String.valueOf(kamarId) + " Not Found!"
            );
        }
    }

}
