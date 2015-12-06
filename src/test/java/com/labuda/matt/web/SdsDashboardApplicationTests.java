package com.labuda.matt.web;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SdsDashboardApplication.class)
@WebAppConfiguration
public class SdsDashboardApplicationTests {

	@Autowired
	private DataSource dataSource;


	@Ignore
	@Test
	public void testDatabaseConnectionWorks() {
		try {
			dataSource.getConnection();
		} catch (SQLException e) {
			Assert.fail("SQL Exception thrown : " + e.getMessage());
			e.getStackTrace();
		}
	}
	/*@Ignore
	@Test
	public void testBatchJobDaoGetElementByIdWorks(){
		BatchJob job = batchJobDao.getBatchJobById(194041);
		Assert.assertNull(job.getJobName());
	}*/

}
