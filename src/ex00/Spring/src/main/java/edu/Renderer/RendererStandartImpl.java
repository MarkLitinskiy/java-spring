package edu.Renderer;

import edu.PreProcessor.PreProcessor;

public class RendererStandartImpl implements Renderer{
    PreProcessor preProcessor;

    public RendererStandartImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void render(String str) {
        System.out.println(preProcessor.reRegistLetters(str));
    }
}
