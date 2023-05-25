package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId(){
        //Job jobTesting = new Job("Web Developer", new Employer("Safaricom"),new Location("Mombasa"),new PositionType("Entry level"),new CoreCompetency("Sijui"));
        //Job jobTesting2 = new Job("Data Analyst", new Employer("Safaricom"),new Location("Nanyuki"),new PositionType("Entry level"),new CoreCompetency("Sijui"));
        // creating two empty job objects
        Job jobTest1 = new Job();
        Job jobTest2 = new Job();
        assertNotEquals(jobTest1.getId(), jobTest2.getId());
    }

//Test full constructor
    // Define test testJobConstructorSetsAllFields.
    @Test
    public void testJobConstructorSetsAllFields(){
        //create job object
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        //Use assertTrue and assertEquals statements to test that the constructor correctly assigns both the class and value of each field.
        assertTrue(job1 instanceof Job);
        assertEquals(job1.getName(), "Product tester");

        assertTrue(job1.getEmployer() instanceof Employer);
        assertEquals(job1.getEmployer().getValue(), "ACME");

        assertTrue(job1.getLocation() instanceof Location);
        assertEquals(job1.getLocation().getValue(), "Desert");

        assertTrue(job1.getPositionType() instanceof PositionType);
        assertEquals(job1.getPositionType().getValue(), "Quality control");

        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(job1.getCoreCompetency().getValue(), "Persistence");
    }

    // Test the equals method
    // create the constructor testJobsForEquality
    @Test
    public void testJobsForEquality(){
        // create two similar job objects but with different ids
        Job jobA = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobB = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        // Test the ids. Test that equals returns false.
        assertFalse(jobA.equals(jobB));


    }


    }



