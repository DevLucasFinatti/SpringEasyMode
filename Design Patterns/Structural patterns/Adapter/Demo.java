package adapter;

/**
 * Cliente.
 * Usa a interface JsonReader, mas adaptando o XmlReader.
 */
public class Demo {
    public static void main(String[] args) {
        XmlReader xmlReader = new XmlReader();
        JsonReader adapter = new XmlToJsonAdapter(xmlReader);

        System.out.println("JSON recebido via adapter:");
        System.out.println(adapter.readJson());
    }
}
