package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.KamarModel;

import java.util.List;

public interface KamarRestService {
    KamarModel createKamar(KamarModel kamar);
    List<KamarModel> retrieveListKamar();
    KamarModel getKamarByIdKamar(Long idKamar);
    KamarModel changeKamar(Long idKamar, KamarModel kamarUpdate);
    void deleteKamar(Long idKamar);
}
