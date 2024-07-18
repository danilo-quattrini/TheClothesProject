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

import it.unicam.cs.mgc.TheClothesProjectConfigurator.configurator.choiser.*;
import it.unicam.cs.mgc.TheClothesProjectConfigurator.controller.Controller;

import java.util.Scanner;
/**
 * Configurator for selecting and finalizing clothing options.
 * <p>
 * This class provides an interactive configuration process where the user selects various clothing
 * attributes such as target audience, category, type of clothing, color, material, and size.
 * After the configuration is complete, the final selection is displayed.
 * </p>
 */
public class TheConfigurator {
    private final Scanner scanner;
    private final Controller controller;
    private final FinalClothes completedClothes;

    public TheConfigurator(Scanner scanner,  Controller controller) {
        this.scanner = scanner;
        this.controller = controller;
        this.completedClothes = new FinalClothes();
    }

    /**
     * Starts the configuration process by prompting the user to make selections for each clothing attribute.
     * Once all selections are made, the final configuration is displayed.
     */
    public void startConfiguration() {
        completedClothes.setTarget(TargetChoicer());
        completedClothes.setCategory(ClothesCategoyChoicer());
        completedClothes.setClothes(ClothesList(completedClothes.getCategory()));
        completedClothes.setColor(ColorList());
        completedClothes.setMaterial(MaterialCategoryChoicer());
        completedClothes.setSize(SizeListOfCategoy(completedClothes.getCategory()));
        showFinalConfiguration();
    }
    /**
     * Prompts the user to select a size from the available options based on the specified category.
     *
     * @param categoryChoised the selected category used to filter the size options.
     * @return the chosen size as a {@link String}.
     */
    private String SizeListOfCategoy(String categoryChoised) {
        CategorySizeChoser allCategorySizes = new CategorySizeChoser(controller,categoryChoised);
        return allCategorySizes.choiser(scanner);
    }
    /**
     * Prompts the user to select a material category.
     *
     * @return the chosen material category as a {@link String}.
     */
    private String MaterialCategoryChoicer() {
        MaterialChoiser allCategoy = new MaterialChoiser(controller);
        return allCategoy.choiser(scanner);
    }
    /**
     * Prompts the user to select a color from the available options.
     *
     * @return the chosen color as a {@link String}.
     */
    private String ColorList() {
        ColorChoice allColor = new ColorChoice(controller);
        return allColor.choiser(scanner);
    }
    /**
     * Prompts the user to select a type of clothing from the available options based on the specified category.
     *
     * @param categoryChoised the selected category used to filter the clothing options.
     * @return the chosen type of clothing as a {@link String}.
     */
    private String ClothesList(String categoryChoised) {
        ClothesFromCategory allCLothes = new ClothesFromCategory(controller,categoryChoised);
        return allCLothes.choiser(scanner);
    }

    /**
     * Prompts the user to select a clothing category.
     *
     * @return the chosen clothing category as a {@link String}.
     */
    private String ClothesCategoyChoicer() {
        ClothesCatogoryChoice chooseCategory = new ClothesCatogoryChoice(controller);
        return chooseCategory.choiser(scanner);
    }
    /**
     * Prompts the user to select a target audience for the clothing.
     *
     * @return the chosen target audience as a {@link String}.
     */
    private String TargetChoicer() {
        TargetChoice TargetChoice = new TargetChoice(controller);
        return TargetChoice.choiser(scanner);
    }
    /**
     * Displays the final configuration of the selected clothing options.
     * The configuration includes all attributes set during the configuration process.
     */
    private void showFinalConfiguration() {
        System.out.println("Final Configuration:");
        System.out.println(completedClothes);
    }

}
