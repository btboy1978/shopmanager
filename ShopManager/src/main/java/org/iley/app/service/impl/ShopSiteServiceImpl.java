package org.iley.app.service.impl;

import java.util.List;

import org.iley.app.model.ShopSite;
import org.iley.app.repository.ShopSiteRepository;
import org.iley.app.service.ShopSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopSiteServiceImpl implements ShopSiteService {

	@Autowired
	private ShopSiteRepository shopSiteRepository;

	@Override
	public void saveAll(List<ShopSite> shopSites) {
		for (ShopSite shopSite : shopSites) {
			save(shopSite);
		}
	}

	@Override
	public ShopSite save(ShopSite shopSite) {
		// TODO Auto-generated method stub
		return shopSiteRepository.save(shopSite);
	}

}
