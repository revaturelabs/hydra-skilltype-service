package com.revature.hydra.skilltype.data;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.revature.beans.SimpleSkillType;

@Repository
public interface SimpleSkillTypeRepository extends JpaRepository<SimpleSkillType, Integer>{
	
	/**
	 * Set the isActive state of the SkillType with given skillTypeId
	 * 
	 * @param isActive the state to set the referred SkillType object to.
	 * @param skillTypeId the unique id of a SkillType object.
	 */
	@Modifying(clearAutomatically = true)
	@Query("update SimpleSkillType st set st.isActive = ?1 where st.skillTypeId = ?2")
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	void toggleSkillTypeStatusById(boolean isActive, Integer skillTypeId);
	
	/**
	 * Find a single SkillType object by given skillTypeId
	 * 
	 * @param skillTypeId the unique id of a SkillType object.
	 * @return A SkillType object relating to the given skillTypeId
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	SimpleSkillType findBySkillTypeId(Integer skillTypeId);
}
