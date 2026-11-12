package Extras;
import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

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
        
        
        Element raiz = documento.createElement ("ranking");
        raiz.setAttribute ("nombre", "Top Jugadores");
        documento.appendChild(raiz);

        Element numero = documento.createElement("numero");
        numero.setAttribute("posicion", "1");
        raiz.appendChild(numero);

        Element nombre = documento. createElement ("nombre");
        nombre.setTextContent ("Ana");
        numero.appendChild(nombre);

        Element puntuacion= documento. createElement ("puntuacion");
        nombre.setTextContent ("200");
        numero.appendChild (puntuacion);

     
        TransformerFactory transformerFabrica = TransformerFactory.newInstance();
        Transformer transformer = transformerFabrica.newTransformer();

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

        DOMSource origen = new DOMSource(documento);
        StreamResult destino = new StreamResult(new File("ranking.xml"));
        transformer.transform(origen, destino);
        
        System.out.println ("Fichero XML generado correctamente");

        }
        catch (Exception e)
        {
            System.out.println("Error generado al XML: " + e.getMessage());
        }
       
    }
}
