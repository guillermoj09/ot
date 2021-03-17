package cl.samtech.ot.service;

import java.sql.Timestamp;
import java.text.Normalizer;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;


import org.apache.log4j.Logger;

import cl.samtech.ot.UsuarioLogin;

import cl.samtech.ot.form.CrearTareaForm;
import cl.samtech.ot.form.DeviceForm;
import cl.samtech.ot.form.ValidarForm;

import model.Agenda;
import model.Compania;
import model.Comuna;
import model.Device;
import model.Device_Tipogp;
import model.Foto;
import model.Instalacion;
import model.Instaladores_Device;
import model.Ot;
import model.PasoFaena;
import model.Region;
import model.SamFicha;


import model.Sam_OT;
import model.TblInstaladore;
import model.TblValidacione;
import model.TipoVehiculo;


public class InstalacionService {
	private static EntityManager em;
	private static EntityManager em1;
	private static EntityManager em2;
	private static EntityManager em3;
	private static EntityManager em4;
	private static EntityManager em5;
	private static EntityManager ema;
	private static EntityManager em6;
	private static EntityManager em7;
	private static EntityManager em8;
	private static EntityManager em9;
	


	final static Logger logger = Logger.getLogger(InstalacionService.class);
	
	
	public static List<Region> findAllRegiones(){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("otsamtechDB");
		em3 = emf.createEntityManager();
		TypedQuery<Region> allregiones = em3.createNamedQuery("Region.findAll", Region.class);
		List<Region> regiones = allregiones.getResultList();
		em3.clear();
		em3.close();
		return regiones;
	}
	public static List<Comuna> findComunas(Integer idRegion){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("otsamtechDB");
		em7 = emf.createEntityManager();
		Query query = em7.createQuery("select r from Comuna r where r.region.id = :idregion");
		query.setParameter("idregion", idRegion);
		query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");

		List<Comuna> ciudades = query.getResultList();
		return ciudades;
	}
	
	
	public static TblInstaladore findInstalador(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gpsf");
		em8 = emf.createEntityManager();

		TblInstaladore instalador = em8.find(TblInstaladore.class, id);

		return instalador;

	}
	public static long countInstalacion(Long ot){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("otsamtechDB");
		em9 = emf.createEntityManager();
		Query query = em9.createQuery("SELECT COUNT(i) From Instalacion i where i.ot.id= :ot and i.estado = 2");	
		query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
		query.setParameter("ot", ot);
		long countryCount = (Long)query.getSingleResult();
		return countryCount;
	}
	
	public static Long crearInstalacion(String id_device, String ot_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("otsamtechDB");
		em = emf.createEntityManager();
		Long id = null;
		
		Instalacion instalacion = new Instalacion();
		Ot ot = em.find(Ot.class, Long.parseLong(ot_id));
		ot.setId(Long.parseLong(ot_id));
		instalacion.setOt(ot);
		instalacion.setIdDevice(id_device);
		// estado pendiente
		instalacion.setEstado(1);
		em.getTransaction().begin();
		em.persist(instalacion);
		em.getTransaction().commit();
		id = instalacion.getId();
		em.close();
		
		return id;
	}

