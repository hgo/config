package config;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BaseTests {

    Properties properties;

    @Before
    public void setUp() throws Exception {
        properties = new Properties();
        properties.setProperty("key", "value");
        properties.setProperty("key1", "value1");
        properties.setProperty("key2", "value2");
        properties.setProperty("key3", "base-value3");
        properties.setProperty("%test.key3", "test-value3");
        properties.setProperty("path.var", "${PATH}");
    }

    @After
    public void tearDown() throws Exception {
        properties = null;
    }

    @Test
    public void default_test() {
        Properties parsed = Config.parse(properties);
        assertEquals("value1", parsed.getProperty("key1"));
        assertEquals(5, parsed.size());
        assertEquals("base-value3", parsed.getProperty("key3"));
    }

    @Test
    public void with_env() {
        Properties parsed = Config.parse("test", properties);
        assertEquals("test-value3", parsed.getProperty("key3"));
    }
    
    @Test
    public void default_withEnv() {
        Properties parsed = Config.parse(properties);
        String path = System.getenv("PATH");
        System.out.println(path);
        assertEquals(path, parsed.getProperty("path.var"));
    }
    

}
