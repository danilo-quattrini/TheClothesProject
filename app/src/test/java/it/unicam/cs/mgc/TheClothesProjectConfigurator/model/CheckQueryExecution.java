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
import it.unicam.cs.mgc.TheClothesProjectConfigurator.model.SPARQLqueries.SelectDataQueries;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

public class CheckQueryExecution {

    private  ControllerOfOntology ontology;

   @BeforeEach
    @Test
   public void setUp() {
        ontology = new ControllerOfOntology();
        assertNotNull(ontology);
    }

    @Test
    public void queryAllClothes() {
        ParsedData data = ontology.get(SelectDataQueries.NATURAL_LIST);
        Collection<String> clothes = data.getAllValues();
        assertEquals(8, clothes.size());
    }

    @Test
    public void querySearchedClothes() {
        ParsedData data = ontology.get(SelectDataQueries.SELECT_CLOTHES, "Hand");
        Collection<String> clothes = data.getAllValues();
        assertEquals(1, clothes.size());
    }

    @Test
    public void queryClothesDetails() {
        ParsedData data = ontology.get(SelectDataQueries.COLOR_LIST_WITH_HEX, "Black");
        assertFalse(data.getAllValues().isEmpty());
    }

   }
