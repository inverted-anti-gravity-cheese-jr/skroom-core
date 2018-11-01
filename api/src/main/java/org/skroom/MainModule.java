package org.skroom;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import org.skroom.auth.TokenGeneratorService;

/**
 * MainModule
 */
public class MainModule extends AbstractModule {

    private static final Logger LOG = Logger.getLogger(MainModule.class.getName());

    private static final String MAIN_PROPERTIES_FILE = "skroom.properties";

    @Override
    protected void configure() {
        // load from jar
        Properties jarProperties = new Properties();
        try (var fis = getClass().getResourceAsStream("/" + MAIN_PROPERTIES_FILE)) {
            if (fis != null) {
                jarProperties.load(fis);
            }
        } catch (IOException ioe) {
            LOG.log(Level.SEVERE, "Could not load \"" + MAIN_PROPERTIES_FILE + "\" file from JAR ", ioe);
        }

        // load from disk
        Properties diskProperties = new Properties();
        if (Files.exists(Paths.get(MAIN_PROPERTIES_FILE))) {
            try (var fis = new FileInputStream(MAIN_PROPERTIES_FILE)) {
                if (fis != null) {
                    diskProperties.load(fis);
                }
            } catch (IOException ioe) {
                LOG.log(Level.SEVERE, "Could not load \"" + MAIN_PROPERTIES_FILE + "\" file ", ioe);
            }
        }

        Properties properties = new Properties();
        properties.putAll(jarProperties);
        properties.putAll(diskProperties);
        Names.bindProperties(binder(), properties);

        bind(TokenGeneratorService.class);

    }
    
}