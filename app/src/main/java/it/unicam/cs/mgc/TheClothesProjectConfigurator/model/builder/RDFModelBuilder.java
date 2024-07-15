/*
 * Copyright (c) 2024 Danilo Quattrini
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package it.unicam.cs.mgc.TheClothesProjectConfigurator.model.builder;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.Model;

/**
 * Classes implementing this interface are used to build RDF models.
 */
public interface RDFModelBuilder {

    /**
         * Creates a basic RDF model without any specific inference or ontology support.
         *
         * @return the built model
         */
        Model buildDefaultModel();

        /**
         * Creates a basic RDF model loading from specific files.
         *
         * @param filenames the names of the files
         * @return the built model
         */
        Model buildDefaultModel(String...filenames);

        /**
         * Creates an RDF model that supports ontology reasoning using specified rule-based reasoning and subtyping rules.
         *
         * @param modelSpecification the model specification
         * @return the built model
         */
        Model buildOntologyModel(OntModelSpec modelSpecification);

        /**
         * Creates an RDF model that supports ontology reasoning using specified rule-based reasoning and subtyping rules
         * loading from a specific file.
         *
         * @param modelSpecification the model specification
         * @param filenames the names of the files
         * @return the built model
         */
        Model buildOntologyModel(OntModelSpec modelSpecification, String...filenames);
}
