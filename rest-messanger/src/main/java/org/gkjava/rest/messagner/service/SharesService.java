package org.gkjava.rest.messagner.service;

import java.util.List;

import org.gkjava.rest.messagner.model.Share;

public interface SharesService {

	List<Share> getAllShares();

	List<Share> getShare(long shareId);
	
	Share addShare(Share share);
	
	Share removeShare(long shareId);
	
	Share updateShare(Share share);
}
