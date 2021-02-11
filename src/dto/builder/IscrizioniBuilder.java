package dto.builder;

import dto.IscrizioniDto;
import model.Corsi;
import model.Docenti;
import model.Iscrizioni;

public class IscrizioniBuilder {
	public static Iscrizioni fromIscrizioniDtoToIscrizioni(IscrizioniDto dto) {
		Docenti docenti = new Docenti();
		docenti.setIdDocente(dto.getIdDocente());
		Corsi corsi = new Corsi();
		corsi.setIdCorso(dto.getIdCorso());
		Iscrizioni c = new Iscrizioni(dto.getIdIscrizione(), dto.getIdDipendente(), corsi, docenti);
		return c;
	}

	public static IscrizioniDto fromIscrizioniToIscrizioniDto(Iscrizioni c) {
		IscrizioniDto dto = new IscrizioniDto(c.getIdIscrizione(), c.getIdDipendente(), c.getDocenti().getIdDocente(),
				c.getCorsi().getIdCorso());
		return dto;
	}
}
