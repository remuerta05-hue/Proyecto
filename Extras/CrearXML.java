package Extras;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CrearXML {
    
    public static void main (String[] args)
    {
        try 
        {
        DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();

        DocumentBuilder constructor = fabrica.newDocumentBuilder();

        Document documento = constructor.newDocument();
        
        Element raiz = documento.createElement ("alumnos");

        }
        catch (Exception e)
        {
            // TODO: handle exception 
        }
       
    }
}
