package in.proj.techy;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import in.proj.techy.entity.Specialization;
import in.proj.techy.repo.SpecializationRepository;

@DataJpaTest(showSql=true)
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
public class SpecializationRepositoryTest {
	
	@Autowired
	private SpecializationRepository repo;
	/**
	 * 1.Test save operation
	 */
	@Test
	@Order(1)
	public void testspecCreate() {
		Specialization spec=new Specialization(null,"CRDLS","cardiologists","");
		spec=repo.save(spec);
		assertNotNull(spec.getId(),"spec is not created!");
	}
	/**
	 * 2.Test display all operations
	 */
	public void testSpecFetchAll() {
		List<Specialization> list=repo.findAll();
		assertNotNull(list);
		if(list.isEmpty()) {
			fail("No data exist in Database");
		}
	}
}
