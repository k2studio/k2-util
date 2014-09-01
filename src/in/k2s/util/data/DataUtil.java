package in.k2s.util.data;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DataUtil {

	public static final long UM_MINUTO = 60000;
	public static final long UMA_HORA  = UM_MINUTO * 60;
	public static final long UM_DIA    = UMA_HORA * 24;
	
	
	public static Time getTime() {
		return getTime(getTimestamp());
	}
	
	public static Time getTime(Timestamp arg0) {
		return getTime(arg0.getTime());
	}
	
	public static Time getTime(int hora, int minuto) {
		return getTime(hora, minuto, 0);
	}
	
	public static Time getTime(int hora, int minuto, int segundo) {
		Calendar c = GregorianCalendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, hora);
		c.set(Calendar.MINUTE, minuto);
		c.set(Calendar.SECOND, segundo);
		c.set(Calendar.MILLISECOND, 0);
		return getTime(c.getTimeInMillis());
	}
	
	public static Time getTime(long arg0) {
		return new Time(arg0);
	}
	
	/**
	 * Adiciona dia, hora, minuto a data atual.
	 * @param dtAtual A data que sera acrescentada.
	 * @param qtAcrescimento Valor a ser acrescentado.
	 * @return Retorna um Timestamp com a nova data.
	 */
	public static Timestamp addData(Timestamp dtAtual, long qtAcrescimento) {
		return new Timestamp(dtAtual.getTime() + qtAcrescimento);
	}
	
	/**
	 * Retorna o dia da semana de uma determinada data.
	 * @param data long de onde sera extraida o dia da semana.
	 * @return Retorna um int que representa o dia da semana, sendo 1 domingo.
	 */
	public static Integer getDiaSemana(long data) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTimeInMillis(data);
		return cal.get(GregorianCalendar.DAY_OF_WEEK);
	}
	
	/**
	 * Retorna o dia da mes de uma determinada data.
	 * @param data long de onde sera extraida o dia da semana.
	 * @return Retorna um int que representa o dia da semana, sendo 1 domingo.
	 */
	public static Integer getDiaMes(long data) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTimeInMillis(data);
		return cal.get(GregorianCalendar.DAY_OF_MONTH);
	}
	
	/**
	 * Retorna o dia da mes de uma determinada data.
	 * @param data long de onde sera extraida o dia da semana.
	 * @return Retorna um int que representa o dia da semana, sendo 1 domingo.
	 */
	public static Integer getDiaAno(long data) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTimeInMillis(data);
		return cal.get(GregorianCalendar.DAY_OF_YEAR);
	}
	
	/**
	 * Retorna o dia da semana de uma determinada data.
	 * @param data long de onde sera extraida o dia da semana.
	 * @return Retorna um DiaSemana.
	 */
	public static DiaSemana getDiaSemanaEnum(Timestamp data) {
		return getDiaSemanaEnum(data.getTime());
	}
	
	/**
	 * Retorna o dia da semana de uma determinada data.
	 * @param data long de onde sera extraida o dia da semana.
	 * @return Retorna um DiaSemana.
	 */
	public static DiaSemana getDiaSemanaEnum(Date data) {
		return getDiaSemanaEnum(data.getTime());
	}
	
	
	/**
	 * Retorna o dia da semana de uma determinada data.
	 * @param data long de onde sera extraida o dia da semana.
	 * @return Retorna um DiaSemana.
	 */
	public static DiaSemana getDiaSemanaEnum(long data) {
		Integer diaSemana = getDiaSemana(data);
		if(diaSemana == 1) {
			return DiaSemana.DOMINGO;
		} else if(diaSemana == 2)  {
			return DiaSemana.SEGUNDA;
		} else if(diaSemana == 3)  {
			return DiaSemana.TERCA;
		} else if(diaSemana == 4)  {
			return DiaSemana.QUARTA;
		} else if(diaSemana == 5)  {
			return DiaSemana.QUINTA;
		} else if(diaSemana == 6)  {
			return DiaSemana.SEXTA;
		} else if(diaSemana == 7)  {
			return DiaSemana.SABADO;
		} else {
			return null;
		}
	}
	
	
	/**
	 * Retorna o dia da semana de uma determinada data.
	 * @param data Date de onde sera extraida o dia da semana.
	 * @return Retorna um int que representa o dia da semana, sendo 1 domingo.
	 */
	public static Integer getDiaSemana(Date data){
		return getDiaSemana(data.getTime());
	}

	/**
	 * Retorna o dia da semana de um determinada data.
	 * @param data Timestamp de onde sera extraida o dia da semana.
	 * @return Retorna um int que representa o dia da semana, sendo 1 domingo.
	 */
	public static Integer getDiaSemana(Timestamp data){
		return getDiaSemana(data.getTime());
	}
	
	
	/**
	 * Retorna a data atual, incluindo as horas, minutos e segundos.
	 * @return Retorna um Timestamp da data atual.
	 */
	public static Timestamp getTimestamp(){
		return new Timestamp(System.currentTimeMillis());
	}
	
	/**
	 * Retorna a hora zero de uma determinada data.
	 * @return Retorna a data zero do dia atual
	 */
	public static Timestamp getTimestamp(Timestamp dtAtual){
		return new Timestamp(dtAtual.getTime());
	}
	
	/**
	 * Retorna a hora zero de uma determinada data.
	 * @return Retorna a data zero do dia atual
	 */
	public static Timestamp getData(){
		return getData(new Timestamp(System.currentTimeMillis()));
	}
	
	/**
	 * Retorna a hora zero de uma determinada data.
	 * @param data Data de onde sera extraida a hora zero.
	 * @return Retorna a data informada com a hora, minuto e segundo zerados.
	 */
	public static Timestamp getData(Timestamp data) throws IllegalArgumentException {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setLenient(false);
		
		cal.setTimeInMillis(data.getTime());
		cal.set(GregorianCalendar.HOUR_OF_DAY, 0);
		cal.set(GregorianCalendar.MINUTE, 0);
		cal.set(GregorianCalendar.SECOND, 0);
		cal.set(GregorianCalendar.MILLISECOND, 0);

		return new Timestamp(cal.getTimeInMillis());
	}
	
	/**
	 * Instancia um Timestamp baseado na data passada. Padrão: dd/mm/yyyy. Mês de 1-12
	 * Obs: O objeto retornara com a hora corrente.
	 * @param ano
	 * @param mes
	 * @param dia
	 * @return
	 */
	public static Timestamp getTimestamp(String data) throws IllegalArgumentException {
		String[] split = data.split("/");
		Integer dia = Integer.parseInt(split[0]);
		Integer mes = Integer.parseInt(split[1]);
		Integer ano = Integer.parseInt(split[2]);
		return DataUtil.getTimestamp(ano, mes, dia);
	}
	
	/**
	 * Instancia um Timestamp baseado nos parametros informados.
	 * Obs: O objeto retornara com a hora corrente.
	 * @param ano
	 * @param mes
	 * @param dia
	 * @return
	 */
	public static Timestamp getTimestamp(Integer ano, Integer mes, Integer dia) throws IllegalArgumentException {
		return DataUtil.getTimestamp(ano, mes, dia, 0, 0);
	}
	
	/**
	 * Instancia um Timestamp baseado nos parametros informados.
	 * @param ano
	 * @param mes
	 * @param dia
	 * @param hora
	 * @param minuto
	 * @return
	 */
	public static Timestamp getTimestamp(Integer ano, Integer mes, Integer dia, Integer hora, Integer minuto) throws IllegalArgumentException {
		Calendar cal = GregorianCalendar.getInstance();
		if(mes > 0) mes--;
		cal.set(Calendar.YEAR, ano);
		cal.set(Calendar.MONTH, mes);
		cal.set(Calendar.DAY_OF_MONTH, dia);
		cal.set(Calendar.HOUR_OF_DAY, hora);
		cal.set(Calendar.MINUTE, minuto);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return new Timestamp(cal.getTimeInMillis());
	}
	
	/**
	 * Instancia um Timestamp com a data do primeiro Domingo ANTERIOR ao dia atual.
	 * @param dtAtual
	 * @return
	 */
	public static Timestamp getDataInicioSemana(Timestamp data) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTimeInMillis(data.getTime());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.clear(Calendar.MINUTE);
		cal.clear(Calendar.SECOND);
		cal.clear(Calendar.MILLISECOND);
		cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
		cal.add(Calendar.DAY_OF_YEAR, -1);
		data = new Timestamp(cal.getTimeInMillis());
		return data;
	}

	/**
	 * Instancia um Timestamp com a data do primeiro Sabado POSTERIOR ao dia atual.
	 * @param dtAtual
	 * @return
	 */
	public static Timestamp getDataFinalSemana(Timestamp data) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTimeInMillis(getDataInicioSemana(data).getTime());
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		cal.add(Calendar.DAY_OF_MONTH, 6);
		data = new Timestamp(cal.getTimeInMillis());
		return data;
	}

	/**
	 * Instancia um Timestamp com a data do primeiro dia do mes enviado.
	 * @param data
	 * @return
	 */
	public static Timestamp getDataInicioMes(Timestamp data) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTimeInMillis(data.getTime());
		cal.set(Calendar.DAY_OF_MONTH, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		return new Timestamp(cal.getTimeInMillis());
	}

	/**
	 * Instancia um Timestamp com a data do ultimo dia do mes enviado.
	 * @param dtAtual
	 * @return
	 */
	public static Timestamp getDataFinalMes(Timestamp data) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTimeInMillis(getDataInicioMes(data).getTime());
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.MILLISECOND, -1);
		return new Timestamp(cal.getTimeInMillis());
	}
	
	/**
	 * 
	 * @param data
	 * @return
	 */
	public static Integer getHora(Timestamp data){
		return getHora(data.getTime());
	}
	
	public static Integer getHora(Long data) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTimeInMillis(data);
		return cal.get(GregorianCalendar.HOUR_OF_DAY);
	}

	public static Integer getMinuto(Timestamp data) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTimeInMillis(data.getTime());
		return cal.get(GregorianCalendar.MINUTE);
	}
	
	public static String formataTimestamp(String timestamp) {
		if(timestamp != null && timestamp.length() > 10) {
			String[] data = timestamp.trim().split(" ");
			String[] dia = data[0].split("-");
			String[] hora = data[1].split(":");
			return dia[2] + "/" + dia[1] + "/" + dia[0] + " " + hora[0] + ":" + hora[1];
		}
		return "-";
	}
	
	/**
	 * Retorna uma data formatada no padrao DD/MM/YYYY
	 * @param data
	 * @return
	 */
	public static String formata(Timestamp data) {
		return DataUtil.formata(data, "dd/MM/yyyy");
	}
	
	public static String formata(Timestamp data, String pattern) {
		if(data == null) return null;
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(data);
	}
	
	public static Timestamp convert(String data) {
		if(data == null || data.length() == 0) return null;
		return DataUtil.convert(data, "dd/MM/yyyy");
	}
	
	public static Timestamp convert(String data, String pattern) {
		if(data == null || data.length() == 0) return null;
		DateFormat f = new SimpleDateFormat(pattern);
		Timestamp fData = null;
		try {
			fData = new Timestamp(f.parse(data).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fData;
	}
	
	@Deprecated
	public static Timestamp convertData(String data) {
		if(data == null || data.length() == 0) return null;
		if(data.indexOf(" ") != -1) {
			String[] dia  = data.split(" ")[0].split("/");
			String[] hora = data.split(" ")[1].split(":");
			return DataUtil.getTimestamp(new Integer(dia[2]), new Integer(dia[1]), new Integer(dia[0]), new Integer(hora[0]), new Integer(hora[1]));
		} else {
			String[] dia  = data.split("/");
			return DataUtil.getTimestamp(new Integer(dia[2]), new Integer(dia[1]), new Integer(dia[0]));
		}
	}
	
	public static String getData(Timestamp data, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(data);
	}
	
	public static Boolean isValid(String data) {
		if(data != null && (data.length() == 16 || data.length() == 10)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna a hora zero de uma determinada data.
	 * @param data Data de onde sera extraida a hora zero.
	 * @return Retorna a data informada com a hora, minuto e segundo zerados.
	 */
	public static Timestamp getDataHora(Timestamp data) throws IllegalArgumentException {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setLenient(false);
		
		cal.setTimeInMillis(data.getTime());
		cal.set(GregorianCalendar.MILLISECOND, 0);

		return new Timestamp(cal.getTimeInMillis());
	}
	
	/**
	 * Calcula o tempo entre duas datas
	 * @param dataInicial
	 * @param dataFinal
	 * @return
	 */
	public static Long diferenca(Timestamp dataInicial, Timestamp dataFinal) {
		return dataFinal.getTime() - dataInicial.getTime();
	}

}
