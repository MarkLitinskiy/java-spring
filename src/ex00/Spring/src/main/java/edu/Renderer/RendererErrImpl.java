package edu.Renderer;

import edu.PreProcessor.PreProcessor;

public class RendererErrImpl implements Renderer{

    PreProcessor preProcessor;

    public RendererErrImpl(PreProcessor preProcessor){
        this.preProcessor = preProcessor;
    }

    public void render(String str){
        System.err.println(preProcessor.reRegistLetters(str));
    }
}
