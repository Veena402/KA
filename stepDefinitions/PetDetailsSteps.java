package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.ExcelReader;

import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PetDetailsSteps {

    private Map<String, String> petDetails;

    @Given("I read pet details for {string} from the Excel file")
    public void iReadPetDetailsForTestCaseFromTheExcelFile(String testCaseName) {
        String filePath = "C:/Users/veenana/Music/pet_details_v2.xlsx";
        petDetails = ExcelReader.getPetDetails(testCaseName, filePath);
    }

    @Then("the Pet ID and Pet Name should be retrieved")
    public void thePetIDAndPetNameShouldBeRetrieved() {
        assertNotNull("Pet ID is null!", petDetails.get("Pet ID"));
        assertNotNull("Pet Name is null!", petDetails.get("Pet Name"));
        System.out.println("Pet ID: " + petDetails.get("Pet ID"));
        System.out.println("Pet Name: " + petDetails.get("Pet Name"));
    }
}
