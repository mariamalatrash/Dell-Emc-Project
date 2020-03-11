package com.server.app.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.server.app.model.VirtualMachine;
import com.server.app.service.VirtualMachineService;

import springfox.documentation.swagger2.mappers.ModelMapper;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class VirtualMachineController {
	
	@Autowired
	VirtualMachineService vmService;
	@Autowired
    private ModelMapper modelMapper;
	
	
	@RequestMapping(method = RequestMethod.POST, value =  "/add")
	public void addVirtualMachine(@RequestParam String userId_, String ip, String username, String password){
		UUID userId=UUID.fromString(userId_);
		vmService.addVirtualMachine(userId, ip, username, password);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value="/get")
	public List<VirtualMachine> getVirtualMachines(String username){
		List<VirtualMachine> vms=vmService.getVitualMachines(username);
		return vms;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value= "/delete")
	public void deleteVirtualMachineByID(@RequestParam String ip){
		vmService.deleteVirtualMachineByIp(ip);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/updatePassword")
	public void updatePasswordByID(@RequestParam UUID id,String newPassword){
		//dbService.updatePasswordByID(id,newPassword);
	}
	
}
