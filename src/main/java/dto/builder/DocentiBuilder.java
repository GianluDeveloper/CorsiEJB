package dto.builder;

import java.util.ArrayList;
import java.util.List;

import dto.DocentiDto;
import model.Corsi;
import model.Docenti;
import model.Iscrizioni;

public class DocentiBuilder {
	public static Docenti fromDocentiDtoToDocenti(DocentiDto dto) {
		Corsi nCorso = new Corsi();
		nCorso.setIdCorso(dto.getIdCorso());
		List<Iscrizioni> listaVuota = new ArrayList<>();
		
		Docenti c = new Docenti(dto.getIdDocente(),dto.getNomeDocente(),nCorso,listaVuota);
		return c;
	}
	public static DocentiDto fromDocentiToDocentiDto(Docenti c) {
		DocentiDto dto = new DocentiDto(c.getIdDocente(),c.getCorsi().getIdCorso(),c.getNomeDocente());
		return dto;
	}
}
