package mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import dto.AutoreDTO;
import dto.LibroDTO;
import model.Autore;
import model.Libro;


@Mapper(componentModel = "cdi")
public interface AutoreMapper {
	
	AutoreMapper INSTANCE = Mappers.getMapper( AutoreMapper.class );
	
	@IterableMapping(qualifiedByName="mapWithoutLibri")
	List<AutoreDTO> mapToAutoreDto(List<Autore> autore);

	@Named("mapWithoutLibri")
	@Mapping(target="libri", ignore = true)
	AutoreDTO mapToDto(Autore autore);

	@Mapping(target = "id", ignore = true)
	Autore mapToEntity(AutoreDTO autoreDto);	

	Autore mapToEntitywithId(AutoreDTO autoreDto);

	@Mapping(target = "autore", ignore = true)
	Libro map(LibroDTO dto);


}
