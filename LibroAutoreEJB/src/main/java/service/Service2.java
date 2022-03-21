package service;

import java.util.List;

import javax.inject.Inject;

import dao.AutoreDao;
import dto.AutoreDTO;
import mapper.AutoreMapper;

public class Service2 implements IService2Local{
	
	@Inject
	AutoreDao autoreDao;

	@Override
	public List<AutoreDTO> findAll() {
		List<AutoreDTO> autoriDto = AutoreMapper.INSTANCE.mapToAutoreDto(autoreDao.findAll());
		
		return autoriDto;
	}

}
