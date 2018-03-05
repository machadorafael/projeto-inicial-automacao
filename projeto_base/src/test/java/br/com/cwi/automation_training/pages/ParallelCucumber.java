package br.com.cwi.automation_training.pages;

import java.io.IOException;

import org.junit.runners.model.InitializationError;

import com.github.qacore.testingtoolbox.junit.runners.schedulers.ParallelScheduler;

import cucumber.api.junit.Cucumber;

public class ParallelCucumber extends Cucumber {

    public ParallelCucumber(Class clazz) throws InitializationError, IOException {
        super(clazz);

        this.setScheduler(new ParallelScheduler());
    }

}
