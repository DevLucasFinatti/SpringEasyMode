package composite;

/**
 * Componente abstrato.
 * Define a interface comum para arquivos e diretórios.
 */
public abstract class FileSystemComponent {
    protected String name;

    public FileSystemComponent(String name) {
        this.name = name;
    }

    public abstract void showDetails();
}
