package org.iley.app.repository;

import org.iley.app.model.ShopSite;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopSiteRepository extends BaseRepository<ShopSite, Integer> {
	ShopSite save(ShopSite shopSite);
}
