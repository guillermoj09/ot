	package cl.samtech.ot.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import model.Device;
import model.Instalacion;
import model.Periferico;
import model.SamFichaHardware;
import model.Validacion;

public class ValidacionLogService {
	
	private static EntityManager em;
	private static EntityManager em1;

	
	final static Logger logger = Logger.getLogger(InstalacionService.class);
	
	public static Boolean createTablaValidacion(String idGps, String lineaLog, Long ot, String estado) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("otsamtechDB");
		em = emf.createEntityManager();
		boolean validador = true;
		try {
			Timestamp fecha = new Timestamp(System.currentTimeMillis());

			Validacion validacion = new Validacion();
			validacion.setIdGps(idGps);
			validacion.setLineaLog(lineaLog.trim());
			validacion.setOt(Long.valueOf(ot));
			validacion.setEstado(estado);
			validacion.setFechaHora(fecha);
			em.getTransaction().begin();
			em.persist(validacion);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.getMessage();
			validador = false;
		}

		return validador;
	}
	public static List<Periferico> findPerifericos(String idGps, Long id_insta){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("otsamtechDB");
		em1 = emf.createEntityManager();

		Query query = em1.createQuery("select p from Periferico p where p.idDevice = :id_gps and p.instalacion.id = :id_insta");
		query.setParameter("id_gps", idGps);
		query.setParameter("id_insta", id_insta);
		List<Periferico> listado = query.getResultList();
		return listado;
	}
	
	public static Boolean existePerifericos(String idGps, Long id_insta,Integer idsamficha){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("otsamtechDB");
		em1 = emf.createEntityManager();
		boolean validar = false;
		Query query = em1.createQuery("select p from Periferico p where p.idSamFichaHardware = :idsamficha and p.idDevice = :id_gps and p.instalacion.id = :id_insta");
		query.setParameter("id_gps", idGps);
		query.setParameter("id_insta", id_insta);
		query.setParameter("idsamficha", idsamficha);
		if(query.getResultList().size() > 0) {
			validar = true;
		}
		em1.clear();
		em1.close();
		return validar;
		
	}
	
	
	public static Boolean listadoPerifericos(String[] ListPeriferico,Device device,Instalacion instalacion) {
		
		for(int i= 0; i < ListPeriferico.length ;i++) {
			boolean validar;
			if(ListPeriferico[i].equals("14")) {
				validar = existePerifericos(device.getIdDevice(),instalacion.getId(),Integer.parseInt(ListPeriferico[i]));
				if(!validar) {
					addPerifericos("Ibutton",Integer.parseInt(ListPeriferico[i]), device.getIbutto(),device.getIdDevice(),"",device.getIdIbutto(),instalacion);
				}else {
					uptPerifericos("Ibutton",Integer.parseInt(ListPeriferico[i]), device.getIbutto(),device.getIdDevice(),"",device.getIdIbutto(),instalacion);
				}
			}else if(ListPeriferico[i].equals("12")) {
				validar = existePerifericos(device.getIdDevice(),instalacion.getId(),Integer.parseInt(ListPeriferico[i]));
				if(!validar) {
					addPerifericos("Corte Corriente",Integer.parseInt(ListPeriferico[i]), device.getCorteComb(),device.getIdDevice(),"","",instalacion);
				}else {
					uptPerifericos("Corte Corriente",Integer.parseInt(ListPeriferico[i]), device.getCorteComb(),device.getIdDevice(),"","",instalacion);

				}
			}else if(ListPeriferico[i].equals("10")) {
				validar = existePerifericos(device.getIdDevice(),instalacion.getId(),Integer.parseInt(ListPeriferico[i]));
				if(!validar) {
					addPerifericos("Sensor Temp",Integer.parseInt(ListPeriferico[i]), device.getStemp(),device.getIdDevice(),"","",instalacion);	
				}else {
					uptPerifericos("Sensor Temp",Integer.parseInt(ListPeriferico[i]), device.getStemp(),device.getIdDevice(),"","",instalacion);	

				}
			}else if(ListPeriferico[i].equals("9")) {
				validar = existePerifericos(device.getIdDevice(),instalacion.getId(),Integer.parseInt(ListPeriferico[i]));
				if(!validar) {
					addPerifericos("Tercer Ojo",Integer.parseInt(ListPeriferico[i]), device.getMobileye(),device.getIdDevice(),"","",instalacion);	
				}else {
					uptPerifericos("Tercer Ojo",Integer.parseInt(ListPeriferico[i]), device.getMobileye(),device.getIdDevice(),"","",instalacion);	

				}
			}else if(ListPeriferico[i].equals("11")) {
				//lector barra
				validar = existePerifericos(device.getIdDevice(),instalacion.getId(),Integer.parseInt(ListPeriferico[i]));
				if(!validar) {
					addPerifericos("Lector barra",Integer.parseInt(ListPeriferico[i]), device.getLbarra(),device.getIdDevice(),"",device.getIdLbarra(),instalacion);

				}else {
					uptPerifericos("Lector barra",Integer.parseInt(ListPeriferico[i]), device.getLbarra(),device.getIdDevice(),"",device.getIdLbarra(),instalacion);

				}
			}else if(ListPeriferico[i].equals("39")) {
				//lector barra
				validar = existePerifericos(device.getIdDevice(),instalacion.getId(),Integer.parseInt(ListPeriferico[i]));
				if(!validar) {
					addPerifericos("Horometro",Integer.parseInt(ListPeriferico[i]), device.getHorometro(),device.getIdDevice(),"","",instalacion);

				}else {
					uptPerifericos("Horometro",Integer.parseInt(ListPeriferico[i]), device.getHorometro(),device.getIdDevice(),"","",instalacion);

				}
			}else if(ListPeriferico[i].equals("37")) {
				//lector barra
				validar = existePerifericos(device.getIdDevice(),instalacion.getId(),Integer.parseInt(ListPeriferico[i]));
				if(!validar) {
					addPerifericos("Candado electronico",Integer.parseInt(ListPeriferico[i]), String.valueOf(device.getCandadoElect()),device.getIdDevice(),"","",instalacion);

				}else {
					uptPerifericos("Candado electronico",Integer.parseInt(ListPeriferico[i]), String.valueOf(device.getCandadoElect()),device.getIdDevice(),"","",instalacion);

				}
			}else if(ListPeriferico[i].equals("38")) {
				//lector barra
				validar = existePerifericos(device.getIdDevice(),instalacion.getId(),Integer.parseInt(ListPeriferico[i]));
				if(!validar) {
					addPerifericos("Contro jornada",Integer.parseInt(ListPeriferico[i]), device.getCjornada(),device.getIdDevice(),"","",instalacion);

				}else {
					uptPerifericos("Control jornada",Integer.parseInt(ListPeriferico[i]), device.getCjornada(),device.getIdDevice(),"","",instalacion);

				}
			}
			
		}
		return true;
	}
	
	public static Boolean addPerifericos(String nombre,Integer idSamFichaHardware,String modelo,String idDevice,String marca,String id_periferico,Instalacion instalacion) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("otsamtechDB");
		em1 = emf.createEntityManager();
		
		Periferico periferico = new Periferico();
		periferico.setModelo(modelo);
		periferico.setId_periferico(id_periferico);
		periferico.setIdSamFichaHardware(idSamFichaHardware);
		periferico.setIdDevice(idDevice);
		periferico.setMarca(marca);
		periferico.setNombre(nombre);
		instalacion.getId();
		periferico.setInstalacion(instalacion);
		em1.getTransaction().begin();
		em1.persist(periferico);
		em1.getTransaction().commit();
		
		return true;
	}
	
	public static Boolean uptPerifericos(String nombre,Integer idSamFichaHardware,String modelo,String idDevice,String marca,String id_periferico,Instalacion instalacion) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("otsamtechDB");
	em1 = emf.createEntityManager();
	Query query = em1.createQuery("select p from Periferico p where p.idSamFichaHardware = :idsamficha and p.idDevice = :id_gps and p.instalacion.id = :id_insta");
	query.setParameter("id_gps", idDevice);
	query.setParameter("id_insta", instalacion.getId());
	query.setParameter("idsamficha", idSamFichaHardware);
	
	Periferico periferico = (Periferico) query.getResultList().get(0);
	periferico.setModelo(modelo);
	periferico.setId_periferico(id_periferico);
	periferico.setIdSamFichaHardware(idSamFichaHardware);
	periferico.setIdDevice(idDevice);
	periferico.setMarca(marca);
	periferico.setNombre(nombre);
	instalacion.getId();
	periferico.setInstalacion(instalacion);
	em1.getTransaction().begin();
	em1.persist(periferico);
	em1.getTransaction().commit();
	
	return true;
}
	
	
	
	public static Boolean findValidacion(String idGps, Integer ot) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("otsamtechDB");
		em1 = emf.createEntityManager();

		boolean validador = true;
		Query query = em1.createQuery("select v from Validacion v where v.idGps = :id_gps and v.ot = :id_ot");
		query.setParameter("id_gps", idGps);
		query.setParameter("id_ot", ot);

		try {
			List results = query.getResultList();
			if (results.isEmpty()) {
				validador = false;
			}
		} catch (NoResultException e) {
			//System.out.println(e);
		}

		return validador;
	}
	
	public static String findModeloPer(String modelo, Integer ficha_har) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("otsamtechDB");
		
		em1 = emf.createEntityManager();
		Query query = em1.createQuery("select v.nombre from ModelosPeriferico v where v.idSamFichaHardware = :ficha_har and v.modelo = :modelo");
		query.setParameter("modelo", modelo);
		query.setParameter("ficha_har", ficha_har);
		Periferico per = null;
		String nombre;
		if(!query.getResultList().isEmpty()) {
			nombre = (String) query.getResultList().get(0);
		}else {
			nombre = "";
		}

		return nombre;
	}

	
	
	public static String validarGPS(String gps, Long ot, Integer folio, Integer anexo, String perifericos) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		Date hoy = new Date();

		String archivo = "/opt/temp/logtrax/" + formatter.format(hoy) + "/" +gps + "_" + formatter.format(hoy)+ ".txt";

		String tabla = "<div class='table-responsive'><table class='table table-striped table-bordered table-hover dataTables-example'>";
		tabla = tabla
				+ "<thead><tr><th align='center'>Validacion </th><th align='center'>Estado</th>	<th align='center'>Hora</th></tr></thead>"
				+ "<form action='completar.html' method='post'>";
		String texto = "";
		long cal = System.currentTimeMillis();
		long calNow = System.currentTimeMillis();
		long milliseconds = 0;
		//String archivo = "\\\\192.168.1.3\\log\\LOG_TRAX\\" + formatter.format(hoy) + "\\" + gps + "_"+ formatter.format(hoy) + ".txt";
		String result = "";
		String resultP = "";
		String cadena;
		List<SamFichaHardware> listFichaHardw = ClienteService.findAcessorios(folio, anexo);
	
		String prueba = "" ;
		
		List<String> log = new ArrayList();
		FileReader f;
		long totalHoras = 0;
		int validar = 0;
		int validarperifericos = 0;
		
		ArrayList<String> datoslinea = new ArrayList<String>();
		try {
			f = new FileReader(archivo);
			boolean gpsok = false;
			boolean canok = false;
			boolean ingok = false;
			boolean posok = false;
			boolean cigok = false;
			boolean senalok = false;
			boolean gprsok = false;
			boolean lonylat = false;
			int valtextcorte = 0;
			int valtextbtnpanico = 0;
			int valtextIbutton = 0;
			int valtextlectorbarra = 0;
			int valtextsnrtemp = 0;
			int valtextcan = 0;
			int valtexteqcam = 0;
			int valtextsnspuerta = 0;
			int valtextsnscinturon = 0;
			int valtexthorometro = 0;
			int valtextcontroljornada = 0;
			boolean horometro = false;
			boolean tercerojo = false;
			boolean btnpanico = false;
			boolean lectorbarra = false;
			boolean snstemperatura = false;
			boolean snspuertaoff = false;
			boolean snspuertaon = false;
			boolean cortemotoroff = false;
			boolean cortemotoron = false;
			boolean snscinturonon = false;
			boolean snscinturonoff = false;
			boolean controljornada = false;
			boolean eqsomAA = false;
			boolean eqsomA9 = false;
			boolean eqsomAC = false;

			int senal = 0;
			int gprs = 0;

			Integer lat = 0;
			Integer lon = 0;
			String temp = "";
			String fstr = "";
			Date d;
			boolean validaciones = false;
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  

			BufferedReader b = new BufferedReader(f);
			try {
				String evento = "";
				
				String parametros = "";
				String linea = "";
				boolean ibutton = false;
				while ((cadena = b.readLine()) != null) {
					String[] fc = cadena.split(" -- ");
					System.out.println(texto);
					prueba = "entro if";
					if (fc.length > 1) {

						fstr = fc[2] + " " + fc[3];
						try {
							prueba = "aa";
							d = sdf.parse(fstr);
							milliseconds = d.getTime();
							
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						totalHoras = ((calNow - milliseconds) / 1000 / 60 / 60);
						
						if (totalHoras < 2) {
							String[] parts = cadena.split(">");
							String part2 = parts[1];
							linea = part2;
							
							if(part2.substring(0, 5).equals("RUS06")) {
								String[] partes = part2.split(",");	
								if(partes[1].substring(0,8).equals("$T1:--.-") && partes[2].equals("") ) {
									parametros =  partes[3];
								}else if(!partes[1].substring(3,8).equals("")) {
									parametros =  partes[2];
								}else if(!partes[1].equals("") && !partes[2].equals("") ) {
									parametros =  partes[3];
								}
							}
							
							
							if (part2.substring(0, 3).equals("RPI") && !gpsok) {

								gpsok = true;
								// public static Boolean
								// createTablaValidacion(String idGps,String
								// lineaLog,Integer ot,Integer
								// tipoValidacion,String estado){
								texto = texto + "<tr>";
								texto = texto + "<td><b>GPS</b></td>";
								texto = texto + "<input type='hidden' name='gps' value='" + linea + "'>";
								texto = texto + "<td><b><button class='btn btn-info btn-circle' type='button' title='"
										+ part2 + "'><i class='fa fa-check'></i> </button></b></td>";
								texto = texto + "<td>" + fstr + "</td>";
								texto = texto + "</tr>";
								result = result + texto;
								texto = "";
								validar++;
							}

							if (part2.contains("F18") && !ingok) {

								ingok = true;
								texto = texto + "<tr>";
								texto = texto + "<td><b>IGNICION</b></td>";
								texto = texto + "<input type='hidden' name='ignicion' value='" + linea + "'>";
								texto = texto + "<td><b><button class='btn btn-info btn-circle' type='button' title='"
										+ part2 + "'><i class='fa fa-check'></i> </button></b></td>";
								texto = texto + "<td>" + fstr + "</td>";
								texto = texto + "</tr>";
								result = result + texto;
								texto = "";
								validar++;

							}
							if (part2.substring(64, 67).equals(("F19")) && !cigok) {
								cigok = true;
								texto = texto + "<tr>";
								texto = texto + "<td><b>CORTE IGNICION</b></td>";
								texto = texto + "<input type='hidden' name='corte' value='" + linea + "' >";
								texto = texto + "<td><b><button class='btn btn-info btn-circle' type='button' title='"
										+ part2 + "'><i class='fa fa-check'></i> </button></b></td>";
								texto = texto + "<td>" + fstr + "</td>";
								texto = texto + "</tr>";
								result = result + texto;
								texto = "";
								validar++;

							}

							if (part2.contains("F46") && !posok) {
								posok = true;
								texto = texto + "<tr>";
								texto = texto + "<td><b>POS</b></td>";
								texto = texto + "<input type='hidden' name='pos' value='" + linea + "'> ";
								texto = texto + "<td><b><button class='btn btn-info btn-circle' type='button' title='"
										+ part2 + "'><i class='fa fa-check'></i> </button></b>"
												+ "</td>";
								texto = texto + "<td>" + fstr + "</td>";
								texto = texto + "</tr>";
								result = result + texto;
								texto = "";
								validar++;
							}

							if (part2.contains("F46") && !gprsok) {
								temp = part2.substring(54, 58);
								if(part2.substring(0, 5).equals("RUS06")) {
									gprs = Integer.parseInt(parametros.substring(38, 42));
								}
								if(part2.substring(0, 3).equals("RPI")) {
									
									gprs = Integer.parseInt(part2.substring(41, 45));
								}
								
								if (gprs == 0) {
									texto = texto + "<tr>";
									texto = texto + "<td><b>GPRS</b></td>";
									texto = texto + "<input type='hidden' name='gprs' value='" + linea + "'>";
									texto = texto
											+ "<td><b><button class='btn btn-info btn-circle' type='button' title='"
											+ part2 + "'><i class='fa fa-check'></i> </button></b></td>";
									texto = texto + "<td>" + fstr + "</td>";
									texto = texto + "</tr>";
									result = result + texto;
									texto = "";
									validar++;
									gprsok = true;
								}
								gprs = 0;
							}
							if (part2.contains("F46") && !lonylat) {
								
								if(part2.substring(0, 5).equals("RUS06")) {
									temp = part2.substring(16, 23);
									temp = part2.substring(24, 32);
									lat = Integer.parseInt(parametros.substring(13, 20));
									lon = Integer.parseInt(parametros.substring(22,28));
								}
								if(part2.substring(0, 3).equals("RPI")) {
									lat = Integer.parseInt(part2.substring(16, 23));
									lon = Integer.parseInt(part2.substring(24, 32));
								}
								if (lat > 0 && lon > 0) {
									texto = texto + "<tr>";
									texto = texto + "<td><b>LATITUD Y LONGITUD</b></td>";
									texto = texto + "<input type='hidden' name='latylon' value='" + linea + "'> ";
									texto = texto
											+ "<td><b><button class='btn btn-info btn-circle' type='button' title='"
											+ part2 + "'><i class='fa fa-check'></i> </button></b></td>";
									texto = texto + "<td>" + fstr + "</td>";
									texto = texto + "</tr>";
									result = result + texto;
									texto = "";
									validar++;
									lonylat = true;
								}
								lat = 0;
								lon = 0;
							}

							if (part2.contains("F46") && !senalok) {
								if(part2.substring(0, 5).equals("RUS06")) {
									senal = Integer.parseInt(parametros.substring(36, 38));
									
								}
								if(part2.substring(0, 3).equals("RPI")) {
									senal = Integer.parseInt(part2.substring(39, 41));
								}							
								//temp = part2.substring(39, 41);
								//senal = Integer.parseInt(part2.substring(39, 41));
								if (senal > 4) {
									
									texto = texto + "<tr>";
									texto = texto + "<input type='hidden' name='senal' value='" + linea + "' >";
									texto = texto + "<td><b>SEÑAL</b></td>";
									texto = texto
											+ "<td><b><button class='btn btn-info btn-circle' type='button' title='"
											+ part2 + "'><i class='fa fa-check'></i> </button></b></td>";
									texto = texto + "<td>" + fstr + "</td>";
									texto = texto + "</tr>";
									result = result + texto;
									texto = "";
									validar++;
									senalok = true;

								}
								senal =0;	
							}
							if (listFichaHardw != null || !listFichaHardw.isEmpty()) {
								
								for (SamFichaHardware sf : listFichaHardw) {
									
									if (sf.getFhHarCodigo() == 15) {
										valtextcan = sf.getFhHarCodigo();
										if (part2.substring(0, 5).equals("RUS08") && part2.substring(7, 9).equals("DA")
												&& !canok) {
											canok = true;
											texto = texto + "<tr>";
											texto = texto + "<td><b>CAN</b></td>";
											texto = texto
													+ "<td><b><button class='btn btn-info btn-circle' type='button' title='"
													+ part2 + "'><i class='fa fa-check'></i> </button></b>"
															+ "<input type='hidden' value='15' name='NamesListPerifericos'>"
															+ "</td>";
											texto = texto + "<td>" + fstr + "</td>";
											texto = texto + "</tr>";
											resultP = resultP + texto;
											texto = "";
										}
									} else if (sf.getFhHarCodigo() == 26 && (!eqsomAA || !eqsomAC || !eqsomA9)) {
										valtexteqcam = sf.getFhHarCodigo();
										if (part2.substring(65, 67).equals("AA") && !eqsomAA) {
											eqsomAA = true;
										} else if (part2.substring(65, 67).equals("AC") && !eqsomAC) {
											eqsomAC = true;
										} else if (part2.substring(65, 67).equals("A9") && !eqsomA9) {
											eqsomA9 = true;
										}
										if (eqsomA9 && eqsomAA && eqsomAC) {
											texto = texto + "<tr>";
											texto = texto + "<td><b>Camara Somnolencia</b></td>";
											texto = texto
													+ "<td><b><button class='btn btn-info btn-circle' type='button' title='"
													+ part2 + "'><i class='fa fa-check'></i></button></b>"
															+ "<input type='hidden' value='26' name='NamesListPerifericos'>"
															+ "</td>";
											texto = texto + "<td>" + fstr + "</td>";
											texto = texto + "</tr>";
											resultP = resultP + texto;
											texto = "";
										}
									} else if (sf.getFhHarCodigo() == 14 && !ibutton) {
										valtextIbutton = sf.getFhHarCodigo();
										if (part2.substring(0, 5).equals("RUS02")) {
											ibutton = true;
											texto = texto + "<tr>";
											texto = texto + "<td><b>Ibutton</b></td>";
											texto = texto
													+ "<td><b><button class='btn btn-info btn-circle' type='button' title='"
													+ part2 + "'><i class='fa fa-check'></i> </button></b>"
															+ "<input type='hidden' value='14' name='NamesListPerifericos'>"
															+ "</td>";
											texto = texto + "<td>" + fstr + "</td>";
											texto = texto + "</tr>";
											resultP = resultP + texto;
											texto = "";
										}
									}else if (sf.getFhHarCodigo() == 11 && !lectorbarra) {
										valtextlectorbarra = sf.getFhHarCodigo();
										if (part2.substring(0, 5).equals("RUS02")) {
											lectorbarra = true;
											texto = texto + "<tr>";
											texto = texto + "<td><b>Lector barra</b></td>";
											texto = texto
													+ "<td><b><button class='btn btn-info btn-circle' type='button' title='"
													+ part2 + "'><i class='fa fa-check'></i> </button></b>"
															+ "<input type='hidden' value='11' name='NamesListPerifericos'>"
															+ "</td>";
											texto = texto + "<td>" + fstr + "</td>";
											texto = texto + "</tr>";
											resultP = resultP + texto;
											texto = "";
										}
									}else if (sf.getFhHarCodigo() == 13 && !btnpanico) {
										valtextbtnpanico = sf.getFhHarCodigo();
										if (part2.substring(64, 67).equals(("F23"))) {
											btnpanico = true;
											texto = texto + "<tr>";
											texto = texto + "<td><b>Boton de panico</b></td>";
											texto = texto
													+ "<td><b><button class='btn btn-info btn-circle' type='button' title='"
													+ part2 + "'><i class='fa fa-check'></i> </button></b>"
															+ "<input type='hidden' value='13' name='NamesListPerifericos'>"
															+ "</td>";
											texto = texto + "<td>" + fstr + "</td>";
											texto = texto + "</tr>";
											resultP = resultP + texto;
											texto = "";
										}		
									}else if (sf.getFhHarCodigo() == 10 && !snstemperatura) {
									
										valtextsnrtemp = sf.getFhHarCodigo();
										if (part2.substring(0, 5).equals("RUS06")) {
											snstemperatura = true;
											texto = texto + "<tr>";
											texto = texto + "<td><b>Sensor de Temperatura</b></td>";
											texto = texto
													+ "<td><b><button class='btn btn-info btn-circle' type='button' title='"
													+ part2 + "'><i class='fa fa-check'></i></button></b>"
															+ "<input type='hidden' value='10' name='NamesListPerifericos'>"
															+ "</td>";
											texto = texto + "<td>" + fstr + "</td>";
											texto = texto + "</tr>";
											resultP = resultP + texto;
											texto = "";

										}
									} else if (sf.getFhHarCodigo() == 17 && (!snspuertaoff || !snspuertaon)) {
										valtextsnspuerta = sf.getFhHarCodigo();
										if (part2.substring(65, 67).equals(("25")) && !snspuertaon) {
											cortemotoron = true;
										} else if (part2.substring(65, 67).equals(("26")) && !snspuertaoff) {
											cortemotoroff = true;
										}
										if (snspuertaon && snspuertaoff) {
											texto = texto + "<tr>";
											texto = texto + "<td><b>Sensor Puerta</b></td>";
											texto = texto
													+ "<td><b><button class='btn btn-info btn-circle' type='button' title='"
													+ part2 + "'><i class='fa fa-check'></i></button></b>"
															+ "<input type='hidden' value='17' name='NamesListPerifericos'>"
															+ "</td>";
											texto = texto + "<td>" + fstr + "</td>";
											texto = texto + "</tr>";
											resultP = resultP + texto;
											texto = "";
										}
					
									} else if (sf.getFhHarCodigo() == 12 && (!cortemotoron || !cortemotoroff)) {
										valtextcorte = sf.getFhHarCodigo();
										temp = part2.substring(65, 67);
										if (part2.substring(65, 67).equals(("F8")) && !cortemotoron) {
											cortemotoron = true;
										} else if (part2.substring(65, 67).equals(("F9")) && !cortemotoroff) {
											cortemotoroff = true;
										}
										if (cortemotoroff && cortemotoron) {
											texto = texto + "<tr>";
											texto = texto + "<td><b>Corte Corriente</b></td>";
											texto = texto
													+ "<td><b><button class='btn btn-info btn-circle' type='button' title='"
													+ part2 + "'><i class='fa fa-check'></i></button></b>"
															+ "<input type='hidden' value='12' name='NamesListPerifericos'>"
															+ "</td>";
											texto = texto + "<td>" + fstr + "</td>";
											texto = texto + "</tr>";
											resultP = resultP + texto;
											texto = "";
										}
									}else if (sf.getFhHarCodigo() == 38 && !controljornada ) {										
										valtextcontroljornada = sf.getFhHarCodigo();
										if (part2.substring(0, 5).equals("RUS07")) {
											controljornada = true;
											texto = texto + "<tr>";
											texto = texto + "<td><b>Control Jornada</b></td>";
											texto = texto
													+ "<td><b><button class='btn btn-info btn-circle' type='button' title='"
													+ part2 + "'><i class='fa fa-check'></i></button></b>"
															+ "<input type='hidden' value='38' name='NamesListPerifericos'>"
															+ "</td>";
											texto = texto + "<td>" + fstr + "</td>";
											texto = texto + "</tr>";
											resultP = resultP + texto;
											texto = "";

										}
									}else if (sf.getFhHarCodigo() == 39 && !horometro ) {										
										valtexthorometro = sf.getFhHarCodigo();
										if (part2.substring(0, 4).equals("RUS9")) {
											horometro = true;
											texto = texto + "<tr>";
											texto = texto + "<td><b>Horometro</b></td>";
											texto = texto
													+ "<td><b><button class='btn btn-info btn-circle' type='button' title='"
													+ part2 + "'><i class='fa fa-check'></i></button></b>"
															+ "<input type='hidden' value='39' name='NamesListPerifericos'>"
															+ "</td>";
											texto = texto + "<td>" + fstr + "</td>";
											texto = texto + "</tr>";
											resultP = resultP + texto;
											texto = "";

										}
									}
								}
							}
						}
					}

				} // end while

				if (!gpsok) {
					result = "No hay eventos";
				} else {
					if (!senalok) {
						texto = texto + "<tr>";
						texto = texto + "<td><b>SEÑAL</b></td>";
						texto = texto + "<td><b><button class='btn btn-danger btn-circle' type='button' title='" + linea
								+ "'><i class='fa fa-times'></i> </button></b></td>";
						texto = texto + "<td>" + fstr + "</td>";
						texto = texto + "</tr>";
						result = result + texto;
						texto = "";
					}
					if (!posok) {
						texto = texto + "<tr>";
						texto = texto + "<td><b>POS</b></td>";
						texto = texto + "<td><b><button class='btn btn-danger btn-circle' type='button' title='" + linea
								+ "'><i class='fa fa-times'></i> </button></b></td>";
						texto = texto + "<td>" + fstr + "</td>";
						texto = texto + "</tr>";
						result = result + texto;
						texto = "";
					}
					if (!gprsok) {
						texto = texto + "<tr>";
						texto = texto + "<td><b>GPRS</b></td>";
						texto = texto + "<td><b><button class='btn btn-danger btn-circle' type='button' title='" + linea
								+ "'><i class='fa fa-times'></i> </button></b></td>";
						texto = texto + "<td>" + fstr + "</td>";
						texto = texto + "</tr>";
						result = result + texto;
						texto = "";
					}
					if (!lonylat) {
						texto = texto + "<tr>";
						texto = texto + "<td><b>LATITUD Y LONGITUD</b></td>";
						texto = texto + "<td><b><button class='btn btn-danger btn-circle' type='button' title='" + linea
								+ "'><i class='fa fa-times'></i> </button></b></td>";
						texto = texto + "<td>" + fstr + "</td>";
						texto = texto + "</tr>";
						result = result + texto;
						texto = "";
					}
					if (!cigok) {
						texto = texto + "<tr>";
						texto = texto + "<td><b>CORTE IGNICION</b></td>";
						texto = texto + "<td><b><button class='btn btn-danger btn-circle' type='button' title='" + linea
								+ "'><i class='fa fa-times'></i> </button></b></td>";
						texto = texto + "<td>" + fstr + "</td>";
						texto = texto + "</tr>";
						result = result + texto;
						texto = "";
					}
					if (!ingok) {
						texto = texto + "<tr>";
						texto = texto + "<td><b>IGNICION</b></td>";
						texto = texto + "<td><b><button class='btn btn-danger btn-circle'  type='button' title='"
								+ linea + "'><i class='fa fa-times'></i> </button></b></td>";
						texto = texto + "<td>" + fstr + "</td>";
						texto = texto + "</tr>";
						result = result + texto;
						texto = "";
					}
					if (valtextcan == 15 && !canok) {
						texto = texto + "<tr>";
						texto = texto + "<td><b>CAN</b></td>";
						texto = texto + "<td><b><button class='btn btn-danger btn-circle'  type='button' title='"
								+ linea + "'><i class='fa fa-times'></i> </button></b></td>";
						texto = texto + "<td>" + fstr + "</td>";
						texto = texto + "</tr>";
						resultP = resultP + texto;
						texto = "";
					}
					if (valtextcontroljornada == 38 && !controljornada) {
						texto = texto + "<tr>";
						texto = texto + "<td><b>Control jornada</b></td>";
						texto = texto + "<td><b><button class='btn btn-danger btn-circle'  type='button' title='"
								+ linea + "'><i class='fa fa-times'></i> </button></b></td>";
						texto = texto + "<td>" + fstr + "</td>";
						texto = texto + "</tr>";
						resultP = resultP + texto;
						texto = "";
					}
					if (valtexteqcam == 26 && (!eqsomA9 || !eqsomAA || !eqsomAC)) {
					
						texto = texto + "<tr>";
						texto = texto + "<td><b>Camara Somnolencia</b></td>";
						texto = texto + "<td><b><button class='btn btn-danger btn-circle'  type='button' title='"
								+ linea + "'><i class='fa fa-times'></i> </button></b></td>";
						texto = texto + "<td>" + fstr + "</td>";
						texto = texto + "</tr>";
						resultP = resultP + texto;
						texto = "";
					
					}
					if (valtextIbutton == 14 && !ibutton) {
						if (!ibutton) {
							texto = texto + "<tr>";
							texto = texto + "<td><b>IButton</b></td>";

							texto = texto + "<td><b><button class='btn btn-danger btn-circle'  type='button' title='"
									+ linea + "'><i class='fa fa-times'></i> </button></b>"
											+ "<input type='hidden' value='0' name='ibutton'></td>";
							texto = texto + "<td>" + fstr + "</td>";
							texto = texto + "</tr>";
							resultP = resultP + texto;
							texto = "";
						}
					}
					if (valtextlectorbarra == 11 && !lectorbarra) {

						texto = texto + "<tr>";
						texto = texto + "<td><b>Lector barra</b></td>";

						texto = texto + "<td><b><button class='btn btn-danger btn-circle'  type='button' title='"
								+ linea + "'><i class='fa fa-times'></i> </button></b></td>";
						texto = texto + "<td>" + fstr + "</td>";
						texto = texto + "</tr>";
						resultP = resultP + texto;
						texto = "";
						
					}
					if (valtextsnspuerta == 17 && (!snspuertaon || !snspuertaoff)) {

						texto = texto + "<tr>";
						texto = texto + "<td><b>Sensor Puertas</b></td>";
						texto = texto + "<td><b><button class='btn btn-danger btn-circle'  type='button' title='"
								+ linea + "'><i class='fa fa-times'></i> </button></b></td>";
						texto = texto + "<td>" + fstr + "</td>";
						texto = texto + "</tr>";
						resultP = resultP + texto;
						texto = "";

					}
					if (valtextcorte == 12 && (!cortemotoroff || !cortemotoron)) {

						texto = texto + "<tr>";
						texto = texto + "<td><b>Corte corriente</b></td>";
						texto = texto + "<td><b><button class='btn btn-danger btn-circle'  type='button' title='"
								+ linea + "'><i class='fa fa-times'></i> </button></b></td>";
						texto = texto + "<td>" + fstr + "</td>";
						texto = texto + "</tr>";
						resultP = resultP + texto;
						texto = "";

					}
					if (valtextsnrtemp == 10 && !snstemperatura) {

						texto = texto + "<tr>";
						texto = texto + "<td><b>Sensor temperatura</b></td>";
						texto = texto + "<td><b><button class='btn btn-danger btn-circle'  type='button' title='"
								+ linea + "'><i class='fa fa-times'></i> </button></b></td>";
						texto = texto + "<td>" + fstr + "</td>";
						texto = texto + "</tr>";
						resultP = resultP + texto;
						texto = "";

					}
					if (valtextbtnpanico == 13 && !btnpanico) {

						texto = texto + "<tr>";
						texto = texto + "<td><b>Boton panico</b></td>";
						texto = texto + "<td><b><button class='btn btn-danger btn-circle'  type='button' title='"
								+ linea + "'><i class='fa fa-times'></i> </button></b></td>";
						texto = texto + "<td>" + fstr + "</td>";
						texto = texto + "</tr>";
						resultP = resultP + texto;
						texto = "";

					}
				
					result = tabla+result +"<tr><td colspan='3'><hr/></td></tr>"+ resultP+"</table></div>";
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result = "Error";	
			}
			try {
				b.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result = "Error";
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "No hay eventos";
		}
		
		if (validar > 6) {
			
			result = result + "<div class='col-md-6 col-md-offset-3' id='btnContinuar'><button class='btn btn-lg btn-block btn-primary m-t-n-xs' type='button' onclick='btn_continuar()'><strong> Continuar</strong></button></div>";
		}

		return result;
	}
}
