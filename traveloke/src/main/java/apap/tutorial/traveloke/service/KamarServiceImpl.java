package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.repository.KamarDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class KamarServiceImpl implements KamarService{

    @Autowired
    KamarDb kamarDb;

    @Override
    public void addKamar(KamarModel kamar){
        kamarDb.save(kamar);
    }

    @Override
    public List<KamarModel> findAllKamarByIdHotel(Long idHotel){
        return kamarDb.findByHotelId(idHotel);
    }

    @Override
    public KamarModel getKamarById(Long nomorKamar){
        return kamarDb.findById(nomorKamar).get();
    }

    @Override
    public KamarModel kamarUpdate(KamarModel kamar){
        KamarModel targetKamar = kamarDb.findById(kamar.getNoKamar()).get();
        try {
            targetKamar.setNamaKamar(kamar.getNamaKamar());
            targetKamar.setKapasitasKamar(kamar.getKapasitasKamar());
            targetKamar.setTipe(kamar.getTipe());
            kamarDb.save(targetKamar);
            return targetKamar;
        } catch (NullPointerException nullException){
            return null;
        }
    }
    @Override
    public KamarModel deleteKamar(Long nomorKamar){
        KamarModel var = kamarDb.findById(nomorKamar).get();
        kamarDb.deleteById(nomorKamar);
        return var;
    }
    @Override
    public Integer getSizeList(Long idHotel){
        return kamarDb.findByHotelId(idHotel).size();
    }
}
