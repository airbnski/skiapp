package airbnski.resort.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Media {

    private Image original;
    private Image image;
    private Image[] sizes;

    public Image getOriginal() {
        return original;
    }

    public void setOriginal(Image original) {
        this.original = original;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image[] getSizes() {
        return sizes;
    }

    public void setSizes(Image[] sizes) {
        this.sizes = sizes;
    }

}
