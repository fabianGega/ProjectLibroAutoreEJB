package service;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import dto.AutoreDTO;

@Local
@Stateless
public interface IService2Local {
	public List<AutoreDTO> findAll();
}
