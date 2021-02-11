package dto.builder;

import dto.DocentiDto;
import model2.Docenti;
import model2.Corsi;

public class DocentiBuilder {
	public static Docenti fromDocentiDtoToDocenti(DocentiDto dto) {
		Corsi nCorso = new Corsi();
		nCorso.setIdCorso(dto.getIdCorso());
		
		Docenti c = new Docenti(dto.getIdDocente(),dto.getNomeDocente(),nCorso,null);
		return c;
	}
	public static DocentiDto fromDocentiToDocentiDto(Docenti c) {
		DocentiDto dto = new DocentiDto(c.getIdDocente(),c.getCorsi().getIdCorso(),c.getNomeDocente());
		return dto;
	}
}
