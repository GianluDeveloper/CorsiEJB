package dto.builder;

import java.text.ParseException;

import dto.CorsiDto;
import model2.Corsi;
import util.DateHandler;

public class CorsiBuilder {
	public static Corsi fromCorsiDtoToCorsi(CorsiDto dto) throws ParseException {
		Corsi c = new Corsi(dto.getIdCorso(),DateHandler.toSql(dto.getDataInizio()),DateHandler.toSql(dto.getDataFine()),dto.getNomeCorso());
		return c;
	}
	public static CorsiDto fromCorsiToCorsiDto(Corsi c) throws ParseException  {
		CorsiDto dto = new CorsiDto(c.getIdCorso(),c.getNomeCorso(),DateHandler.fromUtil(c.getDataInizio()),DateHandler.fromUtil(c.getDataFine()));
		return dto;
	}
}
