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

package it.unicam.cs.mgc.TheClothesProjectConfigurator.configurator.choiser;

import java.util.Collection;
import java.util.Scanner;
/**
 * The choiser interface is used to inizialize the scanner and return the choised
 * */
public interface ChoiserInCase {
    /**
     * Prompts the user to make a choice from a list of options provided by {@link #SubjecList()}.
     *
     * @param scanner the {@link Scanner} object used to read the user's input.
     * @return the user's choice as a {@link String}.
     */
    String choiser(Scanner scanner);
    /**
     * Retrieves a collection of subjects/options to be presented to the user for making a choice.
     *
     * @return a {@link Collection} of {@link String} representing the available choices.
     */
    Collection<String> SubjecList();
}
