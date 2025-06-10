package adapter;

/**
 * Adapter.
 * Faz a tradução entre a interface XmlReader e a interface JsonReader.
 */
public class XmlToJsonAdapter implements JsonReader {
    private XmlReader xmlReader;

    public XmlToJsonAdapter(XmlReader xmlReader) {
        this.xmlReader = xmlReader;
    }

    @Override
    public String readJson() {
        // Pega os dados XML do adaptee e converte para JSON (simulado)
        String xml = xmlReader.readXml();
        // Conversão simples só pra exemplo
        String json = xml.replace("<data>", "{ \"data\": \"")
                         .replace("</data>", "\" }");
        return json;
    }
}
