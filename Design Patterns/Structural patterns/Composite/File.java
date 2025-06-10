package composite;

/**
 * Folha.
 * Representa um arquivo.
 */
public class File extends FileSystemComponent {

    public File(String name) {
        super(name);
    }

    @Override
    public void showDetails() {
        System.out.println("Arquivo: " + name);
    }
}
