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

    // checking that
    // When passed a job object it should return a string that contains a blank line before and after the job information.
    // Label for ech field followed by the data stored in that field. Each field should be on its own line.
    // If a field is empty, the method should add, “Data not available” after the label.
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job jobC = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString = jobC.toString();
        assertEquals(jobString.charAt(0),'\n');
        assertEquals( jobString.charAt(jobString.length()-1), '\n');

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job jobD = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString1 = jobD.toString();

        assertEquals(jobString1, String.format("\nID: %d\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n", jobD.getId()));

        assertTrue(jobString1.contains("ID: "));

        assertTrue(jobString1.contains("Name: "));
        assertTrue(jobString1.contains("Product tester"));

        assertTrue(jobString1.contains("Employer: "));
        assertTrue(jobString1.contains("ACME"));

        assertTrue(jobString1.contains("Location: "));
        assertTrue(jobString1.contains("Desert"));

        assertTrue(jobString1.contains("Position Type: "));
        assertTrue(jobString1.contains("Quality control"));

        assertTrue(jobString1.contains("Core Competency: "));
        assertTrue(jobString1.contains("Persistence"));
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job nusuJob1 = new Job("Product tester", new Employer("ACME"),  new Location(""), new PositionType(""), new CoreCompetency(""));
        assertNotEquals(nusuJob1.toString().indexOf("Data not available"), -1);
        // 3 empty fields - should be split into an array of length 4
        assertEquals(nusuJob1.toString().split("Data not available").length, 4);

        // test the empty Job constructor - returns a Job object with all fields but id being null
        Job hakunaJob1 = new Job();
        assertEquals(hakunaJob1.toString(), "OOPS! This job does not seem to exist.");

        // test 5-parameter constructor with all parameters being empty strings
        Job hakunaJob2 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals(hakunaJob2.toString(), "OOPS! This job does not seem to exist.");
    }


    }



