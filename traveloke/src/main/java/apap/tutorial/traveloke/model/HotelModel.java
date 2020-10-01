package apap.tutorial.traveloke.model;

public class HotelModel {
    public String getIdHotel() {
        return idHotel;
    }

    public HotelModel(String idHotel, String namaHotel, String alamat, String noTelepon) {
        this.idHotel = idHotel;
        this.namaHotel = namaHotel;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
    }

    public void setIdHotel(String idHotel) {
        this.idHotel = idHotel;
    }

    private String idHotel;

    public String getNamaHotel() {
        return namaHotel;
    }

    public void setNamaHotel(String namaHotel) {
        this.namaHotel = namaHotel;
    }

    private String namaHotel;

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    private String alamat;

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    private String noTelepon;
}
