package com.revature.hydra.skilltype.test.unit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.revature.beans.SimpleSkillType;
import com.revature.hydra.skilltype.data.SimpleSkillTypeBucketLookupRepository;
import com.revature.hydra.skilltype.data.SimpleSkillTypeRepository;
import com.revature.hydra.skilltype.service.SkillTypeCompositionService;

@RunWith(SpringRunner.class)
@DataJpaTest
@WebAppConfiguration
@ComponentScan("com.revature.hydra.skilltype.*")
public class SkillTypeCompositionServiceTest {
	
	@Autowired
	SkillTypeCompositionService stcs;

	@Autowired
	SimpleSkillTypeRepository sstr;

	@Autowired
	SimpleSkillTypeBucketLookupRepository sstblr;
	
	@Test
	public final void testFindSkillTypeByName() {
		stcs.createSkill("2", "1");
		Assert.assertEquals(stcs.findSkillTypeByName("2").getSkillTypeDescription(), "1");
	}
	
	@Test
	public final void testCreateSkill() {
		testFindSkillTypeByName();
	}
	
	@Test
	public final void testUpdateSkillTypeBucketLookup() {
		stcs.createSkill("2", "1");
		int id = stcs.findSkillTypeByName("2").getSkillTypeId();
		Integer[] bucketIds = {1, 2, 3};
		Double[] weights = {10.0, 20.0, 70.0};
		Assert.assertTrue(stcs.updateSkillTypeBucketLookup(id, "", bucketIds, weights));
		Double[] weights2 = {11.0, 20.0, 70.0};
		Assert.assertFalse(stcs.updateSkillTypeBucketLookup(id, "", bucketIds, weights2));
		Double[] weights3 = {9.0, 20.0, 70.0};
		Assert.assertFalse(stcs.updateSkillTypeBucketLookup(id, "", bucketIds, weights3));
	}
	
	@Test
	public final void testCreateSkillTypeBucketLookup() {
		stcs.createSkill("2", "1");
		Integer[] bucketIds = {1, 2, 3};
		Double[] weights = {10.0, 20.0, 70.0};
		stcs.createSkillTypeBucketLookup("2", bucketIds, weights);
		SimpleSkillType sst = stcs.findSkillTypeByName("2");
		Assert.assertEquals(sstblr.findBySkillType(sst).get(0).getSkillType().getSkillTypeDescription(), "1");
	}
	
}
