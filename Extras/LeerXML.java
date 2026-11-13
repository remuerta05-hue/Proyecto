package Extras;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class LeerXML {
    public static void main(String[] args) 
    {
        try
        {
            File archivo = new File ("ranking.xml");
            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();

            fabrica.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);

            DocumentBuilder constructor = fabrica.newDocumentBuilder();

            Document documento = constructor.parse (archivo);

            documento.getDocumentElement().normalize();
            
            NodeList lista = documento.getElementsByTagName ("numero");

            System.out.println ("Total de jugadores: " + lista.getLength());
            for (int i = 0; i < lista.getLength(); i++)
            {
                Element elemento = (Element) lista.item (i);

                String nombre = elemento
                                .getElementsByTagName("nombre")
                                .item(0)
                                .getTextContent();

                String puntuacion = elemento 
                                .getElementsByTagName("puntuacion")
                                .item(0)
                                .getTextContent();

                System.out.println ("-------------------------");

                System.out.println ("Posicion: " + elemento.getAttribute("posicion"));
                System.out.println ( "Nombre: " + nombre);
                System.out.println ( "Puntuacion: " + puntuacion);

                System.out.println ("-------------------------");

            }
            
        }
        catch (Exception e)
        {
            System.out.println("No se pudo leer el XML: " + e.getMessage());
        }   
    }
}
