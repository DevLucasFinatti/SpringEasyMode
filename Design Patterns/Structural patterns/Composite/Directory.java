package composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composto.
 * Representa um diretório que pode conter arquivos e outros diretórios.
 */
public class Directory extends FileSystemComponent {
    private List<FileSystemComponent> children = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    public void add(FileSystemComponent component) {
        children.add(component);
    }

    public void remove(FileSystemComponent component) {
        children.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Diretório: " + name);
        for (FileSystemComponent child : children) {
            child.showDetails();
        }
    }
}
