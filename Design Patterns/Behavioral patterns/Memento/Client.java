package memento;

/**
 * Cliente que usa o Editor e History para salvar e restaurar estados.
 */
public class Client {
    public static void main(String[] args) {
        Editor editor = new Editor();
        History history = new History();

        editor.setContent("Estado 1");
        history.push(editor.save());

        editor.setContent("Estado 2");
        history.push(editor.save());

        editor.setContent("Estado 3");
        System.out.println("Conteúdo atual: " + editor.getContent());

        // Desfazer uma vez
        editor.restore(history.pop());
        System.out.println("Depois do undo 1: " + editor.getContent());

        // Desfazer outra vez
        editor.restore(history.pop());
        System.out.println("Depois do undo 2: " + editor.getContent());
    }
}
