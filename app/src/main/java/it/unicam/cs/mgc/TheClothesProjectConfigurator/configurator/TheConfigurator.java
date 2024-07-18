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

import java.util.Scanner;

public class TheConfigurator {
    private final Scanner scanner;
    private final Controller controller;
    private final FinalClothes completedClothes;
    public TheConfigurator(Scanner scanner,  Controller controller) {
        this.scanner = scanner;
        this.controller = controller;
        this.completedClothes = new FinalClothes();
    }

    public void startConfiguration() {
        completedClothes.setTarget(TargetChoicer());
        completedClothes.setCategory(ClothesCategoyChoicer());
        completedClothes.setClothes(ClothesList(completedClothes.getCategory()));
        completedClothes.setColor(ColorList());
        completedClothes.setMaterial(MaterialCategoryChoicer());
        completedClothes.setSize(SizeListOfCategoy(completedClothes.getCategory()));
        showFinalConfiguration();
    }

    private String SizeListOfCategoy(String categoryChoised) {
        CategorySizeChoser allCategorySizes = new CategorySizeChoser(controller,categoryChoised);
        return allCategorySizes.choiser(scanner);
    }

    private String MaterialCategoryChoicer() {
        MaterialChoiser allCategoy = new MaterialChoiser(controller);
        return allCategoy.choiser(scanner);
    }

    private String ColorList() {
        ColorChoice allColor = new ColorChoice(controller);
        return allColor.choiser(scanner);
    }

    private String ClothesList(String categoryChoised) {
        ClothesFromCategory allCLothes = new ClothesFromCategory(controller,categoryChoised);
        return allCLothes.choiser(scanner);
    }

    private String ClothesCategoyChoicer() {
        ClothesCatogoryChoice chooseCategory = new ClothesCatogoryChoice(controller);
        return chooseCategory.choiser(scanner);
    }

    private String TargetChoicer() {
        TargetChoice TargetChoice = new TargetChoice(controller);
        return TargetChoice.choiser(scanner);
    }

    private void showFinalConfiguration() {
        System.out.println("Final Configuration:");
        System.out.println(completedClothes);
    }

}
