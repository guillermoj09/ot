package cl.samtech.ot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.log4j.Logger;

import cl.samtech.ot.controller.UploadController;
import cl.samtech.ot.form.CrearTareaForm;
import cl.samtech.ot.form.DeviceForm;
import cl.samtech.ot.service.ClienteService;
import cl.samtech.ot.util.Crypto;
import model.Agenda;
import model.Cliente;
import model.Compania;
import model.Device;
import model.Device_Tipogp;
import model.Faenas;
import model.Foto;
import model.FotoFirma;
import model.Instalacion;
import model.Instaladores_Device;
import model.MM_Faena_Vehiculo;
import model.Ot;
import model.PasoFaena;
import model.PasoUsuario;
import model.ResumenIfo;
import model.SamFicha;
import model.SamFichaValores;
import model.SamFichap;
import model.SamUsuario;
import model.Sam_OT;
import model.TblInstaladore;
import model.TblValidacione;
import model.TipoVehiculo;
import model.Usuario;
import model.UsuariosTran;

public class TareasService {
	private static EntityManager em;
	private static EntityManager em1;
	private static EntityManager em2;
	private static EntityManager em3;
	private static EntityManager em4;
	private static EntityManager ema;
	private static EntityManager em5;
	private static EntityManager em6;
	private static EntityManager em8;
	private static EntityManager em9;
	private static EntityManager em11;

	final static Logger logger = Logger.getLogger(TareasService.class);

	public static TblInstaladore findInstalador(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gpsf");
		em8 = emf.createEntityManager();

		TblInstaladore instalador = em8.find(TblInstaladore.class, id);

		return instalador;

	}

	public static Long crearInstalacion(String id_device, String ot_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("otsamtechDB");
		em = emf.createEntityManager();
		Long id = null;
		try {
			em.getTransaction().begin();
			Instalacion instalacion = new Instalacion();
			Ot ot = new Ot();
			ot.setId(Long.parseLong(ot_id));
			instalacion.setIdDevice(id_device);
			// estado pendiente
			instalacion.setEstado(1);
			instalacion.setOt(ot);
			em.persist(instalacion);

			em.getTransaction().commit();
			id = instalacion.getId();
			em.close();

		} catch (Exception e) {
			//System.out.println(e);
		}

		return id;
	}

	public static Long existeInstalacion(String id_device,Long ot_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("otsamtechDB");
		em = emf.createEntityManager();
		Query query = em.createQuery("select t.id from Instalacion t where t.idDevice = :id_device and t.ot.id = :ot_id ");
		query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
		query.setParameter("id_device", id_device);
		query.setParameter("ot_id", ot_id);

		long id = 0;

		try {
			List p = query.getResultList();
			if (p != null && !p.isEmpty()) {
				id = Long.parseLong(p.get(0).toString());
			}
			return id;
		} catch (NoResultException e) {
			return id;
		}

	}

