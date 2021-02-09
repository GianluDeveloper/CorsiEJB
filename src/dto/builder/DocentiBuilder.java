package dto.builder;

import dto.DocentiDto;
import model.Docenti;

public class DocentiBuilder {
	public static Docenti fromDocentiDtoToDocenti(DocentiDto dto) {
		Docenti c = new Docenti(dto.getIdDocente(),dto.getIdCorso(),dto.getNomeDocente());
		return c;
	}
	public static DocentiDto fromDocentiToDocentiDto(Docenti c) {
		DocentiDto dto = new DocentiDto(c.getIdDocente(),c.getIdCorso(),c.getNomeDocente());
		return dto;
	}
}
