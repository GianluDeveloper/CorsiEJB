package dto.builder;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import dto.CorsiDto;
import model.Corsi;
import model.Docenti;
import model.Iscrizioni;
import util.DateHandler;

public class CorsiBuilder {
	public static Corsi fromCorsiDtoToCorsi(CorsiDto dto) throws ParseException {
		List<Iscrizioni> listaVuota = new ArrayList<>();
		List<Docenti> docenti = new ArrayList<>();

		if(dto.getDataFine()==null) {
			dto.setDataFine("12/12/2012");
		}
		if(dto.getDataInizio()==null) {
			dto.setDataInizio("12/12/2012");
		}
		Corsi c = new Corsi(dto.getIdCorso(), DateHandler.toSql(dto.getDataInizio()),
				DateHandler.toSql(dto.getDataFine()), dto.getNomeCorso(), docenti, listaVuota);
		return c;
	}

	public static CorsiDto fromCorsiToCorsiDto(Corsi c) throws ParseException {
		CorsiDto dto = new CorsiDto(c.getIdCorso(), c.getNomeCorso(), DateHandler.fromUtil(c.getDataInizio()),
				DateHandler.fromUtil(c.getDataFine()));
		return dto;
	}
}
