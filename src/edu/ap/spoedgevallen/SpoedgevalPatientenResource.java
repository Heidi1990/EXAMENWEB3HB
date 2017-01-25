package edu.ap.spoedgevallen;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import edu.ap.xml.XMLParser;

/**
 * This resource represents all runners for a race instance
 */
public class SpoedgevalPatientenResource extends ServerResource {

	@Get("html")
	public String getPatienten() {
		String spoedgeval_id = getAttribute("spoedgeval_id");
		XMLParser parser = new XMLParser();
		return parser.getPatienten(spoedgeval_id);
	}

}
