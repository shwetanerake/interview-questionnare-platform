package com.platform.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platform.handle.api.error.ApiResponseStatus;
import com.platform.model.company.Company;
import com.platform.service.CompanyService;
import com.platform.service.Utility;

/**
 * 
 * @author shweta
 *
 */
@RestController
@RequestMapping("/api/platform/companies")
public class CompanyController {

	@Autowired
	CompanyService companyService;

	@PostMapping
	public ResponseEntity<ApiResponseStatus> addCompany(@Valid @RequestBody Company company) {

		try {

			final Long companyId = companyService.createOrUpdate(null, company).getCompanyId();

			final Map<String, Object> resultMap = Utility.buildResultMap("company_id", companyId);

			return new ResponseEntity<ApiResponseStatus>(new ApiResponseStatus(resultMap), HttpStatus.OK);

		} catch (Exception exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
			return new ResponseEntity<ApiResponseStatus>(new ApiResponseStatus(-1,
					"Exception Occured, Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR, exception),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@GetMapping("/id/{companyId}")
	public ResponseEntity<ApiResponseStatus> fetchCompanyById(@PathVariable Long companyId) {

		try {

			final Map<String, Object> resultMap = Utility.buildResultMap("company_details",
					companyService.findById(companyId).get());

			return new ResponseEntity<ApiResponseStatus>(new ApiResponseStatus(resultMap), HttpStatus.OK);

		} catch (Exception exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
			return new ResponseEntity<ApiResponseStatus>(new ApiResponseStatus(-1,
					"Exception Occured, Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR, exception),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@GetMapping("/name/{companyName}")
	public ResponseEntity<ApiResponseStatus> fetchCompanyByName(@PathVariable String companyName) {

		try {

			final Map<String, Object> resultMap = Utility.buildResultMap("company_details",
					companyService.findByName(companyName).get());

			return new ResponseEntity<ApiResponseStatus>(new ApiResponseStatus(resultMap), HttpStatus.OK);

		} catch (Exception exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
			return new ResponseEntity<ApiResponseStatus>(new ApiResponseStatus(-1,
					"Exception Occured, Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR, exception),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@PutMapping("/id/{companyId}")
	public ResponseEntity<ApiResponseStatus> updateCompanyDetails(@PathVariable Long companyId,
			@Valid @RequestBody Company company) {

		try {

			final Map<String, Object> resultMap = Utility.buildResultMap("company_details",
					companyService.createOrUpdate(companyId,company));

			return new ResponseEntity<ApiResponseStatus>(new ApiResponseStatus(resultMap), HttpStatus.OK);

		} catch (Exception exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
			return new ResponseEntity<ApiResponseStatus>(new ApiResponseStatus(-1,
					"Exception Occured, Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR, exception),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

}
