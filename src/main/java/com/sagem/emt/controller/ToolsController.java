package com.sagem.emt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagem.emt.dao.entity.tools;
import com.sagem.emt.service.ToolService;

@RestController
@RequestMapping("/tools")
public class ToolsController {
@Autowired
private ToolService toolService;

@GetMapping("/getAll")
public List<tools> getAll(){
	return toolService.getAll();
	
}
@PostMapping("/addTool")
public tools addTools (@RequestBody tools t) {
	return toolService.addTools(t);
}

@DeleteMapping("/deleteTool")
public void deleteAll() {
	toolService.deleteAll();
}

@DeleteMapping("/deleteTool{id}")
public void deletetool(@PathVariable("id")Long id ) {
toolService.deletetool(id);
}
}
