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

package it.unicam.cs.mgc.TheClothesProjectConfigurator.tester;
import it.unicam.cs.mgc.TheClothesProjectConfigurator.model.SPARQLqueries.SelectDataQueries;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;;

public class SPARQLChecker {
    @Test
    public void testQueryParameterization(){
    String query = SelectDataQueries.SELECT_CLOTHES.getSPARQLQuery("Bra");
    String expectedQuery = "SELECT ?label ?value WHERE { ?clothes rdf:type cp:subClassOf. BIND(?clothes AS ?label) . ?clothes rdfs:label ?value . FILTER(STRSTARTS(?value, \"Bra\")) }";
    assertEquals(expectedQuery, query);
    }
}
