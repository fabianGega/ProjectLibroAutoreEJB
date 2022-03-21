package mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import dto.LibroDTO;
import model.Libro;

@Mapper(componentModel = "cdi")
public interface LibroMapper {
	
	LibroMapper INSTANCE = Mappers.getMapper(LibroMapper.class);
	
	@IterableMapping(qualifiedByName="mapToLibroDto")
	List<LibroDTO> mapToLibriDto(List<Libro> libro);

	@Named("mapToLibroDto")
	@Mapping(target="autore", ignore=true)
	LibroDTO mapToLibroDto(Libro libro);
	
	Libro mapToLibroEntity(LibroDTO libroDto);

}
