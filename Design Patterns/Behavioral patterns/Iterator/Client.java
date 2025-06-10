package iterator;

/**
 * Cliente que usa o iterator para percorrer a coleção sem expor sua estrutura interna.
 */
public class Client {
    public static void main(String[] args) {
        NumberCollection collection = new NumberCollection();
        collection.add(10);
        collection.add(20);
        collection.add(30);

        Iterator<Integer> iterator = collection.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
