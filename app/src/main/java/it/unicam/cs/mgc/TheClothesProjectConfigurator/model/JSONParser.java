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
import it.unicam.cs.mgc.TheClothesProjectConfigurator.model.utilites.FormatRDF;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDFS;

import java.util.HashMap;
import java.util.Map;

public class JSONParser implements TheDataParser{

    private final Map<String, String> data = new HashMap<>();

    @Override
    public ParsedData parse(QueryExecution queryExecution) {
        ResultSet results = queryExecution.execSelect();
        while(results.hasNext()) {
            QuerySolution result = results.nextSolution();
            String label = this.parseNodeToString(result.get("label"));
            String value = this.parseNodeToString(result.get("value"));
            // Concatenates multiple values of the same property
            if(data.containsKey(label)) {
                data.put(label, data.get(label) + ", " + value);
            } else {
                data.put(label, value);
            }
        }
        return new JSONData(data);

    }

    /**
     * Parse an RDF node to a string.
     *
     * @param node the RDF node to parse
     * @return a string representing the node. An empty string if the node is null or nor a resource or a literal
     */
    private String parseNodeToString(RDFNode node) {
        if(node == null) return "";
        if(node.isResource()) {
            return this.getNodeLabel(node.asResource());
        } else {
            return node.asLiteral().getString();
        }

    }

    /**
     * Returns the RDF label of a resource node. If the resource does not have a label, returns
     * the name of the resource extracted from its URI.
     *
     * @param resource the resource node
     * @return the RDF label representation as a string
     */
    private String getNodeLabel(Resource resource) {
        if(resource.getProperty(RDFS.label) == null) {
            return FormatRDF.removeUriPrefix(resource.getURI());
        } else {
            return resource.getProperty(RDFS.label).getString();
        }
    }
}
