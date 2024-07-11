import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.ModelFactory;

public class Main {
    static OntModel MyOntology = ModelFactory.createOntologyModel();
    public static void main(String[] args) {
        MyOntology.read("../../../TheClothesProject.owx");
        System.out.println("Hello World!");
    }
}
