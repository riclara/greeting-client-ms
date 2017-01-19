package co.com.msrdo.model;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Greeting")
public class Greeting {
    protected String content;
 
    protected Greeting() {
    this.content = "Hello!";
}
 
    public Greeting(String content) {
        this.content = content;
    }
 
    public String getContent() {
        return content;
    }
}