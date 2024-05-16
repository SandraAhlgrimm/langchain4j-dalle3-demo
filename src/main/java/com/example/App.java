package com.example;

import dev.langchain4j.data.image.Image;
import dev.langchain4j.model.azure.AzureOpenAiImageModel;
import dev.langchain4j.model.output.Response;

/**
 * This class represents an application that uses the Azure OpenAI Image Model to generate images.
 */
public class App 
{
    /**
     * The main method of the application.
     * It creates an instance of the AzureOpenAiImageModel and uses it to generate an image.
     * The generated image URL is then printed to the console.
     *
     * @param args The command line arguments.
     */
    public static void main( String[] args )
    {
        AzureOpenAiImageModel model = new AzureOpenAiImageModel.Builder()
            .endpoint(System.getenv("AZURE_OPENAI_ENDPOINT"))
            .deploymentName(System.getenv("AZURE_OPENAI_DEPLOYMENT_NAME"))
            .apiKey(System.getenv("AZURE_OPENAI_API_KEY"))
            .logRequestsAndResponses(true)
            .build();
        Response<Image> response = model.generate("Create an image of a horse race with three horses.");
        System.out.println(response.toString());
        Image image = response.content();
        System.out.println("The generated image is here: " + image.url());
    }
    
}
