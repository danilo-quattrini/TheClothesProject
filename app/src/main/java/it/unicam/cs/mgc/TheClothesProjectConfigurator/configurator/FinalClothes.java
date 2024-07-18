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

public class FinalClothes {
    private String target;
    private String category;
    private String clothes;
    private String color;
    private String material;
    private String size;

    // Getter e setter per ogni campo
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getClothes() {
        return clothes;
    }

    public void setClothes(String clothes) {
        this.clothes = clothes;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        StringBuilder sb = new StringBuilder();
        sb.append("+------------------------------------------+\n");
        sb.append("|            Final Configuration           |\n");
        sb.append("+------------------------------------------+\n");
        sb.append("| Target:      ").append(padRight(target, 30)).append("|\n");
        sb.append("| Category:    ").append(padRight(category, 30)).append("|\n");
        sb.append("| Clothes:     ").append(padRight(clothes, 30)).append("|\n");
        sb.append("| Color:       ").append(padRight(color, 30)).append("|\n");
        sb.append("| Material:    ").append(padRight(material, 30)).append("|\n");
        sb.append("| Size:        ").append(padRight(size, 30)).append("|\n");
        sb.append("+------------------------------------------+\n");
        return sb.toString();
    }

    private String padRight(String s, int n) {
        return s == null ? "" : String.format("%1$-" + n + "s", s);
    }
}
