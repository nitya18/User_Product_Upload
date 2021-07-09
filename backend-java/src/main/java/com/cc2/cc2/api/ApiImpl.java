package com.cc2.cc2.api;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cc2.cc2.configuration.CloudRepository;
import com.cc2.cc2.configuration.HouseholdRepository;
import com.cc2.cc2.configuration.ProductsRepository;
import com.cc2.cc2.configuration.TxnRepository;
import com.cc2.cc2.entity.Households;
import com.cc2.cc2.entity.PKey;
import com.cc2.cc2.entity.Products;
import com.cc2.cc2.entity.TransactionDetails;
import com.cc2.cc2.entity.UserDetails;
import com.cc2.cc2.model.ApiRequest;
import com.cc2.cc2.model.ApiResponse;

@CrossOrigin
@RestController
public class ApiImpl {
	@Autowired
    private CloudRepository customerRepo;
	
	@Autowired
    private TxnRepository txnRepo;

	@Autowired
    private HouseholdRepository householdRepo;
	
	@Autowired
    private ProductsRepository productsRepo;
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	@ResponseBody
	public ApiResponse registerUser(@RequestBody ApiRequest apiRequest) {
		UserDetails user = new UserDetails();
		user.setFirstname(apiRequest.firstName);
		user.setLastname(apiRequest.lastName);
		user.setUsername(apiRequest.userName);
		user.setPassword(apiRequest.password);
		customerRepo.save(user);
		ApiResponse response = new ApiResponse();
		response.setFirstName(apiRequest.firstName);
		response.setValidated("yes");
		return response;
	}
	
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	@ResponseBody
	public ApiResponse loginUser(@RequestBody ApiRequest apiRequest) {
		Optional<UserDetails> userDetails = customerRepo.findById(apiRequest.userName);
		if(userDetails.isEmpty()) {
			ApiResponse response = new ApiResponse();
			response.setFirstName("");
			response.setValidated("no");
			response.setMessage("User does not exist");
			return response;
		}
		else {
			if(apiRequest.password.equals(userDetails.get().getPassword())) {
				ApiResponse response = new ApiResponse();
				response.setFirstName(userDetails.get().getFirstname());
				response.setValidated("yes");
				return response;
			} else {
				ApiResponse response = new ApiResponse();
				response.setFirstName("");
				response.setValidated("no");
				response.setMessage("Incorrect Password");
				return response;
			}
		}
	}
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public ApiResponse uploadFile(@RequestParam("file") MultipartFile file1) throws IOException, ParseException {
		ApiResponse response = new ApiResponse();
		List<TransactionDetails> txn = new ArrayList<TransactionDetails>();
		Scanner myReader = new Scanner(file1.getInputStream());
		myReader.nextLine();
	    while (myReader.hasNextLine()) {
	    	String data = myReader.nextLine();
	        String[] txnColumns = data.split(",");
	        TransactionDetails txnDetail = new TransactionDetails();
	        PKey pkey = new PKey();
	        pkey.setBASKET_NUM(Integer.parseInt(txnColumns[0].trim()));
	        pkey.setHSHD_NUM(Integer.parseInt(txnColumns[1].trim()));
	        pkey.setPRODUCT_NUM(Integer.parseInt(txnColumns[3].trim()));
	        txnDetail.setPkey(pkey);
//	        SimpleDateFormat sdfmt2= new SimpleDateFormat("dd-MMM-yyyy");
//	        java.util.Date dDate = sdfmt2.parse(  );
	        txnDetail.setPURCHASE(txnColumns[2].trim());
	        txnDetail.setSPEND(Double.parseDouble(txnColumns[4].trim()));
	        txnDetail.setUNITS(Double.parseDouble(txnColumns[5].trim()));
	        txnDetail.setSTORE_R(txnColumns[6].trim());
	        txnDetail.setWEEK_NUM(Integer.parseInt(txnColumns[7].trim()));
	        txnDetail.setYEAR(Integer.parseInt(txnColumns[8].trim()));
	        txn.add(txnDetail);
	    }
	    myReader.close();
	    List<TransactionDetails> txnSaved = txnRepo.saveAll(txn);
	    if(txnSaved.size() == txn.size()) { 
	    	response.setMessage("all records inserted");
	    	response.setValidated("yes");
	    } else {
	    	response.setMessage("No of records inserted = "+txnSaved.size());
	    	response.setValidated("no");
	    }
	    
		return response;
	}
	
	@RequestMapping(value = "/uploadFileHousehold", method = RequestMethod.POST)
	@ResponseBody
	public ApiResponse uploadFileHousehold(@RequestParam("file") MultipartFile file1) throws IOException, ParseException {
		ApiResponse response = new ApiResponse();
		List<Households> txn = new ArrayList<Households>();
		Scanner myReader = new Scanner(file1.getInputStream());
		myReader.nextLine();
	    while (myReader.hasNextLine()) {
	    	String data = myReader.nextLine();
	        String[] txnColumns = data.split(",");
	        Households households = new Households();
	        households.setHSHD_NUM(Integer.parseInt(txnColumns[0].trim()));
	        households.setL(txnColumns[1].trim());
	        households.setAGE_RANGE(txnColumns[2].trim());
	        households.setMARITAL(txnColumns[3].trim());
	        households.setINCOME_RANGE(txnColumns[4].trim());
	        households.setHOMEOWNER(txnColumns[5].trim());
	        households.setHSHD_COMPOSITION(txnColumns[6].trim());
	        households.setHH_SIZE(txnColumns[7].trim());
	        households.setCHILDREN(txnColumns[8].trim());
	        txn.add(households);
	    }
	    myReader.close();
	    List<Households> txnSaved = householdRepo.saveAll(txn);
	    if(txnSaved.size() == txn.size()) { 
	    	response.setMessage("all records inserted");
	    	response.setValidated("yes");
	    } else {
	    	response.setMessage("No of records inserted = "+txnSaved.size());
	    	response.setValidated("no");
	    }
		return response;
	}
	
	@RequestMapping(value = "/uploadFileProducts", method = RequestMethod.POST)
	@ResponseBody
	public ApiResponse uploadFileProducts(@RequestParam("file") MultipartFile file1) throws IOException, ParseException {
		ApiResponse response = new ApiResponse();
		List<Products> txn = new ArrayList<Products>();
		Scanner myReader = new Scanner(file1.getInputStream());
		myReader.nextLine();
	    while (myReader.hasNextLine()) {
	    	String data = myReader.nextLine();
	        String[] txnColumns = data.split(",");
	        Products products = new Products();
	        products.setPRODUCT_NUM(Integer.parseInt(txnColumns[0].trim()));
	        products.setDEPARTMENT(txnColumns[1].trim());
	        products.setCOMMODITY(txnColumns[2].trim());
	        products.setBRAND_TY(txnColumns[3].trim());
	        products.setNATURAL_ORGANIC_FLAG(txnColumns[4].trim());
	        txn.add(products);
	    }
	    myReader.close();
	    List<Products> txnSaved = productsRepo.saveAll(txn);
	    if(txnSaved.size() == txn.size()) { 
	    	response.setMessage("all records inserted");
	    	response.setValidated("yes");
	    } else {
	    	response.setMessage("No of records inserted = "+txnSaved.size());
	    	response.setValidated("no");
	    }
		return response;
	}
}