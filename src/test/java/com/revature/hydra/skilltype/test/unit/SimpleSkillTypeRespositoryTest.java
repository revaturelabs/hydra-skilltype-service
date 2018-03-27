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
import com.revature.hydra.skilltype.data.SimpleSkillTypeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@WebAppConfiguration
public class SimpleSkillTypeRespositoryTest {
	
	@Autowired
	private SimpleSkillTypeRepository skillTypeRepository;
	
	private Integer sstId;
	
	@Before
	public final void init() {
		SimpleSkillType sst = new SimpleSkillType("Test name", "Test description", true);
		sstId = skillTypeRepository.save(sst).getSkillTypeId();
	}
	
	@After
	public final void end() {
		skillTypeRepository.delete(sstId);
	}
	
	@Test
	public final void testToggleSkillTypeStatusById() {
		skillTypeRepository.toggleSkillTypeStatusById(false, sstId);
		SimpleSkillType sst = skillTypeRepository.findBySkillTypeId(sstId);
		Assert.assertFalse(sst.getIsActive());
		skillTypeRepository.toggleSkillTypeStatusById(true, sstId);
		sst = skillTypeRepository.findBySkillTypeId(sstId);
		Assert.assertTrue(sst.getIsActive());
	}
	
	@Test
	public final void testFindBySkillTypeName() {
		SimpleSkillType sst = skillTypeRepository.findBySkillTypeName("Test name");
		Assert.assertNotNull(sst);
		Assert.assertEquals(sst.getSkillTypeDescription(), "Test description");
	}
	
	@Test
	public final void testUpdateSkillType() {
		skillTypeRepository.updateSkillType(sstId, "dummy", "also dummy");
		Assert.assertEquals(skillTypeRepository.findBySkillTypeId(sstId).getSkillTypeName(), "dummy");
		Assert.assertEquals(skillTypeRepository.findBySkillTypeId(sstId).getSkillTypeDescription(), "also dummy");
	}
	
}
