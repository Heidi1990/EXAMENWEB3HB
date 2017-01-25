package edu.ap.spoedgevallen;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class SpoedgevallenApplication extends Application {

	    /**
	     * Creates a root Restlet that will receive all incoming calls.
	     */
	   @Override
	   public synchronized Restlet createInboundRoot() {

	       Router router = new Router(getContext());

	       router.attach("/spoedgeval", SpoedgevallenResource.class);
	       router.attach("/spoedgeval/{spoedgeval_id}", SpoedgevalResource.class);
	       router.attach("/spoedgeval/{spoedgeval_id}/patientnaam", SpoedgevalPatientenResource.class);
	       router.attach("/spoedgeval/{spoedgeval_id}/patientnaam/{patientnaam_id}", SpoedgevalPatientnaamResource.class);

	       return router;
	   }
}


