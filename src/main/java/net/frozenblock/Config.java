package net.frozenblock;

import com.dinocrew.dinocraft.Dinocraft;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class Config {

    public static void createConfig() {

        try(OutputStream output = new FileOutputStream(String.valueOf(Dinocraft.CONFIG_PATH))) {
            Properties prop = new Properties();
            prop.setProperty("naturally_generate_mobs", "true");
            prop.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public static Object getConfig(String property) {
        if(!Files.exists(Dinocraft.CONFIG_PATH)) {
            createConfig();
        } else {
            try(InputStream input = new FileInputStream(String.valueOf(Dinocraft.CONFIG_PATH))) {
                Properties prop = new Properties();

                prop.load(input);

                return prop.getProperty(property);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public static Object getFixedConfig(String property) {
        if(getConfig(property) == null) {
            if(Files.exists(Dinocraft.CONFIG_PATH)) {
                try {
                    Files.delete(Dinocraft.CONFIG_PATH);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            createConfig();
        }
        return getConfig(property);
    }
}
