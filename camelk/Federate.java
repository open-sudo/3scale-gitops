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
		.to("http://fruits-threescale.apps.cluster-9zh9w.9zh9w.sandbox3182.opentlc.com?bridgeEndpoint=true")
		.to("http://vegetables-threescale.apps.cluster-9zh9w.9zh9w.sandbox3182.opentlc.com?bridgeEndpoint=true")
		.end()
                .setBody(simple("[ ${body} ]"))
                .to("jslt:transform.json");
    }
}
