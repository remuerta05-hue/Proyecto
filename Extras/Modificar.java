package Extras;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Modificar {
    public static void main(String[] args) 
    {
        try {
            File archivo = new File("ranking.xml");
            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            fabrica.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);

            DocumentBuilder constructor = fabrica.newDocumentBuilder();
            Document documento = constructor.parse(archivo);
            documento.getDocumentElement().normalize();

            NodeList lista = documento.getElementsByTagName("numero");
            boolean encontrado = false;
            for (int i=0; i< lista.getLength()&& !encontrado;i++)
            {
                Element numero = (Element) lista.item(i);

                if (numero.getAttribute("posicion").equals("1"))
                {
                    Element puntuacion = (Element) numero.getElementsByTagName("puntuacion").item(0);

                    puntuacion.setTextContent("250");
                    encontrado = true;
                    break;
                }

            }
            TransformerFactory transformerFabrica = TransformerFactory.newInstance();
        Transformer transformer = transformerFabrica.newTransformer();

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

        DOMSource origen = new DOMSource(documento);
        StreamResult destino = new StreamResult(new File("ranking.xml"));
        transformer.transform(origen, destino);
        
        System.out.println ("Fichero XML modificado correctamente");

            
        } 
        catch (Exception e) 
        {
            System.out.println("Error al modificar el XML: " + e.getMessage());
    }
}
