package com.revature.hydra.skilltype.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.SimpleSkillType;
import com.revature.beans.SimpleSkillTypeBucketLookup;

/**
 * 
 * @author Sungkwon Kudo
 *
 */
@Repository
public interface SimpleSkillTypeBucketLookupRepository extends JpaRepository<SimpleSkillTypeBucketLookup, Integer>{

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	void deleteBySkillType(SimpleSkillType skillType);

	List<SimpleSkillTypeBucketLookup> findBySkillType(SimpleSkillType sst);
}
