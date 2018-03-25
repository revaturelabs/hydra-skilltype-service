package com.revature.hydra.skilltype.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.SimpleSkillTypeBucketLookup;
import com.revature.beans.SimpleSkillType;

public interface SimpleSkillTypeBucketLookupRepository extends JpaRepository<SimpleSkillTypeBucketLookup, Integer>{

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	List<SimpleSkillTypeBucketLookup> findAllBySkillType(SimpleSkillType skillType);
	
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	List<SimpleSkillTypeBucketLookup> deleteBySkillType(SimpleSkillType skillType);

	List<SimpleSkillTypeBucketLookup> findBySkillType(SimpleSkillType sst);
}
