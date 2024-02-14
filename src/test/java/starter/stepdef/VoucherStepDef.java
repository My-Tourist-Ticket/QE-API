package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.mytt.MyttVoucherAPI;
import starter.utils.Constants;

import java.io.File;

public class VoucherStepDef {
    @Steps
    MyttVoucherAPI myttVoucherAPI;
    @Given("Create voucher with valid data in {string}")
    public void createVoucherWithValidDataIn(String json) throws Exception {
        File jsonCreateVoucher = new File(Constants.REQ_BODY + json);
        myttVoucherAPI.createNewVoucher(jsonCreateVoucher);
    }

    @When("Send request create voucher")
    public void sendRequestCreateVoucher() {
        SerenityRest.when()
                .post(MyttVoucherAPI.CREATE_NEW_VOUCHER);
    }

    @Given("Create voucher with {string}")
    public void createVoucherWith(String json) throws Exception {
        File jsonCreateVoucher = new File(Constants.REQ_BODY + json);
        myttVoucherAPI.createNewVoucher(jsonCreateVoucher);
    }

    @Given("Get list voucher as admin")
    public void getListVoucherWith() throws Exception {
        myttVoucherAPI.getListVoucherAdmin();
    }

    @When("Send request get list voucher as admin")
    public void sendRequestGetListVoucherAsAdmin() {
        SerenityRest.when()
                .get(MyttVoucherAPI.GET_LIST_VOUCHER);
    }

    @Given("Get list voucher as costumer")
    public void getListVoucherAsCostumer() throws Exception {
        myttVoucherAPI.getListVoucherCostumer();
    }

    @When("Send request get list voucher as costumer")
    public void sendRequestGetListVoucherAsCostumer() {
        SerenityRest.when()
                .get(MyttVoucherAPI.GET_LIST_VOUCHER);
    }

    @Given("Get list voucher")
    public void getListVoucher() {
        myttVoucherAPI.getListVoucherUnauth();
    }

    @When("Send request get list voucher")
    public void sendRequestGetListVoucher() {
        SerenityRest.when()
                .get(MyttVoucherAPI.GET_LIST_VOUCHER);
    }

    @Given("Update voucher with data in {string} and {int}")
    public void updateVoucherWithDataIn(String json, int id) throws Exception {
        File jsonUpdateVoucher = new File(Constants.REQ_BODY + json);
        myttVoucherAPI.updateVoucher(jsonUpdateVoucher, id);
    }

    @When("Send request update voucher")
    public void sendRequestUpdateVoucher() {
        SerenityRest.when()
                .put(MyttVoucherAPI.UPDATE_VOUCHER);
    }

    @Given("Update voucher with data in {string} and {string}")
    public void updateVoucherWithDataInAnd(String json, String id) throws Exception {
        File jsonUpdateVoucher = new File(Constants.REQ_BODY + json);
        myttVoucherAPI.updateVoucher1(jsonUpdateVoucher, id);
    }

    @Given("Delete voucher with {int}")
    public void deleteVoucherWith(int id) throws Exception {
        myttVoucherAPI.deleteVoucher(id);
    }

    @When("Send request delete voucher")
    public void sendRequestDeleteVoucher() {
        SerenityRest.when()
                .delete(MyttVoucherAPI.DELETE_VOUCHER);
    }

    @Given("Delete voucher wih {int} without login")
    public void deleteVoucherWihWithoutLogin(int id) {
        myttVoucherAPI.deleteVoucherUnauth(id);
    }
}
