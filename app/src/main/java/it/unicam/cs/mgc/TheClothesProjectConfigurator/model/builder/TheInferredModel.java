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

package it.unicam.cs.mgc.TheClothesProjectConfigurator.model.builder;

import org.apache.jena.rdf.model.*;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.ValidityReport;

import java.util.concurrent.CompletableFuture;

public class TheInferredModel extends TheMainBuilder{
    /**
     * Creates an inferred model.
     *
     * @param model the input model.
     * @param reasoner the reasoner to use for inference.
     * @return A inferred model.
     */
    public InfModel buildInferredModel(Model model, Reasoner reasoner) {
        reasoner.bindSchema(model);
        return ModelFactory.createInfModel(reasoner, model);
    }

    /**
     * Creates an inferred model asynchronously.
     *
     * @param model    the input model.
     * @param reasoner the reasoner to use for inference
     * @return A CompletableFuture representing the asynchronous operation.
     */
    public CompletableFuture<InfModel> buildInferredModelAsync(Model model, Reasoner reasoner) {
        CompletableFuture<InfModel> future = new CompletableFuture<>();
        Thread thread = new Thread(() -> {
            try {
                reasoner.bindSchema(model);
                InfModel inferredModel = ModelFactory.createInfModel(reasoner, model);
                future.complete(inferredModel);
            } catch (Exception e) {
                future.completeExceptionally(e);
            }
        });
        thread.start();
        return future;
    }

    /**
     * Checks if the model is valid and consistent
     *
     * @return true if it's valid
     */
    public static boolean isModelConsistent(InfModel model) {
        ValidityReport validity = model.validate();
        return validity.isValid();
    }

    /**
     * Checks if the given statement has been correctly inferred on the model
     *
     * @param subject the subject of the statement
     * @param predicate the predicate of the statement
     * @param object the object of the statement
     * @return true if the statement has been inferred
     */
    public static boolean isCorrectlyInferred(Resource subject, Property predicate, Resource object, InfModel model) {
        return model.contains(subject, predicate, object);
    }

}
