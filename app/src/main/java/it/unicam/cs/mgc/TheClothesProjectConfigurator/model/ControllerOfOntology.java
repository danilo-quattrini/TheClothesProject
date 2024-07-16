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

package it.unicam.cs.mgc.TheClothesProjectConfigurator.model;

import it.unicam.cs.mgc.TheClothesProjectConfigurator.model.builder.TheInferredModel;
import it.unicam.cs.mgc.TheClothesProjectConfigurator.model.SPARQLqueries.QueryExecutor;
import it.unicam.cs.mgc.TheClothesProjectConfigurator.model.SPARQLqueries.SelectDataQueries;
import it.unicam.cs.mgc.TheClothesProjectConfigurator.model.utilites.AllTheURI;
import openllet.jena.PelletReasonerFactory;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.rdf.model.*;

/**
 * This class is used to manage the underlying app ontology.
 */
public class ControllerOfOntology {

        private Model model;
        private final TheInferredModel modelBuilder = new TheInferredModel();
        private final QueryExecutor queryExecutor = new QueryExecutor();

        public ControllerOfOntology() {
            this.model = modelBuilder.buildOntologyModel(OntModelSpec.OWL_DL_MEM, AllTheURI.LOCAL.getURI());
            this.startInference();
        }

        /**
         * Starts inference on the RDF model replacing it with a new inferred model.
         */
        public void startInference() {
            this.model = modelBuilder.buildInferredModel(model, PelletReasonerFactory.THE_SPEC.getReasoner());
        }

        /**
         * Gets data from the ontology model.
         *
         * @param query the data
         * @return the data chunk result of the query
         */
        public ParsedData get(SelectDataQueries query) {
            JSONParser parser = new JSONParser();
            QueryExecution queryExecution = queryExecutor.perform(query, this.model);
            return parser.parse(queryExecution);
        }

        /**
         * Gets data from the ontology model passing some arguments.
         *
         * @param query the data
         * @param args the parameter for the query
         * @return the data chunk result of the query
         */

        public ParsedData get(SelectDataQueries query, Object...args) {
            JSONParser parser = new JSONParser();
            QueryExecution queryExecution = queryExecutor.perform(query, this.model, args);
            return parser.parse(queryExecution);
        }

        /**
         * Checks if the built inferred model is consistent.
         *
         * @return true if the model is consistent
         */

        public boolean isConsistent() {
            if(this.model instanceof InfModel) {
                return TheInferredModel.isModelConsistent((InfModel) model);
            }
            return false;
        }


}
