package org.skroom;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

import org.skroom.controller.AccountsController;
import org.skroom.controller.ControllersModule;

import ro.pippo.controller.ControllerApplication;
import ro.pippo.core.Pippo;

/**
 * Application
 */
public class Application extends ControllerApplication {
    
    private Injector injector;
    
    @Override
    protected void onInit() {
        
        addControllers(injector.getInstance(AccountsController.class));

        ANY("/.*", context -> {
            System.out.println("Hello filter");
            context.next();
            
        });
    }
    
    public static void main(String[] args) {
        var app = new Application();
        app.injector = Guice.createInjector(
            new MainModule(),
            new ControllersModule());

        var pippo = new Pippo(app);
        String port = app.injector.getInstance(Key.get(String.class, Names.named("org.skroom.application.port")));
        if (port != null) {
            pippo.getServer().setPort(Integer.parseInt(port));
        }
        pippo.start();
    }
    
}