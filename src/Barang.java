public class Barang {

    private final String kode;
    private final String merek;
    private final String type;
    private final String ram;
    private final String internal;
    private final String kamera;
    private int harga;

    public Barang(String kode, String merek, String type, String ram, String internal, String kamera, int harga) {
        this.kode = kode;
        this.merek = merek;
        this.type = type;
        this.ram = ram;
        this.internal = internal;
        this.kamera = kamera;
        this.harga = harga;
    }

    public String getKode() {
        return kode;
    }

    public String getMerek() {
        return merek;
    }

    public String getType() {
        return type;
    }

    public String getRam() {
        return ram;
    }

    public String getInternal() {
        return internal;
    }

    public String getKamera() {
        return kamera;
    }

    public int getHarga() {
        return harga;
    }

}
