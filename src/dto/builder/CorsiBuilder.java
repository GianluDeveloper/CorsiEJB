package dto.builder;

import dto.CorsiDto;
import model.Corsi;

public class CorsiBuilder {
	public static Corsi fromCorsiDtoToCorsi(CorsiDto dto) {
		Corsi c = new Corsi(dto.getIdCorso(),dto.getNomeCorso(),dto.getDataInizio(),dto.getDataFine());
		return c;
	}
	public static CorsiDto fromCorsiToCorsiDto(Corsi c) {
		CorsiDto dto = new CorsiDto(c.getIdCorso(),c.getNomeCorso(),c.getDataInizio(),c.getDataFine());
		return dto;
	}
}