	public static Long existeInstalacion(String id_device, Long idI) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("otsamtechDB");
		em = emf.createEntityManager();
		Query query = em.createQuery("select t.id from Instalacion t where t.idDevice = :id_device and t.ot.id = :id");
		query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
		query.setParameter("id_device", id_device);
		query.setParameter("id", idI);
		long id = 0;
		try {
			Object p = query.getSingleResult();
			if (p != null) {
				id = Long.parseLong(p.toString());
			}
		} catch (Exception e) {
			id = 0;	
		}
		em.close();
		return id;

	}

	public static boolean saveInstalacion(DeviceForm deviceForm, UsuarioLogin usuario,String [] ListPerifericos) {

		Boolean grabado = true;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("otsamtechDB");
		EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("gpsf");
		EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("samtech");

		// EntityManagerFactory emf2 =
		// Persistence.createEntityManagerFactory("otsamtechdb");
		ema = emf.createEntityManager();
		em1 = emf1.createEntityManager();
		em2 = emf2.createEntityManager();
		em4 = emf1.createEntityManager();
		em8 = emf1.createEntityManager();
		// em2 = emf2.createEntityManager();
		String cadenaNormalize = Normalizer.normalize(deviceForm.getObservacion(), Normalizer.Form.NFD);   
		String obsSinAcentos = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");
		deviceForm.setObservacion(obsSinAcentos);
		Agenda agenda = TareasService.findTarea(deviceForm.getOt_id());

		boolean verificarClienteStock = ClienteService.verificarClienteAsignado("stock", deviceForm.getId_device());

		if (verificarClienteStock == true) {
			ClienteService.limpiarAsignacionCliente(deviceForm.getId_device(), usuario);
		}

		Integer cod_ane = Integer.parseInt(agenda.getFolioAnexo());
		Query querySamUsu = em2.createQuery("SELECT t.usu_cod_CV from SamUsuario t where t.usuLogin = :usuario");
		querySamUsu.setParameter("usuario", usuario.getUsername());
		String rutInstalador = "";
		List<String> usu_rut = querySamUsu.getResultList();
		if (usu_rut != null && !usu_rut.isEmpty()) {
			rutInstalador = usu_rut.get(0);
		}
		SamFicha empresa = em2.find(SamFicha.class, Integer.parseInt(agenda.getEmpresa()));
		PasoFaena pfae = ClienteService.IdentificarFaena(deviceForm.getCliente_login());
		Device device = em1.find(Device.class, deviceForm.getId_device());
		if (empresa.getFichLoginCliente() != "0" || empresa.getFichLoginCliente() != null) {
			try {
				TblInstaladore instalador = em8.find(TblInstaladore.class, rutInstalador);
				// device.setIdDevice(deviceForm.getId_device());
				device.setIdTipoVehiculo(deviceForm.getIdTipoVehiculo());
				device.setPatente(deviceForm.getPatente());
				device.setVin(deviceForm.getVin());
				device.setAnio_vehiculo(deviceForm.getAnio_vehiculo());
				device.setVolTolva(device.getVolTolva());
				device.setKilometraje(deviceForm.getKilometraje());
				device.setTipoGps(deviceForm.getTipo_gps());
				device.setMarcaCamion(deviceForm.getMarcaCamion());
				device.setColor(deviceForm.getColor_vehiculo());
				device.setModelo(deviceForm.getModelo());
				device.setObservaciones(obsSinAcentos);
				device.setKopilot(deviceForm.getKopilot());
				device.setImei(deviceForm.getImei().toString());
				device.setIdIbutto(deviceForm.getId_ibutton());
				device.setModulo(deviceForm.getTxtmodulo());
				device.setMvoz(deviceForm.getModulovoz());
				device.setCan(deviceForm.getTipocan());
				device.setTipocan(deviceForm.getTxtcan());
				device.setFwcan(deviceForm.getFwcan());
				device.setCandadoElect(deviceForm.getCandadoElect());
				device.setPuertas(deviceForm.getPuertas());
				device.setIdLbarra(deviceForm.getIdLbarra());	
				device.setIbutto(deviceForm.getTxtibutton());
				device.setColor(deviceForm.getColor_vehiculo());
				device.setFaena(pfae.getId().getFaena());
				device.setUsuarioCamion(deviceForm.getCliente_login());
				device.setPagador(empresa.getFichAlias());
				device.setMobileye(deviceForm.getTxtmeye());
				device.setKopilot(deviceForm.getKopilot());
				device.setBpanico(deviceForm.getBpanico());
				device.setStemp(deviceForm.getStemp());
				device.setIdCds(deviceForm.getId_cds());
				device.setEstado("2");
				device.setHorometro(deviceForm.getHorometro());
				device.setCjornada(deviceForm.getCjornada());
				device.setWifi(deviceForm.getWifi());	
				device.setLbarra(deviceForm.getTxtlbarra());
				device.setCorteComb(deviceForm.getTxtccto());
				device.setBuzzer(deviceForm.getTxtbuzzer());
				device.setInstalador((new StringBuilder(String.valueOf(instalador.getNombre()))).append(" ").append(instalador.getApellidos()).toString());
				device.setAnx(cod_ane.intValue());
				em1.getTransaction().begin();
				em1.persist(device);
				em1.getTransaction().commit();
			} catch (Exception e) {
				grabado = false;
				
			}
			
			//boolean varAddPerifericos = 
			
			
			Instalacion instalacion = ema.find(Instalacion.class, deviceForm.getId_instalacion());
			Ot ot = ema.find(Ot.class, deviceForm.getOt_id());
			try {
				Timestamp fechaInicio = new Timestamp(System.currentTimeMillis());
				ema.getTransaction().begin();
				instalacion.setPatente(deviceForm.getPatente());
				instalacion.setIdDevice(deviceForm.getId_device());
				instalacion.setVinVehiculo(deviceForm.getVin());
				instalacion.setCliente(deviceForm.getCliente_login());
				instalacion.setAnioVehiculo(Integer.toString(deviceForm.getAnio_vehiculo()));
				instalacion.setVoltajeVehiculo(deviceForm.getVoltolva());
				instalacion.setCompaniaSim(deviceForm.getCompania_sim());
				instalacion.setEstadoGps(deviceForm.getEstado_gps());
				instalacion.setOdometro(deviceForm.getOdometro());
				instalacion.setTipoGps(deviceForm.getTipo_gps());
				instalacion.setMarcaVehiculo(deviceForm.getMarcaCamion());
				instalacion.setModeloVehiculo(deviceForm.getModelo());
				instalacion.setColorVehiculo(deviceForm.getColor_vehiculo());
				instalacion.setNumInternoVeh(deviceForm.getNumero_interno());
				instalacion.setTipoConexVpn(deviceForm.getCon_VPN().toString());
				instalacion.setTipoConexProt(deviceForm.getTipo_conx_protocolo().toString());
				instalacion.setImei(deviceForm.getImei().toString());
				instalacion.setNumAbonado(deviceForm.getNum_abonado());
				instalacion.setFaena(pfae.getId().getFaena());
				instalacion.setCiudad(deviceForm.getComuna());
				instalacion.setFechainicio(fechaInicio);
				instalacion.setEstado(2);
				instalacion.setAnexo(cod_ane.intValue());
				instalacion.setRegion(deviceForm.getRegion());
				instalacion.setObservacion(obsSinAcentos);
				ot.getId();
				instalacion.setOt(ot);
				ema.persist(instalacion);
				ema.getTransaction().commit();
				grabado = true;
				ema.close();
			} catch (Exception e) {
				grabado = false;
			}
			if(ListPerifericos != null) {
				ValidacionLogService.listadoPerifericos(ListPerifericos, device, instalacion);
			}
			
			//verificar si esta asignado cliente.

			boolean vgpscliente = ClienteService.findClienteasignado(deviceForm.getId_device(),deviceForm.getCliente_login());
			
			
			if(!vgpscliente) {
				Integer id_usu = ClienteService.IdSamUsuario(usuario.getUsername());

				Query query2 = em2.createQuery("select u.faCodFicha from SamFichaAnexo u where u.faCodAnexo=:cod_anexo");
				query2.setParameter("cod_anexo", cod_ane);
				Integer folio = (Integer) query2.getSingleResult();

				Instaladores_Device instaladoresDevice = findInstaladores_Device(deviceForm.getId_device());

				Timestamp fecha = new Timestamp(System.currentTimeMillis());

				if (instaladoresDevice == null) {
					Integer ott_num = ClienteService.IdOtNum();
					Instaladores_Device insta_device = createInsladores_device(device, instalacion, ott_num, rutInstalador,
							cod_ane, folio, fecha);
					if (insta_device.getIdInstalacion() > 0) {
						createSamOT(ott_num, insta_device, instalacion, empresa, deviceForm, device.getNumSerie(), id_usu,
								cod_ane, folio, fecha);
						ValidacionService.crearTblValidadacion(insta_device, fecha, ott_num, deviceForm.getObservacion(), usuario.getUsername());
						ClienteService.agregarHistoricoPass(device, usuario,deviceForm.getObservacion());
					}
				} else {
					Integer ott_num = ClienteService.IdOtNum();
					Instaladores_Device uInstaldores = updateInsladores_device(device, instaladoresDevice, instalacion,
							ott_num, rutInstalador, cod_ane, folio, fecha);
					if (uInstaldores != null) {
						createSamOT(ott_num, uInstaldores, instalacion, empresa, deviceForm, device.getNumSerie(), id_usu,
								cod_ane, folio, fecha);
						ValidacionService.crearTblValidadacion(uInstaldores, fecha, ott_num, deviceForm.getObservacion(), usuario.getUsername());
						ClienteService.agregarHistoricoPass(device, usuario,deviceForm.getObservacion());
						
					} 
				}

				Boolean asignacionCliente = ClienteService.agregarAsignacionCliente(deviceForm.getCliente_login(),
						instalacion.getIdDevice());
				if (!asignacionCliente) {
					grabado = false;
					
					boolean asigfaena = ClienteService.asignar_faena_vehiculos(deviceForm.getId_device(),
							deviceForm.getCliente_login());
					if (!asigfaena) {
						grabado = false;
					}
					// ClienteService.agregarFaena(instalacion.getIdDevice(),deviceForm.getCliente_login(),instalacion.getPatente(),
					// usuario);
					ClienteService.Actualiza_odo(deviceForm.getId_device(), deviceForm.getPatente(),
							deviceForm.getKilometraje(), deviceForm.getKilometraje(), usuario);
				}
				
			}else {

				Integer id_usu = ClienteService.IdSamUsuario(usuario.getUsername());

				Query query2 = em2.createQuery("select u.faCodFicha from SamFichaAnexo u where u.faCodAnexo=:cod_anexo");
				query2.setParameter("cod_anexo", cod_ane);
				Integer folio = (Integer) query2.getSingleResult();
				Instaladores_Device ins_device = findInstaladores_Device_activo(deviceForm.getId_device());
				Timestamp fecha = new Timestamp(System.currentTimeMillis());
				updateInsladores_device(device, ins_device, instalacion,
						Integer.parseInt(ins_device.getOt()), rutInstalador, cod_ane, folio, fecha);
				boolean updatesamOT = updateSamOT(ins_device, instalacion, empresa, deviceForm, device.getNumSerie(), id_usu, cod_ane, folio, fecha);
				if(updatesamOT) {
					ValidacionService.updateTblValidadacion(ins_device, fecha,deviceForm.getObservacion(),usuario.getUsername());
					ClienteService.agregarHistoricoPass(device, usuario,deviceForm.getObservacion());
				}
			}
	
		}
		return grabado;
	}
	
	public static Instaladores_Device findInstaladores_Device_activo(String idDevice) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gpsf");
		em1 = emf.createEntityManager();
		Query query = em1.createQuery("SELECT i FROM Instaladores_Device i where i.idGps = :id_device "
				+ "AND i.tipoInstalacion = '1' order by i.fecha desc");
		query.setParameter("id_device", idDevice);
		Instaladores_Device insta_device = (Instaladores_Device) query.getResultList().get(0);
		return insta_device;
	}
	
	public static Boolean updateSamOT(Instaladores_Device instaDevice, Instalacion instalacion,
			SamFicha empresa, DeviceForm deviceForm, String num_serie, Integer id_usu, Integer cod_ane, Integer folio,
			Timestamp fecha) {
		boolean grabado = true;
		EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("samtech");
		em2 = emf1.createEntityManager();
		Query query = em2.createQuery("SELECT s FROM Sam_OT s where s.ottNum = :ott_num");
		query.setParameter("ott_num", Integer.parseInt(instaDevice.getOt()));
		try {
			Sam_OT sam_ot = (Sam_OT) query.getResultList().get(0);
			sam_ot.setOttNombre(empresa.getFichRazonSocial());
			sam_ot.setOttUbicacion(instalacion.getCiudad());
			sam_ot.setOttPatente(instalacion.getPatente());
			sam_ot.setOttNumSerie(num_serie);
			sam_ot.setOttMarcaModelo(instalacion.getMarcaVehiculo());
			sam_ot.setOttIdgps(instalacion.getIdDevice());
			sam_ot.setOttColor(instalacion.getColorVehiculo());
			sam_ot.setOttAnio(instalacion.getAnioVehiculo());
			sam_ot.setOttTecnicoId(id_usu);
			sam_ot.setOttAnexo(cod_ane);
			sam_ot.setOttFolio(folio);
			sam_ot.setOttEstado(2);
			sam_ot.setOttFecha(fecha);
			sam_ot.setOttFechaCierra(fecha);
			sam_ot.setOtt_VIN(deviceForm.getVin());
			sam_ot.setOttIdInst((int) instaDevice.getIdInstalacion());	
			sam_ot.setOttImei(deviceForm.getImei().toString());
			sam_ot.setOttTipoAsistencia(1);
			sam_ot.setOttVoltaje(Double.toString(instalacion.getVoltajeVehiculo()));
			em2.getTransaction().begin();
			em2.persist(sam_ot);
			em2.getTransaction().commit();
			grabado = true;
			em2.close();
		} catch (Exception e) {
			//System.out.println(e);
			grabado = false;
		}
		return grabado;
	}
	
	
	
	public static Boolean createSamOT(Integer ott_num, Instaladores_Device instaDevice, Instalacion instalacion,
			SamFicha empresa, DeviceForm deviceForm, String num_serie, Integer id_usu, Integer cod_ane, Integer folio,
			Timestamp fecha) {
		boolean grabado = true;
		EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("samtech");
		em2 = emf1.createEntityManager();
		try {
			Sam_OT sam_ot = new Sam_OT();
			sam_ot.setOttNum(ott_num);
			sam_ot.setOttNombre(empresa.getFichRazonSocial());
			sam_ot.setOttUbicacion(instalacion.getCiudad());
			sam_ot.setOttPatente(deviceForm.getPatente());
			sam_ot.setOttNumSerie(num_serie);
			sam_ot.setOttMarcaModelo(instalacion.getMarcaVehiculo());
			sam_ot.setOttIdgps(instalacion.getIdDevice());
			sam_ot.setOttColor(instalacion.getColorVehiculo());
			sam_ot.setOttAnio(instalacion.getAnioVehiculo());
			sam_ot.setOttTecnicoId(id_usu);
			sam_ot.setOttAnexo(cod_ane);
			sam_ot.setOttFolio(folio);
			sam_ot.setOttEstado(2);
			sam_ot.setOttFecha(fecha);
			sam_ot.setOttFechaCierra(fecha);
			sam_ot.setOtt_VIN(deviceForm.getVin());
			sam_ot.setOttIdInst((int) instaDevice.getIdInstalacion());
			sam_ot.setOttImei(deviceForm.getImei().toString());
			sam_ot.setOttTipoAsistencia(1);
			sam_ot.setOttVoltaje(Double.toString(instalacion.getVoltajeVehiculo()));

			em2.getTransaction().begin();
			em2.persist(sam_ot);
			em2.getTransaction().commit();
			grabado = true;
			em2.close();
		} catch (Exception e) {
			grabado = false;
		}
		return grabado;
	}

	public static List<String> listadoIdCamSom() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gpsf");
		em4 = emf.createEntityManager();
		Query query = em4.createNativeQuery(
				"select id_device from device with (NOLOCK) where id_device like '%CDS%' order by id_device");
		List list = query.getResultList();
		return list;
	}

	

	public static Instaladores_Device findInstaladores_Device(String idDevice) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gpsf");
		em1 = emf.createEntityManager();
		String tipoInstalacion = "0";
		boolean validador = false;
		Query query = em1.createQuery(
				"SELECT i FROM Instaladores_Device i where i.idGps = :id_device AND i.tipoInstalacion = '0' order by i.fecha desc");
		query.setParameter("id_device", idDevice);
		query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
		Instaladores_Device resultList = null;
		try {
			resultList = (Instaladores_Device) query.getSingleResult();
		} catch (NoResultException e) {
			e.getMessage();
		}

		return resultList;
	}

	public static Instaladores_Device createInsladores_device(Device device, Instalacion instalacion, Integer ott_num,
			String rutInstalador, Integer cod_ane, Integer folio, Timestamp fecha) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gpsf");
		em6 = emf.createEntityManager();
		Instaladores_Device instaladoresDevice = new Instaladores_Device();
		boolean grabado = true;
		try {
			// update basegpsf.dbo.instaladores_device set vehiculo=@tipo_veh,
			// marca=@marca,
			// modelo=@modelo, fecha=GETDATE(),validador=@valida,
			// tipo_falla=@tip_fall,desc_falla=@desc_fall,tipo_instalacion=@tip_asis,bpanico=@b_panico,observacion=@obs,otro_acc=@otro_acc,
			// patente=@patente,
			// instalador=@id_inst, VIN=@vin, mod_voz=@mvoz
			instaladoresDevice.setIdGps(device.getIdDevice());
			instaladoresDevice.setVehiculo(instalacion.getTipoVehiculo());
			instaladoresDevice.setMarca(instalacion.getMarcaVehiculo());
			instaladoresDevice.setModelo(instalacion.getModeloVehiculo());
			instaladoresDevice.setFecha(fecha);
			instaladoresDevice.setValidador("");
			instaladoresDevice.setTipoInstalacion("1");
			instaladoresDevice.setBpanico(0);
			instaladoresDevice.setOt(String.valueOf(ott_num));
			instaladoresDevice.setObservacion(" ");
			instaladoresDevice.setPatente(device.getPatente());
			instaladoresDevice.setInstalador(rutInstalador);
			instaladoresDevice.setVin(instalacion.getVinVehiculo());
			instaladoresDevice.setCodAnexo(cod_ane);
			instaladoresDevice.setCodFicha(folio);
			instaladoresDevice.setModVoz("");
			instaladoresDevice.setImei(device.getImei());
			instaladoresDevice.setNumSerie(device.getNumSerie());
			em6.getTransaction().begin();
			em6.persist(instaladoresDevice);
			em6.getTransaction().commit();
			em6.close();
		} catch (Exception e) {
			grabado = false;

		}

		return instaladoresDevice;
	}

	public static Instaladores_Device updateInsladores_device(Device device, Instaladores_Device insta,
			Instalacion instalacion, Integer ott_num, String rutInstalador, Integer cod_ane, Integer folio,
			Timestamp fecha) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gpsf");
		em6 = emf.createEntityManager();
		boolean grabado = true;
		Instaladores_Device instaladoresDevice = em6.find(Instaladores_Device.class, insta.getIdInstalacion());
		try {
			// update basegpsf.dbo.instaladores_device set vehiculo=@tipo_veh,
			// marca=@marca,
			// modelo=@modelo, fecha=GETDATE(),validador=@valida,
			// tipo_falla=@tip_fall,desc_falla=@desc_fall,tipo_instalacion=@tip_asis,bpanico=@b_panico,observacion=@obs,otro_acc=@otro_acc,
			// patente=@patente,
			// instalador=@id_inst, VIN=@vin, mod_voz=@mvoz
			instaladoresDevice.setIdGps(device.getIdDevice());
			instaladoresDevice.setVehiculo(instalacion.getTipoVehiculo());
			instaladoresDevice.setMarca(instalacion.getMarcaVehiculo());
			instaladoresDevice.setModelo(instalacion.getModeloVehiculo());
			instaladoresDevice.setFecha(fecha);
			instaladoresDevice.setValidador("");
			instaladoresDevice.setTipoInstalacion("1");
			instaladoresDevice.setBpanico(0);
			instaladoresDevice.setOt(String.valueOf(ott_num));
			instaladoresDevice.setObservacion(" ");
			instaladoresDevice.setPatente(instalacion.getPatente());
			instaladoresDevice.setInstalador(rutInstalador);
			instaladoresDevice.setVin(instalacion.getVinVehiculo());
			instaladoresDevice.setCodAnexo(cod_ane);
			instaladoresDevice.setCodFicha(folio);
			instaladoresDevice.setModVoz("");
			instaladoresDevice.setImei(device.getImei());
			instaladoresDevice.setNumSerie(device.getNumSerie());
			em6.getTransaction().begin();
			em6.persist(instaladoresDevice);
			em6.getTransaction().commit();
			em6.close();
		} catch (Exception e) {
			grabado = false;

		}
		return instaladoresDevice;
	}

	public static Instalacion findInstalacion(Long id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("otsamtechDB");

		em1 = emf.createEntityManager();

		Instalacion d = em1.find(Instalacion.class, id);
		em1.refresh(d);

		return d;
	}

	public static List<Device_Tipogp> allTipogps() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gpsf");
		em = emf.createEntityManager();
		TypedQuery<Device_Tipogp> allpersonas = em.createNamedQuery("Device_Tipogp.findAll", Device_Tipogp.class);
		List<Device_Tipogp> ausentismos = allpersonas.getResultList();
		return ausentismos;
	}

	public static List<TipoVehiculo> allTipovehiculo() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gpsf");
		em = emf.createEntityManager();
		TypedQuery<TipoVehiculo> allpersonas = em.createNamedQuery("TipoVehiculo.findAll", TipoVehiculo.class);
		List<TipoVehiculo> ausentismos = allpersonas.getResultList();

		return ausentismos;

	}

	public static List<Compania> allCompania() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("otsamtechDB");
		em2 = emf.createEntityManager();
		TypedQuery<Compania> allcompanias = em2.createNamedQuery("Compania.findAll", Compania.class);
		List<Compania> companias = allcompanias.getResultList();

		return companias;

	}
	public static Boolean saveTablaValidaciones(ValidarForm validarForm) {
		Boolean grabado = true;
		ValidacionLogService.createTablaValidacion(validarForm.getIdGps(), validarForm.getValidacionoculta(),
				Long.parseLong(validarForm.getOt_id()), "OK");
		return grabado;
	}

	

	public static Device findGPS(String id) {

		Boolean grabado = true;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gpsf");

		em1 = emf.createEntityManager();

		Device d = em1.find(Device.class, id);
		return d;
	}

	public static Boolean agregarFoto(CrearTareaForm crearTareaForm, String urlFoto) {

		Boolean grabado = true;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("otsamtechDB");

		em1 = emf.createEntityManager();
		logger.error("em1 ");
		// agregar por device
		Instalacion instalacion = em1.find(Instalacion.class, Long.parseLong(crearTareaForm.getIdInstalacion()));

		instalacion.setId(Long.parseLong(crearTareaForm.getIdInstalacion()));

		logger.error("tarea ");
		Foto foto = new Foto();

		foto.setUrl(urlFoto);
		foto.setTipo(crearTareaForm.getTipoFoto());
		foto.setInstalacion(instalacion);
		logger.error("addFoto ");

		try {
			em1.getTransaction().begin();
			logger.error("getTransaction ");
			em1.persist(foto);
			logger.error("persist ");
			em1.getTransaction().commit();
			logger.error("commit ");
		} catch (Exception e) {
			logger.error("error en agregarFoto= " + e.getMessage());
			grabado = false;
		}

		return grabado;
	}

	public static Boolean eliminarFoto(String id_insta, String tipo, String nombre) {

		Boolean grabado = true;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("otsamtechDB");

		em1 = emf.createEntityManager();
		em2 = emf.createEntityManager();
		Instalacion insta = em1.find(Instalacion.class, Long.parseLong(id_insta));

		Query query = em2.createQuery(
				"select f from Foto f where f.url = :nombre and f.instalacion.id = :id_insta and f.tipo= :tipo");
		query.setParameter("nombre", nombre);
		query.setParameter("id_insta", Long.parseLong(id_insta));
		query.setParameter("tipo", tipo);

		List<Foto> fotos = query.getResultList();

		Foto foto = fotos.get(0);
		// tarea.removeFoto(fotos.get(0));
		em2.getTransaction().begin();
		em2.remove(foto);
		em2.getTransaction().commit();

		return grabado;
	}

	public static Boolean existeFoto(Long  id_insta,String tipo) {

		Boolean existe = false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("otsamtechDB");

		em = emf.createEntityManager();

		Query query = em.createQuery("select f from Foto f where f.instalacion.id = :id_insta and f.tipo = :tipo" );
		query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
		query.setParameter("id_insta", id_insta);
		query.setParameter("tipo", tipo);
		
		List<Foto> fotos = query.getResultList();
		 
		if(fotos.size()>0){ 
			existe=true;
		 }
		 em.clear();
		 em.close();
		

		return existe;
	}

	public static Integer numInstaladas(String folio,String anexo) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("samtech");
		em5 = emf.createEntityManager();
		
		boolean validar= false;
		StoredProcedureQuery query = em5.createStoredProcedureQuery("SAM_P_lista_instalados_todos_pass_consolidado");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(5, Integer.class, ParameterMode.IN);
		
		query.setParameter(1, folio);
		query.setParameter(2, anexo);
		query.setParameter(3,"rlagos");
		query.setParameter(4, "lagos1010");
		query.setParameter(5, 2);
		query.execute();
		List<Object[]> rows = query.getResultList();
		int num = 0;	
		for(Object[] row : rows) {
			num = (Integer) row[3];
		}
		return num;
	}


	public static String NumSolicitadas(Long id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("samtech");
		em8 = emf.createEntityManager();
		Agenda agenda = TareasService.findTarea(id);
		Integer cod_ane = Integer.parseInt(agenda.getFolioAnexo());
		Query query = em8.createQuery("select t.fvValor from SamFichaValores t where t.fvCodAnexo = :cod_anexo  and t.fvValCodigo=28");
		query.setParameter("cod_anexo", cod_ane);
		query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
		String numSol;
		if(query.getResultList().size() > 0) {
			numSol = (String) query.getResultList().get(0);
		}else {
			numSol = "0";
		}
		
		return numSol;
		
	}
	
}
