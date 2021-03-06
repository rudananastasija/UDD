package com.example.naucna.services;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.naucna.model.FormSubmissionDto;
import com.example.naucna.model.Magazin;
import com.example.naucna.model.NaucnaOblast;
import com.example.naucna.model.Text;
import com.example.naucna.model.User;

@Service
public class CuvanjeIzabranihRec  implements JavaDelegate{
	@Autowired
	MagazinService magazinService;
	@Autowired
	private TextService textService;
	@Autowired
	NaucnaOblastService naucnaOblastService;
	@Autowired
	private UserServiceImp service;
	@Autowired 
	IndeksiranjeService indeksiranjeService;


	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		
		 List<FormSubmissionDto> izabraniRecenzentiForm = (List<FormSubmissionDto>)execution.getVariable("izabraniRecenzentiForm");
		 String textId = (String)execution.getVariable("textId");
		 Text text = textService.findById(Long.parseLong(textId));
		    
		 for (FormSubmissionDto formField : izabraniRecenzentiForm) {
			
			if(formField.getFieldId().equals("rec")) {
				
				List<String> oblastiId = formField.getOblasti();
				for(String s : oblastiId) {
					Long id = Long.parseLong(s);
					User recenzent = service.findById(id);
					recenzent.getRadoviRecenzent().add(text);
					User sacuvaniRec = service.saveUser(recenzent);
					text.getRecenzenti().add(sacuvaniRec);
					
				}
			}
	      }
		 Text sacuvani = textService.savetext(text);

		indeksiranjeService.indeksiranjeRada(text.getId());
		 System.out.println("uspjesno je sacuvao text nakon dodavanja recenzenata");
	}

}
