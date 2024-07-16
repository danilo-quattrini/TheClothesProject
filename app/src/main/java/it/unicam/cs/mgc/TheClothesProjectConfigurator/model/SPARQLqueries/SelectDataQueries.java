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

package it.unicam.cs.mgc.TheClothesProjectConfigurator.model.SPARQLqueries;

public enum SelectDataQueries implements SPARQLqueries {

    COLOR_LIST_WITH_HEX("SELECT ?individual ?value WHERE {  ?individual rdf:type cp:Colour. ?individual cp:hasColorHex ?value   FILTER (isLiteral(?value))}"),
    GENDER_LIST("SELECT DISTINCT ?gender WHERE { ?individual rdf:type cp:Gender .}"),
    TARGET_LIST("SELECT DISTINCT ?target WHERE { ?target rdfs:subClassOf cp:Target }"),
    EVENT_LIST("SELECT DISTINCT ?events WHERE { ?events rdfs:subClassOf cp:Event }"),
    PATTERN_LIST("SELECT DISTINCT ?patterns ?thumbnails WHERE { ?patterns rdf:type cp:Pattern. ?patterns dbo:thumbnail ?thumbnail}"),
    UPPER_SIZES("SELECT DISTINCT ?uppersizes  WHERE { ?uppersizes rdf:type cp:UpperClothingSize}"),
    LOWER_SIZES("SELECT DISTINCT ?lowersizes  WHERE { ?lowersizes rdf:type cp:LowerSize}"),
    SHOES_SIZES("SELECT DISTINCT ?shoesize  WHERE { ?shoesize rdf:type cp:ShoeSize}"),
    ACCESORY_SIZES("SELECT DISTINCT ?accessoysize  WHERE { ?accessoysize rdf:type cp:AccessorySize}"),
    CLOTHES_LIST("SELECT ?clothes  WHERE { ?clothes rdfs:subClassOf cp:Clothes} "),
    SYNTHETIC_LIST("SELECT ?synthetic  WHERE { ?synthetic rdf:type cp:SyntheticClothesMaterial} "),
    NATURAL_LIST("SELECT ?natural  WHERE { ?natural rdf:type cp:NaturalClothesMaterial} "),
    SEASON_LIST("SELECT ?season WHERE { ?season rdf:type cp:Season }"),
    SELECT_CLOTHES("SELECT ?label ?value WHERE { (?clothes) rdfs:subClassOf cp:Clothes. BIND(?clothes AS ?label) . ?clothes rdfs:label ?value . FILTER(STRSTARTS(?value, \"%s\")) }"),
    SELECT_MATERIAL_NATURAL("SELECT ?label ?value WHERE { ?naturalmaterial rdf:type cp:NaturalClothesMaterial. BIND(?naturalmaterial AS ?label) . ?naturalmaterial rdfs:label ?value . FILTER(STRSTARTS(?value, \"%s\")) }");
    private final String sparqlQuery;

    SelectDataQueries(String sparqlQuery){
        this.sparqlQuery = sparqlQuery;
    };

    @Override
    public String getSPARQLQuery() {
        return sparqlQuery;
    }

    @Override
    public String getSPARQLQuery(Object... args) {
        return String.format(this.sparqlQuery, args);
    }

}
