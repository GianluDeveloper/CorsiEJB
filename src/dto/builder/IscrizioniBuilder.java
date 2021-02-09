package dto.builder;

import dto.IscrizioniDto;
import model.Iscrizioni;

public class IscrizioniBuilder {
	public static Iscrizioni fromIscrizioniDtoToIscrizioni(IscrizioniDto dto) {
		Iscrizioni c = new Iscrizioni(dto.getIdIscrizione(), dto.getIdDipendente(), dto.getIdDocente(),
				dto.getIdCorso());
		return c;
	}

	public static IscrizioniDto fromIscrizioniToIscrizioniDto(Iscrizioni c) {
		IscrizioniDto dto = new IscrizioniDto(c.getIdIscrizione(), c.getIdDipendente(), c.getIdDocente(),
				c.getIdCorso());
		return dto;
	}
}
