import org.apache.camel.builder.RouteBuilder;

public class Fruits extends RouteBuilder {

public void configure() throws Exception {
   from("platform-http:/")
   .setBody(constant("[{\"name\":\"Apple\", \"description\":\"Apple should be sweet\"},{\"name\":\"Banana\",  \"description\":\"Banana are  sweet\"},{\"name\":\"Orange\", \"description\":\"Orange can be sweet\"}]"));
}
}
