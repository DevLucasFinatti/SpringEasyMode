package proxy;

/**
 * Proxy que controla o acesso ao RealImage.
 * Faz carregamento lazy da imagem.
 */
public class ImageProxy implements Image {
    private RealImage realImage;
    private String filename;

    public ImageProxy(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}
