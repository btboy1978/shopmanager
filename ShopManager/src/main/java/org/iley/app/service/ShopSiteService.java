package org.iley.app.service;

import java.util.List;

import org.iley.app.model.ShopSite;

public interface ShopSiteService {
	
	void saveAll(List<ShopSite> shopSites);

	ShopSite save(ShopSite shopSite);
}
