package proxy;

/**
 * Objeto real que representa uma imagem pesada.
 */
public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Carregando imagem do disco: " + filename);
        // Simula carga pesada
    }

    @Override
    public void display() {
        System.out.println("Mostrando imagem: " + filename);
    }
}
