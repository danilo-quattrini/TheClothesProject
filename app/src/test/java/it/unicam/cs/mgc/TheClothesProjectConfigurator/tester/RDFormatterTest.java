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
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import it.unicam.cs.mgc.TheClothesProjectConfigurator.model.utilites.FormatRDF;
public class RDFormatterTest {

    @Test
    public void testRemoveUselessTypes() {
        String test = "Thing, colors, clothes, leather, NamedIndividual";
        String result = FormatRDF.removeUselessTypes(test);
        assertEquals("colors, clothes, leather", result);
    }

    @Test
    public void testRemoveURI() {
        String test = "http://www.w3.org/2000/01/rdf-schema#type";
        String result = FormatRDF.removeUriPrefix(test);
        assertEquals("type", result);
    }

    @Test
    public void testCamelCaseToSpacedString() {
        String test = "IsSuitableToBeDressedByTarget";
        String result = FormatRDF.camelCaseToSpacedString(test);
        assertEquals("is suitable to be dressed by target", result);
    }
}
