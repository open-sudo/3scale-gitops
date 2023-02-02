package org.acme.health;

import org.apache.camel.builder.*;
import org.apache.camel.processor.aggregate.*;

public class Federate extends RouteBuilder {

    @Override
    public void configure() {
	        from("platform-http:/")
                .removeHeaders("CamelHttpPath")
                .multicast()
                .aggregationStrategy(AggregationStrategies.string(","))
		.to("http://fruits?bridgeEndpoint=true")
		.to("http://vegetables?bridgeEndpoint=true")
		.end()
                .setBody(simple("[ ${body} ]"))
                .to("jslt:transform.json");
    }
}
