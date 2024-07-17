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

package it.unicam.cs.mgc.TheClothesProjectConfigurator.configurator;

import it.unicam.cs.mgc.TheClothesProjectConfigurator.controller.Controller;
import it.unicam.cs.mgc.TheClothesProjectConfigurator.model.ControllerOfOntology;

import java.util.Scanner;

public class TheConfigurator {
    private final Scanner scanner;
    private final ControllerOfOntology ontology;
    private final Controller controller;

    public TheConfigurator(Scanner scanner, ControllerOfOntology ontology, Controller controller) {
        this.scanner = scanner;
        this.ontology = ontology;
        this.controller = controller;
    }

    public void startConfiguration() {
        GenderChoicer();
        TargetChoicer();
        String categoryChoised = ClothesCategoyChoicer();
        ClothesList(categoryChoised);
    }

    private void ClothesList(String categoryChoised) {
        ClothesFromCategoy allCLothes = new ClothesFromCategoy(controller,categoryChoised);
        allCLothes.choiser(scanner);
    }

    private String ClothesCategoyChoicer() {
        ClothesCatogoryChoice chooseCategory = new ClothesCatogoryChoice(controller);
        return chooseCategory.choiser(scanner);
    }

    private void TargetChoicer() {
        TargetChoice TargetChoice = new TargetChoice(controller);
        TargetChoice.choiser(scanner);
    }

    private void GenderChoicer() {
        GenderChoice genderChoice = new GenderChoice(controller);
        genderChoice.choiser(scanner);
    }
}
