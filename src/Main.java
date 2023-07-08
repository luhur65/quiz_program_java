import javax.swing.JOptionPane;
import java.text.NumberFormat;
import java.util.Locale;

public class Main {

    private static final Barang[] barangArray = new Barang[14];
    protected static String Information, keterangan;
    protected static Integer index;
    protected static Integer jumlah;
    protected static Integer total;
    protected static Integer bayar;
    protected static Integer kembalian;
    protected static double diskon;
    protected static Integer totalDiskon;
    protected static Integer totalBayar;
    protected static boolean kodeBenar = false;

    // Method to format number to currency
    public static String formatNumber(int number) {
        return NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(number);
    }

    // Method to store product data
    public static void StoreProduct() {

        // Merek Samsung Galaxy
        barangArray[0] = new Barang("MSR-S01", "Samsung Galaxy", "S20", "8GB", "128GB", "64MP", 9585000);
        barangArray[1] = new Barang("MSR-S02", "Samsung Galaxy", "S10+", "6GB", "128GB", "48MP", 7900000);
        barangArray[2] = new Barang("MSR-S03", "Samsung Galaxy", "S20+", "16GB", "128GB", "64MP", 10900000);
        barangArray[3] = new Barang("MSR-S04", "Samsung Galaxy", "Note10 Lite", "6GB", "128GB", "32MP", 7999000);
        barangArray[4] = new Barang("MSR-S05", "Samsung Galaxy", "Z Flip", "16GB", "256GB", "24MP", 19999000);

        // Merek Oppo
        barangArray[5] = new Barang("SMR-O01", "Oppo", "A12s", "3GB", "32GB", "15MP", 2300000);
        barangArray[6] = new Barang("SMR-O02", "Oppo", "A92", "8GB", "128GB", "48MP", 2999000);
        barangArray[7] = new Barang("SMR-O03", "Oppo", "A52", "4GB", "63GB", "12MP", 3665000);
        barangArray[8] = new Barang("SMR-O04", "Oppo", "Reno3 Pro", "8GB", "128GB", "64MP", 6999000);
        barangArray[9] = new Barang("SMR-O05", "Oppo", "Fin X2 Pro", "12GB", "256GB", "48MP", 16500000);

        // Merek Apple
        barangArray[10] = new Barang("SMR-A01", "Apple", "iPhone 7", "2GB", "32GB", "12MP", 2750000);
        barangArray[11] = new Barang("SMR-A02", "Apple", "iPhone 7 Plus", "3GB", "128GB", "12MP", 4700000);
        barangArray[12] = new Barang("SMR-A03", "Apple", "iPhone 5", "1GB", "16GB", "8MP", 1600000);
        barangArray[13] = new Barang("SMR-A04", "Apple", "iPhone 5s", "0GB", "32GB", "8MP", 2800000);

    }

    public static void main(String[] args) {

        // Initialize barangArray
        StoreProduct();

        // get input from user
        String input = JOptionPane.showInputDialog("Masukkan Kode Barang", "MSR-S01");

        // if user click cancel button, exit the program
        if (input == null) {
            System.exit(0);
        }

        // search for the inputted kode in barangArray
        index = 0;
        for (int i = 0; i < barangArray.length; i++) {

            // if inputted kode is found, set index to the index of the barang in barangArray
            if (input.equalsIgnoreCase(barangArray[i].getKode())) {
                index = i;
                kodeBenar = true;
                break;
            }

        }

        // if inputted kode is not found, restart the program
        if (!kodeBenar) {
            JOptionPane.showMessageDialog(null, "Kode Barang Tidak Ditemukan");
            main(args);
        }

        // set Information to the information about the selected barang
        Information = "Kode produk: " + barangArray[index].getKode() + "\n"
                + "Merek: " + barangArray[index].getMerek() + "\n"
                + "Type: " + barangArray[index].getType() + "\n"
                + "RAM: " + barangArray[index].getRam() + "\n"
                + "Internal: " + barangArray[index].getInternal() + "\n"
                + "Kamera: " + barangArray[index].getKamera() + "\n"
                + "Harga: " + formatNumber(barangArray[index].getHarga()) + "\n\n Apakah Anda Ingin Membeli Barang Ini?";

        // confirm if user want to buy the selected barang
        int confirm = JOptionPane.showConfirmDialog(null, Information, "Konfirmasi", JOptionPane.YES_NO_OPTION);

        // if user click no button, exit the program
        if (confirm == JOptionPane.NO_OPTION) {
            // restart the program
            main(args);

        } else {
            // if user click yes button, get input for jumlah barang
            String input2 = JOptionPane.showInputDialog("Masukkan Jumlah Barang", "1");
            jumlah = Integer.parseInt(input2);

            // calculate total harga
            total = barangArray[index].getHarga() * jumlah;

            // if total harga is more than 15000000, set diskon to 8%,
            // if total harga is more than 20000000, set diskon to 10%,
            if (total > 20000000) {
                diskon = 0.1;
            } else if (total > 15000000) {
                diskon = 0.08;
            } else {
                diskon = 0.0;
            }

            // calculate total diskon
            totalDiskon = (int) (total * diskon);
            totalBayar = total - totalDiskon;

            // get input for jumlah uang yang dibayarkan
            Information = "Total Harga: " + formatNumber(total) + "\n"
                    + "Diskon: " + formatNumber(totalDiskon) + "\n"
                    + "Total Bayar: " + formatNumber(totalBayar) + "\n\n"
                    + "Masukkan Jumlah Uang Yang Dibayarkan";
            String input3 = JOptionPane.showInputDialog(Information);
            bayar = Integer.parseInt(input3);

            // calculate kembalian
            kembalian = bayar - totalBayar;

            // set keterangan to the information about the transaction
            if (bayar >= totalBayar) {
                keterangan = "Lunas";
            } else {
                keterangan = "Belum Lunas";
            }

            // show the information about the transaction to the user in a message dialog box
            JOptionPane.showMessageDialog(null, "Kode Produk: " + barangArray[index].getKode() + "\n"
                    + "Merek: " + barangArray[index].getMerek() + "\n"
                    + "Type: " + barangArray[index].getType() + "\n"
                    + "RAM: " + barangArray[index].getRam() + "\n"
                    + "Internal: " + barangArray[index].getInternal() + "\n"
                    + "Kamera: " + barangArray[index].getKamera() + "\n"
                    + "Harga: " + formatNumber(barangArray[index].getHarga()) + "\n"
                    + "Jumlah: " + jumlah + "\n"
                    + "Total: " + formatNumber(total) + "\n"
                    + "Diskon: " + formatNumber(totalDiskon) + "\n"
                    + "Total Bayar: " + formatNumber(totalBayar) + "\n"
                    + "Bayar: " + formatNumber(bayar) + "\n"
                    + "Kembalian: " + formatNumber(kembalian) + "\n"
                    + "Keterangan: " + keterangan);

            // ask user if they want to buy another barang
            int confirm2 = JOptionPane.showConfirmDialog(null, "Apakah Anda Ingin Membeli Barang Lain?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

            // if user click no button, exit the program
            if (confirm2 == JOptionPane.NO_OPTION) {
                System.exit(0);
            } else {
                // restart the program
                main(args);
            }

        }

    }
}
