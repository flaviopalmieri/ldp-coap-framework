package it.poliba.sisinflab.coap.ldp.handler;

import java.lang.management.ManagementFactory;
import java.util.Date;

import org.openrdf.model.vocabulary.DCTERMS;

import com.sun.management.OperatingSystemMXBean;

import it.poliba.sisinflab.coap.ldp.resources.LDPDataHandler;
import it.poliba.sisinflab.rdf.vocabulary.SSN_XG;

@SuppressWarnings("restriction")
public class CPUHandler extends LDPDataHandler {
	
	OperatingSystemMXBean bean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

	@Override
	protected void handleData() {
		double load = bean.getSystemCpuLoad();
    	mng.updateRDFLiteralStatement(mng.getBaseURI() + resource, SSN_XG.hasValue.toString(), load);
		mng.updateRDFLiteralStatement(mng.getBaseURI() + resource, DCTERMS.CREATED.toString(), new Date());
	}

}
