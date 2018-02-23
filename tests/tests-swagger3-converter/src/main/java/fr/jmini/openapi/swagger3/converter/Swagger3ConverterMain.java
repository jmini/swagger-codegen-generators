package fr.jmini.openapi.swagger3.converter;

import io.swagger.codegen.ClientOptInput;
import io.swagger.codegen.DefaultGenerator;
import io.swagger.codegen.config.CodegenConfigurator;
import io.swagger.codegen.languages.java.JavaJerseyServerCodegen;

public class Swagger3ConverterMain {

    public static void main(String[] args) {
        convertSwagger3jaxrs("petstore");
    }

    private static void convertSwagger3jaxrs(String inputSpecName) {
        final String lang= "jaxrs";//TODO: will probably be jaxrs-jersey
        JavaJerseyServerCodegen config = new io.swagger.codegen.languages.java.JavaJerseyServerCodegen();

        final String folder = "../3.0/" + inputSpecName;
        final String artifactId = inputSpecName + "-swagger3-" + lang;

        CodegenConfigurator configurator = new CodegenConfigurator();
        configurator.setLang(lang); 
        configurator.setInputSpec(folder + "/" + inputSpecName + ".json");
        final ClientOptInput input = configurator.toClientOptInput();

        config.setOutputDir(folder + "/" + artifactId);
        config.setArtifactId(artifactId);
        config.setJava8Mode(true);
        input.setConfig(config);

        new DefaultGenerator().opts(input).generate();
    }
}
