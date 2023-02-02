import org.apache.camel.builder.RouteBuilder;

public class Vegetables extends RouteBuilder {

public void configure() throws Exception {
   from("platform-http:/")
   .setBody(constant("[{\"name\":\"Tomato\", \"description\":\"Tomato should be sweet\"},{\"name\":\"Spinach\",  \"description\":\"Spinach are  sweet\"},{\"name\":\"Zucchini\", \"description\":\"Zucchini can be sweet\"}]"));
}
}
