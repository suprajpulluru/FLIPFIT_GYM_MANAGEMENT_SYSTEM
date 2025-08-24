package com.flipfit.rest;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import com.flipfit.rest.*;
import com.flipfit.business.*;

public class App extends Application<FlipFitConfiguration> {

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public void run(FlipFitConfiguration configuration, Environment environment) {
        // Here, you will register all your new REST controllers.
        // This tells DropWizard which classes contain your API endpoints.
        environment.jersey().register(new FlipFitAdminRestController());
        environment.jersey().register(new FlipFitCustomerRestController());
        environment.jersey().register(new FlipFitGymOwnerRestController());
        environment.jersey().register(new FlipFitUserRestController());
    }
}
