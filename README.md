## config

Manage application configuration in single file with environment prefixes


`myapp.conf`:
```
app.name=My App
%test.app.name=My Test App
...
```

### Usage

``` java
Properties properties = parsePropertiesFile(FileUtils.get("myapp.conf"));
Properties parsedProps = Config.parse(properties);
assert parsedProps.get("app.name").equals("My App");


/// with env prefix
Properties parsedProps = Config.parse("test",properties);
assert parsedProps.get("app.name").equals("My Test App");
```

All codes are extracted from Play 1.x library. Actual reference is : [https://www.playframework.com/documentation/1.2.4/configuration](https://www.playframework.com/documentation/1.2.4/configuration)
