package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.KamarModel;

import java.util.List;

public interface KamarService{
    void addKamar(KamarModel kamar);

    List<KamarModel> findAllKamarByIdHotel(Long idHotel);

    KamarModel getKamarById(Long nomorKamar);

    KamarModel kamarUpdate(KamarModel kamar);

    KamarModel deleteKamar(Long nomorKamar);

    Integer getSizeList(Long idHotel);

}
