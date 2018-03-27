package com.revature.hydra.skilltype.test.unit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.revature.beans.SimpleSkillType;
import com.revature.beans.SimpleSkillTypeBucketLookup;
import com.revature.hydra.skilltype.data.SimpleSkillTypeBucketLookupRepository;
import com.revature.hydra.skilltype.data.SimpleSkillTypeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@WebAppConfiguration
public class SimpleSkillTypeBucketLookupRepositoryTest {
	
	@Autowired
	private SimpleSkillTypeBucketLookupRepository stblr;
	
	@Autowired
	private SimpleSkillTypeRepository skillTypeRepository;
	
	Integer sstblId1;
	Integer sstblId2;
	Integer sstblId3;
	
	@Before
	public final void init() {
		SimpleSkillType sst1 = new SimpleSkillType("Test1", "Desc1", true);
		SimpleSkillType sst2 = new SimpleSkillType("Test2", "Desc2", true);
		SimpleSkillType sst3 = new SimpleSkillType("Test3", "Desc3", true);
		sst1 = skillTypeRepository.save(sst1);
		sst2 = skillTypeRepository.save(sst2);
		sst3 = skillTypeRepository.save(sst3);
		SimpleSkillTypeBucketLookup sstbl1 = new SimpleSkillTypeBucketLookup(sst1, 1, 0.7);
		SimpleSkillTypeBucketLookup sstbl2 = new SimpleSkillTypeBucketLookup(sst2, 2, 0.2);
		SimpleSkillTypeBucketLookup sstbl3 = new SimpleSkillTypeBucketLookup(sst3, 3, 0.1);
		sstblId1 = stblr.save(sstbl1).getSkillTypeBucketLookupId();
		sstblId2 = stblr.save(sstbl2).getSkillTypeBucketLookupId();
		sstblId3 = stblr.save(sstbl3).getSkillTypeBucketLookupId();
	}
	
	@After
	public final void end() {
		stblr.deleteAll();
		skillTypeRepository.deleteAll();
	}
	
	@Test
	public final void testFindBySkillType() {
		Assert.assertEquals(stblr.findBySkillType(skillTypeRepository.findBySkillTypeName("Test1")).size(), 1);
		Assert.assertEquals(stblr.findBySkillType(skillTypeRepository.findBySkillTypeName("Test1")).get(0).getSkillTypeBucketLookupId(), sstblId1);
	}
	
	@Test
	public final void testDeleteBySkillType() {
		Assert.assertNotNull(stblr.findOne(sstblId1));
		Assert.assertNotNull(stblr.findOne(sstblId2));
		Assert.assertNotNull(stblr.findOne(sstblId3));
		stblr.deleteBySkillType(stblr.findBySkillType(skillTypeRepository.findBySkillTypeName("Test1")).get(0).getSkillType());
		Assert.assertNull(stblr.findOne(sstblId1));
		Assert.assertNotNull(stblr.findOne(sstblId2));
		Assert.assertNotNull(stblr.findOne(sstblId3));
	}
	
}
