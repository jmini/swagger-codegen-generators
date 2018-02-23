package fr.jmini.openapi.swagger2.converter;

import io.swagger.codegen.ClientOptInput;
import io.swagger.codegen.DefaultGenerator;
import io.swagger.codegen.config.CodegenConfigurator;
import io.swagger.codegen.languages.JavaJerseyServerCodegen;

public class Swagger2ConverterMain {

    public static void main(String[] args) {
        convertSwagger2jaxrs("petstore");
    }

    private static void convertSwagger2jaxrs(String inputSpecName) {
        final String lang= "jaxrs";
        JavaJerseyServerCodegen config = new io.swagger.codegen.languages.JavaJerseyServerCodegen();

        final String folder = "../2.0/" + inputSpecName;
        final String artifactId = inputSpecName + "-swagger2-" + lang;

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
