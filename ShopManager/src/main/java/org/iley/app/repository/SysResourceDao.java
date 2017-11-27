package org.iley.app.repository;

import java.util.List;

import org.iley.app.model.SysResource;
import org.springframework.stereotype.Repository;

@Repository
public interface SysResourceDao extends BaseRepository<SysResource, Integer> {

	List<SysResource> findByResourceString(String url);

	List<SysResource> findByResourceStringAndMethodPath(String resourceString, String methodPath);

}
