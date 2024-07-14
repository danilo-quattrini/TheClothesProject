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

package it.unicam.cs.mgc.TheClothesProjectConfigurator.utilites;
/**
 * Enumerations implementing this interface are used to represent and group SPARQL queries
 */
public interface SPARQLqueries {

    /**
     * Return the query that we are going to use
     * @return the SPARQL query as a string
     */
    String getSPARQLQuery();

    /**
     * Returns a formatted SPARQL query with the specified arguments.
     * @param args Arguments referenced by the format specifiers in the format string.
     * @return a formatted string containing the SPARQL query
     */
    String getSPARQLQuery(Object... args);

    default String getCompleteQuery() {
        return getPrefixes() + this.getSPARQLQuery();
    }

    default String getCompleteQuery(Object...args) {
        return getPrefixes() + this.getSPARQLQuery(args);
    }

    /**
     * Get the SPARQL prefixes necessary for queries
     * @return a string containing SPARQL prefixes
     */
    static String getPrefixes() {
        return """
                PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>
                PREFIX owl: <http://www.w3.org/2002/07/owl#>
                PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
                PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>    
                PREFIX cp: <https://www.unicam.it/cs/daniloquattrini/TheClothesProject#>
                PREFIX dbo: <http://dbpedia.org/ontology/>
                """;
    }

}
