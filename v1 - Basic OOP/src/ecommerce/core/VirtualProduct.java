package ecommerce.core;


public class VirtualProduct extends Product {
    private String downloadURL;

    public VirtualProduct(String id, float price, String name, String brand, String downloadURL){
        super(id, price, name, brand);
        this.downloadURL = downloadURL;
    }


    public void setDownloadURL(String downloadURL) {
        this.downloadURL = downloadURL;
    }

    public String getDownloadURL() {
        return downloadURL;
    }

    public String forDisplay(){
        return super.forDisplay() + " | Download here: " + downloadURL;
    }
}
