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

import it.unicam.cs.mgc.TheClothesProjectConfigurator.controller.Controller;
import it.unicam.cs.mgc.TheClothesProjectConfigurator.model.ParsedData;

import java.util.Collection;
import java.util.Scanner;

public class ClothesFromCategory implements ChoiserInCase {
    private final Controller controller;
    private final String category;

    public ClothesFromCategory(Controller controller, String Categoy) {
        this.controller = controller;
        this.category =  Categoy;
    }
    @Override
    public String choiser(Scanner scanner) {
        String TheChoice = "";
        System.out.println("Choose now the specific clothes:");
        Collection<String> ClothesList = SubjecList();
        boolean validChoice = false;
        while (!validChoice) {
            int index = 1;
            for (String clothes : ClothesList) System.out.println(index++ + ". " + clothes);
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice > 0 && choice <= ClothesList.size()) {
                TheChoice = ClothesList.toArray(new String[0])[choice - 1];
                System.out.println("Hai scelto: " + TheChoice);
                validChoice = true;
            } else System.out.println("Invalid choice. Please try again.");

        }
        return TheChoice;
    }

    @Override
    public Collection<String> SubjecList() {
        ParsedData data = controller.getClothesFromCategory(category);
        return data.getAllValues();
    }
}
