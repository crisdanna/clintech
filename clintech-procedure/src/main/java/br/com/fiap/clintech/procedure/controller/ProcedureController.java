package br.com.fiap.clintech.procedure.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.clintech.procedure.dao.bean.Procedure;
import br.com.fiap.clintech.procedure.dto.ProcedureDto;
import br.com.fiap.clintech.procedure.service.ProcedureService;

@RestController
@RequestMapping("procedure")
public class ProcedureController {
	@Autowired
	private ProcedureService service;
	
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/list")
	public List<ProcedureDto> getProcedures(){
		return convertToDtoList(service.getAllProcedures());
	}
	
	private List<ProcedureDto> convertToDtoList(List<Procedure> procedures) {
		List<ProcedureDto> procedureDtoList = modelMapper.map(procedures, List.class);
	    return procedureDtoList;
	}
}
