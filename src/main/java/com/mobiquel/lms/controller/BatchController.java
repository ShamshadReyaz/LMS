package com.mobiquel.lms.controller;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mobiquel.lms.model.Batch;
import com.mobiquel.lms.repository.BatchRepository;

@RestController
public class BatchController {
	
	@Autowired
	BatchRepository batchRepo;
	
	@PostMapping("/LMS/createBatch")
	public String create(@RequestBody Batch batch) {

		batchRepo.save(new Batch(batch.getCourseId(), batch.getStartDate(),batch.getEndtDate(),batch.getDetails(),batch.getBatchSize()));
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("errorCode", "0");
		jsonObject.put("errorMessage", "Batch created successfully!");
		return jsonObject.toString();
	}
	
	@PostMapping("/LMS/getAllBatch")
	public String getAllBatchs() {
		JSONObject jsonObject=new JSONObject();
		List<Batch> allBatchs=batchRepo.findAll();
		jsonObject.put("errorCode", "0");
		jsonObject.put("errorMessage", "success");
		jsonObject.put("Batchs", allBatchs);
		return jsonObject.toString();
	}
	
	@PostMapping(value ="/LMS/deleteBatch/{id}")
	public String deleteBatch(@PathVariable Integer id) {
		JSONObject json = new JSONObject();
		boolean isFound = batchRepo.existsById(id);
		if (isFound) {
			json.put("errorCode", "0");
			json.put("errorMessage", "Batch deleted");

			batchRepo.deleteById(id);
		}
		else {
			json.put("errorCode", "1");
			json.put("errorMessage", "Batch not exits");

		}	
		return json.toString();
	}
	
	
	@PostMapping("/LMS/updateBatch/{id}")
	public String updateBatch(@PathVariable(value = "id") Integer id, @Validated @RequestBody Batch batchUpdate) {

		JSONObject json = new JSONObject();
		boolean isFound = batchRepo.existsById(id);
		if (isFound) {
			json.put("errorCode", "0");
			json.put("errorMessage", "Batch Updated");

			Optional<Batch> batch = batchRepo.findById(id);

			batch.get().setCourseId(batchUpdate.getCourseId());
			batch.get().setStartDate(batchUpdate.getStartDate());
			batch.get().setEndtDate(batchUpdate.getEndtDate());
			batch.get().setDetails(batchUpdate.getDetails());
			batch.get().setBatchSize(batchUpdate.getBatchSize());
			Batch updatedBatch = batch.get();
			batchRepo.save(updatedBatch);

		} else {

			json.put("errorCode", "1");
			json.put("errorMessage", "Batch not exits");

		}

		return json.toString();
	}
}
