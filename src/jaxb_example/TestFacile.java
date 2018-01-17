package jaxb_example;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class TestFacile {
 private static final String BOOK_XML = "./book-jaxb.xml";

    public static void main(String[] args) throws JAXBException, IOException {

        // create books
        Book book1 = new Book();
        book1.setIsbn("978-0060554736");
        book1.setName("The Game");
        book1.setAuthor("Neil Strauss");
        book1.setPublisher("Harpercollins");

        // create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(Book.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to System.out
        m.marshal(book1, System.out);

        // Write to File
        m.marshal(book1, new File(BOOK_XML));

        // get variables from our xml file, created before
        System.out.println("================================================");
        System.out.println("Output from our XML File: ");
        Unmarshaller um = context.createUnmarshaller();
        Book bookXML = (Book) um.unmarshal(new FileReader(
                BOOK_XML));
        System.out.println("Book: " + bookXML.getName() + " from " + bookXML.getAuthor());
    }    
}
