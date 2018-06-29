package br.com.exemplo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.exemplo.json.model.PessoaDTO;
import br.com.exemplo.model.Pessoa;
import br.com.exemplo.repository.PessoaRepository;

@CrossOrigin(origins  = "http://localhost:4200")
@RestController
@RequestMapping("/service")
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@RequestMapping(value = "/pessoa", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody PessoaDTO salvar(@RequestBody Pessoa pessoa) {

		try {

			this.pessoaRepository.save(pessoa);

			return new PessoaDTO(1, "Registro salvo com sucesso!");

		} catch (Exception e) {

			return new PessoaDTO(0, e.getMessage());
		}
	}
	
	
	@RequestMapping(value="/pessoa", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody PessoaDTO atualizar(@RequestBody Pessoa pessoa){
 
		try {
 
			this.pessoaRepository.save(pessoa);		
 
			return new PessoaDTO(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new PessoaDTO(0,e.getMessage());
		}
	}
	
	

	@RequestMapping(value = "/pessoa", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Pessoa> consultar() {

		return this.pessoaRepository.findAll();
	}

	@RequestMapping(value = "/pessoa/{codigo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Pessoa buscar(@PathVariable("codigo") Integer codigo) {

		return this.pessoaRepository.findOne(codigo);
	}
	
	@RequestMapping(value = "/pessoa/{codigo}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody PessoaDTO excluir(@PathVariable("codigo") Integer codigo) {

		Pessoa pessoa = pessoaRepository.findOne(codigo);

		try {

			pessoaRepository.delete(pessoa);

			return new PessoaDTO(1, "Registro excluido com sucesso!");

		} catch (Exception e) {
			return new PessoaDTO(0, e.getMessage());
		}
	}



}