	public static Boolean FinalizarTarea(UsuarioLogin user, String fechaInicio, Long id, String observaciones,
			String url, String nombre) {
		Boolean grabado = true;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("otsamtechDB");
		EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("TrasladoDB");
		EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("gpsf");

		em = emf.createEntityManager();
		em1 = emf1.createEntityManager();

		Agenda agenda = em1.find(Agenda.class, id);

		//System.out.println(fechaInicio);
		/*
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date parsedDate = dateFormat.parse(fechaInicio);
			Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());

			//System.out.println(timestamp);
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		try {
			// agenda.setColor("green");
			// agenda.setEstado(1);

			// em1.getTransaction().begin();
			// em1.persist(agenda);
			// em1.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e);
			grabado = false;
		}
		// insercion de Firma
		FotoFirma ff = new FotoFirma();
		try {
			ff.setNombre(nombre);
			ff.setUrl(url);
			em.getTransaction().begin();
			em.persist(ff);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		//System.out.println(ff.getId());

		Ot ot = em.find(Ot.class, id);
		List<Instalacion> inst = ot.getInstalacions();

		for (Instalacion insta : inst) {

			insta.setEstado(3);
			try {
				em.getTransaction().begin();
				em.persist(insta);
				em.getTransaction().commit();
			} catch (Exception e) {
				//System.out.println(e);
				grabado = false;
			}

		}	
		ResumenIfo rIfo = new ResumenIfo();
		rIfo.setIdFirma(ff.getId());
		rIfo.setIdOt(ot.getId());
		rIfo.setObservacion(observaciones);
		try {
			em.getTransaction().begin();
			em.persist(rIfo);
			em.getTransaction().commit();
		} catch (Exception e) {
			//System.out.println(e);
			grabado = false;
		}

		return grabado;

	}

	public static String guardarInstalacion(DeviceForm deviceForm, UsuarioLogin usuario) {

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

		String mensaje = "";
		Agenda agenda = findTarea(deviceForm.getOt_id());

		boolean verificarClienteStock = ClienteService.verificarClienteAsignado("stock", deviceForm.getId_device());

		if (verificarClienteStock == true) {
			ClienteService.limpiarAsignacionCliente(deviceForm.getId_device(), usuario);
		}

		Integer cod_ane = Integer.parseInt(agenda.getFolioAnexo());
		Query querySamUsu = em2.createQuery("select t.usu_cod_CV from SamUsuario t where t.usuLogin = :usuario");
		querySamUsu.setParameter("usuario", usuario.getUsername());
		String rutInstalador = "";
		String usu_rut = (String) querySamUsu.getSingleResult();
		if (usu_rut != null) {
			rutInstalador = usu_rut;
		}
		SamFicha empresa = em2.find(SamFicha.class, Integer.parseInt(agenda.getEmpresa()));
		PasoFaena pfae = ClienteService.IdentificarFaena(deviceForm.getCliente_login());
		Device device = em1.find(Device.class, deviceForm.getId_device());
		if(empresa.getFichLoginCliente() != "0" || empresa.getFichLoginCliente() != null) {
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
				// device.setNum_interno(deviceForm.getNumero_interno());
				device.setImei(deviceForm.getImei().toString());
				device.setColor(deviceForm.getColor_vehiculo());
				device.setFaena(pfae.getId().getFaena());
				device.setUsuarioCamion(deviceForm.getCliente_login());
				device.setPagador(empresa.getFichAlias());
				device.setEstado("2");
				device.setInstalador(instalador.getNombre() + " " + instalador.getApellidos());
				device.setAnx(cod_ane);
				em1.getTransaction().begin();
				em1.persist(device);
				em1.getTransaction().commit();
				grabado = true;
				em1.close();
			} catch (Exception e) {
				//System.out.println(e);
				grabado = false;
				mensaje = "Datos del dispositivo mal ingresado";
			}

			Instalacion instalacion = ema.find(Instalacion.class, deviceForm.getId_instalacion());
			Ot ot = ema.find(Ot.class, deviceForm.getOt_id());
			try {
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
				instalacion.setCiudad(deviceForm.getCiudad());
				instalacion.setEstado(2);
				ot.getId();
				instalacion.setOt(ot);
				ema.persist(instalacion);
				ema.getTransaction().commit();
				grabado = true;
				ema.close();
			} catch (Exception e) {
				//System.out.println(e);
				grabado = false;
			}
			
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
						crearTblValidadacion(insta_device, fecha, ott_num);
						agregarHistoricoPass(device,usuario,"Ingresado por OT electronica");
					}
				} else {
					Integer ott_num = ClienteService.IdOtNum();
					Instaladores_Device uInstaldores = updateInsladores_device(device, instaladoresDevice, instalacion,
							ott_num, rutInstalador, cod_ane, folio, fecha);
					if (uInstaldores != null) {
						createSamOT(ott_num, uInstaldores, instalacion, empresa, deviceForm, device.getNumSerie(), id_usu,
								cod_ane, folio, fecha);
						crearTblValidadacion(uInstaldores, fecha, ott_num);	
						agregarHistoricoPass(device,usuario,"Ingresado por OT electronica");

					} 
				}

				Boolean asignacionCliente = ClienteService.agregarAsignacionCliente(deviceForm.getCliente_login(),
						instalacion.getIdDevice());
				if (!asignacionCliente) {
					grabado = false;
					mensaje = "Cliente no esta asociado con ficha,por favor contactar a soporte";
				} else {
					boolean asigfaena = ClienteService.asignar_faena_vehiculos(deviceForm.getId_device(),
							deviceForm.getCliente_login());
					if (!asigfaena) {
						mensaje = "No se asigno a faena acordada";
					}
					// ClienteService.agregarFaena(instalacion.getIdDevice(),deviceForm.getCliente_login(),instalacion.getPatente(),
					// usuario);
					ClienteService.Actualiza_odo(deviceForm.getId_device(), deviceForm.getPatente(),
							deviceForm.getKilometraje(), deviceForm.getKilometraje(), usuario);
				}		
			}else{
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
					updateTblValidadacion(ins_device, fecha);
				}
			}
		}
		return mensaje;
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
			sam_ot.setOttUbicacion(deviceForm.getCiudad());
			sam_ot.setOttPatente(deviceForm.getPatente());
			sam_ot.setOttNumSerie(num_serie);
			sam_ot.setOttMarcaModelo(deviceForm.getMarcaCamion());
			sam_ot.setOttIdgps(deviceForm.getId_device());
			sam_ot.setOttColor(deviceForm.getColor_vehiculo());
			sam_ot.setOttAnio(Integer.toString(deviceForm.getAnio_vehiculo()));
			sam_ot.setOttTecnicoId(id_usu);
			sam_ot.setOttAnexo(cod_ane);
			sam_ot.setOttFolio(folio);
			sam_ot.setOttEstado(2);
			sam_ot.setOttFecha(fecha);
			sam_ot.setOttFechaCierra(fecha);
			sam_ot.setOtt_VIN(deviceForm.getVin());
			sam_ot.setOttIdInst((int)instaDevice.getIdInstalacion());	
			sam_ot.setOttImei(deviceForm.getImei().toString());
			sam_ot.setOttTipoAsistencia(1);

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
	
	public static Boolean updateTblValidadacion(Instaladores_Device insDev, Timestamp fecha) {
		boolean validador = true;
		EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("gpsf");
		em1 = emf1.createEntityManager();
		try {
			Query query = em1.createQuery("SELECT i FROM TblValidacione i where i.id_Gps = :id_device and i.ot = :ot");
			query.setParameter("id_device", insDev.getIdGps());
			query.setParameter("ot", Integer.parseInt(insDev.getOt()));
			query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
			TblValidacione tblvalidades = (TblValidacione) query.getResultList().get(0);
			tblvalidades.setId_Instalador(insDev.getInstalador());
			tblvalidades.setId_Gps(insDev.getIdGps());
			tblvalidades.setId_Cdt("cdtsamtech");
			tblvalidades.setFechaBdd(fecha);
			tblvalidades.setFechaIngreso(fecha);
			tblvalidades.setTipoValidacion(1);
			tblvalidades.setOt(Integer.parseInt(insDev.getOt()));
			tblvalidades.setConfirmada(2);
			tblvalidades.setIdAsistencia(1);
			tblvalidades.setVigencia(false);
			tblvalidades.setObservacion("Ingresada por OT Electronica");
			em1.getTransaction().begin();
			em1.persist(tblvalidades);
			em1.getTransaction().commit();
			em1.close();
		} catch (Exception e) {
			validador = false;
		}
		return validador;
	}

	public static Boolean crearTblValidadacion(Instaladores_Device insDev, Timestamp fecha, Integer ot) {
		boolean validador = true;
		EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("gpsf");
		em1 = emf1.createEntityManager();
		try {
			TblValidacione tblvalidades = new TblValidacione();
			tblvalidades.setId_Instalador(insDev.getInstalador());
			tblvalidades.setId_Gps(insDev.getIdGps());
			tblvalidades.setId_Cdt("cdtsamtech");
			tblvalidades.setFechaBdd(fecha);
			tblvalidades.setFechaIngreso(fecha);
			tblvalidades.setTipoValidacion(1);
			tblvalidades.setOt(ot);
			tblvalidades.setConfirmada(2);
			tblvalidades.setIdAsistencia(1);
			tblvalidades.setVigencia(false);
			tblvalidades.setObservacion("Ingresada por OT Electronica");
			em1.getTransaction().begin();
			em1.persist(tblvalidades);
			em1.getTransaction().commit();
			em1.close();
		} catch (Exception e) {
			validador = false;
		}
		return validador;
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
			// update basegpsf.dbo.instaladores_device set vehiculo=@tipo_veh, marca=@marca,
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

		} catch (Exception e) {
			//System.out.println(e);
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
			// update basegpsf.dbo.instaladores_device set vehiculo=@tipo_veh, marca=@marca,
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
		} catch (Exception e) {
			//System.out.println(e);
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

	public static ArrayList<AgendaActiva> allTareas(UsuarioLogin user) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrasladoDB");
		EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("samtech");

		em = emf.createEntityManager();
		em1 = emf1.createEntityManager();
		List<Agenda> tareas = null;

		Query query = em.createQuery("select a from Agenda a where a.titulo = 'INSTALACION' and a.usuarioAsigna = :username and a.fechaComienzo >:fecha and  a.fechaComienzo <:fechaf order by a.fechaComienzo desc");
		query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
		query.setParameter("username", user.getUsername());

		Date fechahoy = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechahoy);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		fechahoy = calendar.getTime();
		java.sql.Timestamp timefec2 = new Timestamp(fechahoy.getTime());
		query.setParameter("fechaf", timefec2);
		calendar.add(Calendar.DAY_OF_YEAR, -10);
		fechahoy = calendar.getTime();

		java.sql.Timestamp timefec = new Timestamp(fechahoy.getTime());

		query.setParameter("fecha", timefec);

		tareas = query.getResultList();

		ArrayList<AgendaActiva> tareasactivas = new ArrayList<AgendaActiva>();

		for (Agenda t : tareas) {

			AgendaActiva aa = new AgendaActiva();

			aa.setId(t.getId());

			aa.setTitulo(t.getTitulo());
			aa.setFechaComienzo(t.getFechaComienzo());
			SamFicha empresa = em1.find(SamFicha.class, Integer.parseInt(t.getEmpresa()));
			long in = countInstalacion(t.getId());
			aa.setCountInst(in);
			aa.setEmpresa(empresa.getFichRazonSocial());
			aa.setLogin_cliente(empresa.getFichLoginCliente());
			aa.setContacto(t.getContacto());
			aa.setTelefono(t.getTelefono());
			aa.setPatentes(t.getPatentes());
			aa.setDireccion(t.getDireccion());
			aa.setDescripcion(t.getDescripcion());
			tareasactivas.add(aa);

		}

		return tareasactivas;
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
	
	public static Boolean existeTarea(Integer idfalla, Integer idubicacion) {

		Boolean existe = false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrasladoDB");
		em = emf.createEntityManager();
		Query query = em.createQuery(
				"select t from Tarea t where t.falla.idFalla = :idfalla and t.ubicacion.idUbicacion = :idubicacion");
		query.setParameter("idfalla", idfalla);
		query.setParameter("idubicacion", idubicacion);

		List resultList = query.getResultList();
		if (resultList != null && !resultList.isEmpty()) {
			existe = true;
		}

		return existe;
	}

	public static Long findnextTarea(Long idTarea, String usuario) {

		Long id = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrasladoDB");
		em = emf.createEntityManager();
		Query query = em.createQuery("select t from Tarea t where t.idTarea >:idtarea and t.usuario.username= :usuario");
		query.setParameter("idtarea", idTarea);
		query.setParameter("usuario", usuario);
		query.setMaxResults(1);

		List<Agenda> resultList = query.getResultList();
		if (resultList != null && !resultList.isEmpty()) {
			id = resultList.get(0).getId();
		}

		return id;
	}

	public static Boolean guardarTarea(CrearTareaForm crearTareaForm) {

		Boolean grabado = true;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrasladoDB");

		em1 = emf.createEntityManager();
		Agenda tarea = new Agenda();

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

		// tarea.setCorreo(crearTareaForm.getCorreo());
		tarea.setDescripcion(crearTareaForm.getDescripcion());
		// tarea.setEstado(findEstado(Long.valueOf(1)));

		tarea.setTelefono(crearTareaForm.getTelefono());

		try {
			em1.getTransaction().begin();
			em1.persist(tarea);
			em1.getTransaction().commit();

		} catch (Exception e) {
			//System.out.println(e);
			grabado = false;
		}

		return grabado;
	}

	public static Boolean modificarTarea(CrearTareaForm crearTareaForm, UsuarioLogin user) {

		Boolean grabado = true;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrasladoDB");

		em1 = emf.createEntityManager();

		Agenda tarea = em1.find(Agenda.class, crearTareaForm.getIdTarea().intValue());

		tarea.setDescripcion(crearTareaForm.getDescripcion());

		tarea.setTelefono(crearTareaForm.getTelefono());

		try {
			em1.getTransaction().begin();
			em1.persist(tarea);
			em1.getTransaction().commit();

		} catch (Exception e) {
			//System.out.println(e);
			grabado = false;
		}

		return grabado;
	}

	public static Boolean completarTarea(long id) {

		Boolean grabado = true;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrasladoDB");

		em1 = emf.createEntityManager();

		Agenda tarea = em1.find(Agenda.class, id);

		tarea.setColor("green");
		try {
			em1.getTransaction().begin();
			em1.persist(tarea);
			em1.getTransaction().commit();

		} catch (Exception e) {
			//System.out.println(e);
			grabado = false;
		}

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
			//System.out.println(e);
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

		//System.out.println(id_insta + " " + nombre + " " + tipo);
		Query query = em2.createQuery(
				"select f from Foto f where f.url = :nombre and f.instalacion.id = :id_insta and f.tipo= :tipo");
		query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
		query.setParameter("nombre", nombre);
		query.setParameter("id_insta", Long.parseLong(id_insta));
		query.setParameter("tipo", tipo);

		List<Foto> fotos = query.getResultList();

		Foto foto = fotos.get(0);
		//System.out.println(fotos.get(0));
		// tarea.removeFoto(fotos.get(0));
		em2.getTransaction().begin();
		em2.remove(foto);
		em2.getTransaction().commit();

		return grabado;
	}

	public static String existeFoto(Long id_insta) {

		String  existe = "0";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("otsamtechDB");

		em = emf.createEntityManager();

		Query query = em.createQuery("select f from Foto f where f.instalacion.id = :id_insta and f.tipo = 'Inicial' " );
		query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
		query.setParameter("id_insta", id_insta);

		List<Foto> fotoInicial = query.getResultList();
		
		Query query2 = em.createQuery("select f from Foto f where f.instalacion.id = :id_insta and f.tipo = 'Final' " );
		query2.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
		query2.setParameter("id_insta", id_insta);
		
		List<Foto> fotoFinal = query2.getResultList();
		
		  
		if(fotoInicial.size()>0 ){ 
			if(fotoFinal.size() > 0) {
				existe = "2";
			}else {
				existe= "1";
			}
		}else {
			if(fotoFinal.size() > 0) {
				existe = "3";
			}else {
				existe = "0";
			}
		}
			
		em.clear();
		em.close();
		

		return existe;
	}

	public static UsuarioLogin findUsuarioLogin(String idUsuario) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gpsf");
		em = emf.createEntityManager();

		Query query = em.createQuery("select u from UsuariosTran u where u.id.usuario = :usuario");
		query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");

		query.setParameter("usuario", idUsuario);
		List<UsuariosTran> usuarios = query.getResultList();

		UsuarioLogin usuariol = new UsuarioLogin();

		if (usuarios.isEmpty() != true) {

			usuariol.setPassword(usuarios.get(0).getPassword());
			usuariol.setUsername(idUsuario);
			usuariol.setNombre(usuarios.get(0).getNombres());
			usuariol.setApellidos(usuarios.get(0).getApellidos());
			usuariol.setRolDescripcion(usuarios.get(0).getTipo());

		}

		em.clear();
		em.close();

		return usuariol;
	}

	public static Usuario findUsuario(String idUsuario) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrasladoDB");
		em = emf.createEntityManager();

		Usuario usuario = em.find(Usuario.class, idUsuario);
		em.refresh(usuario);
		em.clear();
		em.close();

		return usuario;
	}
	public static Integer numInstaladas(UsuarioLogin user,String folio,String anexo) {
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
		query.setParameter(3, "rlagos");
		query.setParameter(4,"lagos1010");
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
		Agenda agenda = findTarea(id);
		//System.out.println("agenda folio " + agenda.getFolioAnexo());
		Integer cod_ane = Integer.parseInt(agenda.getFolioAnexo());
		Query query = em8.createQuery("select t.fvValor from SamFichaValores t where t.fvCodAnexo = :cod_anexo  and t.fvValCodigo=28");
		query.setParameter("cod_anexo", cod_ane);
		query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
		String numSol = (String) query.getResultList().get(0);
		return numSol;
		
	}
	public static Agenda findAgenda(Long id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrasladoDB");
		em3 = emf.createEntityManager();
		Agenda tarea = em3.find(Agenda.class, id);
		return tarea;
	}
	
	public static Agenda findTarea(Long id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrasladoDB");
		em3 = emf.createEntityManager();
		Agenda tarea = em3.find(Agenda.class, id);
		// em.refresh(tarea);
		Ot ot = findOT(id);
		if (ot == null) {
			crearOT(id);
		}
		return tarea;
	
	}

	public static Ot findOT(Long id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("otsamtechDB");
		em = emf.createEntityManager();
		Ot tarea = em.find(Ot.class, id);

		if(tarea == null) {
			System.out.println("null");
		}
		
		return tarea;
	}

	public static Ot crearOT(Long id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("otsamtechDB");
		em = emf.createEntityManager();

		Ot tarea = new Ot();

		tarea.setId(id);

		em.getTransaction().begin();
		em.persist(tarea);
		em.getTransaction().commit();

		return tarea;
	}
	public static Boolean agregarHistoricoPass(Device device, UsuarioLogin usuario, String obs)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gpsf");
        em11 = emf.createEntityManager();
        StoredProcedureQuery query = em11.createStoredProcedureQuery("PA_modificacion_historico_pass");
        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(2,  String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(3,  String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(4,  String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(5,  String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(6,  String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(7,  String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(8,  String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(9,  String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(10,  String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(11,  String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(12,  String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(13,  String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(14,  String.class, ParameterMode.IN);
        
        query.setParameter(1, device.getIdDevice());
        query.setParameter(2, device.getMarcaCamion());
        query.setParameter(3, device.getPatente());
        query.setParameter(4, "");
        query.setParameter(5, device.getUsuarioCamion());
        query.setParameter(6, device.getFaena());
        query.setParameter(7, device.getSn());
        query.setParameter(8, device.getPhone());
        query.setParameter(9, device.getInstalador());
        query.setParameter(10, usuario.getUsername());
        query.setParameter(11, obs);
        query.setParameter(12, "Trabajo Terminado");
        query.setParameter(13, usuario.getUsername());
        query.setParameter(14, usuario.getPassword());
        query.execute();
        em.close();
        return Boolean.valueOf(true);
    }
	
	public static String validarGPS(String gps) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		Date hoy = new Date();

		String archivo = "/opt/temp/logtrax/" +formatter.format(hoy)+ "/" + gps + "_" + formatter.format(hoy) + ".txt";
		boolean vcliente =  ClienteService.verificarGPSCliente(gps);
		String textoCliente = "";
		if(vcliente) {
			textoCliente = "<label>GPS asignado, si continua actualizara la informacion.</label>";
		}

		String texto = "<div class='table-responsive'><table class='table table-striped table-bordered table-hover dataTables-example'>";
		texto = texto
				+ "<thead><tr><th align='center'>Validacion </th>	<th align='center'>Estado</th>	<th align='center'>Hora</th></tr></thead>";

		//Calendar cal = Calendar.getInstance();
		//Calendar calNow = Calendar.getInstance();
		
		long cal = System.currentTimeMillis();
		long calNow = System.currentTimeMillis();

		//String archivo = "\\\\192.168.1.3\\log\\LOG_TRAX\\" + formatter.format(hoy) + "\\" + gps + "_"+ formatter.format(hoy) + ".txt";
		String result = "";
		String cadena;
		long milliseconds = 0;
		List<String> log = new ArrayList();
		FileReader f;
		int validar = 0;
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

			int senal = 0;
			int gprs = 0;

			Integer lat = 0;
			Integer lon = 0;
			String temp = "";
			long totalHoras = 0;
			boolean validaciones = false;
			BufferedReader b = new BufferedReader(f);
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
			
			try {
				String evento = "";
				String fstr = "";

				String linea = "";
				while ((cadena = b.readLine()) != null) {

					String[] fc = cadena.split(" -- ");
					if (fc.length > 1) {

						fstr = fc[2] + " " + fc[3];
						try {
							 Date d = sdf.parse(fstr);
							 milliseconds = d.getTime();
							//cal.setTime(formatter2.parse(fstr));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						totalHoras = ((calNow - milliseconds) / 1000 / 60 / 60);

						if (totalHoras < 2) {
							String[] parts = cadena.split(">");
							String part2 = parts[1];
							linea = part2;
							if (part2.substring(0, 3).equals("RPI") && !gpsok) {
								gpsok = true;
								texto = texto + "<tr>";
								texto = texto + "<td><b>GPS</b></td>";
								texto = texto + "<td><b><button class='btn btn-info btn-circle' type='button' title='"
										+ part2 + "'><i class='fa fa-check'></i> </button></b></td>";
								texto = texto + "<td>" + fstr + "</td>";
								texto = texto + "</tr>";
								result = result + texto;
								texto = "";
								validar++;
							} else if (part2.substring(0, 5).equals("RUS08") && !canok) {
								canok = true;
								texto = texto + "<tr>";
								texto = texto + "<td><b>CAN</b></td>";
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
								texto = texto + "<td><b><button class='btn btn-info btn-circle' type='button' title='"
										+ part2 + "'><i class='fa fa-check'></i> </button></b></td>";
								texto = texto + "<td>" + fstr + "</td>";
								texto = texto + "</tr>";
								result = result + texto;
								texto = "";
								validar++;
							}
							if (part2.contains("F19") && !cigok) {
								cigok = true;
								texto = texto + "<tr>";
								texto = texto + "<td><b>CORTE IGNICION</b></td>";
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
								texto = texto + "<td><b><button class='btn btn-info btn-circle' type='button' title='"
										+ part2 + "'><i class='fa fa-check'></i> </button></b></td>";
								texto = texto + "<td>" + fstr + "</td>";
								texto = texto + "</tr>";
								result = result + texto;
								texto = "";
								validar++;
							}

							if (part2.contains("F46") && !gprsok) {
								temp = part2.substring(41, 45);
								gprs = Integer.parseInt(part2.substring(41, 45));
								if (gprs == 0) {
									texto = texto + "<tr>";
									texto = texto + "<td><b>GPRS</b></td>";
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
								temp = part2.substring(16, 23);
								temp = part2.substring(24, 32);
								lat = Integer.parseInt(part2.substring(16, 23));
								lon = Integer.parseInt(part2.substring(24, 32));
								if (lat > 0 && lon > 0) {
									texto = texto + "<tr>";
									texto = texto + "<td><b>LATITUD Y LONGITUD</b></td>";
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
								temp = part2.substring(39, 41);
								senal = Integer.parseInt(part2.substring(39, 41));
								if (senal > 4) {
									texto = texto + "<tr>";
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
								senal = 0;

							}
						}
					}

				} // end while

				if (!gpsok && !canok) {
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
						texto = texto + "<td><b><button class='btn btn-danger btn-circle' type='button' title='" + linea
								+ "'><i class='fa fa-times'></i> </button></b></td>";
						texto = texto + "<td>" + fstr + "</td>";
						texto = texto + "</tr>";
						result = result + texto;
						texto = "";
					}

					result = result + "</table>";
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
			try {
				b.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "No hay eventos "+hoy;
		}

		if (validar > 6) {
			result = textoCliente+"<br><br><button class='btn btn-sm btn-primary m-t-n-xs' type='button' onClick='continuar()' ><strong> Continuar</strong></button>"
					+ result;

		}

		return result;
	}

}
